
package etykieta.zegarek;
/**
 * author pawelstradomski
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
        
public class EtykietaZegarek extends JFrame
{
    public EtykietaZegarek()
    {
        super("Etykieta.Zegarek");
        this.setBounds(600, 300, 300, 300);
        this.setDefaultCloseOperation(3);
        initComponent();
        
    }
    public void initComponent()
    {
        this.getContentPane().add(panel);
        panel.add(etykieta);
        panel.add(czas);
        
        ActionListener stoper = new Zegar();
        Timer zegar = new Timer(1000, stoper);
        zegar.start();
    }
    JPanel panel = new JPanel();
    JLabel etykieta = new JLabel("czas");
    JLabel czas = new JLabel();
    
    private class Zegar implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
           GregorianCalendar kalendarzyk = new GregorianCalendar();
//           int h = kalendarzyk.get(Calendar.HOUR_OF_DAY);
//           int min = kalendarzyk.get(Calendar.MINUTE);
//           int sec = kalendarzyk.get(Calendar.SECOND);
//           czas.setText(""+ h+" "+ min+" "+ sec); //wpisanie"" spowodowalo oszukanie ze string+int
           
           //2sposob zamiana int na String
           String   h = ""+kalendarzyk.get(Calendar.HOUR_OF_DAY);
           String min = ""+kalendarzyk.get(Calendar.MINUTE);
           String sec = ""+kalendarzyk.get(Calendar.SECOND);
           
           if(Integer.parseInt(h)<10)//rzutujemy nasz String znowu na int aby sprawdzic warunek
               h="0"+h;
           if(Integer.parseInt(min)<10)
               min="0"+min;
           if(Integer.parseInt(sec)<10)
               sec="0"+sec;
           czas.setText(h+":"+ min+":"+ sec); 
           
        }
        
    }

    
    public static void main(String[] args) {
        new EtykietaZegarek().setVisible(true);
        
    }
    
}
