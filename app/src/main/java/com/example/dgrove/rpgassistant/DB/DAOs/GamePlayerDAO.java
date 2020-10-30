package com.example.dgrove.rpgassistant.DB.DAOs;

import com.example.dgrove.rpgassistant.DB.Entities.GameEntity;
import com.example.dgrove.rpgassistant.DB.Entities.GamePlayerEntity;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface GamePlayerDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertGamePlayer(GamePlayerEntity gamePlayer);

    @Update
    public void updateGamePlayer(GamePlayerEntity gamePlayer);

    @Delete
    public void deleteGamePlayer(GamePlayerEntity gamePlayer);

    @Query("SELECT * FROM GameEntity WHERE gameID IN (:gameIDs)")
    public GameEntity getGameByID(int gameIDs);

    @Query("SELECT * FROM GamePlayerEntity")
    public LiveData<List<GamePlayerEntity>> loadAllGamePlayers();

    @Query("SELECT * FROM GamePlayerEntity WHERE userID = (:playerID)")
    public GamePlayerEntity getAllGamePlayerByID(int playerID);

}
