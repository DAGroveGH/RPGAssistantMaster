package com.example.dgrove.rpgassistant.Activities.PlayerActions;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dgrove.rpgassistant.R;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiceFragment extends Fragment {


    public DiceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dice, container, false);
    }

    public int diceRoll(int dice){
        int randomInt = 1;
        for(int i = 1; i<dice; i++){
            randomInt = (int)(10.0 * Math.random());
        }
        return randomInt;
    }
}
