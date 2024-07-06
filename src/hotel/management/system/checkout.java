
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import  java.sql.*;
import java.util.Date;

public class checkout extends JFrame implements ActionListener {
    Choice idt;
    JLabel timet,roomnot,intime;
  JButton checkout,back;
checkout(){
     setLayout(null);
     JLabel text = new JLabel("Checkout");
     text.setFont(new Font("Tahoma",Font.BOLD,23));
     text.setBounds(90,50,160,20);
     text.setForeground(Color.BLUE);
     add(text);
     
     JLabel id= new JLabel("Customer id");
    id.setBounds(30,110,100,20);
    add(id);
    idt = new Choice();
    idt.setBounds(160,110,190,25);
    add(idt);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
    Image i2 = i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(360,110,20,20);
    add(image);
   
    JLabel roomno= new JLabel("Room Number");
    roomno.setBounds(30,160,100,20);
    add(roomno);
    roomnot = new JLabel();
     roomnot.setBounds(160,160,190,25);
     add(roomnot);
     
    JLabel time= new JLabel("Checkin Time");
    time.setBounds(30,220,100,20);
    add(time);
    intime = new JLabel();
     intime.setBounds(160,220,190,25);
     add(intime);
     
    JLabel outtime= new JLabel("Checkout Time");
    outtime.setBounds(30,280,100,20);
    add(outtime);
     Date date = new Date();
     timet = new JLabel(""+date);
     timet.setBounds(160,280,190,25);
     add(timet);
     
     checkout= new JButton("Checkout");
   checkout .setBounds(30,340,140,35);
   checkout .setForeground(Color.white);
   checkout .setBackground(Color.black);
   checkout .addActionListener(this);
   add(checkout );
    back = new JButton("Back");
   back .setBounds(190,340,140,35);
   back .setForeground(Color.white);
   back .setBackground(Color.black);
   back .addActionListener(this);
   add(back );
   try{
      Conn c = new Conn();
      ResultSet rs = c.s.executeQuery("select * from addcustomer ");
      while(rs.next()){
          idt.add(rs.getString("number"));
          roomnot.setText(rs.getString("roomno"));
          intime.setText(rs.getString("checkintime"));
      }
    }catch(Exception e){
        e.printStackTrace();
    }
     ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
    Image i5 = i4.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
    ImageIcon i6 = new ImageIcon(i5);
    JLabel im = new JLabel(i6);
    im.setBounds(410,80,500,300);
    add(im);
   
     
     getContentPane().setBackground(Color.white);
    setBounds(300,200,980,500);
 setVisible(true);
    
}
public void actionPerformed(ActionEvent ae){
    if(ae.getSource()== checkout){
        String query1 = "delete from addcustomer where number ='"+idt.getSelectedItem()+"'";
        String query2 = "update addroom set available ='Available' where roomno = '"+roomnot.getText()+"'";
    try{
        Conn c = new Conn();
        c.s.executeUpdate(query1);
        c.s.executeUpdate(query2);
        JOptionPane.showMessageDialog(null," Checkout Done");
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
      new checkout();
    }
    
}
