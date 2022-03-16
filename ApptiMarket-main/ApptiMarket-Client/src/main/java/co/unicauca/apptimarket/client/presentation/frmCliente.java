package co.unicauca.apptimarket.client.presentation;

import co.unicauca.apptimarket.client.access.Factory;
import co.unicauca.apptimarket.client.access.IProductAccess;
import co.unicauca.apptimarket.client.domain.services.ProductService;
import static co.unicauca.apptimarket.client.infra.Messages.successMessage;
import co.unicauca.apptimarket.commons.domain.Product;
import co.unicauca.apptimarket.commons.domain.carritoDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WINDOWS
 */
public class frmCliente extends javax.swing.JFrame {

    /**
     * Creates new form frmCliente
     */
    public frmCliente() {
        initComponents();
        setLocationRelativeTo(null);

        SpinnerNumberModel modelSpinner = new SpinnerNumberModel();
        modelSpinner.setMinimum(1);
        modelSpinner.setValue(1);
        spnCantidad.setModel(modelSpinner);

        this.verTablaRegProduct(); //mostrar la tabla de registrar producto desde que se abre la pestaña
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        btnCancelarProducto = new javax.swing.JButton();
        btnAgregarCarrito = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRegProduct = new javax.swing.JTable();
        spnCantidad = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        btnRealizarCompra = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel2.setText("Registrar comprar");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setText("Código de producto:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setText("Producto:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setText("Precio:");

        jTextField2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        jTextField3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        btnCancelarProducto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnCancelarProducto.setText("Cancelar");

        btnAgregarCarrito.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        btnAgregarCarrito.setText("Agregar al carrito");
        btnAgregarCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCarritoActionPerformed(evt);
            }
        });

        tblRegProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRegProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRegProductMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblRegProduct);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel6.setText("Cantidad:");

        btnRealizarCompra.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnRealizarCompra.setText("Realizar compra");
        btnRealizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(btnAgregarCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRealizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 625, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(55, 55, 55)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(138, 138, 138)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(0, 17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(spnCantidad))
                .addGap(52, 52, 52)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnCancelarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRealizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Registrar compra", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String codigo, nombre, precio;
    int cantidad;

    DefaultTableModel objModelo = new DefaultTableModel();

    ArrayList<carritoDTO> objList = new ArrayList<carritoDTO>();
    private void tblRegProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRegProductMouseClicked
        // TODO add your handling code here:
        int seleccionar = tblRegProduct.rowAtPoint(evt.getPoint());

        jTextField1.setText((String.valueOf(tblRegProduct.getValueAt(seleccionar, 1))));
        jTextField2.setText((String.valueOf(tblRegProduct.getValueAt(seleccionar, 2))));
        jTextField3.setText((String.valueOf(tblRegProduct.getValueAt(seleccionar, 3))));
        jTextField1.setEnabled(false);
        jTextField2.setEnabled(false);
        jTextField3.setEnabled(false);

        codigo = jTextField1.getText().trim();
        nombre = jTextField2.getText().trim();
        precio = jTextField3.getText().trim();

     
        System.out.println("Desde cliente\n Código: " + codigo + ", nombre: " + nombre + ", precio: " + precio);
       
    }//GEN-LAST:event_tblRegProductMouseClicked

    private void btnAgregarCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCarritoActionPerformed
        // TODO add your handling code here:
        
        cantidad = (int) spnCantidad.getValue();
        carritoDTO obj = new carritoDTO(codigo, nombre, precio,cantidad);
        //carrito.verTablaCarrito(codigo, nombre, precio, cantidad);
         objList.add(obj); //se anade a la lista de carrito los productos

    }//GEN-LAST:event_btnAgregarCarritoActionPerformed

    private void btnRealizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarCompraActionPerformed
        // TODO add your handling code here:
        //new frmCarrito(codigo, nombre, precio, cantidad).setVisible(true);
        
        new frmCarrito(objList).setVisible(true);
    }//GEN-LAST:event_btnRealizarCompraActionPerformed

    DefaultTableModel objRegProduct = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    //Mostrar datos en la tabla del pabel Registrar producto
    private void verTablaRegProduct() {
        // TODO add your handling code here:
        tblRegProduct.setModel(objRegProduct);
        objRegProduct.setNumRows(0);

        IProductAccess objService = Factory.getInstance().getProductService();

        ProductService objProductService = new ProductService(objService);

        Product objProduct;

        System.out.println("MIRANDO LISTA");

        try {
            List<Product> varObjProducts = objProductService.findProducts();
            objRegProduct.setColumnIdentifiers(new Object[]{"idx", "Codigo", "Nombre", "Precio", "Existencias", "Tipo"});

            for (int count = 0; count < varObjProducts.size(); count++) {
                objRegProduct.insertRow(count, new Object[]{count, varObjProducts.get(count).getAtrCodigoProducto(),
                    varObjProducts.get(count).getAtrNombre(), varObjProducts.get(count).getAtrPrecio(),
                    varObjProducts.get(count).getAtrExistencia(), varObjProducts.get(count).getAtrTipo()});
            }

            for (int count = varObjProducts.size(); count < varObjProducts.size() + 5; count++) {
                objRegProduct.insertRow(count, new Object[]{""});
            }

            tblRegProduct.setRowHeight(1, 30);

        } catch (Exception ex) {
            successMessage(ex.getMessage(), "Atención");
            return;
        }
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
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCarrito;
    private javax.swing.JButton btnCancelarProducto;
    private javax.swing.JButton btnRealizarCompra;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JTable tblRegProduct;
    // End of variables declaration//GEN-END:variables
}
