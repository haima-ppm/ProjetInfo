/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.papama.td.syslin;


/**
 *
 * @author Haimavati
 */


public class Matrice {
   
    // Attributs 
    int nbrLig;
    int nbrCol; 
    double[][] coeffs; 
    
    /* TABLEAUX
    int[]; // déclaration 
    t = new int[n]; // initialisation 
    double[][] coeffs; // déclaration
    coeffs = new double [nl][nc]; //initialisation
    */
    
   
    // Constructeur 
    Matrice(int nl, int nc) {
        this.nbrLig = nl; 
        this.nbrCol = nc; 
        this.coeffs = new double[nl][nc];  
        for (int i=0; i<nl; i++) {
            for (int j=0; j<nc; j++){
                coeffs[i][j] = 0 ;
            }
        }
    }
    
//    public static void main(String[] args) {
//        Matrice m; 
//        int nl; 
//        int nc; 
//        System.out.println("Entrez le nombre de lignes"); 
//        nl= Lire.i(); 
//        System.out.println();
//        System.out.println("Entrez le nombre de colonnes"); 
//        nc= Lire.i();
//        System.out.println();
//        m = new Matrice(nl, nc); 
//        
//        //L'utilisateur entre les coefficients de la matrice
//        for (int i=0; i<nl; i++) {
//            for (int j=0; j<nc; j++) {
//                System.out.println("Entrez les coefficients de la matrice");
//                double c; 
//                m.coeffs[i][j] = Lire.d(); 
//            }
//        }
//        
//        
//        // Affichage de la matrice 
//        for (int i=0; i<nl; i++) {
//            for (int j=0; j<nc; j++){
//                System.out.print(m.coeffs[i][j]+"     ");
//            }
//            System.out.println();
//        }
//    }
    
}
    
    
