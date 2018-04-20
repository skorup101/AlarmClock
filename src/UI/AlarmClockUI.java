package UI;

import clock.AlarmClock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlarmClockUI extends JFrame {
    private static final int WIDTH=300;
    private static final int  HEIGHT=300;
    private JButton startButton;
    private JLabel countDownLabel;
    private FrameLocalization fl;
    private  AlarmClock alarmClock;
    private int alarmTime;

    public AlarmClockUI(int alarmTime){
        super("Alarm Clock");
        setSize(WIDTH,HEIGHT);
        fl = new UI.FrameLocalization(WIDTH,HEIGHT);
        setLocation(fl.x,fl.y);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,1));
        this.alarmTime= alarmTime;

        startButton = new StartButton("START");
        countDownLabel = new JLabel(Integer.toString(alarmTime));
        countDownLabel.setHorizontalAlignment(JLabel.CENTER);

        add(countDownLabel);
        add(startButton);
        setVisible(true);
    }

    class StartButton extends JButton implements ActionListener{
        public StartButton(String text) {
            super(text);
            addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            alarmClock = new AlarmClock(alarmTime);
            try {
                alarmClock.startClock(countDownLabel);
            }catch (Exception ex){
                ex.printStackTrace();
            }
            }
        }
    }
