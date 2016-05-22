/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ConexionBD {
    
    Connection con = null;
    public ConexionBD()
    {
        realizarConexion();
    }
    public void realizarConexion()
    {
        try {
            String userName = "root";
            String password = "";
            System.out.print("2");
            String url = "jdbc:mysql://localhost:3306/matricula";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.print("3");
            con = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } 
    }
    
    /////////////////////////Metodos BD Estudiantes////////////////////////////////////////
    public boolean registrarEstudiante(String cedula, String nombre, String direccion)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO estudiantes(cedula, nombre, direccion) VALUES ('"+cedula+"','"+nombre+"','"+direccion+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    
    public void actualizarEstudiante(String cedula, String nombre, String direccion)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE `estudiantes` SET cedula='"+cedula+"',nombre='"+nombre+"',direccion='"+direccion+"' WHERE cedula='"+cedula+"'");
                
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        
    }
    
    public void eliminarEstudiante(String cedula)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM `estudiantes` WHERE cedula='"+cedula+"'");
                
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        
    }
    
    public String[] consultarEstudiante(String cedula)
    {
        String[] datos=new String[2];
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM `estudiantes` where cedula="+cedula);
                
                while (rs.next()) 
                {
                    datos[0] = rs.getString("nombre");
                    datos[1] = rs.getString("direccion");
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
//        System.out.println("DATA"+datos[0]+datos[1]);
        return datos;
        
    }
    ///////////////////////////////////Fin Metodos BD Estudiantes/////////////////////////////////
    
    ///////////////////////////////////////Metodos BD Cursos//////////////////////////////////////
     public boolean registrarCurso(String sigla, String nombre, String creditos)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO cursos(sigla, nombre, creditos) VALUES ('"+sigla+"','"+nombre+"',"+creditos+")");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
     
     
     ///////////////////////////////////Fin Registar Curso//////////////////////////////////
     
     ///Actualizar Curso.
     public void actualizarCurso(String sigla, String nombre, int creditos)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE `cursos` SET sigla='"+sigla+"',nombre='"+nombre+"',creditos='"+creditos+"' WHERE sigla='"+sigla+"'");
                
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        
    }
    ///////////////////////////////////Fin Actualizar Curso//////////////////////////////////
     
     //Eliminar Curso
     public void eliminarCurso(String sigla)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM `cursos` WHERE sigla='"+sigla+"'");
                
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        
    }
      ///////////////////////////////////Fin Eliminar Curso//////////////////////////////////
     
     //Consultat Curso Por Nombre
    public String[] consultarCursoPorNombre(String nombre)
    {
        String[] datos=new String[3];
        datos[1]=nombre;
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM `cursos` where nombre='"+nombre+"'");
                
                while (rs.next()) 
                {
//                    System.out.print("\nACÁ"+rs.getString("nombre"));
                    datos[0] = rs.getString("sigla");
                    datos[2] = rs.getString("creditos");
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return datos;
    }
    
    /////////////////////////////Fin Consultar Curso Por Nombre//////////////////////
    
    /////////////////////////////Consultar Curso Por Sigla/////////////////////
    public String[] consultarCursoPorSigla(String sigla)
    {
        String[] datos=new String[3];
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM `cursos` where sigla='"+sigla+"'");
                int contador=0;
                while (rs.next()) 
                {
                    datos[0] =rs.getString("sigla");
                    datos[1] = rs.getString("nombre");
                    datos[2] = rs.getString("creditos");
                    
                    
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return datos;
    }
    ////////////////////////////Fin Consultar Curso Por sigla/////////////////////
    
    public ArrayList<Cursos> getCursosParaMatricula()
    {
        ArrayList<Cursos> cursos=new ArrayList<Cursos>();
        Cursos curso;
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM `cursos`");
                
                while (rs.next()) 
                {
                    curso=new Cursos(rs.getString("sigla"),rs.getString("nombre"),rs.getString("creditos"));
                    cursos.add(curso);
                    
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return cursos;
    }
     
    /////////////////////////////////////Metodos BD Matricula//////////////////////////////
    
    
    public boolean registrarMatricula(String codigoMatricula,String cedula_estudiante)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO t_matricula(numero, cedula) VALUES ('"+codigoMatricula+"','"+cedula_estudiante+"'"+")");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    public boolean registrarCursosMatriculados(String codigoMatricula,String sigla)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {

            
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO t_detallematricula(numero, sigla) VALUES ('"+codigoMatricula+"','"+sigla+"'"+")");
            
               return true;
               
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    
    public String corroborarExistenciaDeMatriculaPorCedula(String cedula)
    {
        String datos="";
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM `t_matricula` where cedula='"+cedula+"'");
                
                while (rs.next()) 
                {
                       datos=rs.getString("numero");
                    
                    
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return  datos;
    }

    public ArrayList<String> obtenerDatosDeMatriculaPorCodigo(String codigo)
    {
        String [][] data;
        ArrayList datos=new ArrayList<String>();
        ResultSet rs = null;
        Statement cmd = null;

        try {
            System.out.println("HP");
                cmd = con.createStatement();
//                data=new String[][];
                rs = cmd.executeQuery("SELECT sigla FROM `t_detallematricula` where numero='"+codigo+"'");
                 System.out.println("HI");
                while (rs.next()) 
                {
//                       datos.add(rs.getString("numero"));
                       datos.add(rs.getString("sigla"));
                       System.out.println("SIGLAS="+datos);
                    
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return  datos;
    }
    
    public void eliminarMatricula(String numero)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM `t_matricula` WHERE numero='"+numero+"'");
                ejecuto = cmd.execute("DELETE FROM `t_detallematricula` WHERE numero='"+numero+"'");
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        
    }
    
     ///////////////////////////////////Fin Metodos BD Matricula///////////////////////////////
    
     ///////////////////////////////////Metodos Usuario///////////////////////////////////////
    public boolean registrarUsuario(String cedula,String nombre, String password)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO usuario(cedula, nombre, password) VALUES ('"+cedula+"','"+nombre+"',"+password+")");
                
               return true;
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    
    public boolean corroborarLoginUsuarios(String ced, String password)
    {
        boolean corroborado=false;
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM `usuario` where cedula='"+ced+"'");
                
                while (rs.next()) 
                {
                        if(rs.getString("password").equals(password)){
                            corroborado=true;
                        }
                    
                    
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return  corroborado;
    }
    
    public boolean corroborarExistenciaUsuarios()
    {
        boolean existe=false;
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM `usuario`");
                
                while (rs.next()) 
                {
                        existe=true;
                    
                    
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        System.out.print("\nExiste= "+existe);
        return  existe;
    }
    
     public String[] corroborarExistenciaDeUsuarioPorCedula(String cedula)
    {
        String datos[]=new String[2];
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM `usuario` where cedula='"+cedula+"'");
                
                while (rs.next()) 
                {
                        datos[0]=rs.getString("nombre");
                       
                        datos[1]=rs.getString("password");
                    
                    
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return  datos;
    }
    
     public void eliminarUsuario(String cedula)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM `usuario` WHERE cedula='"+cedula+"'");
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        
    }
     
    public void actualizarUsuario(String ced, String nombre, String password)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE `usuario` SET cedula='"+ced+"',nombre='"+nombre+"',password='"+password+"' WHERE cedula='"+ced+"'");
               
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        
    }
    
    public boolean corroborarCantidadDeUsuarios()
    {
        boolean respuesta=false;
        ResultSet rs = null;
        Statement cmd = null;
        int contador=0;
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM `usuario`");
                
                while (rs.next()) 
                {
                        contador++;
                    
                    
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        System.out.print("\nCantidad De Usuarios= "+contador);
        if(contador>1){
           respuesta=true;
        }
        System.out.print("\nCantidad De Usuarios= "+respuesta);
        return  respuesta;
    }
    ///////////////////////////////////Fin Metodos BD Usuario///////////////////////////////
}
