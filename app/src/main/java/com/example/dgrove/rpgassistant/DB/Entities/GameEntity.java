package com.example.dgrove.rpgassistant.DB.Entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(
        indices = {@Index("ownerID")},
        foreignKeys = @ForeignKey(
                entity = UserEntity.class,
                parentColumns = "userID",
                childColumns = "ownerID",
                onDelete = CASCADE))
public class GameEntity {
    @PrimaryKey (autoGenerate = true)
    private int gameID;

    private int ownerID;
    private String gameName;

    private static final String TAG = "GameEntity";

    public GameEntity(int gameID, int ownerID, @NonNull String gameName){
        if(ownerID < 0){
            throw new NullPointerException("Owner ID must be greater than 0");
        }else{
            this.gameName = gameName;
            this.ownerID = ownerID;
        }
    }

    //Getters
    public int getGameID(){
        return gameID;
    }
    public int getOwnerID(){
        return ownerID;
    }
    public String getGameName(){
        return gameName;
    }

    //setters
    public void setGameID(int gameID) {
        this.gameID = gameID;
    }
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }
}
