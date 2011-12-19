/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdaptSettingsDialog.java
 *
 * Created on 19.12.2011, 08:18:30
 */
package com.t_oster.visicut.gui;

import com.t_oster.visicut.gui.beans.EditableTablePanel;
import com.t_oster.visicut.gui.beans.EditableTableProvider;
import com.t_oster.visicut.model.LaserProfile;
import com.t_oster.visicut.model.MaterialProfile;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author thommy
 */
public class AdaptSettingsDialog extends javax.swing.JDialog
{

  private List<EditableTablePanel> panels = new LinkedList<EditableTablePanel>();
  private MaterialProfile mp;
  
  /** Creates new form AdaptSettingsDialog */
  public AdaptSettingsDialog(java.awt.Frame parent, boolean modal)
  {
    super(parent, modal);
    initComponents();
  }
  
  /**
   * Loads the given MaterialProfile into the Window.
   * All changes to the window occur instantly to this
   * MaterialProfile
   * @param mp 
   */
  public void setMaterialProfile(MaterialProfile mp)
  {
    this.mp = mp;
    this.panels.clear();
    this.jTabbedPane1.removeAll();
    if (mp != null)
    {
      for (LaserProfile lp : mp.getLaserProfiles())
      {
        EditableTablePanel panel = new EditableTablePanel();
        panel.setProvider(new EditableTableProvider()
        {

          public Object getNewInstance()
          {
            throw new UnsupportedOperationException("Not supported yet.");
          }

          public Object editObject(Object o)
          {
            throw new UnsupportedOperationException("Not supported yet.");
          }
          
        });
        this.jTabbedPane1.add(lp.getName(), panel);
      }
    }
  }
  
  /**
   * Returns the MaterialProfile provided by setMaterialProfile.
   * IF Cancel was pressed, it is set to null
   * @return 
   */
  public MaterialProfile getMaterialProfile()
  {
    return this.mp;
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        editableTablePanel1 = new com.t_oster.visicut.gui.beans.EditableTablePanel();
        btOK = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        jTabbedPane1.setName("jTabbedPane1"); // NOI18N

        editableTablePanel1.setName("editableTablePanel1"); // NOI18N
        jTabbedPane1.addTab("tab2", editableTablePanel1);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.t_oster.visicut.gui.VisicutApp.class).getContext().getResourceMap(AdaptSettingsDialog.class);
        btOK.setText(resourceMap.getString("btOK.text")); // NOI18N
        btOK.setName("btOK"); // NOI18N
        btOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOKActionPerformed(evt);
            }
        });

        btCancel.setText(resourceMap.getString("btCancel.text")); // NOI18N
        btCancel.setName("btCancel"); // NOI18N
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(280, Short.MAX_VALUE)
                .addComponent(btCancel)
                .addGap(18, 18, 18)
                .addComponent(btOK)
                .addContainerGap())
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btOK)
                    .addComponent(btCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void btOKActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btOKActionPerformed
  {//GEN-HEADEREND:event_btOKActionPerformed
    this.setVisible(false);
  }//GEN-LAST:event_btOKActionPerformed

  private void btCancelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btCancelActionPerformed
  {//GEN-HEADEREND:event_btCancelActionPerformed
    this.mp = null;
    this.setVisible(false);
  }//GEN-LAST:event_btCancelActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[])
  {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try
    {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
      {
        if ("Nimbus".equals(info.getName()))
        {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    }
    catch (ClassNotFoundException ex)
    {
      java.util.logging.Logger.getLogger(AdaptSettingsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (InstantiationException ex)
    {
      java.util.logging.Logger.getLogger(AdaptSettingsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (IllegalAccessException ex)
    {
      java.util.logging.Logger.getLogger(AdaptSettingsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (javax.swing.UnsupportedLookAndFeelException ex)
    {
      java.util.logging.Logger.getLogger(AdaptSettingsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the dialog */
    java.awt.EventQueue.invokeLater(new Runnable()
    {

      public void run()
      {
        AdaptSettingsDialog dialog = new AdaptSettingsDialog(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter()
        {

          @Override
          public void windowClosing(java.awt.event.WindowEvent e)
          {
            System.exit(0);
          }
        });
        dialog.setVisible(true);
      }
    });
  }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btOK;
    private com.t_oster.visicut.gui.beans.EditableTablePanel editableTablePanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
