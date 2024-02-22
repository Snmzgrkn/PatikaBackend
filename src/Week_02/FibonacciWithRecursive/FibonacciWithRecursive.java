package Week_02.FibonacciWithRecursive;

public class FibonacciWithRecursive {
    public static void main(String[] args) {
        // 1 1 2 3 5 8 13 21

        //f(n) = fn(n-1) + f(n-2)

        System.out.println(fibonacci(6));


    }

    static  int fibonacci(int n){
        if (n==1 || n==2)
            return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
