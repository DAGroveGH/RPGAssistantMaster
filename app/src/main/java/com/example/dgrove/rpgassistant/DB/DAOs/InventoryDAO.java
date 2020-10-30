package com.example.dgrove.rpgassistant.DB.DAOs;

import com.example.dgrove.rpgassistant.DB.Entities.CharacterInventoryEntity;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface InventoryDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertInventory(CharacterInventoryEntity characterInventory);

    @Update
    public void updateInventory(CharacterInventoryEntity characterInventory);

    @Delete
    public void deleteInventory(CharacterInventoryEntity characterInventory);

    @Query("SELECT * FROM CharacterInventoryEntity WHERE itemID IN (:itemIDs)")
    public CharacterInventoryEntity getAllItemsByID(int itemIDs);

    @Query("SELECT * FROM CharacterInventoryEntity WHERE itemTradable = 1")
    public CharacterInventoryEntity[] getAllTradableItems();

    @Query("SELECT * FROM CharacterInventoryEntity")
    public LiveData<List<CharacterInventoryEntity>> loadAllCharacterInventory();
}
