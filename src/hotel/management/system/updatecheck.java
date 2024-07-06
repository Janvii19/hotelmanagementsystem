
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import  java.sql.*;
public class updatecheck extends JFrame implements ActionListener{
    Choice customert;
    JTextField namet,roomnot,timet,amtt,pendingt;
    JButton check,update,back;
updatecheck(){
    setLayout(null);
     getContentPane().setBackground(Color.white);
    
     JLabel text= new JLabel("Update Status");
     text.setFont(new Font("Tahoma",Font.PLAIN,20));
     text.setBounds(90,20,200,30);
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
    roomno.setBounds(30,120,100,20);
    add(roomno);
    roomnot = new JTextField();
    roomnot.setBounds(200,120,150,25);
    add(roomnot);
    
    JLabel name= new JLabel("Name");
    name.setBounds(30,160,100,20);
    add(name);
     namet = new JTextField();
   namet.setBounds(200,160,150,25);
    add(namet);
    
    JLabel time= new JLabel("Checkin Time");
    time.setBounds(30,200,100,20);
    add(time);
   timet = new JTextField();
    timet.setBounds(200,200,150,25);
    add(timet);
    
    JLabel amt= new JLabel("Amount Paid");
    amt.setBounds(30,240,100,20);
    add(amt);
     amtt = new JTextField();
    amtt.setBounds(200,240,150,25);
    add(amtt);
    
    JLabel pending= new JLabel("Pending Amount");
    pending.setBounds(30,280,100,20);
    add(pending);
    pendingt = new JTextField();
    pendingt.setBounds(200,280,150,25);
    add(pendingt);
    
     check = new JButton("Check");
   check .setBounds(30,340,100,35);
   check .setForeground(Color.white);
   check .setBackground(Color.black);
   check .addActionListener(this);
   add(check );
    update= new JButton("Update");
   update .setBounds(150,340,100,35);
   update .setForeground(Color.white);
   update .setBackground(Color.black);
   update .addActionListener(this);
   add(update );
    back = new JButton("Back");
   back .setBounds(270,340,100,35);
   back .setForeground(Color.white);
   back .setBackground(Color.black);
   back .addActionListener(this);
   add(back );
   
   ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
    Image i2 = i1.getImage().getScaledInstance(450,300,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(400,50,500,300);
    add(image);
    
    setBounds(300,200,980,500);
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
         namet.setText(rs.getString("name"));
          amtt.setText(rs.getString("deposit"));
          timet.setText(rs.getString("checkintime"));
      }
      ResultSet rse = c.s.executeQuery("select * from addroom where roomno = '"+roomnot.getText()+"'");
   while(rse.next()){
       String price = rse.getString("price");
       int amtpaid = Integer.parseInt(price)-Integer.parseInt(amtt.getText());
       pendingt.setText(""+ amtpaid);
   }
   
   }catch(Exception e){
      e.printStackTrace();
    }
    }else if(ae.getSource()==update){
      String number =  customert.getSelectedItem();
      String roomno = roomnot.getText();
      String name = namet.getText();
      String checkin = timet.getText();
      String deposit = amtt.getText();
      try{
          Conn c = new Conn();
          c.s.executeUpdate("update addcustomer set roomno = '"+roomno+"', name = '"+name+"',checkintime ='"+checkin +"',deposit ='"+deposit+"' where number ='"+number+"'");
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
    new updatecheck();
    }
    
}
