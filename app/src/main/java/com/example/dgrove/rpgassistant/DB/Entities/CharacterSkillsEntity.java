package com.example.dgrove.rpgassistant.DB.Entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = {
        @ForeignKey(
                entity = GameSkillsEntity.class,
                parentColumns = "skillID",
                childColumns = "skillID",
                onDelete = CASCADE
        )})
public class CharacterSkillsEntity {
    @PrimaryKey
    private int skillID;

    private int currentPointValue;
    private int currentLevel;

    private static final String TAG = "CharacterSkillsEntity";

    public CharacterSkillsEntity(int skillID, int currentPointValue, int currentLevel){
        if(skillID < 0){
            throw new NullPointerException("Skill ID must be greater than 0");
        }else if(currentPointValue < 0){
            throw new NullPointerException("Point Value must be greater than 0");
        }else if(currentLevel < 0){
            throw new NullPointerException("Level must be greater than 0");
        }else{
            this.skillID = skillID;
            this.currentPointValue = currentPointValue;
            this.currentLevel = currentLevel;
        }
    }

    //getters
    public int getSkillID() {
        return skillID;
    }
    public int getCurrentPointValue() {
        return currentPointValue;
    }
    public int getCurrentLevel() {
        return currentLevel;
    }

    //setters
    public void setSkillID(int skillID) {
        this.skillID = skillID;
    }
    public void setCurrentPointValue(int currentPointValue) {
        this.currentPointValue = currentPointValue;
    }
    public void setCurrentLevel(int currentLevel){
        this.currentLevel = currentLevel;
    }
}
