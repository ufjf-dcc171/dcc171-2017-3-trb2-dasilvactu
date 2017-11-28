/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2.labprog3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcus
 */
public class Mesa {
    private int numero;
    private List<Pedido> pedidos;

    public Mesa() {
        pedidos = new ArrayList<>();
    }

    public Mesa(int numero) {
        this.numero = numero;
        this.pedidos = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "Mesa "+ this.getNumero(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
