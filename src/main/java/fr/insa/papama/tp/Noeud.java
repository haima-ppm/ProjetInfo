/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.papama.tp;

/**
 *
 * @author Haimavati
 */
public abstract class Noeud {
    
    //Attributs 
    private int id; 
    private double px, py; 
    private Vecteur2D F; 
    
    // Encapsulation 
    public double getPx(){
        return px; 
    }
        
    public void setPx() {
        this.px=px; 
    }
    
    public double getPy() {
        return py;
    }
    
    public void setPy(){
        this.py=py; 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vecteur2D getF() {
        return F;
    }

    public void setF(Vecteur2D F) {
        this.F = F;
    }
    
    //Constructeur permettant de fixer les attributs 
    public Noeud(double px, double py, Vecteur2D F, int id){
        this.px=px; 
        this.py=py; 
        this.F=F; 
        this.id=id;
    }

    //Constructeur permettant de fixer uniquement la position et la force
    public Noeud(double px, double py, Vecteur2D F){
        this.px=px; 
        this.py=py; 
        this.F=F; 
        this.id=-1; 
    }
    
    //Constructeur permettant de fixer uniquement la position 
    public Noeud(double px, double py){
        this.px=px; 
        this.py=py;
        this.F= new Vecteur2D(0,0); 
        this.id=-1;
    }
    
    @Override
    public String toString(){
        return ("Noeud n°"+id+" = ("+px+";"+py+"), " + "force associée =>"+F); 
    }
    
//    Méthode permettant à l'utilisateur d'entrer les caractéristiques d'un noeud
    public static Noeud entreeNoeud () {
        double x,y;
        int id;
        id = -1; 
        Noeud n; 
        System.out.println("Indiquer le type du noeud à créer: noeud simple: 1 , noeud appui simple: 2 ou noeud appui double: 3");
        int type = Lire.i(); 
        if (type != 1 && type !=2 && type !=3) {
            throw new Error ("Vous avez mal entré le type du noeud désiré");
        }
        System.out.println("Entrez les coordonnées du noeud:");
        x=Lire.d();
        y=Lire.d();
        System.out.println("Entrez le vecteur force associé au noeud");
        double vx=Lire.d(); 
        double vy=Lire.d(); 
        Vecteur2D F = new Vecteur2D(vx,vy);  
        if (type == 2) {
            n = new NoeudAppuiSimple(x,y,F,id); 
        }
        else if (type == 3) {
            n = new NoeudAppuiDouble(x,y,F,id);
        }
        else {
             n = new NoeudSimple(x,y,F,id); 
        }
        return n;
        
    }
public static int nbrInconnues(Noeud n){
        if (n instanceof NoeudAppuiSimple){
            return 1;
        }else if (n instanceof NoeudAppuiDouble){
            return 2;
        }else
            return 0;
    }
    

}
