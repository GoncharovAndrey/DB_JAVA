package edu.school21.chat.models;

public interface ColumnName {
    
    String USER_TABLE_NAME = "USERS";
    String USER_ID = "user_id";
    String USER_LOGIN = "login";
    String USER_PASSWORD = "password";
    String CHATS_TABLE_NAME = "CHATROOMS";
    String CHAT_ID = "chat_id";
    String CHAT_NAME = "chat_name";
    String CHAT_OWNER = "chatroom_owner";
    String MESSAGES_TABLE_NAME = "MESSAGES";
    String MESSAGE_ID = "message_id";
    String MESSAGE_AUTHOR = "message_author";
    String MESSAGE_ROOM = "message_room";
    String MESSAGE_TEXT = "text";
    String MESSAGE_DATE = "message_date";
    String USERS_CHATS_TABLE = "USERS_CHATS";
    String USERS_CHATS_USER_ID = "user_id";
    String USERS_CHATS_CHAT_ID = "chat_id";

}
