package edu.school21.chat.models;

import java.util.List;

public class User {

    private long id;
    private String login;
    private String password;
    private List<Chatroom> createdChats;
    private List<Chatroom> activeChats;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Chatroom> getCreatedChats() {
        return createdChats;
    }

    public void setCreatedChats(List<Chatroom> createdChats) {
        this.createdChats = createdChats;
    }

    public List<Chatroom> getActiveChats() {
        return activeChats;
    }

    public void setActiveChats(List<Chatroom> activeChats) {
        this.activeChats = activeChats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (id != user.id) return false;
        return login.equals(user.login);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + login.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createdChats=" + createdChats +
                ", activeChats=" + activeChats +
                '}';
    }
}
