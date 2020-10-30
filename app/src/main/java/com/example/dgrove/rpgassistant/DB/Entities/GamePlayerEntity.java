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
public class GamePlayerEntity {
    @PrimaryKey
    private int gpID;
    private int gameID;
    private int userID;

    private static final String TAG = "GamePlayerEntity";

    public GamePlayerEntity(int gpID, int gameID, int userID){
        if(gpID < 0){
            throw new NullPointerException("Player ID must be greater than 0");
        }else if(gameID < 0){
            throw new NullPointerException("Game ID must be greater than 0");
        }else if(userID < 0){
            throw new NullPointerException("User ID must be greater than 0");
        }else{
            this.gpID = gpID;
            this.gameID = gameID;
            this.userID = userID;
        }
    }

    // Getters

    public int getGpID(){
        return gpID;
    }

    public int getGameID() {
        return gameID;
    }

    public int getUserID(){
        return userID;
    }

    // Setters


    public void setGpID(int gpID) {
        this.gpID = gpID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
