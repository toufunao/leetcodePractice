package hku;

import java.sql.SQLOutput;
import java.util.Scanner;

public class GuessNumber {
    public static void guess(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("pls enter your range");
        int low=1;
        int high=scanner.nextInt();
        int number=(low+high)/2;
        System.out.println(number+"  is this less than x?");
        String ans=scanner.next();
        do {
            if (ans.equals("yes")){
                low=number;
                number=(low+high)/2;
                System.out.println(number+"  is this less than x?");
                ans=scanner.next();
            }
            if (ans.equals("no")){
                high=number;
                number=(low+high)/2;
                System.out.println(number+"  is this less than x?");
                ans=scanner.next();
            }
        }while (!ans.equals("1"));

        System.out.println("yes the number is "+number);
    }

    public static void main(String[] args){
        guess();
    }
}
