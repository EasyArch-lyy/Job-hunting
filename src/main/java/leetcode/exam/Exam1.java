package leetcode.exam;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lyy
 */
public class Exam1 {
    public static void main(String[] args) {
        //扑克牌库
//        String[] a={"a1","a2","a3","a4","a5","a6","a7","a8","a9","a10","b1","b2","b3","b4","b5","b6","b7","b8","b9","b10","c1","c2","c3","c4","c5","c6","c7","c8","c9","c10","d1","d2","d3","d4","d5","d6","d7","d8","d9","d10"};
        Scanner sc=new Scanner(System.in);
        int[]c=null;
        String s=sc.nextLine();
        System.out.println(s);
        String[]f=s.split(" ");
        System.out.println(f.length);
//        for(int i=0;i<f.length;i++){
//            System.out.println(f[i]);
//        }
        //记录出牌次数
        int t=0;
        //记录连对
        List listAABB=new LinkedList();
        //记录对子
        List listAA=new LinkedList();
        //记录顺子
        List list12345=new LinkedList();
        //记录炸弹
        List listAAA=new LinkedList();
        int w=0;
        //记录每张牌出现次数
        int p1=0;
        int p2=0;
        int p3=0;
        int p4=0;
        int p5=0;
        int p6=0;
        int p7=0;
        int p8=0;
        int p9=0;
        int p10=0;
        int p[]=new int[10];
        for(int i=0;i<f.length;i++){
            switch (f[i]){
                case "1":
                    p1++;
                    break;
                case "2":
                    p2++;
                    break;
                case "3":
                    p3++;
                    break;
                case "4":
                    p4++;
                    break;
                case "5":
                    p5++;
                    break;
                case "6":
                    p6++;
                    break;
                case "7":
                    p7++;
                    break;
                case "8":
                    p8++;
                    break;
                case "9":
                    p9++;
                    break;
                case "10":
                    p10++;
                    break;
            }
            p[i]= Integer.parseInt(("p"+String.valueOf(i)));
            //aaa牌型
            if(p[i]>3){
                listAAA.add(p[i]);
//                map.put(,);
            }
            //aa牌型
            if(p[i]>2){
                listAA.add(p[i]);
            }
            //1122牌型
            if(p[i]>2&&p[i+1]>2){
                listAABB.add(p[i]+p[i+1]);
            }
        }
        //12345牌型
        for(int i=0;i<6;i++){
            if(p[i]>0&&p[i+1]>0&&p[i+2]>0&&p[i+3]>0&&p[i+4]>0){
                list12345.add(p[i]+p[i+4]);
            }
        }

        //判断出牌
        if(list12345.size()>0){
            System.out.println("一次出完");
        }else if(listAAA.size()>0){

        }
//        map;

    }

    public int count(String s) {
        int i = 0;

        return i;
    }
}
