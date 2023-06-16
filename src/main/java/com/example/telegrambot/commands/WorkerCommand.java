package com.example.telegrambot.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface WorkerCommand {
    SendMessage start(Update update);

    SendMessage sendDefaultMessage(Update update);
}
