/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projet_treillis;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 *
 * @author aousseni01
 */
public class VBoxExemple extends VBox {
    public VBoxExemple() {
        for(Button b : CompoTestSets.BoutonsV()) {
        this.getChildren().add(b);
        }
    }
}
