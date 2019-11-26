package asxm3b2_eac6p1_martorell_a;


/**
 *
 * @author jmartorell
 */
public class InterficieUsuari {

    /*
     * Variables globals corresponents als missatges que es mostren per pantalla
     */
    static final String MISSATGE_ERROR_FITXER = "PROBLEMES EN EL MOSTRATGE DEL FITXER";
    
    /** 
     * Funció que mostra per pantalla les diferents opcions que formen el menú
     * que es rep com a paràmetre. La primera posició de l'array menú és el 
     * títol del mateix mentre que la resta són les opcions. Aquesta variable 
     * ja ve inicialitzada des del codi que en fa la crida.
     * @param menu Conté les diferents opcions que es mostraran per pantalla a 
     * l'usuari.
     */
    public static void mostrarMenu(String[] menu){
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(menu[0]);
        System.out.println("--------------------------------------------------------------------------------");
        for(int pos=1; pos < menu.length; pos++){
            System.out.println(menu[pos]);
        } 
        
    }
    
    /**
     * Funció que encapsula un simple volcat d'informació per pantalla
     * @param missatge Missatge a mostrar per pantalla
     */
    public static void mostrarMissatge(String missatge){
        System.out.println(missatge);
    }    

}
