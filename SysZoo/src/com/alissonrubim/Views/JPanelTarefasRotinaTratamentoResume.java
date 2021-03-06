/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alissonrubim.Views;

import com.alissonrubim.Models.DAO.RotinaTratamentoDAO;
import com.alissonrubim.Models.RotinaTratamento;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Reny Correia
 */
public class JPanelTarefasRotinaTratamentoResume extends javax.swing.JPanel {

    /**
     * Creates new form JPanelTarefasRotinaTratamentoResume
     */
    public JPanelTarefasRotinaTratamentoResume() {
        initComponents();
    }
/********************************* IMPLEMENTS *******************************************/
    private Frame parent;
    private RotinaTratamento rotina;
    
    public ArrayList<RotinaTratamento> getList(){
        return list;
    }
    
    private RotinaTratamento getSelected(){
        if(jTableResume.getSelectedRowCount() > 0){
            return list.get(jTableResume.getSelectedRows()[0]);
        }
        return null;
    }
    
    private void openAdd(){
        /*JDialogRotinaTratamentoDetail form = new JDialogRotinaTratamentoDetail();
        form.setVisible(true);
        RotinaTratamento rm = form.getCurrent();
        if(rm != null)
            list.add(rm);
        loadTable(false);*/
    }
    
    private void executeDelete(){
        RotinaTratamento e = getSelected();
        if(e != null){
            if(JOptionPane.showConfirmDialog(this, "Tem certeza que deseja remover esta tarefa da rotina?", "Atenção", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                list.remove(e);
                loadTable(false);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Necessário selecionar uma rotina para remoção", "Atenção", JOptionPane.OK_OPTION);
        }
    }
    
    private ArrayList<RotinaTratamento> list = new ArrayList<>();
    private void loadTable(boolean getFromDatabase){
        DefaultTableModel model = (DefaultTableModel)jTableResume.getModel();
        while(model.getRowCount() > 0)
            model.removeRow(model.getRowCount() - 1);
        try {
            if(getFromDatabase){
                //list = new RotinaTratamentoDAO().getAll(this.rotina);
            }
            for(RotinaTratamento a : list)
            {                
                
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao carregar a lista de rotinas: " + ex.getMessage(), "Atenção", JOptionPane.OK_OPTION);
        }
    }
    /********************************* IMPLEMENTS *******************************************/
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAdd = new javax.swing.JButton();
        jButtonRemove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableResume = new javax.swing.JTable();

        jButtonAdd.setText("Adicionar");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonRemove.setText("Remover");
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });

        jTableResume.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tarefa", "Responsável"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableResume);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRemove)
                        .addGap(0, 357, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonRemove))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        openAdd();
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed
        executeDelete();
    }//GEN-LAST:event_jButtonRemoveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableResume;
    // End of variables declaration//GEN-END:variables
}
