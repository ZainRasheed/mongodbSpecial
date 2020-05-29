package com.example.mongodb_Special.scheduler.manasSirWay;

import java.util.TimerTask;

import static java.time.OffsetDateTime.now;

//Made it abstract so that a class can EXTEND MyTimerTask
public /*abstract*/ class MyTimerTask extends TimerTask { //TimerTask will make it a RUNNABLE and a job for timer.schedule


    @Override
    public void run() {
        System.out.println("Timerrr " +now());
    }
}
