package airlinemanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;



public class Cancel extends  JFrame implements ActionListener{
    
    JTextField tfpnr;
    JLabel tfname, cancellationno, lblfcode, lbldateoftravel;
    JButton fetchButton,flight;
    
    public Cancel(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        Random random = new Random();
        
        JLabel heading = new JLabel("CANCELLATION");
        heading.setBounds(180, 20, 250, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/cancel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(470, 120, 250, 250);
        add(image);
        
        JLabel Ibaadhar = new JLabel("PNR Number");
        Ibaadhar.setBounds(60, 80, 150, 25);
        Ibaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Ibaadhar);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 80, 150, 25);
        add(tfpnr);
        
        fetchButton = new JButton("Show Details");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 80, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel Ibname = new JLabel("Name");
        Ibname.setBounds(60, 130, 130, 25);
        Ibname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Ibname);
        
        tfname = new JLabel();
        tfname.setBounds(220, 130, 150, 25);
        add(tfname);
        
        JLabel Ibnationality = new JLabel("Cancellation No");
        Ibnationality.setBounds(60, 180, 150, 25);
        Ibnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Ibnationality);
        
        cancellationno = new JLabel("" + random.nextInt(1000000));
        cancellationno.setBounds(220, 180, 150, 25);
        add(cancellationno);
        
        JLabel Ibaddress = new JLabel("Flight Code");
        Ibaddress.setBounds(60, 230, 170, 25);
        Ibaddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Ibaddress);
        
        lblfcode = new JLabel();
        lblfcode.setBounds(220, 230, 170, 25);
        add(lblfcode);
        
        JLabel Ibgender = new JLabel("Date");
        Ibgender.setBounds(60, 280, 150, 25);
        Ibgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Ibgender);
        
        lbldateoftravel = new JLabel();
        lbldateoftravel.setBounds(220, 280, 150, 25);
        add(lbldateoftravel);
        
        
        flight = new JButton("Cancel");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(220, 330, 120, 25);
        flight.addActionListener(this);
        add(flight);
        
        setSize(800,450);
        setLocation(350,150);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == fetchButton){
            String pnr = tfpnr.getText();
            
            try {
                Conn conn = new Conn();
                
                String query = "select * from reservation where PNR = '"+pnr+"'"; 
                
                ResultSet rs = conn.s.executeQuery(query);
                
                if(rs.next()){
                    tfname.setText(rs.getString("name"));
                    lblfcode.setText(rs.getString("flightcode"));
                    lbldateoftravel.setText(rs.getString("ddate"));
                }else{
                    JOptionPane.showMessageDialog(null, "Please enter correct PNR");
                }
            }catch(Exception e){
                e.printStackTrace();
        
            }
        }else if(ae.getSource() == flight){
            String name = tfname.getText();
            String pnr = tfpnr.getText();
            String cancelno = cancellationno.getText();
            String fcode = lblfcode.getText();
            String date = lbldateoftravel.getText();
            
            
            try {
                Conn conn = new Conn();
                
                String query = "insert into cancel values('"+pnr+"', '"+name+"', '"+cancelno+"', '"+fcode+"', '"+date+"')"; 
                
                
                conn.s.executeUpdate("delete from reservation where PNR = '"+pnr+"'");
                
                
                JOptionPane.showMessageDialog(null, "Ticket Cancelled");
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
        
            }
        
        }
    }
    
    
   public static void main(String[] arg){
        new Cancel();
    }
    
}



