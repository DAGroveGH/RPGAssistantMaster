package com.example.dgrove.rpgassistant.DB.ViewModels;

import android.app.Application;

import com.example.dgrove.rpgassistant.DB.Entities.CharacterInventoryEntity;
import com.example.dgrove.rpgassistant.DB.Repositories.InventoryRepository;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class InventoryViewModel extends AndroidViewModel {
    private InventoryRepository inventoryRepository;
    private LiveData<List<CharacterInventoryEntity>> allCharacterInventory;

    public InventoryViewModel (Application application){
        super(application);
        inventoryRepository = new InventoryRepository(application);
        allCharacterInventory = inventoryRepository.getAllCharacterInventory();
    }

    public void insert(CharacterInventoryEntity characterInventory) {
        inventoryRepository.insert(characterInventory);
    }

    public void update(CharacterInventoryEntity characterInventory){
        inventoryRepository.update(characterInventory);
    }

    public void delete(CharacterInventoryEntity characterInventory){
        inventoryRepository.delete(characterInventory);
    }

    public LiveData<List<CharacterInventoryEntity>> getAllCharacterInventory() {
        return allCharacterInventory;
    }

    public CharacterInventoryEntity getAllItemsByID(int itemIDs){
        return inventoryRepository.getAllItemsByID(itemIDs);
    }

    public CharacterInventoryEntity[] getAllTradableItems(){
        return inventoryRepository.getAllTradableItems();
    }
}
