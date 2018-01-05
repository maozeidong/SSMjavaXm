package com.zking.dao.impl;

import com.zking.dao.ICommodityDao;
import com.zking.dao.IEnterDao;
import com.zking.pojo.Enter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EnterImpl implements IEnterDao {

    ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext-public.xml");
    IEnterDao iEnterDao= (IEnterDao) applicationContext.getBean("IEnterDaomapper");

    public Enter selectenterlogin(Enter enter) {
        return iEnterDao.selectenterlogin(enter);
    }
}
