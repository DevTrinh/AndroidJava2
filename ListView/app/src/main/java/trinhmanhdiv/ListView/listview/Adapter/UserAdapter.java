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

import trinhmanhdiv.ListView.listview.ImageResource.UserItem;
import trinhmanhdiv.ListView.listview.R;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private Context context;
    private List<UserItem> list;

    public UserAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<UserItem> list){
        this.list = list;
        if(list == null){
            notifyDataSetChanged();
        }

    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).
                        inflate(R.layout.item_user,
                                parent,false);

        Animation animListView = AnimationUtils.loadAnimation(context, R.anim.anim_custom_listview_vertical);
        view.startAnimation(animListView);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        UserItem userItem = list.get(position);
        if (userItem == null){
            return;
        }
        else{
            holder.ivUser.setImageResource(userItem.getSrcImage());
            holder.tvUser.setText(userItem.getName());
        }
    }

    @Override
    public int getItemCount() {
        if (list != null){
            return list.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivUser;
        private TextView tvUser;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            ivUser = itemView.findViewById(R.id.iv_user);
            tvUser = itemView.findViewById(R.id.tv_user);
        }

    }
}
