package ventanas;

import clases.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Christian
 */
public class RegistrarClientes extends javax.swing.JFrame {

    String user;

    public RegistrarClientes() {
        initComponents();
        user = Login.user;
        this.setTitle("Registrar nuevo cliente - Sesión de " + user);
        this.setSize(530, 375);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        //No finaliza el programa al cerrar la interfaz
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        /// IMAGEN DE FONDO
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");   //Poner imagen de fondo
        //Adaptar el tamaño del JLabel LA IMAGEN Y ASÍ, con anchura, altura y que se escalable
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(lbl_wallpaper.getWidth(), lbl_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        lbl_wallpaper.setIcon(icono);   //Colocamos el objeto en el label
        this.repaint(); //Necesario por que a veces no se ve la imagen. 
    }

    //Icono de la ventana
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_mail = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        btn_registroUsuarios = new javax.swing.JButton();
        lbl_footer = new javax.swing.JLabel();
        lbl_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro de Clientes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Email:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Teléfono:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Dirección:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Registrar Cliente");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, -1, -1));

        txt_nombre.setBackground(new java.awt.Color(153, 153, 255));
        txt_nombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        txt_mail.setBackground(new java.awt.Color(153, 153, 255));
        txt_mail.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_mail.setForeground(new java.awt.Color(255, 255, 255));
        txt_mail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_mail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, -1));

        txt_telefono.setBackground(new java.awt.Color(153, 153, 255));
        txt_telefono.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_telefono.setForeground(new java.awt.Color(255, 255, 255));
        txt_telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_telefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, -1));

        txt_direccion.setBackground(new java.awt.Color(153, 153, 255));
        txt_direccion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_direccion.setForeground(new java.awt.Color(255, 255, 255));
        txt_direccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_direccion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 210, -1));

        btn_registroUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btn_registroUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registroUsuariosActionPerformed(evt);
            }
        });
        getContentPane().add(btn_registroUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 100, -1));

        lbl_footer.setText("Creado por Christian Elier De la Paz Barajas ©");
        getContentPane().add(lbl_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, -1, -1));
        getContentPane().add(lbl_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_registroUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registroUsuariosActionPerformed
        int validacion = 0; //Si hay campos vacíos
        String nombre, mail, telefono, direccion;

        nombre = txt_nombre.getText().trim();
        mail = txt_mail.getText().trim();
        telefono = txt_telefono.getText().trim();
        direccion = txt_direccion.getText().trim();

        if (nombre.equals("")) {
            txt_nombre.setBackground(new Color(255, 0, 0));
            validacion++;
        }
        if (direccion.equals("")) {
            txt_telefono.setBackground(new Color(255, 0, 0));
            validacion++;
        }
        if (mail.equals("")) {
            txt_direccion.setBackground(new Color(255, 0, 0));
            validacion++;
        }
        if (telefono.equals("")) {
            txt_mail.setBackground(new Color(255, 0, 0));
            validacion++;
        }

        if (validacion == 0) {
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(""
                        + "insert into clientes values(?,?,?,?,?,?)");
                pst.setInt(1, 0); //Enviar a la posición 1 un valor entero que la BD interpreta como AI 
                pst.setString(2, nombre);
                pst.setString(3, mail);
                pst.setString(4, telefono);
                pst.setString(5, direccion);
                pst.setString(6, user); //Variable del usuario que los está registrando estática hasta arriba

                pst.executeUpdate();
                cn.close();

                Limpiar(); //Limpia campos de texto

                txt_nombre.setBackground(new Color(0, 255, 0));
                txt_telefono.setBackground(new Color(0, 255, 0));
                txt_mail.setBackground(new Color(0, 255, 0));
                txt_direccion.setBackground(new Color(0, 255, 0));

                JOptionPane.showMessageDialog(null, "Registro exitoso");

                this.dispose(); //cerramos y libera recursos

            } catch (SQLException e) {
                System.out.println("Error en registrar cliente " + e);
                JOptionPane.showMessageDialog(null, "ERROR! al registrar cliente contacte al administrador");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debes de llenar todos los campos");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(RegistrarClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            txt_nombre.setBackground(new Color(153, 153, 255));
            txt_direccion.setBackground(new Color(153, 153, 255));
            txt_mail.setBackground(new Color(153, 153, 255));
            txt_telefono.setBackground(new Color(153, 153, 255));
        }
    }//GEN-LAST:event_btn_registroUsuariosActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(RegistrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_registroUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbl_footer;
    private javax.swing.JLabel lbl_wallpaper;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
    public void Limpiar() {
        txt_nombre.setText("");
        txt_direccion.setText("");
        txt_telefono.setText("");
        txt_mail.setText("");
    }
}
