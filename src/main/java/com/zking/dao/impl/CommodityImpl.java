package com.zking.dao.impl;

import com.zking.dao.IClientDao;
import com.zking.dao.ICommodityDao;
import com.zking.pojo.Commodity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CommodityImpl implements ICommodityDao {
    ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext-public.xml");
    ICommodityDao iCommodityDao= (ICommodityDao) applicationContext.getBean("iCommodityDaomapper");


    public List<Commodity> getAll(Commodity commodity) {
        return iCommodityDao.getAll(commodity);
    }

    public int getAllCount(Commodity commodity) {
        return iCommodityDao.getAllCount(commodity);
    }

    public int insertCommodity(Commodity commodity) {
        return iCommodityDao.insertCommodity(commodity);
    }

    public int selectinsertcommodity(Commodity commodity) {
        return iCommodityDao.selectinsertcommodity(commodity);
    }


    public int deletecommodity(int id) {
        return iCommodityDao.deletecommodity(id);
    }


    public int updatecommodityAll(Commodity commodity) {
        return iCommodityDao.updatecommodityAll(commodity);
    }

    public int updatecommodity(Commodity commodity) {
        return iCommodityDao.updatecommodity(commodity);
    }
}
