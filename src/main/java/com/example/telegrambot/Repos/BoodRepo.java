package com.example.telegrambot.Repos;

import com.example.telegrambot.Helpers.DoctorEnum;
import com.example.telegrambot.Models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BoodRepo extends JpaRepository<BookModel, Long>{
    List<BookModel> findBookModelByDoctorEnum(DoctorEnum d);
}
