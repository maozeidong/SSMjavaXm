package com.zking.pojo;

public class Client {

    public Client() {
        super();
    }

    public Client(int id, String customername, String altek, String customeraddress, String customerphone, String customeremail, String customerzipcode, String requesting, int opid, String customerfax, String persontocontact, String contactnumber) {
        this.id = id;
        this.customername = customername;
        this.altek = altek;
        this.customeraddress = customeraddress;
        this.customerphone = customerphone;
        this.customeremail = customeremail;
        this.customerzipcode = customerzipcode;
        this.requesting = requesting;
        this.opid = opid;
        this.customerfax = customerfax;
        this.persontocontact = persontocontact;
        this.contactnumber = contactnumber;
    }

    private int id;


    private String customername;


    private String altek;

    private String customeraddress;


    private String customerphone;


    private String customeremail;


    private String customerzipcode;


    private String requesting;


    private int opid;


    private String customerfax;


    private String persontocontact;

    private String contactnumber;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getAltek() {
        return altek;
    }

    public void setAltek(String altek) {
        this.altek = altek;
    }

    public String getCustomeraddress() {
        return customeraddress;
    }

    public void setCustomeraddress(String customeraddress) {
        this.customeraddress = customeraddress;
    }

    public String getCustomerphone() {
        return customerphone;
    }

    public void setCustomerphone(String customerphone) {
        this.customerphone = customerphone;
    }

    public String getCustomeremail() {
        return customeremail;
    }

    public void setCustomeremail(String customeremail) {
        this.customeremail = customeremail;
    }

    public String getCustomerzipcode() {
        return customerzipcode;
    }

    public void setCustomerzipcode(String customerzipcode) {
        this.customerzipcode = customerzipcode;
    }

    public String getRequesting() {
        return requesting;
    }

    public void setRequesting(String requesting) {
        this.requesting = requesting;
    }

    public int getOpid() {
        return opid;
    }

    public void setOpid(int opid) {
        this.opid = opid;
    }

    public String getCustomerfax() {
        return customerfax;
    }

    public void setCustomerfax(String customerfax) {
        this.customerfax = customerfax;
    }

    public String getPersontocontact() {
        return persontocontact;
    }

    public void setPersontocontact(String persontocontact) {
        this.persontocontact = persontocontact;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }


    /**
     * 一对一
     */

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
        return "Client{" +
                "id=" + id +
                ", customername='" + customername + '\'' +
                ", altek='" + altek + '\'' +
                ", customeraddress='" + customeraddress + '\'' +
                ", customerphone='" + customerphone + '\'' +
                ", customeremail='" + customeremail + '\'' +
                ", customerzipcode='" + customerzipcode + '\'' +
                ", requesting='" + requesting + '\'' +
                ", opid=" + opid +
                ", customerfax='" + customerfax + '\'' +
                ", persontocontact='" + persontocontact + '\'' +
                ", contactnumber='" + contactnumber + '\'' +
                '}';
    }


}
