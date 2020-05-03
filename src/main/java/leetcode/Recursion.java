package leetcode;

/**
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数
 * ‘A’->1,‘B’-> 2,'Z'->26
 * 自顶向下算法
 */
public class Recursion {
    public  int numDecodings(String s){
        char[] chars = s.toCharArray();
        return decode(chars, chars.length -1);
    }

    private int decode(char[] chars, int index) {
        if (index <= 0){
            return 1;
        }
        int count = 0;
        char curr = chars[index];
        char prev = chars[index - 1];
        if (curr > '0'){
           count = decode(chars, index -1);
        }
        if (prev == '1' || (prev == '2' && curr <= '6')){
            count += decode(chars, index -2);

        }

        return  count;
    }

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        int i = recursion.numDecodings("129");
        System.out.println(i);
    }
}
