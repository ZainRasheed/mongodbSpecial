package com.example.mongodb_Special.scheduler.manasSirWay;

import java.util.Timer;

//Made it abstract so that a class csn EXTEND SchedulaAndTimerTask
public abstract class SchedulaAndTimerTask implements Runnable { // implements runnable to execute RUN() in a thread


    @Override
    public void run() {
        new Timer().schedule(new MyTimerTask(), 100, 100);
        /*new Timer().schedule(TIMERTASK, TIME in some format );*/
    }
}
