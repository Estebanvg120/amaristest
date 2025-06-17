package com.amaristest.amaristest.application.dto.response;

import java.util.List;

public class UsersListDummyResponse {

    private List<UserDummyResponse> users;
    private int total;
    private int skip;
    private int limit;

    public UsersListDummyResponse(List<UserDummyResponse> users, int total, int skip, int limit) {
        this.users = users;
        this.total = total;
        this.skip = skip;
        this.limit = limit;
    }

    public UsersListDummyResponse() {
    }

    public List<UserDummyResponse> getUsers() {
        return users;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
