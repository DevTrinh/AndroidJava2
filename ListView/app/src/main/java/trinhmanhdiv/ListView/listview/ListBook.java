package trinhmanhdiv.ListView.listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import trinhmanhdiv.ListView.listview.Adapter.BookAdapter;
import trinhmanhdiv.ListView.listview.ImageResource.BookItem;

public class ListBook extends AppCompatActivity {

    RecyclerView rvBook;
    BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_book);

        mapping();
        rvBook.setNestedScrollingEnabled(false);
        bookAdapter = new BookAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);

        rvBook.setLayoutManager(gridLayoutManager);
        bookAdapter.setData(getListBook());
        rvBook.setAdapter(bookAdapter);

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
        rvBook = findViewById(R.id.rv_book);
    }

    public List<BookItem> getListBook(){
        List<BookItem> bookItem = new ArrayList<>();

        bookItem.add(new BookItem("từ rách thành oách", R.drawable.book1));
        bookItem.add(new BookItem("chuyên gia thời trang", R.drawable.book2));
        bookItem.add(new BookItem("phong cách thế hệ Y", R.drawable.book3));
        bookItem.add(new BookItem("thời trang đường phố", R.drawable.book4));
        bookItem.add(new BookItem("cổ điển sang trọng", R.drawable.book5));
        bookItem.add(new BookItem("kiến trúc hiện đại", R.drawable.book6));
        bookItem.add(new BookItem("sâu vào giấc mơ", R.drawable.book7));
        bookItem.add(new BookItem("sóng vỡ bờ ở Vĩnh An", R.drawable.book8));
        bookItem.add(new BookItem("123", R.drawable.book1));
        bookItem.add(new BookItem("sau những tán lá", R.drawable.book9));
        bookItem.add(new BookItem("cho buổi sáng tốt lành", R.drawable.book10));
        bookItem.add(new BookItem("từ rách thành oách", R.drawable.book1));
        bookItem.add(new BookItem("chuyên gia thời trang", R.drawable.book2));
        bookItem.add(new BookItem("phong cách thế hệ Y", R.drawable.book3));
        bookItem.add(new BookItem("thời trang đường phố", R.drawable.book4));
        bookItem.add(new BookItem("cổ điển sang trọng", R.drawable.book5));
        bookItem.add(new BookItem("kiến trúc hiện đại", R.drawable.book6));
        bookItem.add(new BookItem("sâu vào giấc mơ", R.drawable.book7));
        bookItem.add(new BookItem("sóng vỡ bờ ở Vĩnh An", R.drawable.book8));
        bookItem.add(new BookItem("123", R.drawable.book1));
        bookItem.add(new BookItem("sau những tán lá", R.drawable.book9));
        bookItem.add(new BookItem("cho buổi sáng tốt lành", R.drawable.book10));
        bookItem.add(new BookItem("phong cách thế hệ Y", R.drawable.book3));
        bookItem.add(new BookItem("thời trang đường phố", R.drawable.book4));

        return bookItem;
    }
}