package com.example.dgrove.rpgassistant.MiscPrograms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dgrove.rpgassistant.DB.Entities.CharacterInventoryEntity;
import com.example.dgrove.rpgassistant.R;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.InventoryViewHolder> {
    private CharacterInventoryEntity[] items;
    private List<CharacterInventoryEntity> mDataset = new ArrayList<>();

    public InventoryAdapter(){}

    public static class InventoryViewHolder extends RecyclerView.ViewHolder {
        public TextView item_name;

        public InventoryViewHolder(View v) {
            super(v);
            item_name = v.findViewById(R.id.item_name);
        }
    }

    @Override
    public InventoryAdapter.InventoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView v = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.inventory_list_item, parent, false);
        return new InventoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(InventoryViewHolder holder, int position) {
        CharacterInventoryEntity item = mDataset.get(position);
        holder.item_name.setText(item.getItemName());
    }

    @Override
    public int getItemCount() { return mDataset.size(); }

    public void setDataset(List<CharacterInventoryEntity> list) {
        mDataset = list;
        notifyDataSetChanged();
    }
}
