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
public class GestorDades {
    /**
     * A partir de les dades rebudes com a paràmetre fa l'inicialització de les
     * seves variables internes. Posa el ranking a 0 files i crea dos Strings
     * per a guardar el nom dels jugadors.
     * @param dadesTorneig variable que conté les dades
     */
    public void inicialitzarDades(DadesTorneig dadesTorneig){
        dadesTorneig.ranking = new String[0][2];
        dadesTorneig.resultatDarrerPartit = "SENSE DADES";
        dadesTorneig.jugadorsDarrerPartit = new String[2];
    }
    
    /**
     * Fa una primera simulació de càrrega de partits a partir de les dades dels 
     * jugadors que rep com a paràmetre. Simplement agafa el primer jugador de cada
     * partit i el col·loca al ranking de dadesTorneig com si hagués guanyat 
     * sense realment comprovar-ho.
     * @param dadesTorneig variable que conté el ranking del torneig entre altres
     * @param dadesPartits
     */
    public void carregarPartits(DadesTorneig dadesTorneig, DadesPartits dadesPartits){
        dadesTorneig.ranking = new String[dadesPartits.partits.length][2];
        for ( int i = 0; i < dadesPartits.partits.length; i++ ){
            analitzarPartit(dadesTorneig, dadesPartits.partits[i][0], dadesPartits.partits[i][1], dadesPartits.partits[i][2]);
            dadesTorneig.ranking[i][0] = dadesPartits.partits[i][dadesTorneig.guanyadorDarrerPartit];
            dadesTorneig.ranking[i][1] = "10";
        }
    }
    
    /**
     * Mètode propi del
     * gestor de dades que s’encarregarà de rebre l’estructura de les dades del torneig i
     * analitzar el partit que en ella s’hi troba carregat. En concret, analitzarà la cadena
     * en forma de múltiples A’s i B’s consecutives i generarà una sortida en les seves
     * variables on s’indicarà: el resultat final en forma de sets (format String) i el
     * jugador guanyador, a banda de les altres dades que pot portar i que considereu
     * oportunes.
     * @param dadesTorneig 
     * @param nomJugador1 
     * @param nomJugador2 
     * @param sequenciaPartit 
     */
    public void analitzarPartit(DadesTorneig dadesTorneig, String nomJugador1, String nomJugador2, String sequenciaPartit){
        int jocsJugadorA = 0;
        int jocsJugadorB = 0;
        int setsJugadorA = 0;
        int setsJugadorB = 0;
        String resultat = "";
        int guanyador;
        dadesTorneig.sequenciaDarrerPartit = sequenciaPartit;
        char[] arrayCaracters = dadesTorneig.sequenciaDarrerPartit.toCharArray();
        for (int i = 0; i < arrayCaracters.length; i++){
            if (arrayCaracters[i] == DadesTorneig.CARACTER_JUGADOR1){
                jocsJugadorA++;
                
            }
            if (arrayCaracters[i] == DadesTorneig.CARACTER_JUGADOR2){
                jocsJugadorB++;
                
            }
            if ((jocsJugadorA > 5) && (jocsJugadorA > jocsJugadorB+1)){ 
                setsJugadorA++; 
                String A= String.valueOf(jocsJugadorA);
                String B= String.valueOf(jocsJugadorB);
                resultat += A+"-"+B+" ";
                jocsJugadorA = 0;
                jocsJugadorB = 0; 
                
            }
            if ((jocsJugadorB > 5) && (jocsJugadorB > jocsJugadorA+1)){ 
                setsJugadorB++;
                String A= String.valueOf(jocsJugadorA);
                String B= String.valueOf(jocsJugadorB);
                resultat += A+"-"+B+" ";
                jocsJugadorA = 0;
                jocsJugadorB = 0;
                
            }
            if ((jocsJugadorB > 5) && (jocsJugadorB > 5)){ 
                String A= String.valueOf(jocsJugadorA);
                String B= String.valueOf(jocsJugadorB);
                resultat += A+"-"+B+" ";
                jocsJugadorA = 0;
                jocsJugadorB = 0;
                
            }
            
        }
        int jocsRestants = jocsJugadorA + jocsJugadorB;
        if (jocsRestants != 0){
            
            if (jocsJugadorA > jocsJugadorB+1){
                setsJugadorA++;

            }
            if (jocsJugadorB > jocsJugadorA+1){
                setsJugadorB++;

            }
            if (jocsJugadorB == jocsJugadorA){

            }
            String A= String.valueOf(jocsJugadorA);
            String B= String.valueOf(jocsJugadorB);
            resultat += A+"-"+B+" ";
           
        }
        
        if(setsJugadorA > setsJugadorB){
            guanyador = 0;
        }else{
            guanyador = 1;
        }
        dadesTorneig.jugadorsDarrerPartit[0] = nomJugador1;
        dadesTorneig.jugadorsDarrerPartit[1] = nomJugador2;
        dadesTorneig.resultatDarrerPartit = resultat; 
        dadesTorneig.guanyadorDarrerPartit = guanyador; 

    }
   
}
