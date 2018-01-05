package com.zking.controller;

import com.zking.dao.ICommodityDao;
import com.zking.dao.impl.CommodityImpl;
import com.zking.pojo.Client;
import com.zking.pojo.Commodity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CommodityController {

    ICommodityDao iCommodityDao=new CommodityImpl();



    @RequestMapping(value = "getAllCommodity")
    public  void getAllCommodity(HttpServletRequest request, HttpServletResponse response) throws  Exception {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        int page=Integer.parseInt(request.getParameter("page"));
        int rows=Integer.parseInt(request.getParameter("rows"));
        page-=1;
        String  productname=request.getParameter("productname");

        Commodity commodity=new Commodity();
        commodity.setStart(page*rows);
        commodity.setEnd(rows);
        commodity.setProductname(productname);

        List<Commodity> list=iCommodityDao.getAll(commodity);
        int total=iCommodityDao.getAllCount(commodity);

        List<Map<String,Object>> mapList=new ArrayList<Map<String, Object>>();
        for (Commodity commodity1 : list) {
            Map<String,Object> map=new HashMap<String, Object>();
            map.put("id",commodity1.getId());
            map.put("productname",commodity1.getProductname());
            map.put("commodityreferred",commodity1.getCommodityreferred());
            map.put("originofgoods",commodity1.getOriginofgoods());
            map.put("unit",commodity1.getUnit());
            map.put("suppliername",commodity1.getSupplier().getSuppliername());
            map.put("briefintroduction",commodity1.getBriefintroduction());
            map.put("approvalnumber",commodity1.getApprovalnumber());
            map.put("batchnumber",commodity1.getBatchnumber());
            map.put("specification",commodity1.getSpecification());
            map.put("packaging",commodity1.getPackaging());
            mapList.add(map);
        }
        JSONArray jsonArray=JSONArray.fromObject(mapList);
        String str=jsonArray.toString();
        PrintWriter out=response.getWriter();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("total",total);
        jsonObject.put("rows",str);
        String s=jsonObject.toString();
        System.out.println(s);
        out.print(s);
        out.flush();
        out.close();

    }

    @RequestMapping(value = "getinsertCommodity")
    public  void getinsertCommodity(HttpServletRequest request, HttpServletResponse response) throws  Exception {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");

        Commodity commodity=new Commodity();
        String productnamea=request.getParameter("productnamea");
        commodity.setProductname(productnamea);
        String commodityreferreda=request.getParameter("commodityreferreda");
        commodity.setCommodityreferred(commodityreferreda);
        String originofgoodsa=request.getParameter("originofgoodsa");
        commodity.setOriginofgoods(originofgoodsa);
        String unita=request.getParameter("unita");
        commodity.setUnit(unita);
        String briefintroductiona=request.getParameter("briefintroductiona");
        commodity.setBriefintroduction(briefintroductiona);
        String approvalnumbera=request.getParameter("approvalnumbera");
        commodity.setApprovalnumber(approvalnumbera);
        String batchnumbera=request.getParameter("batchnumbera");
        commodity.setBatchnumber(batchnumbera);
        String specificationa=request.getParameter("specificationa");
        commodity.setSpecification(specificationa);
        String packaginga=request.getParameter("packaginga");
        commodity.setPackaging(packaginga);
        int suppliernamea=Integer.parseInt(request.getParameter("suppliernamea"));
        commodity.setSid(suppliernamea);

        PrintWriter out=response.getWriter();

        if (iCommodityDao.selectinsertcommodity(commodity)>0){

            out.print("G");

        }else{
            int index =iCommodityDao.insertCommodity(commodity);

            if (index>0){
                out.print("Y");
            }else{
                out.print("S");
            }
        }
        out.flush();
        out.close();






    }


    @RequestMapping(value = "getdeletecommodity")
    public  void getdeletecommodity(HttpServletRequest request, HttpServletResponse response) throws  Exception {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");

        int id=Integer.parseInt(request.getParameter("ida"));
        PrintWriter out=response.getWriter();
        if (iCommodityDao.deletecommodity(id)>0){
            out.print("Y");
        }else{
            out.print("S");
        }

        out.flush();
        out.close();






    }


    @RequestMapping(value = "getupdatecommodityAll")
    public  void getupdatecommodityAll(HttpServletRequest request, HttpServletResponse response) throws  Exception {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");


        Commodity commodity=new Commodity();
        int id=Integer.parseInt(request.getParameter("ida"));
        commodity.setId(id);
        String productnamea=request.getParameter("productnamea");
        commodity.setProductname(productnamea);
        String commodityreferreda=request.getParameter("commodityreferreda");
        commodity.setCommodityreferred(commodityreferreda);
        String originofgoodsa=request.getParameter("originofgoodsa");
        commodity.setOriginofgoods(originofgoodsa);
        String unita=request.getParameter("unita");
        commodity.setUnit(unita);
        String briefintroductiona=request.getParameter("briefintroductiona");
        commodity.setBriefintroduction(briefintroductiona);
        String approvalnumbera=request.getParameter("approvalnumbera");
        commodity.setApprovalnumber(approvalnumbera);
        String batchnumbera=request.getParameter("batchnumbera");
        commodity.setBatchnumber(batchnumbera);
        String specificationa=request.getParameter("specificationa");
        commodity.setSpecification(specificationa);
        String packaginga=request.getParameter("packaginga");
        commodity.setPackaging(packaginga);

        String suppliernameb=request.getParameter("suppliernameb");
        PrintWriter out=response.getWriter();

        if ("--请选择--".equals(suppliernameb)){

            if (iCommodityDao.updatecommodity(commodity)>0){

                out.print("Y");

            }else{

                out.print("S");
            }


        }else{

            int suppliernamea=Integer.parseInt(request.getParameter("suppliernamea"));
            commodity.setSid(suppliernamea);

            if (iCommodityDao.updatecommodityAll(commodity)>0){

                out.print("Y");

            }else{

                out.print("S");
            }
        }





        out.flush();
        out.close();






    }


}
