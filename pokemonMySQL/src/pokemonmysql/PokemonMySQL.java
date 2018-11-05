/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonmysql;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author alumno
 */
public class PokemonMySQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        //PASO 1  AÑADIR LIBRERIA DEL DRIVER DE MYSQL
        //PASO 2 INSTANCIAR - MYSQLDATASOURCE
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setServerName("localhost");//DIRECCION DEL SERVIDOR DE BASE DE DATOS 
            dataSource.setDatabaseName("pokemonbd");// NOMBRE DE LA BASE DE BASE DE DATOS A LA CUAL SE VA A CONECTAR
            dataSource.setUser("root");
            dataSource.setPassword("");
            //PASO 3  - OBTENER UNA CONEXION DEL DATA SOURCE
            Connection connection = dataSource.getConnection();
            
            //PASO 4 - CREAR LA SENTENCIA 
            Statement sentencia = connection.createStatement();
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del pokemon: ");
            String tipo = JOptionPane.showInputDialog("Ingrese el tipo del pokemon: ");
            int  nivel = Integer.valueOf(JOptionPane.showInputDialog("Ingrese el nivel del pokemon: "));
            int  vida = Integer.valueOf(JOptionPane.showInputDialog("Ingrese la vida del pokemon: "));
            //PASO 5 - DEFINIR LA SENTENCIA Y EJECTUAR 
            sentencia.executeUpdate("INSERT INTO pokemones (codigo, nombre, tipo, nivel, vida) VALUES (NULL,'"+nombre+"','"+tipo+"','"+nivel+"','"+vida+"')");
            


            // CODIGO DE INSERCION DE BASE DE DATOS - INSERT INTO NOMBRE DE BASE DE DATOS (codigo, nombre, tipo, nivel, vida) VALUES (null, "pikachu", "electrico","1","50")  
            
            //PASO 4B - CREA preparedStatement
            
            //PreparedStatement prep= connection.prepareStatement("INSERT INTO pokemones (codigo, nombre, tipo, nivel, vida) VALUES(?,?,?,?)");
            //prep.setString(1, nombre);
            //prep.setString(2, tipo);
            //prep.setInt(3, nivel);
            //prep.setInt(4, vida);
            
            //PASO 5B - EJECUTAR LA SENTENCIA PREPARADA
            //prep.executeUpdate();
            
            //PASO 4C - CREAR preparedStatement
            //PreparedStatement prep = connection.prepareStatement("SELECT * FROM pokemones");
            
            //PASO 5C - Obtener un result set
            //ResultSet rs = prep.executeQuery();
            
            //Paso 6c - iterar el result set
            //while(rs.next()){
                //String n = rs.getString("nombre");
                //String t = rs.getString("tipo");
                //int niv = rs.getInt("nivel");
                //int v = rs.getInt("vida");
                
                //System.out.println("Pokemon: " + n + "Tipo: " + t );
            }
    }
