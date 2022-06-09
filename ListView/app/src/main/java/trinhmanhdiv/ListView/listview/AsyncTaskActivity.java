package trinhmanhdiv.ListView.listview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AsyncTaskActivity extends AppCompatActivity {

    Button btHandle;
    TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        mapping();

        btHandle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handle().execute();
            }
        });

    }

    public void mapping(){
        btHandle = findViewById(R.id.bt_handle);
        tvInfo = findViewById(R.id.tv_process_async);
    }

    private class Handle extends AsyncTask<Void, String, String> {

        //      After start
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvInfo.setText("Start +\n");
        }

        @NonNull
        @Override
        protected String doInBackground(Void... voids) {
            for(int i = 0; i<=5; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress("Complete Working "+i+"\n");
            }
            return "Complete\n";
        }

//        take
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tvInfo.append(s);
            Log.d("AAAAAAAAAAAAAAAAAAAAA", "BBBBBBBBBBBBBBBBBBBBBBBB");
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            tvInfo.append(values[0]);
        }
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