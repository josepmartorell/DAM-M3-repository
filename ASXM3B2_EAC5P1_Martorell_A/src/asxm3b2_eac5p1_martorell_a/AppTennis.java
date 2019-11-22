/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asxm3b2_eac5p1_martorell_a;

/**
 *
 * @author jmartorell
 */
public class AppTennis {

/**
* @param args the command line arguments
*/
    public static void main(String[] args) {
        AppTennis prg = new AppTennis();
        prg.inici();
        
    }
    
    void inici(){
        String[][] ranking = {
                        {"RAFA", "30"},
                        {"METVEDEV", "20"},
                        {"WILLIAMS", "40"}
        };
        
        String[] menu = {
            "OPCIONS",
            "0. Sortir",
            "1. Practicar"
        };
        
        int opcio;
        
        do{  
            InterficieUsuari.mostrarMenu(menu);
            opcio = Utils.demanarEnter("Entra opció: ", "Error, no enter");
                        
            if ( opcio == 1 ){
                String nomParticipant = Utils.demanarString("Introdueix el nom d'un nou jugador", "El nom ha de contenir caràcters");
                int posicioJugador = RankingUtils.trobarFilaSegonsJugador(ranking, nomParticipant);
                if ( posicioJugador == -1 ){
                    ranking = RankingUtils.afegirJugador(ranking, nomParticipant, 10);
                }else{
                    RankingUtils.actualitzarPuntuacioRanking(ranking, posicioJugador, 10);
                }
                InterficieUsuari.mostrarRanking(ranking);
            }
            
        }while ( opcio != 0 ); 
        
    }
    
}
