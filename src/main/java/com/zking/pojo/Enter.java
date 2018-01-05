package com.zking.pojo;

public class Enter {

    public Enter() {
        super();
    }

    public Enter(int id, String username, String password, int jid) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.jid = jid;
    }

    private  int  id;



    private String username;


    private  String password;


    private  int jid;

    public int getJid() {
        return jid;
    }

    public void setJid(int jid) {
        this.jid = jid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Enter{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
