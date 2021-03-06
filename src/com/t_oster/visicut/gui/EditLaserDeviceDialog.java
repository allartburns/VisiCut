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
 * EditLaserDeviceDialog.java
 *
 * Created on 06.09.2011, 22:04:06
 */
package com.t_oster.visicut.gui;

import com.t_oster.liblasercut.LaserCutter;
import com.t_oster.visicut.managers.PreferencesManager;
import com.t_oster.visicut.model.LaserDevice;
import com.t_oster.visicut.misc.Helper;
import java.io.File;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.FileDialog;

/**
 *
 * @author Thomas Oster <thomas.oster@rwth-aachen.de>
 */
public class EditLaserDeviceDialog extends javax.swing.JDialog
{

  /** Creates new form EditLaserDeviceDialog */
  public EditLaserDeviceDialog(java.awt.Frame parent, boolean modal)
  {
    super(parent, modal);
    initComponents();
    this.jComboBox1.removeAllItems();
    for (String s : PreferencesManager.getInstance().getPreferences().getAvailableLasercutterDrivers())
    {
      jComboBox1.addItem(s);
    }
    this.jTable1.setModel(new DefaultTableModel()
    {

      private String[] cols = new String[]
      {
        "Attribute", "Value"
      };

      @Override
      public int getColumnCount()
      {
        return cols.length;
      }

      @Override
      public String getColumnName(int i)
      {
        return cols[i];
      }

      @Override
      public int getRowCount()
      {
        return EditLaserDeviceDialog.this.currentLaserDevice == null ? 0
          : EditLaserDeviceDialog.this.currentLaserDevice.getLaserCutter().getSettingAttributes().size();
      }

      @Override
      public Object getValueAt(int y, int x)
      {
        String attribute = EditLaserDeviceDialog.this.currentLaserDevice.getLaserCutter().getSettingAttributes().get(y);
        if (x == 0)
        {
          return attribute;
        }
        else if (x == 1)
        {
          return EditLaserDeviceDialog.this.currentLaserDevice.getLaserCutter().getSettingValue(attribute);
        }
        return null;
      }

      @Override
      public boolean isCellEditable(int y, int x)
      {
        return x == 1;
      }

      @Override
      public void setValueAt(Object o, int y, int x)
      {
        if (x == 1)
        {
          String attribute = EditLaserDeviceDialog.this.currentLaserDevice.getLaserCutter().getSettingAttributes().get(y);
          EditLaserDeviceDialog.this.currentLaserDevice.getLaserCutter().setSettingValue(attribute, (String) o);
        }
      }
    });
    this.jTable1.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
  }
  protected LaserDevice laserDevice = null;
  public static final String PROP_LASERDEVICE = "laserDevice";

  /**
   * Get the value of laserDevice
   *
   * @return the value of laserDevice
   */
  public LaserDevice getLaserDevice()
  {
    return laserDevice;
  }

  /**
   * Set the value of laserDevice
   *
   * @param laserDevice new value of laserDevice
   */
  public void setLaserDevice(LaserDevice laserDevice)
  {
    LaserDevice oldLaserDevice = this.laserDevice;
    this.laserDevice = laserDevice;
    firePropertyChange(PROP_LASERDEVICE, oldLaserDevice, laserDevice);
    if (laserDevice != null)
    {
      this.setCurrentLaserDevice(laserDevice.clone());
    }
  }
  protected LaserDevice currentLaserDevice = null;
  public static final String PROP_CURRENTLASERDEVICE = "currentLaserDevice";

  /**
   * Get the value of currentLaserDevice
   *
   * @return the value of currentLaserDevice
   */
  public LaserDevice getCurrentLaserDevice()
  {
    return currentLaserDevice;
  }

  /**
   * Set the value of currentLaserDevice
   *
   * @param currentLaserDevice new value of currentLaserDevice
   */
  public void setCurrentLaserDevice(LaserDevice currentLaserDevice)
  {
    LaserDevice oldCurrentLaserDevice = this.currentLaserDevice;
    this.currentLaserDevice = currentLaserDevice;
    firePropertyChange(PROP_CURRENTLASERDEVICE, oldCurrentLaserDevice, currentLaserDevice);
    this.jComboBox1.setSelectedItem(currentLaserDevice.getLaserCutter().getClass().toString().substring(6));
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

        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        selectThumbnailButton1 = new com.t_oster.visicut.gui.beans.SelectThumbnailButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tfJobPrefix = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        jTextField2.setName("jTextField2"); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentLaserDevice.description}"), jTextField2, org.jdesktop.beansbinding.BeanProperty.create("text_ON_ACTION_OR_FOCUS_LOST"));
        bindingGroup.addBinding(binding);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.t_oster.visicut.gui.VisicutApp.class).getContext().getResourceMap(EditLaserDeviceDialog.class);
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jTextField1.setName("jTextField1"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentLaserDevice.name}"), jTextField1, org.jdesktop.beansbinding.BeanProperty.create("text_ON_ACTION_OR_FOCUS_LOST"), "name");
        bindingGroup.addBinding(binding);

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jTextField3.setToolTipText(resourceMap.getString("jTextField3.toolTipText")); // NOI18N
        jTextField3.setName("jTextField3"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentLaserDevice.cameraURL}"), jTextField3, org.jdesktop.beansbinding.BeanProperty.create("text_ON_ACTION_OR_FOCUS_LOST"), "urls");
        bindingGroup.addBinding(binding);

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jComboBox1.setEditable(true);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setName("jComboBox1"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        jTextField6.setToolTipText(resourceMap.getString("jTextField6.toolTipText")); // NOI18N
        jTextField6.setName("jTextField6"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentLaserDevice.materialsPath}"), jTextField6, org.jdesktop.beansbinding.BeanProperty.create("text"), "path");
        bindingGroup.addBinding(binding);

        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setName("jButton3"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        selectThumbnailButton1.setName("selectThumbnailButton1"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentLaserDevice.thumbnailPath}"), selectThumbnailButton1, org.jdesktop.beansbinding.BeanProperty.create("thumbnailPath"), "thumbnailbutton");
        bindingGroup.addBinding(binding);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setName("jTable1"); // NOI18N
        jScrollPane1.setViewportView(jTable1);

        tfJobPrefix.setToolTipText(resourceMap.getString("tfJobPrefix.toolTipText")); // NOI18N
        tfJobPrefix.setName("tfJobPrefix"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentLaserDevice.jobPrefix}"), tfJobPrefix, org.jdesktop.beansbinding.BeanProperty.create("text_ON_ACTION_OR_FOCUS_LOST"), "jobPrefixBinding");
        bindingGroup.addBinding(binding);

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(selectThumbnailButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, 0, 274, Short.MAX_VALUE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3))
                            .addComponent(tfJobPrefix, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(selectThumbnailButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfJobPrefix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
  {//GEN-HEADEREND:event_jButton2ActionPerformed
    this.setLaserDevice(null);
    this.setVisible(false);
  }//GEN-LAST:event_jButton2ActionPerformed

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
  {//GEN-HEADEREND:event_jButton1ActionPerformed
    String driver = (String) this.jComboBox1.getSelectedItem();
    try
    {
      LaserCutter cutter;
      try
      {
        Class driverclass = Class.forName(driver);
        cutter = (LaserCutter) driverclass.newInstance();
        //Try to set every setting from the current Lasercutter
        for (String a : this.currentLaserDevice.getLaserCutter().getSettingAttributes())
        {
          cutter.setSettingValue(a, this.currentLaserDevice.getLaserCutter().getSettingValue(a));
        }
      }
      catch (Exception e)
      {
        throw new Exception("The driver could not be loaded:\n" + e.getMessage());
      }
      currentLaserDevice.setLaserCutter(cutter);
      if ("".equals(currentLaserDevice.getCameraURL()))
      {
        currentLaserDevice.setCameraURL(null);
      }
      if (currentLaserDevice.getMaterialsPath() == null || !new File(currentLaserDevice.getMaterialsPath()).isDirectory())
      {
        throw new Exception("The materials directory must be a valid directory");
      }
      if (currentLaserDevice.getName() == null || currentLaserDevice.getName().equals(""))
      {
        throw new Exception("The name must not be empty");
      }
      //If class not existing yet in preferences, add them
      boolean found = false;
      String[] drivers = PreferencesManager.getInstance().getPreferences().getAvailableLasercutterDrivers();
      for (String s : drivers)
      {
        if (s.equals(driver))
        {
          found = true;
          break;
        }
      }
      if (!found)
      {
        drivers = Arrays.copyOf(drivers, drivers.length + 1);
        drivers[drivers.length - 1] = driver;
        PreferencesManager.getInstance().getPreferences().setAvailableLasercutterDrivers(drivers);
      }
      this.setLaserDevice(currentLaserDevice);
      this.setVisible(false);
    }
    catch (Exception ex)
    {
      JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
      return;
    }
  }//GEN-LAST:event_jButton1ActionPerformed

  private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
  {//GEN-HEADEREND:event_jButton3ActionPerformed
    if (Helper.isMacOS())
    {//use native dialog to select directories
      System.setProperty("apple.awt.fileDialogForDirectories", "true");
      FileDialog fd = new FileDialog(this, "Please select a material directory");
      fd.setMode(FileDialog.LOAD);
      if (currentLaserDevice.getMaterialsPath() != null)
      {
        fd.setDirectory(currentLaserDevice.getMaterialsPath());
      }
      fd.setVisible(true);
      if (fd.getFile() != null)
      {
        File dir = new File(fd.getDirectory());
        dir = new File(dir, fd.getFile());
        if (dir.isDirectory())
        {
          currentLaserDevice.setMaterialsPath(dir.getAbsolutePath());
        }
      }
      System.setProperty("apple.awt.fileDialogForDirectories", "false");
    }
    else
    {
      JFileChooser fs = new JFileChooser();
      fs.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      fs.setDialogType(JFileChooser.OPEN_DIALOG);
      if (currentLaserDevice.getMaterialsPath() != null)
      {
        fs.setCurrentDirectory(new File(currentLaserDevice.getMaterialsPath()));
      }
      if (fs.showDialog(this, "Please Select a Directory") == JFileChooser.APPROVE_OPTION)
      {
        File dir = fs.getSelectedFile();
        if (dir.isDirectory())
        {
          currentLaserDevice.setMaterialsPath(dir.getPath());
        }
      }
    }

  }//GEN-LAST:event_jButton3ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField6;
    private com.t_oster.visicut.gui.beans.SelectThumbnailButton selectThumbnailButton1;
    private javax.swing.JTextField tfJobPrefix;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
