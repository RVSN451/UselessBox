package org.example;

import java.util.concurrent.atomic.AtomicBoolean;

public class Switch {
    protected UselessBox uselessBox;
    protected AtomicBoolean switchStatus = new AtomicBoolean(false);
    private String turnedOn;

    public Switch(UselessBox uselessBox) {
        this.uselessBox = uselessBox;
        this.switchStatus.set(false);
    }

    public void switchOn() {
        while (!Thread.currentThread().isInterrupted()){
            boolean result = switchStatus.compareAndSet(false, true);

            if (result) {
                turnedOn = Thread.currentThread().getName();
                System.out.printf("\n\n\t\t\t%s: " +
                                "\nКажется %s уснул.. ЧИК!!! - включаю тумблер!!!",
                        turnedOn, uselessBox.getBoxName());

            }
            try {
                Thread.sleep(App.timeSwitchOn);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public void switchOff() {
        while (!Thread.currentThread().isInterrupted()){
            if (switchStatus.compareAndSet(true, false)) {
                System.out.printf("\n\t\t\t%s: " +
                                "\nКто включил мой тумблер????" +
                                "\nАх это ты, %s???" +
                                "\nВыкючаю тумблер и ложусь спать!!!",
                        uselessBox.getBoxName(),
                        turnedOn);
            }
            try {
                Thread.sleep(App.timeSwitchOff);
            } catch (InterruptedException e) {
                return;
            }
        }

    }
}
