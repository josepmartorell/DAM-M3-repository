/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asxm3b2_eac5p1_martorell_a;

import java.util.Scanner;
/**
 *
 * @author jmartorell
 */

public class Utils {
    /* Utilitzat en tot programa principal, permet capturar per teclat un enter després de mostrar el
     * missatge corresponent al primer paràmetre. En cas d’error en la introducció (no es tracta d’un enter) 
     * mostra el missatgeError (segon paràmetre) i demana novament l’enter fins que la introducció sigui la correcte. 
     */ 
    public static int demanarEnter(String missatge, String missatgeError) {
        
        Scanner scan = new Scanner(System.in);
        boolean dadaCorrecta = true;
        int opcioUsuari = 0;
        System.out.println(missatge);  
        dadaCorrecta = scan.hasNextInt();
        do{
            dadaCorrecta = scan.hasNextInt();
            if(!dadaCorrecta){               
                System.out.println(missatgeError);
            }else{
                opcioUsuari = scan.nextInt();           
            }
            scan.nextLine();
        }while(!dadaCorrecta);
  
        return opcioUsuari;
    };
    /* Amb un comportament semblant a l’anterior però amb el tipus de dades String, demana una cadena de text 
     * havent mostrat prèviament el missatge corresponent al primer paràmetre i, en cas que sigui buida, 
     * insisteix mostrant el missatge d’error corresponent al segon paràmetre, fins que l’entrada sigui correcta 
     */
    public static String demanarString(String missatge, String missatgeError){
        
        Scanner scan = new Scanner(System.in);
        boolean dadaCorrecta = true;
        String nomJugador = "";
        System.out.println(missatge);  
        dadaCorrecta = scan.hasNextLine();
        do{
            //dadaCorrecta = scan.hasNextLine();
            if(!dadaCorrecta){               
                System.out.println(missatgeError);
            }else{
                nomJugador = scan.nextLine();           
            }
            //scan.nextLine();
        }while(!dadaCorrecta);
        
        return nomJugador;
    };

    
}