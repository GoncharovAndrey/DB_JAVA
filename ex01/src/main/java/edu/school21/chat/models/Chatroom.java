package edu.school21.chat.models;

import java.util.List;

public class Chatroom {
    private long id;
    private String chatName;
    private User owner;
    private List<Message> messages;

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

    public List<Message> getMassages() {
        return messages;
    }

    public void setMassages(List<Message> massages) {
        this.messages = massages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chatroom)) return false;

        Chatroom chatroom = (Chatroom) o;

        if (id != chatroom.id) return false;
        return chatName.equals(chatroom.chatName);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + chatName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "id=" + id +
                ", chatName='" + chatName + '\'' +
                ", owner=" + owner +
                ", messages=" + messages +
                '}';
    }
}
