/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetobanco;

import java.io.IOException;
import java.text.ParseException;

/**
 *
 * @author Arthur
 */
public class Telas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ParseException {

        tOpcoes t = new tOpcoes();
        t.definirMaterias();

    }
    
}

//Se o Daniel sair ficamos sem professor (hipoteticamente)
//Visualizado por Davyd Sloan às 01:35