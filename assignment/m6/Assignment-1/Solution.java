import java.util.Scanner;
/**
 * Class for add large numbers.
 * @author     :gangadharsingh.
 */
final class AddLargeNumbers {
    /**
     * Constructs the object.
     */
    private AddLargeNumbers() { }
    /**
     * magic number.
     */
    public static final int NUM = 10;
    /**
     * appending to linkedlist.
     *
     * @param      number  The number
     *
     * @return     { LinkedList }
     */
    public static LinkedList numberToDigits(final String number) {
        LinkedList link = new LinkedList();
        String[] arr = number.split("");
        for (String a : arr) {
            link.pushend(a);
        }
        return link;
    }

    /**
     * { appending value of each node to linked list }.
     *
     * @param      list  The list
     *
     * @return     { String }
     */
    public static String digitsToNumber(final LinkedList list) {
        if (list.print() != null) {
            String empt = list.print();
            return empt;
        }
        return null;
    }

    /**
     * Adds large numbers.
     * @param      list1  The list 1
     * @param      list2  The list 2
     * @return     { LinkedList }.
     */
    public static LinkedList addLargeNumbers(final LinkedList list1,
        final LinkedList list2) {
        LinkedList result = new LinkedList();
        int count1 = list1.getsize();
        int count2 = list2.getsize();
        int num = 0;
        int carry = 0;
        while (count1 > 1 && count2 > 1) {
            num = Integer.parseInt(list1.popend()) + carry;
            num += Integer.parseInt(list2.popend());
            carry = num / NUM;
            result.pushstart(Integer.toString(num % NUM));
            count1--;
            count2--;
        }
        if (count1 <= list1.getsize() && count2 <= list2.getsize()) {
            if (list1.getsize() == list2.getsize()) {
                num = Integer.parseInt(list1.popstart()) + carry;
                num += Integer.parseInt(list2.popstart());
            } else {
                if (list1.getsize() > list2.getsize()) {
                    while (list1.getsize() > 1) {
                        num = Integer.parseInt(list1.popend()) + carry;
                        num += Integer.parseInt(list2.popstart());
                        result.pushstart(Integer.toString(num % NUM));
                    }
                    num = Integer.parseInt(list1.popstart());
                } else {
                    num = Integer.parseInt(list1.popstart()) + carry;
                    num += Integer.parseInt(list2.popend());
                }
            }
            result.pushstart(Integer.toString(num));
        }
        return result;
    }
}

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() { }
    /**
     * main function.
     *
     * @param      args  The arguments.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
        case "numberToDigits":
            LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
            LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
            System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
            System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
            break;

        case "addLargeNumbers":
            pDigits = AddLargeNumbers.numberToDigits(p);
            qDigits = AddLargeNumbers.numberToDigits(q);
            LinkedList result = AddLargeNumbers.addLargeNumbers(
                pDigits, qDigits);
            System.out.println(AddLargeNumbers.digitsToNumber(result));
            break;
        default:
            break;
        }
    }

}
