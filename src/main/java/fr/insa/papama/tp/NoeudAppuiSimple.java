/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.papama.tp;

import java.util.ArrayList;

/**
 *
 * @author Haimavati
 */
public class NoeudAppuiSimple extends NoeudAppui {
    double normale;
        
    public NoeudAppuiSimple(double px, double py, Vecteur2D F, int id, ArrayList<Barre> barresDepart, ArrayList<Barre> barresArrivee,double normale){
        super(px,py,F,id,barresDepart,barresArrivee);
        this.normale=normale;        
    }
    
    public double getNormale(){
        return normale; 
    }
        
    public void setNormale(double normale) {
        this.normale=normale; 
    }
        
   @Override 
   public String toString(){
       return ("NoeudAppuisSimple"+super.getId()+" = ("+super.getPx()+";"+super.getPy()+"), " +super.getF()+"Angle de la normale"+this.normale); 
   }
   
    
}
