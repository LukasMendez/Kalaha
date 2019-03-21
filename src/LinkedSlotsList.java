import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

/**
 * Created by Lukas
 * 18-03-2019.
 */
public class LinkedSlotsList {


    Node head; // head of list
    Node tail;
    Node selected;
    GameManager gameManager;

    Label turn;

    static int size;

    // Linked list Node.
    // This inner class is made static
    // so that main() can access it
    static class Node {

        KalahaSlot data;
        Node next;

        // Constructor
        Node(KalahaSlot slot)
        {
            data = slot;
            next = null;
        }

        // Retrieve the data
        KalahaSlot getData(){

            return this.data;
        }

    }

    public LinkedSlotsList(Player player1, Player player2, Label turn){

        gameManager = new GameManager(player1,player2);

        this.turn=turn;

        turn.setText("It's " + gameManager.getCurrentPlayer().getPlayerName() + "'s turn");

    }


    public void add(KalahaSlot data){

        //Will create a new Node with the given data
        Node newNode = new Node(data);


        // If its not a point container (returns false) it will create an event handler
        if (!newNode.getData().isPointContainer()){

            newNode.getData().getSlotButton().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    // Will set the selected to that certain Node, each time its pressed
                    selected = newNode;

                    int amountInHand = Integer.parseInt(newNode.getData().getSlotButton().getText());

                    // Will take out the balls and therefore set the slot to 0
                    selected.getData().getSlotButton().setText("0");

                    for (int i = 0; i < amountInHand; i++) {

                        //Will go to the next slot and increment only on your own slot container

                        Node nextNode = next();


                        if (!nextNode.getData().isPointContainer() || (nextNode.getData().isPointContainer() && gameManager.compare(nextNode.getData().getOwnerShip()))){

                            System.out.println("Is current player same as owned container: " + gameManager.compare(nextNode.getData().getOwnerShip()));

                            System.out.println("Owner: " + nextNode.getData().getOwnerShip().getPlayerName());
                            System.out.println("Current player: " + gameManager.getCurrentPlayer().getPlayerName());

                            // Will get the amount of points in the next slot
                            int newPoint = Integer.parseInt(selected.getData().getSlotButton().getText());

                            // Will add one ball to the slot
                            newPoint++;

                            // Will set the new value and convert it to a string to fit the parameters
                            selected.getData().getSlotButton().setText(Integer.toString(newPoint));

                        }


                    }

                    // If the last one is empty. Switch turns
                    if (selected.getData().getSlotButton().getText().equals("1")){

                        gameManager.switchTurn();

                        String turnNow = "It's " + gameManager.getCurrentPlayer().getPlayerName() + "'s turn";

                        turn.setText(turnNow);

                    }













                }
            });




        }


        size++;

        if (head==null){

            head = newNode;
            tail = newNode;

        } else {

            tail.next= newNode;
            tail = newNode;


            // Set next to first
            tail.next = head; // TODO SEE IF THIS ACTUALLY WORKS


        }

    }

    public Node getLast(){


        return tail;

    }

    public Node getFirst(){

        // Will select the first Node you have
        selected = head;

        return selected;
    }



    public Node next(){

        this.selected=selected.next;

        return selected;

    }



    public Node next(Node selected){

        // Gets the next element
        this.selected = selected.next;


        return selected;


    }

    public int size(){

        return size;
    }









    // Method to insert a new node
    public static LinkedSlotsList insert(LinkedSlotsList list, KalahaSlot data)
    {
        // Create a new node with given data
        Node new_node = new Node(data);
        new_node.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = new_node;
        }
        else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new_node at last node
            last.next = new_node;
        }

        // Return the list by head
        return list;
    }
}

