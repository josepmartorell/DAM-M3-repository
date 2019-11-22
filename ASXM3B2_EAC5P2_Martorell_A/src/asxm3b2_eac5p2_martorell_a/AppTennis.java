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
        DadesPerCarregar dades = new DadesPerCarregar();
        gestorDades.inicialitzarDades(dadesTorneig, dades.ranking.length, dades.ranking[0].length, 
                dades.partits.length, dades.partits[0].length);
        do{
            
            InterficieUsuari.mostrarMenu(menu);
            opcio = Utils.demanarEnter("Tria una opció", "Error");
            switch (opcio){
                case 1:
                    // No implementarem res
                    break;
                case 2:
                    gestorDades.carregarPartits(dadesTorneig, dades);
                    InterficieUsuari.mostrarRanking(dadesTorneig.ranking);
                    break;
                case 3:
                    // No implementarem res
                    break;
                case 0:
                    break;
                default:
            }
            
        }while ( opcio != 0 );
        
    }
    
}