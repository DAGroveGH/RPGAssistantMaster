package com.example.dgrove.rpgassistant.DB.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import com.example.dgrove.rpgassistant.DB.DAOs.UserDAO;
import com.example.dgrove.rpgassistant.DB.Entities.UserEntity;
import com.example.dgrove.rpgassistant.DB.RPGAssistantDB;

import java.util.List;

import androidx.lifecycle.LiveData;

public class UserRepository {
    private UserDAO userDAO;

    public UserRepository(Application application){
        RPGAssistantDB db = RPGAssistantDB.getDatabase(application);
        userDAO = db.userDAO();
    }
    public void insert(UserEntity user){
        new InsertUserAsyncTask(userDAO).execute(user);
    }

    public void update(UserEntity user){
        new UpdateUserAsyncTask(userDAO).execute(user);
    }

    public void delete(UserEntity user){
        new DeleteUserAsyncTask(userDAO).execute(user);
    }

    public LiveData<List<UserEntity>> getAllUsers(){
        return userDAO.loadAllUsers();
    }

    public UserEntity getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

    public UserEntity getUserByUsername(String username) { return userDAO.getUserByUsername(username); }

    public int[] getUserIDs() { return userDAO.getUserIDs(); }

    public String[] getAllUsernames(){ return userDAO.getAllUsernames(); }

    public String getUsername(String username) { return userDAO.getUsername(username); }

    private static class InsertUserAsyncTask extends AsyncTask<UserEntity, Void, Void>{
        private UserDAO userDAO;

        private InsertUserAsyncTask(UserDAO userDAO){
            this.userDAO = userDAO;
        }

        @Override
        protected Void doInBackground(UserEntity... Users){
            userDAO.insertUser(Users[0]);
            return null;
        }
    }

    private static class UpdateUserAsyncTask extends AsyncTask<UserEntity, Void, Void> {
        private UserDAO userDAO;

        private UpdateUserAsyncTask(UserDAO userDAO){
            this.userDAO = userDAO;
        }

        @Override
        protected Void doInBackground(UserEntity... Users){
            userDAO.updateUsers(Users[0]);
            return null;
        }
    }

    private static class DeleteUserAsyncTask extends AsyncTask<UserEntity, Void, Void> {
        private UserDAO userDAO;

        private DeleteUserAsyncTask(UserDAO userDAO){
            this.userDAO = userDAO;
        }

        @Override
        protected Void doInBackground(UserEntity... Users){
            userDAO.deleteUser(Users[0]);
            return null;
        }
    }
}