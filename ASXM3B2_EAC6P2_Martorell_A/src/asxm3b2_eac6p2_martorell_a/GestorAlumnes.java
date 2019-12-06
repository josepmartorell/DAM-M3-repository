package asxm3b2_eac6p2_martorell_a;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;


/**
 *
 * @author jmartorell
 */
public class GestorAlumnes {
    
    /**
     * Variables globals corresponents als missatges que es mostren per pantalla
     */
   
    static final String NOM_FITXER_ALUMNES = "alumnes.txt";
    static final String NOM_FITXER_AMONESTACIONS = "amonestacions.txt";
    static final String NOM_FITXER_SORTIDA = "sortida.txt";
    
    /** 
     * Funció que comprova si a la carpeta de l'aplicació existeixen els fitxers
     * de text necessaris per a treballar.
     * @return cert si existeixen els fitxer. Fals altrament.
     */
    public boolean fitxersPresents(){
        File fCarpeta = new File(System.getProperty("user.dir"));
        File[] fitxers = fCarpeta.listFiles();
        int num = 2;
        int i = 0;
        while ( num > 0 && i < fitxers.length ){
            if ( fitxers[i].getName().equals(NOM_FITXER_ALUMNES) 
                || fitxers[i].getName().equals(NOM_FITXER_AMONESTACIONS) ){
                num--;
            }
            i++;
        }
        return ( num == 0 );
    }
    
    /**
    * Realitza la fusió dels dos fitxers d'alumnes i amonestacions i ho posa
    * tot en un fitxer de sortida anomenat sortida.txt
    * @return cert si el procés s'ha completat satisfactòriament
    */
    public boolean fusionarFitxers(){
        boolean cert = false;
        try{
            File f1 = new File(NOM_FITXER_ALUMNES);
            File f2 = new File(NOM_FITXER_AMONESTACIONS);
            File f3 = new File(NOM_FITXER_SORTIDA);
            Scanner s1 = new Scanner(f1);
            Scanner s2 = new Scanner(f2);
            PrintStream lector = new PrintStream(f3);          
            while(s1.hasNextLine()){
                String line1 = s1.nextLine();
                lector.print(line1);
                lector.print(";");
                String line2 = s2.nextLine();
                lector.println(line2);
            }
            lector.close();
        }catch(FileNotFoundException e){
            System.out.println("Arxius no trobats…");
        }
        return cert;
    }
    
    /**
    * Mostra les dades d'un fitxer de text per pantalla línia a línia
    * @param nomFitxer nom del fitxer a mostrar.
    */
    public static void mostrarAmonestacions(String nomFitxer){
        try{
            System.out.println();
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("  ID NOM                       DATA FALTA  DESCRIPCIÓ DE LA FALTA");
            System.out.println("-----------------------------------------------------------------------");
            String cadena;
            FileReader f = new FileReader(NOM_FITXER_SORTIDA);
            BufferedReader b = new BufferedReader(f);
            while((cadena = b.readLine())!=null) {
                String[] parts = cadena.split(";");
                String descripcio = parts[3];
                if (descripcio.length() > 40){                    
                    descripcio = descripcio.substring(0, 37) + "...";
                }else{
                    descripcio.substring(0);
                }
                System.out.println(String.format("%4s %-25s %10s %s %-40s", parts[0], parts[1], parts[2], "", descripcio));
            }
            b.close();
        }catch(IOException e){
            System.out.println("Arxius no trobats…");
        
        }
        
    }
    
}

