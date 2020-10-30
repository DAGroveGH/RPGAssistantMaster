package com.example.dgrove.rpgassistant.DB.Entities;


import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

import static androidx.room.ForeignKey.CASCADE;

@Entity(
        indices = {@Index("gameID")},
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
        )},
        primaryKeys = {"userID", "gameID"})
public class GameSettingsEntity {
    private int userID;
    private int gameID;
    private boolean allowViewCharacters;
    private boolean allowInvite;
    private boolean viewBalance;
    private boolean transferItems;
    private boolean transferMoney;
    private boolean customSkillLevels;

    public GameSettingsEntity (int userID, int gameID, boolean allowViewCharacters, boolean allowInvite, boolean viewBalance,
                               boolean transferItems, boolean transferMoney, boolean customSkillLevels) {
        if(userID < 0) {
            throw new NullPointerException("User ID is null");
        } else if(gameID < 0) {
            throw new NullPointerException("Game ID is null");
        } else {
            this.userID = userID;
            this.gameID = gameID;
            this.allowViewCharacters = allowViewCharacters;
            this.allowInvite = allowInvite;
            this.viewBalance = viewBalance;
            this.transferItems = transferItems;
            this.transferMoney = transferMoney;
            this.customSkillLevels = customSkillLevels;
        }
    }

    // Getters

    public int getUserID () {
        return userID;
    }

    public int getGameID () {
        return gameID;
    }

    public boolean isAllowViewCharacters() {
        return allowViewCharacters;
    }

    public boolean isAllowInvite() {
        return allowInvite;
    }

    public boolean isViewBalance() {
        return viewBalance;
    }

    public boolean isTransferItems() {
        return transferItems;
    }

    public boolean isTransferMoney() {
        return transferMoney;
    }

    public boolean isCustomSkillLevels() {
        return customSkillLevels;
    }

    // Setters

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public void setAllowViewCharacters(boolean allowViewCharacters) {
        this.allowViewCharacters = allowViewCharacters;
    }

    public void setAllowInvite(boolean allowInvite) {
        this.allowInvite = allowInvite;
    }

    public void setViewBalance(boolean viewBalance) {
        this.viewBalance = viewBalance;
    }

    public void setTransferItems(boolean transferItems) {
        this.transferItems = transferItems;
    }

    public void setTransferMoney(boolean transferMoney) {
        this.transferMoney = transferMoney;
    }

    public void setCustomSkillLevels(boolean customSkillLevels) {
        this.customSkillLevels = customSkillLevels;
    }
}
