package mx.edu.greengates.ane.computerscienceiastudymanagement.util;

public class TimerUtil {

    long startTime;
    long elapsedTime;

    public long startTimer(){
        startTime = System.currentTimeMillis();
        return startTime;
    }

    public long stopTimer(){
        elapsedTime = System.currentTimeMillis() - startTime;
        return elapsedTime;
    }

    public String displayTime(long elapsedTime){
        long elapsedSeconds = elapsedTime / 1000;
        long secondsDisplay = elapsedSeconds % 60;
        long elapsedMinutes = elapsedSeconds / 60;
        String display = elapsedMinutes + ":" + secondsDisplay;
        System.out.println(display);
        return display;
    }
}
