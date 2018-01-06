/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplikasizakat;

/**
 *
 * @author abdul hamid
 */
import java.sql.*;
import java.io.*;
public class AplikasiZakat{
    /**
     * @param args the command line arguments
     */
    public static boolean logged;
    public static mainZakat mainZakat;
    static mainZakat main=new mainZakat();
    public static void isLogin(boolean b){
        if(b==false){
            main.setVisible(true);           
        }else{
            new index.index().setVisible(true);   
            main.dispose();
        }
    }
    public static void main(String[] args) {
        koneksi k=new koneksi();
        // TODO code application logic here
        isLogin(logged);
        k.konek();
        
    }
    
}

