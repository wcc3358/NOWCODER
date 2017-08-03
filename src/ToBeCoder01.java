import java.math.BigInteger;
import java.util.Scanner;

/**
 * 题目描述：
 *    给定区间[-2^31, 2^31]内的3个整数A、B和C，请判断A+B是否大于C
 *输入描述:
 *    输入第1行给出正整数T(<=10)，是测试用例的个数。随后给出T组测试用例，每组占一行，顺序给出A、B和C。整数间以空格分隔。
 * 输出描述:
 *    对每组测试用例，在一行中输出“Case #X: true”如果A+B>C，否则输出“Case #X: false”，其中X是测试用例的编号（从1开始）。
 输入例子:
     4
     1 2 3
     2 3 4
     2147483647 0 2147483646
     0 -2147483648 -2147483647
 输出例子:
     Case #1: false
     Case #2: true
     Case #3: true
     Case #4: false
 */

/**
 * 方法1：使用BigInteger
 */
public class ToBeCoder01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i=1;i<=T;i++){
            BigInteger A = scanner.nextBigInteger();
            BigInteger B = scanner.nextBigInteger();
            BigInteger C = scanner.nextBigInteger();
            BigInteger sum = A.add(B);
            if(sum.compareTo(C)>0){
                System.out.println("Case #"+i+": true");
            }else{
                System.out.println("Case #"+i+": false");
            }
        }
    }
}

/**
 * 方法2，使用Long
 */
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i=1;i<=T;i++){
            long A = scanner.nextLong();
            long B = scanner.nextLong();
            long C = scanner.nextLong();
            long sum = A+B;
            if(sum>C){
                System.out.println("Case #"+i+": true");
            }else{
                System.out.println("Case #"+i+": false");
            }
        }
    }
}
