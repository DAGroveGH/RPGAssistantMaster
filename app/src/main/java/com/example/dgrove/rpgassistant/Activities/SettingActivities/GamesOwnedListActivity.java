package com.example.dgrove.rpgassistant.Activities.SettingActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dgrove.rpgassistant.DB.ViewModels.GameViewModel;
import com.example.dgrove.rpgassistant.MiscPrograms.GameAdapter;
import com.example.dgrove.rpgassistant.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class GamesOwnedListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private GameAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private int[] gameIDs;
    GameViewModel gameViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_owned_list);
        /*recyclerView = (RecyclerView) findViewById(R.id.games_owned_list_rv);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new GameAdapter();
        recyclerView.setAdapter(mAdapter);
        //gameIDs = gameViewModel.getAllGameIDs();


        gameViewModel = ViewModelProviders.of(this).get(GameViewModel.class);
        gameViewModel.getOwnedGames(gameIDs).observe(this, new androidx.lifecycle.Observer<List<GameEntity>>() {
            @Override
            public void onChanged(List<GameEntity> gameEntities) {
                mAdapter.setDataset(gameEntities);
            }
        });*/
    }

    public void gameChoose(View view) {
        Intent intent = new Intent(this, GameOptionsActivity.class);
        startActivity(intent);
    }
}
