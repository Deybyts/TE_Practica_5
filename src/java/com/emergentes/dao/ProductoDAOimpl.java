
package com.emergentes.dao;

import com.emergentes.modelo.Producto;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOimpl extends ConexionBD implements ProductoDAO{

    @Override
    public void insert(Producto producto) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT into productos (descripcion,stock) values (?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, producto.getDescripcion());
            ps.setInt(2, producto.getStock());
            ps.executeUpdate();
        } catch (Exception e) {
            //throws e;
            System.out.println("Error al insertar "+e.getMessage());
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Producto producto) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE productos set descripcion=?, stock=? where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, producto.getDescripcion());
            ps.setInt(2, producto.getStock());
            ps.setInt(3, producto.getId());
            //Ejecutamos
            ps.executeUpdate();
        } catch (Exception e) {
            //throws e;
            System.out.println("Error al insertar "+e.getMessage());
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE from productos where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            //Ejecutamos
            ps.executeUpdate();
        } catch (Exception e) {
            //throws e;
            System.out.println("Error al insertar "+e.getMessage());
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Producto getById(int id) throws Exception {
        Producto avi = new Producto();
        try {
            this.conectar();
            String sql = "SELECT * from productos where id=?";
            PreparedStatement ps =this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                avi.setId(rs.getInt("id"));
                avi.setDescripcion(rs.getString("descripcion"));
                avi.setStock(rs.getInt("stock"));
            }
        } catch (Exception e) {
            //throws e;
            System.out.println("Error al insertar "+e.getMessage());
        }finally {
            this.desconectar();
        }
        return avi;
    }

    @Override
    public List<Producto> getAll() throws Exception {
        List<Producto> lista = null;
        lista = new ArrayList<Producto>();
        try {
            this.conectar();
            String sql = "SELECT * from productos";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Producto avi = new Producto();
                avi.setId(rs.getInt("id"));
                avi.setDescripcion(rs.getString("descripcion"));
                avi.setStock(rs.getInt("stock"));
                lista.add(avi);
            }
           
        } catch (Exception e) {
            //throws e;
            System.out.println("Error de exepxion "+e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }
}
