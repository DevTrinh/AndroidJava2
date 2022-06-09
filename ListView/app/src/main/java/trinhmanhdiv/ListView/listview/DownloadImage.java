package trinhmanhdiv.ListView.listview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadImage extends AppCompatActivity {

    ImageView ivDownload;
    Button btDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_image);

        mapping();

        btDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LoadImage().execute("https://www.toponseek.com/blogs/wp-content/uploads/2019/06/toi-uu-hinh-anh-optimize-image.jpg");
            }
        });
    }

    public void mapping(){
        ivDownload = findViewById(R.id.iv_download);
        btDownload = findViewById(R.id.bt_click_download);
    }

    public class LoadImage extends AsyncTask<String, Void, Bitmap> {

        Bitmap bitmap;

        @Override
        protected Bitmap doInBackground(@NonNull String... strings) {

            try {
                URL url = new URL(strings[0]);
                InputStream inputStream = url.openConnection().getInputStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return  bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            ivDownload.setImageBitmap(bitmap);
        }
    }
}