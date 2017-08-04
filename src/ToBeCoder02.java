import java.util.Scanner;

/**
 * 题目描述
 令Pi表示第i个素数。现任给两个正整数M <= N <= 10000，请输出PM到PN的所有素数。

 输入描述:
     输入在一行中给出M和N，其间以空格分隔。
 输出描述:
     输出从PM到PN的所有素数，每10个数字占1行，其间以空格分隔，但行末不得有多余空格。

 输入例子:
 5 27

 输出例子:
 11 13 17 19 23 29 31 37 41 43
 47 53 59 61 67 71 73 79 83 89
 97 101 103

 质数又称素数。一个大于1的自然数，除了1和它自身外，不能被其他自然数整除的数叫做质数；否则称为合数
 */
public class ToBeCoder02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[] arr = new int[n-m+1];
        int index = 0;
        int count = 0;//用来记录个数
        int i = 2;//第一个素数
        while (count<n){
            if (isPrime(i)){
                count++;
                if(count>=m){
                    arr[index++]=i;
                }
            }
            i++;
        }
        for (int j = 0; j < arr.length; j++) {
            if((j+1)%10==0){//每隔10个数换行
                System.out.println(arr[j]);
            }else{
                if((j+1)==arr.length){
                    System.out.print(arr[j]);
                }else{
                    System.out.print(arr[j]+" ");
                }
            }
        }
    }

    /**
     * 判断参数i是否为素数
     * @param i
     * @return
     */
    private static boolean isPrime(int i){
        if(i==1||(i%2==0&&i!=2)){
            return false;
        }else {
            for (int j = 3;j<=Math.sqrt(i);j+=2){
                if (i%j==0){
                    return false;
                }
            }
            return true;
        }
    }
}
