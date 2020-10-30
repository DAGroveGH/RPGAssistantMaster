package com.example.dgrove.rpgassistant.Activities.CharacterActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.dgrove.rpgassistant.DB.Entities.GameCharacterEntity;
import com.example.dgrove.rpgassistant.R;

import androidx.appcompat.app.AppCompatActivity;

public class NewCharacterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_character);
    }

    public void newCharacter(View view) {
        EditText et = findViewById(R.id.character_name_tv);
        String characterName = et.getText().toString();

        GameCharacterEntity gameCharacterEntity = new GameCharacterEntity(0,0,0, characterName, "", "", 0, "");

        Intent intent = new Intent(this, CharacterMenuActivity.class);
        startActivity(intent);
    }
}
