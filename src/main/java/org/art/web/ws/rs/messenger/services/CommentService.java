package org.art.web.ws.rs.messenger.services;

import org.art.web.ws.rs.messenger.db.DatabaseMockImpl;
import org.art.web.ws.rs.messenger.models.Comment;
import org.art.web.ws.rs.messenger.models.ErrorMessage;
import org.art.web.ws.rs.messenger.models.Message;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommentService {

    private Map<Long, Message> messages = DatabaseMockImpl.getMessages();

    public List<Comment> getAllComments(long messageId) {
        Message message = messages.get(messageId);
        Map<Long, Comment> comments = message.getComments();
        return new ArrayList<>(comments.values());
    }

    public Comment getComment(long messageId, long commentId) {
        Message message = messages.get(messageId);
        ErrorMessage errorMessage = new ErrorMessage("Not found", Response.Status.NOT_FOUND.getStatusCode(), "URL");

        //Note: Bad place for this code here (is not related to business logic)
        Response errorResponse = Response.status(Response.Status.NOT_FOUND)
                .entity(errorMessage)
                .build();

        if (message == null) {
            throw new WebApplicationException(errorResponse);
        }
        Map<Long, Comment> comments = message.getComments();
        Comment comment = comments.get(commentId);
        if (comment == null) {
            //Cleaner way to throw "Not Found" exception
            throw new NotFoundException(errorResponse);
        }
        return comment;
    }

    public Comment addComment(long messageId, Comment comment) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        comment.setId(comments.size() + 1);
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment updateComment(long messageId, Comment comment) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        if (comment.getId() <= 0) {
            return null;
        }
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment removeComment(long messageId, long commentId) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return comments.remove(commentId);
    }
}
