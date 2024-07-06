
package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
public class HotelManagementSystem extends JFrame implements ActionListener{
    JButton next;
HotelManagementSystem(){
    
    setLayout(null);
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
    JLabel image = new JLabel(i1);
    image.setBounds(0,0,1366,565);
    add(image);
    
    JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
    text.setBounds(50,470,850,35);
    text.setForeground(new Color(255, 223, 0));
    text.setFont(new Font("System",Font.BOLD,45));
    image.add(text);
    
     next = new JButton("NEXT");
    next.setBounds(1250,470,80,30);
    next.setForeground(Color.black);
    next.setBackground(new Color(255, 223, 0));
    next.addActionListener(this);
    image.add(next);
   
    setSize(1366,565);
    setLocation(100,100);
    setVisible(true);
    while(true){
        text.setVisible(false);
        try{
           Thread.sleep(500);
        }catch(Exception e){
            e.printStackTrace();
        }
        text.setVisible(true);
        try{
           Thread.sleep(500);
        }catch(Exception e){
            e.printStackTrace();
        }
        text.setVisible(true);
    }
    
    
}
public void actionPerformed(ActionEvent e){
        if(e.getSource()==next){
            setVisible(false);
            new login().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
    
}
