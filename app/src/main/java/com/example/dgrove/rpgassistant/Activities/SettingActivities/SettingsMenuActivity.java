package com.example.dgrove.rpgassistant.Activities.SettingActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dgrove.rpgassistant.R;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SettingsMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_menu);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }

    public void toChooseTheme(View view) {
        Intent intent = new Intent(this, ThemeMenuActivity.class);
        startActivity(intent);
    }

    public void toGamesOwnedList(View view) {
        Intent intent = new Intent(this, GamesOwnedListActivity.class);
        startActivity(intent);
    }

    public void toNotificationMenu(View view) {
        Intent intent = new Intent(this, NotificationMenuActivity.class);
        startActivity(intent);
    }

    public void syncGames(View view) {
        //TODO: write sync games
    }

    public void signOut(View view) {
        //TODO: write sign out
    }
}
