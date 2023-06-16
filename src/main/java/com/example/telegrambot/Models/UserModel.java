package com.example.telegrambot.Models;

import com.example.telegrambot.Helpers.DoctorEnum;
import lombok.Data;

import jakarta.persistence.*;


@Entity
@Table(name = "telegram_user")
@Data
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "username")
    String username;
    @Column(name = "telegram_id")
    String tgId;

    @Column(name = "name")
    String name;

    @Column(name = "wanted_doc" )
    @Enumerated
    DoctorEnum doctorEnum;

}
