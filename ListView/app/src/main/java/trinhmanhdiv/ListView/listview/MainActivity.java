package trinhmanhdiv.ListView.listview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_book, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.it_view_gridlayout:
                Intent mainToGridRCV = new Intent(this, ListBook.class);
                startActivity(mainToGridRCV);
                overridePendingTransition(R.anim.anim_begin_intent, R.anim.anim_end_intent) ;
                break;

            case R.id.it_view_linearlayout:
                Intent intent = new Intent( this, ListUser.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_begin_intent, R.anim.anim_end_intent) ;
                break;

            case R.id.it_action:
                Intent mainToIntent = new Intent(this, IntentImplicit.class);
                startActivity(mainToIntent);
                overridePendingTransition(R.anim.anim_begin_intent, R.anim.anim_end_intent) ;
                break;

            case R.id.it_data_result:
                Intent intentToDataResult = new Intent (this, DataResult.class);
                startActivity(intentToDataResult);
                overridePendingTransition(R.anim.anim_begin_intent, R.anim.anim_end_intent) ;
                break;

            case R.id.it_camera:
                Intent intentToCamera = new Intent(this, IntentCamera.class);
                startActivity(intentToCamera);
                overridePendingTransition(R.anim.anim_begin_intent, R.anim.anim_end_intent) ;
                break;

            case R.id.it_game:
                Intent intentMainToGame = new Intent(this, AngryBird.class);
                startActivity(intentMainToGame);
                overridePendingTransition(R.anim.anim_begin_intent, R.anim.anim_end_intent) ;
                break;

            case R.id.it_shared_preferences:
                Intent mainToSharedPreferences = new Intent (this, SharedPrefer.class);
                startActivity(mainToSharedPreferences);
                overridePendingTransition(R.anim.anim_begin_intent, R.anim.anim_end_intent) ;
                break;

            case R.id.it_animation_alpha:
                Intent mainToAnimAlpha = new Intent(this, AnimationAlpha.class);
                startActivity(mainToAnimAlpha);
                overridePendingTransition(R.anim.anim_begin_intent, R.anim.anim_end_intent) ;
                break;

            case R.id.it_anim_intent:
                Intent animIntentToSecond = new Intent(this, AnimInIntent.class);
                startActivity(animIntentToSecond);
                overridePendingTransition(R.anim.anim_begin_intent, R.anim.anim_end_intent) ;
                break;

            case R.id.it_async_task:
                startActivity(new Intent(this, AsyncTaskActivity.class));
                overridePendingTransition(R.anim.anim_begin_intent, R.anim.anim_end_intent);
                break;

            case R.id.it_dl_img:
                startActivity(new Intent(this, DownloadImage.class));
                overridePendingTransition(R.anim.anim_begin_intent, R.anim.anim_end_intent);
                break;

            case R.id.it_read_content:
                startActivity(new Intent(this, ReadSourceInternet.class));
                overridePendingTransition(R.anim.anim_begin_intent, R.anim.anim_end_intent);
                break;

            case R.id.it_read_news:
                startActivity(new Intent(this, ReadRSS.class));
                overridePendingTransition(R.anim.anim_begin_intent, R.anim.anim_end_intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}