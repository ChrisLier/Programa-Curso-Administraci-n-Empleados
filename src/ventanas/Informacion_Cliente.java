/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.sql.*;
import clases.Conexion;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Image; //Si se llaman igual Image caussa conflicto abajo, así que lo copiamos todo hasta otra seccion completo
import java.awt.Image;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import static ventanas.GestionarClientes.IDCliente_update;

/**
 *
 * @author Christian
 */
public class Informacion_Cliente extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();

    int IDCliente_update = 0;
    public static int IDequipo = 0;
    String user = "";

    public Informacion_Cliente() {
        initComponents();
        user = Login.user;
        IDCliente_update = GestionarClientes.IDCliente_update;

        this.setSize(630, 450);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        /// IMAGEN DE FONDO
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");   //Poner imagen de fondo
        //Adaptar el tamaño del JLabel LA IMAGEN Y ASÍ, con anchura, altura y que se escalable
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(lbl_wallpaper.getWidth(), lbl_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        lbl_wallpaper.setIcon(icono);   //Colocamos el objeto en el label
        this.repaint(); //Necesario por que a veces no se ve la imagen.

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from clientes where id_cliente= '" + IDCliente_update + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) { //Si hay registros
                setTitle("Información del cliente " + rs.getString("nombre_cliente") + " - Sesión de " + user);
                lbl_titulo.setText("Informacion del Cliente " + rs.getString("nombre_cliente"));

                txt_nombre.setText(rs.getString("nombre_cliente"));
                txt_mail.setText(rs.getString("mail_cliente"));
                txt_telefono.setText(rs.getString("tel_cliente"));
                txt_direccion.setText(rs.getString("dir_cliente"));
                txt_ultimaModificacion.setText(rs.getString("ultima_modificacion"));
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error en la conexión en Información al cliente.");
            JOptionPane.showMessageDialog(null, "¡¡ERROR!!, contacte al administrador.");
        }
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select id_equipo, tipo_equipo, marca, estatus from equipos where id_cliente = '"
                    + IDCliente_update + "'");
            ResultSet rs = pst.executeQuery();

            //Anexamos la tabla al Scroll
            table_equipos = new JTable(model);
            scrollEquipos.setViewportView(table_equipos);

            model.addColumn("ID Equipo");
            model.addColumn("Tipo de Equipo");
            model.addColumn("Marca");
            model.addColumn("Estatus");

            while (rs.next()) {//Mientras siga encontrando registros
                Object[] fila = new Object[4];

                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error en la conexión de la tabla equipos");
        }

        table_equipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Coordenadas para que indique cuál celda se presionó
                int fila_point = table_equipos.rowAtPoint(e.getPoint()); //El punto exacto
                int columna_point = 0; //Queremos el puro ID por ende sólo podemos seleccionar la primer columna

                if (fila_point > -1) { //Sólo para verificar que si clickea la tabla
                    IDequipo = (int) model.getValueAt(fila_point, columna_point);

                    //Abrir ventana extra cuando seleccionamos registros
                    InformacionEquipo informacionEquipo = new InformacionEquipo();
                    informacionEquipo.setVisible(true);

                }
            }
        });
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

        scrollEquipos = new javax.swing.JScrollPane();
        table_equipos = new javax.swing.JTable();
        btn_registrar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        lbl_titulo = new javax.swing.JLabel();
        lbl_footer = new javax.swing.JLabel();
        lbl_nombre = new javax.swing.JLabel();
        lbl_mail = new javax.swing.JLabel();
        lbl_telefono = new javax.swing.JLabel();
        lbl_direccion = new javax.swing.JLabel();
        lbl_ultimaModificacion = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_mail = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_ultimaModificacion = new javax.swing.JTextField();
        btn_imprimirReporte = new javax.swing.JButton();
        lbl_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_equipos.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollEquipos.setViewportView(table_equipos);

        getContentPane().add(scrollEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 380, 180));

        btn_registrar.setBackground(new java.awt.Color(153, 153, 255));
        btn_registrar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        btn_registrar.setForeground(new java.awt.Color(255, 255, 255));
        btn_registrar.setText("Registrar Equipo");
        btn_registrar.setBorder(null);
        btn_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 210, 35));

        btn_actualizar.setBackground(new java.awt.Color(153, 153, 255));
        btn_actualizar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        btn_actualizar.setForeground(new java.awt.Color(255, 255, 255));
        btn_actualizar.setText("Actualizar Cliente");
        btn_actualizar.setBorder(null);
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 210, 35));

        lbl_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_titulo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_titulo.setText("Información del Cliente");
        getContentPane().add(lbl_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lbl_footer.setText("Creado por Christian Elier De la Paz Barajas ©");
        getContentPane().add(lbl_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, -1, -1));

        lbl_nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_nombre.setForeground(new java.awt.Color(255, 255, 255));
        lbl_nombre.setText("Nombre:");
        getContentPane().add(lbl_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        lbl_mail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_mail.setForeground(new java.awt.Color(255, 255, 255));
        lbl_mail.setText("Mail:");
        getContentPane().add(lbl_mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        lbl_telefono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_telefono.setForeground(new java.awt.Color(255, 255, 255));
        lbl_telefono.setText("Teléfono:");
        getContentPane().add(lbl_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        lbl_direccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_direccion.setForeground(new java.awt.Color(255, 255, 255));
        lbl_direccion.setText("Dirección:");
        getContentPane().add(lbl_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        lbl_ultimaModificacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_ultimaModificacion.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ultimaModificacion.setText("Última Modificación:");
        getContentPane().add(lbl_ultimaModificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

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
        txt_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_direccionActionPerformed(evt);
            }
        });
        getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 210, -1));

        txt_ultimaModificacion.setBackground(new java.awt.Color(153, 153, 255));
        txt_ultimaModificacion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_ultimaModificacion.setForeground(new java.awt.Color(255, 255, 255));
        txt_ultimaModificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ultimaModificacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_ultimaModificacion.setEnabled(false);
        getContentPane().add(txt_ultimaModificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 210, -1));

        btn_imprimirReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        btn_imprimirReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imprimirReporteActionPerformed(evt);
            }
        });
        getContentPane().add(btn_imprimirReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 120, 100));
        getContentPane().add(lbl_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarActionPerformed
        RegistrarEquipo registrarEquipo = new RegistrarEquipo();
        registrarEquipo.setVisible(true);
    }//GEN-LAST:event_btn_registrarActionPerformed

    private void txt_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_direccionActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        int validacion = 0;
        String nombre, mail, telefono, direccion;
        nombre = txt_nombre.getText().trim();
        mail = txt_mail.getText().trim();
        telefono = txt_telefono.getText().trim();
        direccion = txt_direccion.getText().trim();

        //CAMPOS VACÍOS
        if (nombre.equals("")) {
            txt_nombre.setBackground(Color.red);
            validacion++;
        }
        if (mail.equals("")) {
            txt_mail.setBackground(Color.red);
            validacion++;
        }
        if (telefono.equals("")) {
            txt_telefono.setBackground(Color.red);
            validacion++;
        }
        if (direccion.equals("")) {
            txt_direccion.setBackground(Color.red);
            validacion++;
        }

        //VALIDACION
        if (validacion == 0) {

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "update clientes set nombre_cliente=?,mail_cliente=?,tel_cliente=?,dir_cliente=?,ultima_modificacion=? "
                        + "where id_cliente = '" + IDCliente_update + "'");
                pst.setString(1, nombre);
                pst.setString(2, mail);
                pst.setString(3, telefono);
                pst.setString(4, direccion);
                pst.setString(5, user); //Usuario Administrador

                pst.executeUpdate();
                cn.close();

                Limpiar();

                txt_nombre.setBackground(Color.green);
                txt_mail.setBackground(Color.green);
                txt_telefono.setBackground(Color.green);
                txt_direccion.setBackground(Color.green);
                txt_ultimaModificacion.setText(user);

                JOptionPane.showMessageDialog(null, "Actualización correcta.");
                this.dispose(); //Al dar aceptar se cierre la ventana

            } catch (SQLException e) {
                System.err.println("Error en boton actuali1zar cliente" + e);
                JOptionPane.showMessageDialog(null, "ERROR al actualizar cliente, contacte al administrador");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos !");
        }


    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btn_imprimirReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimirReporteActionPerformed

        Document documento = new Document();  //Generar Documento PDF

        try {

            String ruta = System.getProperty("user.home"); //Conseguimos ruta del usuario para dejar el PDF
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/" + txt_nombre.getText().trim() + ".pdf")); //Pasamos objeto del documento y ruta del documento pero en escritorio y su nombre 

            //HEADER con un paquete repetido 
            //Clase                 //Objeto //Instanciación
            com.itextpdf.text.Image header = com.itextpdf.text.Image.getInstance("src/images/BannerPDF.jpg");
            header.scaleToFit(650, 1000); //Tamaño de la imagen en el documento
            header.setAlignment(Chunk.ALIGN_CENTER);//Alineación de la imagen

            //Formato para el texto y texto
            Paragraph parrafo = new Paragraph();             //Instanciación
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);    //Alineación
            parrafo.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY)); //Características del texto
            parrafo.add("Información del cliente. \n\n");    //Agregamo texto

            //Agregamos objetos al documento
            documento.open();   //Abrir documento
            documento.add(header);
            documento.add(parrafo);

            //Creación de tablas
            PdfPTable tablaCliente = new PdfPTable(5); //NUMERO DE COLUMNAS
            tablaCliente.addCell("ID");
            tablaCliente.addCell("NOMBRE");
            tablaCliente.addCell("EMAIL");
            tablaCliente.addCell("TELEFONO");
            tablaCliente.addCell("DIRECCION");

            //Consultar registros en base al cliente iniciado
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select * from clientes where id_cliente ='" + IDCliente_update + "'");

                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    do {
                        //Llenamos registros
                        tablaCliente.addCell(rs.getString(1));
                        tablaCliente.addCell(rs.getString(2));
                        tablaCliente.addCell(rs.getString(3));
                        tablaCliente.addCell(rs.getString(4));
                        tablaCliente.addCell(rs.getString(5));

                    } while (rs.next()); //No se detiene hasta que acaben los registros

                    documento.add(tablaCliente);

                }

                //OTRO PARRAFO
                Paragraph parrafo2 = new Paragraph();
                parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo2.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));
                parrafo2.add("\n \n Equipos registrados \n \n");
                

                //Agregamos el objeto
                documento.add(parrafo2);

                //Tabla2
                PdfPTable tablaEquipos = new PdfPTable(4);
                tablaEquipos.addCell("ID equipo");
                tablaEquipos.addCell("Tipo");
                tablaEquipos.addCell("Marca");
                tablaEquipos.addCell("Estatus");

                try {
                    Connection cn2 = Conexion.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement(
                            "select id_equipo, tipo_equipo, marca, estatus from equipos where id_cliente = '" + IDCliente_update + "'");
                    ResultSet rs2 = pst2.executeQuery();

                    if (rs2.next()) {
                        do {

                            tablaEquipos.addCell(rs2.getString(1));
                            tablaEquipos.addCell(rs2.getString(2));
                            tablaEquipos.addCell(rs2.getString(3));
                            tablaEquipos.addCell(rs2.getString(4));

                        } while (rs2.next()); //Mientras haya registros
                        //Agregaos la tabla
                        documento.add(tablaEquipos);
                    }

                } catch (SQLException e) {
                    System.err.println("Error en la obtención de los equipos PDF " + e);
                }

            } catch (SQLException e) {
                System.err.println("Error al obtener datos del cliente" + e);
                
            }
            
            documento.close(); //Cerramos el documento
            JOptionPane.showMessageDialog(null, "Reporte creado correctamente !!");

        } catch (DocumentException | IOException e) { //Errores para archivos
            System.out.println("Error en PDF o ruta de imagen"+ e);
            JOptionPane.showMessageDialog(null, "Error al generar PDF, contacte al administrador.");
        }

    }//GEN-LAST:event_btn_imprimirReporteActionPerformed

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
            java.util.logging.Logger.getLogger(Informacion_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informacion_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informacion_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informacion_Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informacion_Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_imprimirReporte;
    private javax.swing.JButton btn_registrar;
    private javax.swing.JLabel lbl_direccion;
    private javax.swing.JLabel lbl_footer;
    private javax.swing.JLabel lbl_mail;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_telefono;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JLabel lbl_ultimaModificacion;
    private javax.swing.JLabel lbl_wallpaper;
    private javax.swing.JScrollPane scrollEquipos;
    private javax.swing.JTable table_equipos;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_ultimaModificacion;
    // End of variables declaration//GEN-END:variables

    public void Limpiar() {
        txt_nombre.setText("");
        txt_mail.setText("");
        txt_telefono.setText("");
        txt_direccion.setText("");
    }
}
