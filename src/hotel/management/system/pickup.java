package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import  java.sql.*;
import net.proteanit.sql.*;
public class pickup extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    Choice typeofcar;
    JCheckBox available;
pickup(){
    getContentPane().setBackground(Color.white);
    setLayout(null);
    JLabel text = new JLabel("Pickup Service");
    text.setFont(new Font("System",Font.BOLD,20));
    text.setBounds(400,30,250,30);
    add(text);
   
    JLabel roomtype = new JLabel("Type Of Car");
    roomtype.setBounds(50,100,100,20);
    add(roomtype);
    typeofcar = new Choice();
    typeofcar.setBounds(150,100,200,25);
    add(typeofcar);
   
    try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from driver");
        while(rs.next()){
            typeofcar.add(rs.getString("brand"));
        }
        
    }catch(Exception e){
        e.printStackTrace();
    }
  
   
    JLabel l1 = new JLabel("Name");
    l1.setBounds(50,160,100,20);
    add(l1);
    
     
    JLabel l2 = new JLabel("Age");
    l2.setBounds(200,160,100,20);
    add(l2);
     
    JLabel l3 = new JLabel("Gender");
    l3.setBounds(330,160,100,20);
    add(l3); 
    
    JLabel l4 = new JLabel("Brand");
    l4.setBounds(460,160,100,20);
    add(l4);
     
    JLabel l5 = new JLabel("Company");
    l5.setBounds(630,160,100,20);
    add(l5);
    JLabel l6 = new JLabel("Availability");
    l6.setBounds(740,160,100,20);
    add(l6);
    JLabel l7 = new JLabel("Location");
    l7.setBounds(890,160,100,20);
    add(l7);
    
    table = new JTable();
    table.setBounds(0,200,1000,300);
    add(table);
    
    
    try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from driver");
        table.setModel(DbUtils.resultSetToTableModel(rs));
        
    }catch(Exception e){
        System.out.println(e);
    }
   submit = new JButton("Submit");
   submit .setBounds(300,500,120,35);
   submit .setForeground(Color.white);
   submit .setBackground(Color.black);
   submit .addActionListener(this);
   add(submit );
   back = new JButton("Back");
   back .setBounds(500,500,120,35);
   back .setForeground(Color.white);
   back .setBackground(Color.black);
   back .addActionListener(this);
   add(back );
   
    setBounds(300,200,1000,600);
    setVisible(true);
}
public void actionPerformed(ActionEvent ae){
  if(ae.getSource()==submit){
      try{
          String query = "select * from driver where brand = '"+ typeofcar.getSelectedItem()+"'";
          
              Conn c = new Conn();
        
      ResultSet rs;
      rs=c.s.executeQuery(query);
      table.setModel(DbUtils.resultSetToTableModel(rs));
      }catch(Exception e){
          System.out.println(e);
      }
  }else{
    setVisible(false);
    new reception();
  }
}
    public static void main(String[] args) {
      new pickup();
    }
    
}
