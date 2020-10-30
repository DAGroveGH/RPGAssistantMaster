package com.example.dgrove.rpgassistant.MiscPrograms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dgrove.rpgassistant.DB.Entities.GameEntity;
import com.example.dgrove.rpgassistant.R;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHolder> {
    private GameEntity[] games;
    private List<GameEntity> mDataset = new ArrayList<>();

    public GameAdapter(){}

    //private List<Game> gameList;

    public static class GameViewHolder extends RecyclerView.ViewHolder {
        public TextView game_name;

        public GameViewHolder(View v){
            super(v);
            game_name = v.findViewById(R.id.game_name);
        }
    }

    @Override
    public GameAdapter.GameViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        TextView v = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.game_list_item, parent, false);
        return new GameViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GameViewHolder holder, int position){
        GameEntity game = mDataset.get(position);
        holder.game_name.setText(game.getGameName());
    }

    @Override
    public int getItemCount(){
        return mDataset.size();
    }

    public void setDataset(List<GameEntity> list)   {
        mDataset = list;
        notifyDataSetChanged();
    }

}
