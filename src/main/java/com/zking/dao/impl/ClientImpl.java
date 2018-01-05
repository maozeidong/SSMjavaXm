package com.zking.dao.impl;

import com.zking.dao.IClientDao;
import com.zking.dao.IMainmenuDao;
import com.zking.pojo.Client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ClientImpl implements  IClientDao {

    ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext-public.xml");
    IClientDao clientDao= (IClientDao) applicationContext.getBean("IClientDaomapper");

    public List<Client> getAll(Client client) {
        return clientDao.getAll(client);
    }

    public int getAllCount(Client client) {
        return clientDao.getAllCount(client);
    }


    public int insertClient(Client client) {
        return clientDao.insertClient(client);
    }

    public int selectclientinsert(Client client) {
        return clientDao.selectclientinsert(client);
    }


    public int deleteclient(int id) {
        return clientDao.deleteclient(id);
    }

    public int updateclient(Client client) {
        return clientDao.updateclient(client);
    }

    public int updateclientabc(Client client) {
        return clientDao.updateclientabc(client);
    }
}
