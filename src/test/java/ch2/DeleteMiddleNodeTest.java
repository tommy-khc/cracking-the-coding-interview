package ch2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class DeleteMiddleNodeTest {

    private static final Logger logger = LogManager.getLogger(DeleteMiddleNodeTest.class);

    @Test
    public void questionOne () {

        class LinkedList {
            DeleteMiddleNode.Node head; // the head of list

            /* Takes index as argument and return data at index*/
            public int GetNth(int index) {
                DeleteMiddleNode.Node current = head;
                int count = 0; /* index of Node we are
                          currently looking at */
                while (current != null) {
                    if (count == index)
                        return current.data;
                    count++;
                    current = current.next;
                }

                /* if we get to this line, the caller was asking
                for a non-existent element so we assert fail */
                assert (false);
                return 0;
            }

            /* Given a reference to the head of a list and an int,
               inserts a new Node on the front of the list. */
            public void push(int new_data) {

//                /* 1. alloc the Node and put data*/
//                DeleteMiddleNode.Node new_Node = new DeleteMiddleNode.Node(new_data);
//
//                /* 2. Make next of new Node as head */
//                new_Node.next = head;
//
//                /* 3. Move the head to point to new Node */
//                head = new_Node;

                if (head == null) {
                    head = new DeleteMiddleNode.Node(new_data);
                    return;
                }

                head.appendToTail(new_data);
            }

            public DeleteMiddleNode.Node GetNthNode (int index) {
                DeleteMiddleNode.Node current = head;
                int count = 0; /* index of Node we are
                          currently looking at */
                while (current != null) {
                    if (count == index)
                        return current;
                    count++;
                    current = current.next;
                }

                /* if we get to this line, the caller was asking
                for a non-existent element so we assert fail */
                assert (false);
                return null;
            }

            private List<String> toDeepString () {
                List<String> list = new ArrayList<>();
                DeleteMiddleNode.Node n = head;
                list.add(n.toString());
                while (n.next != null) {
                    list.add(n.next.toString());
                    n = n.next;
                }
                return list;
            }
        }

        LinkedList lList = new LinkedList();
        lList.push(1);
        lList.push(2);
        lList.push(3);
        lList.push(4);
        lList.push(5);
        lList.push(6);

        List<String> expectedList = new ArrayList<>();
        Collections.addAll(expectedList,
                "Node{data=1}",
                "Node{data=2}",
                "Node{data=3}",
                "Node{data=5}",
                "Node{data=6}");

        DeleteMiddleNode.answer(lList.GetNthNode(3));
        Assertions.assertEquals(lList.toDeepString(),expectedList);
        logger.info("expectedList: " + expectedList);
        logger.info("lList: " + lList.toDeepString());
    }
}
