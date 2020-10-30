package com.example.dgrove.rpgassistant.DB.ViewModels;

import android.app.Application;

import com.example.dgrove.rpgassistant.DB.Entities.UserEntity;
import com.example.dgrove.rpgassistant.DB.Repositories.UserRepository;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class UserViewModel extends AndroidViewModel {
    private UserRepository userRepository;
    private LiveData<List<UserEntity>> allUsers;

    public UserViewModel (Application application){
        super(application);
        userRepository = new UserRepository(application);
        allUsers = userRepository.getAllUsers();
    }

    public void insert(UserEntity user) {
        userRepository.insert(user);
    }

    public void update(UserEntity user){
        userRepository.update(user);
    }

    public void delete(UserEntity user){
        userRepository.delete(user);
    }

    public LiveData<List<UserEntity>> getAllUsers() {
        return allUsers;
    }

    public UserEntity getUserByEmail(String email){
        return userRepository.getUserByEmail(email);
    }

    public UserEntity getUserByUsername(String username) { return userRepository.getUserByUsername(username); }

    public int[] getUserIDs() {return userRepository.getUserIDs(); }

    public String[] getAllUsernames() { return userRepository.getAllUsernames(); }

    public String getUsername(String username) { return userRepository.getUsername(username); }

}
