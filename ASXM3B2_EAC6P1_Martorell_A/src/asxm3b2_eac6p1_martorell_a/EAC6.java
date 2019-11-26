package asxm3b2_eac6p1_martorell_a;


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
    static final String MISSATGE_COMIAT = "Què passis un bon dia!";
    static final String MISSATGE_OPCIO_BLOQUEJADA = "Opció bloquejada";
    static final String MISSATGE_OPCIONS_DESBLOQUEJADES = "Aplicació desbloquejada, fitxers presents";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EAC6 prg = new EAC6();
        prg.inici();
    }
    
    void inici(){
        int opcio;
        boolean desbloqueig = false;
        String[] menu = {
            "MENÚ",
            "1. Testejar carpeta de treball", 
            "2. Fusió fitxers de text", 
            "3. Mostrar fitxer amonestacions", 
            "0. Sortir" 
        };
        
        // Variable que apunta al fitxer amb les funcions de gestió de fitxers
        // per a aquesta EAC.
        GestorAlumnes gestorAlumnes = new GestorAlumnes();

        do{
            InterficieUsuari.mostrarMenu(menu);
            opcio = Utils.demanarEnter(MISSATGE_TRII_OPCIO, MISSATGE_ERROR_OPCIO);
            if ( opcio == 0 ){
                // Opció de sortida
                InterficieUsuari.mostrarMissatge(MISSATGE_COMIAT);
            }else if ( opcio == 1 ){
                desbloqueig = gestorAlumnes.fitxersPresents();
                if (desbloqueig){
                    InterficieUsuari.mostrarMissatge(MISSATGE_OPCIONS_DESBLOQUEJADES);
                }                             
            }else if (desbloqueig ){
                if ( opcio == 2 ){
                    // Fusió de fitxers
                    InterficieUsuari.mostrarMissatge("Fusió fitxers");
                }else if ( opcio == 3 ){
                    // Mostrar fitxer de text
                    InterficieUsuari.mostrarMissatge("Mostrar fitxer text");
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
