package com.example.dgrove.rpgassistant.Activities.AccountActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.dgrove.rpgassistant.Activities.GameActivities.GameListActivity;
import com.example.dgrove.rpgassistant.Activities.GameActivities.GameMenuActivity;
import com.example.dgrove.rpgassistant.DB.Entities.UserEntity;
import com.example.dgrove.rpgassistant.DB.RPGAssistantDB;
import com.example.dgrove.rpgassistant.DB.ViewModels.UserViewModel;
import com.example.dgrove.rpgassistant.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class LoginActivity extends AppCompatActivity {
    UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        RPGAssistantDB db = RPGAssistantDB.getDatabase(this);

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
    }

    public void login(View view){
        EditText emailET = findViewById(R.id.emailEditText);
        String email = emailET.getText().toString();

        EditText passwordET = findViewById(R.id.passwordEditText);
        String password = passwordET.getText().toString();

        UserEntity user = userViewModel.getUserByEmail(email);

        if(user != null) {
            if(user.getPassword().equals(password)){
                Intent intent = new Intent(this, GameListActivity.class);
                startActivity(intent);
            }
        }

        CheckBox checkBox = (CheckBox)findViewById(R.id.stayLoggedInCheckBox);
        boolean isChecked = checkBox.isChecked();

        emailET.getText().clear();
        passwordET.getText().clear();
    }

    public void testOpenActivity(View view) {
        Intent intent = new Intent(this, GameMenuActivity.class);
        startActivity(intent);
    }

    public void loginToCreate(View view) {
        Intent intent = new Intent(this, CreateUserActivity.class);
        startActivity(intent);
    }
}
