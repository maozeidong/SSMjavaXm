package com.zking.dao;

import com.zking.pojo.Client;
import com.zking.pojo.Commodity;

import java.util.List;

public interface ICommodityDao {




    public List<Commodity> getAll(Commodity commodity);



    public  int getAllCount(Commodity commodity);


    public int insertCommodity(Commodity commodity);


    public  int selectinsertcommodity(Commodity commodity);



    public  int deletecommodity(int id);



    public int updatecommodityAll(Commodity commodity);



    public  int updatecommodity(Commodity commodity);
}
