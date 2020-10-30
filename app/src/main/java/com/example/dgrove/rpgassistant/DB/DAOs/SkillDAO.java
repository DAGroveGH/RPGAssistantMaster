package com.example.dgrove.rpgassistant.DB.DAOs;

import com.example.dgrove.rpgassistant.DB.Entities.GameSkillsEntity;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface SkillDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertSkill(GameSkillsEntity gameSkills);

    @Update
    public void updateSkills(GameSkillsEntity gameSkills);

    @Delete
    public void deleteSkill(GameSkillsEntity gameSkills);

    @Query("SELECT * FROM GameSkillsEntity WHERE skillID IN (:skillIDs)")
    public GameSkillsEntity getSkill(int skillIDs);

    @Query("SELECT * FROM GameSkillsEntity")
    public LiveData<List<GameSkillsEntity>> loadAllGameSkills();
}
