import java.util.Scanner;

/**
 * 部分A+B
 题目描述
 正整数A的“DA（为1位整数）部分”定义为由A中所有DA组成的新整数PA。例如：给定A = 3862767，DA = 6，则A的“6部分”PA是66，因为A中有2个6。
 现给定A、DA、B、DB，请编写程序计算PA + PB。

 输入描述:
 输入在一行中依次给出A、DA、B、DB，中间以空格分隔，其中0 < A, B < 10的10次方。

 输出描述:
 在一行中输出PA + PB的值。

 输入例子:
 3862767 6 13530293 3

 输出例子:
 399
 */
public class ToBeCoder04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long da = scanner.nextLong();
        long a = scanner.nextLong();
        long db = scanner.nextLong();
        long b = scanner.nextLong();
        int pa = getRet(da,a);
        int pb = getRet(db,b);
        System.out.print(pa+pb);
    }
    private static int getRet(long input,long findEle){
        //input中含有的findEle的个数
        int count = 0;
        char[] arr_input = String.valueOf(input).toCharArray();
        char str_findEle = String.valueOf(findEle).toCharArray()[0];
        for (char c : arr_input) {
            if(str_findEle==c){
                count++;
            }
        }
        if(count==0){
            return 0;
        }
        //计算pa的值
        StringBuilder sb = new StringBuilder(20);
        for(int i=0;i<count;i++){
            sb.append(String.valueOf(findEle));
        }
        return Integer.parseInt(sb.toString());
    }
}
