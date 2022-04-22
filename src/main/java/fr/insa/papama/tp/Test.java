/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.papama.tp;

import fr.insa.papama.td.syslin.Matrice;

/**
 * MAIN PROGRAMME 
 * @author Haimavati
 */
public class Test {
    
    
    public static void main(String[] args) {        

       
//      Vecteur2D => création d'un vecteur avec ses coordonées 
        Vecteur2D v1;
        System.out.println("Entrez les coordonnées du vecteur");
        double x=Lire.d();
        double y=Lire.d();  
        v1 = new Vecteur2D(x,y);  
        System.out.println(v1.toString());
//      v.getVx

//      Noeud => création d'un Noeud avec ses attributs 
        Noeud n; 
        int i; 
        n=Noeud.entreeNoeud(); 
        System.out.println(n);
//        i=nbrInconnues(n); 
//        System.out.println("Ce noeud comporte"+ i +"inconnues"); 
    }
}
