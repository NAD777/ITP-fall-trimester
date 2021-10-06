
package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TimeCreator tc = new TimeCreator();
        Time t1 = tc.makeTime(12, 0, 0);
        System.out.format("Time 1: %s", t1.getString());
        Time t2 = tc.makeTime(1, 0, 0);
        System.out.format("Time 2: %s", t2.getString());
        t1.inc().inc().inc();
        System.out.format("Time 1, 3 times inc: %s", t1.getString());
        Time t3 = t1.minus(t2);
        System.out.format("Time 1 - Time 2: %s", t3.getString());
    }
}

class Time {
    private int hours;
    private int minutes;
    private int seconds;

    Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Time inc() {
        this.seconds += 1;
        if (this.seconds == 60) {
            this.seconds = 0;
            this.minutes += 1;
            if (this.minutes == 60) {
                this.minutes = 0;
                this.hours += 1;
                if (this.hours == 24) {
                    this.hours = 0;
                }
            }
        }
        return this;
    }

    String getString() {
        DecimalFormat df = new DecimalFormat("00");
        return String.format("%s:%s:%s\n", df.format(this.hours), df.format(this.minutes), df.format(this.seconds));
    }

    int getHours() {
        return this.hours;
    }

    int getMinutes() {
        return this.minutes;
    }

    int getSeconds() {
        return this.seconds;
    }

    Time minus(Time t2) {
        int this_time_int_secs = this.seconds + this.minutes * 60 + this.hours * 3600;
        int t2_time_int_secs = t2.getSeconds() + t2.getMinutes() * 60 + t2.getHours() * 3600;
        int result = this_time_int_secs - t2_time_int_secs;
        return new Time(result / 3600, result % 3600 / 60, result % 3600 % 60);
    }

}

class TimeCreator {
    Time makeTime(int hours, int minutes, int seconds) {
        return new Time(hours, minutes, seconds);
    }
}
