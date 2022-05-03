/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.papama.tp;

import java.util.ArrayList;

/**
 *
 * @author GWENDOLINE
 */
public class Treillis {
    //Attributs   
    ArrayList<Barre> barres = new ArrayList();
    ArrayList<Noeud> noeuds = new ArrayList();
    

    // Encapsulation 
    public ArrayList<Barre> getBarres(){
        return barres; 
    }
        
    public void setBarres() {
        this.barres=barres; 
    }
    public ArrayList<Noeud> getNoeuds(){
        return noeuds; 
    }
        
    public void setgetNoeuds() {
        this.noeuds=noeuds; 
    }
    
    //Constructeur
    public Treillis(ArrayList<Barre> barres,ArrayList<Noeud> noeuds){
        this.barres=barres;
        this.noeuds=noeuds;
    }
    
    //Methodes    
    public static int maxIdNoeud(Treillis t){
        int max=0;
        if (t.noeuds.size()!=0){
            for (int i=0; i<t.noeuds.size();i++){
               if (t.noeuds.get(i).getId()>=max){
                   max=t.noeuds.get(i).getId();
               }
            }
        }
        return max;
    }
    
    public static int maxIdBarre(Treillis t){
        int max=0;
        if (t.barres.size()!=0){
            for (int i=0; i<t.barres.size();i++){
               if (t.barres.get(i).getId()>=max){
                   max=t.barres.get(i).getId();
               }
            }
        }
        return max;
    }
    
    public static void ajouteNoeud(Noeud n, Treillis t){
        int i=0;
        while(t.noeuds.get(i)!=n && i<t.noeuds.size()){
            i++;
        }
        if(i!=t.noeuds.size()-1){
            throw new Error ("Ce noeud est deja dans le treillis");
        }else{
            n.setId(maxIdNoeud(t)); 
            t.noeuds.add(n);
        }
    }
    public static void ajouteBarre(Barre b, Treillis t){
        int i=0;
        while(t.barres.get(i)!=b && i<t.barres.size()){
            i++;
        }
        if(i!=t.barres.size()-1){
            throw new Error ("Cette barre est deja dans le treillis");
        }else{
            ajouteNoeud(b.getNoeudDepart(),t);
            ajouteNoeud(b.getNoeudArrivee(),t);
            b.setId(maxIdBarre(t)+1);
            t.barres.add(b);
        }
    }
    public static ArrayList<Barre> barreCasse (Treillis t){
       //Création de la matrice des equations
       int nombreequation;
       nombreequation=t.barres.size();
       for(int i=0;i<t.noeuds.size();i++){
           nombreequation=nombreequation+Noeud.nbrInconnues(t.noeuds.get(i));
       }
       double [][]  Equation;
       Equation = new double [nombreequation][nombreequation];
       //Forme de la matrice solution (Tx1,Ty1,Tx2,Ty2,...,Rx1,Ry1,...)
       for (int y;y<t.noeuds.size();y++){
           if(t.noeuds.get(y) instanceof NoeudSimple ==false){
               
           }
       }
       
       
       
       
       
       
       //Resolution de la matrice
       double[] v = Treillis.resoudreMatrice(Equation);
        for (int in=0;in<v.length;in++){
            System.out.print(v[in]+" | ");
        }
        
       //Trouver les barres qui risquent de casser
       ArrayList<Barre> fragile = new ArrayList(); 
       for (int k=0;k<t.barres.size();k++) {
            if (v[k]>t.barres.get(k).getCompressionMax()){
                fragile.add(t.barres.get(k));
            }               
        }
       return fragile;
    }
    
  
    
    static void permutation(int l,double [][] a,double [] b) {
    int n = b.length;
    double aux;
    int ll = l;
    while ( a[ll][l] == 0.0 ) {
      ll++; }
    for ( int i = l ; i < n ; i++ ) {
      aux = a[l][i];
      a[l][i] = a[ll][i];
      a[ll][i] = aux; }
    aux = b[l];
    b[l] = b[ll];
    b[ll] = aux;
  }

  static void transformation(double [][] a,double [] b) {
    int n = b.length;
    for ( int i = 1 ; i < n ; i++ ) {
      if ( a[i-1][i-1] == 0.0 )
        permutation(i-1,a,b);
      for ( int j = i ; j < n ; j++ ) {
        double facteur = a[j][i-1]/a[i-1][i-1];
        for ( int k = i-1 ; k < n ; k++ ) {
          a[j][k] = a[j][k] - a[i-1][k]*facteur; }
        b[j] = b[j] - b[i-1]*facteur;  } }
  }

  static double [] extraction(double [][] a,double [] b) {
    int n = b.length;
    double [] v = new double[n];
    v[n-1] = b[n-1]/a[n-1][n-1];
    for ( int i = n-2 ; i >= 0 ; i-- ) {
      v[i] = b[i];
      for ( int j = n-1 ; j > i ; j-- ) {
        v[i] = v[i] - v[j]*a[i][j]; }
      v[i] = v[i]/a[i][i]; }
    return v;
  }

  static double [] resolution(double [][] a,
                              double [] b) {
    transformation(a,b);
    return extraction(a,b);
  }
  
  public static double [] resoudreMatrice (double[][] m){
      double[] v;
      v=new double[m.length];
      for (int j=0; j<m.length; j++){
            v[j] = 0 ;
        }
      return resolution(m,v);
  }

}
