/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.JF_MantenimientoCursos;
import Vista.JF_MantenimientoEstudiantes;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Emmanuel
 */
public class Matricula implements Serializable{
    private String estudiante;
    private String codigo;
    ArrayList<String> arrayCursos;
    JF_MantenimientoEstudiantes mantenimientoEstudiantes;
    JF_MantenimientoCursos mantenimientoCursos;
    public Matricula(String estudiante, String codigo){
        this.codigo=codigo;
        arrayCursos=new ArrayList<String>();
        this.estudiante=estudiante;
    }
    
    public ArrayList<String> getSiglasCursos(){
        return arrayCursos;
    }
    public String getCodigoMatricula(){
        return codigo;
    }
    public String getCedulaEstudiante(){
        return estudiante;
    }
    public void agregarCurso(String curso){
        arrayCursos.add(curso);
    }
    
}
