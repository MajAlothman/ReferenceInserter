
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;


public class GUI extends javax.swing.JFrame{


    static GUI gui;
    ArrayList<BibItem> library ;
    ArrayList<BibItem> result ;
    String path = "";

    public GUI() {
        path = GUIHelper.chooseDirectory();
        library = BibHelper.parseBibFileToBibItemArray(path);
        result = library;
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

        jSlider1 = new javax.swing.JSlider();
        listPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultList = new javax.swing.JList<>();
        keyLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        authorLabel = new javax.swing.JLabel();
        yearLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bibFileInfoLabel = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        searchInfoLabel = new javax.swing.JLabel();
        hotkeyLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        listPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Matched Bib Items: "+ result.size()));

        resultList.setModel(/* here */new javax.swing.AbstractListModel() {
            Object[] strings = result.toArray();
            public int getSize() { return strings.length; }
            public BibItem getElementAt(int i) { return (BibItem)strings[i]; }
        });
        resultList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                resultListKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                resultListKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(resultList);

        keyLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        keyLabel.setText("Info about the selected bib item will appear here");
        keyLabel.setToolTipText("");

        titleLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        titleLabel.setText("-");

        authorLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        authorLabel.setText("-");

        yearLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        yearLabel.setText("-");

        javax.swing.GroupLayout listPanelLayout = new javax.swing.GroupLayout(listPanel);
        listPanel.setLayout(listPanelLayout);
        listPanelLayout.setHorizontalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(keyLabel)
                    .addComponent(titleLabel)
                    .addComponent(authorLabel)
                    .addComponent(yearLabel))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        listPanelLayout.setVerticalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addGroup(listPanelLayout.createSequentialGroup()
                        .addComponent(keyLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(titleLabel)
                        .addGap(18, 18, 18)
                        .addComponent(authorLabel)
                        .addGap(18, 18, 18)
                        .addComponent(yearLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bibFileInfoLabel.setText(path + " |  " + library.size());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bibFileInfoLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bibFileInfoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        searchInfoLabel.setText("<- Enter your search term here ( shortcut: \\)");

        hotkeyLabel.setText("Enter- BibKey 1-Title 2-Author 3-Title-Author-Year");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hotkeyLabel)
                            .addComponent(searchInfoLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchInfoLabel)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hotkeyLabel)
                .addGap(18, 18, 18)
                .addComponent(listPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setBounds(0, 0, 675, 330);
    }// </editor-fold>//GEN-END:initComponents
    
    public static void changeStateNormal(){
        gui.setState(javax.swing.JFrame.NORMAL);
    }
    
    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // come here
        if(evt.getActionCommand().trim().isEmpty()){
            result = library;
        }else{
            result = BibHelper.searchBibArray(library, evt.getActionCommand());
        }
        resultList.setModel(/* here */new javax.swing.AbstractListModel() {
            Object[] strings = result.toArray();
            public int getSize() { return strings.length; }
            public BibItem getElementAt(int i) { return (BibItem)strings[i]; }
        });
        listPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Matched Bib Items: "+ result.size()));

    }//GEN-LAST:event_searchFieldActionPerformed

    private void resultListKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_resultListKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN){
            BibItem dummyBib = resultList.getSelectedValue();
            if(dummyBib == null){
                keyLabel.setText("Info about the selected bib item will appear here");
                titleLabel.setText("-");
                authorLabel.setText("-");
                yearLabel.setText("-");
            }
            else{
                keyLabel.setText(dummyBib.getType()+ " - "+ dummyBib.getKey());
                titleLabel.setText("<html>"+">>Title:  "+dummyBib.getTitle()+"</html>");
                authorLabel.setText("<html>"+">>Author:  "+dummyBib.getAuthor()+"</html>");
                yearLabel.setText(">>Year:  "+ dummyBib.getYear());
            }
        }
    }//GEN-LAST:event_resultListKeyReleased

    private void resultListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_resultListKeyPressed
        BibItem dummyBib = resultList.getSelectedValue();
        if(dummyBib == null);
        else if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            gui.setExtendedState(javax.swing.JFrame.ICONIFIED);
            GUIHelper.copyAndPaste(dummyBib.getKey());
        }
        else if(evt.getKeyCode() == KeyEvent.VK_1){
            gui.setExtendedState(javax.swing.JFrame.ICONIFIED);
            GUIHelper.copyAndPaste(dummyBib.getTitle());
        }
        else if(evt.getKeyCode() == KeyEvent.VK_2){
            gui.setExtendedState(javax.swing.JFrame.ICONIFIED);
            GUIHelper.copyAndPaste(dummyBib.getAuthor());
        }
        else if(evt.getKeyCode() == KeyEvent.VK_3){
            gui.setExtendedState(javax.swing.JFrame.ICONIFIED);
            GUIHelper.copyAndPaste(dummyBib.getTitle()+"-"+dummyBib.getAuthor()+"-"+dummyBib.getYear());
        }
    }//GEN-LAST:event_resultListKeyPressed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                gui = new GUI();
                gui.setVisible(true);
            }
        });
        
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }
        GlobalScreen.addNativeKeyListener(new GlobalGUIListener());     
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorLabel;
    private javax.swing.JLabel bibFileInfoLabel;
    private javax.swing.JLabel hotkeyLabel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel keyLabel;
    private javax.swing.JPanel listPanel;
    private javax.swing.JList<BibItem> resultList;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel searchInfoLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel yearLabel;
    // End of variables declaration//GEN-END:variables
}
