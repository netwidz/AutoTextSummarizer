/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AppUI.java
 *
 * Created on Apr 22, 2012, 12:59:29 AM
 */
package iit.fyp.textSummarizer;

import iit.fyp.textSummarizer.core.ProgLogic;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Fahiz
 */
public class AppUI extends javax.swing.JFrame {

    /** Creates new form AppUI */
    public AppUI() {
        initComponents();
        initAppPreferences();
    }

    private void initAppPreferences() {
    	clearAll();
    	summaryPercentageTxt.setText(String.valueOf((int) summaryPercentage.getValue()));
    	
    	//txtSummarizer = new textSummarizer();
    	
    	jFileChooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				 return "MS Word 2003 , Ms Word 2007, PDF" ;
				
			}
			
			@Override
			public boolean accept(File file) {
				String fileName=file.getName().toLowerCase();
				 return fileName.endsWith(".doc") ||  fileName.endsWith(".docx") || fileName.endsWith(".pdf") || file.isDirectory() ;
				
			}
		});
    	
    	
		
		
		
	}

	/** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

    	jFileChooser = new javax.swing.JFileChooser();
        UserPreferencePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        chooseTxtField = new javax.swing.JTextField();
        chooseBtn = new javax.swing.JButton();
        consoleBtn = new javax.swing.JButton();
        summarizeBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        origBtn = new javax.swing.JButton();
        summaryPercentage = new javax.swing.JSlider();
        summaryPercentageTxt = new javax.swing.JTextField();
        aboutPanel = new javax.swing.JPanel();
        tabbedSummaryTxt = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Choose file to Summarize ");

        chooseTxtField.setEditable(false);

        chooseBtn.setText("Choose");
        chooseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseBtnActionPerformed(evt);
            }
        });

        consoleBtn.setText("Show / Hide Console");
        consoleBtn.setEnabled(false);
        consoleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	consoleBtnActionPerformed(evt);
            }
        });

        summarizeBtn.setText("Summarize");
        summarizeBtn.setEnabled(false);
        summarizeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					summarizeBtnActionPerformed(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        jLabel5.setText("Summary Percentage (%)");

        origBtn.setText("Retrieve Original Text");
        origBtn.setEnabled(false);
        origBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					origBtnActionPerformed(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
 
        
        summaryPercentageTxt.setEditable(false);

        javax.swing.GroupLayout UserPreferencePanelLayout = new javax.swing.GroupLayout(UserPreferencePanel);
        UserPreferencePanel.setLayout(UserPreferencePanelLayout);
        UserPreferencePanelLayout.setHorizontalGroup(
            UserPreferencePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserPreferencePanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(UserPreferencePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(UserPreferencePanelLayout.createSequentialGroup()
                        .addGroup(UserPreferencePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(UserPreferencePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UserPreferencePanelLayout.createSequentialGroup()
                                .addComponent(summaryPercentage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(summaryPercentageTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(chooseTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(origBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(UserPreferencePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chooseBtn)
                    .addGroup(UserPreferencePanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(summarizeBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(consoleBtn)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        UserPreferencePanelLayout.setVerticalGroup(
            UserPreferencePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserPreferencePanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(UserPreferencePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chooseTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chooseBtn)
                    .addComponent(jLabel1))
                .addGap(12, 12, 12)
                .addGroup(UserPreferencePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(summaryPercentage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(summaryPercentageTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UserPreferencePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(consoleBtn)
                    .addComponent(summarizeBtn)
                    .addComponent(origBtn))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        tabbedSummaryTxt.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jTextArea4.setColumns(20);
        jTextArea4.setEditable(false);
        jTextArea4.setRows(5);
        jScrollPane4.setViewportView(jTextArea4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedSummaryTxt.addTab("Original Text", jPanel1);

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedSummaryTxt.addTab("Summary Text", jPanel3);

        jTextArea2.setBackground(new java.awt.Color(51, 51, 51));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(204, 255, 255));
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedSummaryTxt.addTab("Console", jPanel4);

        jLabel2.setFont(new java.awt.Font("Calisto MT", 3, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setText("Auto Text Summarizer");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Developed By : Fahiz  Mohamed");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Version : 1.0 v");

        jLabel6.setFont(new java.awt.Font("Verdana", 2, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("This will help you to summarize documents which are in Microsoft Office word formats (DOC, DOCX) ");

        jLabel7.setFont(new java.awt.Font("Verdana", 2, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("and Portable Document Format (PDF). PDF should not be encrypted. ");

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("This is an approach to solve the Text Summarizing. This uses Statistical Approach to give the summary");

        jLabel9.setFont(new java.awt.Font("Harlow Solid Italic", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("Thank you for choosing");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel9)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        
        summaryPercentage.setMinimum(5);
        summaryPercentage.setMaximum(50);

        summaryPercentage.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                summPercentStateChanged(evt);
            }
        });
        
        tabbedSummaryTxt.addTab("About", jPanel5);

        javax.swing.GroupLayout aboutPanelLayout = new javax.swing.GroupLayout(aboutPanel);
        aboutPanel.setLayout(aboutPanelLayout);
        aboutPanelLayout.setHorizontalGroup(
            aboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedSummaryTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
                .addContainerGap())
        );
        aboutPanelLayout.setVerticalGroup(
            aboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedSummaryTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(aboutPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(UserPreferencePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UserPreferencePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(aboutPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void origBtnActionPerformed(java.awt.event.ActionEvent evt) throws Exception {   
    	
    	OPStream outPutter = new OPStream(jTextArea2,60);
        PrintStream printStream = new PrintStream(outPutter);

    	summarizeBtn.setEnabled(true);
    	jTextArea4.setText(AppLogic.getOriginalText());
    	
        System.setOut(printStream);
        System.setErr(printStream);
    	
    }    
    
    
private void  clearAll() {
	
	jTextArea1.setText("");
	jTextArea2.setText("");
	jTextArea4.setText("");
	chooseTxtField.setText("");
	AppLogic.init = false;
	origBtn.setEnabled(false);
	consoleBtn.setEnabled(false);
	summarizeBtn.setEnabled(false);
	
}
    
private void chooseBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
// TODO add your handling code here:
clearAll();
	OPStream outPutter = new OPStream(jTextArea2,60);
    PrintStream printStream = new PrintStream(outPutter);
    System.setOut(printStream);
    System.setErr(printStream);
    
    
	 int val = jFileChooser.showOpenDialog(this);
     if(val==jFileChooser.APPROVE_OPTION){
    	 try {
    		 		String filePath = jFileChooser.getSelectedFile().getAbsolutePath();
    		 
    				this.chooseTxtField.setText(filePath);
    				
    				AppLogic.setFilePath(filePath);
    				//summarizerThread.setFilePath(filePath);
    				
    				if(this.chooseTxtField.getText()!=""){
    					
     				   summarizeBtn.setEnabled(false);
     				   consoleBtn.setEnabled(true);
     				   origBtn.setEnabled(true);

    				}
    		   
    		   } catch (Exception e1) {
    			// TODO Auto-generated catch block
    			   e1.printStackTrace();
    		   }
	     }else {
	    	 
	    	 this.chooseTxtField.setText("");
	    	 
	     }
    
    
	
	

  
 
   

   
  // chooseBtn.setEnabled(false);

//        int retValue = jFileChooserBrowse.showOpenDialog(this);
//        if(retValue==jFileChooserBrowse.APPROVE_OPTION){
//            filePath=jFileChooserBrowse.getSelectedFile().getAbsolutePath();
//            this.jTextFieldFilePath.setText(filePath);
//            ProgramLogic.setFilePath(filePath);
//            jButtonGetFile.setEnabled(true);
//    
    
}                           

private void summPercentStateChanged(javax.swing.event.ChangeEvent evt) {                                                
    
    summaryPercentageTxt.setText(String.valueOf((int)(summaryPercentage.getValue())));
}  

private void consoleBtnActionPerformed(java.awt.event.ActionEvent evt) {                                         
// TODO add your handling code here:
   
      if(jPanel4.isShowing()){
    
    	  jPanel4.setVisible(false);
    	  jTextArea2.setVisible(false);
    }else{
    	jPanel4.setVisible(true);
    	jTextArea2.setVisible(true);
    }
}      




private void summarizeBtnActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
// TODO add your handling code here:
    
	 OPStream outPutter = new OPStream(jTextArea2,60);
	 System.out.println("buffer : "+outPutter.getMaximumLines());
     PrintStream printStream = new PrintStream(outPutter);
     outPutter.setMaximumLines(100000000);
     System.out.println("buffer : "+outPutter.getMaximumLines());

     
    
     if(!chooseTxtField.getText().isEmpty()){
    	 chooseBtn.setEnabled(false);
    	// SummarizerThread summarizerThread = new SummarizerThread( Integer.parseInt(summaryPercentageTxt.getText()),this);
      //   summarizerThread.setSummaryPercent(Integer.parseInt(summaryPercentageTxt.getText()));
    	 SummarizerThread summarizerThread = new SummarizerThread(Integer.parseInt(summaryPercentageTxt.getText()),this);
    	// summarizerThread.setFilePath(chooseTxtField.getText());
    	summarizerThread.start();
    	
    	if(!summarizerThread.isAlive()){
    		chooseBtn.setEnabled(true);
    		
    	}
    	 //summarizerThread.stop();
     }
     else{
    	 chooseBtn.setEnabled(true);
    	System.out.println("No file found");
     }
    	 
        
     

   
    	
   	
  
    
//jTextArea1.setText(summary);    	
     consoleBtn.setEnabled(true);
	
    	   


    
    System.setOut(printStream);
    System.setErr(printStream);
    	   
    
}

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
    	

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
            	
            	
            	
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(AppUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(AppUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(AppUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(AppUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            	
                new AppUI().setVisible(true);
            }
        });
    }
    
    
    
    // Variables declaration - do not modify
    
  
    javax.swing.JFileChooser jFileChooser;
    private javax.swing.JPanel UserPreferencePanel;
    private javax.swing.JPanel aboutPanel;
    javax.swing.JButton chooseBtn;
    private javax.swing.JTextField chooseTxtField;
    private javax.swing.JButton consoleBtn;
    private javax.swing.JButton summarizeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JButton origBtn;
    private javax.swing.JSlider summaryPercentage;
    private javax.swing.JTextField summaryPercentageTxt;
    private javax.swing.JTabbedPane tabbedSummaryTxt;
    // End of variables declaration
}
