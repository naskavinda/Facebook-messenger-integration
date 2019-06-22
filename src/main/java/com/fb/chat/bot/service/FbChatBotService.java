package com.fb.chat.bot.service;

import com.fb.chat.bot.model.WebhookBody;
import org.springframework.stereotype.Service;

@Service
public class FbChatBotService {

    private static final String VERIFY_TOKEN = "abc123";

    public String verification(String mode, String verifyToken, String challenge) {

        if (mode.equals("subscribe") && verifyToken.equals(VERIFY_TOKEN)) {
            return challenge;
        } else {
            return null;
        }
    }

    public String webhook(WebhookBody webhookBody) {
        if (webhookBody.getObject().equals("page")) {
            webhookBody.getEntry().forEach(messaging -> messaging.getMessaging().forEach(System.out::println));
            return "EVENT_RECEIVED";
        }
        return null;
    }
}
