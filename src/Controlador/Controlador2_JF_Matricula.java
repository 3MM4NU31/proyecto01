/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConexionBD;
import Modelo.Cursos;
import Modelo.MetodosCursos;
import Modelo.MetodosEstudiantes;
import Modelo.MetodosMatricula;
import Vista.JF_Matricula;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author Emmanuel
 */
public class Controlador2_JF_Matricula implements ItemListener {

   MetodosMatricula metodosMatricula;
    JF_Matricula matricula;
    MetodosEstudiantes metodosEstudiantes;
    MetodosCursos metodosCursos;
    int tipoGuardado;
    public Controlador2_JF_Matricula(JF_Matricula matricula, MetodosEstudiantes metodosEstudiantes, MetodosCursos metodosCursos,MetodosMatricula metodosMatricula,int tipoGuardado,ConexionBD conexionBD){
        this.metodosMatricula=metodosMatricula;
        this.matricula=matricula;
        this.metodosEstudiantes=metodosEstudiantes;
        this.metodosCursos=metodosCursos;
        this.tipoGuardado=tipoGuardado;
    }
    public void itemStateChanged(ItemEvent e) {
        Cursos cursoAuxilar;
                switch(tipoGuardado){
            case 1://Bases
          cursoAuxilar=metodosCursos.getCursoSeleccionadoBD(matricula.getSeleccionado());
          matricula.llenarDatosCurso(cursoAuxilar.getSiglas(),""+cursoAuxilar.getCreditos()); 
                break;
            case 2://XTML
                cursoAuxilar=metodosCursos.getCursoSelecionadoXML(matricula.getSeleccionado());
                matricula.llenarDatosCurso(cursoAuxilar.getSiglas(),""+cursoAuxilar.getCreditos());
                break;
                
            case 3://Archivos Planos
                cursoAuxilar=metodosCursos.getCursoArray(matricula.getSeleccionado());
                matricula.llenarDatosCurso(cursoAuxilar.getSiglas(),""+cursoAuxilar.getCreditos());
                break;
        }
        
        
    
    }
    
}
