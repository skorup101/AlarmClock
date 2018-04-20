package UI;

import clock.AlarmClock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlarmClockUI extends JFrame {
    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;
    private JButton startButton;
    private JLabel countDownLabel;
    private JLabel textlabel;
    private JTextField inputTextField;
    private FrameLocalization fl;
    private AlarmClock alarmClock;
    private int alarmTime;

    public AlarmClockUI() {
        super("Alarm Clock");
        setSize(WIDTH, HEIGHT);
        fl = new UI.FrameLocalization(WIDTH, HEIGHT);
        setLocation(fl.x, fl.y);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        startButton = new StartButton("START");

        countDownLabel = new JLabel(Integer.toString(alarmTime));
        countDownLabel.setHorizontalAlignment(JLabel.CENTER);

        inputTextField = new JTextField();

        textlabel = new JLabel("COUNTDOWN:");

        add(textlabel);
        add(countDownLabel);
        add(inputTextField);
        add(startButton);
        setVisible(true);
    }

    private class StartButton extends JButton implements ActionListener {
        private StartButton(String text) {
            super(text);
            addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(inputTextField.getText().equals("")) alarmTime=10;
            else alarmTime=Integer.parseInt(inputTextField.getText());

            new Thread(()->{
                alarmClock = new AlarmClock(alarmTime);
                while(!alarmClock.isItTime()){
                    countDownLabel.setText(alarmClock.getMessage());
                }
            }).start();
        }
    }
}
