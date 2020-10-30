package com.example.dgrove.rpgassistant.Activities.CharacterActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dgrove.rpgassistant.Activities.SkillActivities.SkillListActivity;
import com.example.dgrove.rpgassistant.R;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CharacterMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_menu);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }

    public void toCharacterInfo(View view) {
        Intent intent = new Intent(this, CharacterInfoActivity.class);
        startActivity(intent);
    }

    public void toSkillList(View view) {
        Intent intent = new Intent(this, SkillListActivity.class);
        startActivity(intent);
    }

    public void toCharacterStory(View view) {
        Intent intent = new Intent(this, CharacterStoryActivity.class);
        startActivity(intent);
    }

}
