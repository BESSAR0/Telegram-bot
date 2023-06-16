package com.example.telegrambot.Helpers;

import com.example.telegrambot.Models.UserModel;
import com.example.telegrambot.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class
UserHelper {

    public static UserRepo userRepo;


    public UserHelper(UserRepo userRepos) {
        userRepo = userRepos;
        userHelper = this;
    }

    public static UserHelper userHelper = null;
 /*   public static UserModel find(String tgId){
        UserModel userModel;
        userModel = userRepo.findUserModelByTgId(tgId);
        return userModel;
    }*/

    public static void saveUser(UserModel userModel){
        userRepo.save(userModel);
    }

    public static UserModel findUser(String tgId){
        UserModel userModel = new UserModel();
        userModel = userRepo.findUserModelByTgId(tgId);
        return userModel;
    }
}
