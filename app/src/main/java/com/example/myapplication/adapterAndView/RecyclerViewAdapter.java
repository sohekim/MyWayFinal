package com.example.myapplication.adapterAndView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.ExploreActivity;
import com.example.myapplication.ProfileActivity;
import com.example.myapplication.R;
import com.example.myapplication.data.User;

import java.io.Serializable;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    ExploreActivity exploreActivity;
    ArrayList<User> userArrayList;
    int curPosition;

    public RecyclerViewAdapter(ExploreActivity exploreActivity, ArrayList<User> userArrayList) {
        this.exploreActivity = exploreActivity;
        this.userArrayList = userArrayList;
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(exploreActivity.getBaseContext());
        View view = layoutInflater.inflate(R.layout.single_row, parent, false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        curPosition = position;
        holder.mUserName.setText(userArrayList.get(position).getName());
        holder.mUserMajor.setText(userArrayList.get(position).getMajor());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewAdapter.this.exploreActivity, ProfileActivity.class);
                intent.putExtra("USER", userArrayList.get(curPosition));
                exploreActivity.startActivity(intent);
            }

        });
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

}
