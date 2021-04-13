package edu.school21.chat.models;

import java.sql.Timestamp;

public class Message {
    private long id;
    private User author;
    private Chatroom chatroom;
    private String text;
    private Timestamp creationDate;

    public Message(User author, Chatroom chatroom, String text) {
        this.author = author;
        this.chatroom = chatroom;
        this.text = text;
    }

    public Message(long id, User author, Chatroom chatroom, String text, Timestamp creationDate) {
        this.id = id;
        this.author = author;
        this.chatroom = chatroom;
        this.text = text;
        this.creationDate = creationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;

        Message massage = (Message) o;

        if (id != massage.id) return false;
        return creationDate.equals(massage.creationDate);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + creationDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", author=" + author +
                ", chatroom=" + chatroom +
                ", text='" + text + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
