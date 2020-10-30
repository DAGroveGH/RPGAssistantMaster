package com.example.dgrove.rpgassistant.DB.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import com.example.dgrove.rpgassistant.DB.DAOs.InventoryDAO;
import com.example.dgrove.rpgassistant.DB.Entities.CharacterInventoryEntity;
import com.example.dgrove.rpgassistant.DB.RPGAssistantDB;

import java.util.List;

import androidx.lifecycle.LiveData;

public class InventoryRepository {
    private InventoryDAO inventoryDAO;
    LiveData<List<CharacterInventoryEntity>> allCharacterInventory;

    public InventoryRepository(Application application){
        RPGAssistantDB db = RPGAssistantDB.getDatabase(application);
        inventoryDAO = db.inventoryDAO();
    }

    public void insert(CharacterInventoryEntity characterInventory){
        new InsertCharacterAsyncTask(inventoryDAO).execute(characterInventory);
    }
    public void update(CharacterInventoryEntity characterInventory){
        new UpdateCharacterAsyncTask(inventoryDAO).execute(characterInventory);
    }

    public void delete(CharacterInventoryEntity characterInventory){
        new DeleteCharacterAsyncTask(inventoryDAO).execute(characterInventory);
    }

    public LiveData<List<CharacterInventoryEntity>> getAllCharacterInventory(){
        return allCharacterInventory;
    }

    public CharacterInventoryEntity getAllItemsByID(int itemIDs){
        return inventoryDAO.getAllItemsByID(itemIDs);
    }

    public CharacterInventoryEntity[] getAllTradableItems(){
        return inventoryDAO.getAllTradableItems();
    }

    private static class InsertCharacterAsyncTask extends AsyncTask<CharacterInventoryEntity, Void, Void> {
        private InventoryDAO inventoryDAO;

        private InsertCharacterAsyncTask(InventoryDAO inventoryDAO){
            this.inventoryDAO = inventoryDAO;
        }

        @Override
        protected Void doInBackground(CharacterInventoryEntity... characterInventorys){
            inventoryDAO.insertInventory(characterInventorys[0]);
            return null;
        }
    }
    private static class UpdateCharacterAsyncTask extends AsyncTask<CharacterInventoryEntity, Void, Void> {
        private InventoryDAO inventoryDAO;

        private UpdateCharacterAsyncTask(InventoryDAO inventoryDAO){
            this.inventoryDAO = inventoryDAO;
        }

        @Override
        protected Void doInBackground(CharacterInventoryEntity... characterInventorys){
            inventoryDAO.updateInventory(characterInventorys[0]);
            return null;
        }
    }
    private static class DeleteCharacterAsyncTask extends AsyncTask<CharacterInventoryEntity, Void, Void> {
        private InventoryDAO inventoryDAO;

        private DeleteCharacterAsyncTask(InventoryDAO inventoryDAO){
            this.inventoryDAO = inventoryDAO;
        }

        @Override
        protected Void doInBackground(CharacterInventoryEntity... characterInventorys){
            inventoryDAO.deleteInventory(characterInventorys[0]);
            return null;
        }
    }
}