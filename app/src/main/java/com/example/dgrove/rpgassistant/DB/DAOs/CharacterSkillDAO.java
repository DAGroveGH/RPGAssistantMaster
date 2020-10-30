package com.example.dgrove.rpgassistant.DB.DAOs;

import com.example.dgrove.rpgassistant.DB.Entities.CharacterSkillsEntity;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface CharacterSkillDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertCharacterSkill(CharacterSkillsEntity characterSkills);

    @Update
    public void updateCharacterSkills(CharacterSkillsEntity characterSkills);

    @Delete
    public void deleteCharacterSkills(CharacterSkillsEntity characterSkills);

    @Query("SELECT * FROM CharacterSkillsEntity WHERE skillID IN (:skillIDs)")
    public CharacterSkillsEntity getSkillsByID(int skillIDs);

    @Query("SELECT * FROM CharacterSkillsEntity")
    public LiveData<List<CharacterSkillsEntity>> loadAllCharacterSkills();
}