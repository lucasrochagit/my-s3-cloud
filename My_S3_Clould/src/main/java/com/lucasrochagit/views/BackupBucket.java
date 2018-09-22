/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasrochagit.views;


import com.lucasrochagit.aws.services.s3.S3Methods;
import com.lucasrochagit.entities.business.BucketBusiness;
import com.lucasrochagit.entities.model.BucketModel;
import com.lucasrochagit.entities.model.FileModel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author lucas
 */
public class BackupBucket extends javax.swing.JFrame {
    
    private ArrayList<BucketModel> buckets;
    /**
     * Creates new form UploadFile
     */
    public BackupBucket(ArrayList<BucketModel> buckets) {
        initComponents();
        appearance();
        
        this.buckets = buckets;
        List<String> bucketsNames = new ArrayList<>();

        for (BucketModel b : this.buckets) {;
            bucketsNames.add(b.getName());
        }

        bucketOpt.setModel(
                new DefaultComboBoxModel
                    (bucketsNames.toArray(new String[bucketsNames.size()]))
        );

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bucketOpt = new javax.swing.JComboBox<>();
        download = new javax.swing.JLabel();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        title.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("BACKUP OF BUCKET");
        title.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel1.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        jLabel1.setText("SELECT A BUCKET TO DO A BACKUP:");

        bucketOpt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bucketOpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bucketOptActionPerformed(evt);
            }
        });

        download.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        download.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        download.setText("DOWNLOAD");
        download.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        download.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        download.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                downloadMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                downloadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                downloadMouseExited(evt);
            }
        });

        back.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 18)); // NOI18N
        back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back.setText("BACK");
        back.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(299, 299, 299))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(188, 188, 188))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(bucketOpt, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(download, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bucketOpt, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(download, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(158, 158, 158)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bucketOptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bucketOptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bucketOptActionPerformed

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
        MyFiles f = new MyFiles(buckets);;
        this.dispose();
        f.setVisible(true);
    }//GEN-LAST:event_backMouseClicked

    private void backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseEntered
        // TODO add your handling code here:
        back.setForeground(Color.BLUE);
    }//GEN-LAST:event_backMouseEntered

    private void backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseExited
        // TODO add your handling code here:
        back.setForeground(Color.BLACK);
    }//GEN-LAST:event_backMouseExited

    private void downloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_downloadMouseClicked
        // TODO add your handling code here:   
        for (FileModel f: BucketBusiness
                            .getInstance()
                            .getBucket(buckets,
                                            bucketOpt
                                               .getSelectedItem()
                                               .toString())
                                               .getFiles()){            
            S3Methods
                .getInstance()
                .downloadFile
                    (bucketOpt.getSelectedItem().toString(), f.getName());
        }        
        JOptionPane
            .showMessageDialog(null,
                    "Backup made sucessfully.",
                    "Information",
                    JOptionPane.INFORMATION_MESSAGE);   
    }//GEN-LAST:event_downloadMouseClicked

    private void downloadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_downloadMouseEntered
        // TODO add your handling code here:
        download.setForeground(Color.BLUE);
    }//GEN-LAST:event_downloadMouseEntered

    private void downloadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_downloadMouseExited
        // TODO add your handling code here:
        download.setForeground(Color.BLACK);

    }//GEN-LAST:event_downloadMouseExited
    public static void appearance() {
        try {
            UIManager
                .setLookAndFeel
                    ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger
                    .getLogger(BackupBucket.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JComboBox<String> bucketOpt;
    private javax.swing.JLabel download;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
