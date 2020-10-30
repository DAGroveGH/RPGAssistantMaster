package com.example.dgrove.rpgassistant.DB.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import com.example.dgrove.rpgassistant.DB.DAOs.GamePlayerDAO;
import com.example.dgrove.rpgassistant.DB.Entities.GameEntity;
import com.example.dgrove.rpgassistant.DB.Entities.GamePlayerEntity;
import com.example.dgrove.rpgassistant.DB.RPGAssistantDB;

import java.util.List;

import androidx.lifecycle.LiveData;

public class GamePlayerRepository {
    private GamePlayerDAO gamePlayerDAO;
    LiveData<List<GamePlayerEntity>> allGamePlayers;

    public GamePlayerRepository(Application application){
        RPGAssistantDB db = RPGAssistantDB.getDatabase(application);
        gamePlayerDAO = db.gamePlayerDAO();
    }

    public void insert(GamePlayerEntity game){
        new InsertGameAsyncTask(gamePlayerDAO).execute(game);
    }

    public void update(GamePlayerEntity game){
        new UpdateGameAsyncTask(gamePlayerDAO).execute(game);
    }

    public void delete(GamePlayerEntity game){
        new DeleteGameAsyncTask(gamePlayerDAO).execute(game);
    }

    public LiveData<List<GamePlayerEntity>> getAllGamePlayers(){
        return allGamePlayers;
    }

    public GameEntity getGameByID(int gameID){
        return gamePlayerDAO.getGameByID(gameID);
    }

    public GamePlayerEntity getAllGamePlayerByID(int playerID){
        return gamePlayerDAO.getAllGamePlayerByID(playerID);
    }

    private static class InsertGameAsyncTask extends AsyncTask<GamePlayerEntity, Void, Void> {
        private GamePlayerDAO gamePlayerDAO;

        private InsertGameAsyncTask(GamePlayerDAO gamePlayerDAO){
            this.gamePlayerDAO = gamePlayerDAO;
        }

        @Override
        protected Void doInBackground(GamePlayerEntity... gamePlayers){
            gamePlayerDAO.insertGamePlayer(gamePlayers[0]);
            return null;
        }
    }

    private static class UpdateGameAsyncTask extends AsyncTask<GamePlayerEntity, Void, Void> {
        private GamePlayerDAO gamePlayerDAO;

        private UpdateGameAsyncTask(GamePlayerDAO gamePlayerDAO){
            this.gamePlayerDAO = gamePlayerDAO;
        }

        @Override
        protected Void doInBackground(GamePlayerEntity... gamePlayers){
            gamePlayerDAO.updateGamePlayer(gamePlayers[0]);
            return null;
        }
    }

    private static class DeleteGameAsyncTask extends AsyncTask<GamePlayerEntity, Void, Void>{
        private GamePlayerDAO gamePlayerDAO;

        private DeleteGameAsyncTask(GamePlayerDAO gamePlayerDAO){
            this.gamePlayerDAO = gamePlayerDAO;
        }

        @Override
        protected Void doInBackground(GamePlayerEntity... gamePlayers){
            gamePlayerDAO.deleteGamePlayer(gamePlayers[0]);
            return null;
        }
    }
}
