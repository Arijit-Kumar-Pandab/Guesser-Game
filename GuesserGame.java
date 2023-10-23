import java.util.Scanner;

/**
 * GuesserGame
 */
class Guesser {
    int num;

    public int guessNum() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Guess the number for guesser :");
        num = sc.nextInt();
        return num;
    }
}

class Player {
    int num;

    public int guessNum() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Guess the number for player :");
        num = sc.nextInt();
        return num;
    }
}

class Umpire {
    int numFromGuesser;
    int numFromPlayer1;
    int numFromPlayer2;
    int numFromPlayer3;

    public void getNumFromGuesser() {
        Guesser gs = new Guesser();
        numFromGuesser = gs.guessNum();
    }

    public void getNumbFromPlayers() {
        Player pl = new Player();
        numFromPlayer1 = pl.guessNum();
        numFromPlayer2 = pl.guessNum();
        numFromPlayer3 = pl.guessNum();
    }

    public void compare() {
        boolean check = true;
        while (check) {
            if (numFromGuesser == numFromPlayer1 && numFromGuesser == numFromPlayer2
                    && numFromGuesser == numFromPlayer3) {
                System.out.println("All players guessed correct number, Let's play again.");
                getNumFromGuesser();
                getNumbFromPlayers();
                continue;
            } else if ((numFromGuesser == numFromPlayer1 && numFromGuesser == numFromPlayer2)
                    || (numFromGuesser == numFromPlayer2 && numFromGuesser == numFromPlayer3)
                    || (numFromGuesser == numFromPlayer1 && numFromGuesser == numFromPlayer3)) {
                System.out.println("Two players guessed correct answer, Let's play again.");
                getNumFromGuesser();
                getNumbFromPlayers();
                continue;
            } else if (numFromGuesser == numFromPlayer1) {
                System.out.println("Player 1 is the winner.");
                check = false;
            } else if (numFromGuesser == numFromPlayer2) {
                System.out.println("Player 2 is the winner.");
                check = false;
            } else if (numFromGuesser == numFromPlayer3) {
                System.out.println("Player 3 is the winner");
                check = false;
            } else {
                System.out.println("No one guesses correctly, let's play again.");
                getNumFromGuesser();
                getNumbFromPlayers();
            }
        }
    }
}

public class GuesserGame {
    public static void main(String[] args) {
        Umpire u = new Umpire();
        u.getNumFromGuesser();
        u.getNumbFromPlayers();
        u.compare();
    }
}