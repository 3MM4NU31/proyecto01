/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
/**
 *
 * @author Emmanuel
 */
public class ArchivosEstudianteXML {
    DocumentBuilderFactory factory;
    DocumentBuilder builder;
    DOMImplementation implementation;
    Document document;
//    ArrayList titulos;
//    ArrayList valores;
    Element raiz,principal;
    String arregloInformacion[];
    Source source;
    Result result;
    Result console;
    Transformer transformer;
//    String nombreArchivo;
    public ArchivosEstudianteXML(){
        if(cargarXML("estudiantes"))
        {
          System.out.println("Ya existe un archivo XML Es creado, ya fue cargado y puede proceder a utilizarlo");
        }
        else
        {
            crearXML("estudiantes");
            System.out.println("No existía un archivo XML Es creado, ya fue creado y puede proceder a utilizarlo");
        }
         ////////////////////////////////////////////////////////////////////////////////
        arregloInformacion=new String[3];
//        titulos = new ArrayList();
//        valores = new ArrayList();
    }
    
    
    
    public boolean cargarXML(String nombre) //Método nuevo en pruebas
    {
        boolean cargo=false;
        try {
        
            File fXmlFile = new File(nombre+".xml");
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            document = builder.parse(fXmlFile);
            document.getDocumentElement().normalize();
            cargo=true;
            
            NodeList nList = document.getElementsByTagName(nombre);
            Node nNode = nList.item(0);
            raiz = (Element) nNode;
                
        } catch (Exception e) {
            System.out.println("Error al cargar el archivo XML"+e);
        }
        return cargo;
    } 
    
    
    public void crearXML(String nombre) //Método nuevo en pruebas
    {
        factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
            implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "xml", null);
            document.setXmlVersion("1.0");
            source = new DOMSource(document);
            result = new StreamResult(new java.io.File(nombre+".xml"));
 
            console = new StreamResult(System.out);
 
            transformer = TransformerFactory.newInstance().newTransformer();
 
            transformer.transform(source, result);
            transformer.transform(source, console);
 
        } catch (Exception e) {
            System.err.println("Error al crear el archivo XML: " + e);
        }
    }
    
    //////////////////////////////METODOS USUARIO//////////////////////////////
    
    
    /////////////////////////////FIN METODOS USUARIO///////////////////////////
    
    
    ///////////////////////////METODOS ESTUDIANTES////////////////////////////
    
    
    public void guardarEstudiantesEnXML(String arregloInformacion[])//Método nuevo en pruebas
    {
        try{
            
            raiz = document.createElement("estudiantes");
            principal = document.createElement("estudiantes");
            document.getDocumentElement().appendChild(raiz);
            
            Element valor1 = document.createElement("cedula");
            Text text = document.createTextNode(arregloInformacion[0]);
            Element valor2 = document.createElement("nombre");
            Text text2 = document.createTextNode(arregloInformacion[1]);
            Element valor3 = document.createElement("direccion");
            Text text3 = document.createTextNode(arregloInformacion[2]);
            
            raiz.appendChild(valor1);
            valor1.appendChild(text);
            raiz.appendChild(valor2);
            valor2.appendChild(text2);
            raiz.appendChild(valor3);
            valor3.appendChild(text3);
            
            source = new DOMSource(document);
            result = new StreamResult(new java.io.File("estudiantes"+".xml"));
            console = new StreamResult(System.out);
            transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            transformer.transform(source, console);
            
            }
        catch (Exception e) 
        {
            System.err.println("Error al guardar: " + e);
        }
    }
    
    public boolean consultarInformacionEstudianteDelXml(String cedula)
    { 
         Element raiz = document.getDocumentElement();
         NodeList listaDeItems = raiz.getElementsByTagName("estudiantes");
         Node tag=null,datoContenido=null;

         boolean itemEncontrado=false,tituloCedula=false;
         int contador=0;
         for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
         {   
             Node item = listaDeItems.item(contadorItems);
             NodeList datosItem = item.getChildNodes();
             for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
             {           
                 tag = datosItem.item(contadorTags); 
                 datoContenido = tag.getFirstChild();
             System.out.println("CED="+cedula+"");
                 if(tag.getNodeName().equals("cedula") && datoContenido.getNodeValue().equals(""+cedula) )
                 {
                    itemEncontrado=true;     
                 }
                 if(itemEncontrado && contador<3)
                 {
                    arregloInformacion[contador]=datoContenido.getNodeValue();
                    contador++;
                 }
             }

         }
         return itemEncontrado;
    }
    public String[] getArregloInformacion()
    {
        return this.arregloInformacion;
    }
    public void modificarInformacionEstudianteDelXml(String informacion[])
    { 
         Element raiz = document.getDocumentElement();
         NodeList listaDeItems = raiz.getElementsByTagName("estudiantes");
         Node tag=null,datoContenido=null;
         String arregloInformacion[]=new String[3];
         boolean itemEncontrado=false,tituloCedula=false;
         int contador=0;
         try
         {
            for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
            {   
                Node item = listaDeItems.item(contadorItems);
                NodeList datosItem = item.getChildNodes();
                for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
                {   
                    tag = datosItem.item(contadorTags); 
                    datoContenido = tag.getFirstChild();
                    if(tag.getNodeName().equals("cedula") && datoContenido.getNodeValue().equals(""+informacion[0]) )
                    {   
                       itemEncontrado=true;     
                    }
                    if(itemEncontrado && contador<3)
                    {
                        datoContenido.setNodeValue(informacion[contador]);                    
                        contador++;
                    }
                }
            }
           source = new DOMSource(document);
           result = new StreamResult(new java.io.File("estudiantes"+".xml"));
           console = new StreamResult(System.out);
           transformer = TransformerFactory.newInstance().newTransformer();
           transformer.transform(source, result);
           transformer.transform(source, console);
        }
        catch (Exception e) 
        {
            System.err.println("Error al modificar: " + e);
        }
    }
    public void eliminarInformacionEstudianteDelXml(String cedula)
    { 
         Element raiz = document.getDocumentElement();
         NodeList listaDeItems = raiz.getElementsByTagName("estudiantes");
         Node tag=null,datoContenido=null;
         String arregloInformacion[]=new String[3];
         boolean itemEncontrado=false,tituloCedula=false;

         try{
            for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
            {   
                Node item = listaDeItems.item(contadorItems);
                NodeList datosItem = item.getChildNodes();
                for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
                {
                    tag = datosItem.item(contadorTags); 
                    datoContenido = tag.getFirstChild();
                    if(tag.getNodeName().equals("cedula") && datoContenido.getNodeValue().equals(""+cedula) )
                    {
                       itemEncontrado=true;
                       raiz.removeChild(item);
                       source = new DOMSource(document);
                       result = new StreamResult(new java.io.File("estudiantes.xml"));
                       console = new StreamResult(System.out);
                       transformer = TransformerFactory.newInstance().newTransformer();
                       transformer.transform(source, result);
                       transformer.transform(source, console);
                    } 
                }
            }
         }
        catch (Exception e) 
        {
            System.err.println("Error al eliminar: " + e);
        }
    }
    ////////////////////////FIN METODOS ESTUDIANTES//////////////////////////
    
    
    
}
