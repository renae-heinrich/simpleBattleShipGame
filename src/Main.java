import java.util.Scanner;

class SimpleBattleShip {
    private int[] battleShip;
    private int numOfHits;

    public void setBattleShip(int[] locationCells) {
        battleShip = locationCells;
    }

    public String checkIfHitOrMiss(String guess) {
        //get the user guess as a String parameter
        // CONVERT the user guess to an int
        int guessToInt = Integer.parseInt(guess);

        String result = "Miss!";
        //REPEAT with each of the location cells in the int array
        // COMPARE the user guess to the location cell
        // IF the user guess matched
        // INCREMENT the number of hits
        for (int cell : battleShip) {
            if (guessToInt == cell) {
                result = "Hit";
                numOfHits++;
                break;
            }
        }
        //if number of hits equals the length of the length of the battleship
        if (numOfHits == battleShip.length) {
            result = "Kill";
        }
        System.out.println(result);
        return result;
    }
}

public class Main {

    public static void main(String[] args) {

        int numOfGuesses = 0;
        boolean isAlive = true;
        SimpleBattleShip game = new SimpleBattleShip();

        //compute a random number between 0 and 4 that will be the starting location cell position
        int randomNumber = (int) (Math.random() * 5);

        //MAKE an int array with 3 ints using the randomly generated number, that number incremented by 1, and that number incremented by 2.
        int[] battleShip = {randomNumber, randomNumber + 1, randomNumber + 2};
//        printArray(battleShip);

        //invoke the setBattleShip instance on the game instance to set the battle ship position
        game.setBattleShip(battleShip);

        System.out.println("~~ Simple Battleship ~~ \nTo guess where the BattleShip is, guess the position of where the ship is, starting from 0.");

        while(isAlive == true){
            Scanner scanner = new Scanner(System.in);

            System.out.print("Please enter your guess: ");
            String userGuess = scanner.nextLine();
            String result = game.checkIfHitOrMiss(userGuess);
            numOfGuesses ++;

            if (result.equals("Kill")){
                isAlive = false;
                System.out.println("Number of guesses: " + numOfGuesses);
                break;
            }

        }



    }

    private static void printArray(int[] ship) {
        for (var i : ship) {
            System.out.print(i);
        }
        System.out.println();
    }

}
