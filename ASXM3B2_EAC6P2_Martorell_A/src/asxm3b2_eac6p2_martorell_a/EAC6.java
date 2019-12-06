package asxm3b2_eac6p2_martorell_a;

import java.io.IOException;

/**
 *
 * @author jmartorell
 */
public class EAC6 {
    /**
     * Variables globals corresponents als missatges que es mostren per pantalla
     */
    static final String MISSATGE_TRII_OPCIO = "Triï una opció";
    static final String MISSATGE_ERROR_OPCIO = "Opció incorrecta. Torni-ho a intentar";
    static final String MISSATGE_ERROR = "Error";
    static final String MISSATGE_CONFIRMACIO_DESBLOQUEIG = "Aplicació desbloquejada, fitxers presents";
    static final String MISSATGE_NOCONFIRMACIO_DESBLOQUEIG = "Aplicació no desbloquejada, fitxers no presents";
    static final String MISSATGE_COMIAT = "Què passis un bon dia!";
    static final String MISSATGE_OPCIO_BLOQUEJADA = "Opció bloquejada";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        EAC6 prg = new EAC6();
        prg.inici();
    }
    
    void inici() throws IOException{
        int opcio;
        boolean desbloqueig = false;
        String[] menu = {
            "MENÚ",
            "1. Testejar carpeta de treball", 
            "2. Fusió fitxers de text", 
            "3. Mostrar fitxer amonestacions", 
            "0. Sortir" 
        };
        
        GestorAlumnes gestorAlumnes = new GestorAlumnes();

        do{
            InterficieUsuari.mostrarMenu(menu);
            opcio = Utils.demanarEnter(MISSATGE_TRII_OPCIO, MISSATGE_ERROR_OPCIO);
            if ( opcio == 0 ){
                // Opció de sortida
                InterficieUsuari.mostrarMissatge(MISSATGE_COMIAT);
            }else if ( opcio == 1 ){
                // Comprovació de l'existència dels fitxers per a desbloquejar la resta d'opcions.
                if ( gestorAlumnes.fitxersPresents() ){
                    desbloqueig = true;
                    InterficieUsuari.mostrarMissatge(MISSATGE_CONFIRMACIO_DESBLOQUEIG);
                }else{
                    desbloqueig = false;
                    InterficieUsuari.mostrarMissatge(MISSATGE_NOCONFIRMACIO_DESBLOQUEIG);
                }
                
            }else if (desbloqueig ){
                if ( opcio == 2 ){
                    // Fusió de fitxers
                    gestorAlumnes.fusionarFitxers();
                    InterficieUsuari.mostrarMissatge("Fusió realitzada amb èxit");
                }else if ( opcio == 3 ){
                    // Mostrar fitxer de text
                    InterficieUsuari.mostrarMissatge("Mostrar fitxer text");
                    GestorAlumnes.mostrarAmonestacions(GestorAlumnes.NOM_FITXER_SORTIDA);
                }else if ( opcio < 2 || opcio > 3 ){
                    InterficieUsuari.mostrarMissatge(MISSATGE_ERROR_OPCIO);
                }
            }else{
                // Opcions encara bloquejades.
                InterficieUsuari.mostrarMissatge(MISSATGE_OPCIO_BLOQUEJADA);
            }
            
        }while ( opcio != 0 );
        
    }
    
}