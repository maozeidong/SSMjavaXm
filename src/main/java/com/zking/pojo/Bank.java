package com.zking.pojo;

public class Bank {

    public Bank() {
        super();
    }

    public Bank(int id, String openingbank) {
        this.id = id;
        this.openingbank = openingbank;
    }

    private int id;


    private String openingbank;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpeningbank() {
        return openingbank;
    }

    public void setOpeningbank(String openingbank) {
        this.openingbank = openingbank;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", openingbank='" + openingbank + '\'' +
                '}';
    }
}
