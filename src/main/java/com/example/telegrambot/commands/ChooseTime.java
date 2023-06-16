package com.example.telegrambot.commands;

import com.example.telegrambot.Helpers.DoctorHelper;
import com.example.telegrambot.Helpers.TimeControl;
import com.example.telegrambot.Helpers.UserHelper;
import com.example.telegrambot.Models.BookModel;
import com.example.telegrambot.Models.UserModel;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChooseTime implements WorkerCommand{
    @Override
    public SendMessage start(Update update) {
        TimeControl timeControl = new TimeControl();
        List<String> list = timeControl.getTimes();
        boolean ifThisCommand=false;
        for (String str: list) {
            if (update.getMessage().getText().equals(str)) {
                ifThisCommand = true;
            }
        }
            if (!ifThisCommand) {
                return null;
            }

        BookModel bookModel = new BookModel();
        bookModel.setTime(update.getMessage().getText().toString());


        UserModel userModel = new UserModel();
        userModel = UserHelper.findUser(update.getMessage().getFrom().getId().toString());
        userModel.setTgId(update.getMessage().getFrom().getId().toString());

        bookModel.setTgId(update.getMessage().getFrom().getId().toString());
        bookModel.setDoctorEnum(userModel.getDoctorEnum());

        DoctorHelper.save(bookModel);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        sendMessage.setText("Вы успешно записались к врачу");
        return sendMessage;
    }

    @Override
    public SendMessage sendDefaultMessage(Update update) {
        return null;
    }
}
