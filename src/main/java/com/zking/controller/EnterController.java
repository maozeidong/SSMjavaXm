package com.zking.controller;

import com.zking.dao.IEnterDao;
import com.zking.dao.impl.EnterImpl;
import com.zking.pojo.Client;
import com.zking.pojo.Enter;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EnterController {

IEnterDao iEnterDao=new EnterImpl();



    @RequestMapping(value = "getselectenterlogin")
    public  void getselectenterlogin(HttpServletRequest request, HttpServletResponse response) throws  Exception {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        String mname=request.getParameter("mname");
        String mpwd=request.getParameter("mpwd");

        Enter enter=new Enter();
        enter.setUsername(mname);
        enter.setPassword(mpwd);

        Enter enter1=iEnterDao.selectenterlogin(enter);

        PrintWriter out=response.getWriter();
        HttpSession session=request.getSession();
        if (enter1.getId()>0){

            out.print("Y");
            session.setAttribute("id",enter1.getJid());
            session.setAttribute("username",mname);
        }else{

            out.print("S");

        }
        out.flush();
        out.close();



    }



}
