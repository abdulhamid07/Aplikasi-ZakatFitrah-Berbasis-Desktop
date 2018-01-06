/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mustahiq;

/**
 *
 * @author Student
 */
import muzakki.*;
import aplikasizakat.koneksi;
import java.io.*;
import java.sql.*;
import java.text.*;
import java.util.Date; 
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class daftarMustahiq extends javax.swing.JFrame {
    koneksi k=new koneksi();
    private DefaultTableModel model;
    private DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
    private DecimalFormat formatter;
    private boolean checkTable=false;
    public static String noMustahiq;
    public static String sql,logMuzakki;
    public static int totUangMuzakki,totBerasMuzakki,totUangMustahiq,totBerasMustahiq;
    ResultSet rsLog;
    Statement stLog;
    public daftarMustahiq() {
        initComponents();
        k.konek();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        inisialisasiKolom();
        tampilkanData();
    }
    void tampilkanData(){
        sql="select * from dt_mustahiq";
        logMuzakki="select * from log_muzakki";
        try{
            k.st=k.conn.createStatement();
            k.rs=k.st.executeQuery(sql);
            stLog=k.conn.createStatement();
            rsLog=stLog.executeQuery(logMuzakki);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "Load data gagal");
            return;
        }
        mengisiTable();
        settingKolom();
        symbols.setGroupingSeparator('.');
        Format formatter=new DecimalFormat("###,###.##", symbols);
        
        txtUangMustahiq.setText("Rp. "+formatter.format(totUangMustahiq));
        txtBerasMustahiq.setText(totBerasMustahiq+" Kg");
    }
    void settingKolom(){
        DefaultTableCellRenderer rataKanan=new DefaultTableCellRenderer();
        rataKanan.setHorizontalAlignment(SwingConstants.RIGHT);
        tblDaftarMustahiq.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumn col=null;
        col=tblDaftarMustahiq.getColumnModel().getColumn(0);
        col.setPreferredWidth(50);
        col=tblDaftarMustahiq.getColumnModel().getColumn(1);
        col.setPreferredWidth(100);
        col=tblDaftarMustahiq.getColumnModel().getColumn(2);
        col.setPreferredWidth(200);
        col=tblDaftarMustahiq.getColumnModel().getColumn(3);
        col.setPreferredWidth(250);
        col=tblDaftarMustahiq.getColumnModel().getColumn(4);
        col.setPreferredWidth(300);
        col=tblDaftarMustahiq.getColumnModel().getColumn(5);
        col.setPreferredWidth(100);
        col=tblDaftarMustahiq.getColumnModel().getColumn(6);
        col.setPreferredWidth(70);
        col=tblDaftarMustahiq.getColumnModel().getColumn(7);
        col.setPreferredWidth(100);
        col=tblDaftarMustahiq.getColumnModel().getColumn(8);
        col.setPreferredWidth(250);
 
        col.setCellRenderer(rataKanan);
        tblDaftarMustahiq.getColumnModel().getColumn(5).setCellRenderer(rataKanan);
        col=tblDaftarMustahiq.getColumnModel().getColumn(5);
        tblDaftarMustahiq.getColumnModel().getColumn(6).setCellRenderer(rataKanan);
        col=tblDaftarMustahiq.getColumnModel().getColumn(6);
    }
    void inisialisasiKolom(){
        model=new DefaultTableModel();
        tblDaftarMustahiq.setModel(model);
        model.addColumn("NO");
        model.addColumn("TANGGAL");
        model.addColumn("GOLONGAN");
        model.addColumn("NAMA MUSTAHIQ");
        model.addColumn("ALAMAT");
        model.addColumn("UANG");
        model.addColumn("BERAS");
        model.addColumn("PANITIA");
        model.addColumn("KETERANGAN");
        
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
    }
    void mengisiTable(){
        symbols.setGroupingSeparator('.');
        Format formatter=new DecimalFormat("###,###.##", symbols);
         try {
             while(k.rs.next()){
                 Object[] obj=new Object[9];
                 obj[0]=k.rs.getString("nomor");
                 obj[1]=k.rs.getString("tglInput");
                 obj[2]=k.rs.getString("gol").toUpperCase();
                 obj[3]=k.rs.getString("namaMustahiq");
                 obj[4]=k.rs.getString("alamat");
                 obj[5]=k.rs.getString("jmlUang");
                 obj[6]=k.rs.getString("jmlBeras");
                 obj[7]=k.rs.getString("panitia");
                 obj[8]=k.rs.getString("ket");
                 totUangMustahiq=totUangMustahiq+Integer.parseInt(k.rs.getString("jmlUang"));
                 totBerasMustahiq=totBerasMustahiq+Integer.parseInt(k.rs.getString("jmlBeras"));
                 model.addRow(obj);
             }
             rsLog.last();
             txtTerUang.setText("Rp. "+formatter.format(rsLog.getInt("totalUang")));
             txtTerBeras.setText(rsLog.getInt("totalBeras")+" Kg");
             totUangMuzakki=rsLog.getInt("totalUang");
             totBerasMuzakki=rsLog.getInt("totalBeras");
             
             //jScrollPane1.setViewportView(tblDaftarMuzakki); 
         } catch (SQLException e) {
             JOptionPane.showMessageDialog(null,"Data gagal diload");
         }
       
    }
    void fungsiPencarian(){
                inisialisasiKolom();
        sql="select * from dt_mustahiq where namaMustahiq like '%"+txtCari.getText().toString().toUpperCase()+"%'";
        try{
            k.st=k.conn.createStatement();
            k.rs=k.st.executeQuery(sql);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, "Data Tidak Ketemu");
            return;
        }
        mengisiTable();
        settingKolom();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCari = new javax.swing.JButton();
        lblTanggal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnKeluar = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnTambahMustahiq = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDaftarMustahiq = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtBerasMustahiq = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtUangMustahiq = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnRefMustahiq = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtTerBeras = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTerUang = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DAFTAR MUZAKKI");
        setBackground(new java.awt.Color(204, 204, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnCari.setText("CARI");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        lblTanggal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTanggal.setForeground(new java.awt.Color(0, 102, 51));
        lblTanggal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(".:: DAFTAR MUSTAHIQ ::.");

        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Masukkan Nama Mustahiq : ");

        btnKeluar.setText("KELUAR");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnEdit.setText("EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnTambahMustahiq.setText("TAMBAH");
        btnTambahMustahiq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahMustahiqActionPerformed(evt);
            }
        });

        tblDaftarMustahiq.setRowHeight(25);
        tblDaftarMustahiq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDaftarMustahiqMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDaftarMustahiq);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TOTAL PENYALURAN MUSTAHIQ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14), new java.awt.Color(153, 0, 0))); // NOI18N

        txtBerasMustahiq.setEditable(false);
        txtBerasMustahiq.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtBerasMustahiq.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setText("ZAKAT BERAS :");

        txtUangMustahiq.setEditable(false);
        txtUangMustahiq.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtUangMustahiq.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setText("ZAKAT UANG :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 60, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUangMustahiq, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBerasMustahiq, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUangMustahiq, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBerasMustahiq, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRefMustahiq.setText("Refresh");
        btnRefMustahiq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefMustahiqActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SISA ZAKAT TERKUMPUL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14), new java.awt.Color(153, 0, 0))); // NOI18N

        txtTerBeras.setEditable(false);
        txtTerBeras.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTerBeras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setText("ZAKAT BERAS :");

        txtTerUang.setEditable(false);
        txtTerUang.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTerUang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setText("ZAKAT UANG :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 28, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTerUang, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTerBeras, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTerUang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTerBeras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnTambahMustahiq)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnKeluar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCari)
                                .addGap(18, 18, 18)
                                .addComponent(lblTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRefMustahiq)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(61, 61, 61))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCari)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(lblTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefMustahiq))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKeluar)
                    .addComponent(btnHapus)
                    .addComponent(btnEdit)
                    .addComponent(btnTambahMustahiq))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
       DateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
       Date date=new Date();
       lblTanggal.setText("Tanggal : "+dateFormat.format(date).toString());

    }//GEN-LAST:event_formWindowOpened

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        fungsiPencarian();
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        totUangMustahiq=0;
        totBerasMustahiq=0;
        this.dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:

        if (checkTable == false) {
                JOptionPane.showMessageDialog(null,"Belum ada data yang dipilih");
                //checkTable = true;
            }else{
                if(JOptionPane.showConfirmDialog(null,"Yakin data akan dihapus?","Konfirmasi",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){ 
                String nomor=tblDaftarMustahiq.getValueAt(tblDaftarMustahiq.getSelectedRow(), 0).toString();
                String sql="delete from dt_mustahiq where nomor='"+nomor+"'";
                
                String zakatUang=tblDaftarMustahiq.getValueAt(tblDaftarMustahiq.getSelectedRow(),5).toString();
                String zakatBeras=tblDaftarMustahiq.getValueAt(tblDaftarMustahiq.getSelectedRow(),6).toString();
                String updateLog="update log_muzakki set totalUang=totalUang-'"+zakatUang+"',totalBeras=totalBeras-'"+zakatBeras+"'";
            try{
                try{
                    k.st=k.conn.createStatement();
                    k.st.execute(sql);
                    JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(this, "Gagal Dihapus");
                    return;
                }
                try{
                    k.st=k.conn.createStatement();
                    k.st.execute(updateLog);
                }catch(SQLException e){
                    return;
                }
                JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Gagal Dihapus");
            }
        }
    }
                
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tblDaftarMustahiqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDaftarMustahiqMouseClicked
        // TODO add your handling code here:
        checkTable=true;
    }//GEN-LAST:event_tblDaftarMustahiqMouseClicked

    private void btnTambahMustahiqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahMustahiqActionPerformed
        // TODO add your handling code here:
        new inputMustahiq().setVisible(true);
    }//GEN-LAST:event_btnTambahMustahiqActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        if(checkTable == false) {
                JOptionPane.showMessageDialog(null,"Belum ada data yang dipilih");
                //checkTable = true;
        }
        noMustahiq=tblDaftarMustahiq.getValueAt(tblDaftarMustahiq.getSelectedRow(), 0).toString();
        new dataMustahiq().setVisible(true);
        
    }//GEN-LAST:event_btnEditActionPerformed

    private void txtCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyPressed
        // TODO add your handling code here:
         if (evt.getKeyChar()==evt.VK_ENTER){
             fungsiPencarian();
         }
    }//GEN-LAST:event_txtCariKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        totUangMustahiq=0;
        totBerasMustahiq=0;
    }//GEN-LAST:event_formWindowClosed

    private void btnRefMustahiqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefMustahiqActionPerformed
        // TODO add your handling code here:
        totUangMustahiq=0;
        totBerasMustahiq=0;
        inisialisasiKolom();
        tampilkanData();
    }//GEN-LAST:event_btnRefMustahiqActionPerformed

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

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
            java.util.logging.Logger.getLogger(daftarMustahiq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(daftarMustahiq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(daftarMustahiq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(daftarMustahiq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new daftarMustahiq().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnRefMustahiq;
    private javax.swing.JButton btnTambahMustahiq;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JTable tblDaftarMustahiq;
    private javax.swing.JTextField txtBerasMustahiq;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtTerBeras;
    private javax.swing.JTextField txtTerUang;
    private javax.swing.JTextField txtUangMustahiq;
    // End of variables declaration//GEN-END:variables
}
