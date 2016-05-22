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
public class Estudiante implements Serializable{
    
    private String nombre;
    private String cedula;
    private String direccion;

    /**
     * @return the nombre
     */
    public Estudiante(String cedula,String nombre, String direccion){
        this.setNombre(nombre);
        this.setCedula(cedula);
        this.setDireccion(direccion);
    }
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getInformacion(){
        return "Cédula: "+getCedula()+"\nNombre: "+getNombre()+"\nDirección"+getDireccion(); 
    }
}
