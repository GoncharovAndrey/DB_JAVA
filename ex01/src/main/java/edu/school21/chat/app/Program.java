package edu.school21.chat.app;

import edu.school21.chat.models.Message;
import edu.school21.chat.repository.MessagesRepositoryJdbc;
import edu.school21.chat.repository.MessagesRepositoryJdbcImpl;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long messageId = scanner.nextLong();
        MessagesRepositoryJdbc messagesRepo = new MessagesRepositoryJdbcImpl(DataSourceServices.INSTANSE.getDataSource());

        Message message = messagesRepo.findById(messageId).orElse(null);
        System.out.println(message.toString());
        DataSourceServices.INSTANSE.close();
    }
}
