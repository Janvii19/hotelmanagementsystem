package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
public class addemployee extends JFrame implements ActionListener{
    JTextField namet,aget,salaryt,phonet,emailt,aadhart;
    JRadioButton male,female;
    JButton submit;
     JComboBox jobt;
addemployee(){
    setLayout(null);
    JLabel name = new JLabel("NAME");
    name.setBounds(45,50,100,25);
    name.setFont(new Font("System",Font.BOLD,20));
    add(name);
    namet = new JTextField();
    namet.setBounds(165,50,200,30);
    add(namet);
    
    JLabel age = new JLabel("AGE");
    age.setBounds(45,100,100,25);
    age.setFont(new Font("System",Font.BOLD,20));
    add(age);
    aget = new JTextField();
    aget.setBounds(165,100,200,30);
    add(aget);
    
    JLabel gender = new JLabel("GENDER");
    gender.setBounds(45,150,100,25);
    gender.setFont(new Font("System",Font.BOLD,20));
    add(gender);
    male = new JRadioButton("Male");
    male.setBackground(Color.white);
    male.setBounds(165,150,60,25);
    add(male);
     female = new JRadioButton("Female");
     female.setBackground(Color.white);
    female.setBounds(270,150,80,25);
    add(female);
    ButtonGroup gendert = new ButtonGroup();
    gendert.add(male);
    gendert.add(female);
    
    JLabel job = new JLabel("JOB");
    job.setBounds(45,200,100,25);
    job.setFont(new Font("System",Font.BOLD,20));
    add(job);
    String valjob[]={"Front Desk Clerks","Porters","HouseKeeping","Kitchen staff","Room Service","Chefs","Waiter/Waitress","Manager"};
     jobt = new JComboBox(valjob);
    jobt.setBounds(165,200,200,30);
    jobt.setBackground(Color.white);
    add(jobt);
    
    JLabel salary = new JLabel("SALARY");
    salary.setBounds(45,250,100,25);
    salary.setFont(new Font("System",Font.BOLD,20));
    add(salary);
    salaryt = new JTextField();
    salaryt.setBounds(165,250,200,30);
    add(salaryt);
    JLabel phone = new JLabel("PHONE");
    phone.setBounds(45,300,100,25);
    phone.setFont(new Font("System",Font.BOLD,20));
    add(phone);
     phonet = new JTextField();
    phonet.setBounds(165,300,200,30);
    add(phonet);
    JLabel email = new JLabel("EMAIL");
    email.setBounds(45,350,100,25);
    email.setFont(new Font("System",Font.BOLD,20));
    add(email);
     emailt = new JTextField();
     emailt.setBounds(165,350,200,30);
    add( emailt);
    JLabel aadhar = new JLabel("AADHAR");
    aadhar.setBounds(45,400,100,25);
    aadhar.setFont(new Font("System",Font.BOLD,20));
    add(aadhar);
     aadhart = new JTextField();
   aadhart.setBounds(165,400,200,30);
    add(aadhart);
   
    submit = new JButton("Submit");
    submit.setBounds(165,470,200,30);
    submit.setBackground(Color.black);
    submit.setForeground(Color.white);
    submit.setFont(new Font("system",Font.BOLD,20));
    submit.addActionListener(this);
    add(submit);
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
     Image i2 = i1.getImage().getScaledInstance(490,600,Image.SCALE_DEFAULT);
     ImageIcon i3 = new ImageIcon(i2);
     JLabel image = new JLabel(i3);
     image.setBounds(400,1,450,750);
     add(image);
     
    
    setBounds(200,100,900,600);
    setVisible(true);
    getContentPane().setBackground(Color.white);
}
public void actionPerformed(ActionEvent ae){
    
        String name = namet.getText();
         String age= aget.getText();
         String salary = salaryt.getText();
         String phone = phonet.getText();
         String email = emailt.getText();
         String aadhar = aadhart.getText();
          if(name.equals("")){
              JOptionPane.showMessageDialog(null,"Name is required");
              return;
          }
         String gender = null;
         if(male.isSelected()){
             gender ="Male";
         }else if(female.isSelected()){
             gender = "female";
         }
          String job = (String) jobt.getSelectedItem();
          try{
              Conn c = new Conn();
              
              String query = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
          c.s.executeUpdate(query);
          JOptionPane.showMessageDialog(null,"EMPLOYEE ADDED SUCESSFULLY");
          setVisible(false);
          }catch(Exception e){
              System.out.println(e);
          }
    
}
    public static void main(String[] args) {
new addemployee();
    }
    
}
