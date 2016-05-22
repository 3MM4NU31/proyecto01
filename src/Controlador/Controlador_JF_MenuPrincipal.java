/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

//import Vista.JF_MantenimientoCursos;
import Modelo.Archivo;
import Modelo.ArchivosCursosXML;
import Modelo.ArchivosEstudianteXML;
import Modelo.ArchivosMatriculaXML;
import Modelo.ConexionBD;
import Modelo.MetodosCursos;
import Modelo.MetodosEstudiantes;
import Vista.JF_MantenimientoCursos;
import Vista.JF_MantenimientoEstudiantes;
import Vista.JF_MantenimientoUsuarios;
import Vista.JF_Matricula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Emmanuel
 */
public class Controlador_JF_MenuPrincipal implements  ActionListener  {
    JF_MantenimientoEstudiantes mantenimientoEstudiantes;
    JF_MantenimientoCursos mantenimientoCursos;
    JF_Matricula matricula;
    MetodosEstudiantes metodosEstudiantes;
    MetodosCursos metodosCursos;
    Archivo archivo;
    ConexionBD conexionBD;
    JF_MantenimientoUsuarios mantenimientoUsuarios;
    public Controlador_JF_MenuPrincipal(ConexionBD conexionBD,int tipoGuardado,Archivo archivo,ArchivosEstudianteXML archivosEstudianteXML, ArchivosCursosXML archivosCursosXML, ArchivosMatriculaXML archivosMatriculaXML){
        this.conexionBD=conexionBD;
        metodosEstudiantes=new MetodosEstudiantes(conexionBD,archivo,archivosEstudianteXML);//METODOS E
        metodosCursos=new MetodosCursos(conexionBD,archivo,archivosCursosXML);//METODOS C
        mantenimientoEstudiantes=new JF_MantenimientoEstudiantes(metodosEstudiantes,conexionBD,tipoGuardado);
        mantenimientoCursos=new JF_MantenimientoCursos(metodosCursos,conexionBD,tipoGuardado);
        matricula=new JF_Matricula(metodosEstudiantes,metodosCursos,conexionBD,tipoGuardado,archivo,archivosEstudianteXML,archivosCursosXML,archivosMatriculaXML);
        metodosEstudiantes.cargarArchivos();
        metodosCursos.cargarArchivos();
//        metodosMatricula.cargarArchivos();
    }
    public void setMantenimientoUsuarios(JF_MantenimientoUsuarios mantenimientoUsuarios) {
        this.mantenimientoUsuarios=mantenimientoUsuarios;
    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Estudiantes")){
            mantenimientoEstudiantes.setVisible(true);
        }
        if(e.getActionCommand().equals("Cursos")){
             mantenimientoCursos.setVisible(true);
        }
        if(e.getActionCommand().equals("Matricula")){
            matricula.setVisible(true);
        }
        if(e.getActionCommand().equals("Usuarios")){
            mantenimientoUsuarios.setVisible(true);
        }
        
    }

    

   
    
}
