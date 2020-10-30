package com.example.dgrove.rpgassistant.Activities.GameActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.dgrove.rpgassistant.DB.Entities.GameEntity;
import com.example.dgrove.rpgassistant.R;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CreateJoinGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_join_game);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }

    public void createGame(View view) {
        EditText gameNameET = findViewById(R.id.game_name_et);
        String gameName = gameNameET.getText().toString();

        GameEntity game = new GameEntity(0, 0,gameName);

        Intent intent = new Intent(this, GameMenuActivity.class);
        startActivity(intent);
    }

    public void joinGame(View view) {
        EditText inviteCodeET = findViewById(R.id.invite_code_et);
        String inviteCode = inviteCodeET.getText().toString();
    }
}
