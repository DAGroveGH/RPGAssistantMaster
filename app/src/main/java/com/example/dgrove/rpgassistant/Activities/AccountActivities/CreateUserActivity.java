package com.example.dgrove.rpgassistant.Activities.AccountActivities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.dgrove.rpgassistant.Activities.GameActivities.GameListActivity;
import com.example.dgrove.rpgassistant.Activities.GameActivities.GameMenuActivity;
import com.example.dgrove.rpgassistant.DB.Entities.UserEntity;
import com.example.dgrove.rpgassistant.DB.ViewModels.UserViewModel;
import com.example.dgrove.rpgassistant.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class CreateUserActivity extends AppCompatActivity {
    UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        Intent intent = getIntent();
    }

    public void createUser(View view) {
        EditText usernameET = findViewById(R.id.usernameEditText);
        String username = usernameET.getText().toString();

        EditText passwordET = findViewById(R.id.passwordEditText);
        String password = passwordET.getText().toString();

        EditText emailET = findViewById(R.id.emailEditText);
        String email = emailET.getText().toString();

        CheckBox checkBox = (CheckBox) findViewById(R.id.stayLoggedInCheckBox);
        boolean isChecked = checkBox.isChecked();
        checkBox.setChecked(isChecked);

        SharedPreferences sharedPref = getSharedPreferences(
                getString(R.string.RPGAssistantSharedPreferences), Context.MODE_PRIVATE);

        if(userViewModel.getUserByUsername(username) != null){
            UserEntity user = new UserEntity(0, username, password, email);
            userViewModel.insert(user);

            sharedPref.edit().putString(getString(R.string.prefCurrentUserEmailKey), user.getEmail()).apply();
        }

        sharedPref.edit().putBoolean(getString(R.string.prefStayLoggedInKey), checkBox.isChecked()).apply();

        sharedPref.getBoolean(getString(R.string.prefStayLoggedInKey), false);

        Intent intent = new Intent(this, GameListActivity.class);
        startActivity(intent);
    }

    public void testActivityOpen(View view) {
        Intent intent = new Intent(this, GameMenuActivity.class);
        startActivity(intent);
    }


    public void createToLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
