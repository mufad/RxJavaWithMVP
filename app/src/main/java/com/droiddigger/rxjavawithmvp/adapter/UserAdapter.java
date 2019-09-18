package com.droiddigger.rxjavawithmvp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.droiddigger.rxjavawithmvp.R;
import com.droiddigger.rxjavawithmvp.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    List<User> userList = new ArrayList<>();

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_users, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvTitle.setText(userList.get(position).getTitle());
        holder.tvId.setText(userList.get(position).getId() + "");
        holder.tvBody.setText(userList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, tvTitle, tvBody;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvId = (TextView) itemView.findViewById(R.id.user_id);
            tvTitle = (TextView) itemView.findViewById(R.id.user_title);
            tvBody = (TextView) itemView.findViewById(R.id.user_body);
        }
    }

}