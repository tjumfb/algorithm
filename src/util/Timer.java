package util;

public class Timer {
    long time;
    public Timer() {
        time = System.currentTimeMillis();
    }
    public long getTime(){
        return System.currentTimeMillis()-time;
    }
}
