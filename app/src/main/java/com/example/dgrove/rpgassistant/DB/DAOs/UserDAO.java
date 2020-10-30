package com.example.dgrove.rpgassistant.DB.DAOs;

import com.example.dgrove.rpgassistant.DB.Entities.UserEntity;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertUser(UserEntity user);

    @Update
    public void updateUsers(UserEntity user);

    @Delete
    public void deleteUser(UserEntity user);

    @Query("SELECT * FROM UserEntity WHERE email = :email LIMIT 1")
    public UserEntity getUserByEmail(String email);

    @Query("SELECT username FROM UserEntity ORDER BY username")
    public String[] getAllUsernames();

    @Query("SELECT username FROM UserEntity WHERE username = :username")
    public String getUsername(String username);

    @Query("SELECT * FROM UserEntity WHERE username = :username LIMIT 1")
    public UserEntity getUserByUsername(String username);

    @Query("SELECT userID FROM UserEntity ORDER BY userID")
    public int[] getUserIDs();

    @Query("SELECT * FROM UserEntity")
    public LiveData<List<UserEntity>> loadAllUsers();
}