package com.example.dgrove.rpgassistant.DB.ViewModels;

import android.app.Application;

import com.example.dgrove.rpgassistant.DB.Entities.GameEntity;
import com.example.dgrove.rpgassistant.DB.Entities.GamePlayerEntity;
import com.example.dgrove.rpgassistant.DB.Repositories.GamePlayerRepository;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class GamePlayerViewModel extends AndroidViewModel {
    private GamePlayerRepository gamePlayerRepository;
    private LiveData<List<GamePlayerEntity>> allGamePlayers;

    public GamePlayerViewModel (Application application){
        super(application);
        gamePlayerRepository = new GamePlayerRepository(application);
        allGamePlayers = gamePlayerRepository.getAllGamePlayers();
    }

    public void insert(GamePlayerEntity gamePlayer){
        gamePlayerRepository.insert(gamePlayer);
    }

    public void update(GamePlayerEntity gamePlayer){
        gamePlayerRepository.update(gamePlayer);
    }

    public void delete(GamePlayerEntity gamePlayer){
        gamePlayerRepository.delete(gamePlayer);
    }

    public LiveData<List<GamePlayerEntity>> getAllGamePlayers(){
        return allGamePlayers;
    }

    public GameEntity getGameByID(int gameID){
        return gamePlayerRepository.getGameByID(gameID);
    }

    public GamePlayerEntity getAllGamePlayersByID(int playerID){
        return gamePlayerRepository.getAllGamePlayerByID(playerID);
    }

}
