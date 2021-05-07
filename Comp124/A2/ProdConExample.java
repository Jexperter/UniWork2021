
// COMP124 Producer-Consumer Example
// This shows how a Buffer object can synchronise insert() and remove() from
// concurrent Producer and Consumer threads

// NOTE: Run this multiple times to see what happens when the Consumer thread
// starts first

// --------------------------------------------------------------------------
// Buffer

class Buffer {

    private int store;
    private volatile boolean empty = true;

    public synchronized void insert(int item) {
        while(!empty) {
            System.out.println("Waiting to insert...");
            try {
                wait();
            } catch(InterruptedException e) {}
        }
        empty = false;
        store = item;
        notify();
    }

    public synchronized int remove() {
        while(empty) {
            System.out.println("Waiting to remove...");
            try {
                wait();
            } catch(InterruptedException e) {}
        }
        empty = true;
        notify();
        return store;
    }

}

// --------------------------------------------------------------------------
// Producer

class Producer extends Thread {

    private Buffer buff;

    public Producer(Buffer b) {
        buff = b;
    }

    public void run() {
        System.out.println("Attempting insert");
        buff.insert(10);
    }

}

// --------------------------------------------------------------------------
// Consumer

class Consumer extends Thread {

    private Buffer buff;

    public Consumer(Buffer b) {
        buff = b;
    }

    public void run() {
        System.out.println("Attempting remove");
        int removed = buff.remove();
        System.out.println("Removed " + removed);
    }

}

// --------------------------------------------------------------------------
// Main Thread (Program Starts Here)

// NOTE: Try creating multiple Producer and Consumer objects and start them
// running in different orders to increase the chances of having to wait

public class ProdConExample {

    public static void main(String args[]) {
        System.out.println("Starting Main Thread");
        Buffer storage = new Buffer();
        Producer pro = new Producer(storage);
        Consumer con = new Consumer(storage);
        pro.start();
        con.start();
        System.out.println("Ending Main Thread");
    }

}
        