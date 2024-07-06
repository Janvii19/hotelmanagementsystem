package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class dashboard extends JFrame implements ActionListener {
dashboard(){
    setLayout(null);
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
     Image i2 = i1.getImage().getScaledInstance(1950,1050,Image.SCALE_DEFAULT);
     ImageIcon i3 = new ImageIcon(i2);
     JLabel image = new JLabel(i3);
     image.setBounds(0,0,1950,1050);
     add(image);
     JLabel taj = new JLabel("THE TAJ GROUP WELCOMES YOU");
     taj.setFont((new Font("Tahoma",Font.PLAIN,45)));
     taj.setForeground(Color.white);
     taj.setBounds(490,200,1000,40);
     image.add(taj);
     JMenuBar mb = new JMenuBar();
      mb.setBounds(0,0,1950,40);
      image.add(mb);

      JMenu  hotel = new JMenu("Hotel Management");
      hotel.setFont(new Font("Raleway",Font.BOLD,12));
      hotel.setForeground(Color.blue);
     mb.add(hotel);
         
     JMenuItem reception = new JMenuItem("RECEPTION");
     reception.addActionListener(this);
     hotel.add(reception);
     
      JMenu admin = new JMenu("Admin");
      admin.setFont(new Font("Raleway",Font.BOLD,12));
      admin.setForeground(Color.blue);
     mb.add(admin);
     
     JMenuItem employee= new JMenuItem("ADD EMPLOYEE");
    employee.addActionListener(this);
     admin.add(employee);
     
     JMenuItem room = new JMenuItem("ADD ROOMS");
     room.addActionListener(this);
     admin.add(room);
     
     JMenuItem driver= new JMenuItem("ADD DRIVER");
     driver.addActionListener(this);
     admin.add(driver);
     
     setBounds(0,0,1950,1050);
    setVisible(true);
}
public void actionPerformed(ActionEvent ae){
    if(ae.getActionCommand().equals("ADD EMPLOYEE")){
        new addemployee().setVisible(true);
    }else if(ae.getActionCommand().equals("ADD ROOMS")){
        new addrooms();
    }else if(ae.getActionCommand().equals("ADD DRIVER")){
        new adddriver();
    }else if(ae.getActionCommand().equals("RECEPTION")){
        new reception();
    }
}
    
    public static void main(String[] args) {
        new dashboard();
    }
    
}
