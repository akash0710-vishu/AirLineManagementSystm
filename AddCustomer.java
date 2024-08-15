package airlinemanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class AddCustomer extends  JFrame implements ActionListener{
    
    JTextField tfname, tfphone,tfaadhar,tfnationality,tfaddress;
    JRadioButton rbmale,rbfemale;
    
    public AddCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(220, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel Ibname = new JLabel("Name");
        Ibname.setBounds(60, 80, 150, 25);
        Ibname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Ibname);
        
        tfname = new JTextField();
        tfname.setBounds(220, 80, 150, 25);
        add(tfname);
        
        JLabel Ibnationality = new JLabel("Nationality");
        Ibnationality.setBounds(60, 130, 150, 25);
        Ibnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Ibnationality);
        
        tfnationality = new JTextField();
        tfnationality.setBounds(220, 130, 150, 25);
        add(tfnationality);
        
        JLabel Ibaadhar = new JLabel("Aadhar Number");
        Ibaadhar.setBounds(60, 180, 150, 25);
        Ibaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Ibaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 180, 150, 25);
        add(tfaadhar);
        
        JLabel Ibaddress = new JLabel("Address");
        Ibaddress.setBounds(60, 230, 150, 25);
        Ibaddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Ibaddress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220, 230, 150, 25);
        add(tfaddress);
        
        JLabel Ibgender = new JLabel("Gender");
        Ibgender.setBounds(60, 280, 150, 25);
        Ibgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Ibgender);
        
        ButtonGroup gendergroup = new ButtonGroup();
        
       
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(220, 280, 70, 25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300, 280, 70, 25);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        
        JLabel Ibphone = new JLabel("Phone");
        Ibphone.setBounds(60, 330, 150, 25);
        Ibphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Ibphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        add(tfphone);
        
        JButton save = new JButton("SAVE");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(220, 380, 150, 30);
        save.addActionListener(this);
        add(save);
        
        
         ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
         JLabel lbimage = new JLabel(i2);
         lbimage.setBounds(450, 80, 280, 400);
         add(lbimage);
        
        
        
        
        
        
        
        setSize(900,600);
        setLocation(300,150);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String gender;
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String aadhar = tfaadhar.getText();
        if(rbmale.isSelected()){
           gender = "Male";
        }else{
           gender = "female";
        }
        try{
            Conn conn = new Conn();
            
            String query = "insert into passenger values('"+name+"', '"+nationality+"', '"+phone+"', '"+address+"', '"+aadhar+"', '"+gender+"')";
            
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
               
            setVisible(false);
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    
   public static void main(String[] arg){
        new AddCustomer();
    }
    
}
