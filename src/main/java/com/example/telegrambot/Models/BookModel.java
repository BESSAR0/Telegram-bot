package com.example.telegrambot.Models;

import com.example.telegrambot.Helpers.DoctorEnum;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "doctor")
    @Enumerated
    DoctorEnum doctorEnum;

    @Column(name = "time")
    String time;

    @Column(name = "tg_id")
    String tgId;


}
