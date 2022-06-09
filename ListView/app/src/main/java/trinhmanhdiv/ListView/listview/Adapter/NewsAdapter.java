package trinhmanhdiv.ListView.listview.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import trinhmanhdiv.ListView.listview.ImageResource.UserItem;
import trinhmanhdiv.ListView.listview.R;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private Context context;
    private List<UserItem> list;

    public NewsAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).
                        inflate(R.layout.item_news,
                                parent,false);

        Animation animListView = AnimationUtils.loadAnimation(context, R.anim.anim_custom_listview_vertical);
        view.startAnimation(animListView);

        return new NewsAdapter.NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivNews;
        private TextView tvTittle, tvContent;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            ivNews = itemView.findViewById(R.id.iv_news_item);
            tvTittle = itemView.findViewById(R.id.tv_news_item);
            tvContent = itemView.findViewById(R.id.tv_content_news);


        }
    }
}
