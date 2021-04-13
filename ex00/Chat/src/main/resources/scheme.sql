create table USERS
(
    USER_ID BIGSERIAL not null PRIMARY KEY,
    LOGIN varchar(32) not null,
    PASSWORD varchar(1024) not null
);

create unique index users_id_uindex
    on USERS (USER_ID);

create unique index users_login_uindex
    on USERS (LOGIN);

create table CHATROOMS
(
    CHAT_ID BIGSERIAL not null PRIMARY KEY,
    CHAT_NAME varchar(512),
    CHAT_OWNER BIGINT not null,
    FOREIGN KEY (CHAT_OWNER) REFERENCES users(USER_ID)
);

create unique index chatrooms_id_uindex
    on CHATROOMS (CHAT_ID);

create unique index chatrooms_name_uindex
    on CHATROOMS (CHAT_ID, CHAT_OWNER);

create table MESSAGES
(
    MESSAGE_ID BIGSERIAL not null,
    MESSAGE_AUTHOR BIGINT not null,
    FOREIGN KEY (MESSAGE_AUTHOR) REFERENCES users(USER_ID),
    MESSAGE_ROOM BIGINT not null,
    FOREIGN KEY (MESSAGE_ROOM) REFERENCES CHATROOMS(CHAT_ID),
    TEXT TEXT,
    MESSAGE_DATE TIMESTAMP default current_timestamp
);

create unique index massage_id_uindex
    on MESSAGES (MESSAGE_ID);

create index massage_chat_id_index
    on MESSAGES (MESSAGE_ROOM);

create table USERS_CHATS
(
    USER_ID BIGINT not null,
    FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID),
    CHAT_ID BIGINT not null,
    FOREIGN KEY (CHAT_ID) REFERENCES CHATROOMS(CHAT_ID)
);

create unique index users_chats_user_id_chat_id_uindex
    on users_chats (user_id, chat_id);
