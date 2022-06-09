package trinhmanhdiv.ListView.listview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ReadRSS extends AppCompatActivity {

    private ListView lvNews;
    private TextView tvHotNews;
    private ImageView ivHotNews;
    ArrayList<String> listTittle, listLink;
    ArrayList<Intent> listImg;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_rss);

        mapping();
        listTittle = new ArrayList<>();
        listLink = new ArrayList<>();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listTittle);

        lvNews.setAdapter(adapter);
        new ReadNewsRSS().execute("https://vnexpress.net/rss/tin-moi-nhat.rss");

        lvNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ReadRSS.this, listLink.get(position)+"", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ReadRSS.this, ReadNews.class);
                intent.putExtra("urlNews", listLink.get(position)+"");
                startActivity(intent);
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

    public class ReadNewsRSS extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(@NonNull String... strings) {

            StringBuilder content = new StringBuilder();

            try {
                URL url = new URL(strings[0]);
                InputStreamReader inputStreamReader =
                        new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = "";

                while ((line = bufferedReader.readLine()) != null){
                    content.append(line);
                }
                bufferedReader.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content.toString();
        }

        String title = "asdasdas";
        int iv = 0;
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            XMLDOMParser xmldomParser = new XMLDOMParser();
            Document document = xmldomParser.getDocument(s);
            NodeList nodeList = document.getElementsByTagName("item");

            for(int i = 0; i < nodeList.getLength(); i++){
                Element element = (Element) nodeList.item(i);
                title = xmldomParser.getValue(element, "title");
                if(i == 0){
                    tvHotNews.setText(title);
                    ivHotNews.setImageResource(R.drawable.iv_news);
                }
                else{
                    listTittle.add(title);
                    listLink.add(xmldomParser.getValue(element, "link"));
                }

            }
            adapter.notifyDataSetChanged();

            Toast.makeText(ReadRSS.this, title+"", Toast.LENGTH_SHORT).show();
        }

    }

    public void mapping(){
        ivHotNews = findViewById(R.id.rv_news_hot);
        tvHotNews = findViewById(R.id.tv_tittle_hot);
        lvNews = findViewById(R.id.rv_news_main);
    }

}