package com.example.dgrove.rpgassistant.DB;

import android.content.Context;

import com.example.dgrove.rpgassistant.DB.DAOs.CharacterListDAO;
import com.example.dgrove.rpgassistant.DB.DAOs.CharacterSkillDAO;
import com.example.dgrove.rpgassistant.DB.DAOs.GameListDAO;
import com.example.dgrove.rpgassistant.DB.DAOs.GamePlayerDAO;
import com.example.dgrove.rpgassistant.DB.DAOs.GameSettingsDAO;
import com.example.dgrove.rpgassistant.DB.DAOs.InventoryDAO;
import com.example.dgrove.rpgassistant.DB.DAOs.SkillDAO;
import com.example.dgrove.rpgassistant.DB.DAOs.UserDAO;
import com.example.dgrove.rpgassistant.DB.Entities.CharacterInventoryEntity;
import com.example.dgrove.rpgassistant.DB.Entities.CharacterSkillsEntity;
import com.example.dgrove.rpgassistant.DB.Entities.GameCharacterEntity;
import com.example.dgrove.rpgassistant.DB.Entities.GameEntity;
import com.example.dgrove.rpgassistant.DB.Entities.GamePlayerEntity;
import com.example.dgrove.rpgassistant.DB.Entities.GameSettingsEntity;
import com.example.dgrove.rpgassistant.DB.Entities.GameSkillsEntity;
import com.example.dgrove.rpgassistant.DB.Entities.UserEntity;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class, GameEntity.class, GameCharacterEntity.class, GamePlayerEntity.class, GameSkillsEntity.class, GameSettingsEntity.class,
        CharacterSkillsEntity.class, CharacterInventoryEntity.class}, version = 1, exportSchema = false)

public abstract class RPGAssistantDB extends RoomDatabase {
    public abstract UserDAO userDAO();
    public abstract GameListDAO gameListDAO();
    public abstract CharacterListDAO characterListDAO();
    public abstract GamePlayerDAO gamePlayerDAO();
    public abstract SkillDAO skillDAO();
    public abstract GameSettingsDAO gameSettingsDAO();
    public abstract CharacterSkillDAO characterSkillDAO();
    public abstract InventoryDAO inventoryDAO();

    private static RPGAssistantDB INSTANCE;
    public static RPGAssistantDB getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (RPGAssistantDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RPGAssistantDB.class, "rpgassistant_database")
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}