package com.zking.controller;

import com.zking.dao.IClientDao;
import com.zking.dao.impl.ClientImpl;
import com.zking.pojo.Client;
import com.zking.pojo.Mainmenu;
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
public class ClientController {

IClientDao iClientDao=new ClientImpl();


    @RequestMapping(value = "getAllClient")
    public  void getAllClient(HttpServletRequest request, HttpServletResponse response) throws  Exception {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        int page=Integer.parseInt(request.getParameter("page"));
        int rows=Integer.parseInt(request.getParameter("rows"));
        page-=1;
        String  customername=request.getParameter("customername");

        Client client=new Client();
        client.setStart(page*rows);
        client.setEnd(rows);
        client.setCustomername(customername);

        List<Client> list=iClientDao.getAll(client);
        int total=iClientDao.getAllCount(client);

        List<Map<String,Object>> mapList=new ArrayList<Map<String, Object>>();
        for (Client client1 : list) {
            Map<String,Object> map=new HashMap<String, Object>();
            map.put("id",client1.getId());
            map.put("customername",client1.getCustomername());
            map.put("altek",client1.getAltek());
            map.put("customeraddress",client1.getCustomeraddress());
            map.put("customerphone",client1.getCustomerphone());
            map.put("customeremail",client1.getCustomeremail());
            map.put("customerzipcode",client1.getCustomerzipcode());
            map.put("requesting",client1.getRequesting());
            map.put("openingbank",client1.getBank().getOpeningbank());
            map.put("customerfax",client1.getCustomerfax());
            map.put("persontocontact",client1.getPersontocontact());
            map.put("contactnumber",client1.getContactnumber());
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






    @RequestMapping(value = "getinsertClient")
    public  void getinsertClient(HttpServletRequest request, HttpServletResponse response) throws  Exception {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        System.out.println("aa");
       Client client=new Client();
        String customernamea=request.getParameter("customernamea");
        System.out.println(customernamea+"aaaa");
        client.setCustomername(customernamea);

        String alteka=request.getParameter("alteka");
        System.out.println(alteka+"bbb");
        client.setAltek(alteka);

        String customeraddressa=request.getParameter("customeraddressa");
        System.out.println(customeraddressa+"ccc");
        client.setCustomeraddress(customeraddressa);

        String customerphonea=request.getParameter("customerphonea");
        System.out.println(customerphonea+"ddd");
        client.setCustomerphone(customerphonea);

        String customeremaila=request.getParameter("customeremaila");
        System.out.println(customeremaila+"eee");
        client.setCustomeremail(customeremaila);

        String customerzipcodea=request.getParameter("customerzipcodea");
        System.out.println(customerzipcodea+"fff");
        client.setCustomerzipcode(customerzipcodea);

        String requestinga=request.getParameter("requestinga");
        System.out.println(requestinga+"ggg");
        client.setRequesting(requestinga);

        String customerfaxa=request.getParameter("customerfaxa");
        System.out.println(customerfaxa+"hhh");
        client.setCustomerfax(customerfaxa);

        String persontocontacta=request.getParameter("persontocontacta");
        System.out.println(persontocontacta+"11");
        client.setPersontocontact(persontocontacta);

        String contactnumbera=request.getParameter("contactnumbera");
        System.out.println(contactnumbera+"22");
        client.setContactnumber(contactnumbera);

        int opida=Integer.parseInt(request.getParameter("opida"));
        System.out.println(opida+"33");
        client.setOpid(opida);




        PrintWriter out=response.getWriter();
        if (iClientDao.selectclientinsert(client)>0){

            out.write("G");
        }else{
            int index =iClientDao.insertClient(client);

            if (index>0){
                out.write("Y");
            }else{
                out.write("S");
            }
        }




        out.flush();
        out.close();

    }


    @RequestMapping(value = "getdeleteclient")
    public  void getdeleteclient(HttpServletRequest request, HttpServletResponse response) throws  Exception {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");

        int id=Integer.parseInt(request.getParameter("ida"));

        int index =iClientDao.deleteclient(id);

        PrintWriter out=response.getWriter();
        if (index>0){
            out.write("Y");
        }else{
            out.write("S");

        }
        out.flush();
        out.close();

    }






    @RequestMapping(value = "getupdateclient")
    public  void getupdateclient(HttpServletRequest request, HttpServletResponse response) throws  Exception {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        System.out.println("aa");
        Client client=new Client();

        int ida=Integer.parseInt(request.getParameter("ida"));
        client.setId(ida);
        String customernamea=request.getParameter("customernamea");
        System.out.println(customernamea+"aaaa");
        client.setCustomername(customernamea);

        String alteka=request.getParameter("alteka");
        System.out.println(alteka+"bbb");
        client.setAltek(alteka);

        String customeraddressa=request.getParameter("customeraddressa");
        System.out.println(customeraddressa+"ccc");
        client.setCustomeraddress(customeraddressa);

        String customerphonea=request.getParameter("customerphonea");
        System.out.println(customerphonea+"ddd");
        client.setCustomerphone(customerphonea);

        String customeremaila=request.getParameter("customeremaila");
        System.out.println(customeremaila+"eee");
        client.setCustomeremail(customeremaila);

        String customerzipcodea=request.getParameter("customerzipcodea");
        System.out.println(customerzipcodea+"fff");
        client.setCustomerzipcode(customerzipcodea);

        String requestinga=request.getParameter("requestinga");
        System.out.println(requestinga+"ggg");
        client.setRequesting(requestinga);

        String customerfaxa=request.getParameter("customerfaxa");
        System.out.println(customerfaxa+"hhh");
        client.setCustomerfax(customerfaxa);

        String persontocontacta=request.getParameter("persontocontacta");
        System.out.println(persontocontacta+"11");
        client.setPersontocontact(persontocontacta);

        String contactnumbera=request.getParameter("contactnumbera");
        System.out.println(contactnumbera+"22");
        client.setContactnumber(contactnumbera);

        String opidaa=request.getParameter("opidaa");
        PrintWriter out=response.getWriter();
        if ("--请选择--".equals(opidaa)){

            if (iClientDao.updateclientabc(client)>0){
                out.write("Y");
            }else{
                out.write("S");
            }

        }else{
            int opida=Integer.parseInt(request.getParameter("opida"));
            System.out.println(opida+"33");
            client.setOpid(opida);

            if (iClientDao.updateclient(client)>0){
                out.write("Y");
            }else{
                out.write("S");
            }
        }
        out.flush();
        out.close();

    }


}
