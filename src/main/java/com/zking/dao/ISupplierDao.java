package com.zking.dao;

import com.zking.pojo.Bank;
import com.zking.pojo.Client;
import com.zking.pojo.Supplier;

import java.util.List;

public interface ISupplierDao {


    public List<Supplier> getAll(Supplier supplier);



    public  int getAllCount(Supplier supplier);



    public List<Bank> getAllBank();



    public  int insertsupplier(Supplier supplier);



    public int deletesupplier(int id);



    public  int insertselect(Supplier supplier);



    public  int updatesupplier(Supplier supplier);


    public  int updatesupplierabc(Supplier supplier);



    public  List<Supplier> selectsupplierAll();
}
