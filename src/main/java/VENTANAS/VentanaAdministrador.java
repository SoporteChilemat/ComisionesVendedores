package VENTANAS;

import static DAO.administradorDAO.contraseñaAdministrador;
import DAO.consultaUsuarioDAO;
import static VENTANAS.VentanaLogin.dialogLogin;
import static VENTANAS.VentanaPrincipal.ventanaPrincipal;
import com.tagmycode.plugin.gui.TextPrompt;
import java.awt.Image;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class VentanaAdministrador extends javax.swing.JDialog {

    public VentanaAdministrador(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        ImageIcon imageIcon = new ImageIcon("Logo\\brazo.png");
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);

        jLabel1.setHorizontalAlignment(JLabel.CENTER);
        jLabel1.setIcon(imageIcon);
        jLabel1.setText("");

        TextPrompt tp1 = new TextPrompt("Contraseña Administrador", jPasswordField1);
        tp1.changeAlpha(0.5f);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String text = jPasswordField1.getText();
        String contraseñaAdministrador = "";
        try {
            contraseñaAdministrador = contraseñaAdministrador();
        } catch (IOException ex) {
            Logger.getLogger(VentanaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VentanaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }

        String usuario = dialogLogin.jTextField1.getText();
        String contraseña = dialogLogin.jPasswordField1.getText();
        String contraseña2 = dialogLogin.jPasswordField2.getText();

        if (text.equals(contraseñaAdministrador)) {
            System.out.println("usuario " + usuario);
            System.out.println("contraaseña " + contraseña);
            System.out.println("contraseña2 " + contraseña2);
            dispose();
            dialogLogin.dispose();

            boolean insertUsuario = false;
            try {
                insertUsuario = consultaUsuarioDAO.registraUsuario(usuario, contraseña);
            } catch (IOException ex) {
                Logger.getLogger(VentanaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(VentanaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (insertUsuario) {
                System.out.println("1");
                VentanaOK dialogOK = new VentanaOK(ventanaPrincipal, true);
                dialogOK.setLocationRelativeTo(ventanaPrincipal);
                dialogOK.setModal(true);
                dialogOK.setVisible(true);
            } else {
                System.out.println("1");
                VentanaErroContraseñas dialogError = new VentanaErroContraseñas(ventanaPrincipal, true);
                dialogError.jLabel1.setText("    Contraseña Incorrecta     ");
                dialogError.jLabel1.setText("Ops! Informar Al Administrador");
                dialogError.setLocationRelativeTo(ventanaPrincipal);
                dialogError.setModal(true);
                dialogError.setVisible(true);
            }
        } else {
            System.out.println("1");
            VentanaErroContraseñas dialogError = new VentanaErroContraseñas(ventanaPrincipal, true);
            dialogError.jLabel1.setText("    Contraseña Incorrecta     ");
            dialogError.setLocationRelativeTo(ventanaPrincipal);
            dialogError.setModal(true);
            dialogError.setVisible(true);

            dispose();
            dialogLogin.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    // End of variables declaration//GEN-END:variables
}
