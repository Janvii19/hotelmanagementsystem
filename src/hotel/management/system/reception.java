package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class reception extends JFrame implements ActionListener {
    JButton form,room,department,employee,customer,manager,checkout,status,roomstatus,pickup,search,logout;
reception(){
 
  form = new JButton("New Customer Form");
   form.setBounds(10,40,220,30);
   form.setForeground(Color.white);
   form.setBackground(Color.black);
   form.addActionListener(this);
   add(form);
   room = new JButton("Rooms");
   room.setBounds(10,80,220,30);
   room.setForeground(Color.white);
   room.setBackground(Color.black);
   room.addActionListener(this);
   add(room);
   department = new JButton("Department");
   department.setBounds(10,120,220,30);
   department.setForeground(Color.white);
   department.setBackground(Color.black);
   department.addActionListener(this);
   add(department);
   employee = new JButton("All Employee");
   employee.setBounds(10,160,220,30);
   employee.setForeground(Color.white);
   employee.setBackground(Color.black);
   employee.addActionListener(this);
   add(employee);
   customer = new JButton("Customer Info");
   customer.setBounds(10,200,220,30);
   customer.setForeground(Color.white);
   customer.setBackground(Color.black);
   customer.addActionListener(this);
   add(customer);
   manager = new JButton("Manager Info");
   manager.setBounds(10,240,220,30);
   manager.setForeground(Color.white);
   manager.setBackground(Color.black);
   manager.addActionListener(this);
   add(manager);
    checkout= new JButton("Checkout");
   checkout.setBounds(10,280,220,30);
   checkout.setForeground(Color.white);
   checkout.setBackground(Color.black);
   checkout.addActionListener(this);
   add(checkout);
   status = new JButton("Update Status");
   status.setBounds(10,320,220,30);
   status.setForeground(Color.white);
   status.setBackground(Color.black);
   status.addActionListener(this);
   add(status);
   roomstatus = new JButton("Update Room Status");
   roomstatus.setBounds(10,360,220,30);
   roomstatus.setForeground(Color.white);
   roomstatus.setBackground(Color.black);
   roomstatus.addActionListener(this);
   add(roomstatus);
   pickup = new JButton("Pickup  Service");
   pickup.setBounds(10,400,220,30);
   pickup.setForeground(Color.white);
   pickup.setBackground(Color.black);
   pickup.addActionListener(this);
   add(pickup);
   search = new JButton("Search Room");
  search.setBounds(10,440,220,30);
   search.setForeground(Color.white);
   search.setBackground(Color.black);
   search.addActionListener(this);
   add(search);
   logout = new JButton("Logout");
   logout.setBounds(10,480,220,30);
   logout.setForeground(Color.white);
   logout.setBackground(Color.black);
   logout.addActionListener(this);
   add(logout);
    
   ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
    Image i2 = i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(260,40,520,480);
    add(image);
   
  
    setLayout(null);
    setBounds(500,150,840,620);
    setVisible(true);
    getContentPane().setBackground(Color.white);
}
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==form){
    new addcustomer().setVisible(true);
}else if(ae.getSource()==room){
    new room().setVisible(true);
}else if(ae.getSource()==department){
    new department().setVisible(true);
}else if(ae.getSource()==employee){
    new employee().setVisible(true);
}else if(ae.getSource()== manager){
    new  managerinfo().setVisible(true);
}else if(ae.getSource()== customer){
    new  customerinfo().setVisible(true);
}else if(ae.getSource()== search){
    new  searchroom().setVisible(true);
}else if(ae.getSource()== status){
    new  updatecheck().setVisible(true);
}else if(ae.getSource()== roomstatus){
    new  updateroom().setVisible(true);
}else if(ae.getSource()== pickup){
    new  pickup().setVisible(true);
}else if(ae.getSource()== checkout){
    new  checkout().setVisible(true);
}else{
    setVisible(false);
}
}
    public static void main(String[] args) {
    new reception();
    }
    
}
