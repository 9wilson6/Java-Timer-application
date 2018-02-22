
package timerapp;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;


public class TimerApp extends JFrame{

    JLabel promptLabel , countLabel;
    int counter;
    JTextField tx;
    JLabel timerLabel;
    JButton button;
    Timer timer;
    
    public TimerApp(){
    
        setLayout(new GridLayout(2,2,5,5));
        promptLabel = new JLabel("Enter time in Seconds:", SwingConstants.CENTER);
        add(promptLabel);
        tx = new JTextField();
        add(tx);
        button= new JButton("StartTiming");
        add(button);
        
        timerLabel= new JLabel("Waiting....", SwingConstants.CENTER);
        add(timerLabel);
                
        event e = new event();
        button.addActionListener(e);
    }
    public class event implements ActionListener{
    
        public void actionPerformed(ActionEvent e){
        
            int count=Integer.parseInt(tx.getText());
            timerLabel.setText("Time left: "+ count);
            TimerClass tc = new TimerClass(count);
            timer = new Timer(1000, tc);
            timer.start();
        }
    
    }
    public class TimerClass implements ActionListener{
        int counter;
    public TimerClass(int counter){
    this.counter = counter;
    }
    public void actionPerformed(ActionEvent tc){
    
    counter--;
        if (counter>=1) {
            timerLabel.setText("Time left: " + counter);
            
        }else{
        timer.stop();
        timerLabel.setText("Done");
            Toolkit .getDefaultToolkit().beep();
        
        }
    
    }
    
    
    }
    public static void main(String args[]){
        TimerApp ta= new TimerApp();
    ta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ta.pack();
    ta.setVisible(true);
    ta.setLocationRelativeTo(null);
    ta.setResizable(false);
    ta.setTitle("Timmer app");
    
    }
}
