/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asxm3b2_eac5p3_martorell_a;

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
        int opcio = 0;
        String[] menu = {
            "MENÚ",
            "1. Introducció partit", 
            "2. Càrrega de partits", 
            "3. Visualitzar rànking",  
            "0. Sortir" 
        };
        
        DadesTorneig dadesTorneig = new DadesTorneig();
        GestorDades gestorDades = new GestorDades();
        gestorDades.inicialitzarDades(dadesTorneig);
        DadesPartits dadesJugadors = new DadesPartits();
        gestorDades.carregarPartits(dadesTorneig, dadesJugadors);
        do{
            InterficieUsuari.mostrarMenu(menu);
            opcio = Utils.demanarEnter("Tria una opció", "Error");
            switch (opcio){
                case 1:
                    String jugador1 =  Utils.demanarString("Introdueix el nom del/la jugador/a 1: ", "Error");
                    String jugador2 =  Utils.demanarString("Introdueix el nom del/la jugador/a 2: ", "Error");
                    String sequenciaPartit = "";
                    while(sequenciaPartit.equals(sequenciaPartit.toLowerCase())){
                        sequenciaPartit = Utils.demanarString("Introdueix la seqüència de caràcters d'un partit: ", "Error");
                    }
                    gestorDades.analitzarPartit(dadesTorneig, jugador1, jugador2, sequenciaPartit);
                    System.out.println("El resultat del partit és el següent:");
                    System.out.println(dadesTorneig.resultatDarrerPartit);
                    System.out.println("El/La jugador/a guanyador del partit és:");
                    System.out.println(dadesTorneig.jugadorsDarrerPartit[dadesTorneig.guanyadorDarrerPartit]);   
                    
                    int posicioJugador = RankingUtils.trobarFilaSegonsJugador(dadesTorneig.ranking, dadesTorneig.jugadorsDarrerPartit[dadesTorneig.guanyadorDarrerPartit]);
                    if ( posicioJugador == -1 ){
                        dadesTorneig.ranking = RankingUtils.afegirJugador(dadesTorneig.ranking, dadesTorneig.jugadorsDarrerPartit[dadesTorneig.guanyadorDarrerPartit], 10);
                    }else{
                        RankingUtils.actualitzarPuntuacioRanking(dadesTorneig.ranking, posicioJugador, 10);
                    }
                    RankingUtils.ordenarRanking(dadesTorneig.ranking);
                    InterficieUsuari.mostrarRanking(dadesTorneig.ranking);                
                    break;
                case 2:
                    gestorDades.carregarPartits(dadesTorneig, dadesJugadors);
                    InterficieUsuari.mostrarRanking(dadesTorneig.ranking);
                    break;
                case 3:
                    // No implementat
                    break;
                case 0:
                    System.out.println("Fins la propera!");
                    break;
                default:
                    
            }
        }while ( opcio != 0 );
    
    }
    
}

