import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 福尔摩斯的约会
 题目描述
 大侦探福尔摩斯接到一张奇怪的字条：“我们约会吧！ 3485djDkxh4hhGE 2984akDfkkkkggEdsb s&hgsfdk d&Hyscvnm”。大侦探很
 快就明白了，字条上奇怪的乱码实际上就是约会的时间“星期四 14:04”，因为前面两字符串中第1对相同的大写英文字母（大小写有区分）是
 第4个字母'D'，代表星期四；第2对相同的字符是'E'，那是第5个英文字母，代表一天里的第14个钟头（于是一天的0点到23点由数字0到9、
 以及大写字母A到N表示）；后面两字符串第1对相同的英文字母's'出现在第4个位置（从0开始计数）上，代表第4分钟。现给定两对字符串，
 请帮助福尔摩斯解码得到约会的时间。

 输入描述:
 输入在4行中分别给出4个非空、不包含空格、且长度不超过60的字符串。

 输出描述:
 在一行中输出约会的时间，格式为“DAY HH:MM”，其中“DAY”是某星期的3字符缩写，即MON表示星期一，TUE表示星期二，WED表示星期三，THU表示星期
 四，FRI表示星期五，SAT表示星期六，SUN表示星期日。题目输入保证每个测试存在唯一解。

 输入例子:
 3485djDkxh4hhGE
 2984akDfkkkkggEdsb
 s&hgsfdk
 d&Hyscvnm

 输出例子:
 THU 14:04
 */
public class ToBeCoder06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //获得4个输入
        char[] location0 = scanner.nextLine().toCharArray();
        char[] location1 = scanner.nextLine().toCharArray();
        char[] location2 = scanner.nextLine().toCharArray();
        char[] location3 = scanner.nextLine().toCharArray();
        int len1 = location0.length<=location1.length?location0.length:location1.length;
        int len2 = location2.length<=location3.length?location2.length:location3.length;

        //创建星期的数组（Map也是可以的） switch
        String[] week = new String[]{"MON","TUE","WED","THU","FRI","SAT","SUN"};
        //对应的字母为 A B C D E F G
        StringBuilder sb = new StringBuilder(10);

        //判断星期，找到第一个字符串的大写字母，并匹配第二个字符串，如果第二个字符串中含有该字母则将其作为星期
        int j = 0;
        for (int i = 0; i < len1; i++) {
            if(location0[i]<='Z'&&location0[i]>='A'){
                if(location0[i]==location1[i]){
                    sb.append(week[location0[i]-'A']).append(" ");
                    j = i+1;
                    break;
                }
            }
        }
        //判断小时,找到第二大写字母，包含在第二个字符串中 A(65)-10 B(66)-11 C-12 D-13 E-14 F-15 G-16 H-17 I-18 J-19 K-20 L-21 M-22 N-23 （int）字母-55
        for (; j<len1; j++) {
            if(location0[j]<='Z'&&location0[j]>='A'){
                if(location0[j]==location1[j]){
                    sb.append(location0[j]-55).append(":");
                    break;
                }
            }else if (location0[j]<='9'&&location0[j]>='0'){
                if(location0[j]==location1[j]){
                    sb.append("0").append(location0[j]).append(":");
                    break;
                }
            }
        }
        //判断分，找到小写字母相同的所处的位置
        for (int i = 0; i < len2; i++) {
            if(isLetter(location2[i])&&isLetter(location3[i])){
                if (location2[i]==location3[i]){
                    if(i<10){
                        sb.append("0").append(i);
                    }else {
                        sb.append(i);
                    }
                    break;
                }
            }
        }
        System.out.print(sb.toString());

    }
    public static boolean isLetter(char c){
        return c>='A'&&c<='z';
    }
}
