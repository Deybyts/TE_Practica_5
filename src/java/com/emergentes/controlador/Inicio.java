package com.emergentes.controlador;

import com.emergentes.dao.ProductoDAO;
import com.emergentes.dao.ProductoDAOimpl;
import com.emergentes.modelo.Producto;
import com.emergentes.utiles.ConexionBD;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            ConexionBD canal = new ConexionBD();
            Connection conn = canal.conectar();
            ProductoDAO dao = new ProductoDAOimpl();
            int id;
            Producto pd = new Producto();
            String action;
            action = action = (request.getParameter("action") != null) ? request.getParameter("action") : "list";
            switch(action){
                case "list":
                    List<Producto> lista = dao.getAll();
                    request.setAttribute("lista", lista);
                    request.getRequestDispatcher("ini.jsp").forward(request, response);
                case "add":
                    request.setAttribute("product", pd);
                    request.getRequestDispatcher("formproducto.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    pd = dao.getById(id);
                    request.setAttribute("product", pd);
                    request.getRequestDispatcher("formproducto.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("Inicio");
                    break;
                
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error :"+e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       ProductoDAO dao = new ProductoDAOimpl();
       int id = Integer.parseInt(request.getParameter("id"));
       String descripcion = request.getParameter("descripcion");
       int stock = Integer.parseInt(request.getParameter("stock"));
       Producto pd = new Producto();
       pd.setId(id);
       pd.setDescripcion(descripcion);
       pd.setStock(stock);
       if(id==0){
           try {
               dao.insert(pd);
               response.sendRedirect("Inicio");
           } catch (Exception e) {
               System.out.println("Error :"+e.getMessage());
           }
       }else{
           try {
               dao.update(pd);
               response.sendRedirect("Inicio");
           } catch (Exception e) {
               System.out.println("Error :"+e.getMessage());
           }
       }
    }
}
