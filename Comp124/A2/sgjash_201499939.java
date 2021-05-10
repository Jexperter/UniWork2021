//Jonathan Ash
//201499939

   //This class is the shelf.
   class Buffer {

        public volatile int store = 0;

        public synchronized void insert() {
            while (store >= 5) {
                try {
                    System.out.println("Shelf is full (Waiting...)"); 
                    wait();
                } catch (InterruptedException e) {}
            }
            store+=1;
            notify();
        }

        public synchronized void remove() {
            while (store == 0) {
                try {
                    System.out.println("Shelf is empty (Waiting...)");
                    wait();
                } catch (InterruptedException a) {}   
            }
            store-=1;
            notify();
        }
    }


    class producer extends Thread {
        private Buffer a;
        private int x;
        private String name;
        int potCount = 0;

        //Constructor to allow for certain variables to be entered, allows for code reuse 
        public producer(Buffer a, int x, String name) {
            this.a = a;
            this.x = x;
            this.name = name;

        }

        @Override
        //This method implements the runnable interface which allows for threads to be executed 
        public void run() {            
            while (potCount < 10) {
                System.out.printf("%s has started to make a pot\n", name);
                try {
                    //Simulates time taken for producer to create a pot
                    sleep(x);
                } catch (InterruptedException e) {}
                //Inserts into the shelf using the buffer 
                a.insert();
                potCount++;
                System.out.printf("%s has added a pot number %2d to the shelf. Shelf : %2d\n", name, potCount, a.store);
                
            }
        }
    }

    class consumer extends Thread {
        private Buffer c;
        private int x;
        private int potCount;

        public consumer(Buffer c, int x) {
            this.c = c;
            this.x = x;
        }

        @Override
        //This method removes a pot from the shelf
        public void run() {
            potCount = 0;
            //Loops until all pots are packed 
            while (potCount <= 19) {
                System.out.println("Consumer1 is ready to pack");
                try {
                    //Simulates time taken for consumer to pack a pot
                    sleep(x);
                } catch (InterruptedException e) {}
                //removes from the shelf using the buffer 
                c.remove();
                potCount++;
                System.out.printf("Consumer1 has packed a pot, there is now %2d pot(s) packed. Shelf : %2d\n", potCount, c.store);    
                
            }
        }    
    }

    //Main program which instantiates the preceading classes and runs them using the extended thread class 
    public class sgjash_201499939 {

        public static void main(String args[]) {
            System.out.println("P1 has started");
            System.out.println("P2 has started");
            System.out.println("C1 has started");
            Buffer shelf = new Buffer();
            producer p1 = new producer(shelf, 600, "Producer1");
            consumer c1 = new consumer(shelf, 400);
            producer p2 = new producer(shelf, 500, "Producer2");
            p1.start();
            p2.start();
            c1.start();
        }
    }