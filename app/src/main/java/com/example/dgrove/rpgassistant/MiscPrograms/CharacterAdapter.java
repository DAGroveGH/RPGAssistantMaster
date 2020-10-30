package com.example.dgrove.rpgassistant.MiscPrograms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dgrove.rpgassistant.DB.Entities.GameCharacterEntity;
import com.example.dgrove.rpgassistant.R;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {
    private GameCharacterEntity[] characters;
    private List<GameCharacterEntity> mDataset = new ArrayList<>();

    public CharacterAdapter(){}

    public static class CharacterViewHolder extends RecyclerView.ViewHolder {
        public TextView character_name;

        public CharacterViewHolder(View v) {
            super(v);
            character_name = v.findViewById(R.id.character_name);
        }
    }

    @Override
    public CharacterAdapter.CharacterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView v = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.game_list_item, parent, false);
        return new CharacterViewHolder(v);
    }


    @Override
    public void onBindViewHolder(CharacterViewHolder holder, int position){
        GameCharacterEntity character = mDataset.get(position);
        holder.character_name.setText(character.getCharacterName());
    }

    @Override
    public int getItemCount(){
        return mDataset.size();
    }

    public void setDataset(List<GameCharacterEntity> list)   {
        mDataset = list;
        notifyDataSetChanged();
    }
}
