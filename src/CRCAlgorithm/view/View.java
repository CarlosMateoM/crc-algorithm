package CRCAlgorithm.view;

import CRCAlgorithm.interfaces.CycleIterationListener;
import CRCAlgorithm.model.CRC;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author mateo092
 */
public class View extends javax.swing.JFrame implements CycleIterationListener {

    /**
     * Creates new form View
     */
    boolean isRunningAlgorithmToCheck = false;

    public View() {
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);

    }

    public void enableActions() {
        initCRCAlgorithmBtn.setEnabled(!isRunningAlgorithmToCheck);
        CheckCRCAlgorithmBtn.setEnabled(isRunningAlgorithmToCheck);
    }

    public CRC getDataCRCAlgorithm() {
        enableActions();
        gifPanel1.setImage("/CRCAlgorithm/resources/sendDataToPc.gif");
        isRunningAlgorithmToCheck = true;
        CRC crc = new CRC();
        crc.setPolynomialBitstring(polynomialBitstringTxt.getText());
        crc.setInputBitstring(inputBitstringTxt.getText());
        crc.setInitialFiller("0".repeat(polynomialBitstringTxt.getText().length() - 1));
        return crc;
    }

    public CRC getDataToCheckCRCAlgorithm() {
        enableActions();
        gifPanel1.setImage("/CRCAlgorithm/resources/sendDataToPCwithCRC.gif");
        isRunningAlgorithmToCheck = false;
        CRC crc = new CRC();
        String remainder = "0".repeat(polynomialBitstringTxt.getText().length() - 1 - remainderTxt.getText().length()) + remainderTxt.getText();
        crc.setPolynomialBitstring(polynomialBitstringTxt.getText());
        crc.setInputBitstring(inputBitstringTxt.getText());
        crc.setInitialFiller(remainder);
        return crc;
    }

    public void addActionListener(ActionListener ac) {
        initCRCAlgorithmBtn.addActionListener(ac);
        CheckCRCAlgorithmBtn.addActionListener(ac);
    }

    @Override
    public void notifyAlgorithmStart() {
    }

    @Override
    public void notifyCycleIteration(CRC crc) {
        inputPaddedTxt.setText(crc.getInputPadded());
        currentChunkTxt.setText(crc.getCurrentChuck());
        quotientTxt.setText(crc.getQuotient());
    }

    @Override
    public void notifyAlgorithmFinish(CRC crc) {
        enableActions();
        currentChunkTxt.setText("");
        remainderTxt.setText(crc.getCurrentChuck());

        if (isRunningAlgorithmToCheck) {
            gifPanel1.setImage("/CRCAlgorithm/resources/sendDataToRouter.gif");
            JOptionPane.showMessageDialog(null, "¡Algoritmo finalizado!", "Algoritmo CRC", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (crc.getCurrentChuck().isEmpty()) {
                JOptionPane.showMessageDialog(null, "¡Verificación correcta!", "Algoritmo CRC", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "¡Verificación INCORRECTA!", "Algoritmo CRC", JOptionPane.WARNING_MESSAGE);

            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        currentChunkTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        polynomialBitstringTxt = new javax.swing.JTextField();
        inputBitstringTxt = new javax.swing.JTextField();
        inputPaddedTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        gifPanel1 = new CRCAlgorithm.view.GifPanel();
        initCRCAlgorithmBtn = new javax.swing.JButton();
        CheckCRCAlgorithmBtn = new javax.swing.JButton();
        remainderTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        quotientTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("(CRC) Algoritmo de Revisión de Redundancia Cíclica");
        setResizable(false);

        jLabel4.setText("CC = ");

        jLabel1.setText("D = ");

        jLabel2.setText("G = ");

        polynomialBitstringTxt.setText("1001");
        polynomialBitstringTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                polynomialBitstringTxtActionPerformed(evt);
            }
        });

        inputBitstringTxt.setText("10011110");

        jLabel3.setText("CRC = ");

        initCRCAlgorithmBtn.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBoxMenuItem.acceleratorForeground"));
        initCRCAlgorithmBtn.setForeground(new java.awt.Color(255, 255, 255));
        initCRCAlgorithmBtn.setText("enviar");
        initCRCAlgorithmBtn.setActionCommand("initCRCAlgorithmCmd");

        CheckCRCAlgorithmBtn.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        CheckCRCAlgorithmBtn.setForeground(new java.awt.Color(255, 255, 255));
        CheckCRCAlgorithmBtn.setText("verificar");
        CheckCRCAlgorithmBtn.setActionCommand("CheckCRCAlgorithmCmd");

        javax.swing.GroupLayout gifPanel1Layout = new javax.swing.GroupLayout(gifPanel1);
        gifPanel1.setLayout(gifPanel1Layout);
        gifPanel1Layout.setHorizontalGroup(
            gifPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gifPanel1Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(initCRCAlgorithmBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CheckCRCAlgorithmBtn)
                .addGap(69, 69, 69))
        );
        gifPanel1Layout.setVerticalGroup(
            gifPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gifPanel1Layout.createSequentialGroup()
                .addContainerGap(184, Short.MAX_VALUE)
                .addGroup(gifPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(initCRCAlgorithmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CheckCRCAlgorithmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(127, 127, 127))
        );

        remainderTxt.setText("1001");
        remainderTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remainderTxtActionPerformed(evt);
            }
        });

        jLabel5.setText("R = ");

        quotientTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quotientTxtActionPerformed(evt);
            }
        });

        jLabel6.setText("C = ");

        jLabel7.setText("Carlos Mateo Martinez Guerra - Eylin Vanesa Ortega Buelvas - Redes Locales");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel8.setText("Para inducir un error edite los bits en D, G o R al finalizar el envio y antes de iniciar la verificación");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(gifPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(polynomialBitstringTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(inputBitstringTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(6, 6, 6)
                                        .addComponent(currentChunkTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(inputPaddedTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(quotientTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(remainderTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currentChunkTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputPaddedTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(remainderTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(inputBitstringTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(polynomialBitstringTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(quotientTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addGap(24, 24, 24)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gifPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void polynomialBitstringTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_polynomialBitstringTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_polynomialBitstringTxtActionPerformed

    private void remainderTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remainderTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_remainderTxtActionPerformed

    private void quotientTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quotientTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quotientTxtActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CheckCRCAlgorithmBtn;
    private javax.swing.JTextField currentChunkTxt;
    private CRCAlgorithm.view.GifPanel gifPanel1;
    private javax.swing.JButton initCRCAlgorithmBtn;
    private javax.swing.JTextField inputBitstringTxt;
    private javax.swing.JTextField inputPaddedTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField polynomialBitstringTxt;
    private javax.swing.JTextField quotientTxt;
    private javax.swing.JTextField remainderTxt;
    // End of variables declaration//GEN-END:variables

}
