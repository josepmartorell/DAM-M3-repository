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
public class RankingUtils {
    
    static final short ID_NOM = 0;
    static final short ID_PUNTUACIO = 1;
    
    /* Cerca dins del ranking passat com a paràmetre si el nom de Participant s’hi troba present. 
     * Retornarà el número de la fila on l’ha trobat i -1 si no existeix en el rànquing. 
     */
    public static int trobarFilaSegonsJugador(String[][] ranking, String nomParticipant){
        int posIndex = 0;
        boolean trobat = false;
        
        while( !trobat && posIndex < ranking.length ){
            trobat = ranking[posIndex][ID_NOM].equalsIgnoreCase(nomParticipant);
            posIndex++;
        }

        if( !trobat ){
            return -1;
        }else{
            return (posIndex - 1);
        }
        
    } 
    
    /* Crea un duplicat del ranking amb una fila més i afegeix el participant a la darrera posició del nou rànquing. 
     * La variable puntuació s’afegeix a la columna juntament amb el nom.
    for(int i=0; i<old.length; i++)
  for(int j=0; j<old[i].length; j++)
    old[i][j]=current[i][j];
     */
    
    public static String[][] afegirJugador(String[][] ranking, String nomParticipant, int puntuacio){       
      
        nomParticipant = nomParticipant.toUpperCase();
        
        // declarem un nou array i l'inicialitzem
        String [][] ranking2 = new String[ranking.length + 1][2];
        for(int i = 0; i < ranking2.length; i++) { 
            for (int j = 0; j < ranking2[i].length; j++) { 
                ranking2[i][j] = "";
            }
        }
        // omplim el duplicat amb el contigut del array l'original
        for(int i = 0; i < ranking.length; i++){    
            ranking2[i][ID_NOM] = ranking[i][ID_NOM];
            ranking2[i][ID_PUNTUACIO] = ranking[i][ID_PUNTUACIO];
        }
        // busquem la última posició del array duplicat i insertem el nom del participant
        for(int i = 0; i < ranking2.length; i++){    
            if("".equals(ranking2[i][ID_NOM])){
                ranking2[i][ID_NOM] = nomParticipant;
                ranking2[i][ID_PUNTUACIO] = Integer.toString(puntuacio);
            }
        }
        
        return ranking2; 
        
    }
    /* Accedeix a la posició del jugador indicada per posicioJugador dins el rànquing i l’incrementa 
     * amb el valor indicat a al paràmetre puntuacio.
     */
    public static void actualitzarPuntuacioRanking(String[][] ranking, int posicioJugador, int puntuacio){
        
        //ranking[posicioJugador][ID_PUNTUACIO] = Integer.toString(puntuacio);
        String rankingParticipant = ranking[posicioJugador][ID_PUNTUACIO];
        int rankingConvertit = Integer.parseInt(rankingParticipant);
        int rankingAcumulat = rankingConvertit + puntuacio;
        String rankingActualitzat = Integer.toString(rankingAcumulat);
        ranking[posicioJugador][ID_PUNTUACIO] = rankingActualitzat;
               
        
    } 

    
}
