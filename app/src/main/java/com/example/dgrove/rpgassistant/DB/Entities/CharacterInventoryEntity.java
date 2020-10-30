package com.example.dgrove.rpgassistant.DB.Entities;


import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(
        indices = {@Index("characterID")},
        foreignKeys = {
                @ForeignKey(
                        entity = GameCharacterEntity.class,
                        parentColumns = "characterID",
                        childColumns = "characterID",
                        onDelete = CASCADE
                )})
public class CharacterInventoryEntity {
    @PrimaryKey
    private int itemID;
    private int characterID;
    private String itemName;
    private boolean itemTradable;

    private static final String TAG = "CharacterInventoryEntity";

    public CharacterInventoryEntity(int itemID, int characterID, String itemName, boolean itemTradable) {
        if(itemID < 0){
            throw new NullPointerException("Item ID must be greater than 0");
        }else if(characterID < 0){
            throw new NullPointerException("Character ID must be greater than 0");
        }else if(itemName == null){
            throw new NullPointerException("Item name must not be null");
        }else{
            this.itemID = itemID;
            this.characterID = characterID;
            this.itemName = itemName;
            this.itemTradable = itemTradable;
        }
    }

    //getters
    public int getCharacterID() {
        return characterID;
    }
    public String getItemName() {
        return itemName;
    }
    public boolean isItemTradable() {
        return itemTradable;
    }
    public int getItemID() {
        return itemID;
    }

    //setters
    public void setCharacterID(int characterID) {
        this.characterID = characterID;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public void setItemTradable(boolean itemTradable) {
        this.itemTradable = itemTradable;
    }
    public void setItemID(int itemID){ this.itemID = itemID; }
}
