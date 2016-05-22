/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorUsuarios;
import Modelo.Archivo;
import Modelo.ArchivosCursosXML;
import Modelo.ArchivosEstudianteXML;
import Modelo.ArchivosMatriculaXML;
import Modelo.ArchivosUsuarioXML;
import Modelo.ConexionBD;
import Modelo.MetodosUsuarios;

/**
 *
 * @author Emmanuel
 */
public class Principal {
    Archivo archivo;
    JF_MenuPrincipal jf_Principal;
    JF_Usuario usuario;
    ConexionBD conexionBD;
    ControladorUsuarios controladorUsuarios;
    MetodosUsuarios metodosUsuarios;
    JF_MantenimientoCursos mantenimientoCursos;
    JF_MantenimientoUsuarios mantenimientoUsuarios;
    JF_EleccionGuardado eleccion;
    private int tipoGuardado;
    public Principal(){
            conexionBD=new ConexionBD();
            archivo=new Archivo();
            eleccion=new JF_EleccionGuardado(conexionBD,this);
            

    }
    public void inicio(){
           ArchivosEstudianteXML archivosEstudianteXML=new ArchivosEstudianteXML();
           ArchivosCursosXML archivosCursosXML=new ArchivosCursosXML();
           ArchivosUsuarioXML archivosUsuarioXML=new ArchivosUsuarioXML();
           ArchivosMatriculaXML archivosMatriculaXML= new ArchivosMatriculaXML();
           tipoGuardado=eleccion.getTipoGuardado();
           jf_Principal=new JF_MenuPrincipal(conexionBD,tipoGuardado,archivo,archivosEstudianteXML,archivosCursosXML,archivosMatriculaXML);
            metodosUsuarios=new MetodosUsuarios(conexionBD,archivo,archivosUsuarioXML);
            ControladorUsuarios controladorUsuarios=new ControladorUsuarios(tipoGuardado,conexionBD,jf_Principal,metodosUsuarios,archivo);
            usuario=new JF_Usuario(controladorUsuarios);
            mantenimientoUsuarios=new JF_MantenimientoUsuarios(controladorUsuarios);
            jf_Principal.setMantenimientoUsuarios(mantenimientoUsuarios);
             controladorUsuarios.setVentaMantenimientoUsuario(mantenimientoUsuarios);
             controladorUsuarios.setVentaUsuario(usuario);
        if(metodosUsuarios.existeUsuario(tipoGuardado)){
            usuario.setVisible(true);
            
        }else{
            mantenimientoUsuarios.setVisible(true);
        }
        
    }
    public static void main(String[] arg){
        Principal principal=new Principal();
    }
    
}
