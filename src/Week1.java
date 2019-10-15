public class Week1 {

    int sum(int n) {
        if (n <= 0) {
            return 0;
        }
        return n+sum(n-1);

    }

    int evenSquares(int n){
        if (n <= 0) {
            return 0;
        }
        return (int) (Math.pow(2.0*n, 2.0) + evenSquares(n-1));

    }

    int fib(int n){
        if (n <= 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else {
            return fib(n-1)+fib(n-2);
        }
    }

    boolean linear(String s, char c, int l){
        if (s.length() == l) {
            if (s.charAt(l-1) != c) {

            }
        }
        return true;
    }

}
