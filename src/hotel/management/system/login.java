package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{
    JTextField namet;
     JPasswordField pass;
     JButton login,cancel;
login(){
   
    setLayout(null);
    getContentPane().setBackground(Color.white);
    
     JLabel name = new JLabel("Username");
     name.setBounds(20,40,90,20);
     name.setFont(new Font("System",Font.BOLD,17));
     add(name);
      
      namet = new JTextField();
     namet.setBounds(140,40,140,25);
     add(namet);
             
     JLabel password = new JLabel("Password");
     password.setBounds(20,90,90,20);
     password.setFont(new Font("System",Font.BOLD,17));
     add(password);
     
     pass = new JPasswordField();
     pass.setBounds(140,90,140,25);
     add(pass);
             
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
     Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
     ImageIcon i3 = new ImageIcon(i2);
     JLabel image = new JLabel(i3);
     image.setBounds(350,10,200,200);
     add(image);
     
     login = new JButton("Login");
   login.setBounds(20,160,130,30);
   login.setForeground(Color.white);
   login.setBackground(Color.black);
  login.addActionListener(this);
    add(login);
    
     cancel = new JButton("Cancel");
    cancel.setBounds(160,160,130,30);
   cancel.setForeground(Color.white);
   cancel.setBackground(Color.black);
   cancel.addActionListener(this);
    add(cancel);
    
     setBounds(500,300,600,300);
    setVisible(true);
}
public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==login){
        Conn c = new Conn();
        String user = namet.getText();
        String password = pass.getText();
        try{
            String query = "select * from login where username ='" +user+"' and password ='"+password+"'";
        ResultSet rs = c.s.executeQuery(query);
        if(rs.next()){
            setVisible(false);
            new dashboard().setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null,"Invalid username or password");
            setVisible(false);
        }
        }catch(Exception e){
            System.out.println(e);
        }
    }else if(ae.getSource()==cancel){
        setVisible(false);
    }
}
    public static void main(String[] args) {
       new login(); 
    }
    
}
