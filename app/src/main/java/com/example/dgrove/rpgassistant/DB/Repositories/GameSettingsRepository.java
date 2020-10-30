package com.example.dgrove.rpgassistant.DB.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import com.example.dgrove.rpgassistant.DB.DAOs.GameSettingsDAO;
import com.example.dgrove.rpgassistant.DB.Entities.GameSettingsEntity;
import com.example.dgrove.rpgassistant.DB.RPGAssistantDB;

import java.util.List;

import androidx.lifecycle.LiveData;

public class GameSettingsRepository {
    private GameSettingsDAO gameSettingsDAO;
    LiveData<List<GameSettingsEntity>> allGameSettings;

    public GameSettingsRepository(Application application){
        RPGAssistantDB db = RPGAssistantDB.getDatabase(application);
        gameSettingsDAO = db.gameSettingsDAO();
    }

    public void insert(GameSettingsEntity gameSettings){
        new InsertGameSettingAsyncTask(gameSettingsDAO).execute(gameSettings);
    }

    public void update(GameSettingsEntity gameSettings){
        new UpdateGameSettingAsyncTask(gameSettingsDAO).execute(gameSettings);
    }

    public void delete(GameSettingsEntity gameSettings){
        new DeleteGameSettingAsyncTask(gameSettingsDAO).execute(gameSettings);
    }

    public LiveData<List<GameSettingsEntity>> getAllGameSettings(){
        return allGameSettings;
    }



    private static class InsertGameSettingAsyncTask extends AsyncTask<GameSettingsEntity, Void, Void> {
        private GameSettingsDAO gameSettingsDAO;

        private InsertGameSettingAsyncTask(GameSettingsDAO gameSettingsDAO){
            this.gameSettingsDAO = gameSettingsDAO;
        }

        @Override
        protected Void doInBackground(GameSettingsEntity... gameSettings){
            gameSettingsDAO.insertGameSettings(gameSettings[0]);
            return null;
        }
    }

    private static class UpdateGameSettingAsyncTask extends AsyncTask<GameSettingsEntity, Void, Void> {
        private GameSettingsDAO gameSettingsDAO;

        private UpdateGameSettingAsyncTask(GameSettingsDAO gameSettingsDAO){
            this.gameSettingsDAO = gameSettingsDAO;
        }

        @Override
        protected Void doInBackground(GameSettingsEntity... gameSettings){
            gameSettingsDAO.updateGameSettings(gameSettings[0]);
            return null;
        }
    }

    private static class DeleteGameSettingAsyncTask extends AsyncTask<GameSettingsEntity, Void, Void> {
        private GameSettingsDAO gameSettingsDAO;

        private DeleteGameSettingAsyncTask(GameSettingsDAO gameSettingsDAO){
            this.gameSettingsDAO = gameSettingsDAO;
        }

        @Override
        protected Void doInBackground(GameSettingsEntity... gameSettings){
            gameSettingsDAO.deleteGameSettings(gameSettings[0]);
            return null;
        }
    }
}
