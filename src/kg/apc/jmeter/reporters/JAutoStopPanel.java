package kg.apc.jmeter.reporters;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Stephane Hoblingre
 */
public class JAutoStopPanel extends javax.swing.JPanel {

    /** Creates new form JAutoStopPanel */
    public JAutoStopPanel() {
        initComponents();
        registerJTextfieldForValidation(jTextFieldError, true);
        registerJTextfieldForValidation(jTextFieldErrorSec, false);
        registerJTextfieldForValidation(jTextFieldRespLatency, false);
        registerJTextfieldForValidation(jTextFieldRespLatencySec, false);
        registerJTextfieldForValidation(jTextFieldRespTime, false);
        registerJTextfieldForValidation(jTextFieldRespTimeSec, false);

        initFields();
    }

    public void configure(AutoStop testElement) {
        jTextFieldRespTime.setText(testElement.getResponseTime());
        jTextFieldRespTimeSec.setText(testElement.getResponseTimeSecs());
        jTextFieldError.setText(testElement.getErrorRate());
        jTextFieldErrorSec.setText(testElement.getErrorRateSecs());
        jTextFieldRespLatency.setText(testElement.getResponseLatency());
        jTextFieldRespLatencySec.setText(testElement.getResponseLatencySecs());
    }

    public void modifyTestElement(AutoStop testElement) {
        testElement.setResponseTime(jTextFieldRespTime.getText());
        testElement.setResponseTimeSecs(jTextFieldRespTimeSec.getText());
        testElement.setErrorRate(jTextFieldError.getText());
        testElement.setErrorRateSecs(jTextFieldErrorSec.getText());
        testElement.setResponseLatency(jTextFieldRespLatency.getText());
        testElement.setResponseLatencySecs(jTextFieldRespLatencySec.getText());
    }

    public final void initFields() {
        jTextFieldRespTime.setText("1000");
        jTextFieldRespTimeSec.setText("10");
        jTextFieldError.setText("50");
        jTextFieldErrorSec.setText("10");
        jTextFieldRespLatency.setText("50");
        jTextFieldRespLatencySec.setText("10");
    }

    private int getIntValue(JTextField tf) {
        int ret;
        try {
            ret = Integer.valueOf(tf.getText());
        } catch (NumberFormatException ex) {
            ret = -1;
        }
        return ret;
    }

    private float getFloatValue(JTextField tf) {
        float ret;
        try {
            ret = Float.valueOf(tf.getText());
        } catch (NumberFormatException ex) {
            ret = -1;
        }
        return ret;
    }

    private boolean isVariableValue(JTextField tf) {
        String value = tf.getText();
        if(value != null) {
            return value.startsWith("${") && value.endsWith("}");
        } else {
            return false;
        }
    }

    private void processBullets() {
        jLabelBulletError.setEnabled(getFloatValue(jTextFieldError) > 0 || isVariableValue(jTextFieldError));
        jLabelBulletRespTime.setEnabled(getIntValue(jTextFieldRespTime) > 0 || isVariableValue(jTextFieldRespTime));
        jLabelBulletLatency.setEnabled(getIntValue(jTextFieldRespLatency) > 0 || isVariableValue(jTextFieldRespLatency));
    }

    private void setJTextFieldColor(final JTextField tf, boolean isFloat) {
        if(!isFloat && (getIntValue(tf) > -1 || isVariableValue(tf))) {
            tf.setForeground(Color.black);
        } else if(isFloat && (getFloatValue(tf) > -1 || isVariableValue(tf))) {
            tf.setForeground(Color.black);
        } else {
            tf.setForeground(Color.red);
        }
    }

    private void registerJTextfieldForValidation(final JTextField tf, final boolean isFloat) {
        tf.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void changedUpdate(DocumentEvent arg0) {
                setJTextFieldColor(tf, isFloat);
                processBullets();
            }

            @Override
            public void insertUpdate(DocumentEvent arg0) {
                setJTextFieldColor(tf, isFloat);
                processBullets();
            }

            @Override
            public void removeUpdate(DocumentEvent arg0) {
                setJTextFieldColor(tf, isFloat);
                processBullets();
            }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelBulletRespTime = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldRespTime = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldRespTimeSec = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelBulletLatency = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldRespLatency = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldRespLatencySec = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabelBulletError = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldError = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldErrorSec = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Test Plan Shutdown Criterias"));
        setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel1.setText("The test will be automatically stopped if any of these criteria is met:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(jLabel1, gridBagConstraints);

        jLabelBulletRespTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kg/apc/jmeter/reporters/bulletGreen.png"))); // NOI18N
        jPanel1.add(jLabelBulletRespTime);

        jLabel10.setText("Average Response Times are Greater than");
        jPanel1.add(jLabel10);

        jTextFieldRespTime.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldRespTime.setMaximumSize(new java.awt.Dimension(100, 20));
        jTextFieldRespTime.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel1.add(jTextFieldRespTime);

        jLabel2.setText("ms for");
        jPanel1.add(jLabel2);

        jTextFieldRespTimeSec.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldRespTimeSec.setInheritsPopupMenu(true);
        jTextFieldRespTimeSec.setMaximumSize(new java.awt.Dimension(100, 20));
        jTextFieldRespTimeSec.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel1.add(jTextFieldRespTimeSec);

        jLabel3.setText("seconds");
        jPanel1.add(jLabel3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(jPanel1, gridBagConstraints);

        jLabelBulletLatency.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kg/apc/jmeter/reporters/bulletGreen.png"))); // NOI18N
        jPanel2.add(jLabelBulletLatency);

        jLabel11.setText("Average Response Latencies are Greater than");
        jPanel2.add(jLabel11);

        jTextFieldRespLatency.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldRespLatency.setMaximumSize(new java.awt.Dimension(100, 20));
        jTextFieldRespLatency.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel2.add(jTextFieldRespLatency);

        jLabel4.setText("ms for");
        jPanel2.add(jLabel4);

        jTextFieldRespLatencySec.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldRespLatencySec.setMaximumSize(new java.awt.Dimension(100, 20));
        jTextFieldRespLatencySec.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel2.add(jTextFieldRespLatencySec);

        jLabel5.setText("seconds");
        jPanel2.add(jLabel5);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(jPanel2, gridBagConstraints);

        jLabelBulletError.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kg/apc/jmeter/reporters/bulletGreen.png"))); // NOI18N
        jPanel4.add(jLabelBulletError);

        jLabel12.setText("Error Rate is Greater than");
        jPanel4.add(jLabel12);

        jTextFieldError.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldError.setMaximumSize(new java.awt.Dimension(30, 20));
        jTextFieldError.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel4.add(jTextFieldError);

        jLabel6.setText("% for");
        jPanel4.add(jLabel6);

        jTextFieldErrorSec.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldErrorSec.setMaximumSize(new java.awt.Dimension(100, 20));
        jTextFieldErrorSec.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel4.add(jTextFieldErrorSec);

        jLabel7.setText("seconds");
        jPanel4.add(jLabel7);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(jPanel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jPanel3, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 10));
        jLabel8.setText("OR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        add(jLabel8, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 10));
        jLabel9.setText("OR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        add(jLabel9, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelBulletError;
    private javax.swing.JLabel jLabelBulletLatency;
    private javax.swing.JLabel jLabelBulletRespTime;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextFieldError;
    private javax.swing.JTextField jTextFieldErrorSec;
    private javax.swing.JTextField jTextFieldRespLatency;
    private javax.swing.JTextField jTextFieldRespLatencySec;
    private javax.swing.JTextField jTextFieldRespTime;
    private javax.swing.JTextField jTextFieldRespTimeSec;
    // End of variables declaration//GEN-END:variables

}
