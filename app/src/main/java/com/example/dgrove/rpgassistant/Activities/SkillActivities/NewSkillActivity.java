package com.example.dgrove.rpgassistant.Activities.SkillActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.dgrove.rpgassistant.DB.Entities.GameSkillsEntity;
import com.example.dgrove.rpgassistant.R;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class NewSkillActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_skill);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }

    public void createSkill(View view){
        EditText skillNameET = findViewById(R.id.skill_name_et);
        String skillName = skillNameET.getText().toString();

        GameSkillsEntity skill = new GameSkillsEntity(0, 0, skillName);

        Intent intent = new Intent(this, SkillListActivity.class);
        startActivity(intent);
    }
 }
