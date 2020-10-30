package com.example.dgrove.rpgassistant.DB.ViewModels;


import android.app.Application;

import com.example.dgrove.rpgassistant.DB.Entities.CharacterSkillsEntity;
import com.example.dgrove.rpgassistant.DB.Repositories.CharacterSkillRepository;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class CharacterSkillViewModel extends AndroidViewModel {
    private CharacterSkillRepository characterSkillRepository;
    private LiveData<List<CharacterSkillsEntity>> allCharacterSkills;

    public CharacterSkillViewModel(Application application) {
        super(application);
        characterSkillRepository = new CharacterSkillRepository(application);
        allCharacterSkills = characterSkillRepository.getAllCharacterSkills();
    }

    public void insert(CharacterSkillsEntity characterSkills) {
        characterSkillRepository.insert(characterSkills);
    }

    public void update(CharacterSkillsEntity characterSkills) {
        characterSkillRepository.update(characterSkills);
    }

    public void delete(CharacterSkillsEntity characterSkills) {
        characterSkillRepository.delete(characterSkills);
    }

    public LiveData<List<CharacterSkillsEntity>> getAllCharacterSkills() {
        return allCharacterSkills;
    }

    public CharacterSkillsEntity getSkillsByID(int skillID){
        return characterSkillRepository.getSkillsByID(skillID);
    }
}
