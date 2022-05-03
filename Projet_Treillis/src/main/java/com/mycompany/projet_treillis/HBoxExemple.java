/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projet_treillis;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 *
 * @author aousseni01
 */
public class HBoxExemple extends HBox {
    public HBoxExemple() {
        for(Button b : CompoTestSets.BoutonsH()) {
        this.getChildren().add(b);
        }
    }
}
