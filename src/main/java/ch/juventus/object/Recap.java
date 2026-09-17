package ch.juventus.object;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Recap {

    static void main() {

        Player lucy = new Player("Lucy");
        Player tom = new Player("Tom");
        Player fred = new Player("Fred");
        Player robert = new Player("Robert");
        Player anotherTom = new Player("Tom");

        Game game = new Game();
        game.register(lucy);
        game.register(tom);
        game.register(fred);
        game.register(robert);
        game.register(anotherTom);

        game.play();

        game.printWinner();
    }

    static class Player {
        private final String name;
        private int points;

        public Player(String name) {
            this.name = name;
        }

        public void roll() {
            Random random = new Random();
            int number = random.nextInt(6) + 1;
            points += number;
        }

        public String getName() {
            return name;
        }

        public int getPoints() {
            return points;
        }

        @Override
        public String toString() {
            return name + " with " + points + " points";
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Player player = (Player) o;
            return Objects.equals(name, player.name);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(name);
        }
    }

    static class Game {
        private final List<Player> players;

        public Game() {
            this.players = new ArrayList<>();
        }

        /**
         * Should only register a new player if name is not taken
         * @param newPlayer
         * @return if the player was registered or not
         */
        public boolean register(Player newPlayer) {
            for(Player existingPlayer : players) {
                if(existingPlayer.equals(newPlayer)) {
                    System.out.println("Failed to register " + newPlayer.getName());
                    return false;
                }
            }
            players.add(newPlayer);
            System.out.println("Successfully registered " + newPlayer.getName());
            return true;
        }

        public void play() {
            for (Player player : players) {
                player.roll();
            }
        }

        public void printWinner() {
            if (players.isEmpty()) {
                System.out.println("No players registered.");
                return;
            }

            Player winner = players.getFirst();

            for (Player player : players) {
                if (player.getPoints() > winner.getPoints()) {
                    winner = player;
                }
            }

            System.out.println("The winner is: " + winner);
        }
    }
}
