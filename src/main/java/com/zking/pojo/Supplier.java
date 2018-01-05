package com.zking.pojo;

public class Supplier {

    public Supplier() {
        super();
    }

    public Supplier(int id, String suppliername, String suppliershort, String supplieraddress, String suppliertelephone, String supplieremail, String supplierzipcode, String supplieraccount, int opid, String faxtosupplier, String suppliercontact, String suppliercontactnumber) {
        this.id = id;
        this.suppliername = suppliername;
        this.suppliershort = suppliershort;
        this.supplieraddress = supplieraddress;
        this.suppliertelephone = suppliertelephone;
        this.supplieremail = supplieremail;
        this.supplierzipcode = supplierzipcode;
        this.supplieraccount = supplieraccount;
        this.opid = opid;
        this.faxtosupplier = faxtosupplier;
        this.suppliercontact = suppliercontact;
        this.suppliercontactnumber = suppliercontactnumber;
    }

    private int id;


    private String suppliername;

    private String suppliershort;

    private String supplieraddress;


    private String suppliertelephone;


    private String supplieremail;


    private String supplierzipcode;


    private String supplieraccount;


    private int opid;

    private String faxtosupplier;


    private String suppliercontact;


    private String suppliercontactnumber;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername;
    }

    public String getSuppliershort() {
        return suppliershort;
    }

    public void setSuppliershort(String suppliershort) {
        this.suppliershort = suppliershort;
    }

    public String getSupplieraddress() {
        return supplieraddress;
    }

    public void setSupplieraddress(String supplieraddress) {
        this.supplieraddress = supplieraddress;
    }

    public String getSuppliertelephone() {
        return suppliertelephone;
    }

    public void setSuppliertelephone(String suppliertelephone) {
        this.suppliertelephone = suppliertelephone;
    }

    public String getSupplieremail() {
        return supplieremail;
    }

    public void setSupplieremail(String supplieremail) {
        this.supplieremail = supplieremail;
    }

    public String getSupplierzipcode() {
        return supplierzipcode;
    }

    public void setSupplierzipcode(String supplierzipcode) {
        this.supplierzipcode = supplierzipcode;
    }

    public String getSupplieraccount() {
        return supplieraccount;
    }

    public void setSupplieraccount(String supplieraccount) {
        this.supplieraccount = supplieraccount;
    }

    public int getOpid() {
        return opid;
    }

    public void setOpid(int opid) {
        this.opid = opid;
    }

    public String getFaxtosupplier() {
        return faxtosupplier;
    }

    public void setFaxtosupplier(String faxtosupplier) {
        this.faxtosupplier = faxtosupplier;
    }

    public String getSuppliercontact() {
        return suppliercontact;
    }

    public void setSuppliercontact(String suppliercontact) {
        this.suppliercontact = suppliercontact;
    }

    public String getSuppliercontactnumber() {
        return suppliercontactnumber;
    }

    public void setSuppliercontactnumber(String suppliercontactnumber) {
        this.suppliercontactnumber = suppliercontactnumber;
    }






    /*一对一*/
    private  Bank bank;

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
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
        return "Supplier{" +
                "id=" + id +
                ", suppliername='" + suppliername + '\'' +
                ", suppliershort='" + suppliershort + '\'' +
                ", supplieraddress='" + supplieraddress + '\'' +
                ", suppliertelephone='" + suppliertelephone + '\'' +
                ", supplieremail='" + supplieremail + '\'' +
                ", supplierzipcode='" + supplierzipcode + '\'' +
                ", supplieraccount='" + supplieraccount + '\'' +
                ", opid=" + opid +
                ", faxtosupplier='" + faxtosupplier + '\'' +
                ", suppliercontact='" + suppliercontact + '\'' +
                ", suppliercontactnumber='" + suppliercontactnumber + '\'' +
                '}';
    }
}
