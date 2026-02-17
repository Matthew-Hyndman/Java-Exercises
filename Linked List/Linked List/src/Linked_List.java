public class Linked_List {
    private Node first;

    public Linked_List() {
        first = null;
    }

    public boolean isListEmpty() {
        return first == null;
    }

    public Node getFirst() {
        return first;
    }

    /**
     * For inserting to first Node
     * 
     * @param thPerson
     */
    public void incertfirstPerson(Person thPerson) {
        Node newNode = new Node(thPerson);
        // setting the new node as the first node
        newNode.setNext(first);
        // setting the first node
        first = newNode;
    }

    /**
     * For deleteding first Node
     */
    public void deleteFirst() {
        // creating a temp node for logging
        Node temp = first;
        // eraceing the first node by setting the first to the next
        first = first.getNext();
        // logging
        System.out.println("Deleted first: " + temp.getPerson().toString());
    }

    /**
     * Print Linked List content
     */
    public void printList() {
        
        System.out.println("index|Person");
        int index = 0;
        // declaring the start of the list by setting the current to the first
        Node current = first;
        // looping until current reaches the end which will always be null
        while (current != null) {
            System.out.println("[" + index + "]: |" + current.getPerson().toString());
            // traversing the linked list by setting the current node to the next node
            current = current.getNext();
            index++;
        }
    }

}
