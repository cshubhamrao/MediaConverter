/*
 * Copyright (C) 2014 Shubham Rao
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.github.cshubhamrao.MediaConverter;

import com.github.cshubhamrao.MediaConverter.Library.FFMpegUtils;
import com.github.cshubhamrao.MediaConverter.Library.OSUtils;
import java.io.File;
import javax.swing.JOptionPane;

/** This class is the main UI for the app.
 *
 * @author Shubham Rao
 */
public class MainUI extends javax.swing.JFrame {
    
    /* Represents Files used by all parts of program */
    static File ffmpegLocation = new File (FFMpegUtils.FFMPEG_EXECUTABLE.
                                                                     getPath());
    File inputFileLocation;
    File outputFileLocation;
    File logFileLocation = new File (OSUtils.getJarLocation().getParent(),
                                                                    "file.log");

    /**
     * Creates new form MainUI
     */
    public MainUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputFileChooser = new javax.swing.JFileChooser();
        outputFileChooser = new javax.swing.JFileChooser();
        filePanel = new javax.swing.JPanel();
        inputFileLabel = new javax.swing.JLabel();
        inputFile = new javax.swing.JTextField();
        inputFileBrowse = new javax.swing.JButton();
        outputFileLabel = new javax.swing.JLabel();
        outputFile = new javax.swing.JTextField();
        outputFileBrowse = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputArea = new javax.swing.JTextArea();
        outputLogButton = new javax.swing.JButton();

        inputFileChooser.setCurrentDirectory(new java.io.File("C:\\Users\\Shubham\\Videos"));
        inputFileChooser.setDialogTitle("Open file for conversion");

        outputFileChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        outputFileChooser.setCurrentDirectory(new java.io.File("C:\\Users\\Shubham\\Videos"));
        outputFileChooser.setDialogTitle("Save the output file as");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Media Converter");

        filePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "File Selection", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        inputFileLabel.setText("Input File");

        inputFileBrowse.setText("Browse");
        inputFileBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputFileBrowseActionPerformed(evt);
            }
        });

        outputFileLabel.setText("Output File");

        outputFileBrowse.setText("Browse");
        outputFileBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputFileBrowseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout filePanelLayout = new javax.swing.GroupLayout(filePanel);
        filePanel.setLayout(filePanelLayout);
        filePanelLayout.setHorizontalGroup(
            filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(outputFileLabel)
                    .addComponent(inputFileLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outputFile)
                    .addComponent(inputFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputFileBrowse, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(outputFileBrowse, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        filePanelLayout.setVerticalGroup(
            filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputFileLabel)
                    .addComponent(inputFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputFileBrowse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(filePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outputFileLabel)
                    .addComponent(outputFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputFileBrowse))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        startButton.setText("Start");

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        outputArea.setColumns(20);
        outputArea.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(outputArea);

        outputLogButton.setText("Show Output Log");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(filePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(exitButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(startButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(outputLogButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(outputLogButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startButton)
                    .addComponent(exitButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void inputFileBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFileBrowseActionPerformed
        // TODO add your handling code here:
        inputFileChooser.showDialog(this, "Open this File");
        inputFile.setText(inputFileChooser.getSelectedFile().getPath());
        // Finally set inputFileLocation as text of the text bar
        inputFileLocation = new File (inputFile.getText());
        // If the file doesn't exist, show an error message
        if (!inputFileLocation.exists())
        {
            // Creates a scary error message dialog box.
            JOptionPane.showMessageDialog(this, "The input file doesn't exsist."
                    + "\nPlease choose another file", "Inavlid file selected", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_inputFileBrowseActionPerformed

    private void outputFileBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputFileBrowseActionPerformed
        // TODO add your handling code here:
        outputFileChooser.showDialog(this, "Open this File");
        outputFile.setText(outputFileChooser.getSelectedFile().getPath());
        // Finally set outputFileLocation as text of the text bar
        outputFileLocation = new File (outputFile.getText());
    }//GEN-LAST:event_outputFileBrowseActionPerformed

    /** This is the main method for {@code MainUI}
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            /* Set the System look and feel */
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager
                    .getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | 
                IllegalAccessException | 
                javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.
                    util.logging.Level.SEVERE, null, ex);
        }
        
        ffmpegLocation = FFMpegUtils.setFFMpegExecutable();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {new MainUI().setVisible(true);});
        //DEBUG 
        System.out.println(ffmpegLocation);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JPanel filePanel;
    private javax.swing.JTextField inputFile;
    private javax.swing.JButton inputFileBrowse;
    private javax.swing.JFileChooser inputFileChooser;
    private javax.swing.JLabel inputFileLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea outputArea;
    private javax.swing.JTextField outputFile;
    private javax.swing.JButton outputFileBrowse;
    private javax.swing.JFileChooser outputFileChooser;
    private javax.swing.JLabel outputFileLabel;
    private javax.swing.JButton outputLogButton;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
