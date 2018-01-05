package com.zking.dao;

import com.zking.pojo.Client;

import java.util.List;

public interface IClientDao {


    public List<Client> getAll(Client client);



    public  int getAllCount(Client client);



    public  int insertClient(Client client);



    public  int selectclientinsert(Client client);


    public  int deleteclient(int id);


    public int updateclient(Client client);


    public  int updateclientabc(Client client);

}
