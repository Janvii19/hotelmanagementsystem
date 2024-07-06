package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class adddriver extends JFrame implements ActionListener{
    JTextField namet,aget,companyt,modelt,locationt;
    JComboBox gendert,availablet;
    JButton adddrivers,cancel;
adddriver(){
    JLabel adddriver = new JLabel(" Add Drivers");
    adddriver.setBounds( 100,20,400,40);
    adddriver.setFont(new Font("Tahoma",Font.BOLD,22));
    add(adddriver);
    
   JLabel name = new JLabel("Name");
   name.setBounds(30,90,200,25);
   name.setFont(new Font("Tahoma",Font.PLAIN,18));
   add(name);
    namet = new JTextField();
    namet.setBounds(190,90,200,30);
    add(namet);
    
   JLabel age= new JLabel("Age");
   age.setBounds(30,150,200,25);
   age.setFont(new Font("Tahoma",Font.PLAIN,18));
    add(age);
    aget = new JTextField();
    aget.setBounds(190,150,200,30);
    add(aget);
    
    JLabel gender = new JLabel("Gender");
   gender.setBounds(30,210,200,25);
    gender.setFont(new Font("Tahoma",Font.PLAIN,18));
    add(gender);
    String valstatus[] = {"Male","Female"};
  gendert = new JComboBox(valstatus);
  gendert.setBounds(190,210,200,30);
  gendert.setBackground(Color.white);
  add(gendert);
    
  JLabel company = new JLabel("Car Company");
  company.setBounds(30,270,200,25);
  company.setFont(new Font("Tahoma",Font.PLAIN,18));
   add(company);
   companyt = new JTextField();
   companyt.setBounds(190,270,200,30);
    add(companyt);
    
    JLabel model = new JLabel("Car Model");
  model.setBounds(30,330,200,25);
  model.setFont(new Font("Tahoma",Font.PLAIN,18));
   add(model);
   modelt = new JTextField();
  modelt.setBounds(190,330,200,30);
    add(modelt);
   
   JLabel available = new JLabel("Available");
   available.setBounds(30,390,200,25);
   available.setFont(new Font("Tahoma",Font.PLAIN,18));
    add(available);
    
   String valtype[] = {"Available","Busy"};
   availablet = new JComboBox(valtype);
   availablet.setBounds(190,390,200,30);
   availablet.setBackground(Color.white);
   add(availablet);
   
  JLabel location = new JLabel("Location");
  location.setBounds(30,450,200,25);
  location.setFont(new Font("Tahoma",Font.PLAIN,18));
   add(location);
   locationt = new JTextField();
locationt.setBounds(190,450,200,30);
    add(locationt);
   
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
    Image i2 = i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(450,30,480,450);
    add(image);
    
   adddrivers = new JButton("Add Driver");
   adddrivers.setBounds(30,520,160,30);
   adddrivers.setForeground(Color.white);
   adddrivers.setBackground(Color.black);
  adddrivers.addActionListener(this);
   add(adddrivers);
    
   cancel = new JButton("Cancel");
   cancel.setBounds(230,520,160,30);
   cancel.setForeground(Color.white);
   cancel.setBackground(Color.black);
   cancel.addActionListener(this);
   add(cancel);
    
    setLayout(null);
    setBounds(500,150,1000,630);
    setVisible(true);
    getContentPane().setBackground(Color.white);
}
public void actionPerformed(ActionEvent ae){
    if(ae.getSource()== adddrivers){
        String name = namet.getText();
        String age = aget.getText();
        String gender = (String)gendert.getSelectedItem();
        String model = modelt.getText();
        String company = companyt.getText();
        String available = (String)availablet.getSelectedItem();
        String location = locationt.getText();
        try{
            Conn c = new Conn();
            String query = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+model+"','"+company+"','"+available+"','"+location+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"driver added sucessfully");
            setVisible(false);
        }catch(Exception e){
           System.out.println(e);
        }
    }else if(ae.getSource()==cancel){
        setVisible(false);
    }
}
    public static void main(String[] args) {
      new adddriver();
    }
    
}
