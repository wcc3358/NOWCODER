import java.util.Arrays;
import java.util.Scanner;

/**
 * 数字黑洞
 题目描述
 给定任一个各位数字不完全相同的4位正整数，如果我们先把4个数字按非递增排序，再按非递减排序，然后用第1个数字减第2个数字，将得到
 一个新的数字。一直重复这样做，我们很快会停在有“数字黑洞”之称的6174，这个神奇的数字也叫Kaprekar常数。

 例如，我们从6767开始，将得到

 7766 - 6677 = 1089
 9810 - 0189 = 9621
 9621 - 1269 = 8352
 8532 - 2358 = 6174
 7641 - 1467 = 6174
 ... ...
 现给定任意4位正整数，请编写程序演示到达黑洞的过程。

 输入描述:
 输入给出一个(0, 10000)区间内的正整数N。

 输出描述:
 如果N的4位数字全相等，则在一行内输出“N - N = 0000”；否则将计算的每一步在一行内输出，直到6174作为差出现，输出格式见样例,每行中间没有空行。
 注意每个数字按4位数格式输出。

 输入例子:
 6767

 输出例子:
 7766 - 6677 = 1089
 9810 - 0189 = 9621
 9621 - 1269 = 8352
 8532 - 2358 = 6174
 */
public class ToBeCoder05 {
    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            String input = scanner.next();
            //如果N的4位数字全相等，则在一行内输出“N - N = 0000”
            if(calKaprekar(input)[2]==0){
                System.out.println(input+" - "+input+" = "+"0000");
            }else{
                while (calKaprekar(input)[2]!=6174){
                    System.out.format("%04d - %04d = %04d\n",calKaprekar(input)[0],calKaprekar(input)[1],calKaprekar(input)[2]);
                    //修改input
                    input = calKaprekar(input)[2]+"";
                }
                System.out.format("%04d - %04d = %04d",calKaprekar(input)[0],calKaprekar(input)[1],calKaprekar(input)[2]);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(scanner!=null){
                scanner.close();
            }
        }
    }
    public static int[] calKaprekar(String input){
        //在不足4位数的数字前添加“0”
        while(input.length()<4){
            input="0"+input;
        }
        //构建一个长度为4的整数数组，每一位为真实的数字
        int[] ret = new int[4];
        for (int i = 0;i<4;i++){
            ret[i] = input.charAt(i) - '0';
        }
        //对数组进行排序，使用Arrays.sort()，默认为递增排序
        Arrays.sort(ret);

        int big = ret[3]*1000+ret[2]*100+ret[1]*10+ret[0];
        int little = ret[0]*1000+ret[1]*100+ret[2]*10+ret[3];

        int[] kaprekar = {big,little,big-little};
        return kaprekar;
    }
}
