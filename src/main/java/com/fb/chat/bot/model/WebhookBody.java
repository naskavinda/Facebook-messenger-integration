package com.fb.chat.bot.model;


import java.util.List;

public class WebhookBody {

    private String object;

    private List<Entry> entry;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public List<Entry> getEntry() {
        return entry;
    }

    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WebhookBody{");
        sb.append("object='").append(object).append('\'');
        sb.append(", entry=").append(entry);
        sb.append('}');
        return sb.toString();
    }
}
