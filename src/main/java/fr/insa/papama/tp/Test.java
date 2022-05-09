/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.papama.tp;

import fr.insa.papama.td.syslin.Matrice;
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

//      double [][] syslin=new double[4][5];
//      syslin[0][0]=2;
//      syslin[1][0]=3;
//      syslin[2][0]=1;
//      syslin[3][0]=0;
//      syslin[0][1]=1;
//      syslin[1][1]=-1;
//      syslin[2][1]=4;
//      syslin[3][1]=2;
//      syslin[0][2]=-1;
//      syslin[1][2]=1;
//      syslin[2][2]=0;
//      syslin[3][2]=1;
//      syslin[0][3]=1;
//      syslin[1][3]=-1;
//      syslin[2][3]=-6;
//      syslin[3][3]=-3;
//      syslin[0][4]=-1;
//      syslin[1][4]=6;
//      syslin[2][4]=7;
//      syslin[3][4]=5;
//      double res[]= new double[4];
//      res=Treillis.ResoudreSysLin(syslin);
//      for (int i=0; i<4; i++) {
//            System.out.println(res[i]+"     ");
//        }
        
    }
    
    
}
