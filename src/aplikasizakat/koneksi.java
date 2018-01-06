/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplikasizakat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author abdul hamid
 */

public class koneksi extends AplikasiZakat {
    
    public Connection conn;
    public Statement st;
    public ResultSet rs;
    public static String username;
    public static int idPanitia;
    
    public void konek(){
        koneksi("localhost","db_zakat","root","");
    }
    void koneksi(String server,String db,String user,String pass){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver tidak bisa diload");
            //e.printStackTrace();
            return;
        }
        //System.out.print("Driver berhasil diload \n");
        //JOptionPane.showMessageDialog(null, "Driver berhasil diload");
        conn=null;
        try {
            conn=DriverManager.getConnection("jdbc:mysql://"+server+":3306/"+db,user,pass);  
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi tidak berhasil");
            e.printStackTrace();
            return;
        }
        //System.out.print("Koneksi berhasil");
        //JOptionPane.showMessageDialog(null, "Koneksi berhasil");
    }
}
