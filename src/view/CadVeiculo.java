/*
 * Created by JFormDesigner on Mon Sep 02 20:17:53 AMT 2024
 */

package view;

import controller.VeiculoController;
import models.Veiculo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 * @author etech
 */
public class CadVeiculo extends JFrame {
    VeiculoController vc = new VeiculoController();

    public CadVeiculo() {
        initComponents();
    }

    private void preecherTabela(){
        String[] colunas = {"Marca", "Modelo", "Cor", "Ano"};

        DefaultTableModel mTable = new DefaultTableModel(colunas,0); //object

        for(Veiculo veiculo: vc.getListaVeiculo()){
            Object[] linha = {
                    veiculo.getMarca(),
                    veiculo.getModelo(),
                    veiculo.getCor(),
                    veiculo.getAno()
            };
            mTable.addRow(linha);
        }
        tableVeiculo.setModel(mTable);
    }

    private void limparCampos(){
        textModelo.setText("");
        textMarca.setText("");
        textCor.setText("");
        textAno.setText("");
    }

    private void salvar(ActionEvent e) {
        Veiculo veiculo = new Veiculo();
        veiculo.setModelo(textModelo.getText());
        veiculo.setMarca(textMarca.getText());
        veiculo.setCor(textCor.getText());
        try{
            int ano = Integer.parseInt(textAno.getText());
            veiculo.setAno(ano);
            vc.salvar(veiculo);
            limparCampos();
            preecherTabela();
            textModelo.requestFocusInWindow();

        } catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro de formato", JOptionPane.ERROR_MESSAGE);
        }



//        String modelo = textModelo.getText();
//        String marca = textMarca.getText();
//        String cor = textCor.getText();
//        String ano = textAno.getText();
//
//        // Adiciona os dados à tabela
//        DefaultTableModel model = (DefaultTableModel) tableVeiculo.getModel();
//        model.addRow(new Object[]{modelo, marca, cor, ano});
//
//        // Limpa os campos de texto após salvar
//        textModelo.setText("");
//        textMarca.setText("");
//        textCor.setText("");
//        textAno.setText("");
    }

    private void cancelar(ActionEvent e) {
        textModelo.setText("");
        textMarca.setText("");
        textCor.setText("");
        textAno.setText("");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        textModelo = new JTextField();
        textMarca = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        textCor = new JTextField();
        textAno = new JTextField();
        salvarButton = new JButton();
        cancelarButton = new JButton();
        scrollPane1 = new JScrollPane();
        tableVeiculo = new JTable();

        //======== this ========
        setPreferredSize(new Dimension(550, 450));
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBorder(LineBorder.createBlackLineBorder());
            panel1.setPreferredSize(new Dimension(400, 200));
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("Modelo");
            panel1.add(label1);
            label1.setBounds(20, 15, 80, label1.getPreferredSize().height);

            //---- label2 ----
            label2.setText("Marca");
            panel1.add(label2);
            label2.setBounds(new Rectangle(new Point(265, 15), label2.getPreferredSize()));
            panel1.add(textModelo);
            textModelo.setBounds(15, 40, 225, 30);
            panel1.add(textMarca);
            textMarca.setBounds(255, 40, 230, 30);

            //---- label3 ----
            label3.setText("Cor");
            panel1.add(label3);
            label3.setBounds(20, 80, 70, label3.getPreferredSize().height);

            //---- label4 ----
            label4.setText("Ano");
            panel1.add(label4);
            label4.setBounds(new Rectangle(new Point(265, 80), label4.getPreferredSize()));
            panel1.add(textCor);
            textCor.setBounds(15, 105, 220, 30);
            panel1.add(textAno);
            textAno.setBounds(255, 105, 230, 30);

            //---- salvarButton ----
            salvarButton.setText("Salvar");
            salvarButton.addActionListener(e -> salvar(e));
            panel1.add(salvarButton);
            salvarButton.setBounds(new Rectangle(new Point(305, 160), salvarButton.getPreferredSize()));

            //---- cancelarButton ----
            cancelarButton.setText("Cancelar");
            cancelarButton.addActionListener(e -> cancelar(e));
            panel1.add(cancelarButton);
            cancelarButton.setBounds(new Rectangle(new Point(390, 160), cancelarButton.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(10, 25, 500, 210);

        //======== scrollPane1 ========
        {

            //---- tableVeiculo ----
            tableVeiculo.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "Modelo", "Marca", "Cor", "Ano"
                }
            ));
            scrollPane1.setViewportView(tableVeiculo);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(10, 245, 500, 155);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JTextField textModelo;
    private JTextField textMarca;
    private JLabel label3;
    private JLabel label4;
    private JTextField textCor;
    private JTextField textAno;
    private JButton salvarButton;
    private JButton cancelarButton;
    private JScrollPane scrollPane1;
    private JTable tableVeiculo;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
