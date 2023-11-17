public class CircularDoublyLinkedList {

  public DoublyNode head;
  public DoublyNode tail;
  public int size;

  public DoublyNode createCDLL(int value) {
    head = new DoublyNode();
    DoublyNode newNode = new DoublyNode();
    newNode.value = value;
    head = newNode;
    tail = newNode;
    newNode.next = newNode;
    newNode.previous = newNode;
    size = 1;
    return head;
  }

  public void insertCDLL(int value, int location) {
    DoublyNode newNode = new DoublyNode();
    newNode.value = value;
    if(head == null) {
      createCDLL(value);
      return;
    }
    else if(location == 0) {
      newNode.next = head;
      newNode.previous = tail;
      head.previous = newNode;
      tail.next = newNode;
      head = newNode;
    } 
    else if(location >= size) {
      newNode.next = head;
      newNode.previous = tail;
      head.previous = newNode;
      tail.next = newNode;
      tail = newNode;
    }
    else {
      DoublyNode temp = head;
      for(int i = 0; i < location - 1; i++) {
        temp = temp.next;
      } 
      newNode.previous = temp;
      newNode.next = temp.next;
      temp.next.previous = newNode;
      temp.next = newNode;
    }
    size++;
  }
  public void traverseCDLL() {
    if(head != null) {
      DoublyNode temp = head;
      for(int i = 0; i < size; i++) {
        System.out.print(temp.value);
        if(i != size - 1) {
          System.out.print(" -> ");
        }
        temp = temp.next;
      }
      System.out.println("");
    } else {
      System.out.println("CDLL does not exist");
    }
  }
  public void reverseTraversCDLL() {
    if(head != null) {
      DoublyNode temp = tail;
      for(int i = 0; i < size; i++) {
        System.out.print(temp.value);
        if(i != size-1) {
          System.out.print(" <- ");
        }
        temp = temp.previous;
      }
      System.out.println("");
    } else {
      System.out.println("CDLL does not exist");
    }
  }
  public boolean searchCDLL(int value) {
    if(head != null) {
      DoublyNode temp = head;
      for(int i = 0; i < size; i++) {
        if(temp.value == value) {
          System.out.println("Value was found at node " + i);
          return true;
        }
        temp = temp.next;
      }
    }
    System.out.println("Value not found");
    return false;
  }

  public void deleteNodeCDLL(int location) {
   if(head == null) {
     System.out.println("CDLL does not exist");
     return;
   } 
    else if(location == 0) {
      if(size == 1) {
        head.next = null;
        head.previuos = null;
        head = tail = null;
        size--;
      } else {
        head = head.next;
        head.previou = tail;
        tail.next = head;
        size--;
      }
    } else if(location >= 0) {
      if(size == 1) {
        head.next = null;
        head.previuos = null;
        head = tail = null;
        size--;
      } else {
        tail = tail.previous;
        tail.next = head;
        head.previous = tail;
        size--;
      }
    } else {
      DoublyNode temp = head;
      for(int i = 0; i < location - 1; i++) {
        temp = temp.next;
      }
      temp.next = temp.next.next;
      temp.next.previous = temp;
      size--;
    }
  }

  public void deleteAllCDLL() {
    DoublyNode temp = head;
    for(int i = 0; i < size; i++) {
      temp.previous = null;
      temp = temp.next;
    }
    head = null;
    tail = null;
    System.out.println("CDLL has been deleted");
  }
}