class Foo {
        private volatile int i  = 0;

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        i=1;
        Thread.yield();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        while(i!=1)
            Thread.yield();
        printSecond.run();
        i=2;
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        while(i!=2)
            Thread.yield();
        printThird.run();
    }
}