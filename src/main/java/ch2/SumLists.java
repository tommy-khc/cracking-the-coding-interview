package ch2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SumLists {

    private static final Logger logger = LogManager.getLogger(SumLists.class);

    public static class Node {
        Node next = null;
        int data;

        public Node (int d) {
            data = d;
        }

        public Node() {

        }

        void appendToTail (int d) {
            Node end = new Node(d);
            Node n = this;
            while (n.next != null) {
                n = n.next;
            }
            n.next = end;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }

        private void setNext (Node n) {
            next = n;
        }

        private int length () {
            int count = 1;
            Node n = next;
            while (n != null) {
                count += 1;
                n = n.next;
            }
            return count;
        }
    }

    public static class LinkedList {
        Node head;

        public int GetNth(int index) {
            Node current = head;
            int count = 0;
            while (current != null) {
                if (count == index)
                    return current.data;
                count++;
                current = current.next;
            }

            assert (false);
            return 0;
        }

        public Node GetNthNode (int index) {
            Node current = head;
            int count = 0;
            while (current != null) {
                if (count == index)
                    return current;
                count++;
                current = current.next;
            }

            assert (false);
            return null;
        }

        public Node GetTail() {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            return current;
        }

        private Boolean remove (Node n) {
            if (n == null) {
                logger.error("Node is null");
                return Boolean.FALSE;
            }

            Node next = n.next;
            n.data = next.data;
            n.next = next.next;
            return Boolean.TRUE;
        }

        public void appendToTail(int new_data) {

            //Head won't be changed

            if (head == null) {
                head = new Node(new_data);
                return;
            }

            head.appendToTail(new_data);
        }

        public void appendToHead(int new_data) {

            //head is changed

            Node newHead = new Node(new_data);
            newHead.next = head;
            head = newHead;

        }

        public List<String> toDeepString () {
            List<String> list = new ArrayList<>();
            Node n = head;
            list.add(n.toString());
            while (n.next != null) {
                list.add(n.next.toString());
                n = n.next;
            }
            return list;
        }
    }

    //input: two LinkedLists
    //output: LinkedList
    //function: each of lists represents a number (its digit are stored in reverse order). Add them and return a new list to present the sum
    //data flow: list -> string -> int -> sum -> int -> String -> list
    //remarks: Octal will be transfered to decimal
    //         no negative number
    public static LinkedList answer(LinkedList list1, LinkedList list2, String order) {

        if (list1 == null) {
            logger.error("list1 is null");
            return null;
        }

        if (list2 == null) {
            logger.error("list2 is null");
            return null;
        }

        if (!order.equals("reverse") && !order.equals("forward")) {
            return null;
        }

        logger.info("List1: " + list1.toDeepString());
        logger.info("List2: " + list2.toDeepString());

        String str1 = listToString(list1, order);
        String str2 = listToString(list2, order);

        Integer num1 = Integer.valueOf(str1);
        Integer num2 = Integer.valueOf(str2);

        Integer sum = num1 + num2;

        String str3 = String.valueOf(sum);
        LinkedList sumList = stringToList(str3, order);

        logger.info("sumList: " + sumList.toDeepString());
        return sumList;
    }

    private static String listToString (LinkedList list, String order) {

        if (list == null) {
            return null;
        }

        if (!order.equals("reverse") && !order.equals("forward")) {
            return null;
        }

        String str = new String();
        Node current = list.head;
        while (current != null) {
            if (order.equals("reverse")) {
                str = String.valueOf(current.data) + str;
            } else { //order.equals("forward")
                str = str + String.valueOf(current.data);
            }
            current = current.next;
        }

        return str;
    }

    private static LinkedList stringToList (String str, String order) {

        if (str == null) {
            return null;
        }

        if (!order.equals("reverse") && !order.equals("forward")) {
            return null;
        }

        char[] chars = str.toCharArray();
        LinkedList list = new LinkedList();
        for (char c : chars) {
            Integer data = Integer.valueOf(String.valueOf(c)); // char can not convert to Integer directly
            if (order.equals("reverse")) {
                list.appendToHead(data);
            } else { //order.equals("forward")
                list.appendToTail(data);
            }
        }

        return list;
    }

    //answer from book
    //reverse 7->1->6 = 617
    //recusive call in math = f(f(f(...f(x)...)))
    //*how to read codes contain recursive call: find the last result of recursive calls
    //*when to adopt recursive call: when the whole process can be analysed as a process that is formed
    // by calling a process (mostly simpler) repeatly --I call it f
    //*how to design recursive call: 2 parts: 1st : code f , 2nd : code how to link f (i.e f(f )
    private static Node addLists (Node list1, Node list2) {
        return addLists(list1, list2, 0);
    }

    private static Node addLists (Node list1, Node list2, int carry) {

        if (list1 == null && list2 == null && carry == 0) {
            return null;
        }

        Node result = new Node();

        int value = carry;

        if (list1 != null) {
            value += list1.data;
        }

        if (list2 != null) {
            value += list2.data;
        }

        result.data = value % 10;

        if (list1 != null || list2 != null) {
            Node more = addLists(list1 == null ? null : list1.next, list2 == null ? null : list2.next, value >= 10 ? 1 : 0);
            result.setNext(more);
        }

        return result;
    }

    //when to use wrapper class:
    //1. The objects are necessary if we wish to modify the arguments passed into the method (because primitive
    // types are passed by value).
    //2. return several primitive values/objects from a method
    //Follow up 6->1->7

    public static class FollowUp {
        private class PartialSum {
            Node sum = null;
            int carry = 0;
        }

        public Node addLists (Node l1, Node l2) {
            int len1 = l1.length();
            int len2 = l2.length();

            //Pad the shorter list with zeros - see note (1)
            if (len1 < len2) {
                l1 = padList(l1, len2 - len1);
            } else {
                l2 = padList(l2, len1 -len2);
            }

            //Add list
            PartialSum sum = addListsHelper(l1, l2);

            //If there was a carry vlaue left over, insert this at the front of the list.
            //Otherwise, just return the linked list.
            if (sum.carry == 0) {
                return sum.sum;
            } else {
                Node result = insertBefore(sum.sum, sum.carry);
                return result;
            }
        }

        PartialSum addListsHelper (Node l1, Node l2) {
            if (l1 == null && l2 == null) {
                PartialSum sum = new PartialSum();
                return sum;
            }
            //Add smaller digits recursively
            PartialSum sum = addListsHelper(l1.next, l2.next);

            //Add carry to current data
            int val = sum.carry + l1.data + l2.data;

            //Insert sum of current digits
            Node fullResult = insertBefore(sum.sum, val % 10);

            //Return sum so far, and the carry value
            sum.sum = fullResult;
            sum.carry = val / 10;
            return sum;
        }

        //Pad the list with zeros
        Node padList(Node l, int padding) {
            Node head = l;
            for (int i = 0; i < padding; i++) {
                head = insertBefore(head, 0);
            }
            return head;
        }

        //Helper function to insert node in the frint if a linked lsit
        Node insertBefore(Node list, int data) {
            Node node = new Node(data);
            if (list != null) {
                node.next = list;
            }
            return node;
        }
    }



}
