package trinhmanhdiv.ListView.listview.Adapter;

import android.content.Context;
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

import trinhmanhdiv.ListView.listview.ImageResource.BookItem;
import trinhmanhdiv.ListView.listview.R;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>{

    private Context context;
    private List<BookItem> listBook;

    public BookAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<BookItem> list){
        this.listBook = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.item_book,
                        parent, false);

        Animation animListGrid = AnimationUtils.loadAnimation(context, R.anim.anim_custom_lv_grid);
        view.startAnimation(animListGrid);

        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        BookItem bookItem = listBook.get(position);
        if (bookItem == null){
            return;
        }
        holder.ivBook.setImageResource(bookItem.getImage());
        holder.tvName.setText(bookItem.getName());
    }

    @Override
    public int getItemCount() {
        if (listBook != null){
            return  listBook.size();
        }
        return 0;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivBook;
        private TextView tvName;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name_book);
            ivBook = itemView.findViewById(R.id.iv_item_book);
        }
    }
}
