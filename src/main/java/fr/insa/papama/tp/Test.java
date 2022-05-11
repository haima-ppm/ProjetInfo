/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.papama.tp;
import java.util.ArrayList;

/**
 * MAIN PROGRAMME 
 * @author Haimavati
 */
public class Test {
    
    
    public static void main(String[] args) {        

       
//      Vecteur2D => création d'un vecteur avec ses coordonées 
    //    Vecteur2D v1;
  //      System.out.println("Entrez les coordonnées du vecteur");
//        double x=Lire.d();
    //    double y=Lire.d();  
  //      v1 = new Vecteur2D(x,y);  
//        System.out.println(v1.toString());
//      v.getVx

//      Noeud => création d'un Noeud avec ses attributs 
//        Noeud n; 
//        n=Noeud.entreeNoeud(); 
//        System.out.println(n.toString());
//        int i=Noeud.nbrInconnues(n); 
//        System.out.println("Ce noeud comporte"+ i +"inconnues"); 
//        
//        Noeud m; 
//        m=Noeud.entreeNoeud(); 
//        System.out.println(m.toString());
//        int j=Noeud.nbrInconnues(m); 
//        System.out.println("Ce noeud comporte"+ j +"inconnues"); 
        
//        Noeud m; 
//        m=Noeud.entreeNoeud();
//        Noeud n; 
//        n=Noeud.entreeNoeud();
//        Noeud o; 
//        o=Noeud.entreeNoeud();
//        Noeud p; 
//        p=Noeud.entreeNoeud();
//        
//        Barre b= new Barre(1,n,m,1,1,1);
//        Barre b2= new Barre(2,n,o,1,1,1);
//        Barre b3= new Barre(3,n,p,1,1,1);
//        
//        ArrayList<Barre> barres = new ArrayList();
//        ArrayList<Noeud> noeuds = new ArrayList();
//        barres.add(b);
//        barres.add(b2);
//        barres.add(b3);
//        noeuds.add(m);
//        noeuds.add(o);
//        noeuds.add(p);
//        noeuds.add(n);
//        
//        Noeud nopp=Barre.noeudOppose(b, n);
//        System.out.println("le noeud opposé est "+nopp);
//        System.out.println(barres.size());
//        
//        
//        
//        
//        double a=b.Angle(n, b);
//        System.out.println("l'angle est "+a);
//        System.out.println(Noeud.barresIncidentes(n).size());
    
    Treillis t= new Treillis();
    t=Treillis.treilliTest();
    ArrayList<Barre> barreQuiCasse = new ArrayList();
    barreQuiCasse=t.barreCasse();
    System.out.println(barreQuiCasse.size());
        
    }
    
    
}
