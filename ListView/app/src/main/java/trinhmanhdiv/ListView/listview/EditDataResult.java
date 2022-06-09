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
import android.widget.EditText;
import android.widget.TextView;

public class EditDataResult extends AppCompatActivity {

    Button btGetData;
    EditText etGetData;
    TextView tvSetData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data_result);

        btGetData = findViewById(R.id.bt_get_data);
        etGetData = findViewById(R.id.et_get_data);
        tvSetData = findViewById(R.id.tv_set_data);

        btGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToWork = new Intent();
                String text = etGetData.getText().toString();
                intentToWork.putExtra("new_name", text);
                setResult(RESULT_OK, intentToWork);
//              đóng hoặc kết thúc màn hình hiện tại
                finish();
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