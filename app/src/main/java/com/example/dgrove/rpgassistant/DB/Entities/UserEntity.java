package com.example.dgrove.rpgassistant.DB.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity
public class UserEntity {
    @PrimaryKey (autoGenerate=true)
    int userID;
    private String username;
    private String password;
    private String email;

    public UserEntity(int userID, @NonNull String username, @NonNull String password, @NonNull String email){
            this.username = username;
            this.password = password;
            this.email = email;
    }

    // Getters

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    // Setters

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
