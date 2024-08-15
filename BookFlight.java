package airlinemanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;


public class BookFlight extends  JFrame implements ActionListener{
    
    JTextField tfaadhar;
    JLabel tfname, tfnationality, tfaddress, labelgender, labelfname, labelfcode;
    JButton bookflight,fetchButton,flight;
    Choice source,destination;
    JDateChooser dcdate;
    
    public BookFlight(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(420, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel Ibaadhar = new JLabel("Aadhar");
        Ibaadhar.setBounds(60, 80, 150, 25);
        Ibaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Ibaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 80, 150, 25);
        add(tfaadhar);
        
        fetchButton = new JButton("Fetch User");
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
        
        JLabel Ibnationality = new JLabel("Nationality");
        Ibnationality.setBounds(60, 180, 150, 25);
        Ibnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Ibnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 150, 25);
        add(tfnationality);
        
        JLabel Ibaddress = new JLabel("Address");
        Ibaddress.setBounds(60, 230, 170, 25);
        Ibaddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Ibaddress);
        
        tfaddress = new JLabel();
        tfaddress.setBounds(220, 230, 170, 25);
        add(tfaddress);
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 430, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220, 430, 150, 25);
        add(labelfname);
        
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(60, 480, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(220, 480, 150, 25);
        add(labelfcode);
        
        JLabel lbldate = new JLabel("Date of Travel");
        lbldate.setBounds(60, 530, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(220, 530, 150, 25);
        add(dcdate);
        
        JLabel Ibgender = new JLabel("Gender");
        Ibgender.setBounds(60, 280, 150, 25);
        Ibgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Ibgender);
        
        labelgender = new JLabel("Gender");
        labelgender.setBounds(220, 280, 150, 25);
        add(labelgender);
        
        JLabel Ibsource = new JLabel("Source");
        Ibsource.setBounds(60, 330, 150, 25);
        Ibsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Ibsource);
        
        source = new Choice();
        source.setBounds(220, 330, 150, 25);
        add(source);
        
        JLabel Ibdest = new JLabel("Destination");
        Ibdest.setBounds(60, 380, 150, 25);
        Ibdest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Ibdest);
        
        destination = new Choice();
        destination.setBounds(220, 380, 150, 25);
        add(destination);
        
        try{
            Conn c = new Conn();
            String query = "select * from flight";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        flight = new JButton("Fetch Flights");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(380, 380, 120, 25);
        flight.addActionListener(this);
        add(flight);
        
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.jpg"));
         Image i3 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
         ImageIcon i2 = new ImageIcon(i3); 
         JLabel lbimage = new JLabel(i2);
         lbimage.setBounds(550, 80, 500, 410);
         add(lbimage);
        
        
        bookflight = new JButton("Book Flight");
        bookflight.setBackground(Color.BLACK);
        bookflight.setForeground(Color.WHITE);
        bookflight.setBounds(220, 580, 150, 25);
        bookflight.addActionListener(this);
        add(bookflight);
        
        
        
        
        setSize(1100,700);
        setLocation(200,50);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == fetchButton){
            String aadhar = tfaadhar.getText();
            
            try {
                Conn conn = new Conn();
                
                String query = "select * from passenger where aadhar = '"+aadhar+"'"; 
                
                ResultSet rs = conn.s.executeQuery(query);
                
                if(rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfnationality.setText(rs.getString("nationality"));
                    tfaddress.setText(rs.getString("address"));
                    labelgender.setText(rs.getString("gender"));
                }else{
                    JOptionPane.showMessageDialog(null, "Please enter correct aadhar");
                }
            }catch(Exception e){
                e.printStackTrace();
        
            }
        }else if(ae.getSource() == flight){
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();
            
            try {
                Conn conn = new Conn();
                
                String query = "select * from flight where source = '"+src+"' and destination = '"+dest+"'"; 
                
                ResultSet rs = conn.s.executeQuery(query);
                
                if(rs.next()){
                    labelfname.setText(rs.getString("f_name"));
                    labelfcode.setText(rs.getString("f_code"));
                }else{
                    JOptionPane.showMessageDialog(null, "No Flights Found");
                }
            }catch(Exception e){
                e.printStackTrace();
        
            }
        }else {
            Random random = new Random();
            
            String aadhar = tfaadhar.getText();
            String name = tfname.getText();
            String nationality = tfnationality.getText();
            String flightname = labelfname.getText(); 
            String flightcode = labelfcode.getText();
            String src = source.getSelectedItem();
            String des = destination.getSelectedItem();
            String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            
            try {
                 Conn conn = new Conn();
                
                 String query = "insert into reservation values('PNR-"+random.nextInt(1000000)+"', 'TIC-"+random.nextInt(10000)+"', '"+aadhar+"','"+name+"','"+nationality+"','"+flightname+"','"+flightcode+"','"+src+"','"+des+"', '"+ddate+"')";       
           
                
                  conn.s.executeUpdate(query);
              
                  JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");
                
            }catch(Exception e){
                e.printStackTrace();
        
            }
        }
    }
    
    
   public static void main(String[] arg){
        new BookFlight();
    }
    
}


