package com.zking.dao;

import com.zking.pojo.Mainmenu;
import com.zking.pojo.Qx;

import java.util.List;

public interface IMainmenuDao {


    /**
     * 父菜单
     * @param mparent
     * @return
     */
    public List<Mainmenu> getAll(int mparent );


    /**
     * 子菜单
     * @param qx
     * @return
     */
    public List<Mainmenu> getA(Qx qx);


}
