package com.example.dgrove.rpgassistant.DB.ViewModels;

import android.app.Application;

import com.example.dgrove.rpgassistant.DB.Entities.GameSkillsEntity;
import com.example.dgrove.rpgassistant.DB.Repositories.GameSkillRepository;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class GameSkillViewModel extends AndroidViewModel {
    private GameSkillRepository gameSkillRepository;
    private LiveData<List<GameSkillsEntity>> allGameSkills;

    public GameSkillViewModel (Application application){
        super(application);
        gameSkillRepository = new GameSkillRepository(application);
        allGameSkills = gameSkillRepository.getAllGameSkills();
    }

    public void insert(GameSkillsEntity gameSkills) {
        gameSkillRepository.insert(gameSkills);
    }

    public void update(GameSkillsEntity gameSkills){
        gameSkillRepository.update(gameSkills);
    }

    public void delete(GameSkillsEntity gameSkills){
        gameSkillRepository.delete(gameSkills);
    }

    public LiveData<List<GameSkillsEntity>> getAllGameSkills() {
        return allGameSkills;
    }

    public GameSkillsEntity getGameSkill(int skillID) {
        return gameSkillRepository.getGameSkill(skillID);
    }
}
