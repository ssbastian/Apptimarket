
package co.unicauca.apptimarket.client.presentation;

import co.unicauca.apptimarket.client.domain.ClienteRapido;
import static co.unicauca.apptimarket.client.infra.Messages.successMessage;
import co.unicauca.apptimarket.commons.domain.carritoDTO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WINDOWS
 */
public class frmRecibo extends javax.swing.JFrame {
   
    /**
     * Creates new form frmRecibo
     */
    public frmRecibo() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    
    DefaultTableModel objDatos = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    public frmRecibo(ArrayList <carritoDTO> prmPago, ClienteRapido prmClienteRapido) {
        initComponents();
        setLocationRelativeTo(null);
        
        double cmpTotal = 0;
        
        tblListaComprada.setModel(objDatos);
        objDatos.setNumRows(0);
        
        txtNombreComprador.setText(prmClienteRapido.getAtrNombre().trim());
        txtIDComprador.setText(prmClienteRapido.getAtrID().trim());
        txtDireccion.setText(prmClienteRapido.getAtrDireccion().trim());
        txtTelefono.setText(prmClienteRapido.getAtrTelefono().trim());
        
        try {

            for (int count = 0; count < prmPago.size(); count++) {
                objDatos.setColumnIdentifiers(new Object[]{"Codigo", "Nombre", "Precio", "Cantidad"});
                objDatos.insertRow(count, new Object[]{prmPago.get(count).getCodigo(), prmPago.get(count).getNombre(),
                    prmPago.get(count).getPrecio(), prmPago.get(count).getCantidad()});
                
                cmpTotal += prmPago.get(count).getCantidad() * Double.parseDouble( prmPago.get(count).getPrecio());
                
            }

            
            txtPagar.setText(cmpTotal + "");
            // System.out.println("Desde Carrito\n Código: " + codigo + ", nombre: " + nombre + ", precio: " + precio);
            tblListaComprada.setRowHeight(1, 30);

        } catch (Exception ex) {
            successMessage(ex.getMessage(), "Atención");
            return;
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

        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtIDComprador = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtNombreComprador = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPagar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaComprada = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Factura de compra");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(188, 11, 325, 47);

        jLabel5.setText("Nombre comprador:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(50, 100, 111, 16);

        jLabel6.setText("ID comprador:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(70, 130, 78, 16);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setText("TOTAL A PAGAR ($):");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 375, 240, 32);
        getContentPane().add(txtIDComprador);
        txtIDComprador.setBounds(180, 130, 230, 24);

        jLabel8.setText("Dirección de domicilio:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(40, 160, 125, 16);
        getContentPane().add(txtDireccion);
        txtDireccion.setBounds(180, 160, 230, 24);
        getContentPane().add(txtNombreComprador);
        txtNombreComprador.setBounds(180, 100, 232, 24);

        jLabel9.setText("Número teléfono comprador:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 190, 158, 16);

        txtPagar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        getContentPane().add(txtPagar);
        txtPagar.setBounds(254, 372, 249, 40);

        tblListaComprada.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblListaComprada);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 258, 673, 96);

        jLabel10.setText("Infotmación de la compra");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(250, 230, 139, 16);
        getContentPane().add(txtTelefono);
        txtTelefono.setBounds(180, 190, 230, 24);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 860, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(frmRecibo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRecibo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRecibo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRecibo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRecibo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListaComprada;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIDComprador;
    private javax.swing.JTextField txtNombreComprador;
    private javax.swing.JTextField txtPagar;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
