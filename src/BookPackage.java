import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookPackage extends JFrame implements ActionListener {

    Choice cpackage;
    JTextField tfpersons;
    JLabel labelusername , labelid, labelnumber, labelphone, labelprice;
    JButton checkprice, bookpackage, back;

    String username;
    BookPackage(String username){
        this.username = username;
        setBounds(350,200,1100,500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,70,100,20);
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(250,70,200,20);
        labelusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelusername);

        JLabel lblpackage = new JLabel("Select Package");
        lblpackage.setBounds(40,110,150,20);
        lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblpackage);

        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250,110,200,20);
        add(cpackage);

        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(40,150,150,25);
        lblpersons.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblpersons);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(250,150,200,25);
        add(tfpersons);

        JLabel lblid = new JLabel("Id");
        lblid.setBounds(40,190,150,25);
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250,190,200,25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(40,230,150,25);
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnumber);

        labelnumber= new JLabel();
        labelnumber.setBounds(250,230,150,25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40,270,200,25);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblphone);

        labelphone= new JLabel();
        labelphone.setBounds(250,270,200,25);
        add(labelphone);

        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40,310,200,25);
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbltotal);

        labelprice = new JLabel();
        labelprice.setBounds(250,310,200,25);
        add(labelprice);

        try{
            Conn c = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }

        }catch (Exception e){
            System.out.println(e);
        }

        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60,380,120,25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(220,380,120,25);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(380,380,120,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon("D:\\Travel Management System\\icons\\bookpackage.jpg");
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(550,50,500,300);
        add(l1);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == checkprice){
            String pack = cpackage.getSelectedItem();
            int cost =0;
            if(pack.equals("Gold Package")){
                cost += 40000;
            }else if(pack.equals("Silver Package")){
                cost += 32000;
            }else{
                cost += 24000;
            }

            int persons = Integer.parseInt(tfpersons.getText());
            cost *= persons;
            labelprice.setText("Rs "+ cost);
        }else if(ae.getSource() == bookpackage){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"' ,'"+cpackage.getSelectedItem()+"','"+tfpersons.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"' ,'"+labelprice.getText()+"')");
                JOptionPane.showMessageDialog(null,"Package Booked Successful");
                setVisible(false);
            }catch (Exception e){
                System.out.println(e);
            }
        }else{
            setVisible(false);
        }
    }

    public static  void main(String [] args){
        new BookPackage("");
    }
}
