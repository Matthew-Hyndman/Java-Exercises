public class App {
    public static void main(String[] args) throws Exception {

        //declaring the linked list (first will always be null, meaning it is empty)
        Linked_List list = new Linked_List();

        //demostraition that the list is empty
        System.out.println("\nis linked list empty?: " + list.isListEmpty() + "\n");

        //populating the linked list with Person(s) in the first. 
        // Meaning Matthew will be last and Alex will be first.
        list.incertfirstPerson(new Person("Matthew", 26));
        list.incertfirstPerson(new Person("Adam", 23));
        list.incertfirstPerson(new Person("Lilly", 31));
        list.incertfirstPerson(new Person("Alex", 54));

        list.printList();

        //deleating from first (meaning; at this point of execution, Alex will be removed from the Linked List)
        list.deleteFirst();

        list.printList();
    }
}
