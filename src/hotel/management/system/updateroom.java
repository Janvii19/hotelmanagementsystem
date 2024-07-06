
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import  java.sql.*;
public class updateroom extends JFrame implements ActionListener{
    Choice customert;
    JTextField avlt,roomnot,statust,amtt,pendingt;
    JButton check,update,back;
updateroom(){
    setLayout(null);
     getContentPane().setBackground(Color.white);
    
     JLabel text= new JLabel("Update Room Status");
     text.setFont(new Font("Tahoma",Font.PLAIN,25));
     text.setBounds(30,20,250,30);
     text.setForeground(Color.BLUE);
     add(text);
     
    JLabel id= new JLabel("Customer id");
    id.setBounds(30,80,100,20);
    add(id);
     
    customert = new Choice();
    customert.setBounds(200,80,150,25);
    add(customert);
    try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("Select * from  addcustomer");
        while(rs.next()){
            customert.add(rs.getString("number"));
        }
    }catch(Exception e){
        e.printStackTrace();
    }
     
    JLabel roomno= new JLabel("Room Number");
    roomno.setBounds(30,130,100,20);
    add(roomno);
    roomnot = new JTextField();
    roomnot.setBounds(200,130,150,25);
    add(roomnot);
    
    JLabel name= new JLabel("Availability");
    name.setBounds(30,180,100,20);
    add(name);
     avlt = new JTextField();
   avlt.setBounds(200,180,150,25);
    add(avlt);
    
    JLabel time= new JLabel("Cleaning Status");
    time.setBounds(30,230,100,20);
    add(time);
   statust = new JTextField();
    statust.setBounds(200,230,150,25);
    add(statust);
    
   
     check = new JButton("Check");
   check .setBounds(30,300,100,35);
   check .setForeground(Color.white);
   check .setBackground(Color.black);
   check .addActionListener(this);
   add(check );
    update= new JButton("Update");
   update .setBounds(150,300,100,35);
   update .setForeground(Color.white);
   update .setBackground(Color.black);
   update .addActionListener(this);
   add(update );
    back = new JButton("Back");
   back .setBounds(270,300,100,35);
   back .setForeground(Color.white);
   back .setBackground(Color.black);
   back .addActionListener(this);
   add(back );
   
   ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
    Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(400,50,500,300);
    add(image);
    
    setBounds(300,200,980,450);
     setVisible(true);
    
}
public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==check){
        String id = customert.getSelectedItem();
        String query = "select  *from addcustomer where number ='"+id+"'";
   try{
      Conn c = new Conn();
      ResultSet rs = c.s.executeQuery(query);
      while(rs.next()){
          roomnot.setText(rs.getString("roomno"));
        
      }
      ResultSet rse = c.s.executeQuery("select * from addroom where roomno = '"+roomnot.getText()+"'");
   while(rse.next()){
       avlt.setText(rse.getString("available"));
       statust.setText(rse.getString("cleaningstatus"));
   }
   
   }catch(Exception e){
      e.printStackTrace();
    }
    }else if(ae.getSource()==update){
      String number =  customert.getSelectedItem();
      String roomno = roomnot.getText();
      String available = avlt.getText();
      String status = statust.getText();
     
      try{
          Conn c = new Conn();
          c.s.executeUpdate("update addroom set available = '"+available+"',cleaningstatus = '"+status+"' where roomno = '"+roomno+"'");
     JOptionPane.showMessageDialog(null,"Data Updated Sucessfully");
     setVisible(false);
     new reception();
      }catch(Exception e){
         e.printStackTrace();
      }
    }else{
        setVisible(false);
        new reception();
    }
}
    public static void main(String[] args) {
    new updateroom();
    }
    
}
