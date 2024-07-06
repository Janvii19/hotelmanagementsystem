package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import  java.sql.*;
import net.proteanit.sql.*;
public class employee extends JFrame implements ActionListener{
    JTable table;
    JButton back;
employee(){
    getContentPane().setBackground(Color.white);
    setLayout(null);
  
    JLabel l1 = new JLabel("Name");
    l1.setBounds(10,10,100,20);
    add(l1);
    
     
    JLabel l2 = new JLabel("Age");
    l2.setBounds(150,10,100,20);
    add(l2);
     
    JLabel l3 = new JLabel("Gender");
    l3.setBounds(270,10,100,20);
    add(l3); 
    
    JLabel l4 = new JLabel("Job");
    l4.setBounds(390,10,100,20);
    add(l4);
     
    JLabel l5 = new JLabel("Salary");
    l5.setBounds(520,10,100,20);
    add(l5);
     
    JLabel l6 = new JLabel("Phone");
    l6.setBounds(630,10,100,20);
    add(l6);
    
    JLabel l7 = new JLabel("Email");
    l7.setBounds(770,10,100,20);
    add(l7);
    
     JLabel l8 = new JLabel("Aadhar");
    l8.setBounds(890,10,100,20);
    add(l8);
    
    table = new JTable();
    table.setBounds(0,40,1000,400);
    add(table);
    
    
    try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from employee");
        table.setModel(DbUtils.resultSetToTableModel(rs));
        
    }catch(Exception e){
        System.out.println(e);
    }
     back = new JButton("Back");
   back .setBounds(420,500,120,35);
   back .setForeground(Color.white);
   back .setBackground(Color.black);
   back .addActionListener(this);
   add(back );
   
    setBounds(300,200,1000,600);
    setVisible(true);
}
public void actionPerformed(ActionEvent ae){
    setVisible(false);
    new reception();
}
    public static void main(String[] args) {
      new employee();
    }
    
}

