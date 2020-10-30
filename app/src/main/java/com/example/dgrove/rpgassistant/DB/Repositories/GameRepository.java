package com.example.dgrove.rpgassistant.DB.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import com.example.dgrove.rpgassistant.DB.DAOs.GameListDAO;
import com.example.dgrove.rpgassistant.DB.Entities.GameEntity;
import com.example.dgrove.rpgassistant.DB.RPGAssistantDB;

import java.util.List;

import androidx.lifecycle.LiveData;

public class GameRepository {
    private GameListDAO gameListDAO;
    LiveData<List<GameEntity>> allGames;

    public GameRepository(Application application){
        RPGAssistantDB db = RPGAssistantDB.getDatabase(application);
        gameListDAO = db.gameListDAO();
        allGames = gameListDAO.loadAllGameEntities();
    }

    public void insert(GameEntity game){
        new InsertGameAsyncTask(gameListDAO).execute(game);
    }

    public void update(GameEntity game){
        new UpdateGameAsyncTask(gameListDAO).execute(game);
    }

    public void delete(GameEntity game){
        new DeleteGameAsyncTask(gameListDAO).execute(game);
    }

    public LiveData<List<GameEntity>> getAllGames(){
        return allGames;
    }

    public GameEntity getGameByID (int gameID){
        return gameListDAO.getGameEntityByID(gameID);
    }

    /*public LiveData<List<GameEntity>> getOwnedGames(int[] gameID){
        return gameListDAO.getOwnedGameEntities(gameID);
    }*/

    public int[] getGameIDs() {return gameListDAO.getAllGameIDs();}

    public LiveData<List<GameEntity>> loadAllGames(){ return gameListDAO.loadAllGameEntities(); }

    public String[] getAllGameNames(){ return gameListDAO.getAllGameEntityNames(); }

    private static class InsertGameAsyncTask extends AsyncTask<GameEntity, Void, Void>{
        private GameListDAO gameListDAO;

        private InsertGameAsyncTask(GameListDAO gameListDAO){
            this.gameListDAO = gameListDAO;
        }

        @Override
        protected Void doInBackground(GameEntity... games){
            gameListDAO.insertGameEntity(games[0]);
            return null;
        }
    }

    private static class UpdateGameAsyncTask extends AsyncTask<GameEntity, Void, Void> {
        private GameListDAO gameListDAO;

        private UpdateGameAsyncTask(GameListDAO gameListDAO){
            this.gameListDAO = gameListDAO;
        }

        @Override
        protected Void doInBackground(GameEntity... games){
            gameListDAO.updateGameEntity(games[0]);
            return null;
        }
    }

    private static class DeleteGameAsyncTask extends AsyncTask<GameEntity, Void, Void> {
        private GameListDAO gameListDAO;

        private DeleteGameAsyncTask(GameListDAO gameListDAO){
            this.gameListDAO = gameListDAO;
        }

        @Override
        protected Void doInBackground(GameEntity... games){
            gameListDAO.deleteGameEntity(games[0]);
            return null;
        }
    }
}
