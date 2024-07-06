package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class addrooms extends JFrame implements ActionListener{
    JTextField roomt,pricet;
    JComboBox typet, statust,availablet;
    JButton addroom,cancel;
addrooms(){
    JLabel addrooms = new JLabel(" Add Rooms");
    addrooms.setBounds( 100,20,400,40);
    addrooms.setFont(new Font("Tahoma",Font.BOLD,22));
    add(addrooms);
    
   JLabel room = new JLabel("Room Number");
   room.setBounds(30,90,200,25);
    room.setFont(new Font("Tahoma",Font.PLAIN,18));
    add(room);
    roomt = new JTextField();
    roomt.setBounds(190,90,200,30);
    add(roomt);
    
    JLabel available = new JLabel("Available");
   available.setBounds(30,150,200,25);
    available.setFont(new Font("Tahoma",Font.PLAIN,18));
    add(available);
     String valavailable[] = {"Available","Occupied"};
   availablet = new JComboBox(valavailable);
   availablet.setBounds(190,150,200,30);
   availablet.setBackground(Color.white);
   add(availablet);
    
     JLabel status = new JLabel("Cleaning Status");
   status.setBounds(30,210,200,25);
    status.setFont(new Font("Tahoma",Font.PLAIN,18));
    add(status);
    String valstatus[] = {"Cleaned","Dirty"};
   statust = new JComboBox(valstatus);
   statust.setBounds(190,210,200,30);
   statust.setBackground(Color.white);
   add(statust);
    
   JLabel price = new JLabel("Price");
  price.setBounds(30,270,200,25);
   price.setFont(new Font("Tahoma",Font.PLAIN,18));
   add(price);
   pricet = new JTextField();
    pricet.setBounds(190,270,200,30);
    add(pricet);
   
    JLabel type = new JLabel("Bed Type");
   type.setBounds(30,330,200,25);
    type.setFont(new Font("Tahoma",Font.PLAIN,18));
    add(type);
    
    String valtype[] = {"Single Bed","Double Bed"};
   typet = new JComboBox(valtype);
   typet.setBounds(190,330,200,30);
   typet.setBackground(Color.white);
   add(typet);
   
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
    Image i2 = i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(450,20,480,350);
    add(image);
    
   addroom = new JButton("Add Room");
   addroom.setBounds(30,400,160,30);
   addroom.setForeground(Color.white);
   addroom.setBackground(Color.black);
   addroom.addActionListener(this);
   add(addroom);
    
   cancel = new JButton("Cancel");
   cancel.setBounds(230,400,160,30);
   cancel.setForeground(Color.white);
   cancel.setBackground(Color.black);
   cancel.addActionListener(this);
   add(cancel);
    
    setLayout(null);
    setBounds(400,300,1000,500);
    setVisible(true);
    getContentPane().setBackground(Color.white);
}
  public void actionPerformed(ActionEvent ae){
      if(ae.getSource()== addroom){
          String roomno = roomt.getText();
          String available = (String) availablet.getSelectedItem();
          String cleaning = (String) statust.getSelectedItem();
          String price = pricet.getText();
          String type = (String) typet.getSelectedItem();
          try{
             Conn c = new Conn(); 
             String query = "insert into addroom values('"+roomno+"','"+available+"','"+cleaning+"','"+price+"','"+type+"')";
             c.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null,"Room added Sucesssfully");
             setVisible(false);
          }catch(Exception e){
              System.out.println(e);
          }
      }else if(ae.getSource()==cancel){
          setVisible(false);
      }
  }
    public static void main(String[] args) {
       new addrooms();
    }
    
}
