/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.papama.tp;
import java.util.Scanner;
/**
 *
 * @author GWENDOLINE
 */
//    
//    //Resoudre le système linéaire
//    public static double[] ResoudreSysLin (double[][] m){
//        int n=m.length;
//        
//        double[] res=new double[m[m.length-1].length];
//        double inversem[][]=inverser(m);
//         System.out.println("n= "+n);
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                System.out.println("i= "+i);
//                System.out.println("j= "+j);
//                res[i]=res[i]+inversem[i][j]*m[j][m[m.length-1].length-1];
//            }
//        }
//        return res;
//    }
//    
//    public static double[][] inverser (double m[][]){
//        int n=m.length-1;
//        double x[][] =new double [n][n];
//        double id[][] =new double [n][n];
//        int index[]=new int[n];
//        for (int i=0;i<n;i++){
//            id[i][i]=1;
//        }
//        gauss(m,index);
//        //On applique les transformations à la matrice id
//        for(int i=0;i<n-1;i++){
//            for(int j=i+1;j<n;j++){
//                for(int k=0;k<n;k++){
//                    x[n-1][i]=id[index[j]][k]-=m[index[j]][i]*id[index[i]][k];
//                }
//            }
//        }
//        for(int i=0;i<n;i++){
//            x[n-1][i]=id[index[n-1]][i]/m[index[n-1]][n-1];
//            for(int j=n-2;j>=0;j--){
//                x[j][i]=id[index[j]][i];
//                for(int k=j+1;k<n;k++){
//                    x[j][i] -= m[index[j]][k]*x[k][i];
//                }
//                x[j][i] /= m[index[j]][j];
//            }
//        }
//        
//        return x;
//    }
//    
//    //Method to carry out the partial-pivoting gaussian elimination
//    //sauv[] stores pivoting order
//    public static void gauss(double m[][], int sauv[]){
//        int n = sauv.length;
//        double c[]= new double[n];
//        //on initialise le tableau sauv
//        for (int i=0;i<n;i++){
//            sauv[i]=i;
//        }
//        //trouver le coef de recalibrage
//        for(int i=0;i<n;i++){
//            double c1=0;
//            for(int j=0;j<n;j++){
//                double c0 = Math.abs(m[i][j]);
//                if(c0>c1){
//                    c1=c0;
//                }
//            }
//            c[i]=c1;
//        }
//        
//        //Trouver le pivot pour chaque colonne
//        int k =0;
//        for(int j=0;j<n-1;j++){
//            double pi1=0;
//            for(int i=j;i<n;i++){
//                double pi0=Math.abs(m[sauv[i]][j]);
//                pi0 = (pi0/c[sauv[i]]);
//                if(pi1>pi0){
//                    pi1=pi0;
//                    k=i;
//                }
//            }
//            //Echange les lignes selon pivoting order
//            int temp=sauv[j];
//            sauv[j]=sauv[k];
//            sauv[k]=temp;
//            for(int i=j+1;i<n;i++){
//                double pj = m[sauv[i]][j]/m[sauv[j]][j];
//                m[sauv[i]][j]=pj;
//                for (int l=j+1;l<n;l++){
//                    m[sauv[i]][j] -= pj*m[sauv[j]][l];
//                }
//                
//            }
//            
//            //Methodes permettant d'effectuer le pivot de gauss pour résoudre la matrice
//    static void permutation(int l1, double[][] a) {
//        int n = a[a.length - 1].length;
//        double aux;
//        int l2 = l1;
//        //Recherche des lignes à permuter
//        while (a[l2][l1] == 0.0) {
//            l2++;
//        }
//        for (int i = l1; i < n; i++) {
//            aux = a[l1][i];
//            a[l1][i] = a[l2][i];
//            a[l2][i] = aux;
//        }
//        aux = a[a.length - 1][l1];
//        a[a.length - 1][l1] = a[a.length - 1][l2];
//        a[a.length - 1][l2] = aux;
//    }
//
//    static void transformation(double[][] a) {
//        int n = a.length;
//        for (int i = 1; i < n; i++) {
//            if (a[i - 1][i - 1] == 0.0) {
//                permutation(i - 1, a);
//            }
//            for (int j = i; j < n; j++) {
//                double facteur = a[j][i - 1] / a[i - 1][i - 1];
//                for (int k = i - 1; k < n; k++) {
//                    a[j][k] = a[j][k] - a[i - 1][k] * facteur;
//                }
//                a[a.length - 1][j] = a[a.length - 1][j] - a[a.length - 1][i - 1] * facteur;
//            }
//        }
//    }
//
//    static double[] extraction(double[][] a) {
//        int n = a.length;
//        double[] v = new double[n];
//        v[n - 1] = a[a.length - 1][n - 1] / a[n - 1][n - 1];
//        for (int i = n - 2; i >= 0; i--) {
//            v[i] = a[a.length - 1][i];
//            for (int j = n - 1; j > i; j--) {
//                v[i] = v[i] - v[j] * a[i][j];
//            }
//            v[i] = v[i] / a[i][i];
//        }
//        return v;
//    }
//
//    static double[] resolution(double[][] a) {
//        transformation(a);
//        return extraction(a);
//    }
//
//    public static double[] resoudreMatrice(double[][] m) {
//        return resolution(m);
//    }

//            
//    }