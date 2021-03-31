/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.sql.*;
import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Christian
 */
public class GestionarEquipos extends javax.swing.JFrame {

    String user;
    public static int IDequipo_update; //Variable que mandemos para ver el equipo seleccionado
    DefaultTableModel model = new DefaultTableModel(); //Permite la interacción con la tabla 

    public GestionarEquipos() {
        initComponents();
        this.setSize(630, 380);
        user = Login.user;
        this.setTitle("Capturista - Sesión de " + user + " -");
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //Cerrar ventana sin acabar proceso

        /// IMAGEN DE FONDO
        ImageIcon wallpaper = new ImageIcon("src/images/wallpaperPrincipal.jpg");   //Poner imagen de fondo
        //Adaptar el tamaño del JLabel LA IMAGEN Y ASÍ, con anchura, altura y que se escalable
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(lbl_wallpaper.getWidth(), lbl_wallpaper.getHeight(), Image.SCALE_DEFAULT));
        lbl_wallpaper.setIcon(icono);   //Colocamos el objeto en el label
        this.repaint(); //Necesario por que a veces no se ve la imagen.

        //TABLA
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(""
                    + "select id_equipo, tipo_equipo, marca, estatus from equipos");

            ResultSet rs = pst.executeQuery();

            tab_equipos = new JTable(model); //Conexion con tabla asociando el objeto DefaultTableModel
            scrollp_equipos.setViewportView(tab_equipos); //Metemos la tabla en el Scrollpane

            model.addColumn(" ");
            model.addColumn("TIPO");
            model.addColumn("MARCA");
            model.addColumn("ESTATUS");

            while (rs.next()) { //Mientras existan registros
                Object[] fila = new Object[4];
                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error en gestionar equipos en la base de datos " + e);
        }
        //Método para obtener datos de la tabla
        this.ObtenerDatosTabla();

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
        scrollp_equipos = new javax.swing.JScrollPane();
        tab_equipos = new javax.swing.JTable();
        lbl_footer = new javax.swing.JLabel();
        cmb_estatus = new javax.swing.JComboBox<>();
        Mostrar = new javax.swing.JButton();
        lbl_wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Equipos Registrados");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        tab_equipos.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollp_equipos.setViewportView(tab_equipos);

        getContentPane().add(scrollp_equipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 630, 180));

        lbl_footer.setText("Creado por Christian Elier De la Paz Barajas ©");
        getContentPane().add(lbl_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, -1, -1));

        cmb_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nuevo Ingreso", "No reparado", "No revision", "Reparado", "Entregado" }));
        cmb_estatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_estatusActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 130, -1));

        Mostrar.setBackground(new java.awt.Color(153, 153, 255));
        Mostrar.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        Mostrar.setForeground(new java.awt.Color(255, 255, 255));
        Mostrar.setText("Mostrar");
        Mostrar.setBorder(null);
        Mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarActionPerformed(evt);
            }
        });
        getContentPane().add(Mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 210, 35));
        getContentPane().add(lbl_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarActionPerformed
        String seleccion = cmb_estatus.getSelectedItem().toString();
        String query = "";

        model.setRowCount(0);           //Limpiamos las filas
        model.setColumnCount(0);        //Limpiamos las columnas

        try {
            Connection cn = Conexion.conectar();
            
            if (seleccion.equalsIgnoreCase("Todos")) { //Si se selecciona todos
                query = "select id_equipo, tipo_equipo, marca, estatus from equipos";
            } else {    //Si se selecciona cualquier otra cosa de acuerdo a la selección
                query = "select id_equipo, tipo_equipo, marca, estatus from equipos where estatus ='" + seleccion + "'";
            }
            
            //Consulta
            PreparedStatement pst = cn.prepareStatement(query);
            //Resultados
            ResultSet rs = pst.executeQuery();
            
            //Creamos la tabla
            tab_equipos = new JTable(model);
            scrollp_equipos.setViewportView(tab_equipos);
            
            //Diseño Tabla
            model.addColumn(" ");
            model.addColumn("TIPO");
            model.addColumn("MARCA");
            model.addColumn("ESTATUS");
            
            //Creamos visivilidad de la tabla
            while(rs.next()){
                Object [] fila = new Object[4];
                for (int i = 0; i < 4; i++) {
                    fila[i]=rs.getObject(i + 1);
                }
                model.addRow(fila); //Agregamos fila a la tabla
            }
            cn.close();
            
        } catch (SQLException e) {
            System.err.println("Error al recuperar los registros de equipo en el filtro"+ e);
        }
        this.ObtenerDatosTabla();
    }//GEN-LAST:event_MostrarActionPerformed

    private void cmb_estatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_estatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_estatusActionPerformed

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
            java.util.logging.Logger.getLogger(GestionarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarEquipos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Mostrar;
    private javax.swing.JComboBox<String> cmb_estatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_footer;
    private javax.swing.JLabel lbl_wallpaper;
    private javax.swing.JScrollPane scrollp_equipos;
    private javax.swing.JTable tab_equipos;
    // End of variables declaration//GEN-END:variables

    public void ObtenerDatosTabla() {
        //Creación de eventos para la tabla
        //Lo pasamos a un método y depende del botón presionado
        tab_equipos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Coordenadas para que indique cuál celda se presionó
                int fila_point = tab_equipos.rowAtPoint(e.getPoint()); //El punto exacto
                int columna_point = 0; //Queremos el puro ID por ende sólo podemos seleccionar la primer columna

                if (fila_point > -1) { //Sólo para verificar que si clickea la tabla
                    IDequipo_update = (int) model.getValueAt(fila_point, columna_point);

                    //Abrir ventana extra cuando seleccionamos registros
                    InformacionEquipoTecnico info = new InformacionEquipoTecnico();
                    info.setVisible(true);
                }
            }
        });
    }

}