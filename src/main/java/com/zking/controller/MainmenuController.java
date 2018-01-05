package com.zking.controller;

import com.zking.dao.IMainmenuDao;
import com.zking.dao.impl.MainmenuImpl;
import com.zking.pojo.Mainmenu;
import com.zking.pojo.Qx;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;
@Controller
public class MainmenuController {

    IMainmenuDao iMainmenuDao=new MainmenuImpl();

    @RequestMapping(value = "getAllMainmenu")
    public  void getAllMainmenu(HttpServletRequest request, HttpServletResponse response) throws  Exception {
     request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        String text=request.getParameter("text");

        HttpSession session=request.getSession();
        List<Mainmenu> list=null;
        if (text!=null){
            int id=Integer.parseInt(session.getAttribute("id").toString());
             Qx qx=new Qx();
             qx.setId(id);
             qx.setText(text);
            list=iMainmenuDao.getA(qx);

        }else{
      int mparent=Integer.parseInt(session.getAttribute("id").toString());
            list=iMainmenuDao.getAll(mparent);

        }

        JSONArray jsonArray=JSONArray.fromObject(list);
        String str=jsonArray.toString();
        PrintWriter out=response.getWriter();
        System.out.println(str);
        out.print(str);
        out.flush();
        out.close();

    }
}
