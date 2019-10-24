/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p4_e8_martorella_b;

import java.util.Scanner;

/**
 *
 * @author jmartorell
 */
public class P4_e8_MartorellA_B {

    // declarem constats
    public static final int MIN_CODI = 1000;
    public static final int MAX_CODI = 4000;
    public static final int MIN_HORA = 6;
    public static final int MAX_HORA = 21;
    public static final int MIN_MINUT = 0;
    public static final int MAX_MINUT = 59;
    public static final int MIN_PERMANENCIA = 1;
    public static final int MAX_PERMANENCIA = 360;
    public static final int GENERE1 = 1;
    public static final int GENERE2 = 2;
    public static final String GENERE1_NOM = "noia";
    public static final String GENERE2_NOM = "noi";
    public static final int TIPUS_0 = 0;
    public static final int TIPUS_1 = 1;
    public static final int TIPUS_2 = 2;
    public static final int TIPUS_3 = 3;
    public static final String TIPUS_0_NOM= "no abonat";
    public static final String TIPUS_1_NOM = "total";
    public static final String TIPUS_2_NOM = "només piscina";
    public static final String TIPUS_3_NOM = "caps de setmana";
    public static final int NO_SEGUIR = 0;
    public static final int SI_SEGUIR = 1;
    public static final int MAX_USUARIS = 10;
    public static final int NUM_COLUMNES = 10;

    public static void main(String[] args) {
        
        // declarem variables i arranjaments
        int comptador=0, seguir=0, usuarisEntrats=0, i = 0;
        int codiAux = 0, horaAux = 0, minutAux = 0, permanenciaAux =0, genereAux = 0, tipusAux = 0;
        String genereNom="", tipusNom="";
        boolean dadaCorrecta=true, introduirMes=true;
        int [][] taula = new int[MAX_USUARIS][NUM_COLUMNES];
        
        
        // instanciar objecte Scanner
        Scanner scan = new Scanner(System.in);
        
        do{
            // demanem el codi d'usuari
            System.out.println("-------------Entrada de dades d'usuari-------------");
            System.out.print("Codi d'identificació d'usuari: ");
            do{
                // analitzem tipus de dada
                dadaCorrecta = scan.hasNextInt();
                if (dadaCorrecta){ //si és un número sencer llegim dades
                    taula[i][0] = scan.nextInt();
                    // avaluem si és vàlida
                    if((taula[i][0] < MIN_CODI)||(taula[i][0] > MAX_CODI)){
                        dadaCorrecta = false;
                        comptador++;
                        if(comptador < 3){
                            System.out.print("Dada incorrecta, torni a introduir-la: ");
                        }
                    }
                }else{
                    dadaCorrecta = false;
                    comptador++;
                    if(comptador < 3){
                        System.out.print("Dada incorrecta, torni a introduir-la: ");
                    }
                }
            scan.nextLine();
            // mentre dadaCorrecta sigui false i  el comptador no arribi a 3 no sortirem del bucle
            }while((!dadaCorrecta)&&(comptador < 3));
            
            // restablim el comptador
            comptador = 0;
            // continuem demanant la següent dada
            if(dadaCorrecta){// si tot és correcte proseguim, de lo contrari saltarem fins l'else de l'últim if...
                // entrem hora d'entrada
                System.out.print("Hora d'entrada: ");
                do{
                    dadaCorrecta = scan.hasNextInt();
                    if(dadaCorrecta){
                        taula[i][1] = scan.nextInt();
                        if((taula[i][1] < MIN_HORA)||(taula[i][1] > MAX_HORA)){
                            dadaCorrecta = false;
                            comptador++;
                            if(comptador < 3){
                                System.out.print("Dada incorrecta, torni a introduir-la: ");
                            }
                        }
                    }else{
                        dadaCorrecta = false;
                        comptador++;
                        if(comptador < 3){
                            System.out.print("Dada incorrecta, torni a introduir-la: ");
                        }
                    }
                    scan.nextLine();
                // mentre dadaCorrecta sigui false i  el comptador no arribi a 3 no sortirem del bucle
                }while((!dadaCorrecta)&&(comptador < 3));    
            }
            
            // restablim de nou el comptador
            comptador = 0;
            if(dadaCorrecta){// si tot és correcte proseguim...
                // entrem minut d'entrada
                System.out.print("Minut d'entrada: ");
                do{
                    dadaCorrecta = scan.hasNextInt();
                    if (dadaCorrecta){
                        taula[i][2] = scan.nextInt();
                        if((taula[i][2] < MIN_MINUT)||(taula[i][2] > MAX_MINUT)){
                            dadaCorrecta = false;
                            comptador++;
                            if(comptador < 3){
                                System.out.print("Dada incorrecta, torni a introduir-la: ");
                            }
                        }
                    }else{
                        dadaCorrecta = false;
                        comptador++;
                        if(comptador < 3){
                            System.out.print("Dada incorrecta, torni a introduir-la: ");
                        }
                    }
                scan.nextLine();
                // mentre dadaCorrecta sigui false i  el comptador no arribi a 3 no sortirem del bucle    
                }while((!dadaCorrecta)&&(comptador < 3));    
            }
            
            // restablim de nou el comptador
            comptador = 0;
            if(dadaCorrecta){// si tot és correcte proseguim...    
                // entrem minuts de permanencia
                System.out.print("Total en minuts de permanència?: ");    
                do{
                    dadaCorrecta = scan.hasNextInt();
                    if (dadaCorrecta){
                        taula[i][3] = scan.nextInt();
                        if((taula[i][3] < MIN_PERMANENCIA)||(taula[i][3] > MAX_PERMANENCIA)){
                            dadaCorrecta = false;
                            comptador++;
                            if(comptador < 3){
                                System.out.print("Dada incorrecta, torni a introduir-la: ");
                            }
                        }
                    }else{
                        dadaCorrecta = false;
                        comptador++;
                        if(comptador < 3){
                            System.out.print("Dada incorrecta, torni a introduir-la: ");
                        }
                    }
                scan.nextLine();
                // mentre dadaCorrecta sigui false i  el comptador no arribi a 3 no sortirem del bucle    
                }while((!dadaCorrecta)&&(comptador < 3));    
            }
            
            // restablim de nou el comptador
            comptador = 0;
            if(dadaCorrecta){// si tot és correcte proseguim...
                // entrem gènere de l'usuari
                System.out.print("És noia (1) o noi (2)?: ");
                do{
                    dadaCorrecta = scan.hasNextInt();
                    if (dadaCorrecta){
                        taula[i][4] = scan.nextInt();
                        if((taula[i][4] < GENERE1)||(taula[i][4] > GENERE2)){
                            dadaCorrecta = false;
                            comptador++;
                            if(comptador < 3){
                                System.out.print("Dada incorrecta, torni a introduir-la: ");
                            }
                        }
                    }else{
                        dadaCorrecta = false;
                        comptador++;
                        if(comptador < 3){
                            System.out.print("Dada incorrecta, torni a introduir-la: ");
                        }
                    }
                scan.nextLine();
                // mentre dadaCorrecta sigui false i  el comptador no arribi a 3 no sortirem del bucle    
                }while((!dadaCorrecta)&&(comptador < 3));    
            }
            
            // restablim el comptador
            comptador = 0;
            if(dadaCorrecta){// si tot és correcte proseguim...  
                // entrem tipus d'usuari
                System.out.print( 
                        "tipus d'usuari?:\n"    
                        +"\t• no abonat..........(0)\n"    
                        +"\t• total..............(1)\n"        
                        +"\t• només piscina......(2)\n"
                        +"\t• caps de setmana....(3): ");
                do{
                    dadaCorrecta = scan.hasNextInt();
                    if (dadaCorrecta){
                        taula[i][5] = scan.nextInt();
                        if((taula[i][5] < TIPUS_0)||(taula[i][5] > TIPUS_3)){
                            dadaCorrecta = false;
                            comptador++;
                            if(comptador < 3){
                                System.out.print("Dada incorrecta, torni a introduir-la: ");
                            }
                        }
                    }else{
                        dadaCorrecta = false;
                        comptador++;
                        if(comptador < 3){
                            System.out.print("Dada incorrecta, torni a introduir-la: ");
                        }
                    }
                scan.nextLine();
                // mentre dadaCorrecta sigui false i  el comptador no arribi a 3 no sortirem del bucle    
                }while((!dadaCorrecta)&&(comptador < 3));
            }
            
            if(dadaCorrecta){// si tot és correcte proseguim...             
                // comptador per a la quantitat d'usuaris entrats
                usuarisEntrats++;
                i++;// incrementem l'index i del arrays
            }else{ 
                System.out.println("Intents esgotats");
            }
            // restablim el comptador
            comptador = 0;
            System.out.print("Vol seguir introduint més dades?\n" +
                             "\t• sortir.............(0)\n" +
                             "\t• continuar..........(1): ");
            do{
                dadaCorrecta = scan.hasNextInt();
                if(dadaCorrecta){
                    seguir = scan.nextInt();
                    if((seguir < NO_SEGUIR) || (seguir > SI_SEGUIR)){
                        dadaCorrecta = false;
                            comptador++;
                            if(comptador < 3){
                                System.out.print("Dada incorrecta, torni a introduir-la: ");
                            }
                    }
                }else{
                    dadaCorrecta = false;
                    comptador++;
                    if(comptador < 3){
                        System.out.print("Dada incorrecta, torni a introduir-la: ");
                    }
                }
            scan.nextLine();
            // mentre dadaCorrecta sigui false i  el comptador no arribi a 3 no sortirem del bucle    
            }while((!dadaCorrecta)&&(comptador < 3));
            
            if(seguir == NO_SEGUIR){
                introduirMes = false;
            }
        
        }while(introduirMes);
        
        // mostrem els llistat amb les dedes de tots els usuaris introduïts
        System.out.println("\nCODI  ENTRADA  TEMPS  GENERE  TIPUS");
        for(i = 0; i < usuarisEntrats; i++){
            if(dadaCorrecta){ 
                switch(taula[i][4]){
                    case GENERE1:
                        genereNom = GENERE1_NOM;
                        break;
                    case GENERE2:
                        genereNom = GENERE2_NOM;
                        break;
                }
            }
            if(dadaCorrecta){
                switch(taula[i][5]){
                    case TIPUS_0:
                        tipusNom = TIPUS_0_NOM;
                        break;
                    case TIPUS_1:
                        tipusNom = TIPUS_1_NOM;
                        break;
                    case TIPUS_2:
                        tipusNom = TIPUS_2_NOM;
                        break;
                    case TIPUS_3:
                        tipusNom = TIPUS_3_NOM;
                        break;
                }

            }
            System.out.println(taula[i][0] + "  " +taula[i][1]+":"+taula[i][2]+ "     "+taula[i][3]+"m     "+genereNom+"    "+tipusNom);
        }

        // mostrem la quantitat de usuaris entrats
        System.out.println("\nS'han introduït " + usuarisEntrats + " usuaris");
        // demanem si es vol mostrar els llistats endreçats per permanencia
        System.out.print("Vols mostrar els usuaris endreçats per permanencia?\n" +
                         "\t• sortir.............(0)\n" +
                         "\t• continuar..........(1): "); 
        dadaCorrecta = scan.hasNextInt();
        // fem el control de dades i avaluem la decisió
        if ( dadaCorrecta ){ // si és un número sencer
            seguir = scan.nextInt();
            // si a entrat el númeno 1 utilitzem l'algoritme de la bombolla per orednar els llistats
            if(seguir == 1){
                for(i = 0; i < usuarisEntrats; i++){
                    for(int j = i + 1; j < usuarisEntrats; j++){
                        // s'endreça per permanencia
                        if(taula[i][3] > taula[j][3]){
                            codiAux = taula[j][0];
                            taula[j][0] = taula[i][0];
                            taula[i][0] = codiAux; 
                            
                            horaAux = taula[j][1];
                            taula[j][1] = taula[i][1];
                            taula[i][1] = horaAux;
                            
                            minutAux = taula[j][2];
                            taula[j][2] = taula[i][2];
                            taula[i][2] = minutAux;
                            
                            permanenciaAux = taula[j][3];
                            taula[j][3] = taula[i][3];
                            taula[i][3] = permanenciaAux;
                            
                            genereAux = taula[j][4];
                            taula[j][4] = taula[i][4];
                            taula[i][4] = genereAux;
                            
                            tipusAux = taula[j][5];
                            taula[j][5] = taula[i][5];
                            taula[i][5] = tipusAux;
                            
                        }
                    }
                }
                // finalment amb el cicle for mostrem per pantalla els llistats endreçats dels usuaris
                System.out.println("\nCODI  ENTRADA  TEMPS  GENERE  TIPUS");
                for(i = 0; i < usuarisEntrats; i++){
                    // asignem les cadenes corresponents ales variables genereNom i tipusNom dins del mateix cicle
                    switch(taula[i][4]){
                    case GENERE1:
                        genereNom = GENERE1_NOM;
                        break;
                    case GENERE2:
                        genereNom = GENERE2_NOM;
                        break;
                    }
                    switch(taula[i][5]){
                    case TIPUS_0:
                        tipusNom = TIPUS_0_NOM;
                        break;
                    case TIPUS_1:
                        tipusNom = TIPUS_1_NOM;
                        break;
                    case TIPUS_2:
                        tipusNom = TIPUS_2_NOM;
                        break;
                    case TIPUS_3:
                        tipusNom = TIPUS_3_NOM;
                        break;
                    }
                    System.out.println(taula[i][0] + "  " +taula[i][1]+":"+taula[i][2]+ "     "+taula[i][3]+"m     "+genereNom+"    "+tipusNom);
                }
            }
        }else{
            System.out.println("dada incorrecta");  
        } 
    }
}