/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2.labprog3;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Marcus
 */
public class PedidosListModel implements ListModel<Pedido> {
    private final List<Pedido> pedidos;
    private final List<ListDataListener> dataListeners;
    public PedidosListModel(List<Pedido> pedidos) {
        this.pedidos = pedidos;
        this.dataListeners = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return pedidos.size();
    }

    @Override
    public Pedido getElementAt(int index) {
        return pedidos.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        this.dataListeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        this.dataListeners.remove(l);
    }
    
}
