package trinhmanhdiv.ListView.listview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class IntentImplicit extends AppCompatActivity {

    ImageView ivCall, ivBrowse, ivMess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        ivBrowse = findViewById(R.id.iv_browse);
        ivCall = findViewById(R.id.iv_call);
        ivMess = findViewById(R.id.iv_mess);

        ivBrowse.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intentToBrowse = new Intent();
               intentToBrowse.setAction(Intent.ACTION_VIEW);
               intentToBrowse.setData(Uri.parse("https://www.google.com/"));
               startActivity(intentToBrowse);
           }
        });

        ivMess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToMess = new Intent();
                intentToMess.setAction(Intent.ACTION_SENDTO);
//                gửi đi dữ liệu gì đó
                intentToMess.putExtra("sms_body", "XIN CHAO");
                intentToMess.setData(Uri.parse("sms:0868841059"));
                startActivity(intentToMess);
            }
        });

        ivCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToCall = new Intent();
                intentToCall.setAction(Intent.ACTION_DIAL);
                intentToCall.setData(Uri.parse("tel:0868841059"));
                startActivity(intentToCall);
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