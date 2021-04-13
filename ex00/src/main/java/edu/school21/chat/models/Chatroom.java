package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chatroom {
    private long id;
    private String chatName;
    private User owner;
    private List<Massage> massages;

    public Chatroom(String chatName, User owner) {
        this.chatName = chatName;
        this.owner = owner;
    }

    public Chatroom(long id, String chatName, User owner) {
        this.id = id;
        this.chatName = chatName;
        this.owner = owner;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Massage> getMassages() {
        return massages;
    }

    public void setMassages(List<Massage> massages) {
        this.massages = massages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chatroom)) return false;
        Chatroom chatroom = (Chatroom) o;
        return id == chatroom.id && chatName.equals(chatroom.chatName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chatName);
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "id=" + id +
                ", chatName='" + chatName + '\'' +
                ", owner=" + owner +
                ", massages=" + massages +
                '}';
    }
}
