/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.papama.tp;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
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
    public ArrayList<Barre> getBarres() {
        return barres;
    }
//On ne va pas modifier toutes les barres d'un coup
//    public void setBarres(ArrayList<Barre> barres) {
//        this.barres = barres;
//    }

    public ArrayList<Noeud> getNoeuds() {
        return noeuds;
    }

//    public void setgetNoeuds(ArrayList<Noeud> noeuds) {
//        this.noeuds = noeuds;
//    }

    //Constructeur
    public Treillis(ArrayList<Barre> barres, ArrayList<Noeud> noeuds) {
        this.barres = barres;
        this.noeuds = noeuds;
    }

    //Methodes    
    public static int maxIdNoeud(Treillis t) {
        int max = 0;
        if (t.noeuds.size() != 0) {
            for (int i = 0; i < t.noeuds.size(); i++) {
                if (t.noeuds.get(i).getId() >= max) {
                    max = t.noeuds.get(i).getId();
                }
            }
        }
        return max;
    }

    public static int maxIdBarre(Treillis t) {
        int max = 0;
        if (t.barres.size() != 0) {
            for (int i = 0; i < t.barres.size(); i++) {
                if (t.barres.get(i).getId() >= max) {
                    max = t.barres.get(i).getId();
                }
            }
        }
        return max;
    }

    public static void ajouteNoeud(Noeud n, Treillis t) {
        int i = 0;
        while (t.noeuds.get(i) != n && i < t.noeuds.size()) {
            i++;
        }
        if (i != t.noeuds.size() - 1) {
            throw new Error("Ce noeud est deja dans le treillis");
        } else {
            n.setId(maxIdNoeud(t));
            t.noeuds.add(n);
        }
    }

    public static void ajouteBarre(Barre b, Treillis t) {
        int i = 0;
        while (t.barres.get(i) != b && i < t.barres.size()) {
            i++;
        }
        if (i != t.barres.size() - 1) {
            throw new Error("Cette barre est deja dans le treillis");
        } else {
            ajouteNoeud(b.getNoeudDepart(), t);
            ajouteNoeud(b.getNoeudArrivee(), t);
            b.setId(maxIdBarre(t) + 1);
            t.barres.add(b);
        }
    }

    
    
    public static ArrayList<Barre> barreCasse(Treillis t) {
        //Création de la matrice des equations
        // dimention inconnues horizontal nbr var et bertical nbrvar+1
        int nombreequation;
        nombreequation = t.barres.size();
        for (int i = 0; i < t.noeuds.size(); i++) {
            nombreequation = nombreequation + Noeud.nbrInconnues(t.noeuds.get(i));
        }
        double[][] Equation;
        Equation = new double[nombreequation][nombreequation+1];
        for (int i = 0; i < nombreequation; i++) {
            for (int j = 0; j < nombreequation; j++) {
                Equation[i][j] = 0;
            }
        }

        //Creation d'une liste contenant les inconnues
        ArrayList<String> Inconnues = new ArrayList();
        for (int j = 0; j < t.barres.size(); j++) {
            Inconnues.add("T" + j);
        }
        for (int y = 0; y < t.noeuds.size(); y++) {
            if (t.noeuds.get(y) instanceof NoeudSimple == false) {
                if (t.noeuds.get(y) instanceof NoeudAppuiSimple == true) {
                    Inconnues.add("R" + y);
                
                } else {
                    Inconnues.add("R" + y + "x");
                    Inconnues.add("R" + y + "y");
                }
            }
        }

        //Afficher les inconnues
        for (int i = 0; i < Inconnues.size(); i++) {
            System.out.print(Inconnues.get(i));
        }

        //Creation de la matrice à résoudre
        int lig=0;
        for(int i=0;i<t.noeuds.size();i++){
            //Remplissage Réactions
            Noeud n= t.noeuds.get(i);
            if (n instanceof NoeudSimple){
            }else{
                if(n instanceof NoeudAppuiDouble){
                    int num=Treillis.numVar(Inconnues, n, t);
                    Equation[lig][num]=1;
                    Equation[lig][num+1]=1;
                }else{
                    int num=Treillis.numVar(Inconnues,n,t);
                    //TODO cos? et résoudre problème
                    Equation[lig][num]=cos(n.getNormale);
                    Equation[lig][num+1]=sin(n.getNormale);
                }
            }            
            //Equation selon x pour les tensions dans les barres
            for(int j=0;j<Noeud.barresIncidentes(n).size();j++){
                Barre b=Noeud.barresIncidentes(n).get(j);
                double angle= Barre.Angle(n,b);
                int col= Treillis.numVar(Inconnues,b,t);
                Equation[lig][col]=cos(angle);
                Equation[lig][col]=n.getF().getVx();
            }
            lig++;
            //Equation selon y pour les tensions dans les barres
            for(int j=0;j<Noeud.barresIncidentes(n).size();j++){
                Barre b=Noeud.barresIncidentes(n).get(j);
                double angle;
                angle = Barre.Angle(n,b);
                int col= Treillis.numVar(Inconnues,b,t);
                Equation[lig][col]=sin(angle);
                Equation[lig][col]=n.getF().getVy();
            }
            lig++;
        }  
        
        //Resolution de la matrice
        double[] v = Treillis.resoudreMatrice(Equation);
        for (int in = 0; in < v.length; in++) {
            System.out.print(v[in] + " | ");
        }
        //TODO gérer si c'est une compression ou une traction
        //Trouver les barres qui risquent de casser
        ArrayList<Barre> fragile = new ArrayList();
        for (int k = 0; k < t.barres.size(); k++) {
            if (v[k] > t.barres.get(k).getCompressionMax()) {
                fragile.add(t.barres.get(k));
            }
        }
        return fragile;
    }
    
    public static int numVar(ArrayList<String> inconnues,Barre b, Treillis t) {
        int pos = t.barres.indexOf(b);
        int i=0;
        while(i<inconnues.size() && !inconnues.get(i).equals("T"+pos)){
            i++;
        }
        if(i==inconnues.size()-1){
            throw new Error ("Il n'y a pas d'inconnues suivant cette barre");
        }else{
            return i;
        }
    }
    
    public static int numVar(ArrayList<String> inconnues,Noeud n, Treillis t) {
        int pos = t.barres.indexOf(n);
        int i=0;
        while(i<inconnues.size() && !inconnues.get(i).contains("R"+pos)){
            i++;
        }
        if(i==inconnues.size()-1){
            throw new Error ("Il n'y a pas d'inconnues suivant cette barre");
        }else{
            return i;
        }
    }
    
    //Methodes permettant d'effectuer le pivot de gauss pour résoudre la matrice
    static void permutation(int l, double[][] a) {
        int n = a[a.length-1].length;
        double aux;
        int ll = l;
        while (a[ll][l] == 0.0) {
            ll++;
        }
        for (int i = l; i < n; i++) {
            aux = a[l][i];
            a[l][i] = a[ll][i];
            a[ll][i] = aux;
        }
        aux = a[a.length-1][l];
        a[a.length-1][l] = a[a.length-1][ll];
        a[a.length-1][ll] = aux;
    }

    static void transformation(double[][] a) {
        int n = a[a.length-1].length;
        for (int i = 1; i < n; i++) {
            if (a[i - 1][i - 1] == 0.0) {
                permutation(i - 1, a);
            }
            for (int j = i; j < n; j++) {
                double facteur = a[j][i - 1] / a[i - 1][i - 1];
                for (int k = i - 1; k < n; k++) {
                    a[j][k] = a[j][k] - a[i - 1][k] * facteur;
                }
                a[a.length-1][j] = a[a.length-1][j] - a[a.length-1][i - 1] * facteur;
            }
        }
    }

    static double[] extraction(double[][] a) {
        int n = a[a.length-1].length;
        double[] v = new double[n];
        v[n - 1] = a[a.length-1][n - 1] / a[n - 1][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            v[i] = a[a.length-1][i];
            for (int j = n - 1; j > i; j--) {
                v[i] = v[i] - v[j] * a[i][j];
            }
            v[i] = v[i] / a[i][i];
        }
        return v;
    }

    static double[] resolution(double[][] a) {
        transformation(a);
        return extraction(a);
    }

    public static double[] resoudreMatrice(double[][] m) {
        return resolution(m);
    }

}
