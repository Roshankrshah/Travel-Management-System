import javax.print.attribute.standard.Destination;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Dashboard extends JFrame implements ActionListener {

    String username;
    JButton addPersonalDetails,viewPersonalDetails,updatePersonalDetails,checkpackages, bookpackage,viewpackage,viewhotels, destinations, bookhotel,viewbookhotel, payment,calculator,notepad,about,deletePersonalDetails,logout;

    Dashboard(String username){
        this.username = username;
        //setBounds(0,0,1600,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0,0,1600,65);
        p1.setBackground(new Color(0,0,102));
        add(p1);

        ImageIcon i1 = new ImageIcon("D:\\Travel Management System\\icons\\dashboard.png");
        Image i2 = i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5,0,70,70);
        p1.add(icon);

        JLabel heading  = new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(heading);

        logout = new JButton("Logout");
        logout.setBounds(1400,10,100,35);
        logout.setBackground(new Color(0,0,120));
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Tahoma",Font.PLAIN,20));
        logout.addActionListener(this);
        p1.add(logout);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(0,65,300,900);
        p2.setBackground(new Color(0,0,102));
        add(p2);

        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0,0,300,50);
        addPersonalDetails.setBackground(new Color(0,0,120));
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        addPersonalDetails.setMargin(new Insets(0,0,0,40));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0,50,300,50);
        updatePersonalDetails.setBackground(new Color(0,0,120));
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        updatePersonalDetails.setMargin(new Insets(0,0,0,20));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);

        viewPersonalDetails = new JButton("View Personal Details");
        viewPersonalDetails.setBounds(0,100,300,50);
        viewPersonalDetails.setBackground(new Color(0,0,120));
        viewPersonalDetails.setForeground(Color.WHITE);
        viewPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewPersonalDetails.setMargin(new Insets(0,0,0,30));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);

        deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0,150,300,50);
        deletePersonalDetails.setBackground(new Color(0,0,120));
        deletePersonalDetails.setForeground(Color.WHITE);
        deletePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        deletePersonalDetails.setMargin(new Insets(0,0,0,20));
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);

        checkpackages = new JButton("Check Packages");
        checkpackages.setBounds(0,200,300,50);
        checkpackages.setBackground(new Color(0,0,120));
        checkpackages.setForeground(Color.WHITE);
        checkpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        checkpackages.setMargin(new Insets(0,0,0,80));
        checkpackages.addActionListener(this);
        p2.add(checkpackages);

        bookpackage = new JButton("Book Packages");
        bookpackage.setBounds(0,250,300,50);
        bookpackage.setBackground(new Color(0,0,120));
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookpackage.setMargin(new Insets(0,0,0,90));
        bookpackage.addActionListener(this);
        p2.add(bookpackage);

        viewpackage = new JButton("View Packages");
        viewpackage.setBounds(0,300,300,50);
        viewpackage.setBackground(new Color(0,0,120));
        viewpackage.setForeground(Color.WHITE);
        viewpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewpackage.setMargin(new Insets(0,0,0,90));
        viewpackage.addActionListener(this);
        p2.add(viewpackage);

        viewhotels = new JButton("View Hotels");
        viewhotels.setBounds(0,350,300,50);
        viewhotels.setBackground(new Color(0,0,120));
        viewhotels.setForeground(Color.WHITE);
        viewhotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewhotels.setMargin(new Insets(0,0,0,110));
        viewhotels.addActionListener(this);
        p2.add(viewhotels);

        bookhotel = new JButton("Book Hotel");
        bookhotel.setBounds(0,400,300,50);
        bookhotel.setBackground(new Color(0,0,120));
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookhotel.setMargin(new Insets(0,0,0,120));
        bookhotel.addActionListener(this);
        p2.add(bookhotel);

        viewbookhotel = new JButton("View Book Hotel");
        viewbookhotel.setBounds(0,450,300,50);
        viewbookhotel.setBackground(new Color(0,0,120));
        viewbookhotel.setForeground(Color.WHITE);
        viewbookhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewbookhotel.setMargin(new Insets(0,0,0,70));
        viewbookhotel.addActionListener(this);
        p2.add(viewbookhotel);

        destinations = new JButton("Destinations");
        destinations.setBounds(0,500,300,50);
        destinations.setBackground(new Color(0,0,120));
        destinations.setForeground(Color.WHITE);
        destinations.setFont(new Font("Tahoma",Font.PLAIN,20));
        destinations.setMargin(new Insets(0,0,0,100));
        destinations.addActionListener(this);
        p2.add(destinations);

        payment = new JButton("Payment");
        payment.setBounds(0,550,300,50);
        payment.setBackground(new Color(0,0,120));
        payment.setForeground(Color.WHITE);
        payment.setFont(new Font("Tahoma",Font.PLAIN,20));
        payment.setMargin(new Insets(0,0,0,130));
        payment.addActionListener(this);
        p2.add(payment);

        calculator = new JButton("Calculator");
        calculator.setBounds(0,600,300,50);
        calculator.setBackground(new Color(0,0,120));
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font("Tahoma",Font.PLAIN,20));
        calculator.setMargin(new Insets(0,0,0,120));
        calculator.addActionListener(this);
        p2.add(calculator);

        notepad = new JButton("Notepad");
        notepad.setBounds(0,650,300,50);
        notepad.setBackground(new Color(0,0,120));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
        notepad.setMargin(new Insets(0,0,0,130));
        notepad.addActionListener(this);
        p2.add(notepad);

        about = new JButton("About");
        about.setBounds(0,700,300,50);
        about.setBackground(new Color(0,0,120));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tahoma",Font.PLAIN,20));
        about.setMargin(new Insets(0,0,0,150));
        about.addActionListener(this);
        p2.add(about);


        ImageIcon i4 = new ImageIcon("D:\\Travel Management System\\icons\\home.jpg");
        Image i5 = i4.getImage().getScaledInstance(1650,1000,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,1650,1000);
        add(image);

        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setBounds(400,70,1200,70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.PLAIN,55));
        image.add(text);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addPersonalDetails){
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select number from customer where username = '"+username+"'");
                if(rs.next()){
                    JOptionPane.showMessageDialog(null,"Your Details Already Added");
                    new ViewCustomer(username);
                }
                else{
                    new AddCustomer(username);
                }
            }catch(Exception e){
                System.out.println(e);
            }

        }else if(ae.getSource() == viewPersonalDetails){
            new ViewCustomer(username);
        }else if(ae.getSource() == updatePersonalDetails){
            new UpdateCustomer(username);
        }else if(ae.getSource() == checkpackages){
            new CheckPackage();
        }else if(ae.getSource() == bookpackage){
            new BookPackage(username);
        }else if(ae.getSource() == viewpackage){
            new ViewPackage(username);
        }else if(ae.getSource() == viewhotels){
            new CheckHotels();
        }else if(ae.getSource() == destinations){
            new Destinations();
        }else if(ae.getSource() == bookhotel){
            new BookHotel(username);
        }else if(ae.getSource() == viewbookhotel){
            new ViewBookedHotel(username);
        }else if(ae.getSource() == payment){
            new Payment();
        }else if(ae.getSource() == calculator){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource() == notepad){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource() == about){
                new About();
        }else if(ae.getSource() == deletePersonalDetails){
            new DeleteDetails(username);
        }else if(ae.getSource() == logout){
            setVisible(false);
            new Login();
        }
    }

    public static void main(String []args){
        new Dashboard("");
    }
}
