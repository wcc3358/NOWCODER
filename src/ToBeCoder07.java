import java.util.Scanner;

/**
 * D进制的A+B
 题目描述
 输入两个非负10进制整数A和B(<=230-1)，输出A+B的D (1 < D <= 10)进制数。

 输入描述:
 输入在一行中依次给出3个整数A、B和D。

 输出描述:
 输出A+B的D进制数。

 输入例子:
 123 456 8

 输出例子:
 1103
 */
public class ToBeCoder07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int d = scanner.nextInt();

        //求和
        int c = a+b;
        //求D进制数，（使用递归）即是用求和的数，先判断是否是大于d，如果大于d则用和除以d求得余数和结果，然后递归
        StringBuilder sb = new StringBuilder(40);
        sb = getNum(c,d,sb);
        System.out.println(sb.reverse().toString());

    }
    public static StringBuilder getNum(int c,int d,StringBuilder stringBuilder) {
        if(c>=d){
            stringBuilder.append(c%d);
            int ret = c/d;
            getNum(c/d,d,stringBuilder);
        }else{
            stringBuilder.append(c);
        }
        return stringBuilder;
    }
}
