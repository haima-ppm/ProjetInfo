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
public class NoeudAppuiDouble extends NoeudAppui {
    
        public NoeudAppuiDouble (double px, double py, Vecteur2D F, int id,ArrayList<Barre> barresDepart, ArrayList<Barre> barresArrivee){
        super(px,py,F,id,barresDepart,barresArrivee);
    }
    
      
        

    @Override
    public String toString(){
        return ("NoeudAppuiDouble"+super.getId()+" = ("+super.getPx()+";"+super.getPy()+"), " +super.getF()); 
    }
    
}
