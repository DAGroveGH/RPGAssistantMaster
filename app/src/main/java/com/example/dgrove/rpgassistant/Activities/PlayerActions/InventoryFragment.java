package com.example.dgrove.rpgassistant.Activities.PlayerActions;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dgrove.rpgassistant.MiscPrograms.InventoryAdapter;
import com.example.dgrove.rpgassistant.R;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class InventoryFragment extends Fragment {
    private RecyclerView recyclerView;
    private InventoryAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public InventoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_inventory, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.inventory_rv);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new InventoryAdapter();
        recyclerView.setAdapter(mAdapter);

        return rootView;
    }

}
