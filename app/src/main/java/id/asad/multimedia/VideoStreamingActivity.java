package id.asad.multimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;

import id.asad.multimedia.databinding.ActivityVideoStreamingBinding;

public class VideoStreamingActivity extends AppCompatActivity {

    private ActivityVideoStreamingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVideoStreamingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String url = "https://www.dropbox.com/s/2xziljidxo1jzva/Moana.mp4?dl=1";

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(binding.videoViewStreaming);
        binding.videoViewStreaming.setMediaController(mediaController);

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading, harap tunggu");
        progressDialog.show();

        binding.videoViewStreaming.setVideoURI(Uri.parse(url));
        binding.videoViewStreaming.requestFocus();
        binding.videoViewStreaming.setOnPreparedListener(mp -> {
            progressDialog.dismiss();
            mp.start();
        });
    }
}