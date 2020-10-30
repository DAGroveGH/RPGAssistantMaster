package com.example.dgrove.rpgassistant.Activities.CharacterActivities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.dgrove.rpgassistant.R;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CharacterStoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_story);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }

    public void saveCharacterStory(View view) {
        EditText et = findViewById(R.id.character_story_et);
        String characterStory = et.getText().toString();


    }
}
