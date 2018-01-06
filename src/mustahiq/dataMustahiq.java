/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mustahiq;

import muzakki.*;
import aplikasizakat.koneksi;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.SpinnerNumberModel;
import javax.swing.JOptionPane;
/**
 *
 * @author abdul hamid
 */
public class dataMustahiq extends javax.swing.JFrame {

    /**
     * Creates new form inputMuzakki
     */
    koneksi k=new koneksi();
    SpinnerNumberModel modelJiwa;
    int zakatUang=0,zakatBeras=0,jmlBeras=0;
    public dataMustahiq() {
        initComponents();
        k.konek();
        getData();          
    }
    public void getData(){
        
        String sql="select * from dt_mustahiq where nomor='"+daftarMustahiq.noMustahiq+"'";

         try{
            k.st=k.conn.createStatement();
            k.rs=k.st.executeQuery(sql);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "Load data gagal");
            return;
        }
         try {
            k.rs.next();
            txtTanggal.setText(k.rs.getString("tglInput").toString());
            txtNomor.setText(Integer.toString(k.rs.getInt("nomor")));
            cmbGol.setSelectedItem(k.rs.getString("gol"));
            txtNamaMustahiq.setText(k.rs.getString("namaMustahiq").toString().toUpperCase());
            txtAlamat.setText(k.rs.getString("Alamat").toString().toUpperCase());
            txtJmlUang.setText(Integer.toString(k.rs.getInt("jmlUang")));
            txtJmlBeras.setText(Integer.toString(k.rs.getInt("jmlBeras")));
            txtPanitia.setText(koneksi.username);
            txtKet.setText(k.rs.getString("ket").toString());
         } catch (SQLException e) {
             JOptionPane.showMessageDialog(null,"Data gagal di perbarui");
         }
    }
    
    public void setKosongkan(){
        txtNamaMustahiq.setText(null);
        txtAlamat.setText(null);
        txtJmlUang.setText(null);
        txtJmlBeras.setText(null);
        txtKet.setText(null);
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
        txtTanggal = new javax.swing.JTextField();
        txtNomor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNamaMustahiq = new javax.swing.JTextField();
        txtAlamat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtJmlUang = new javax.swing.JTextField();
        txtJmlBeras = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPanitia = new javax.swing.JTextField();
        btnBatal = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cmbGol = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtKet = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INPUT DATA MUZAKKI");
        setBackground(new java.awt.Color(153, 255, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText(".:: EDIT DATA MUSTAHIQ ::.");

        jLabel2.setText("TANGGAL");

        jLabel3.setText("NOMOR");

        txtTanggal.setEditable(false);
        txtTanggal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txtNomor.setEditable(false);
        txtNomor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel4.setText("NAMA");

        txtNamaMustahiq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaMustahiqActionPerformed(evt);
            }
        });

        jLabel5.setText("ALAMAT");

        jLabel8.setText("JUMLAH UANG");

        txtJmlBeras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtJmlBerasMousePressed(evt);
            }
        });

        jLabel9.setText("Kg");

        jLabel11.setText("PANITIA");

        txtPanitia.setEditable(false);
        txtPanitia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        btnBatal.setText("BATAL");
        btnBatal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/WZSAVE.jpg"))); // NOI18N
        btnEdit.setText("EDIT");
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEdit.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jLabel12.setText("GOLONGAN");

        jLabel13.setText("JUMLAH BERAS");

        cmbGol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- PILIH GOLONGAN --", "AMILIN", "RIQOB", "GHORIMIN", "MUALLAF", "FISABILILLAH", "IBNU SABIL", " " }));

        jLabel6.setText("KERANGAN");

        txtKet.setColumns(20);
        txtKet.setRows(5);
        jScrollPane1.setViewportView(txtKet);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(271, 271, 271))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel12)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4))
                            .addGap(14, 14, 14))
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNamaMustahiq, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbGol, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 54, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnEdit)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnBatal))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel8))
                                    .addGap(30, 30, 30)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtJmlUang, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtJmlBeras, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel9))
                                        .addComponent(txtPanitia, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNomor, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtNomor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbGol, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtJmlUang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtJmlBeras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaMustahiq, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPanitia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEdit)
                            .addComponent(btnBatal))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void txtJmlBerasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtJmlBerasMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJmlBerasMousePressed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        if(txtNamaMustahiq.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Nama Penerima Belum di Isi");
            txtNamaMustahiq.requestFocus();
        }else if(cmbGol.getSelectedIndex()==0 ){
            JOptionPane.showMessageDialog(null,"Golongan Belum di Pilih");
            cmbGol.requestFocus();
        }else if(txtAlamat.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Alamat Belum di Isi");
            txtAlamat.requestFocus();
        }else if(txtJmlUang.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Jumlah Uang Belum di Isi");
            txtJmlUang.requestFocus();
        }else if(Integer.parseInt(txtJmlUang.getText()) > daftarMustahiq.totUangMuzakki){
            JOptionPane.showMessageDialog(null,"Jumlah Uang Melebihi Jumlah Maksimal");
            txtJmlUang.requestFocus();
        }else if(Integer.parseInt(txtJmlUang.getText()) < 0){
            JOptionPane.showMessageDialog(null,"Jumlah Uang Harus Lebih Dari 0");
            txtJmlUang.requestFocus();
        }else{
            boolean proses=false;
            if(txtJmlBeras.getText().isEmpty()){
                jmlBeras=0;
                proses=true;
            }else if((!(txtJmlBeras.getText().isEmpty()))&& (Integer.parseInt(txtJmlBeras.getText()) > daftarMustahiq.totBerasMuzakki)){
                JOptionPane.showMessageDialog(null,"Jumlah Beras Melebihi Jumlah Maksimal");
                txtJmlBeras.requestFocus();
                proses=false;
            }else if((!(txtJmlBeras.getText().isEmpty()))&& (Integer.parseInt(txtJmlBeras.getText()) < 0)){
                JOptionPane.showMessageDialog(null,"Jumlah Beras Harus Lebih Dari 0");
                txtJmlBeras.requestFocus();
                proses=false;
            }else{
                jmlBeras=Integer.parseInt(txtJmlBeras.getText());
                proses=true;
            }
            if(proses==true){
           
                if(Integer.parseInt(txtJmlUang.getText())<zakatUang){
                    zakatUang=zakatUang-Integer.parseInt(txtJmlUang.getText());
                    zakatUang=datfarMuzakki.totalUang-zakatUang;
                }else if(Integer.parseInt(txtJmlUang.getText())>zakatUang){
                    zakatUang=Integer.parseInt(txtJmlUang.getText())-zakatUang;
                    zakatUang=datfarMuzakki.totalUang+zakatUang;
                }else{
                    zakatUang=datfarMuzakki.totalUang;
                }
                if(Integer.parseInt(txtJmlBeras.getText())<zakatBeras){
                    zakatBeras=zakatBeras-Integer.parseInt(txtJmlBeras.getText());
                    zakatBeras=datfarMuzakki.totalBeras-zakatBeras;
                }else if(Integer.parseInt(txtJmlBeras.getText())>zakatBeras){
                    zakatBeras=Integer.parseInt(txtJmlBeras.getText())-zakatBeras;
                    zakatBeras=datfarMuzakki.totalBeras+zakatBeras;
                }else{
                    zakatBeras=datfarMuzakki.totalBeras;
                }
                String sql="Update dt_mustahiq set gol='"+cmbGol.getSelectedItem().toString()+
                    "',namaMustahiq='"+txtNamaMustahiq.getText().toUpperCase()+
                    "',alamat='"+txtAlamat.getText()+
                    "',ket='"+txtKet.getText()+
                    "',jmlUang='"+txtJmlUang.getText()+
                    "',jmlBeras='"+txtJmlBeras.getText()+
                    "',panitia='"+koneksi.username+"' where nomor='"+daftarMustahiq.noMustahiq+"'";
                String updateLog="update log_muzakki set totalUang='"+zakatUang+"',totalBeras='"+zakatBeras+"'";
                try{
                    try{
                        k.st=k.conn.createStatement();
                        k.st.execute(sql);
                    }catch(SQLException e){
                        JOptionPane.showMessageDialog(this, "Penyimpanan Gagal");
                        setKosongkan();
                        txtNamaMustahiq.requestFocus();
                        return;
                    }
                    try{
                        k.st=k.conn.createStatement();
                        k.st.execute(updateLog);
                        //JOptionPane.showMessageDialog(this, "Data Berhasil Di Update");
                    }catch(SQLException e){
                        //JOptionPane.showMessageDialog(this, "Gagal Di Update");
                        return;
                    }
                        JOptionPane.showMessageDialog(this, "Data Berhasil Di Edit");
                        dispose();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this, "Gagal Di Edit");
                }
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void txtNamaMustahiqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaMustahiqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaMustahiqActionPerformed

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
            java.util.logging.Logger.getLogger(dataMustahiq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dataMustahiq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dataMustahiq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dataMustahiq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dataMustahiq().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox cmbGol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtJmlBeras;
    private javax.swing.JTextField txtJmlUang;
    private javax.swing.JTextArea txtKet;
    private javax.swing.JTextField txtNamaMustahiq;
    private javax.swing.JTextField txtNomor;
    private javax.swing.JTextField txtPanitia;
    private javax.swing.JTextField txtTanggal;
    // End of variables declaration//GEN-END:variables
}