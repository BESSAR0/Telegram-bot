package com.example.telegrambot.Helpers;

import com.example.telegrambot.Models.BookModel;
import com.example.telegrambot.Repos.BoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorHelper {
@Autowired
BoodRepo boodRepo;

private static DoctorHelper doctorHelper = null;

    public DoctorHelper() {
        doctorHelper = this;
    }

    public static void save(BookModel b){
        doctorHelper.boodRepo.save(b);
    }
    public static List<String> getFreeTimes(DoctorEnum d){
        TimeControl timeControl = new TimeControl();
        List<BookModel> bookModelList = doctorHelper.boodRepo.findBookModelByDoctorEnum(d);
        List<String> freeTimes = new ArrayList<>();
        freeTimes = timeControl.getTimes();

        List<String> list = new ArrayList<>();
        for (BookModel b : bookModelList){
            for (String str: freeTimes){
                if (b.getTime().equals(str)){
                    list.add(b.getTime());
                }
            }
        }
        freeTimes.remove(list);
        return freeTimes;
    }
}
