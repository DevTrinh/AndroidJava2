package com.example.readjson;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.readjson.Adapter.AdapterItemSql;
import com.example.readjson.DataBase.DataBaseSqlite;
import com.example.readjson.ItemData.ItemSql;

import java.util.ArrayList;
import java.util.List;

public class SQLiteToDoList extends AppCompatActivity {

    static DataBaseSqlite dataBase;
    ImageView ivNavigation;
    RecyclerView rvWorking;
    AdapterItemSql adapterItemSql;

    List<ItemSql> list;
    Cursor dataWorking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_to_do_list);

        mapping();
        list = new ArrayList<>();

        adapterItemSql = new AdapterItemSql(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rvWorking.setLayoutManager(linearLayoutManager);
        rvWorking.setAdapter(adapterItemSql);

        dataBase = new DataBaseSqlite(this, "ghichu.sqlite", null, 1);

//        CREATE TABLE DATA WORKING
        dataBase.queryData(SqlCommand.createTable);
//        INSERT DATA
//        dataBase.queryData("INSERT INTO working VALUES(null, 'Schools')");

        selectData();
    }


//    SELECT DATA
    private void selectData(){
        dataWorking = dataBase.getData(SqlCommand.selectAllData);
        list.clear();
        while (dataWorking.moveToNext()) {
            String name = dataWorking.getString(1);
            int positionWorking = dataWorking.getInt(0);
            adapterItemSql.setData(getListItemSql(name, positionWorking));
        }
    }

    private void dialogUpdateItem(){

    }

//    ADD DATA USING DIALOG
    private void dialogAddItem(int gravity) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_dialog_add_item);

        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowAttribute = window.getAttributes();
        windowAttribute.gravity = gravity;
        window.setAttributes(windowAttribute);

        if (Gravity.CENTER == gravity) {
            dialog.setCancelable(false);
        } else {
            dialog.setCancelable(true);
        }

        EditText etDialog = dialog.findViewById(R.id.et_content_add);
        Button btDialogCf = dialog.findViewById(R.id.bt_dialog_confirm);
        Button btDialogCc = dialog.findViewById(R.id.bt_dialog_cancel);

        btDialogCc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btDialogCf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noteText = etDialog.getText().toString();
                if (noteText.trim().length() == 0) {
                    Toast.makeText(SQLiteToDoList.this, "Not Data", Toast.LENGTH_SHORT).show();
                } else {
                    dataBase.queryData("INSERT INTO working VALUES(null, '"+noteText+"')");
                    Toast.makeText(SQLiteToDoList.this, "Add Note Successfully", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    selectData();
                }
            }
        });
        dialog.show();
    }

    @NonNull
    private List<ItemSql> getListItemSql(String name, int positionWorking) {
        list.add(new ItemSql(name, positionWorking));
        return list;
    }

    private void showMenuOption() {
        PopupMenu menu = new PopupMenu(this, ivNavigation);
        menu.getMenuInflater().inflate(R.menu.mn_sql_nav, menu.getMenu());
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.it_delete:
                        break;
                    case R.id.it_update:
                        item.getItemId();
                        break;
                }
                return false;
            }
        });
        menu.show();
    }

    private void mapping() {
        ivNavigation = findViewById(R.id.iv_sql_nav);
        rvWorking = findViewById(R.id.rv_data_sql);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mn_add_item_sql, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.it_add) {
            dialogAddItem(Gravity.CENTER);
        }
        return super.onOptionsItemSelected(item);
    }

    public static class SqlCommand {
        static String createTable =
                "CREATE TABLE IF NOT EXISTS " +
                        "working(id INTEGER PRIMARY KEY AUTOINCREMENT, TenCV nvarchar(50))";
        static String selectAllData = "SELECT * FROM working";
    }
}