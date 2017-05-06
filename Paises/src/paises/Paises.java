/*
 *
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author jmr
 */
public class Paises {

    /**
     * @param args the command line arguments
     */
    List<String> lista = new ArrayList<String>();
    List<String> lista_found = new ArrayList<String>();

    public void muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            //System.out.println(cadena);
            String paises[] = cadena.split(",");
            //System.out.println(paises[0] + ", " + paises[1] + ", " + paises[5]);
            lista.add(paises[0] + "," + paises[1] + "," + paises[5]);
        }
        b.close();
    }
    
    public void verLista() {
        Iterator<String> it = lista.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
    
    public void buscar(List<String> paises) {        
        Iterator<String> it_2 = paises.iterator();
        while (it_2.hasNext()) {
            String pais = it_2.next();
            pais = "\"" + pais + "\"";
            System.out.println("********Pais = " + pais);
            Iterator<String> it = lista.iterator();
            while (it.hasNext()) {
                String datos = it.next();                
                //System.out.println("Datos = " + datos);
                String datos_split[] = datos.split(",");       
                if (datos_split[0].compareToIgnoreCase(pais) == 0) {
                    System.out.println("Encontrado = " + datos_split[2]);
                    break;
                }
            }
        }
    }
    
    public void EscribeFichero() {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("C:\\Users\\User\\Desktop\\log_consultas.txt");
            pw = new PrintWriter(fichero);

            for (int i = 0; i < 10; i++)
                pw.println("Linea " + i);

        } 
        catch (Exception e) {
            e.printStackTrace();
        } 
        finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } 
            catch (Exception e2) {
                e2.printStackTrace();
            }
        }        
    }    
    
     
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Paises paises = new Paises();
        paises.muestraContenido("C:\\Users\\User\\Desktop\\paises.txt");
        //paises.verLista();
        List<String> lista = new ArrayList<String>();
        lista.add("Ucrania");
        lista.add("PEPE");
        lista.add("Uruguay");
        paises.buscar(lista);
        paises.EscribeFichero();
    }
    
}