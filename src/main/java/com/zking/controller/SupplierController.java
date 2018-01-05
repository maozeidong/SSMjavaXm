package com.zking.controller;

import com.zking.dao.ISupplierDao;
import com.zking.dao.impl.SupplierImpl;
import com.zking.pojo.Bank;
import com.zking.pojo.Client;
import com.zking.pojo.Supplier;
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
public class SupplierController {


ISupplierDao iSupplierDao=new SupplierImpl();


    @RequestMapping(value = "getAllSupplier")
    public  void getAllSupplier(HttpServletRequest request, HttpServletResponse response) throws  Exception {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        int page=Integer.parseInt(request.getParameter("page"));
        int rows=Integer.parseInt(request.getParameter("rows"));
        page-=1;
        String  suppliername=request.getParameter("suppliername");

        Supplier supplier=new Supplier();
        supplier.setStart(page*rows);
        supplier.setEnd(rows);
        supplier.setSuppliername(suppliername);

        List<Supplier> list=iSupplierDao.getAll(supplier);
        int total=iSupplierDao.getAllCount(supplier);

        List<Map<String,Object>> mapList=new ArrayList<Map<String, Object>>();
        for (Supplier supplier1 : list) {
            Map<String,Object> map=new HashMap<String, Object>();
            map.put("id",supplier1.getId());
            map.put("suppliername",supplier1.getSuppliername());
            map.put("suppliershort",supplier1.getSuppliershort());
            map.put("supplieraddress",supplier1.getSupplieraddress());
            map.put("suppliertelephone",supplier1.getSuppliertelephone());
            map.put("supplieremail",supplier1.getSupplieremail());
            map.put("supplierzipcode",supplier1.getSupplierzipcode());
            map.put("supplieraccount",supplier1.getSupplieraccount());
            map.put("openingbank",supplier1.getBank().getOpeningbank());
            map.put("faxtosupplier",supplier1.getFaxtosupplier());
            map.put("suppliercontact",supplier1.getSuppliercontact());
            map.put("suppliercontactnumber",supplier1.getSuppliercontactnumber());
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






    @RequestMapping(value = "getAllBank")
    public  void getAllBank(HttpServletRequest request, HttpServletResponse response) throws  Exception {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");

        List<Bank> list=iSupplierDao.getAllBank();
        JSONArray jsonArray=JSONArray.fromObject(list);
        String str=jsonArray.toString();
        PrintWriter out=response.getWriter();
        System.out.println(str);
        out.print(str);
        out.flush();
        out.close();

    }

    @RequestMapping(value = "getinsertsupplier")
    public  void getinsertsupplier(HttpServletRequest request, HttpServletResponse response) throws  Exception {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        System.out.println("aa");
        Supplier supplier=new Supplier();
        String suppliernamea=request.getParameter("suppliernamea");
        System.out.println(suppliernamea+"aaaa");
        supplier.setSuppliername(suppliernamea);

        String suppliershorta=request.getParameter("suppliershorta");
        System.out.println(suppliershorta+"bbb");
        supplier.setSuppliershort(suppliershorta);

        String supplierzipcodea=request.getParameter("supplierzipcodea");
        System.out.println(supplierzipcodea+"ccc");
        supplier.setSupplierzipcode(supplierzipcodea);

        String supplieraddressa=request.getParameter("supplieraddressa");
        System.out.println(supplieraddressa+"ddd");
        supplier.setSupplieraddress(supplieraddressa);

        String suppliertelephonea=request.getParameter("suppliertelephonea");
        System.out.println(suppliertelephonea+"eee");
        supplier.setSuppliertelephone(suppliertelephonea);

        String faxtosuppliera=request.getParameter("faxtosuppliera");
        System.out.println(faxtosuppliera+"fff");
        supplier.setFaxtosupplier(faxtosuppliera);

        String suppliercontacta=request.getParameter("suppliercontacta");
        System.out.println(suppliercontacta+"ggg");
        supplier.setSuppliercontact(suppliercontacta);

        String suppliercontactnumbera=request.getParameter("suppliercontactnumbera");
        System.out.println(suppliercontactnumbera+"hhh");
        supplier.setSuppliercontactnumber(suppliercontactnumbera);

        String supplieraccounta=request.getParameter("supplieraccounta");
        System.out.println(supplieraccounta+"11");
        supplier.setSupplieraccount(supplieraccounta);

        String supplieremaila=request.getParameter("supplieremaila");
        System.out.println(supplieremaila+"22");
        supplier.setSupplieremail(supplieremaila);

        int opida=Integer.parseInt(request.getParameter("opida"));
        System.out.println(opida+"33");
        supplier.setOpid(opida);




        PrintWriter out=response.getWriter();
        if (iSupplierDao.insertselect(supplier)>0){

            out.write("G");
        }else{
            int index =iSupplierDao.insertsupplier(supplier);

            if (index>0){
                out.write("Y");
            }else{
                out.write("S");
            }
        }




        out.flush();
        out.close();

    }




    @RequestMapping(value = "getdeletesupplier")
    public  void getdeletesupplier(HttpServletRequest request, HttpServletResponse response) throws  Exception {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");

        int id=Integer.parseInt(request.getParameter("ida"));

        int index =iSupplierDao.deletesupplier(id);

        PrintWriter out=response.getWriter();
      if (index>0){
          out.write("Y");
      }else{
          out.write("S");

      }
        out.flush();
        out.close();

}






    @RequestMapping(value = "getupdatesupplier")
    public  void getupdatesupplier(HttpServletRequest request, HttpServletResponse response) throws  Exception {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
         Supplier supplier=new Supplier();
        int id=Integer.parseInt(request.getParameter("ida"));
        supplier.setId(id);

        String suppliernamea=request.getParameter("suppliernamea");
        System.out.println(suppliernamea+"aaaa");
        supplier.setSuppliername(suppliernamea);

        String suppliershorta=request.getParameter("suppliershorta");
        System.out.println(suppliershorta+"bbb");
        supplier.setSuppliershort(suppliershorta);

        String supplierzipcodea=request.getParameter("supplierzipcodea");
        System.out.println(supplierzipcodea+"ccc");
        supplier.setSupplierzipcode(supplierzipcodea);

        String supplieraddressa=request.getParameter("supplieraddressa");
        System.out.println(supplieraddressa+"ddd");
        supplier.setSupplieraddress(supplieraddressa);

        String suppliertelephonea=request.getParameter("suppliertelephonea");
        System.out.println(suppliertelephonea+"eee");
        supplier.setSuppliertelephone(suppliertelephonea);

        String faxtosuppliera=request.getParameter("faxtosuppliera");
        System.out.println(faxtosuppliera+"fff");
        supplier.setFaxtosupplier(faxtosuppliera);

        String suppliercontacta=request.getParameter("suppliercontacta");
        System.out.println(suppliercontacta+"ggg");
        supplier.setSuppliercontact(suppliercontacta);

        String suppliercontactnumbera=request.getParameter("suppliercontactnumbera");
        System.out.println(suppliercontactnumbera+"hhh");
        supplier.setSuppliercontactnumber(suppliercontactnumbera);

        String supplieraccounta=request.getParameter("supplieraccounta");
        System.out.println(supplieraccounta+"11");
        supplier.setSupplieraccount(supplieraccounta);

        String supplieremaila=request.getParameter("supplieremaila");
        System.out.println(supplieremaila+"22");
        supplier.setSupplieremail(supplieremaila);

        String opidaa=request.getParameter("opidaa");


        PrintWriter out=response.getWriter();

        if ("--请选择--".equals(opidaa)){

            if (iSupplierDao.updatesupplierabc(supplier)>0){
                out.write("Y");
            }else{
                out.write("S");
            }

        }else{

            int opida=Integer.parseInt(request.getParameter("opida"));
            supplier.setOpid(opida);
            if (iSupplierDao.updatesupplier(supplier)>0){
                out.write("Y");
            }else{
                out.write("S");
            }
        }


        out.flush();
        out.close();

    }













    @RequestMapping(value = "selectsupplierAll")
    public  void selectsupplierAll(HttpServletRequest request, HttpServletResponse response) throws  Exception {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        List<Supplier> list=iSupplierDao.selectsupplierAll();
        JSONArray jsonArray=JSONArray.fromObject(list);
        String str=jsonArray.toString();
        PrintWriter out=response.getWriter();
        out.print(str);
        out.flush();
        out.close();
    }





}
