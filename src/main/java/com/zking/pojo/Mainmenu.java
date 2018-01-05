package com.zking.pojo;

public class Mainmenu {


    public Mainmenu() {
        super();
    }

    public Mainmenu(int mid, String text, String miconCls, int mparent, String murl) {
        this.mid = mid;
        this.text = text;
        this.miconCls = miconCls;
        this.mparent = mparent;
        this.murl = murl;
    }

    private int mid;

    private String text;

    private String miconCls;

    private int mparent;


    private String murl;


    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMiconCls() {
        return miconCls;
    }

    public void setMiconCls(String miconCls) {
        this.miconCls = miconCls;
    }

    public int getMparent() {
        return mparent;
    }

    public void setMparent(int mparent) {
        this.mparent = mparent;
    }

    public String getMurl() {
        return murl;
    }

    public void setMurl(String murl) {
        this.murl = murl;
    }

    @Override
    public String toString() {
        return "Mainmenu{" +
                "mid=" + mid +
                ", text='" + text + '\'' +
                ", miconCls='" + miconCls + '\'' +
                ", mparent=" + mparent +
                ", murl='" + murl + '\'' +
                '}';
    }
}
