package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import  java.sql.*;
import net.proteanit.sql.*;
public class searchroom extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    JComboBox bedtype;
    JCheckBox available;
searchroom(){
    getContentPane().setBackground(Color.white);
    setLayout(null);
    JLabel text = new JLabel("Search For Room");
    text.setFont(new Font("System",Font.BOLD,20));
    text.setBounds(400,30,250,30);
    add(text);
   
    JLabel roomtype = new JLabel("Bed Type");
    roomtype.setBounds(50,100,100,20);
    add(roomtype);
    bedtype = new JComboBox( new String[]{"Single Bed","Double Bed"});
    bedtype.setBounds(150,100,150,25);
    bedtype.setBackground(Color.white);
    add(bedtype);
    
   available = new JCheckBox("Only Display Available");
   available.setBounds(650,100,150,25);
   available.setBackground(Color.white);
   add(available);
   
    JLabel l1 = new JLabel("Room Number");
    l1.setBounds(50,160,100,20);
    add(l1);
    
     
    JLabel l2 = new JLabel("Availablity");
    l2.setBounds(280,160,100,20);
    add(l2);
     
    JLabel l3 = new JLabel(" Status");
    l3.setBounds(450,160,100,20);
    add(l3); 
    
    JLabel l4 = new JLabel("price");
    l4.setBounds(650,160,100,20);
    add(l4);
     
    JLabel l5 = new JLabel("Bed Type");
    l5.setBounds(850,160,100,20);
    add(l5);
    
    table = new JTable();
    table.setBounds(0,200,1000,300);
    add(table);
    
    
    try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from addroom");
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
          String query1 = "select * from addroom where bedtype = '"+ bedtype.getSelectedItem()+"'";
          String query2 = "select * from addroom where available ='Available' AND bedtype = '"+bedtype.getSelectedItem()+"'";
              Conn c = new Conn();
        
      ResultSet rs;
      if(available.isSelected()){
          rs = c.s.executeQuery(query2);
      }else{
          rs = c.s.executeQuery(query1);
      }
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
      new searchroom();
    }
    
}
