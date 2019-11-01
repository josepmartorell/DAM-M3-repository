/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eac4p3;

/**
 *
 * @author jmartorell
 */
public class AppEAC4P3 {

    static final short ID_MATRICULA = 0;
    static final short ID_HORA = 1;
    String[][] cotxesAparcats = {
        {"3130JPG", "11:10"},
        {"", ""},
        {"", ""},
        {"", ""},
        {"", ""},
        {"", ""},
        {"", ""},
        {"", ""},
        {"", ""},
        {"", ""}
    };
    int numCotxesAparcats = 1;
    
    String[] horesEntradaAleatories = {
        "08:00",
        "08:30",
        "09:00",
        "09:30",
        "10:00",
        "10:30",
        "11:00",
        "11:30",
        "12:00",
        "12:30",
        "13:00",
        "13:30",
        "14:00",
        "14:30",
        "15:00",
        "15:30",
        "16:00",
        "16:30",
        "17:00",
        "17:30",
        "18:00",
        "18:30",
        "19:00",
        "19:30",
        "20:00",
        "20:30",
        "21:00",
        "21:30",
        "22:00",
    };
    
    /**
* @param args the command line arguments
*/
    public static void main(String[] args) {

        AppEAC4P3 prg = new AppEAC4P3();
        prg.inici();
    }
    
     private void inici(){
        // Primer es mostra l'ocupació del parking que ha de ser d'un vehicle
        mostrarOcupacioParking();
        // Després es simula l'entrada de molts vehicles
        afegirNouCotxe("9201DDR", generarHoraEntrada());
        mostrarOcupacioParking();
        afegirNouCotxe("9202DDR", generarHoraEntrada());
        mostrarOcupacioParking();
        afegirNouCotxe("9203DDR", generarHoraEntrada());
        mostrarOcupacioParking();
        afegirNouCotxe("9204DDR", generarHoraEntrada());
        mostrarOcupacioParking();
        afegirNouCotxe("9205DDR", generarHoraEntrada());
        mostrarOcupacioParking();
        afegirNouCotxe("9206DDR", generarHoraEntrada());
        mostrarOcupacioParking();
        // Es repeteix expressament la matricula d'una entrada per a veure si 
        // el software és capaç de detectar-ho i comunicar-ho.
        afegirNouCotxe("9206ddr", generarHoraEntrada());
        
        // Seguim introduïnt cotxes
        afegirNouCotxe("9207DDR", generarHoraEntrada());
        mostrarOcupacioParking();
        afegirNouCotxe("9208DDR", generarHoraEntrada());
        mostrarOcupacioParking();
        afegirNouCotxe("9209DDR", generarHoraEntrada());
        mostrarOcupacioParking();
        
        // Hem arribat al maxim d'ocupació, aquesta darrera entrada no hauria
        // de permetre inserir-la.
        afegirNouCotxe("9210DDR", generarHoraEntrada());
    }
    
    /**
* Retorna una hora d'entrada aleatoria procedent de l'array d'hores d'entrada
* aleatories de l'aplicació. 
* @return 
*/
    private String generarHoraEntrada(){
        return horesEntradaAleatories[(int) (Math.random() * horesEntradaAleatories.length)];
    }
    
    /**
* A partir de la matricula rebuda cerca si el cotxe es troba dins l'array
* cotxesAparcats, en cas contrari en farà la inserció a la darrera posició
* incrementant el nombre de cotxes aparcats. Si s'arriba al màxim ja no 
* farà cap més inserció.
* La matricula pot contenir les lletres en majúscules o minúscules
* @param matricula matrícula del vehicle a inserir
* @param hora hora a la que el vehicle ha arrribat a '
*/
    private void afegirNouCotxe(String matricula, String hora){
/* si el aparcamente és ple mostrem messatge, sino (else)es procedeix a l'insercio de la matricula*/

        if(numCotxesAparcats >= 10){
            System.out.println("Parking complet!");
            
            //System.out.println("ERROR! El vehicle amb matrícula"+matricula+" ja es troba aparcat");
            
        }else{
/* si no esta complet organizarem dos bucles en serie, el primer per detectar matricules repetides*/
            boolean cotxeNoEntra = false;
            for(int i = 0; i < cotxesAparcats.length; i++){
                
                if(matricula.equalsIgnoreCase(cotxesAparcats[i][ID_MATRICULA])){
                System.out.println("ERROR! El vehicle amb matrícula "+matricula+" ja es troba aparcat.");
                cotxeNoEntra = true;
                }
                
            } 
/* es segon per insertar matricules restringuim el rang de les files al espai lliure per mitja de la variable 
            numCotxesAparcats*/
            if(!cotxeNoEntra){
                for(int i = numCotxesAparcats; i < numCotxesAparcats+1; i++){

                        cotxesAparcats[i][ID_MATRICULA] = matricula;
                        cotxesAparcats[i][ID_HORA] = hora; 
                }
                numCotxesAparcats++;
            }
            
        }
                 
    }
    /**
* Mostra un llistat dels cotxes que hi ha dins l'aparcament.
*/
    private void mostrarOcupacioParking(){
        /*"pintem" la capsalera*/
        System.out.println("-------------------------------------------------\n"
                         + "---------------LLISTAT DE VEHICLES---------------\n"
                         + "-------------------------------------------------");
/*Recorrem la matriu i mostrem les dues columnes separades per un espai*/
        for(int i=0;i<numCotxesAparcats;i++){
            
            System.out.println(cotxesAparcats[i][ID_MATRICULA]
                    + "                                     "
                    + cotxesAparcats[i][ID_HORA]);
        } 
        
    }   
    
}