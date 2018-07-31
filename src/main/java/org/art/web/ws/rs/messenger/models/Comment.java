package org.art.web.ws.rs.messenger.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Comment {

    private long id;
    private String message;
    private Date created;
    private String authod;

    public Comment() {
    }

    public Comment(long id, String message, String authod) {
        this.id = id;
        this.message = message;
        this.created = new Date();
        this.authod = authod;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getAuthod() {
        return authod;
    }

    public void setAuthod(String authod) {
        this.authod = authod;
    }
}
