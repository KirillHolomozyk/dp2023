package Servlets;

import Crud.CrudInterface;
import Entity.Entity;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import grenades.RiflesList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/servlet/*")
public class Servlet extends HttpServlet {

    //private static final long serialVersionUID = 1L;
    private List<Entity> lu = new RiflesList().getRiflesList();
    ServletConfigInterface servletConfig;
    CrudInterface crud;

    public Servlet(){
        super();
        this.servletConfig = new ServletConfig();
        this.crud = servletConfig.getCrud();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("application/json");
        String someJson = new Gson().toJson(lu);
        PrintWriter out = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        out.print(someJson);
        out.flush();
    }


    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Entity grnd = crud.riffleParse(request);
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        response.setContentType("application/json");
        int index = crud.getIndexByGrenadeId(id, lu);
        lu.set(index, grnd);
        doGet(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Entity grnd = crud.riffleParse(request);
        grnd.setId(crud.getNextId(lu));
        lu.add(grnd);
        doGet(request, response);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getPathInfo().substring(1));
        response.setContentType("application/json");
        int index = crud.getIndexByGrenadeId(id, lu);
        lu.remove(index);
        doGet(request, response);
    }
}
