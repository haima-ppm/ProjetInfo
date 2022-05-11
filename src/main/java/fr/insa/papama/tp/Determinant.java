/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.papama.tp;
import java.util.Scanner.*;
public class Determinant {
/**
 *
 * @author GWENDOLINE
 */
    double A[][];
    double m[][];
    int N;
    int start;
    int last;

    public Determinant (double A[][], int N){
            this.A = A;
            this.N = N;
    }

    public double[][] generateSubArray (double A[][], int N, int j1){
            m = new double[N-1][];
            for (int k=0; k<(N-1); k++)
                    m[k] = new double[N-1];

            for (int i=1; i<N; i++){
                  int j2=0;
                  for (int j=0; j<N; j++){
                      if(j == j1)
                            continue;
                      m[i-1][j2] = A[i][j];
                      j2++;
                  }
              }
            return m;
    }
    /*
     * Calculate determinant recursively
     */
    public double determinant(double A[][], int N){
        double res;

        // Trivial 1x1 matrix
        if (N == 1) res = A[0][0];
        // Trivial 2x2 matrix
        else if (N == 2) res = A[0][0]*A[1][1] - A[1][0]*A[0][1];
        // NxN matrix
        else{
            res=0;
            for (int j1=0; j1<N; j1++){
                 m = generateSubArray (A, N, j1);
                 res += Math.pow(-1.0, 1.0+j1+1.0) * A[0][j1] * determinant(m, N-1);
            }
        }
        return res;
    }
    public  double [][] inverse(double A[][]) {
    double [][] result = new double [A.length][A[0].length];
    for (int i = 0; i < result.length; i++) {
        for (int j = 0; j < result[0].length; j++) {
            result[j][i] = (int)(Math.pow(-1, i + j) * determinant(removeRowCol(i, j,A),removeRowCol(i, j,A).length));
            result[j][i]=result[j][i]*this.determinant(A, A.length);
        }
    }

    return result;
}

public static double [][] removeRowCol(int row, int col,double A[][]) {
    double [][] result = new double [A.length-1][A[0].length];

    int k = 0, l = 0;
    for (int i = 0; i < A.length; i++) {
        if (i == row) continue;
        for (int j = 0; j < A[0].length; j++) {
            if (j == col) continue;
            result[l][k] = A[i][j];

            k = (k + 1) % (A.length - 1);
            if (k == 0) l++;
        }
    }

    return result;
}
}
