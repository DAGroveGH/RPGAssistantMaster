package com.example.dgrove.rpgassistant.MiscPrograms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dgrove.rpgassistant.DB.Entities.GameSkillsEntity;
import com.example.dgrove.rpgassistant.R;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class SkillAdapter extends RecyclerView.Adapter<SkillAdapter.SkillViewHolder> {
    private GameSkillsEntity[] skills;
    private List<GameSkillsEntity> mDataset = new ArrayList<>();

    public SkillAdapter(){}

    public static class SkillViewHolder extends RecyclerView.ViewHolder {
        public TextView skill_name;

        public SkillViewHolder(View v){
            super(v);
            skill_name = v.findViewById(R.id.skill_name);
        }
    }

    @Override
    public SkillAdapter.SkillViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        TextView v = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.skill_list_item, parent, false);
        return new SkillViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SkillViewHolder holder, int position){
        GameSkillsEntity skill = mDataset.get(position);
        holder.skill_name.setText(skill.getSkillName());
    }

    @Override
    public int getItemCount() { return mDataset.size(); }

    public void setDataset(List<GameSkillsEntity> list) {
        mDataset = list;
        notifyDataSetChanged();
    }

}
