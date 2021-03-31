/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.Conexion;
import java.sql.*;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Christian
 */
public class Capturista extends javax.swing.JFrame {

    String user, nombre_usuario;
    int sesion_usuario;

    /**
     * Creates new form Capturista
     */
    public Capturista() {
        initComponents();
        user = Login.user;
        sesion_usuario = Administrador.sesion_usuario; //Recibe bandera 1= Admin

        this.setSize(550, 300);  //Tamaño Ventana
        this.setResizable(false); //Sin cambiar tamaño
        this.setTitle("Capturista - Sesión de " + user);
        this.setLocationRelativeTo(null);

        if (sesion_usuario == 1)//Si es administrador no se finaliza el programa
        {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //Es admin no cierra el proceso
        } else {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Si no es admin cierra todo
        }
        /// IMAGEN DE FONDO para LOGIN
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");   //Poner imagen de fondo
        //Adaptar el tamaño del JLabel LA IMAGEN Y ASÍ, con anchura, altura y que se escalable
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(lbl_wallpaper.getWidth(), lbl_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        lbl_wallpaper.setIcon(icono);   //Colocamos el objeto en el label
        this.repaint(); //Necesario por que a veces no se ve la imagen. 

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select nombre_usuario from usuarios where username = '" + user + "'");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) { //Si se cumple
                nombre_usuario = rs.getString("nombre_usuario");
                lbl_NombreUsuario.setText("Bienvenido " + nombre_usuario);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error en consultar nombre de capturista" + e);
        }

    }

    //Para el ICONO DE LA INTERFAZ
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

        jLabel7 = new javax.swing.JLabel();
        lbl_NombreUsuario = new javax.swing.JLabel();
        btn_registrarCliente = new javax.swing.JButton();
        btn_gestionarClientes = new javax.swing.JButton();
        btn_imprimir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_footer = new javax.swing.JLabel();
        lbl_wallpaper = new javax.swing.JLabel();

        jLabel7.setText("Creado por Christian Elier De la Paz Barajas ©");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_NombreUsuario.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lbl_NombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lbl_NombreUsuario.setText("jLabel1");
        getContentPane().add(lbl_NombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btn_registrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btn_registrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btn_registrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 120, 100));

        btn_gestionarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/informationuser.png"))); // NOI18N
        btn_gestionarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gestionarClientesActionPerformed(evt);
            }
        });
        getContentPane().add(btn_gestionarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 120, 100));

        btn_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        btn_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imprimirActionPerformed(evt);
            }
        });
        getContentPane().add(btn_imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 120, 100));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Registrar Cliente");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Gestionar Clientes");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Imprimir Clientes");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, -1, -1));

        lbl_footer.setText("Creado por Christian Elier De la Paz Barajas ©");
        getContentPane().add(lbl_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, -1));
        getContentPane().add(lbl_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_registrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarClienteActionPerformed

        RegistrarClientes registrarClientes = new RegistrarClientes();
        registrarClientes.setVisible(true);
    }//GEN-LAST:event_btn_registrarClienteActionPerformed

    private void btn_gestionarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gestionarClientesActionPerformed
        GestionarClientes gestionarClientes = new GestionarClientes();
        gestionarClientes.setVisible(true);
    }//GEN-LAST:event_btn_gestionarClientesActionPerformed

    private void btn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimirActionPerformed
        Document documento = new Document();
        //Documento PDF
        try {
            //Sacar ruta del PDF
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/ListaClientes.pdf"));
            
            //Para que no haga conflicto importamos aquí directo la Image
            
            //BANNER
            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/BannerPDF.jpg");
            header.scaleToFit(650,1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            
            //Parrafo
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Lista de Clientes. \n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma",18,Font.BOLD, BaseColor.DARK_GRAY));
            
            //Arquitectura del Pdf
            documento.open();
            documento.add(header);
            documento.add(parrafo);
            
            //Tabla en el PDF para agregar la tabla de la base de datos
            PdfPTable tabla = new PdfPTable(5);
           
            //Encabezados
            tabla.addCell("ID");
            tabla.addCell("Nombre");
            tabla.addCell("Email");
            tabla.addCell("Telefono");
            tabla.addCell("Direccion");
            
            //Conexion a la BD
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement("select * from clientes");
                ResultSet rs = pst.executeQuery();
                
                //Si hay datos
                if (rs.next()) {
                    do {                        
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        
                    } while (rs.next());
                    
                    //Agregamos tabla al documento
                    documento.add(tabla);
                }
            } catch (SQLException e) {
                System.err.println("Error al generar lista de clientes " + e);
            }
            
            documento.close();
            JOptionPane.showMessageDialog(null, "Lista de Clientes creada correctamente.!!");
            
        } catch (Exception e) {
            System.err.println("Error al generar PDF " + e);
        }
    }//GEN-LAST:event_btn_imprimirActionPerformed

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
            java.util.logging.Logger.getLogger(Capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Capturista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Capturista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_gestionarClientes;
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JButton btn_registrarCliente;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lbl_NombreUsuario;
    private javax.swing.JLabel lbl_footer;
    private javax.swing.JLabel lbl_wallpaper;
    // End of variables declaration//GEN-END:variables
}