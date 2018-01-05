package com.zking.pojo;

public class Commodity {


    public Commodity() {
        super();
    }

    public Commodity(int id, String productname, String commodityreferred, String originofgoods, String unit, int sid, String briefintroduction, String approvalnumber, String batchnumber, String specification, String packaging) {
        this.id = id;
        this.productname = productname;
        this.commodityreferred = commodityreferred;
        this.originofgoods = originofgoods;
        this.unit = unit;
        this.sid = sid;
        this.briefintroduction = briefintroduction;
        this.approvalnumber = approvalnumber;
        this.batchnumber = batchnumber;
        this.specification = specification;
        this.packaging = packaging;
    }

    private  int id;


    private String productname;


    private  String commodityreferred;

    private  String originofgoods;

    private  String unit;

    private int  sid;

    private  String briefintroduction;

    private String approvalnumber;

    private String batchnumber;

    private  String specification;

    private String packaging;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getCommodityreferred() {
        return commodityreferred;
    }

    public void setCommodityreferred(String commodityreferred) {
        this.commodityreferred = commodityreferred;
    }

    public String getOriginofgoods() {
        return originofgoods;
    }

    public void setOriginofgoods(String originofgoods) {
        this.originofgoods = originofgoods;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getBriefintroduction() {
        return briefintroduction;
    }

    public void setBriefintroduction(String briefintroduction) {
        this.briefintroduction = briefintroduction;
    }

    public String getApprovalnumber() {
        return approvalnumber;
    }

    public void setApprovalnumber(String approvalnumber) {
        this.approvalnumber = approvalnumber;
    }

    public String getBatchnumber() {
        return batchnumber;
    }

    public void setBatchnumber(String batchnumber) {
        this.batchnumber = batchnumber;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    /**
     * 一对一
     */

    private  Supplier supplier;

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    /**
     * 分页
     */
    private  int  start;



    private  int end;


    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", productname='" + productname + '\'' +
                ", commodityreferred='" + commodityreferred + '\'' +
                ", originofgoods='" + originofgoods + '\'' +
                ", unit='" + unit + '\'' +
                ", sid=" + sid +
                ", briefintroduction='" + briefintroduction + '\'' +
                ", approvalnumber='" + approvalnumber + '\'' +
                ", batchnumber='" + batchnumber + '\'' +
                ", specification='" + specification + '\'' +
                ", packaging='" + packaging + '\'' +
                '}';
    }
}
