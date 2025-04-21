package com.chatme.backend;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

@Configuration
public class FirebaseInitializer {

    @PostConstruct
    public void init() throws IOException {
    	String serviceAccountJson = """
    	        {
    	          "type": "service_account",
    	          "project_id": "chat-mobileapp-b05c2",
    	          "private_key_id": "b980bf5ffbda884f413f33c5e45888e28f0c7db5",
    	          "private_key": "-----BEGIN PRIVATE KEY-----\\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQChxWVgdJhjKMdk\\nYkcYOI4zBxiyjoJlm+rX8YglZNQRDoiV7OXj4NTun8Ce8xwsicHxX8kJL1oys+h4\\nLLZQ/Wnu/auTCP+cRw1PCPrHIE2Wi8klfaADrwrNW3x10fErZahr2KB1xMmB9GX0\\nNDavhIG2iuhUc5do0mMINS+rcjlgUbVrKWouQtEDlPg2YZ5nmnAa+1raqDmWgxpH\\nmddu/SRcUOvTLCxwsvFVRjb5B+aY72Lo8ZDh4gway2X9niZzYAOZaN3aS2U9Kb92\\nvkf+OJu7PDDLs4lCyH/BsfCWXiCJHj5lrPH9SyT6qR7Jvi1duhZdhI5HJeubCUhP\\n7IMcRBrfAgMBAAECggEATA28ooNOXVf/ne8iU33LRKwybUfYgCK0Xv+brVDg7n/x\\nsOKmFeNO2Dzc1x2egkXlmzAYGKxdcHbqdQ04TY1GL2itMDxLx9ITrLOhCtrh/0QK\\ntgiAoRq7Ll6zfcTM6EUr0EAQ+C0jO2iGQjAGAbB/Ny3JGmMZrNs0Wdh/Z9AUr3Ya\\nDuav7+woVmvM5XuOOsDjDwoT/rf/2gUFFNJ/MGQiipCY77HOj5udsqMh0spFtlV6\\nswl9K80b9fVaVsn+u2iSinL68TWyKOPKKVapYopov04DoFfJk2VzujqU+oWAUCtF\\nA5pKySXjZHrJQxdElPbx6Dvyu3yLN+o3RW5n2Nj12QKBgQDjxxb06Np2M5x/6bhn\\nU1aaxS8MXI2XkvouMkcw0kWRFRGB0lzZnIekWjyZqF4zdJGtpYGnXSMN3ML3DFbc\\nY+iWT8KKGJzimXVgJ8FN21iLbFrhtb/+4pgvIzE5DHkyHXdpoK0Z7D4h+PzMSG1Z\\ncnWZYe7XAJ2xmuiCuaIDAc6HswKBgQC10KJGa+ax6oyNua0MQOHAHYN/O7WHEYce\\nTXGGpCJTiUrmn4zTpMy2MRy0QZCtlBeB5QYKbU4JvbO/mBTiX15ziSHf5e+F4iDg\\nHhnkzDmt3mgtOYi9rBjTPCIe1PFlUjBdJmIkKZsWHRDEwEZabU2N2RR1GeuZ7/9H\\nH3qfSKyKJQKBgQDNM1GiJ5iP/iUSM1t2cmTGH7gn+cVxdO6/6XmrKPOVJZbVDs+p\\nF9Q3IzgO8diToIORHVZ1kXmABo76A3rJJ5SkvYwz3sKPfdJ5YrdJzb6yNFaXmqYy\\nGK8jYB/7FhqlJFispxzrCqJa9rW/z8v7VhtNqCWEOkDWfQjUpCmpbdpC8wKBgFDC\\nvwJW9Z98FzjxDCwQOfbzZTDEHgtEPue38MCk8dZ3erzcjFqKrqATSrPLF+/yg0qg\\np8FD8lEjYc+uR0CSqkrZ1CE3auDmpEHJPSlDii9wRogoMVRHOLPD10gowJ2IF5GY\\n9ikoDgqRmJw86ENMoBFtJsgpXlz/nT5Dfl14k6O9AoGBALd+LbaVUo72FkaV2to8\\nzwOmX7KrJxE5dOtCRdrd13YI5zRLI1sJGaPxRqNuoZ+fDLNfuzBONf207FhTZ3Em\\nQFvP9y5XfNt5NRAAb3/9+cMSP4JVvy3GzJc3RYH7jwizhGTmVWD5F5X0WgzIqjSy\\nRQDH+3KBRupEkQ42IXLFrGue\\n-----END PRIVATE KEY-----\\n",
    	          "client_email": "chat-mobileapp-b05c2@appspot.gserviceaccount.com",
    	          "client_id": "114893330201692470251",
    	          "auth_uri": "https://accounts.google.com/o/oauth2/auth",
    	          "token_uri": "https://oauth2.googleapis.com/token",
    	          "auth_provider_x509_cert_url": "https://www.googleapis.com/oauth2/v1/certs",
    	          "client_x509_cert_url": "https://www.googleapis.com/robot/v1/metadata/x509/chat-mobileapp-b05c2%40appspot.gserviceaccount.com",
    	          "universe_domain": "googleapis.com"
    	        }
    	        """;

        ByteArrayInputStream serviceAccountStream = new ByteArrayInputStream(serviceAccountJson.getBytes(StandardCharsets.UTF_8));

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccountStream))
                .setDatabaseUrl("https://chat-mobileapp-b05c2-default-rtdb.europe-west1.firebasedatabase.app/") 
                .build();

        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options);
        }
    }

    @Bean
    public FirebaseDatabase firebaseDatabase() {
        return FirebaseDatabase.getInstance("https://chat-mobileapp-b05c2-default-rtdb.europe-west1.firebasedatabase.app/");
    }
}
