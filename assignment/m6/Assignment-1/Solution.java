import java.util.Scanner;
class AddLargeNumbers {
    public static LinkedList numberToDigits(String number) {
        LinkedList link= new LinkedList();;
        String[] arr = number.split("");
        for (String a: arr) {
            // System.out.println("numberToDigits");
            link.pushend(a);
            // System.out.println(link.print());
        }
        return link;
    }

    public static String digitsToNumber(LinkedList list) {
        // System.out.println("digitsToNumber");
        if (list.print() != null) {
            String empt = list.print();    
            return empt;
        }
        return null;
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        // System.out.println("addLargeNumbers");
        LinkedList result = new LinkedList();
        // int list1elem = Integer.parseInt(list1.print().replaceAll("\\D", ""));
        // int list2elem = Integer.parseInt(list2.print());
        // int sum = list1elem+list2elem;
        int count1 = list1.getsize();
        int count2= list2.getsize();
        int num = 0;
        int carry = 0;
        while(count1 > 1 && count2 > 1) {   
            num = Integer.parseInt(list1.popend()) + carry;
            num += Integer.parseInt(list2.popend());
            carry = num/10;
            // System.out.println("num:"+num);
            // System.out.println("carry:"+carry);
            result.pushstart(Integer.toString(num%10));
            // System.out.println(result.print()+":::print");
            count1--;
            count2--;
        }
        if (count1 <= list1.getsize() && count2 <= list2.getsize()) {
            if (list1.getsize() == list2.getsize()) {
                num = Integer.parseInt(list1.popstart()) + carry;
                num += Integer.parseInt(list2.popstart());
            } else {
                if (list1.getsize() > list2.getsize()) {
                    while(list1.getsize() > 1) {
                        num = Integer.parseInt(list1.popend()) + carry;
                        num += Integer.parseInt(list2.popstart());
                        // System.out.println("carry:"+carry);
                        result.pushstart(Integer.toString(num%10));
                    }
                    num = Integer.parseInt(list1.popstart());
                    // result.pushstart(Integer.toString(num));
                } else {
                    
                    while(list2.getsize() > 1) {
                        num = Integer.parseInt(list1.popstart()) + carry;
                        num += Integer.parseInt(list2.popend());
                        // System.out.println("carry:"+carry);
                        result.pushstart(Integer.toString(num%10));
                    }
                    num = Integer.parseInt(list2.popstart());
                }
            }
            // System.out.println("num:"+num);
            // System.out.println("carry:"+carry);
            result.pushstart(Integer.toString(num));
            // System.out.println(result.print()+":::print");
        }
        return result;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }
    
}
