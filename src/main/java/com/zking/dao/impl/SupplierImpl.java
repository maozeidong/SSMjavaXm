package com.zking.dao.impl;

import com.zking.dao.IMainmenuDao;
import com.zking.dao.ISupplierDao;
import com.zking.pojo.Bank;
import com.zking.pojo.Supplier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SupplierImpl implements ISupplierDao {

    ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext-public.xml");
    ISupplierDao iSupplierDao= (ISupplierDao) applicationContext.getBean("ISupplierDaomapper");


    public List<Supplier> getAll(Supplier supplier) {
        return iSupplierDao.getAll(supplier);
    }

    public int getAllCount(Supplier supplier) {
        return iSupplierDao.getAllCount(supplier);
    }


    public List<Bank> getAllBank() {
        return iSupplierDao.getAllBank();
    }

    public int insertsupplier(Supplier supplier) {
        return iSupplierDao.insertsupplier(supplier);
    }


    public int deletesupplier(int id) {
        return iSupplierDao.deletesupplier(id);
    }

    public int insertselect(Supplier supplier) {
        return iSupplierDao.insertselect(supplier);
    }


    public int updatesupplier(Supplier supplier) {
        return iSupplierDao.updatesupplier(supplier);
    }


    public int updatesupplierabc(Supplier supplier) {
        return iSupplierDao.updatesupplierabc(supplier);
    }


    public List<Supplier> selectsupplierAll() {
        return iSupplierDao.selectsupplierAll();
    }
}
