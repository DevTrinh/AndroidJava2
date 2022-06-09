package trinhmanhdiv.ListView.listview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ReadSourceInternet extends AppCompatActivity {

    TextView tvReadData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_content_internet);

        tvReadData = findViewById(R.id.tv_read_data);

        new ReadContent().
                execute("https://www.toponseek.com/blogs/toi-uu-hinh-anh-optimize-image/");
    }

    private class ReadContent extends AsyncTask<String, Void, String> {

        @Nullable
        @Override
        protected String doInBackground(String... strings) {
//            read content
            StringBuilder stringBuilder = new StringBuilder();
            try {
                URL url = new URL(strings[0]);

                InputStreamReader inputStreamReader =
                        new InputStreamReader(url.openConnection().getInputStream());

                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";

                while((line = bufferedReader.readLine()) != null){
                    stringBuilder.append(line+"\n");
                }

                bufferedReader.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return stringBuilder.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tvReadData.setText(s);
        }
    }
}