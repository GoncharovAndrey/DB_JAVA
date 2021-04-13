package edu.school21.chat.models;

import java.sql.Timestamp;
import java.util.Objects;

public class Massage {
    private long id;
    private User author;
    private Chatroom chatroom;
    private String text;
    private Timestamp creationDate;

    public Massage(User author, Chatroom chatroom, String text) {
        this.author = author;
        this.chatroom = chatroom;
        this.text = text;
    }

    public Massage(long id, User author, Chatroom chatroom, String text, Timestamp creationDate) {
        this.id = id;
        this.author = author;
        this.chatroom = chatroom;
        this.text = text;
        this.creationDate = creationDate;
    }

    public long getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Chatroom getChatroom() {
        return chatroom;
    }

    public void setChatroom(Chatroom chatroom) {
        this.chatroom = chatroom;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Massage)) return false;
        Massage massage = (Massage) o;
        return id == massage.id && creationDate.equals(massage.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate);
    }

    @Override
    public String toString() {
        return "Massage{" +
                "id=" + id +
                ", author=" + author +
                ", chatroom=" + chatroom +
                ", text='" + text + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
