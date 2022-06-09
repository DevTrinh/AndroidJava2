package com.example.readjson.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.readjson.Interface.ClickItemSql;
import com.example.readjson.ItemData.ItemSql;
import com.example.readjson.R;
import com.example.readjson.SQLiteToDoList;

import java.util.List;

// STEP 4:
public class AdapterItemSql extends RecyclerView.Adapter<AdapterItemSql.ItemSqlViewHolder>{

//    STEP 5:
    private Context context;
    private List<ItemSql> listItem;

//    CLICK ITEM SQL
    private ClickItemSql clickItemSql;
// STEP 6:
    public AdapterItemSql(Context context) {
        this.context = context;
    }

//    STEP 7:
    public void setData(List<ItemSql> list){
        this.listItem = list;
        notifyDataSetChanged();
    }

    public void setDataOneItem(@NonNull List<ItemSql> list){
        this.listItem = list;
        notifyItemChanged(list.size()+1);
    }

    @NonNull
//    STEP 8
    @Override
    public ItemSqlViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_work_strean, parent, false);

        return new ItemSqlViewHolder(view);
    }

//    STEP 9:
    @Override
    public void onBindViewHolder(@NonNull ItemSqlViewHolder holder, int position) {
        ItemSql itemSql = listItem.get(position);
        if (itemSql == null){
            return;
        }
        holder.tvContent.setText(itemSql.getItemWork());
    }

    @Override
    public int getItemCount() {
        if (listItem != null){
            return listItem.size();
        }
        return 0;
    }

//    ?STEP 3:

    public class ItemSqlViewHolder extends RecyclerView.ViewHolder{

        private TextView tvContent;
        private ImageView ivNavigation;
        public ItemSqlViewHolder(@NonNull View itemView) {
            super(itemView);
            tvContent = itemView.findViewById(R.id.tv_sql_name_working);
            ivNavigation = itemView.findViewById(R.id.iv_sql_nav);

            ivNavigation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showMenuNav();
                }
            });

        }

        private void showMenuNav(){
            PopupMenu popupMenu = new PopupMenu(context,ivNavigation);
            popupMenu.getMenuInflater().inflate(R.menu.mn_sql_nav, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()){
                        case R.id.it_update:
                            dialogUpdateItem(Gravity.CENTER);
                            break;
                    }
                    return false;
                }
            });
            popupMenu.show();
        }


        private void dialogUpdateItem(int gravity){
            final Dialog dialog = new Dialog(context);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.layout_dialog_update_item);

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

            etDialog.setText(tvContent.getText().toString()+"");

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

                    } else {

                    }
                }
            });
            dialog.show();
        }
    }
}
