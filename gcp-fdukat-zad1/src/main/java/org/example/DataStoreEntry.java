package org.example;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.datastore.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

public class DataStoreEntry {
    private static final String PROJECT_ID = "brep-playground";
    private static final String CREDENTIALS_PATH = "src/main/resources/brep-playground-40458e49ca06.json";


    public static  void main(String[] args) throws IOException {

        DatastoreOptions datastoreOptions = DatastoreOptions.newBuilder()
                .setProjectId(PROJECT_ID)
                .setCredentials(GoogleCredentials.fromStream(new FileInputStream(CREDENTIALS_PATH)))
                .build();
        Datastore datastore = datastoreOptions.getService();
        KeyFactory keyFactory = datastore.newKeyFactory().setKind("brep_manual_dukat");
        Key key = keyFactory.newKey(generateRandomId());

        Entity entity = Entity.newBuilder(key)
                .set("date_string", new Date().toString())
                .build();
        datastore.put(entity);

    }

    private static long generateRandomId() {
        UUID uuid = UUID.randomUUID();
        return uuid.getMostSignificantBits();
    }
}