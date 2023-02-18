import javax.print.attribute.standard.Destination;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Destinations extends JFrame implements Runnable {

    Thread t;
    JLabel [] label = new JLabel[9];

    public void run(){
        String [] text = new String[]{"JW Marriott Hotel","Madarin Oriental Hotel", "Four Seasons Hotel","Raddisson Blue Hotel","Classio Hotel","The Bay Club Hotel","Breeze Blow Hotel","The Taj Hotel","Happy Morning Motel","River View"};

        try{
            for(int i=0;i<9;i++){
                label[i].setVisible(true);
                Thread.sleep(2500);
                if(i<8){
                    label[i].setVisible(false);
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    Destinations(){
        setBounds(500,200,800,600);

        ImageIcon [] img = new ImageIcon[9];

        Image [] jimg = new Image[9];

        ImageIcon [] kimg = new ImageIcon[9];

        for(int i=0;i<9;i++) {
            img[i] = new ImageIcon("D:\\Travel Management System\\icons\\hotel"+(i+1)+".jpg");
            jimg[i] = img[i].getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
            kimg[i] = new ImageIcon(jimg[i]);
            label[i] = new JLabel(kimg[i]);
            label[i].setBounds(0, 0, 800, 600);
            add(label[i]);
        }

        t = new Thread(this);
        t.start();
        setVisible(true);
    }
    public static void main(String [] args){
        new Destinations();
    }
}

