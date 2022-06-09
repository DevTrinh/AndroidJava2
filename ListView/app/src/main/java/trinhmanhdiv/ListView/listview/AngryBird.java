package trinhmanhdiv.ListView.listview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AngryBird extends AppCompatActivity {

    public static ArrayList<String> listName;
    ImageView ivBird, ivQuestion;
    TextView tvScore;
    SharedPreferences saveScore;

    int reQuest = 123;
    int totalScore = 100;
    String ivGap;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angry_bird);

        ivBird = findViewById(R.id.iv_bird);
        ivQuestion = findViewById(R.id.iv_question);
        tvScore = findViewById(R.id.tv_score_bird);
        saveScore = getSharedPreferences("dataScore", MODE_PRIVATE);

        String[] listNameBird = getResources().getStringArray(R.array.list_name);
        listName = new ArrayList<>(Arrays.asList(listNameBird));
        totalScore = saveScore.getInt("numberScore", 100);
        tvScore.setText("score: " + totalScore);

//      mix array
        Collections.shuffle(listName);
        ivGap = listName.get(5);

        int idImage =
                getResources().getIdentifier(listName.get(5),
                        "drawable", getPackageName());

        ivBird.setImageResource(idImage);

        ivQuestion.setOnClickListener(v -> startActivityForResult(new Intent(
                AngryBird.this,
                ImageBird.class), reQuest));
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode, @Nullable Intent data) {
        if (requestCode == reQuest && resultCode == RESULT_OK && data != null) {
            String name_image = data.getStringExtra("name_image");
            int idImage =
                    getResources().getIdentifier(name_image,
                            "drawable", getPackageName());

            ivQuestion.setImageResource(idImage);

//           compare by image
            if (ivGap.equals(name_image)) {
                Toast.makeText(this, "That is true", Toast.LENGTH_SHORT).show();
                new CountDownTimer(1500, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        //        mix array
                        Collections.shuffle(listName);
                        ivGap = listName.get(5);
                        int idImage = getResources().
                                getIdentifier(listName.get(5),
                                        "drawable",
                                        getPackageName());
                        ivBird.setImageResource(idImage);
                    }
                }.start();
                //sum score
                totalScore += 10;
            } else {
                Toast.makeText(this, "This is False",
                        Toast.LENGTH_SHORT).show();totalScore -= 5;
            }

            setSaveScore();
            tvScore.setText("score: " + totalScore);
        }

        if (requestCode == reQuest && resultCode == RESULT_CANCELED) {
            Toast.makeText(this,
                    "You not click image",
                    Toast.LENGTH_SHORT).show();
            totalScore -= 15;
            setSaveScore();
            tvScore.setText("score: " + totalScore);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mn_reload_bird, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.ic_reload) {
//        mix array
            Collections.shuffle(listName);
            ivGap = listName.get(5);
            int idImage = getResources().getIdentifier(listName.get(5),
                    "drawable", getPackageName());
            ivBird.setImageResource(idImage);
        }
        return super.onOptionsItemSelected(item);
    }

    private void setSaveScore() {
        SharedPreferences.Editor editorScore = saveScore.edit();
        editorScore.putInt("numberScore", totalScore);
        editorScore.apply();
    }

}