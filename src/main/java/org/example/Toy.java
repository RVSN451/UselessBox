package org.example;

public class Toy extends Thread implements Runnable {
    final Thread thread;

    public Toy() {
        this.thread = new Thread();
    }

    @Override
    public void run(){

    }
}
