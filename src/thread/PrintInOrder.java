package thread;

import java.util.concurrent.Semaphore;

public class PrintInOrder {
    class Foo {
        Semaphore m1;
        Semaphore m2;
        public Foo() {
            m1=new Semaphore(0);
            m2=new Semaphore(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            m1.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            m1.acquire();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            m2.release();
        }

        public void third(Runnable printThird) throws InterruptedException {

            m2.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
