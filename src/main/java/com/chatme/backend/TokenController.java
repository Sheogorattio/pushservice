/*package com.chatme.backend;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/tokens")
public class TokenController {

    @Autowired
    private FirebaseDatabase firebaseDatabase;

    @PostMapping
    public String receiveToken(@RequestBody Map<String, String> payload) {
        String token = payload.get("token");
        String userId = payload.get("userId");

        if (token == null || token.isEmpty()) {
            return "Token is missing";
        }
        
        if (userId == null || userId.isEmpty()) {
            return "User ID is missing";
        }

        // Отримуємо базу даних
        DatabaseReference ref = firebaseDatabase.getReference("users").child(userId);

        // Оновлюємо токен користувача в Firebase
        ref.child("fcmToken").setValueAsync(token);
        
        System.out.print(false);

        return "Token updated successfully";
    }
}
*/