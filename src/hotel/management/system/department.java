package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import  java.sql.*;
import net.proteanit.sql.*;
public class department extends JFrame implements ActionListener{
    JTable table;
    JButton back;
department(){
    getContentPane().setBackground(Color.white);
    setLayout(null);
    
    
    JLabel l1 = new JLabel("Department");
    l1.setBounds(180,10,100,20);
    add(l1);
    
     
    JLabel l2 = new JLabel("Budget");
    l2.setBounds(430,10,100,20);
    add(l2);
     
  
    
    table = new JTable();
    table.setBounds(0,50,700,350);
    add(table);
    
    
    try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from department");
        table.setModel(DbUtils.resultSetToTableModel(rs));
        
    }catch(Exception e){
        System.out.println(e);
    }
     back = new JButton("Back");
   back .setBounds(280,380,120,35);
   back .setForeground(Color.white);
   back .setBackground(Color.black);
   back .addActionListener(this);
   add(back );
   
    setBounds(400,200,700,480);
    setVisible(true);
}
public void actionPerformed(ActionEvent ae){
    setVisible(false);
    new reception();
}
    public static void main(String[] args) {
      new department();
    }
    
}
