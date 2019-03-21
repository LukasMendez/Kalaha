import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Created by Lukas
 * 12-03-2019.
 */
public class KalahaSlot {


    private final int DEFAULT_STARTING_POINT = 0;
    private final int DEFAULT_SLOT_SIZE = 6;


    private int amountOfBalls;



    private Button slotButton;
    private boolean isPointContainer;
    private Player ownerShip;

    private KalahaSlot previous;
    private KalahaSlot next;


    public KalahaSlot(Button slotButton, boolean isPointContainer, Player player){

        if (isPointContainer){

            this.amountOfBalls=DEFAULT_STARTING_POINT; // 0
            this.slotButton=slotButton;
            this.slotButton.setText("0");
            this.isPointContainer=true;

        } else {

            this.amountOfBalls=DEFAULT_SLOT_SIZE; // 6
            this.slotButton=slotButton;
            this.slotButton.setText("6");


        }

        // GIVES OWNER PERMISSIONS TO THE PLAYER
        this.ownerShip = player;


    }

    public Player getOwnerShip(){


        return ownerShip;
    }


    public boolean isPointContainer(){

        return isPointContainer;

    }


















    //TODO THIS SHOULD BE A PART OF THE LINKED LIST BABY

    public void add(KalahaSlot nextKalahaSlot){

        this.next=nextKalahaSlot;
        next.setPrevious(this);


    }

    public void setPrevious(KalahaSlot previousKalahaSlot){

        previous = previousKalahaSlot;

    }



    public Button getSlotButton() {
        return slotButton;
    }

}






