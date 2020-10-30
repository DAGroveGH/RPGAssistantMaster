package com.example.dgrove.rpgassistant.DB.ViewModels;

import android.app.Application;

import com.example.dgrove.rpgassistant.DB.Entities.GameSettingsEntity;
import com.example.dgrove.rpgassistant.DB.Repositories.GameSettingsRepository;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class GameSettingsViewModel extends AndroidViewModel {
    private GameSettingsRepository gameSettingsRepository;
    private LiveData<List<GameSettingsEntity>> allGameSettings;

    public GameSettingsViewModel(Application application) {
        super(application);
        gameSettingsRepository = new GameSettingsRepository(application);
        allGameSettings = gameSettingsRepository.getAllGameSettings();
    }

    public void insert(GameSettingsEntity gameSettings) {
        gameSettingsRepository.insert(gameSettings);
    }

    public void update(GameSettingsEntity gameSettings) {
        gameSettingsRepository.update(gameSettings);
    }

    public void delete(GameSettingsEntity gameSettings) {
        gameSettingsRepository.delete(gameSettings);
    }

    public LiveData<List<GameSettingsEntity>> getAllGameSettings() {
        return allGameSettings;
    }
}
