package com.chatme.backend;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class PushNotificationController {

    private final FirebaseService firebaseService;

    public PushNotificationController(FirebaseService firebaseService) {
        this.firebaseService = firebaseService;
    }

    @PostMapping("/send")
    public String sendNotification( @RequestParam("token") String token,
						            @RequestParam("title") String title,
						            @RequestParam("body") String body) {
    	System.out.println("Received new message from token " + token.toString() );
        return firebaseService.sendPushNotification(token, title, body);
    }
}

