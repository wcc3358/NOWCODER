import java.util.Scanner;

/**
 * 数字分类
 题目描述
 给定一系列正整数，请按要求对数字进行分类，并输出以下5个数字：
 A1 = 能被5整除的数字中所有偶数的和；
 A2 = 将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；
 A3 = 被5除后余2的数字的个数；
 A4 = 被5除后余3的数字的平均数，精确到小数点后1位；
 A5 = 被5除后余4的数字中最大数字。

 输入描述:
 每个输入包含1个测试用例。每个测试用例先给出一个不超过1000的正整数N，随后给出N个不超过1000的待分类的正整数。数字间以空格分隔。

 输出描述:
 对给定的N个正整数，按题目要求计算A1~A5并在一行中顺序输出。数字间以空格分隔，但行末不得有多余空格。
 若其中某一类数字不存在，则在相应位置输出“N”。

 输入例子:
 13 1 2 3 4 5 6 7 8 9 10 20 16 18

 输出例子:
 30 11 2 9.7 9
 */
public class ToBeCoder03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[5];
        int temp;//记录输入的整数
        int ret;//ret = temp%5;
        int count = 0;//用来记录5除后余1中-1的个数
        int num = 0;//用来记录被5除后余3的数的个数
        for (int i = 0; i < n; i++) {
            temp = scanner.nextInt();
            ret = temp%5;
            switch (ret){
                case 0://能被5整除
                    if(temp%2==0){
                        arr[0]+=temp;
                    }
                    break;
                case 1://被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；
                    arr[1]+=(count++%2==0?1:-1)*temp;
                    break;
                case 2://被5除后余2的数字的个数
                    arr[2]++;
                    break;
                case 3://被5除后余3的数字的平均数，精确到小数点后1位
                    arr[3]+=temp;
                    num++;
                    break;
                case 4://被5除后余4的数字中最大数字
                    if(temp>arr[4]){
                        arr[4] = temp;
                    }
                    break;
            }
        }
        for (int i = 0; i < 5; i++) {
            if(arr[i]==0&&i!=4){
                System.out.print("N ");
                continue;
            }
            if(arr[i]==0&&i==4){
                System.out.print("N");
                continue;
            }
            if(i==4){
                System.out.print(arr[i]);
            }else if(i==3){
                System.out.print(Math.round(arr[i]*10.0/num)*1.0/10 + " ");
            }else {
                System.out.print(arr[i]+" ");
            }
        }
    }
}
