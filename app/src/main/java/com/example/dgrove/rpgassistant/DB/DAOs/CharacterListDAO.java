package com.example.dgrove.rpgassistant.DB.DAOs;

import com.example.dgrove.rpgassistant.DB.Entities.GameCharacterEntity;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface CharacterListDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertNewCharacter(GameCharacterEntity gameCharacter);

    @Update
    public void updateCharacter(GameCharacterEntity gameCharacter);

    @Delete
    public void deleteCharacter(GameCharacterEntity gameCharacter);

    @Query("SELECT * FROM GameCharacterEntity WHERE characterID IN (:characterIDs)")
    public GameCharacterEntity getCharactersByID(int characterIDs);

    @Query("SELECT * FROM GameCharacterEntity")
    public LiveData<List<GameCharacterEntity>> loadAllCharacters();
}
