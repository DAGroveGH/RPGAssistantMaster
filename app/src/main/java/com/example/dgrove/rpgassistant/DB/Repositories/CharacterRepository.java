package com.example.dgrove.rpgassistant.DB.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import com.example.dgrove.rpgassistant.DB.DAOs.CharacterListDAO;
import com.example.dgrove.rpgassistant.DB.Entities.GameCharacterEntity;
import com.example.dgrove.rpgassistant.DB.RPGAssistantDB;

import java.util.List;

import androidx.lifecycle.LiveData;

public class CharacterRepository {
    private CharacterListDAO characterListDAO;
    LiveData<List<GameCharacterEntity>> allGameCharacters;

    public CharacterRepository(Application application){
        RPGAssistantDB db = RPGAssistantDB.getDatabase(application);
        characterListDAO = db.characterListDAO();
        allGameCharacters = characterListDAO.loadAllCharacters();
    }

    public void insert(GameCharacterEntity character){
        new InsertCharacterAsyncTask(characterListDAO).execute(character);
    }
    public void update(GameCharacterEntity character){
        new UpdateCharacterAsyncTask(characterListDAO).execute(character);
    }

    public void delete(GameCharacterEntity character){
        new DeleteCharacterAsyncTask(characterListDAO).execute(character);
    }

    public LiveData<List<GameCharacterEntity>> getAllGameCharacters(){
        return allGameCharacters;
    }

    public GameCharacterEntity getCharactersByID(int characterID){
        return characterListDAO.getCharactersByID(characterID);
    }

    private static class InsertCharacterAsyncTask extends AsyncTask<GameCharacterEntity, Void, Void> {
        private CharacterListDAO characterListDAO;

        private InsertCharacterAsyncTask(CharacterListDAO characterListDAO){
            this.characterListDAO = characterListDAO;
        }

        @Override
        protected Void doInBackground(GameCharacterEntity... characters){
            characterListDAO.insertNewCharacter(characters[0]);
            return null;
        }
    }
    private static class UpdateCharacterAsyncTask extends AsyncTask<GameCharacterEntity, Void, Void> {
        private CharacterListDAO characterListDAO;

        private UpdateCharacterAsyncTask(CharacterListDAO characterListDAO){
            this.characterListDAO = characterListDAO;
        }

        @Override
        protected Void doInBackground(GameCharacterEntity... characters){
            characterListDAO.updateCharacter(characters[0]);
            return null;
        }
    }
    private static class DeleteCharacterAsyncTask extends AsyncTask<GameCharacterEntity, Void, Void> {
        private CharacterListDAO characterListDAO;

        private DeleteCharacterAsyncTask(CharacterListDAO characterListDAO){
            this.characterListDAO = characterListDAO;
        }

        @Override
        protected Void doInBackground(GameCharacterEntity... characters){
            characterListDAO.deleteCharacter(characters[0]);
            return null;
        }
    }
}