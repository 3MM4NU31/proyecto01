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
public class Cursos implements Serializable{
  private  String siglas, nombre,creditos;
    
    public Cursos(String siglas, String nombre, String creditos){
        this.setSiglas(siglas);
        this.setNombre(nombre);
        this.setCreditos(creditos);
    }

    public void setSiglas(String siglas) {
     this.siglas=siglas;  
    }

    public void setNombre(String nombre) {
      this.nombre=nombre;
    }

    public void setCreditos(String creditos) {
    this.creditos=creditos;    
    }
    public String getSiglas(){
        return siglas;
    }
    public String getNombre(){
        return nombre;
    }
    public String getCreditos(){
        return creditos;
    }
}
