package clock;

import javax.swing.*;
import java.time.Instant;

public class AlarmClock {
    private long startTime;
    private long endTime;
    private int currentcountdown;

    public AlarmClock(int seconds){
        currentcountdown = seconds;
        startTime = Instant.now().getEpochSecond();
        endTime = startTime+seconds;
    }

    private boolean isItTime(){
        return endTime<=Instant.now().getEpochSecond();
    }

    public void startClock(JLabel jlabel) throws InterruptedException{
        while(!isItTime()){
            Thread.sleep(1000);
            currentcountdown--;
            jlabel.setText(getMessage());
        }
    }
    public String getMessage(){
        if (currentcountdown>0) return Integer.toString(currentcountdown);
        else return "ALARM!";
    }
}
