package trinhmanhdiv.ListView.listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class AnimationAlpha extends AppCompatActivity {

    ImageView ivAnimAlpha, ivAnimRotate, ivAnimSlate, ivAnimTranslate, ivAnimTranslate2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_alpha);

        ivAnimAlpha = findViewById(R.id.iv_anim_alpha);
        ivAnimRotate = findViewById(R.id.iv_anim_rotate);
        ivAnimSlate = findViewById(R.id.iv_gif_duck);
        ivAnimTranslate = findViewById(R.id.iv_anim_translate);
        ivAnimTranslate2 = findViewById(R.id.iv_anim_translate2);

        final Animation animAlpha =
                AnimationUtils.loadAnimation(
                        AnimationAlpha.this, R.anim.anim_alpha);
        final Animation animRotate =
                AnimationUtils.loadAnimation(
                        AnimationAlpha.this, R.anim.anim_rotate);
        final Animation animScale =
                AnimationUtils.loadAnimation(
                        this, R.anim.anim_scale);
        final Animation animTranslate =
                AnimationUtils.loadAnimation(
                        this, R.anim.anim_translate);
        final Animation animTranslate2 =
                AnimationUtils.loadAnimation(this, R.anim.anim_translate_zigzag);

        ivAnimAlpha.setOnClickListener(v -> {
            v.startAnimation(animAlpha);
            Toast.makeText(AnimationAlpha.this,
                    "Animation Alpha", Toast.LENGTH_SHORT).show();
        });

        ivAnimRotate.setOnClickListener(v -> {
            v.startAnimation(animRotate);
            Toast.makeText(AnimationAlpha.this,
                    "Animation Rotate", Toast.LENGTH_SHORT).show();
        });

        ivAnimSlate.setOnClickListener(v -> {
            v.startAnimation(animScale);
            Toast.makeText(AnimationAlpha.this,
                    "Animation Scale", Toast.LENGTH_SHORT).show();
        });

        ivAnimTranslate.setOnClickListener(v -> {
            v.startAnimation(animTranslate);
            Toast.makeText(AnimationAlpha.this,
                    "Animation Translate", Toast.LENGTH_SHORT).show();
        });

        ivAnimTranslate2.setOnClickListener(v -> {
            v.startAnimation(animTranslate2);
            Toast.makeText(AnimationAlpha.this,
                    "Animation Translate Type ZigZag",
                    Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ic_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.it_home) {
            startActivity(new Intent(this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

}