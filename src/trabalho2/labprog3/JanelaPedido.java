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
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Marcus
 */
class JanelaPedido extends  JFrame{
    private List<Item> itens;
    private final JList<Item> lstItem = new JList<Item>(new DefaultListModel<Item>());
    private final JButton salva = new JButton("Salva");
    private final JButton exclui = new JButton("Exclui");
    private final JLabel lblNome = new JLabel("Nome");
    private final JLabel lblQuantidade = new JLabel("Quantidade");
    private final JLabel lblPreco = new JLabel("Preço");
    private final JTextField nome = new JTextField();
    private final JTextField preco = new JTextField();
    private final JTextField quantidade = new JTextField();
    private JanelaMesas janelaMesa;
    public JanelaPedido(List<Item> itens, JanelaMesas janelaMesa) throws HeadlessException {
        super("Detalhes Pedido");
        this.itens= itens;
        setResizable(false);
        setSize(300,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JPanel caixas = new JPanel(new GridLayout(6,1));
        JPanel cima = new JPanel(new GridLayout(1,2));
        JPanel baixo = new JPanel(new GridLayout(1,2));
        JPanel tudo = new JPanel(new GridLayout(2,1));
        setJanelaMesa(janelaMesa);
        caixas.add(lblNome);
        caixas.add(nome);
        caixas.add(lblPreco);
        caixas.add(preco);
        caixas.add(lblQuantidade);
        caixas.add(quantidade);
        cima.add(new JScrollPane(lstItem));
        cima.add(caixas);
        baixo.add(salva);
        baixo.add(exclui);
        tudo.add(cima);
        tudo.add(baixo);
        lstItem.setModel(new ItensListModel(itens));
        add(tudo);
        setVisible(true);
        
        lstItem.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Item selecionado = lstItem.getSelectedValue();
                if(selecionado!=null){
                    String quant = "" + selecionado.getQuantidade();
                    String valor = "" + selecionado.getPreco();
                    quantidade.setText(quant);
                    nome.setText(selecionado.getNome());
                    preco.setText(valor);
                }
            }
        });
        salva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item selecionado = lstItem.getSelectedValue();
                if(selecionado!=null){
                    if(nome.getText().trim().equals("") || quantidade.getText().trim().equals("") || preco.getText().trim().equals("")){
                        JOptionPane.showMessageDialog(null, "Digite valores para Nome e Quantidade");
                    }else{
                        int i = itens.indexOf(selecionado);
                        itens.get(i).setNome(nome.getText());
                        itens.get(i).setQuantidade(Integer.parseInt(quantidade.getText()));
                        itens.get(i).setPreco(Double.parseDouble(preco.getText()));
                        janelaMesa.getLstItens().setText(janelaMesa.getLstPedidos().getSelectedValue().imprimeItens());
                        lstItem.updateUI();
                        lstItem.clearSelection();
                    }
                    
                }else{
                    if(nome.getText().trim().equals("") || quantidade.getText().trim().equals("") || preco.getText().trim().equals("")){
                        JOptionPane.showMessageDialog(null, "Digite valores para Nome e Quantidade");
                    }else{
                        itens.add(new Item(nome.getText(), Integer.parseInt(quantidade.getText()),Double.parseDouble(preco.getText())));
                        janelaMesa.getLstItens().setText(janelaMesa.getLstPedidos().getSelectedValue().imprimeItens());
                        lstItem.updateUI();
                        lstItem.clearSelection();
                        nome.setText("");
                        quantidade.setText("");
                        preco.setText("");
                        
                    }
                }
            }
        });
        exclui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item selecionado = lstItem.getSelectedValue();
                if(selecionado!= null){
                    itens.remove(selecionado);
                    lstItem.updateUI();
                    lstItem.clearSelection();
                    nome.setText("");
                    quantidade.setText("");
                    janelaMesa.getLstItens().setText(janelaMesa.getLstPedidos().getSelectedValue().imprimeItens());
                }else{
                    JOptionPane.showMessageDialog(null,"Selecione um item para excluir");
                }
            }
        });
        
    }

    /**
     * @param janelaMesa the janelaMesa to set
     */
    public void setJanelaMesa(JanelaMesas janelaMesa) {
        this.janelaMesa = janelaMesa;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
    
}
