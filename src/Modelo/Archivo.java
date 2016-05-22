/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Emmanuel
 */
public class Archivo {
    ObjectOutputStream matriculaArchivoSalida;
    ObjectOutputStream estudianteArchivoSalida;
    ObjectOutputStream cursoArchivoSalida;
    ObjectOutputStream usuarioArchivoSalida;
    ObjectInputStream matriculaArchivoEntrada;
    ObjectInputStream estudianteArchivoEntrada;
    ObjectInputStream cursoArchivoEntrada;
    ObjectInputStream usuarioArchivoEntrada;
    ///////////////////Constructor///////////
    public Archivo(){
        cargarArchivos();
    }

    
     //Fin del Constructor
    
    
    public void cargarArchivos(){
       if(cargarArchivoMatricula()){
           System.out.print(" Archivo Matricula Cargado correctamente ");
       }else{
           crearArchivoMatricula();
       }
       
       if(cargarArchivoEstudiante()){
           System.out.print(" Archivo Estudiante Cargado correctamente ");
       }else{
           crearArchivoEstudiante();
       }
       
       if(cargarArchivoCurso()){
           System.out.print(" Archivo Cursos Cargado correctamente ");
       }else{
           crearArchivoCurso();
       }
       
       if(cargarArchivoUsuarios()){
           System.out.print(" Archivo Usuarios Cargado correctamente ");
       }else{
           crearArchivoUsuarios();
       }
        
       
    }
    
 
/////****************Metodos Devolver Información de los archivos*************///
    
    public ArrayList<Usuario> devolverInformacionArchivoUsuario(){
        ArrayList<Usuario> usuarios=new ArrayList<Usuario>();
        try{
            while(true){
                usuarios.add((Usuario)usuarioArchivoEntrada.readObject());
            }
        }catch(Exception e){
            System.out.println("Se Cargo Usuario");
        }
        return usuarios;
    }
    public ArrayList<Matricula> devolverInformacionArchivoMatricula(){
        ArrayList<Matricula> matriculas=new ArrayList<Matricula>();
        try{
            while(true){
                matriculas.add((Matricula)matriculaArchivoEntrada.readObject());
            }
        }catch(Exception e){
            System.out.println("Se Cargo Matricula");
        }
        return matriculas;
    }
    
    public ArrayList<Estudiante> devolverInformacionArchivoEstudiante(){
        ArrayList<Estudiante> estudiantes=new ArrayList<Estudiante>();
        try{
            while(true){
                estudiantes.add((Estudiante)estudianteArchivoEntrada.readObject());
                 
            }
        }catch(Exception e){
             System.out.println("Se Cargo Estudiante");
        }
        return estudiantes;
    }
    
    public ArrayList<Cursos> devolverInformacionArchivoCursos(){
        ArrayList<Cursos> cursos=new ArrayList<Cursos>();
        try{
            while(true){
                cursos.add((Cursos)cursoArchivoEntrada.readObject());
            }
        }catch(Exception e){
            System.out.println("Se Cargo Cursos");
        }
        return cursos;
    }
    ///////****************Fin Metodos Devolver Informacion*****************////
    
    //////*****************Metodos Cargar Archivos**************///////////////
    public boolean cargarArchivoUsuarios(){
        boolean existe=false;
        try{
            usuarioArchivoEntrada=new ObjectInputStream(new FileInputStream("usuarios.dat"));
            existe=true;
        }catch(Exception e){
            
        }
        
        
        return existe;
    }
    
    public boolean cargarArchivoMatricula(){
        boolean existe=false;
        try{
            matriculaArchivoEntrada=new ObjectInputStream(new FileInputStream("matriculas.dat"));
            existe=true;
        }catch(Exception e){
            
        }
        
        
        return existe;
    }
    public boolean cargarArchivoEstudiante(){
        boolean existe=false;
        try{
            estudianteArchivoEntrada=new ObjectInputStream(new FileInputStream("estudiantes.dat"));
            existe=true;
            System.out.println("Se Cargo Estudiantes");
    }catch(Exception e){
        System.out.println("NO Se Cargo Estudiantes"+e);
        }
        return existe;
    }
    
    public boolean cargarArchivoCurso(){
        boolean existe=false;
        try{
            cursoArchivoEntrada=new ObjectInputStream(new FileInputStream("cursos.dat"));
            existe=true;
        }catch(Exception e){
        
     }
        return existe;
    }
    //crearArchivos
    //Crea Los Archivos necesarios para guardar la inormación
    public void crearArchivoUsuarios(){
        try{
        usuarioArchivoSalida=new ObjectOutputStream(new FileOutputStream("usuarios.dat"));
        System.out.print(" Se creo El archivo de forma correcta ");
        }catch(Exception e){
            System.out.print(" Error al crear El archivo ");
        }
        
        
        
    }
    
    public void crearArchivoMatricula(){
        try{
        matriculaArchivoSalida=new ObjectOutputStream(new FileOutputStream("matriculas.dat"));
        System.out.print(" Se creo El archivo de forma correcta ");
        }catch(Exception e){
            System.out.print(" Error al crear El archivo ");
        }
        
        
        
    }
    
    public void crearArchivoEstudiante(){
       try{
            estudianteArchivoSalida=new ObjectOutputStream(new FileOutputStream("estudiantes.dat"));
            
        }catch(Exception e){
            System.out.println("Error al crear Archivo Estudiante "+e);
        }
       
    }
    
    public void crearArchivoCurso(){
        try{
           cursoArchivoSalida=new ObjectOutputStream(new FileOutputStream("cursos.dat"));
        }catch(Exception e){
            
        }
    }
//////////////////////////////////////////////////Fin CrearArchivo///////////////////////////////////////
    
    //**********************Inicio metodos ingresar Información*************************//
     public void ingresarInformacionAlArchivoUsuarios(Usuario usuario){
        try{
            usuarioArchivoSalida.writeObject(usuario);
            System.out.print(" Se creo el objeto usuario ");
        }catch(Exception e){
            System.out.print("Error al ingresar Información al archivo"+e);
        }
    }
    
    public void ingresarInformacionAlArchivoMatricula(Matricula matricula){
        try{
            matriculaArchivoSalida.writeObject(matricula);
            System.out.println(" SE CARGO MATRICULA");
        }catch(Exception e){
            System.out.println("Error al ingresar Información al archivo"+e);
        }
    }

    public void ingresarInformacionAlArchivoEstudiante(Estudiante estudiante){
        try{
            estudianteArchivoSalida.writeObject(estudiante);
        }catch(Exception e){
            
        }
    }
    
    public void ingresarInformacionAlArchivoCurso(Cursos curso){
        try{
            cursoArchivoSalida.writeObject(curso);
        }catch(Exception e){
            
        }
    }

//////////////*****************FIN IngresarInformacion a los archivos**********//////////////////////
    
   
    
}
