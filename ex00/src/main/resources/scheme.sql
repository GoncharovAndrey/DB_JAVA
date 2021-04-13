create table USERS
(
    ID BIGSERIAL not null PRIMARY KEY,
    LOGIN varchar(32) not null,
    PASSWORD varchar(1024) not null
);

create unique index users_id_uindex
    on USERS (ID);

create unique index users_login_uindex
    on USERS (LOGIN);

create table CHATROOMS
(
    ID BIGSERIAL not null PRIMARY KEY,
    NAME varchar(512),
    OWNER_ID BIGINT not null,
    FOREIGN KEY (OWNER_ID) REFERENCES users(id)
);

create unique index chatrooms_id_uindex
    on CHATROOMS (ID);

create unique index chatrooms_name_uindex
    on CHATROOMS (NAME, OWNER_ID);

create table MASSAGE
(
    ID BIGSERIAL not null,
    AUTHOR_ID BIGINT not null,
    FOREIGN KEY (AUTHOR_ID) REFERENCES users(id),
    CHAT_ID BIGINT not null,
    FOREIGN KEY (CHAT_ID) REFERENCES CHATROOMS(id),
    TEXT TEXT,
    CREATION_DATE TIMESTAMP default current_timestamp
);

create unique index massage_id_uindex
    on MASSAGE (ID);

create index massage_chat_id_index
    on MASSAGE (chat_id);

create table USERS_CHATS
(
    USER_ID BIGINT not null,
    FOREIGN KEY (USER_ID) REFERENCES USERS(ID),
    CHAT_ID BIGINT not null,
    FOREIGN KEY (CHAT_ID) REFERENCES CHATROOMS(ID)
);

create unique index users_chats_user_id_chat_id_uindex
	on users_chats (user_id, chat_id);
