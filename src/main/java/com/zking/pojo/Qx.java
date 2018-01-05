package com.zking.pojo;

public class Qx {

    public Qx() {
        super();
    }

    public Qx(int id, String text) {
        this.id = id;
        this.text = text;
    }

    private  int id;


    private  String text;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Qx{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
