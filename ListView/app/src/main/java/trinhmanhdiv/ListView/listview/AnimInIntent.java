package trinhmanhdiv.ListView.listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class AnimInIntent extends AppCompatActivity {

    Button btFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_in_intent);

        btFirst = findViewById(R.id.bt_anim_intent1);

        btFirst.setOnClickListener(v -> {
            startActivity(new Intent(AnimInIntent.this, SecondAnimInIntent.class));
            overridePendingTransition(R.anim.anim_begin_intent, R.anim.anim_end_intent) ;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ic_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.it_home:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}