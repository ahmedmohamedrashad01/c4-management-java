package carrefour2018;

import java.sql.*;
import jdk.nashorn.api.tree.BreakTree;

public class Sql {

    public int idIncrement() {
        int id = 1;
        try {

            PreparedStatement ps = null;
            ResultSet rs = null;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "root21485");
            ps = conn.prepareStatement("SELECT MAX (ID) FROM C4");
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1) + 1;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return id;
    }
    
    public void chackPassport(String s){
        AddEmployee2Controller ad = new AddEmployee2Controller();
       s = ad.pass;
        
        try{
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "root21485");
            ps = conn.prepareStatement("SELECT DISTINCT PASSPORT FROM C4");
            
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("Sorry This Employee is Already Registered");
              return;
        }
           
            
            
        }catch(Exception e){
            System.out.println(e.getMessage()); 
        }
    }
}
