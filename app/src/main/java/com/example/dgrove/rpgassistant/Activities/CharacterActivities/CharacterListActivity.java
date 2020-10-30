package com.example.dgrove.rpgassistant.Activities.CharacterActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dgrove.rpgassistant.DB.Entities.GameCharacterEntity;
import com.example.dgrove.rpgassistant.DB.ViewModels.CharacterViewModel;
import com.example.dgrove.rpgassistant.MiscPrograms.CharacterAdapter;
import com.example.dgrove.rpgassistant.R;

import java.util.List;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CharacterListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CharacterAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    CharacterViewModel characterViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_list);        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.character_list_rv);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new CharacterAdapter();
        recyclerView.setAdapter(mAdapter);

        characterViewModel = ViewModelProviders.of(this).get(CharacterViewModel.class);
        characterViewModel.getAllGameCharacter().observe(this, new androidx.lifecycle.Observer<List<GameCharacterEntity>>() {
            @Override
            public void onChanged(List<GameCharacterEntity> characterEntities) {
                mAdapter.setDataset(characterEntities);
            }
        });
    }

    public void characterChoose(View view) {
        Intent intent = new Intent(this, CharacterMenuActivity.class);
        startActivity(intent);
    }

    public void newCharacter(View view) {
        Intent intent = new Intent(this, NewCharacterActivity.class);
        startActivity(intent);
    }
}
