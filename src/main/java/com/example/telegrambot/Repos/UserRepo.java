package com.example.telegrambot.Repos;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.telegrambot.Models.UserModel;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Long>{
    UserModel findUserModelByTgId(String id);
}
