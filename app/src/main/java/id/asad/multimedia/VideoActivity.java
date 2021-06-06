package id.asad.multimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;

import id.asad.multimedia.databinding.ActivityVideoBinding;

public class VideoActivity extends AppCompatActivity {

    private ActivityVideoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVideoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.androiddeveloper);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(binding.videoView);
        binding.videoView.setMediaController(mediaController);

        binding.videoView.setVideoURI(uri);
        binding.videoView.requestFocus();
        binding.videoView.start();

        binding.videoView.setOnCompletionListener(mp -> {
            finish();
        });

    }
}