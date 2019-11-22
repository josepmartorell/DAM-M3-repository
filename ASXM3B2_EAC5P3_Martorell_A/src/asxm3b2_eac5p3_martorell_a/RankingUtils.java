/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asxm3b2_eac5p3_martorell_a;

import java.util.*;
/**
 *
 * @author jmartorell
 */
public class RankingUtils {
    
    static final int INDEX_NOM = 0;
    static final int INDEX_PUNTS = 1;
    static final int NUM_COLUMNES_RANKING = 2;

    
    /**
     * A partir de les dades del torneig i el nom del darrer guanyador,
     * mira si existeix dins el ranking. En cas que així sigui en retorna
     * la fila corresponent a la seva posició. Altrament retorna -1
     * @param ranking conté el ranking i el jugador que s'hi cerca
     * @param nomParticipant
     * @return la fila del jungador en el ranking o -1 si no el troba
     */
    public static int trobarFilaSegonsJugador(String[][] ranking, String nomParticipant){
        String nomJugador = nomParticipant.toUpperCase();
        int fila = 0;
        while ( fila < ranking.length && 
                !nomJugador.equals(ranking[fila][RankingUtils.INDEX_NOM].toUpperCase()) ){
            fila++;
        }
        if ( fila == ranking.length )
            fila = -1;
        return fila;
    }
        
    /**
     * Afegeix una nova posició al ranking amb el nou jugador que ha guanyat
     * el darrer partit. Amplia el ranking en una posició per fer-ho.
     * @param ranking
     * @param nomParticipant
     * @param puntuacio
     * @return 
     */
    public static String[][] afegirJugador(String[][] ranking, String nomParticipant, int puntuacio){
        String[][] nouRanking = Arrays.copyOf(ranking, ranking.length + 1);
        nouRanking[ranking.length] = new String[RankingUtils.NUM_COLUMNES_RANKING];
        nouRanking[ranking.length][RankingUtils.INDEX_NOM] = nomParticipant;
        nouRanking[ranking.length][RankingUtils.INDEX_PUNTS] = Integer.toString(puntuacio);
        return nouRanking;
    }
    
    /**
     * A partir de la posició del darrer jugador que ha guanyat el darrer partir
     * n'incrementa la seva puntuació al ranking en tants punts com valor té una
     * victoria (constant)
     * @param ranking conté el ranking en el que s'han d'actualitzar els punts.
     * @param posicioJugador conté la posició del jugador en el ranking que cal actualitzar-li els punts
     * @param puntuacio
     */
    public static void actualitzarPuntuacioRanking(String[][] ranking, int posicioJugador, int puntuacio){
        ranking[posicioJugador][RankingUtils.INDEX_PUNTS] = 
            Integer.toString(Integer.parseInt(ranking[posicioJugador][RankingUtils.INDEX_PUNTS]) + puntuacio);          
    } 
    
    /**
     * Realitza la
     * ordenació de major a menor del paràmetre ranking, agafant com a criteri la
     * puntuació que es troba en la segona columna de l’array de dues dimensions que
     * conforma. Tingueu present que es tracta d’un array d’String i que per tant, en el
     * moment de comparar les puntuacions caldrà passar-ho a enter fent ús de
     * Integer.parseInt que ja coneixeu.
     * @param ranking
     * @return 
     */
    public static String[][] ordenarRanking(String[][] ranking){
        // array intern per efectuar els canvis en l'array del ranking
        //String array [][] = new String [ranking.length][];       
        // Recorregut de totes les files de l’array de dues dimensions
        for( int i = 0; i < ranking.length; i++){
            // Per cada fila de l’array es compara amb totes les restants
            for( int j = 0; j < ranking.length - 1; j++){
                
                // comparació entre files convertin els valors de la segona columna a enters
                int ranking1 = Integer.parseInt(ranking[j][INDEX_PUNTS]);
                int ranking2 = Integer.parseInt(ranking[j+1][INDEX_PUNTS]);
                if ( ranking1 < ranking2 ){
                    // Intercanvi de files en cas de que una major estigui per sota d’una amb menor valor
                    String[] aux = ranking[j + 1];
                    ranking[j + 1] = ranking[j];
                    ranking[j] = aux;
                }
                
            }
            
        }      
        return ranking;
    }
    
    /**
     * es tracta d’una funció que
     * s’encarrega d’actualitzar el ranking quan detectem un participant guanyador. Rep
     * el ranking com a paràmetre, el participant i la puntuació a sumar. Si el participant
     * ja existeix se li incrementa la puntuació si no, s’afegeix per primera vegada amb
     * la puntuació indicada. De fet, utilitza funcions ja creades en el seu interior i, de
     * tenir-les com hauria de ser, la seva implementació es força simple
     * @param ranking
     * @param participant
     * @param puntuacio
     * @return 
     */
    public static String[][] actualitzarRanking(String[][] ranking, String participant, int puntuacio){
        return null;
    }
}

