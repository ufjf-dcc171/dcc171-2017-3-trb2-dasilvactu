/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.labprog3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Marcus
 */
public class Trabalho1LabProg3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JanelaMesas janela = new JanelaMesas(getSampleData());
        janela.setSize(800,500);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }
    private static List<Mesa> getSampleData() {
        // TODO code application logic here
        Item i1 = new Item("X-burguer",1,2.00);
        Item i2 = new Item("Hamburguer",2,3.00);
        Item i3 = new Item("Refrigerante",2,4.00);
        
        Pedido p1 = new Pedido(1, new Date());
        p1.getItens().add(i1);
        p1.getItens().add(i3);
        
        Pedido p2 = new Pedido(1, new Date());
        
        p2.getItens().add(i2);
        p2.getItens().add(i3);
        
        Mesa m1 = new Mesa(1);
        Mesa m2 = new Mesa(2);
        
        m1.getPedidos().add(p2);
        m2.getPedidos().add(p1);
        
        List<Mesa> mesas = new ArrayList<>();
        mesas.add(m1);
        mesas.add(m2);
        return mesas;
    }
}
