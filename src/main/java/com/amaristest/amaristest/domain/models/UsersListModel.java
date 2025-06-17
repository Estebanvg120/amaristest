package com.amaristest.amaristest.domain.models;

import java.util.List;

public class UsersListModel {

    private List<UserModel> users;
    private int total;
    private int skip;
    private int limit;

    public UsersListModel(List<UserModel> users, int total, int skip, int limit) {
        this.users = users;
        this.total = total;
        this.skip = skip;
        this.limit = limit;
    }

    public UsersListModel() {
    }

    public List<UserModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
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
