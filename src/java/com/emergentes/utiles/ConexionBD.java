
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bd_almacen";
    static String usuario = "root";
    static String password = "";
    
    //con esto prodremos realizar la coneccion para hacer consultas
    protected Connection conn = null;

    public ConexionBD() {
        try {
            //Especificamos con que driver nos va a conectar
            Class.forName(driver);
            //Llenamos con los valores de la coneccion
            conn = DriverManager.getConnection(url,usuario,password);
            //verifica si se a conectado
            if (conn != null){
                System.out.println("Conexión exitosa : " + conn);
            }
        //del con si tiene un error lo mandamos a este catch    
        }catch(SQLException ex){
            System.out.println("Error de SQL "+ex.getMessage());
        //verificamos si un driver no esta especificado
        }catch(ClassNotFoundException ex){
            System.out.println("Falta driver "+ex.getMessage());
        }
    }
    //Si existe una coneccion debuelve un estado
    public Connection conectar()
    {
        return conn;
    }
    //Evitados que haya concurrencia cuando se conectan varios
    public void desconectar()
    {
        try {
            System.out.println("Cerrando la BD"+conn);
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error de SQL "+ ex.getMessage());
        }
    }
}
