package airlinemanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;


public class BoardingPass extends  JFrame implements ActionListener{
    
    JTextField tfpnr;
    JLabel tfname, tfnationality, lblsrc, lbldest, labelfname, labelfcode,labeldate;
    JButton fetchButton;
    
    
    
    public BoardingPass(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("AIR INDIA");
        heading.setBounds(380, 10, 450, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(heading);
        
        JLabel subheading = new JLabel("Boarding Pass");
        subheading.setBounds(360, 50, 300, 30);
        subheading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        subheading.setForeground(Color.BLUE);
        add(subheading);
        
        JLabel Ibaadhar = new JLabel("PNR  DETAILS");
        Ibaadhar.setBounds(60, 100, 150, 25);
        Ibaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Ibaadhar);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 100, 150, 25);
        add(tfpnr);
        
        fetchButton = new JButton("Enter");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 100, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel Ibname = new JLabel("NAME");
        Ibname.setBounds(60, 140, 130, 25);
        Ibname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Ibname);
        
        tfname = new JLabel();
        tfname.setBounds(220, 140, 150, 25);
        add(tfname);
        
        JLabel Ibnationality = new JLabel("NATIONALITY");
        Ibnationality.setBounds(60, 180, 150, 25);
        Ibnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Ibnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 150, 25);
        add(tfnationality);
        
        JLabel Ibaddress = new JLabel("SRC");
        Ibaddress.setBounds(60, 220, 150, 25);
        Ibaddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Ibaddress);
        
        lblsrc = new JLabel();
        lblsrc.setBounds(220, 220, 150, 25);
        add(lblsrc);
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 260, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220, 260, 150, 25);
        add(labelfname);
        
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(380, 260, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(540, 260, 150, 25);
        add(labelfcode);
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 300, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);
        
        labeldate = new JLabel();
        labeldate.setBounds(220, 300, 150, 25);
        add(labeldate);
        
        JLabel Ibgender = new JLabel("DEST");
        Ibgender.setBounds(380, 220, 150, 25);
        Ibgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Ibgender);
        
        lbldest = new JLabel();
        lbldest.setBounds(540, 220, 150, 25);
        add(lbldest);
        
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/airindia.png"));
         Image i3 = i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
         ImageIcon i2 = new ImageIcon(i3); 
         JLabel lbimage = new JLabel(i2);
         lbimage.setBounds(600, 0, 300, 300);
         add(lbimage);
        
        
        setSize(1000,450);
        setLocation(300,150);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
            String pnr = tfpnr.getText();
            
            try {
                Conn conn = new Conn();
                
                String query = "select * from reservation where PNR = '"+pnr+"'"; 
                
                ResultSet rs = conn.s.executeQuery(query);
                
                if(rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfnationality.setText(rs.getString("nationality"));
                    lblsrc.setText(rs.getString("src"));
                    lbldest.setText(rs.getString("des"));
                    labelfname.setText(rs.getString("flightname"));
                    labelfcode.setText(rs.getString("flightcode"));
                    labeldate.setText(rs.getString("ddate"));
                }else{
                    JOptionPane.showMessageDialog(null, "Please enter correct aadhar");
                }
            }catch(Exception e){
                e.printStackTrace();
        
            }  
        
    }
    
    
   public static void main(String[] arg){
        new BoardingPass();
    }
    
}
