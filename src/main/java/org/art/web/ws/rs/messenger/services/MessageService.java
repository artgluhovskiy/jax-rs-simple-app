package org.art.web.ws.rs.messenger.services;

import org.art.web.ws.rs.messenger.db.DatabaseMockImpl;
import org.art.web.ws.rs.messenger.exceptions.DataNotFoundException;
import org.art.web.ws.rs.messenger.models.Message;

import java.util.*;

public class MessageService {

    private final Map<Long, Message> messages = DatabaseMockImpl.getMessages();

    public List<Message> getAllMessages() {
        return new ArrayList<>(messages.values());
    }

    public List<Message> getAllMessagesForYear(int year) {
        List<Message> messagesForYear = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        Collection<Message> allMessages = messages.values();
        for (Message message : allMessages) {
            cal.setTime(message.getCreated());
            if (cal.get(Calendar.YEAR) == year) {
                messagesForYear.add(message);
            }
        }
        return messagesForYear;
    }

    public List<Message> getAllMessagesPaginated(int offset, int limit) {
        ArrayList<Message> allMessages = new ArrayList<>(messages.values());
        if (offset + limit > allMessages.size()) {
            return new ArrayList<>();
        }
        return allMessages.subList(offset, offset + limit);
    }

    public Message getMessage(long id) {
        Message message = messages.get(id);
        if (message == null) {
            throw new DataNotFoundException("Message id " + id + " not found.");
        }
        return message;
    }

    public Message addMessage(Message message) {
        if (message.getId() == 0) {
            message.setId(messages.size() + 1);
        }
        messages.put(message.getId(), message);
        return message;
    }

    public Message updateMessage(Message message) {
        if (message.getId() <= 0) {
            return null;
        }
        messages.put(message.getId(), message);
        return message;
    }

    public Message removeMessage(long id) {
        return messages.remove(id);
    }
}
