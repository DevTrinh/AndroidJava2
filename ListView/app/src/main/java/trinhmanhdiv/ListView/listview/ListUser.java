package trinhmanhdiv.ListView.listview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import trinhmanhdiv.ListView.listview.Adapter.UserAdapter;
import trinhmanhdiv.ListView.listview.ImageResource.UserItem;

public class ListUser extends AppCompatActivity {

    UserAdapter userAdapter;
    private RecyclerView rvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        mapping();
        rvUser.setNestedScrollingEnabled(false);
        userAdapter = new UserAdapter(this);
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this,
                        RecyclerView.VERTICAL,false);
        rvUser.setLayoutManager(linearLayoutManager);
        userAdapter.setData(getListUser());
        rvUser.setAdapter(userAdapter);
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
        rvUser = findViewById(R.id.rv_user);
    }

    public List<UserItem> getListUser(){
        List<UserItem> list = new ArrayList<>();

        list.add(new UserItem("Thanh Mai", R.drawable.im_boy));
        list.add(new UserItem("Ngọc Linh", R.drawable.boy2));
        list.add(new UserItem("Đàm Thảo", R.drawable.boy3));
        list.add(new UserItem("Thanh Mai", R.drawable.girl2));
        list.add(new UserItem("Thanh Mai", R.drawable.girl3));
        list.add(new UserItem("Thanh Mai", R.drawable.im_girl));
        list.add(new UserItem("Thanh Mai", R.drawable.girl4));
        list.add(new UserItem("Thanh Mai", R.drawable.girl6));
        list.add(new UserItem("Thanh Mai", R.drawable.girl7));
        list.add(new UserItem("Thanh Mai", R.drawable.boy2));

        return list;
    }


}