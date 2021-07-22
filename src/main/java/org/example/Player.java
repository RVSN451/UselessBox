package org.example;

public class Player extends Thread implements Runnable {

    String name;
    Long sleep;
    Integer count;
    final Thread thread;

    Player(String name, Long sleep) {
        this.name = name;
        this.sleep = sleep;
        thread = new Thread();
        thread.setName(name);
    }

    @Override
    public void run() {
        UselessBox myBox = new UselessBox("LittleCat");

        while (!thread.isInterrupted()) {
            myBox.boxSwitchOn();
            try {
                Thread.sleep(App.timeSwitchOn);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
