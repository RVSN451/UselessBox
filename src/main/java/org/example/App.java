package org.example;


public class App {
    public final static long timeSwitchOn = 100;
    public final static long timeSwitchOff = 100;

    public static void main(String[] args) throws InterruptedException {
        UselessBox myBox = new UselessBox("LittleCat");
        Thread player = new Thread(myBox::boxSwitchOn, "Игрок");
        Thread box = new Thread(myBox::boxSwitchOff);

        box.start();
        player.start();

        Thread.sleep(8000);


        player.interrupt();
        box.interrupt();
    }
}
