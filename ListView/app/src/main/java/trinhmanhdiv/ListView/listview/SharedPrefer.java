package trinhmanhdiv.ListView.listview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.zip.Inflater;

public class SharedPrefer extends AppCompatActivity {

//  STEP 1
    EditText etUsername, etPassword;
    Button btConfirm;
    CheckBox cbSavePass;
    SharedPreferences sharedPrefer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

//STEP 2
        mapping();

//        STEP 3
        sharedPrefer = getSharedPreferences("userLogin", MODE_PRIVATE);

//       STEP 6: get data
        etUsername.setText(sharedPrefer.getString("username", ""));
        etPassword.setText(sharedPrefer.getString("password", ""));
        cbSavePass.setChecked(sharedPrefer.getBoolean("checked", false));

//        STEP 4
        btConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = etUsername.getText().toString();
                String passWord = etPassword.getText().toString();

                if (userName.equals("trinhmanhdiv")
                        && passWord.equals("123")){
                    Toast.makeText(
                            SharedPrefer.this, "Login successful",
                            Toast.LENGTH_SHORT).show();
//                    IF CHECKBOX == TRUE
                    if (cbSavePass.isChecked()){
//                        STEP 5: SET DATA IN KEY VALUE
                        SharedPreferences.Editor editor = sharedPrefer.edit();
                        editor.putString("username", userName);
                        editor.putString("password", passWord);
                        editor.putBoolean("checked", true);
                        editor.apply();
                    }
                    else{
//                        IF CHECKED NOT TRUE
                        SharedPreferences.Editor editor = sharedPrefer.edit();
                        editor.remove("username");
                        editor.remove("password");
                        editor.remove("checked");
                        editor.apply();
                    }
                }
                else{
                    Toast.makeText(SharedPrefer.this, "login error", Toast.LENGTH_SHORT).show();
                }
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

    public void mapping(){
        etUsername = findViewById(R.id.et_user_login);
        etPassword = findViewById(R.id.et_user_password);
        btConfirm = findViewById(R.id.bt_login);
        cbSavePass = findViewById(R.id.cb_save_pass);
    }
}