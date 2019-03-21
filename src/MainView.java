import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.LinkedList;

/**
 * Created by Lukas and Alex
 * 12-03-2019.
 */
public class MainView extends Application implements EventHandler {



    private Label playerTurnLabel = new Label();
    private String playerNameTurn = "Player 1";

    private Player player1 = new Player("Player 1");
    private Player player2 = new Player("Player 2");

    // Default Linked List
    private LinkedList<KalahaSlot> kalahaSlots = new LinkedList<>();

    // Our own Linked List - needs player information. No GRASP patterns were respected that day
    private LinkedSlotsList kalahaList = new LinkedSlotsList(player1,player2, playerTurnLabel);



    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root,800,500);
        primaryStage.setResizable(false);


        Pane pane = new Pane();
        root.setCenter(pane);


      //  playerTurnLabel.setText("It's " + playerNameTurn + "'s turn");
        playerTurnLabel.setLayoutX(370);
        playerTurnLabel.setLayoutY(100);

        pane.getChildren().add(playerTurnLabel);


        ///////////////////////////////////

        // CREATION OF PLAYERS

    //    Player player1 = new Player("Alex");
      //  Player player2 = new Player("Lukas");


        // WILL BUILD THE BOARD

        // Default Linked List
       // buildBoard(kalahaSlots,player1,player2, pane);

        // Our own Linked List

        buildBoard(kalahaList,player1,player2,pane);






        // TESTING AREA

        scene.getStylesheets().addAll("Sample.css");






        primaryStage.setScene(scene);
        primaryStage.show();






    }


    /**
     *
     * This is the preferred method
     * @param slots
     * @param player1
     * @param player2
     * @param pane
     */
    @SuppressWarnings("Duplicates")
    private static void buildBoard(LinkedSlotsList slots, Player player1, Player player2, Pane pane){

        // FIRST PLAYER (PLAYER 1)

        Button[] playerOneButtons = new Button[6];
        Button playerOnePointSlot = new Button();

        // SECOND PLAYER (PLAYER 2)

        Button[] playerTwoButtons = new Button[6];
        Button playerTwoPointSlot = new Button();

        // POSITION MANAGEMENT

        int x = 600; // START POSITION


        // WILL ADD THE SLOTS OF THE FIRST PLAYERS BUTTONS
        for (int i = 0; i < playerOneButtons.length; i++) {

            // YOU HAVE TO INITIALIZE EACH BUTTON TO PREVENT NULL POINTER EXCEPTION
            playerOneButtons[i] = new Button();

            slots.add(new KalahaSlot(playerOneButtons[i],false, player1));

            // SET POSITION

            slots.getLast().getData().getSlotButton().setLayoutX(x);

            slots.getLast().getData().getSlotButton().setLayoutY(300);


            x=x-83; // direction of placing the slots



        }
        // WILL ADD THE POINT CONTAINER
        slots.add(new KalahaSlot(playerOnePointSlot,true, player1));

        // SET THE POSITION

        slots.getLast().getData().getSlotButton().setLayoutX(x+83);

        slots.getLast().getData().getSlotButton().setLayoutY(217); // TODO THESE ARE MAGIC NUMBERS, AND SHOULD BE CHANGED SOON!!

        x=x+83; // GET BACK TO RIGHT POSITION

        for (int i = 0; i < playerTwoButtons.length; i++) {

            playerTwoButtons[i] = new Button();

            slots.add(new KalahaSlot(playerTwoButtons[i],false,player2));

            slots.getLast().getData().getSlotButton().setLayoutX(x);

            slots.getLast().getData().getSlotButton().setLayoutY(150);

            if (i!=playerTwoButtons.length-1){

                x=x+83;
            }



        }

        slots.add(new KalahaSlot(playerTwoPointSlot,true,player2));

        // SET THE POSITION

        slots.getLast().getData().getSlotButton().setLayoutX(x);

        slots.getLast().getData().getSlotButton().setLayoutY(217); // TODO THESE ARE MAGIC NUMBERS, AND SHOULD BE CHANGED SOON!!



        // WILL ACTUALLY BUILD THE BOARD

        placeElements(slots, pane);








    }

    private static void placeElements(LinkedSlotsList slots, Pane pane){


        // Place the first building block
        pane.getChildren().add(slots.getFirst().getData().getSlotButton());


        for (int i = 0; i < slots.size()-1; i++) {

            pane.getChildren().add(slots.next().getData().getSlotButton());

        }


    }




    public void startGame(){


        playerNameTurn = player1.getPlayerName();

        playerTurnLabel.setText("It's " + playerNameTurn + "'s turn");








    }






































    // USING THE DEFAULT LINKED LIST



    /**
     *
     * Please don't look too much at this code. It's pretty messed up.
     * @param slots
     * @param player1
     * @param player2
     * @param pane
     */
    @SuppressWarnings("Duplicates")
    private static void buildBoard(LinkedList<KalahaSlot> slots, Player player1, Player player2, Pane pane){

        // FIRST PLAYER (PLAYER 1)

        Button[] playerOneButtons = new Button[6];
        Button playerOnePointSlot = new Button();

        // SECOND PLAYER (PLAYER 2)

        Button[] playerTwoButtons = new Button[6];
        Button playerTwoPointSlot = new Button();

        // POSITION MANAGEMENT

        int x = 600; // START POSITION


        // WILL ADD THE SLOTS OF THE FIRST PLAYERS BUTTONS
        for (int i = 0; i < playerOneButtons.length; i++) {

            // YOU HAVE TO INITIALIZE EACH BUTTON TO PREVENT NULL POINTER EXCEPTION
            playerOneButtons[i] = new Button();

            slots.add(new KalahaSlot(playerOneButtons[i],false, player1));

            // SET POSITION

           slots.getLast().getSlotButton().setLayoutX(x);

           slots.getLast().getSlotButton().setLayoutY(300);


                x=x-83; // direction of placing the slots



        }
        // WILL ADD THE POINT CONTAINER
        slots.add(new KalahaSlot(playerOnePointSlot,true, player1));

        // SET THE POSITION

        slots.getLast().getSlotButton().setLayoutX(x+83);

        slots.getLast().getSlotButton().setLayoutY(217); // TODO THESE ARE MAGIC NUMBERS, AND SHOULD BE CHANGED SOON!!

        x=x+83; // GET BACK TO RIGHT POSITION

        for (int i = 0; i < playerTwoButtons.length; i++) {

            playerTwoButtons[i] = new Button();

            slots.add(new KalahaSlot(playerTwoButtons[i],false,player2));

            slots.getLast().getSlotButton().setLayoutX(x);

            slots.getLast().getSlotButton().setLayoutY(150);

            if (i!=playerTwoButtons.length-1){

                x=x+83;
            }



        }

        slots.add(new KalahaSlot(playerTwoPointSlot,true,player2));

        // SET THE POSITION

        slots.getLast().getSlotButton().setLayoutX(x);

        slots.getLast().getSlotButton().setLayoutY(217); // TODO THESE ARE MAGIC NUMBERS, AND SHOULD BE CHANGED SOON!!



        // WILL ACTUALLY BUILD THE BOARD

        placeElements(slots, pane);








    }
















    private static void placeElements(LinkedList<KalahaSlot> slots, Pane pane){

        for (int i = 0; i < slots.size(); i++) {

            pane.getChildren().add(slots.get(i).getSlotButton());

        }


    }

















    @Override
    public void handle(Event event) {

    }
}
