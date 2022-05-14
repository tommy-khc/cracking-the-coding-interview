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
}
