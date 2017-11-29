/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2.labprog3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.JFrame;

/**
 *
 * @author Marcus
 */
public class Trabalho2LabProg3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException {
        Persistencia p = new Persistencia();
        JanelaMesas janela = new JanelaMesas(p.lerArquivo(),p);
        janela.setSize(800,500);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }
}
