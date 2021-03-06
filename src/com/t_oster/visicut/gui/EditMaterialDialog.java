/**
 * This file is part of VisiCut.
 * Copyright (C) 2011 Thomas Oster <thomas.oster@rwth-aachen.de>
 * RWTH Aachen University - 52062 Aachen, Germany
 * 
 *     VisiCut is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *    VisiCut is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 * 
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with VisiCut.  If not, see <http://www.gnu.org/licenses/>.
 **/

/*
 * EditMaterialDialog.java
 *
 * Created on 06.09.2011, 00:43:54
 */
package com.t_oster.visicut.gui;

import com.t_oster.visicut.gui.beans.EditableTableProvider;
import com.t_oster.visicut.model.MaterialProfile;
import com.t_oster.visicut.model.RasterProfile;
import com.t_oster.visicut.model.Raster3dProfile;
import com.t_oster.visicut.model.VectorProfile;
import java.io.File;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Thomas Oster <thomas.oster@rwth-aachen.de>
 */
public class EditMaterialDialog extends javax.swing.JDialog implements EditableTableProvider {

  protected File defaultDirectory = null;

  /**
   * Get the value of defaultDirectory
   *
   * @return the value of defaultDirectory
   */
  public File getDefaultDirectory()
  {
    return defaultDirectory;
  }

  /**
   * Set the value of defaultDirectory for finding the Thumbnail
   *
   * @param defaultDirectory new value of defaultDirectory
   */
  public void setDefaultDirectory(File defaultDirectory)
  {
    this.defaultDirectory = defaultDirectory;
    if (defaultDirectory != null)
    {
      this.selectThumbnailButton1.setDefaultDirectory(defaultDirectory);
    }
  }

    protected MaterialProfile material = null;
    public static final String PROP_MATERIAL = "material";

    /**
     * Get the value of material
     *
     * @return the value of material
     */
    public MaterialProfile getMaterial() {
        return material;
    }

    /**
     * Set the value of material
     *
     * @param material new value of material
     */
    public void setMaterial(MaterialProfile material) {
        MaterialProfile oldMaterial = this.material;
        this.material = material;
        firePropertyChange(PROP_MATERIAL, oldMaterial, material);
        if (material == null) {
            this.setCurrentMaterial(new MaterialProfile());
        } else {
            this.setCurrentMaterial(material.clone());
        }
    }
    protected MaterialProfile currentMaterial = new MaterialProfile();
    public static final String PROP_CURRENTMATERIAL = "currentMaterial";

    /**
     * Get the value of currentMaterial
     *
     * @return the value of currentMaterial
     */
    public MaterialProfile getCurrentMaterial() {
        return currentMaterial;
    }

    /**
     * Set the value of currentMaterial
     *
     * @param currentMaterial new value of currentMaterial
     */
    public void setCurrentMaterial(MaterialProfile currentMaterial) {
        MaterialProfile oldCurrentMaterial = this.currentMaterial;
        this.currentMaterial = currentMaterial;
        firePropertyChange(PROP_CURRENTMATERIAL, oldCurrentMaterial, currentMaterial);
        //Bug: Beansbinding does not work properly, so we set it manually
        this.editableTablePanel1.setObjects((List) currentMaterial.getLaserProfiles());
    }

    /** Creates new form EditMaterialDialog */
    public EditMaterialDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

    jTextField1 = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jTextField2 = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    jTextField4 = new javax.swing.JTextField();
    jLabel5 = new javax.swing.JLabel();
    jButton3 = new javax.swing.JButton();
    jButton4 = new javax.swing.JButton();
    jLabel6 = new javax.swing.JLabel();
    jTextField5 = new javax.swing.JTextField();
    jTextField6 = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    selectThumbnailButton1 = new com.t_oster.visicut.gui.beans.SelectThumbnailButton();
    chooseColorButton1 = new com.t_oster.visicut.gui.beans.ChooseColorButton();
    editableTablePanel1 = new com.t_oster.visicut.gui.beans.EditableTablePanel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setName("Form"); // NOI18N

    jTextField1.setName("jTextField1"); // NOI18N

    org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentMaterial.name}"), jTextField1, org.jdesktop.beansbinding.BeanProperty.create("text"), "name");
    bindingGroup.addBinding(binding);

    org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.t_oster.visicut.gui.VisicutApp.class).getContext().getResourceMap(EditMaterialDialog.class);
    jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
    jLabel1.setName("jLabel1"); // NOI18N

    jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
    jLabel2.setName("jLabel2"); // NOI18N

    jTextField2.setName("jTextField2"); // NOI18N

    binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentMaterial.description}"), jTextField2, org.jdesktop.beansbinding.BeanProperty.create("text"), "Description");
    bindingGroup.addBinding(binding);

    jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
    jLabel4.setName("jLabel4"); // NOI18N

    jTextField4.setName("jTextField4"); // NOI18N

    binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentMaterial.depth}"), jTextField4, org.jdesktop.beansbinding.BeanProperty.create("text"));
    bindingGroup.addBinding(binding);

    jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
    jLabel5.setName("jLabel5"); // NOI18N

    jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
    jButton3.setName("jButton3"); // NOI18N
    jButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton3ActionPerformed(evt);
      }
    });

    jButton4.setText(resourceMap.getString("jButton4.text")); // NOI18N
    jButton4.setName("jButton4"); // NOI18N
    jButton4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton4ActionPerformed(evt);
      }
    });

    jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
    jLabel6.setName("jLabel6"); // NOI18N

    jTextField5.setName("jTextField5"); // NOI18N

    binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentMaterial.width}"), jTextField5, org.jdesktop.beansbinding.BeanProperty.create("text"), "width");
    bindingGroup.addBinding(binding);

    jTextField6.setName("jTextField6"); // NOI18N

    binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentMaterial.height}"), jTextField6, org.jdesktop.beansbinding.BeanProperty.create("text"), "Height");
    bindingGroup.addBinding(binding);

    jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
    jLabel3.setName("jLabel3"); // NOI18N

    selectThumbnailButton1.setName("selectThumbnailButton1"); // NOI18N

    binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentMaterial.thumbnailPath}"), selectThumbnailButton1, org.jdesktop.beansbinding.BeanProperty.create("thumbnailPath"), "thumbnailbt");
    bindingGroup.addBinding(binding);

    chooseColorButton1.setText(resourceMap.getString("chooseColorButton1.text")); // NOI18N
    chooseColorButton1.setName("chooseColorButton1"); // NOI18N

    binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentMaterial.color}"), chooseColorButton1, org.jdesktop.beansbinding.BeanProperty.create("selectedColor"), "selectedColor");
    bindingGroup.addBinding(binding);

    editableTablePanel1.setName("editableTablePanel1"); // NOI18N
    editableTablePanel1.setProvider(this);

    binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentMaterial.laserProfiles}"), editableTablePanel1, org.jdesktop.beansbinding.BeanProperty.create("objects"), "Laser Profiles to Table Model");
    bindingGroup.addBinding(binding);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(editableTablePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel2)
              .addComponent(jLabel4)
              .addComponent(jLabel6)
              .addComponent(jLabel3)
              .addComponent(selectThumbnailButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(29, 29, 29)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel1)
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                  .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(chooseColorButton1, 0, 0, Short.MAX_VALUE))
                  .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)))
              .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
              .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(jButton4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton3)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(selectThumbnailButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel6))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel4)
          .addComponent(jLabel5)
          .addComponent(chooseColorButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(20, 20, 20)
        .addComponent(jLabel3)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(editableTablePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jButton3)
          .addComponent(jButton4))
        .addContainerGap())
    );

    bindingGroup.bind();

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
  {//GEN-HEADEREND:event_jButton3ActionPerformed
      this.setMaterial(this.getCurrentMaterial());
      this.setVisible(false);
  }//GEN-LAST:event_jButton3ActionPerformed

  private void jButton4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton4ActionPerformed
  {//GEN-HEADEREND:event_jButton4ActionPerformed
      this.setMaterial(null);
      this.setVisible(false);
  }//GEN-LAST:event_jButton4ActionPerformed
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private com.t_oster.visicut.gui.beans.ChooseColorButton chooseColorButton1;
  private com.t_oster.visicut.gui.beans.EditableTablePanel editableTablePanel1;
  private javax.swing.JButton jButton3;
  private javax.swing.JButton jButton4;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JTextField jTextField1;
  private javax.swing.JTextField jTextField2;
  private javax.swing.JTextField jTextField4;
  private javax.swing.JTextField jTextField5;
  private javax.swing.JTextField jTextField6;
  private com.t_oster.visicut.gui.beans.SelectThumbnailButton selectThumbnailButton1;
  private org.jdesktop.beansbinding.BindingGroup bindingGroup;
  // End of variables declaration//GEN-END:variables

    public Object getNewInstance() {
        JComboBox choose = new JComboBox();
        choose.addItem("Line Profile");
        choose.addItem("Raster Profile");
        choose.addItem("Raster3d Profile");
        if (JOptionPane.showConfirmDialog(this, choose, "Which kind of Profile?", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            if (choose.getSelectedItem().equals("Line Profile")) {
                return new VectorProfile();
            } else if (choose.getSelectedItem().equals("Raster Profile")) {
                return new RasterProfile();
            } else if (choose.getSelectedItem().equals("Raster3d Profile")) {
                return new Raster3dProfile();
            }

        }
        return null;
    }

    public Object editObject(Object selected) {
        if (selected instanceof VectorProfile) {
            EditVectorProfileDialog d = new EditVectorProfileDialog(null, true);
            d.setVectorProfile((VectorProfile) selected);
            d.setDefaultDirectory(defaultDirectory);
            d.setVisible(true);
            return d.getVectorProfile();
        } else if (selected instanceof RasterProfile) {
            EditRasterProfileDialog d = new EditRasterProfileDialog(null, true);
            d.setRasterProfile((RasterProfile) selected);
            d.setDefaultDirectory(defaultDirectory);
            d.setVisible(true);
            return d.getRasterProfile();
        } else if (selected instanceof Raster3dProfile) {
            EditRaster3dProfileDialog d = new EditRaster3dProfileDialog(null, true);
            d.setRasterProfile((Raster3dProfile) selected);
            d.setDefaultDirectory(defaultDirectory);
            d.setVisible(true);
            return d.getRasterProfile();
        }

        return null;
    }
}
