package com.zking.dao.impl;

import com.zking.dao.IMainmenuDao;
import com.zking.pojo.Mainmenu;
import com.zking.pojo.Qx;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainmenuImpl implements IMainmenuDao {

    ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext-public.xml");
    IMainmenuDao iMainmenuDao= (IMainmenuDao) applicationContext.getBean("IMainmenuDaomapper");


    public List<Mainmenu> getAll(int mparent ) {
        return iMainmenuDao.getAll( mparent );
    }


    public List<Mainmenu> getA(Qx qx) {
        return iMainmenuDao.getA(qx);
    }
}
