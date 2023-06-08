package com.example.telegrambot.Helpers;

import com.example.telegrambot.Models.UserModel;
import com.example.telegrambot.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserHelper {
    final
    UserRepo userRepo;

    public UserHelper(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    private static UserHelper helper = null;

    public static void saveUser(UserModel u){
        helper.userRepo.save(u);
    }
    public static UserModel findUser(String tgId){
        UserModel userModel = new UserModel();
        userModel = helper.userRepo.findUserModelByTgId(tgId);
        return userModel;
    }
}
