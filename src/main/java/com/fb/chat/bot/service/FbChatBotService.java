package com.fb.chat.bot.service;

import com.fb.chat.bot.model.WebhookBody;
import org.springframework.stereotype.Service;

@Service
public class FbChatBotService {

    private static final String VERIFY_TOKEN = "abc123";

    public String verification(String mode, String verifyToken, String challenge) {

        if (mode.equals("subscribe") && verifyToken.equals(VERIFY_TOKEN)) {
            System.out.println("Inside Verification method");
//            return "EAAiqXO6NnGoBACSHjXJrgi9NqSV8Wk8UBvicnWougp7dpgFxyeFZC4ZCYyiYHUpASbc2j5HiloqAXMtu3g6LxTXYd7kZBt9d9UaHgvoEXkz3wePVovZBig1ac8iU4OMoDkWzuNDWamoj9hFxa65j15aZCOxupquAAGaW9hohZCoAZDZD";
            return challenge;
        } else {
            return null;
        }
    }

    public String webhook(WebhookBody webhookBody) {
        if (webhookBody.getObject().equals("page")) {
            System.out.println("Nside wehook method");
            webhookBody.getEntry().forEach(messaging -> messaging.getMessaging().forEach(System.out::println));
            return "EVENT_RECEIVED";
        }
        return null;
    }
}
