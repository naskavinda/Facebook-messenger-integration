package com.fb.chat.bot.model;

import java.util.List;

public class Entry {

    private String id;

    private List<Messaging> messaging;

    private long time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Messaging> getMessaging() {
        return messaging;
    }

    public void setMessaging(List<Messaging> messaging) {
        this.messaging = messaging;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Entry{");
        sb.append("id=").append(id);
        sb.append(", messaging=").append(messaging);
        sb.append(", time=").append(time);
        sb.append('}');
        return sb.toString();
    }
}
