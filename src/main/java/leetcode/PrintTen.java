package leetcode;

public class PrintTen {
    public static void main(String[] args) {
        printTen(1);
    }

    private static void printTen(int n) {
        if (n == 11) {
            return;
        }
        System.out.println(n);
        printTen(n + 1);
    }
}
