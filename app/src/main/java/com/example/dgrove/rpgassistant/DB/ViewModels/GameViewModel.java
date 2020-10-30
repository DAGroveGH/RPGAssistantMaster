package com.example.dgrove.rpgassistant.DB.ViewModels;

import android.app.Application;

import com.example.dgrove.rpgassistant.DB.Entities.GameEntity;
import com.example.dgrove.rpgassistant.DB.Repositories.GameRepository;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class GameViewModel extends AndroidViewModel {
    private GameRepository gameRepository;
    private LiveData<List<GameEntity>> allGames;
    //private int[] allGameIDs;
    //private LiveData<List<GameEntity>> allOwnedGames;


    public GameViewModel(Application application) {
        super(application);
        gameRepository = new GameRepository(application);
        allGames = gameRepository.getAllGames();
        //allOwnedGames = gameRepository.getOwnedGames(allGameIDs);
    }

    public void insert(GameEntity game) {
        gameRepository.insert(game);
    }

    public void update(GameEntity game) {
        gameRepository.update(game);
    }

    public void delete(GameEntity game) {
        gameRepository.delete(game);
    }

    public LiveData<List<GameEntity>> getAllGames() {
        return allGames;
    }

    //public LiveData<List<GameEntity>> getAllOwnedGames() { return allOwnedGames; }

    /*public int[] getAllGameIDs() {
        return allGameIDs;
    }*/

    public int[] getGameIDs() {return gameRepository.getGameIDs();}

    public GameEntity getGameByID(int gameID){
        return gameRepository.getGameByID(gameID);
    }

    /*public LiveData<List<GameEntity>> getOwnedGames(int[] gameID){
        return gameRepository.getOwnedGames(gameID);
    }*/

    public LiveData<List<GameEntity>> loadAllGames() { return gameRepository.loadAllGames(); }

    public String[] getAllGameNames() {
        return gameRepository.getAllGameNames();
    }

}
