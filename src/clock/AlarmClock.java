package clock;

import java.time.Instant;

public class AlarmClock {
    private long startTime;
    private long endTime;
    private long difference;

    public AlarmClock(long seconds){
        difference = seconds;
        startTime = Instant.now().getEpochSecond();
        endTime = startTime+seconds;
    }

    public boolean isItTime(){
        long now = Instant.now().getEpochSecond();
        difference= endTime-now;
        return endTime<now;
    }

    public String getMessage(){
        if (difference>0) return Long.toString(difference);
        else return "ALARM!";
    }
}
