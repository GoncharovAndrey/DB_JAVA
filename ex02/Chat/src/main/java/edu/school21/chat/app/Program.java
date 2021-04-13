package edu.school21.chat.app;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repository.MessagesRepositoryJdbc;
import edu.school21.chat.repository.MessagesRepositoryJdbcImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        User creator = new User(1L, "user1", "user1");
        User author = creator;
        Chatroom room = new Chatroom(1L, "chat1", creator);
        Message message = new Message(author, room, "Hello!");
        MessagesRepositoryJdbc messagesRepository = new MessagesRepositoryJdbcImpl(DataSourceServices.INSTANSE.getDataSource());
        messagesRepository.save(message);
        System.out.println(message);
        DataSourceServices.INSTANSE.close();
    }
}

