package hku;

import java.util.Stack;

public class Transfer {
    public static void dec2bit(int number){
        int x;
        StringBuilder stringBuilder=new StringBuilder();
        Stack<Integer> stack=new Stack<>();
        while (number>0){
            x=number%2;
            number=number/2;
            stack.push(x);
        }

        while (!stack.empty()){
            stringBuilder.append(stack.pop());
        }
        System.out.println(stringBuilder.toString());
    }


    public static void dec2oct(int number){
        int x;
        StringBuilder stringBuilder=new StringBuilder();
        Stack<Integer> stack=new Stack<>();
        while (number>0){
            x=number%8;
            number=number/8;
           // stack.push(x);
            stringBuilder.append(x);
        }

        while (!stack.empty()){
            stringBuilder.append(stack.pop());
        }
        System.out.println(stringBuilder.reverse().toString());
    }

    public static void dec2hex(int number){
        int x;
        StringBuilder stringBuilder=new StringBuilder();
        Stack<String> stack=new Stack<>();
        while (number>0){
            x=number%16;
            number=number/16;
            if (x>=0&&x<=9){
                stack.push(Integer.toString(x));
            }else if (x==10){
                stack.push("A");
            }else if (x==11){
                stack.push("B");
            }else if (x==12){
                stack.push("C");
            }else if (x==13){
                stack.push("D");
            }else if (x==14){
                stack.push("E");
            }else if (x==15){
                stack.push("F");
            }
        }

        while (!stack.empty()){
            stringBuilder.append(stack.pop());
        }
        System.out.println(stringBuilder.toString());
    }

    public static void n2oct(String number,int radix){
        StringBuilder stringBuilder=new StringBuilder(number);
        stringBuilder.reverse();
        int result=0;
        for (int i=0;i<stringBuilder.length();i++){
            int bit=stringBuilder.charAt(i);
            if (bit>='0'&&bit<='9'){
                result+=(int)(bit-'0')*Math.pow(radix,i);
            }else if (bit>='a'&&bit<='f'){
                result+=((int)(bit-'a')+10)*Math.pow(radix,i);
            }
        }
        System.out.println(result);
    }


    public static void main(String[] args){
        dec2bit(10);
        dec2oct(10);
        dec2hex(15);
        n2oct("1010",2);
        n2oct("12",8);
    }
}
