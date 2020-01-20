package com.lishaopeng.algorithm.practice.fibonacci;

public class FibonacciBenchmark {
    public static void main(String[] args)
    {
        FibonacciBenchmark benchmark = new FibonacciBenchmark();
        benchmark.run41();
        benchmark.run9000();
        benchmark.run100000();
    }

    private Fibonacci[] fibonacciImpls = new Fibonacci[] {
            new RecursiveFibonacci(),
            new QuickRecursiveFibonacci(),
            new TailRecursiveFibonacciFake(),
            new TailRecursiveFibonacciGenuine(),
            new NonRecursiveFibonacci()
    };

    private void run41() {
        System.out.println("=====   41   =====");
        for (Fibonacci fibonacci : fibonacciImpls) {
            long start = System.currentTimeMillis();
            fibonacci.getValue(41);
            long end = System.currentTimeMillis();
            System.out.format("%30s - %4d\n",
                    fibonacci.getClass().getSimpleName(),
                    end - start);
        }
    }

    private void run9000() {
        System.out.println("=====  9000  =====");
        for (int i = 1; i < fibonacciImpls.length; i++ ) {
            Fibonacci fibonacci = fibonacciImpls[i];
            long start = System.currentTimeMillis();
            fibonacci.getValue(9000);
            long end = System.currentTimeMillis();
            System.out.format("%30s - %4d\n",
                    fibonacci.getClass().getSimpleName(),
                    end - start);
        }
    }

    private void run100000() {
        System.out.println("===== 100000 =====");
        for (int i = 3; i < fibonacciImpls.length; i++ ) {
            Fibonacci fibonacci = fibonacciImpls[i];
            long start = System.currentTimeMillis();
            fibonacci.getValue(100000);
            long end = System.currentTimeMillis();
            System.out.format("%30s - %4d\n",
                    fibonacci.getClass().getSimpleName(),
                    end - start);
        }
    }
}
