//Jonathan Ash
//201499939


   //This class is the shelf.
   class Buffer {
        private volatile int store = 0;

        public synchronized int insert() {
            while (store != 5) {
                System.out.printf("Shelf has %2d pot(s) (Waiting to insert...)\n", store);
                try {
                    wait();
                } catch (InterruptedException e) {}
            }
            store--;
            notify();
            return store;
        }

        public synchronized int remove() {
            while (store != 0) {
                System.out.printf("Shelf has %2d pot(s) (Waiting to remove...)\n", store);
                try {
                    wait();
                } catch (InterruptedException a) {}
            }
            store--;
            notify();
            return store;
        }

        public int getStroe() {
            return store;
        }

    }


    class producer extends Thread {
        private Buffer a;
        private int x;
        private String name;
        int potCount = 0;

        //Constructor to allow for certain variables to be entered, allows or code reuse 
        public producer(Buffer a, int x, String name) {
            this.a = a;
            this.x = x;
            this.name = name;

        }

        public void run() {            
            while (potCount < 11) {
                while (a.getStroe() < 5) {
                System.out.printf("%s has started to make a pot\n", name);
                try {
                    Thread.yield();
                    sleep(x);
                } catch (InterruptedException e) {}
                a.insert();
                System.out.printf("%s has added a pot number %2d to the shelf\n", name, potCount);
                potCount++;
                }
            }
        }
    }

    class consumer extends Thread {
        private Buffer c;
        private int x;
        private int potCount = 0;

        public consumer(Buffer c, int x) {
            this.c = c;
            this.x = x;
        }

        public void run() {
            System.out.println("Consumer1 is ready to pack");
            while (c.getStroe() != 0) {
                try {
                    Thread.yield();
                    sleep(x);
                } catch (InterruptedException e) {}
                c.remove();
                System.out.printf("Consumer1 has packed a pot, there is now %2d pot(s) packed\n", potCount);    
                potCount++;
                }
            }
        }

    //Main program

    public class sgjash_201499939 {

        public static void main(String args[]) {
            System.out.println("Starting main thread...");
            System.out.println("P1 has started");
            System.out.println("P2 has started");
            System.out.println("C1 has started");
            Buffer shelf = new Buffer();
            producer p1 = new producer(shelf, 600, "Producer1");
            consumer c1 = new consumer(shelf, 400);
            producer p2 = new producer(shelf, 500, "Producer2");
            p1.start();
            c1.start();
            p2.start();
        }
    }