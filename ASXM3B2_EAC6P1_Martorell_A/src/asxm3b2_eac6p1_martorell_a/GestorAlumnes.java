package asxm3b2_eac6p1_martorell_a;

import java.io.File;
/**
 *
 * @author jmartorell
 */
public class GestorAlumnes {
    
    /**
     * Poseu aquí totes les opcions de manipulació de fitxers que 
     * des del programa principal es fan servir.
     */
	 
    /** 
     * Funció que comprova si a la carpeta de l'aplicació existeixen els fitxers
     * de text necessaris per a treballar.
     * @return cert si existeixen els fitxer. Fals altrament.
     */
    public boolean fitxersPresents(){
        boolean resposta=false;
        File fitxerAlumnes = new File("alumnes.txt");
        File fitxerAmonestacions = new File("amonestacions.txt");
        if (fitxerAlumnes.exists() && fitxerAmonestacions.exists()) {
            resposta = true;
        }       
        return resposta;
    }
    
}

