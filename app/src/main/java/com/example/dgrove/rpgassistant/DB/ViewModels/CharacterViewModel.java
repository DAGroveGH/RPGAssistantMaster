package com.example.dgrove.rpgassistant.DB.ViewModels;

import android.app.Application;

import com.example.dgrove.rpgassistant.DB.Entities.GameCharacterEntity;
import com.example.dgrove.rpgassistant.DB.Repositories.CharacterRepository;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class CharacterViewModel extends AndroidViewModel {
    private CharacterRepository characterRepository;
    private LiveData<List<GameCharacterEntity>> allGameCharacter;

    public CharacterViewModel(Application application) {
        super(application);
        characterRepository = new CharacterRepository(application);
        allGameCharacter = characterRepository.getAllGameCharacters();
    }

    public void insert(GameCharacterEntity character) {
        characterRepository.insert(character);
    }

    public void update(GameCharacterEntity character) {
        characterRepository.update(character);
    }

    public void delete(GameCharacterEntity character) {
        characterRepository.delete(character);
    }

    public LiveData<List<GameCharacterEntity>> getAllGameCharacter() {
        return allGameCharacter;
    }

    public GameCharacterEntity getCharactersByID(int characterID){
        return characterRepository.getCharactersByID(characterID);
    }
}
