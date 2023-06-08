package com.example.telegrambot;

import com.example.telegrambot.Repos.UserRepo;
import com.example.telegrambot.commands.BookCommand;
import com.example.telegrambot.commands.ChooseTime;
import com.example.telegrambot.commands.LoginCommand;
import com.example.telegrambot.commands.WorkerCommand;
import com.example.telegrambot.commands.bookcommand.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class Bot extends TelegramLongPollingBot {


    @Override
    public String getBotUsername() {
        return "medicine_reg_bot";
    }


    @Override
    public String getBotToken() {
        return "6101015374:AAFUnow-fF7Fo_7eOj__T4Tzocpn7cxq5OA";
    }

    @Override
    public void onUpdateReceived(Update update) {
        KeyboardRow k = new KeyboardRow();
            k.add(new KeyboardButton("Log In"));
        k.add(new KeyboardButton("Записаться к врачу"));
        SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(update.getMessage().getChatId().toString());
            sendMessage.setText("выберите действие");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(Collections.singletonList(k));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        List<WorkerCommand> list = new ArrayList<>();
        list.add(new LoginCommand());
        list.add(new BookCommand());
        list.add(new TerapevtBookCommand());
        list.add(new OkulistBookCommand());
        list.add(new LorBookCommand());
        list.add(new GinekologBookCommand());
        list.add(new AllergologBookCommand());
        list.add(new ChooseTime());
        SendMessage s;
        for (WorkerCommand w: list){
            if ((s = w.start(update))!=null){
                sendMessage = s;
                break;
            }
        }
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    }
