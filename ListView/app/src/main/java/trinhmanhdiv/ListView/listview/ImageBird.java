package trinhmanhdiv.ListView.listview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.Collections;

public class ImageBird extends AppCompatActivity {

    TableLayout tbLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_bird);

        tbLayout = findViewById(R.id.tb_layout);
        int collum = 2;
        int row = 10;
//        mix arr
        Collections.shuffle(AngryBird.listName);

        for(int i = 1; i <= row; i++){
            TableRow tableRow = new TableRow(this);
//            create column -> imageview
            for (int j = 1; j <= collum; j++){
                ImageView iv = new ImageView(this);
                TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(dpToPx(140), dpToPx(140));
                iv.setLayoutParams(layoutParams);

                final int POSITION = collum  * (i - 1) + j -1;

                int idImage =
                        getResources().
                                getIdentifier(AngryBird.listName.get(POSITION),
                                        "drawable", getPackageName());
                iv.setImageResource(idImage);
//                add imageView vào table row
                tableRow.addView(iv);

                iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.putExtra(
                                "name_image",
                                AngryBird.listName.get(POSITION));
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });
            }
//            add table row in table
            tbLayout.addView(tableRow);
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

    public static int dpToPx(int dp)
    {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
}