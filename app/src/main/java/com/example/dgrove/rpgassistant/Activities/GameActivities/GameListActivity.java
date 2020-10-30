package com.example.dgrove.rpgassistant.Activities.GameActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dgrove.rpgassistant.DB.Entities.GameEntity;
import com.example.dgrove.rpgassistant.DB.ViewModels.GameViewModel;
import com.example.dgrove.rpgassistant.MiscPrograms.GameAdapter;
import com.example.dgrove.rpgassistant.R;

import java.util.List;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GameListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private GameAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    GameViewModel gameViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.game_list_rv);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new GameAdapter();
        recyclerView.setAdapter(mAdapter);

        gameViewModel = ViewModelProviders.of(this).get(GameViewModel.class);
        gameViewModel.getAllGames().observe(this, new androidx.lifecycle.Observer<List<GameEntity>>() {
            @Override
            public void onChanged(List<GameEntity> gameEntities) {
                mAdapter.setDataset(gameEntities);
            }
        });
    }

    public void gameChoose(View view) {
        Intent intent = new Intent(this, GameMenuActivity.class);
        startActivity(intent);
    }

    public void newGame(View view) {
        Intent intent = new Intent(this, CreateJoinGameActivity.class);
        startActivity(intent);
    }
}
