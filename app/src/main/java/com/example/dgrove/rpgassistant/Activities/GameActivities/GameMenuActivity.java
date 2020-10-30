package com.example.dgrove.rpgassistant.Activities.GameActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dgrove.rpgassistant.Activities.CharacterActivities.CharacterListActivity;
import com.example.dgrove.rpgassistant.Activities.PlayerActions.PlayerActionsActivity;
import com.example.dgrove.rpgassistant.R;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class GameMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }

    public void toCharacterList(View view) {
        Intent intent = new Intent(this, CharacterListActivity.class);
        startActivity(intent);
    }

    public void toGameStory(View view) {
        Intent intent = new Intent(this, GameStoryActivity.class);
        startActivity(intent);
    }

    public void toPlayerActions(View view) {
        Intent intent = new Intent(this, PlayerActionsActivity.class);
        startActivity(intent);
    }
}
