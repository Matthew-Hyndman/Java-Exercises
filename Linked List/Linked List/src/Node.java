public class Node {
    private Person person;
    private Node next;    

    Node(Person thePreson, Node theNode){
        this.person = thePreson;
        this.next = theNode;
    }

    Node(Person thePreson){
        this.person = thePreson;
    }

    public Person getPerson() {
        return person;
    }

    public Node getNext() {
        return next;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
