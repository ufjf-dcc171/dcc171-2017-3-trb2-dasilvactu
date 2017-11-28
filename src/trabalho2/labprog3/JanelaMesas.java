/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2.labprog3;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.Date;
/**
 *
 * @author Marcus
 */
class JanelaMesas extends JFrame{
    private final List<Mesa> mesas;
    private final JButton criaMesa = new JButton("Cria Mesa");
    private final JButton addItem = new JButton("Adiciona Item");
    private final JButton criaPedido = new JButton("Cria Pedido");
    private final JButton fechaPedido = new JButton("Fecha Pedido");
    private final JButton editaPedido = new JButton("Edita Pedido");
    private final JList<Mesa> lstMesas = new JList<Mesa>(new DefaultListModel<Mesa>());
    private JList<Pedido> lstPedidos = new JList<Pedido>(new DefaultListModel<Pedido>());
    private JTextArea lstItens = new JTextArea(10,50 );
    private JanelaPedido janelaPedido;
    public JanelaMesas(List<Mesa> sampleData) throws HeadlessException {
        super("Lanchonete");
        lstItens.setEditable(false);
        this.mesas = sampleData;
        JPanel componentes = new JPanel(new GridLayout(2,1));
        JPanel listaBotoes = new JPanel(new GridLayout(1,3));
        JPanel botoes = new JPanel(new GridLayout(5,1));
        botoes.add(criaMesa);
        botoes.add(criaPedido);
        botoes.add(addItem);
        botoes.add(editaPedido);
        botoes.add(fechaPedido);
        listaBotoes.add(new JScrollPane(lstMesas));
        listaBotoes.add(new JScrollPane(lstPedidos));
        listaBotoes.add(botoes);
        componentes.add(listaBotoes);
        componentes.add(lstItens);
        add(componentes);
//        add(new JScrollPane(lstMesas),BorderLayout.WEST);
//        add(new JScrollPane(lstPedidos),BorderLayout.CENTER);
//        add(lstItens, BorderLayout.SOUTH);
        lstMesas.setModel(new MesasListModel(mesas));
        
        lstMesas.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                getLstItens().setText("");
                Mesa selecionada = lstMesas.getSelectedValue();
                if(selecionada!= null){
                    System.out.println(selecionada);
                    getLstPedidos().setModel(new PedidosListModel(selecionada.getPedidos()));
                }else{
                    getLstPedidos().setModel(new DefaultListModel<>());
                }
            }
        });
        criaMesa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mesa = JOptionPane.showInputDialog("Digite o número da Mesa");
                if(mesa != null){
                    Mesa m1 = new Mesa(Integer.parseInt(mesa));
                    mesas.add(m1);
                    lstMesas.updateUI();
                }
            }
        });
        lstPedidos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Pedido selecionado = getLstPedidos().getSelectedValue();
                if(selecionado!=null){
                    getLstItens().setText(selecionado.imprimeItens());
                }
            }
        });
        fechaPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pedido selecionado = getLstPedidos().getSelectedValue();
                if(selecionado!=null){
                    if(selecionado.isStatus()){
                        getLstPedidos().getSelectedValue().calculaPreco();
                        getLstPedidos().getSelectedValue().setStatus(false);
                        getLstPedidos().getSelectedValue().setFim(new Date());
                        getLstPedidos().updateUI();
                        getLstItens().setText(selecionado.imprimeItens());
                    }
                 
                }
            }
        });
        editaPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lstMesas.getSelectedValue()!=null){
                    if(getLstPedidos().getSelectedValue()!=null){
                        if(getLstPedidos().getSelectedValue().isStatus()){
                            janelaPedido = new JanelaPedido(getLstPedidos().getSelectedValue().getItens(),JanelaMesas.this);
                        }else{
                            JOptionPane.showMessageDialog(null, "O pedido já está fechado, não é possível editar");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Selecione um pedido de uma Mesa");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Selecione uma Mesa");
                }
            }
        });
        criaPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lstMesas.getSelectedValue()!=null){
                    Mesa selecionada = lstMesas.getSelectedValue();
                    mesas.get(mesas.indexOf(selecionada)).getPedidos().add(new Pedido(selecionada.getPedidos().size()+1,new Date()));
                    lstPedidos.updateUI();
                    int ultimo = selecionada.getPedidos().size()-1;
                    lstPedidos.setSelectedIndex(ultimo);
                    janelaPedido = new JanelaPedido(selecionada.getPedidos().get(ultimo).getItens(),JanelaMesas.this);
                }else{
                    JOptionPane.showMessageDialog(null, "Selecione uma Mesa");
                }
            }
        });
        addItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lstMesas.getSelectedValue()!=null){
                    if(getLstPedidos().getSelectedValue()!=null){
                        if(getLstPedidos().getSelectedValue().isStatus()){
                            janelaPedido = new JanelaPedido(getLstPedidos().getSelectedValue().getItens(),JanelaMesas.this);
                        }else{
                            JOptionPane.showMessageDialog(null, "O pedido já está fechado, não é possível editar");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Selecione um pedido de uma Mesa");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Selecione uma Mesa");
                }
            }
        });
    }

    public JTextArea getLstItens() {
        return lstItens;
    }

    public void setLstItens(JTextArea lstItens) {
        this.lstItens = lstItens;
    }

    public JList<Pedido> getLstPedidos() {
        return lstPedidos;
    }

    public void setLstPedidos(JList<Pedido> lstPedidos) {
        this.lstPedidos = lstPedidos;
    }
    
}
