/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import javax.lang.model.element.Element;
import org.jdom2.Document;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;





/**
 *
 * @author dacastro
 */
public class Estudiante extends Persona {

    private String codigo;
    private String carrera;
    private org.jdom2.Element estudiante;

    public Estudiante() {
    }

    public Estudiante(String codigo, String carrera, String nombre, String telefono, String correo) {
        super(nombre, telefono, correo);
        this.codigo = codigo;
        this.carrera = carrera;
    }

    /**
     * Get the value of carrera
     *
     * @return the value of carrera
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * Set the value of carrera
     *
     * @param carrera new value of carrera
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
     * Get the value of codigo
     *
     * @return the value of codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Set the value of codigo
     *
     * @param codigo new value of codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return super.toString() + "," + codigo + "," + carrera;
    }

    public boolean crearArchivoEstudiante(LinkedList<Estudiante> listaEstudiantes) {
        boolean g = false;
        FileWriter flwriter = null;
        try {
            flwriter = new FileWriter("estudiantes.txt");
            BufferedWriter bfwriter = new BufferedWriter(flwriter);

            for (int i = 0; i < listaEstudiantes.size(); i++) {
                //escribe los datos en el archivo
                bfwriter.write(listaEstudiantes.get(i) + "\n");
            }
            bfwriter.close();
            System.out.println("Archivo creado satisfactoriamente..");
            g=true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {//cierra el flujo principal
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return g;
    }

    public boolean crearArchivoXML(LinkedList<Estudiante> listaE) {
        boolean g = false;
        
        try{
            
            Element estudiantes = new Element("estudiantes");
            Document doc = new Document (estudiante);
            
            for(int i =0; i< listaE.size(); i++){
                
                Element estudiantes = new Element("estudiante");
                estudiante.addContent( new org.jdom2.Element ("nombre").setText(
                        listaE.get(i).getNombre()));
                estudiante.addContent( new org.jdom2.Element ("telefono").setText(
                        listaE.get(i).getTelefono()));
                estudiante.addContent( new org.jdom2.Element ("correo").setText(
                        listaE.get(i).getCorreo()));
                estudiante.addContent( new org.jdom2.Element ("codigo").setText(
                        listaE.get(i).getCodigo()));
                estudiante.addContent( new org.jdom2.Element ("carrrera").setText(
                        listaE.get(i).getCarrera()));
                
                doc.getRootElement().addContent(estudiante);
            }
            XMLOutputter xmlOutput = newXMLOutputter();
            XMLOutputter.setFormat(Format.getPrettyFormat());
            XMLOutput.output(doc, new FileWriter("universidad.xml"));
            g = true;
        } catch ( IOException io){
            System.outprintln( io.getMessage());
            g= false;
        }
        return g;
    }

}
