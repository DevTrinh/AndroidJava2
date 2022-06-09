package trinhmanhdiv.ListView.listview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DataResult extends AppCompatActivity {

    Button btSetData;
    TextView tvSetData;
    int reQuestCode = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_result);

        btSetData = findViewById(R.id.bt_set_data);
        tvSetData = findViewById(R.id.tv_set_data);

       btSetData.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intentToMain = new Intent(
                       DataResult.this,
                       EditDataResult.class);
               startActivityForResult(intentToMain, reQuestCode);
           }
       });
    }

    @Override
    protected void onActivityResult(
            int requestCode,
            int resultCode,
            @Nullable Intent data) {
        if (requestCode == reQuestCode && resultCode == RESULT_OK && data != null ){
            String name = data.getStringExtra("new_name");
            tvSetData.setText(name);
        }
        super.onActivityResult(requestCode, resultCode, data);
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