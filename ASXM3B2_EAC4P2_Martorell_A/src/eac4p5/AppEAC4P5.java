/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eac4p5;

import java.util.Scanner;

/**
 *
 * @author jmartorell
 */
public class AppEAC4P5 {

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
    boolean cotxeTrobat = true;
    boolean semafor = true;
    int opcio = 0;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AppEAC4P5 prg = new AppEAC4P5();
        prg.inici();
    }
    
    private void inici(){
        // Primer es mostra l'ocupació del parking que ha de ser d'un vehicle
        mostrarOcupacioParking();
        /* Després es simula l'entrada de molts vehicles, sense oblidar que abans de
         *  insertat qualsevol vehicle n'haruem de retirar un altre.
         */
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
        
        while(semafor){
            System.out.print( 
                        "\nEscull una d'aquestes opcions:\n"    
                        +"     • afegir cotxe............................(1)\n"    
                        +"     • retirar cotxe...........................(2)\n"        
                        +"     • mostrar plaçes ocupades al parking......(3)\n"
                        +"     • sortir..................................(4)\n");
            Scanner scan = new Scanner(System.in);
            opcio = scan.nextInt();
            switch(opcio){
                case 1:
                    System.out.print("Introdueixi la matricula del vehicle a insertar: ");
                    Scanner scan2 = new Scanner(System.in);
                    String insertar;
                    insertar = scan2.nextLine();
                    afegirNouCotxe(insertar, generarHoraEntrada());
                    break;
                case 2:
                    eliminarVehicle(cotxesAparcats);
                    break;
                case 3:
                    mostrarOcupacioParking();
                    break;
                default:
                    semafor = false;
            }  
            
        }
        
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
    * 1) Demana a a l’usuari quina és la matrícula del cotxe que es retirarà.
    * 2) Cercar la posició del cotxe dins de l’aparcament a partir de la matrícula introduida. 
    * 3) Un cop s’obté la posició, si és correcte, es mostra el preu a pagar. S’espera a que confirmi el pagament amb ENTER.
    * 4) Un cop fet el pagament, eliminem el vehicle del pàrquing definitivament.
    * 5) Torna a mostrar la pantalla amb les 3 opcions principals més la de sortir.
    */
    
    void eliminarVehicle(String param[][]){
        // demanem al usuari que introdueixi la matricula del vehicle que vol retirar
        System.out.print("Introdueixi la matricula del vehicle a retirar: ");
        Scanner scan = new Scanner(System.in);
        String str = "";
        str = scan.nextLine();
       
        for(int i=0; i<param.length; i++){
            if(str.equalsIgnoreCase(param[i][ID_MATRICULA])){
                cotxeTrobat = false;
                System.out.println("Hora d'entrada: "+ param[i][ID_HORA]);
                // itroduïm l'hora de sortida
                System.out.print("Introdueixi l'hora de sortida: ");
                String str2 = "";
                str2 = scan.nextLine();
                // calculem total dels minuts que mes en devant es restaran de total dels minuts d'entrada
                String string = str2;
                String[] rellotge = string.split(":");
                String hora = rellotge[0];
                String minuts = rellotge[1];
                int minutsSortida = (Integer.parseInt(hora)*60) + Integer.parseInt(minuts);
                // calculem els minuts de l'hora d'entrada...
                String string2 = param[i][ID_HORA];
                String[] rellotge2 = string2.split(":");
                String hora2 = rellotge2[0];
                String minuts2 = rellotge2[1];
                int minutsEntrada = (Integer.parseInt(hora2)*60) + Integer.parseInt(minuts2);
                // introduïm al final una variable amb l'algoritme que ens mostrarà la quantitat a pagar
                double total = (minutsSortida - minutsEntrada)*0.045;
                // si la quantitat es negativa mostrem un missatge
                if(total < 0){
                    System.out.println("El cotxe ha estat retirat per la grua"
                            + "\nPremi ENTER per continuar");
                }else{
                /* treiem per parntalla el parametres implicats en el pagament 
                   indican la quantita que ha de pagar */
                System.out.print("\nMatricula: "+ param[i][ID_MATRICULA] +"\n"
                        + "Entrada: "+ param[i][ID_HORA] +"\n"
                        + "Sortida: "+ str2 +"\n"
                        + "Quantitat a pagar: "+ (String.format("%.2f", total)) +" €\n"
                        + "\nSiusplau, premeu ENTER per acepar el pagament");
                }
                // finalment esborrem la matrícula de l'array
                str = scan.nextLine();
                for (int j = i; j < param.length - 1; j++) {
                    param[j][ID_MATRICULA] = param[j+1][ID_MATRICULA]; 
                    param[j][ID_HORA] = param[j+1][ID_HORA];

                }
                numCotxesAparcats--;
            }
            
        }
        if(cotxeTrobat){
            System.out.println("ERROR: La matrícula no es troba dins del parking");
        }
        
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
        if ( numCotxesAparcats == cotxesAparcats.length ){
            System.out.println("\n------------------------------------------");
            System.out.println("  Aparcament ple, " + matricula + " es queda fora");
            System.out.println("------------------------------------------");
        }else{
            matricula = matricula.toUpperCase();
            int i = 0;
            // Ciclem la variable "i" fins assolir el valor de numCotxesAparcats o la posició de una matricual coincident.
            while ( !matricula.equals(cotxesAparcats[i][ID_MATRICULA]) && i < numCotxesAparcats ){
                i++;
            }
            // S'han recorregut tots els vehicles i no s'ha trobat coincidencia, insertem la matricula a l'última posició
            if ( i == numCotxesAparcats ){
                // introduïm la matrícula i l'hora a la l'última fila.
                cotxesAparcats[numCotxesAparcats][ID_MATRICULA] = matricula;
                cotxesAparcats[numCotxesAparcats][ID_HORA] = hora;
                // incrementem una posició a l'array
                numCotxesAparcats++;
            // Si ha estat una matricula coincident mostrem missatge     
            }else{
                System.out.println("ERROR! El vehicle amb matrícula " + matricula + " ja es troba aparcat");
            }
            
        }
        
    }
    
    /**
     * Mostra un llistat dels cotxes que hi ha dins l'aparcament.
     */
    private void mostrarOcupacioParking(){
        System.out.println("-----------------------------------------------");
        System.out.println("--------------LLISTAT DE VEHICLES--------------");
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < numCotxesAparcats; i++){
            System.out.print(cotxesAparcats[i][ID_MATRICULA]);
            System.out.print("                                   ");
            System.out.println(cotxesAparcats[i][ID_HORA]);
        }
        
    }
    
}

