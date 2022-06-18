package answerFromBook.ch2;

public interface LoopDetectable {

    //1. Create two pointers, FastPointer and SlowPointer
    //2. Move FastPointer at rate of 2 steps and SlowPointer at a rate of 1 step.
    //3. When they collide, move SlowPointer to LinkedListHead. Kepp FastPointer where it is.
    //4. Move SlowPointer and FastPointer at a rate of one step. Return the new collision point.
//    default Node searchBeginningOfLoop (Node head) {
//
//        if (head == null) {
//            return null;
//        }
//
//        Boolean hasALoop = Boolean.FALSE;
//        Node slow = head;
//        Node fast = head;
//
//        while (fast != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//
//            if (slow.equals(fast)) { //collide
//                hasALoop = Boolean.TRUE;
//                break;
//            }
//        }
//
//        if (hasALoop) {
//            slow = head;
//            while (!slow.equals(fast)) {
//                slow = slow.next;
//                fast = fast.next;
//            }
//            return slow;
//        }
//
//        return null; //No loop
//    }

    default Node searchBeginningOfLoop (Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow.equals(fast)) { //collide
                break;
            }
        }

        if (fast == null || fast.next == null) { //No loop
            return null;
        }

        slow = head;
        while (!slow.equals(fast)) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }
}
