package com.example.dgrove.rpgassistant.DB.Entities;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(
        indices = {@Index("gameID")},
        foreignKeys = {
        @ForeignKey(
                entity = GameEntity.class,
                parentColumns = "gameID",
                childColumns = "gameID",
                onDelete = CASCADE
        )})
public class GameSkillsEntity {
    @PrimaryKey
    private int skillID;
    private int gameID;
    private String skillName;

    public GameSkillsEntity(int skillID, int gameID, @NonNull String skillName) {
        if(skillID < 0) {
            throw new NullPointerException("Skill ID is null");
        } else if(gameID < 0) {
            throw new NullPointerException("Game ID is null");
        } else {
            this.skillID = skillID;
            this.gameID = gameID;
            this.skillName = skillName;
        }
    }

    // Getters

    public int getSkillID() {
        return skillID;
    }

    public int getGameID() {
        return skillID;
    }

    public String getSkillName() {
        return skillName;
    }

    // Setters

    public void setSkillID(int skillID) {
        this.skillID = skillID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
