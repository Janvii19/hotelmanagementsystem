
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import  java.sql.*;
import java.util.Date;
public class addcustomer extends JFrame implements ActionListener{
    JComboBox idt;
    Choice roomt;
    JRadioButton male,female;
    JTextField namet,numbert, countryt,depositt;
    JLabel timet;
    JButton add,back;
addcustomer(){
   JLabel text = new JLabel("NEW CUSTOMER FORM");
   text.setBounds(70,40,350,45);
   text.setForeground(Color.blue);
  text.setFont(new Font("Tahoma",Font.BOLD,30));
   add(text);
   JLabel id = new JLabel("ID");
   id.setBounds(30,110,60,25);
    id.setFont(new Font("Tahoma",Font.PLAIN,18));
    add(id);
   String valstatus[] = {"Aadhar Card","Passport","Pan Card","Voter Card","Ration Card"};
  idt = new JComboBox(valstatus);
  idt.setBounds(250,110,200,30);
  idt.setBackground(Color.white);
  add(idt);
   JLabel name = new JLabel("Name");
   name.setBounds(30,170,200,25);
  name.setFont(new Font("Tahoma",Font.PLAIN,18));
   add(name);
   namet = new JTextField();
    namet.setBounds(250,170,200,30);
   add(namet);
   JLabel number = new JLabel("Number");
   number.setBounds(30,230,200,25);
   number.setFont(new Font("Tahoma",Font.PLAIN,18));
   add(number);
   numbert = new JTextField();
    numbert.setBounds(250,230,200,30);
     add(numbert);
    JLabel gender = new JLabel("GENDER");
    gender.setBounds(30,290,200,25);
    gender.setFont(new Font("Tahoma",Font.PLAIN,18));
    add(gender);
    male = new JRadioButton("Male");
    male.setBackground(Color.white);
    male.setBounds(250,290,80,30);
    add(male);
     female = new JRadioButton("Female");
     female.setBackground(Color.white);
    female.setBounds(360,290,80,30);
    add(female);
    ButtonGroup gendert = new ButtonGroup();
    gendert.add(male);
    gendert.add(female);
  
    JLabel country = new JLabel("Country");
   country.setBounds(30,350,200,25);
  country.setFont(new Font("Tahoma",Font.PLAIN,18));
   add(country);
  countryt = new JTextField();
    countryt.setBounds(250,350,200,30);
     add(countryt);
     
    JLabel room = new JLabel("Allocated Room Number");
    room.setBounds(30,410,200,25);
    room.setFont(new Font("Tahoma",Font.PLAIN,18));
    add(room);
   roomt  = new Choice();
   try{
       Conn c = new Conn();
       String query ="select * from addroom where available ='Available'";
       ResultSet rs = c.s.executeQuery(query);
       while(rs.next()){
           roomt.add(rs.getString("roomno"));
       }
       
   }catch(Exception e){
       System.out.println(e);
   }
   roomt.setBounds(250,410,200,30);
    add(roomt);
    
  JLabel time = new JLabel("Checkin Time");
  time.setBounds(30,470,200,25);
  time.setFont(new Font("Tahoma",Font.PLAIN,18));
   add(time);
   Date date = new Date();
  timet = new JLabel(""+date);
    timet .setBounds(250,470,250,30);
     timet.setFont(new Font("Tahoma",Font.PLAIN,16));
     add(timet );
   
   JLabel deposit = new JLabel("Deposit");
   deposit.setBounds(30,530,200,25);
   deposit.setFont(new Font("Tahoma",Font.PLAIN,18));
   add(deposit);
    depositt = new JTextField();
    depositt.setBounds(250,530,200,30);
     add(depositt);
  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
    Image i2 = i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(550,150,480,500);
    add(image);
    
    
   add = new JButton("Add");
   add.setBounds(40,595,140,35);
   add.setForeground(Color.white);
   add.setBackground(Color.black);
   add.addActionListener(this);
   add(add);
    
   back = new JButton("Back");
   back .setBounds(260,595,140,35);
   back .setForeground(Color.white);
   back .setBackground(Color.black);
   back .addActionListener(this);
   add(back );
   
    
    setLayout(null);
    setBounds(500,150,1000,730);
    setVisible(true);
    getContentPane().setBackground(Color.white);
    
}
public void actionPerformed(ActionEvent ae){
    if(ae.getSource()== add){
       String id = (String)idt.getSelectedItem();
       String name = namet.getText();
        String number= numbert.getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        }
         String country= countryt.getText();
         String room = (String)roomt.getSelectedItem();
          String time= timet.getText();
           String deposit= depositt.getText();
           try{
               Conn c = new Conn();
                String query1 = "insert into addcustomer values('"+id+"','"+name+"','"+number+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
                String query2 = "update addroom set available ='Occupied' where roomno='"+room+"'";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"customer added sucessfully");
                setVisible(false);
                new reception().setVisible(true);
           }catch(Exception e){
               System.out.println(e);
           }
          
           
    }else if(ae.getSource()== back){
          setVisible(false);
                new reception().setVisible(true);
    }
}
    public static void main(String[] args) {
       new addcustomer();
    }
    
}
