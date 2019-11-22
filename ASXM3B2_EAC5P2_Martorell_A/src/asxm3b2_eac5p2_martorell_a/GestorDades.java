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
public class GestorDades {
    public void inicialitzarDades(DadesTorneig dadesTorneig, int filesRanking, int columnesRanking, int filesPartits, int columnesPartits){
        dadesTorneig.ranking = new String[filesRanking][columnesRanking];
        dadesTorneig.partits = new String[filesPartits][columnesPartits];

    
    }  
    public void carregarPartits(DadesTorneig dadesTorneig, DadesPerCarregar dades){
        for (int i = 0; i < dades.ranking.length ; i++){
        dadesTorneig.ranking[i][0] = dades.ranking[i][0];
        dadesTorneig.ranking[i][1] = dades.ranking[i][1];
        dadesTorneig.nombreEntradesRanking++;
        }
        
    }
    
}   
