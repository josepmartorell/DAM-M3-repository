/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asxm3b2_eac5p2_martorell_a;

/**
 *
 * @author jmartorell
 */
public class InterficieUsuari {
    
    static final short ID_NOM = 0;
    static final short ID_PUNTUACIO = 1;
    /*A partir d’un array String que conté les diferents opcions de menú, mostra aquest degudament formatat. 
     * La primera posició de l’esmentat array és el títol del menú, no pas una opció.
     */
    public static void mostrarMenu(String[] menu){
        System.out.print("--------------------------------------------------------------------------------\n" +
                         "OPCIONS\n" +
                         "--------------------------------------------------------------------------------\n");
        
        for (int i = 1; i < menu.length; i++){
            System.out.print(menu[i] + "\n");
        }
    
    }
    /* A partir d’un array que conté un ranking format per noms i puntuacions (1a i 2a columna), el mostra per pantalla 
     * degudament formatat, amb les columnes ben alineades independentment de la longitud dels caràcters 
     */
    
    public static void mostrarRanking(String[][]ranking){
        System.out.print("--------------------------------\n" +
                         "JUGADOR                PUNTUACIO\n" +
                         "--------------------------------\n");
        int i = 0;
        while ( i < ranking.length){
            System.out.print(String.format("%-8s", ranking[i][ID_NOM]) + "\t\t");
            System.out.print(String.format("%8s",ranking[i][ID_PUNTUACIO]) + "\n");
            i++;
        }
        
    }
    
}
