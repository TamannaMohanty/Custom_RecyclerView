package com.example.custom_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameHolder> {

    Context context;
    List<GameModel> gameModelList = new ArrayList<>();
    OnItemClick onItemClick;

    public GameAdapter(Context context, List<GameModel> gameModelList) {
        this.context = context;
        this.gameModelList = gameModelList;
    }

    public GameAdapter(Context context, List<GameModel> gameModelList, OnItemClick onItemClick) {
        this.context = context;
        this.gameModelList = gameModelList;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public GameHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_vertical, parent, false);
        return new GameHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull GameHolder holder, int position) {
        holder.name.setText(gameModelList.get(position).getName());
        holder.country.setText(gameModelList.get(position).getCountry());
        holder.people.setText(gameModelList.get(position).getPeople());

    }

    @Override
    public int getItemCount() {
        return gameModelList.size();
    }

    public class GameHolder extends RecyclerView.ViewHolder {
        TextView name, country, people;

        public GameHolder(@NonNull View itemView) {

            super(itemView);

            name = itemView.findViewById(R.id.gamename);
            country = itemView.findViewById(R.id.gamecountry);
            people = itemView.findViewById(R.id.gamepeople);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    onItemClick.onClick(getAdapterPosition());

                    // Toast.makeText(context, ""+gameModelList.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}