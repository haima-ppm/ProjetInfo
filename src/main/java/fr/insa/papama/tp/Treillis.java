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
    private ArrayList<Barre> barres = new ArrayList();
    private ArrayList<Noeud> noeuds = new ArrayList();

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
    public Treillis() {
        this.barres = new ArrayList<>();
        this.noeuds = new ArrayList<>();
    }

    //Methodes    
    public static Treillis treilliTest() {
        Treillis res;
        res = new Treillis();
        NoeudAppuiDouble n1 = new NoeudAppuiDouble(0, 200, new Vecteur2D(0, 0), 1);
        NoeudSimple n2 = new NoeudSimple(100, 100, new Vecteur2D(0, -1000), 2);
        NoeudAppuiSimple n3 = new NoeudAppuiSimple(0, 0, new Vecteur2D(0, 0), 3, 0);
        Barre b1 = new Barre(0, n2, n3, 0, 0, 0);
        Barre b2 = new Barre(1, n2, n1, 0, 0, 0);
        Barre b3 = new Barre(2, n3, n1, 0, 0, 0);
        res.ajouteBarre(b1);
        res.ajouteBarre(b2);
        res.ajouteBarre(b3);
        res.ajouteNoeud(n1);
        res.ajouteNoeud(n2);
        res.ajouteNoeud(n3);
        return res;
    }

    public  int maxIdNoeud() {
        int max = 0;
        if (this.noeuds.size() != 0) {
            for (int i = 0; i < this.noeuds.size(); i++) {
                if (this.noeuds.get(i).getId() >= max) {
                    max = this.noeuds.get(i).getId();
                }
            }
        }
        return max;
    }

    public  int maxIdBarre() {
        int max = 0;
        if (this.barres.size() != 0) {
            for (int i = 0; i < this.barres.size(); i++) {
                if (this.barres.get(i).getId() >= max) {
                    max = this.barres.get(i).getId();
                }
            }
        }
        return max;
    }

    public void ajouteNoeud(Noeud n) {
        if (this.noeuds.size() == 0) {
            n.setId(1);
            this.noeuds.add(n);
        } else {
            int i = 0;
            while (i < this.noeuds.size() && this.noeuds.get(i) != n) {
                i++;
            }
            if (i != this.noeuds.size()) {
                throw new Error("Ce noeud est deja dans le treillis");
            } else {
                n.setId(this.maxIdNoeud() + 1);
                this.noeuds.add(n);
            }
        }
    }

    public  void ajouteBarre(Barre b) {
        int i = 0;
        if (this.barres.size() == 0) {
            b.setId(0);
            this.barres.add(b);
        } else {
            while ((this.barres.get(i) != b) && (i < this.barres.size() - 1)) {
                i++;
            }
            if (i != this.barres.size() - 1) {
                throw new Error("Cette barre est deja dans le treillis");
            } else {
                b.setId(this.maxIdBarre() + 1);
                this.barres.add(b);
            }
        }
    }

    public  ArrayList<Barre> barreCasse() {
        //Création de la matrice des equations
        // dimention inconnues horizontal nbr var et bertical nbrvar+1
        int nombreequation;
        nombreequation = this.barres.size();
        for (int i = 0; i < this.noeuds.size(); i++) {
            nombreequation = nombreequation + this.noeuds.get(i).nbrInconnues();
        }

        double[][] Equation;
        Equation = new double[this.noeuds.size() * 2][nombreequation];
        for (int i = 0; i < this.noeuds.size() * 2; i++) {
            for (int j = 0; j < nombreequation; j++) {
                Equation[i][j] = 0;
            }
        }

        //Creation d'une liste contenant les inconnues
        ArrayList<String> Inconnues = new ArrayList();
        for (int j = 0; j < this.barres.size(); j++) {
            Inconnues.add("T" + j);
        }
        for (int y = 0; y < this.noeuds.size(); y++) {
            if (this.noeuds.get(y) instanceof NoeudSimple == false) {
                if (this.noeuds.get(y) instanceof NoeudAppuiSimple == true) {
                    Inconnues.add("R" + y);

                } else {
                    Inconnues.add("R" + y + "x");
                    Inconnues.add("R" + y + "y");
                }
            }
        }

        //Afficher les inconnues
        for (int i = 0; i < Inconnues.size(); i++) {
            System.out.print(Inconnues.get(i)+" ");
        }
        System.out.println(" ");

        //Creation de la matrice à résoudre A et du vecteur colonne B dans AX=B
        //Remplissage Réactions
        double[] B=new double[this.noeuds.size() * 2];
        int lig = 0;
        for (int i = 0; i < this.noeuds.size(); i++) {
            Noeud n = this.noeuds.get(i);
            if (n instanceof NoeudSimple) {
            } else {
                if (n instanceof NoeudAppuiDouble) {
                    int num = this.numVar(Inconnues, n);
                    Equation[lig][num] = 1;
                    Equation[lig + 1][num + 1] = 1;
                } else {
                    int num = this.numVar(Inconnues, n);
                    //TODO résoudre problème
                    NoeudAppuiSimple ns = (NoeudAppuiSimple) n;
                    double angle=ns.getNormale();
                    Equation[lig][num] = cos(angle);
                    Equation[lig + 1][num] = sin(angle);
                }
            }
            //Equation selon x pour les tensions dans les barres
            for (int j = 0; j < n.barresIncidentes().size(); j++) {
                Barre b = n.barresIncidentes().get(j);
                double angle = b.Angle(n);
                int col = this.numVar(Inconnues, b);
                Equation[lig][col] = cos(angle);
                B[lig] = n.getF().getVx();
            }
            lig++;
            //Equation selon y pour les tensions dans les barres
            for (int j = 0; j < n.barresIncidentes().size(); j++) {
                Barre b = n.barresIncidentes().get(j);
                double angle = b.Angle(n);
                int col = this.numVar(Inconnues, b);
                Equation[lig][col] = sin(angle);
                B[lig] = n.getF().getVy();

            }
            lig++;
        }
        System.out.println(" ");
        for (int i = 0; i < nombreequation; i++) {
            for (int j = 0; j < nombreequation; j++) {
                System.out.print(Equation[i][j] + " | ");
            }
            System.out.println(" ");
        }
        for (int j = 0; j < nombreequation; j++) {
                System.out.print(B[j] + " | ");
        }
        //Resolution de la matrice
        if (this.noeuds.size() * 2 != nombreequation){
              throw new Error("Le système n'est pas soluble");
        }
//        Determinant d= new Determinant(Equation,Equation.length);
//        double[][]inverse=transpose(d.inverse(Equation));
//        double[][] inverse=inverse(Equation);
        double[] v=new double[nombreequation];
        for(int k=0;k<nombreequation;k++){
            for(int l=0;l<nombreequation;l++){
//                System.out.print(inverse[k][l]+"   ");
            }
            System.out.print(" ");
        }
        for(int k=0;k<nombreequation;k++){
            for(int l=0;l<nombreequation;l++){
//                v[k]=v[k]+inverse[k][l]*B[k];
            }
        }

        double[][]produit=new double[nombreequation][nombreequation];
        for(int i=0; i<nombreequation; i++){
            for(int j=0; j<nombreequation; j++){ 
            produit[i][j] = 0;    
                for(int k=0; k<2 ;k++) {   
//                    produit[i][j] += Equation[i][k] * inverse[k][j];    
                }
//            System.out.print(produit[i][j]+" "); 
            }
            System.out.println();
        }  
        
        for (int in = 0; in < v.length; in++) {
            System.out.println(Inconnues.get(in)+" "+v[in]);
        }
        //TODO gérer si c'est une compression ou une traction
        //Trouver les barres qui risquent de casser
        ArrayList<Barre> fragile = new ArrayList();
        for (int k = 0; k < this.barres.size(); k++) {
            if (v[k] > this.barres.get(k).getCompressionMax()) {
                fragile.add(this.barres.get(k));
            }
        }
        return fragile;
    }

    public int numVar(ArrayList<String> inconnues, Barre b) {
        int pos = this.barres.indexOf(b);
        int i = 0;
        while (i < inconnues.size() && !inconnues.get(i).equals("T" + pos)) {
            i++;
        }
        if (i == inconnues.size() - 1) {
            throw new Error("Il n'y a pas d'inconnues suivant cette barre");
        } else {
            return i;
        }
    }

    public int numVar(ArrayList<String> inconnues, Noeud n) {
        int pos = this.noeuds.indexOf(n);
        int i = 0;
        while (i < inconnues.size() && !inconnues.get(i).contains("R" + pos)) {
            i++;
        }
        if (i == inconnues.size()) {
            throw new Error("Il n'y a pas d'inconnues suivant cette barre");
        } else {
            return i;
        }
    }
    public static double[][] transpose (double[][] m){
        double[][] transpose=new double[m.length][m[1].length];
        for(int i=0;i<3;i++){    
            for(int j=0;j<3;j++){    
                transpose[i][j]=m[j][i];  
            }    
        } 
        return transpose;
    }
//    public static double[][] inverse(double[][] arg0) {
//   //     Matrix mat = new Matrix(arg0);
//    return mat.inverse().getArray();
//    }

    
}

