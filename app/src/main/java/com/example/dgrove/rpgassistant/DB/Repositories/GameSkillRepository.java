package com.example.dgrove.rpgassistant.DB.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import com.example.dgrove.rpgassistant.DB.DAOs.SkillDAO;
import com.example.dgrove.rpgassistant.DB.Entities.GameSkillsEntity;
import com.example.dgrove.rpgassistant.DB.RPGAssistantDB;

import java.util.List;

import androidx.lifecycle.LiveData;

public class GameSkillRepository {
    private SkillDAO skillDAO;
    LiveData<List<GameSkillsEntity>> allGameSkills;

    public GameSkillRepository(Application application){
        RPGAssistantDB db = RPGAssistantDB.getDatabase(application);
        skillDAO = db.skillDAO();
        allGameSkills = skillDAO.loadAllGameSkills();
    }

    public void insert(GameSkillsEntity gameSkills){
        new InsertGameSkillAsyncTask(skillDAO).execute(gameSkills);
    }

    public void update(GameSkillsEntity gameSkills){
        new UpdateGameSkillAsyncTask(skillDAO).execute(gameSkills);
    }

    public void delete(GameSkillsEntity gameSkills){
        new DeleteGameSkillAsyncTask(skillDAO).execute(gameSkills);
    }

    public LiveData<List<GameSkillsEntity>> getAllGameSkills(){
        return allGameSkills;
    }

    public GameSkillsEntity getGameSkill(int skillID){
        return skillDAO.getSkill(skillID);
    }

    private static class InsertGameSkillAsyncTask extends AsyncTask<GameSkillsEntity, Void, Void> {
        private SkillDAO skillDAO;

        private InsertGameSkillAsyncTask(SkillDAO skillDAO){
            this.skillDAO = skillDAO;
        }

        @Override
        protected Void doInBackground(GameSkillsEntity... gameSkills){
            skillDAO.insertSkill(gameSkills[0]);
            return null;
        }
    }

    private static class UpdateGameSkillAsyncTask extends AsyncTask<GameSkillsEntity, Void, Void> {
        private SkillDAO skillDAO;

        private UpdateGameSkillAsyncTask(SkillDAO skillDAO){
            this.skillDAO = skillDAO;
        }

        @Override
        protected Void doInBackground(GameSkillsEntity... gameSkills){
            skillDAO.updateSkills(gameSkills[0]);
            return null;
        }
    }

    private static class DeleteGameSkillAsyncTask extends AsyncTask<GameSkillsEntity, Void, Void>{
        private SkillDAO skillDAO;

        private DeleteGameSkillAsyncTask(SkillDAO skillDAO){
            this.skillDAO = skillDAO;
        }

        @Override
        protected Void doInBackground(GameSkillsEntity... gameSkills){
            skillDAO.deleteSkill(gameSkills[0]);
            return null;
        }
    }
}
