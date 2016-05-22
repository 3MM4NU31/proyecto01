/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Emmanuel
 */
public class Usuario implements Serializable{
    String nombre, cedula, password;
    
    public Usuario(String nombre,String cedula,String password){
        this.nombre=nombre;
        this.cedula=cedula;
        this.password=password;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setCedula(String cedula){
        this.cedula=cedula;
    }
    public void setPassword(String password){
        this.password=password;
    }
    
    public String getNombre(){
        return nombre;
    }
    public String getCedula(){
        return cedula;
    }
    
    public String getPassword(){
        return password;
    }
}
