package Model;

import java.util.LinkedList;

public class User {
    private int id;
    private int password;
    private String surname;
    private boolean online;
    private LinkedList<LinkedList<String>> lastHistory=new LinkedList<>();
    private LinkedList<User> friends=new LinkedList<>();
    private boolean request;
    private int reqFri;

    public int getReqFri() {
        return reqFri;
    }

    public void setReqFri(int reqFri) {
        this.reqFri = reqFri;
    }

    public boolean isRequest() {
        return request;
    }

    public void setRequest(boolean request) {
        this.request = request;
    }

    public LinkedList<LinkedList<String>> getLastHistory() {
        return lastHistory;
    }

    public LinkedList<User> getFriends() {
        return friends;
    }

    public void setFriends(LinkedList<User> friends) {
        this.friends = friends;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastHistory(LinkedList<LinkedList<String>> lastHistory) {
        this.lastHistory = lastHistory;
    }
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
