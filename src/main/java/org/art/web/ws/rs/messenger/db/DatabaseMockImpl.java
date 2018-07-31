package org.art.web.ws.rs.messenger.db;

import org.art.web.ws.rs.messenger.models.Message;
import org.art.web.ws.rs.messenger.models.Profile;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DatabaseMockImpl {

    private static Map<Long, Message> messages = new ConcurrentHashMap<>();
    private static Map<String, Profile> profiles = new ConcurrentHashMap<>();

    static {
        //Messages initialization
        Message m1 = new Message(1L, "Message Text 1", "John");
        Message m2 = new Message(2L, "Message Text 2", "Bob");
        Message m3 = new Message(3L, "Message Text 3", "Max");
        messages.put(m1.getId(), m1);
        messages.put(m2.getId(), m2);
        messages.put(m3.getId(), m3);

        //Profiles initialization
        Profile p1 = new Profile(1L, "profile_1", "John", "Smith");
        Profile p2 = new Profile(2L, "profile_2", "Bob", "Wilson");
        Profile p3 = new Profile(3L, "profile_3", "Max", "Lumen");
        profiles.put(p1.getProfileName(), p1);
        profiles.put(p2.getProfileName(), p2);
        profiles.put(p3.getProfileName(), p3);
    }

    public static Map<Long, Message> getMessages() {
        return messages;
    }

    public static Map<String, Profile> getProfiles() {
        return profiles;
    }
}
