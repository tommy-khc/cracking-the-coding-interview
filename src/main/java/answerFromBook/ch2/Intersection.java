package answerFromBook.ch2;

public interface Intersection {
    
    //Concepts:
    //1. Determining if there's an intersection
    //2. Finding the intersecting Node
    //Data flow:
    //1. Run through each linked list to get the lengths and the tails
    //2. Compare the tails. If they are different (by reference, not by value), return immediately. There is no intersection.
    //Set two pointers to the start of each linked list
    //4. On the longer linked list, advance its pointer by difference in lengths
    //5. Now, traverse on each linked list until the pointers are the same.
    default Node findIntersection (Node list1, Node list2) {
        if (list1 == null || list2 == null) {
            return null;
        }
        
        //Get tail and sizes.
        Result result1 = getTailAndSize(list1);
        Result result2 = getTailAndSize(list2);
        
        //If different tail nodes, then there's no intersection.
        if (result1.tail != result2.tail) {
            return null;
        }

        //Set pointers to the start of each linked list.
        Node shorter = result1.size < result2.size ? list1 : list2;
        Node longer = result1.size < result2.size ? list2 : list1;

        //Advance the pointer for the longer linked list by difference in lengths.
        longer = getKthNode(longer, Math.abs(result1.size - result2.size));

        //Move both pointers until you have a collision.
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        //return ethier one
        return longer;
    }
    
    class Result {
        public Node tail;
        public int size;

        public Result(Node tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }
    
    private Result getTailAndSize(Node list) {
        if (list == null) {
            return null;
        }
        
        int size = 1;
        Node current = list; //current is current head
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return new Result(current, size);
    }

    private Node getKthNode (Node head, int k) {
        Node current = head;
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }
}
