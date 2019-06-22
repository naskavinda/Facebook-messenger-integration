package com.fb.chat.bot.controller;

import com.fb.chat.bot.model.WebhookBody;
import com.fb.chat.bot.service.FbChatBotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FbChatBotController {

    private final FbChatBotService fbChatBotService;

    public FbChatBotController(FbChatBotService fbChatBotService) {
        this.fbChatBotService = fbChatBotService;
    }

    @GetMapping(value = "/webhook")
    public ResponseEntity<String> verification(@RequestParam(value = "hub.mode") String mode,
                                               @RequestParam(value = "hub.verify_token") String verifyToken,
                                               @RequestParam(value = "hub.challenge", required = false) String challenge) {

        String response = fbChatBotService.verification(mode, verifyToken, challenge);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping(value = "/webhook")
    public ResponseEntity<String> webhook(@RequestBody WebhookBody webhookBody) {
        String response = fbChatBotService.webhook(webhookBody);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
