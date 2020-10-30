package com.example.dgrove.rpgassistant.Activities.GameActivities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.dgrove.rpgassistant.R;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class GameStoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_story);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }

    public void saveGameStory(View view) {
        EditText et = findViewById(R.id.game_story_et);
        String gameStory = et.getText().toString();


    }

}
