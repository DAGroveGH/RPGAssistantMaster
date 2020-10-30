package com.example.dgrove.rpgassistant.DB.Entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(
        indices = {@Index("userID"),@Index("gameID")},
        foreignKeys = {
                @ForeignKey(
                        entity = GameEntity.class,
                        parentColumns = "gameID",
                        childColumns = "gameID",
                        onDelete = CASCADE
                ),
                @ForeignKey(
                        entity = UserEntity.class,
                        parentColumns = "userID",
                        childColumns = "userID",
                        onDelete = CASCADE
                )})
public class GameCharacterEntity {
    @PrimaryKey
    private int characterID;

    private int userID;
    private int gameID;
    private String characterName;
    private String characterInfo;
    private String characterStory;
    private int balance;
    private String notes;

    private static final String TAG = "GameCharacterEntity";

    public GameCharacterEntity(int userID, int characterID, int gameID, String characterName, String characterInfo, String characterStory, int balance, String notes){
        if(userID < 0){
            throw new NullPointerException("User ID must be greater than 0");
        }else if (characterID < 0){
            throw new NullPointerException("Character ID must be greater than 0");
        }else if (gameID < 0){
            throw new NullPointerException("Game ID must be greater than 0");
        }else if(characterName == null){
            throw new NullPointerException("Character name must be greater than 0");
        }else if(characterInfo == null){
            throw new NullPointerException("Character info must be greater than 0");
        }else if(characterStory == null){
            throw new NullPointerException("Character story must be greater than 0");
        }else {
            this.userID = userID;
            this.characterID = characterID;
            this.gameID = gameID;
            this.characterName = characterName;
            this.characterInfo = characterInfo;
            this.characterStory = characterStory;
            this.balance = balance;
            this.notes = notes;
        }
    }

    //getters
    public int getUserID() {
        return userID;
    }
    public int getCharacterID() {
        return characterID;
    }
    public int getGameID() {
        return gameID;
    }
    public String getCharacterName() {
        return characterName;
    }
    public String getCharacterInfo() {
        return characterInfo;
    }
    public String getCharacterStory() {
        return characterStory;
    }
    public int getBalance() {
        return balance;
    }
    public String getNotes() {
        return notes;
    }

    //setters
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public void setCharacterID(int characterID) {
        this.characterID = characterID;
    }
    public void setGameID(int gameID) {
        this.gameID = gameID;
    }
    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }
    public void setCharacterInfo(String characterInfo) {
        this.characterInfo = characterInfo;
    }
    public void setCharacterStory(String characterStory) {
        this.characterStory = characterStory;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
