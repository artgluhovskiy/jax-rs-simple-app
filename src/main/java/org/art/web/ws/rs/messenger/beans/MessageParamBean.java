package org.art.web.ws.rs.messenger.beans;

import javax.ws.rs.QueryParam;

public class MessageParamBean {

    @QueryParam("year")
    private int year;

    @QueryParam("offset")
    private int offset;

    @QueryParam("limit")
    private int limit;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
