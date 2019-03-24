package com.t3h.chatfun;

import java.util.Date;

public class Friend {
    private String displayNameFriend;
    private String id;
    private String avatar;
    private String lastMessage;
    private Date dateLastMessage;
    private boolean isOnline;

    public String getdisplayNameFriend() {
        return displayNameFriend;
    }

    public void setdisplayNameFriend(String displayNameFriend) {
        this.displayNameFriend = displayNameFriend;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public Date getDateLastMessage() {
        return dateLastMessage;
    }

    public void setDateLastMessage(Date dateLastMessage) {
        this.dateLastMessage = dateLastMessage;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }
}
