
package vista;

import controlador.conexionHorario;

import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.logging.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class horario extends javax.swing.JInternalFrame {
    DefaultTableModel model;
  
    public horario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnmodificar = new javax.swing.JMenuItem();
        mneliminar = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbclientes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btncronograma = new javax.swing.JButton();
        btnexpositores = new javax.swing.JButton();
        btntema = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();

        mnmodificar.setText("Modificar");
        mnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnmodificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnmodificar);

        mneliminar.setText("Eliminar");
        mneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mneliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mneliminar);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("ESTUDIANTE");
        setRequestFocusEnabled(false);
        setVisible(true);

        tbclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbclientes.setComponentPopupMenu(jPopupMenu1);
        jScrollPane2.setViewportView(tbclientes);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btncronograma.setText("Cronograma de horario");
        btncronograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncronogramaActionPerformed(evt);
            }
        });

        btnexpositores.setText("Expositores");
        btnexpositores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexpositoresActionPerformed(evt);
            }
        });

        btntema.setText("Tema");
        btntema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntemaActionPerformed(evt);
            }
        });

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btncronograma, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnexpositores, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btntema, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncronograma)
                    .addComponent(btnexpositores)
                    .addComponent(btntema)
                    .addComponent(btncancelar)
                    .addComponent(btnsalir))
                .addGap(189, 189, 189))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(163, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                .addGap(38, 38, 38))
        );

        getAccessibleContext().setAccessibleName("E");
        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btntemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntemaActionPerformed
// TODO add your handling code here:
    String []titulos={"TEMA"};
        model= new DefaultTableModel(null,titulos);
        
       // String []Datos= new String [3];
        
      // String a1="";
       //String a2="";
       //String a3="";
       String []re = new String [3];
        try {
            conexionHorario hora=new conexionHorario();
             ResultSet res =hora.cronograma();
            
            while(res.next())
            {
                //re[0]=res.getString("hora");
               //re[1] = res.getString("nombre_confe")+"  "+res.getString("apellido_confe");
               re[0] =res.getString("tema");
                model.addRow(re);
               
            }
            tbclientes.setModel(model);
        } catch (SQLException ex) {
            //Logger.getLogger(ConsultasBoletas.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        
    
    
    
}//GEN-LAST:event_btntemaActionPerformed

private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
// TODO add your handling code here:
    this.dispose();
}//GEN-LAST:event_btnsalirActionPerformed

private void btncronogramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncronogramaActionPerformed
// TODO add your handling code here:

        String []titulos={"HORA","CONFERENSISTA","TEMA"};
        model= new DefaultTableModel(null,titulos);
       String []re = new String [3];
        try {
            conexionHorario hora=new conexionHorario();
             ResultSet res =hora.cronograma();           
            while(res.next())
            {
                re[0]=res.getString("hora");
               re[1] = res.getString("nombre_confe")+"  "+res.getString("apellido_confe");
               re[2] =res.getString("tema");
                model.addRow(re);    
            }
            tbclientes.setModel(model);
        } catch (SQLException ex) {
   
        }

        

}//GEN-LAST:event_btncronogramaActionPerformed

private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
// TODO add your handling code here:
  
}//GEN-LAST:event_btncancelarActionPerformed

private void btnexpositoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexpositoresActionPerformed
// TODO add your handling code here:
String []titulos={"CONFERENSISTA"};
        model= new DefaultTableModel(null,titulos);
       String []re = new String [3];
        try {
            conexionHorario hora=new conexionHorario();
             ResultSet res =hora.cronograma();           
            while(res.next())
            {
                //re[0]=res.getString("hora");
               re[0] = res.getString("nombre_confe")+"  "+res.getString("apellido_confe");
               //re[2] =res.getString("tema");
                model.addRow(re);    
            }
            tbclientes.setModel(model);
        } catch (SQLException ex) {
   
        }

      

    
}//GEN-LAST:event_btnexpositoresActionPerformed

private void mneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mneliminarActionPerformed
// TODO add your handling code here:
    
}//GEN-LAST:event_mneliminarActionPerformed

private void mnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnmodificarActionPerformed
// TODO add your handling code here:
    
}//GEN-LAST:event_mnmodificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btncronograma;
    private javax.swing.JButton btnexpositores;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton btntema;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem mneliminar;
    private javax.swing.JMenuItem mnmodificar;
    private javax.swing.JTable tbclientes;
    // End of variables declaration//GEN-END:variables
conexionHorario cc= new conexionHorario();
Connection cn= cc.conexionn();
}
