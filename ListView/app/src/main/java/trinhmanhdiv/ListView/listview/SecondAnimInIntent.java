package trinhmanhdiv.ListView.listview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SecondAnimInIntent extends AppCompatActivity {

    Button btSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_anim_in_intent);

        btSecond = findViewById(R.id.bt_anim_intent2);

        btSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondAnimInIntent.this, AnimInIntent.class));
                overridePendingTransition(R.anim.anim_begin_intent, R.anim.anim_end_intent);
            }
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