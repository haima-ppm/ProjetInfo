/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.papama.tp;

/**
 *
 * @author GWENDOLINE
 */
public class Matrice {
   
    // Attributs 
    private int nbrLig;
    private int nbrCol; 
    private double[][] coeffs; 
    
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
    @Override
    public String toString(){
        // Affichage de la matrice 
        String s;
        s="";
        for (int i=0; i<this.getNbrLig(); i++) {
            for (int j=0; j<this.getNbrCol(); j++){
                s=s+this.coeffs[i][j]+"     ";
            }
            s=s+"\n";
        }
        return s;
    }
    
    
    public static void main(String[] args) {
        Matrice m; 
        int nl; 
        int nc; 
        System.out.println("Entrez le nombre de lignes"); 
        nl= Lire.i(); 
        System.out.println();
        System.out.println("Entrez le nombre de colonnes"); 
        nc= Lire.i();
        System.out.println();
        m = new Matrice(nl, nc); 
        
        //L'utilisateur entre les coefficients de la matrice
        for (int i=0; i<nl; i++) {
            for (int j=0; j<nc; j++) {
                System.out.println("Entrez les coefficients de la matrice"+i+" "+j);
                double c= Math.random()*10; 
                m.set(i, j, c);
            }
            m.set(i, i, 0);
        }
        System.out.println(m.toString());
        
//        m=m.descenteGauss();
        System.out.println(m.toString());
     }
        
       
    /**
     * @return the nbrLig
     */
    public int getNbrLig() {
        return nbrLig;
    }

    /**
     * @param nbrLig the nbrLig to set
     */
    public void setNbrLig(int nbrLig) {
        this.nbrLig = nbrLig;
    }

    /**
     * @return the nbrCol
     */
    public int getNbrCol() {
        return nbrCol;
    }

    /**
     * @param nbrCol the nbrCol to set
     */
    public void setNbrCol(int nbrCol) {
        this.nbrCol = nbrCol;
    }
    public double get(int i,int j){
        return this.coeffs[i][j];
    }
    
    public void set(int i, int j, double x){
        this.coeffs[i][j]=x;
    }
    
//    public Matrice descenteGauss (){
//     for(int i=0;i<this.nbrLig;i++){
//         if (this.get(i, i)==0){
//             int j=i;
//             while (j<this.nbrLig && this.get(j, i)==0){
//                 j++;
//             }
//             this.echangeligne(j, i);
//         }
//     }
//     return this;
//    }
//    
//    public Matrice echangeligne(int l1,int l2){
//        Matrice matechange=new Matrice(this.nbrLig,this.nbrCol);
//        for (int i=0;i<this.nbrLig;i++){
//            for(int j=0;j<this.nbrCol;j++){
//                if(i==l1){
//                    matechange.set(i, j, this.get(l2, j));
//                }else
//                if(i==l2){
//                    matechange.set(i, j, this.get(l1, j));
//                }else
//                    matechange.set(i, j, this.get(i, j));
//                }
//            }
//        return matechange;
//    }
}
