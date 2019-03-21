import javafx.scene.control.Button;

/**
 * Created by Lukas
 * 12-03-2019.
 */
public class Player {

    private final int PLAYER_AMOUNT = 2;
    private int playerScore = 0;
    private String playerName;

    public Player(String playerName){

        this.playerName=playerName;


    }

    public String getPlayerName(){

        return playerName;
    }

    public void addScore(){

        playerScore++;
    }





}
