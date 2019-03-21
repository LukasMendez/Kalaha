/**
 * Created by Lukas
 * 20-03-2019.
 */
public class GameManager {

    LinkedSlotsList linkedSlotsList;
    Player player1;
    Player player2;

    Player currentPlayer;


    public GameManager(Player player1, Player player2){

        this.player1=player1;
        this.player2=player2;

        // Player one always start
        currentPlayer = player1;

    }

    public void switchTurn(){

        if (currentPlayer==player1){

            currentPlayer=player2;
        } else if (currentPlayer==player2){

            currentPlayer=player1;

        }

    }

    public Player getCurrentPlayer(){


        return currentPlayer;
    }


    /**
     *
     * Will check if they both have the same name
     * @param o any object.  Has to be of type Player though
     * @return true or false depending of equality
     */

    public boolean compare(Object o){


        return ((Player)o).getPlayerName().equals(currentPlayer.getPlayerName());

    }




}
