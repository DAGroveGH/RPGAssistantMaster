package com.example.dgrove.rpgassistant.DB.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import com.example.dgrove.rpgassistant.DB.DAOs.CharacterSkillDAO;
import com.example.dgrove.rpgassistant.DB.Entities.CharacterSkillsEntity;
import com.example.dgrove.rpgassistant.DB.RPGAssistantDB;

import java.util.List;

import androidx.lifecycle.LiveData;

public class CharacterSkillRepository {
    private CharacterSkillDAO characterSkillDAO;
    LiveData<List<CharacterSkillsEntity>> allCharacterSkills;

    public CharacterSkillRepository(Application application){
        RPGAssistantDB db = RPGAssistantDB.getDatabase(application);
        characterSkillDAO = db.characterSkillDAO();
        allCharacterSkills = characterSkillDAO.loadAllCharacterSkills();
    }

    public void insert(CharacterSkillsEntity characterSkills){
        new InsertCharacterSkillsAsyncTask(characterSkillDAO).execute(characterSkills);
    }

    public void update(CharacterSkillsEntity characterSkills){
        new UpdateCharacterSkillsAsyncTask(characterSkillDAO).execute(characterSkills);
    }

    public void delete(CharacterSkillsEntity characterSkills){
        new DeleteCharacterSkillsAsyncTask(characterSkillDAO).execute(characterSkills);
    }

    public LiveData<List<CharacterSkillsEntity>> getAllCharacterSkills(){
        return allCharacterSkills;
    }

    public CharacterSkillsEntity getSkillsByID(int skillID){
        return characterSkillDAO.getSkillsByID(skillID);
    }

    private static class InsertCharacterSkillsAsyncTask extends AsyncTask<CharacterSkillsEntity, Void, Void> {
        private CharacterSkillDAO characterSkillDAO;

        private InsertCharacterSkillsAsyncTask(CharacterSkillDAO characterSkillDAO){
            this.characterSkillDAO = characterSkillDAO;
        }

        @Override
        protected Void doInBackground(CharacterSkillsEntity... characterSkills){
            characterSkillDAO.insertCharacterSkill(characterSkills[0]);
            return null;
        }
    }

    private static class UpdateCharacterSkillsAsyncTask extends AsyncTask<CharacterSkillsEntity, Void, Void> {
        private CharacterSkillDAO characterSkillDAO;

        private UpdateCharacterSkillsAsyncTask(CharacterSkillDAO characterSkillDAO){
            this.characterSkillDAO = characterSkillDAO;
        }

        @Override
        protected Void doInBackground(CharacterSkillsEntity... characterSkills){
            characterSkillDAO.updateCharacterSkills(characterSkills[0]);
            return null;
        }
    }

    private static class DeleteCharacterSkillsAsyncTask extends AsyncTask<CharacterSkillsEntity, Void, Void> {
        private CharacterSkillDAO characterSkillDAO;

        private DeleteCharacterSkillsAsyncTask(CharacterSkillDAO characterSkillDAO){
            this.characterSkillDAO = characterSkillDAO;
        }

        @Override
        protected Void doInBackground(CharacterSkillsEntity... characterSkills){
            characterSkillDAO.deleteCharacterSkills(characterSkills[0]);
            return null;
        }
    }
}