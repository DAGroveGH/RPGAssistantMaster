package com.example.dgrove.rpgassistant.DB.DAOs;

import com.example.dgrove.rpgassistant.DB.Entities.GameEntity;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface GameListDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertGameEntity(GameEntity game);

    @Update
    public void updateGameEntity(GameEntity game);

    @Delete
    public void deleteGameEntity(GameEntity game);

    @Query("SELECT * FROM GameEntity WHERE gameID IN (:gameIDs)")
    public GameEntity getGameEntityByID(int gameIDs);

    /*@Query("SELECT * FROM GameEntity G JOIN UserEntity U WHERE G.ownerID = U.userID IN (:gameIDs)")
    public LiveData<List<GameEntity>> getOwnedGameEntities(int[] gameIDs);*/

    @Query("SELECT gameID FROM GameEntity ORDER BY gameID")
    public int[] getAllGameIDs();

    @Query("SELECT * FROM GameEntity")
    public LiveData<List<GameEntity>> loadAllGameEntities();

    @Query("SELECT gameName FROM GameEntity ORDER BY gameName")
    public String[] getAllGameEntityNames();

}