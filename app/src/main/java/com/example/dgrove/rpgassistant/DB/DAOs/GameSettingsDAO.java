package com.example.dgrove.rpgassistant.DB.DAOs;

import com.example.dgrove.rpgassistant.DB.Entities.GameSettingsEntity;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface GameSettingsDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertGameSettings(GameSettingsEntity gameSettings);

    @Update
    public void updateGameSettings(GameSettingsEntity gameSettings);

    @Delete
    public void deleteGameSettings(GameSettingsEntity gameSettings);

    @Query("SELECT * FROM GameSettingsEntity")
    public LiveData<List<GameSettingsEntity>> loadAllGameSettings();

}
