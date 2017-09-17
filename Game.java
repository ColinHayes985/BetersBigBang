import javax.swing.*; // Import JOptionPane & features
import java.util.*; // Import Random

public class Game {
    private static String gameName = "Beter's Big Bang: The Kava Kaverns";
    private static String welcome = "Welcome to Beter's Big Bang: The Kava Kaverns! Are you ready to start?";
    public static Room[][] map;
    public static Player player;

    public static void main(String[] args) {
        boolean winCondition = false; // Used to see if the player has won
        boolean isDead = false;
        Scanner s = new Scanner(System.in);
        map = new Room[5][8]; // New array of Rooms for the map

        // Map [3][5] -- START (ROOM 0)
        char[][] layout0 = {{'/', '/', '/', '/', 'D', '/', '/', '/', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', 'O', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '/', '/', '/', '/', '/', '/', '/', '/'}};
        map[3][5] = new Room(layout0); // Stores layout for map[3][5] into layout

        // Map [2][5] -- ROOM 1
        char[][] layout1 = {{'/', '/', '/', '/', 'D', '/', '/', '/', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', '|', ' ', '|', ' ', ' ', '/'},
                {'D', ' ', ' ', '|', '*', '|', ' ', ' ', 'D'},
                {'/', ' ', ' ', '|', '|', '|', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '/', '/', '/', 'D', '/', '/', '/', '/'}};
        map[2][5] = new Room(layout1);

        // Map [2][6] -- ROOM 2
        char[][] layout2 = {{'/', '/', '/', '/', '/', '/', '/', '/', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', '|', ' ', '|', ' ', ' ', '/'},
                {'D', ' ', ' ', '|', ' ', '|', ' ', ' ', 'D'},
                {'/', ' ', ' ', '|', '|', '|', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '/', '/', '/', 'D', '/', '/', '/', '/'}};
        map[2][6] = new Room(layout2);

        // Map [3][6] -- ROOM 3
        char[][] layout3 = {{'/', '/', '/', '/', 'D', '/', '/', '/', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '|', '|', '|', '|', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', '|', '|', '|', '|', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '/', '/', '/', 'D', '/', '/', '/', '/'}};
        map[3][6] = new Room(layout3);

        // Map [4][6] -- ROOM 4
        char[][] layout4 = {{'/', '/', '/', '/', 'D', '/', '/', '/', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', '|', '|', '|', '|', '|', '/'},
                {'/', ' ', ' ', '|', ' ', ' ', ' ', ' ', 'D'},
                {'/', ' ', ' ', '|', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', '|', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '/', '/', '/', '/', '/', '/', '/', '/'}};
        map[4][6] = new Room(layout4);

        // Map [2][4] -- ROOM 5
        char[][] layout5 = {{'/', '/', '/', '/', '/', '/', '/', '/', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', '|', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', '|', ' ', ' ', ' ', ' ', '/'},
                {'D', ' ', ' ', '|', ' ', ' ', ' ', ' ', 'D'},
                {'/', ' ', ' ', '|', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', '|', '|', '|', '|', '|', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '/', '/', '/', 'D', '/', '/', '/', '/'}};
        map[2][4] = new Room(layout5);

        // Map [3][4] -- ROOM 6
        char[][] layout6 = {{'/', '/', '/', '/', 'D', '/', '/', '/', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '|', '|', '|', '|', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', '|', '|', '|', '|', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '/', '/', '/', 'D', '/', '/', '/', '/'}};
        map[3][4] = new Room(layout6);

        // Map [4][4] -- ROOM 7
        char[][] layout7 = {{'/', '/', '/', '/', 'D', '/', '/', '/', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', '*', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '/', '/', '/', '/', '/', '/', '/', '/'}};
        map[4][4] = new Room(layout7);

        // Map [4][7] -- ROOM 8
        char[][] layout8 = {{'/', '/', '/', '/', '/', '/', '/', '/', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', '*', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'D', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', '*', ' ', '/'},
                {'/', '/', '/', '/', '/', '/', '/', '/', '/'}};
        map[4][7] = new Room(layout8);

        // Map[2][7] -- ROOM 9 (and 11)
        char[][] layout9 = {{'/', '/', '/', '/', 'D', '/', '/', '/', '/'},
                {'/', '|', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', '|', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', '|', ' ', ' ', ' ', ' ', '/'},
                {'D', ' ', ' ', ' ', '|', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', '|', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', '|', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '/', '/', '/', '/', '/', '/', '/', '/'}};
        map[2][7] = new Room(layout9);

        // Map [1][7] -- ROOM 10
        char[][] layout10 = {{'/', '/', '/', '/', '/', '/', '/', '/', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', '*', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '/', '/', '/', 'D', '/', '/', '/', '/'}};
        map[1][7] = new Room(layout10);

        // Map [1][6] -- ROOM 11 (and 9)
        char[][] layout11 = {{'/', '/', '/', '/', 'D', '/', '/', '/', '/'},
                {'/', '|', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', '|', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', '|', ' ', ' ', ' ', ' ', '/'},
                {'D', ' ', ' ', ' ', '|', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', '|', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', '|', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '/', '/', '/', '/', '/', '/', '/', '/'}};
        map[1][6] = new Room(layout11);

        // Map [1][5] -- ROOM 12
        char[][] layout12 = {{'/', '/', '/', '/', '/', '/', '/', '/', '/'},
                {'/', '*', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', '|', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', '|', ' ', ' ', ' ', 'D'},
                {'/', ' ', ' ', ' ', ' ', '|', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', '|', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', '|', '/'},
                {'/', '/', '/', '/', 'D', '/', '/', '/', '/'}};
        map[1][5] = new Room(layout12);

        // Map [2][3] -- ROOM 13
        char[][] layout13 = {{'/', '/', '/', '/', 'D', '/', '/', '/', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', '|', '|', '|', ' ', ' ', '/'},
                {'D', ' ', ' ', ' ', '*', '|', ' ', ' ', '/'},
                {'/', ' ', ' ', '|', '|', '|', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '/', '/', '/', 'D', '/', '/', '/', '/'}};
        map[2][3] = new Room(layout13);

        // Map [3][3] -- ROOM 14
        char[][] layout14 = {{'/', '/', '/', '/', 'D', '/', '/', '/', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', '|', '|', '|', '|', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '|', '|', '|', '|', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '/', '/', '/', 'D', '/', '/', '/', '/'}};
        map[3][3] = new Room(layout14);

        // Map [4][3] -- ROOM 15
        char[][] layout15 = {{'/', '/', '/', '/', 'D', '/', '/', '/', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '|', '|', '|', '|', '|', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', '|', ' ', ' ', '/'},
                {'D', ' ', ' ', ' ', ' ', '|', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', '|', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', '|', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '/', '/', '/', '/', '/', '/', '/', '/'}};
        map[4][3] = new Room(layout15);

        // Map [0][6] -- ROOM 16
        char[][] layout16 = {{'/', '/', '/', '/', '/', '/', '/', '/', '/'},
                {'/', ' ', '*', ' ', ' ', ' ', 'F', ' ', '/'},
                {'/', ' ', ' ', ' ', '|', '|', '|', '|', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '/', '/', '/', 'D', '/', '/', '/', '/'}};
        map[0][6] = new Room(layout16);

        // Map [0][3] -- ROOM 17
        char[][] layout17 = {{'/', '/', '/', '/', '/', '/', '/', '/', '/'},
                {'/', ' ', ' ', '|', 'F', '|', ' ', ' ', '/'},
                {'/', ' ', ' ', '|', ' ', '|', ' ', ' ', '/'},
                {'/', ' ', ' ', '|', ' ', '|', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', '*', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '/', '/', '/', 'D', '/', '/', '/', '/'}};
        map[0][3] = new Room(layout17);

        // Map [1][3] -- ROOM 18
        char[][] layout18 = {{'/', '/', '/', '/', 'D', '/', '/', '/', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '|', '|', '|', '|', '|', ' ', ' ', '/'},
                {'D', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '|', '|', '|', '|', '|', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '/', '/', '/', 'D', '/', '/', '/', '/'}};
        map[1][3] = new Room(layout18);

        // Map [1][2] -- ROOM 19 (and 20)
        char[][] layout19 = {{'/', '/', '/', '/', '/', '/', '/', '/', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', '|', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', '|', ' ', ' ', ' ', '/'},
                {'D', ' ', ' ', ' ', '|', ' ', ' ', ' ', 'D'},
                {'/', ' ', ' ', ' ', '|', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', '|', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '/', '/', '/', '/', '/', '/', '/', '/'}};
        map[1][2] = new Room(layout19);

        //Map [2][2] -- ROOM 20
        char[][] layout20 = {{'/', '/', '/', '/', '/', '/', '/', '/', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', '|', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', '|', ' ', ' ', ' ', '/'},
                {'D', ' ', ' ', ' ', '|', ' ', ' ', ' ', 'D'},
                {'/', ' ', ' ', ' ', '|', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', '|', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '/', '/', '/', '/', '/', '/', '/', '/'}};
        map[2][2] = new Room(layout20);

        //Map [4][2] -- ROOM 21
        char[][] layout21 = {{'/', '/', '/', '/', '/', '/', '/', '/', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '|', '|', '|', ' ', ' ', ' ', ' ', '/'},
                {'/', 'F', ' ', ' ', ' ', '*', ' ', ' ', 'D'},
                {'/', '|', '|', '|', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '/', '/', '/', '/', '/', '/', '/', '/'}};
        map[4][2] = new Room(layout21);

        //Map [3][1] -- ROOM 22
        char[][] layout22 = {{'/', '/', '/', '/', 'D', '/', '/', '/', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', '*', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '|', '|', '|', '|', '|', ' ', ' ', '/'},
                {'/', 'F', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '/', '/', '/', '/', '/', '/', '/', '/'}};
        map[3][1] = new Room(layout22);

        //Map [2][1] -- ROOM 23 (and 5)
        char[][] layout23 = {{'/', '/', '/', '/', '/', '/', '/', '/', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', '|', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', '|', ' ', ' ', ' ', ' ', '/'},
                {'D', ' ', ' ', '|', ' ', ' ', ' ', ' ', 'D'},
                {'/', ' ', ' ', '|', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', '|', '|', '|', '|', '|', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '/', '/', '/', 'D', '/', '/', '/', '/'}};
        map[2][1] = new Room(layout23);

        //Map [2][0] -- ROOM 24
        char[][] layout24 = {{'/', '/', '/', '/', '/', '/', '/', '/', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', '*', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'D'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', '*', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '/', '/', '/', '/', '/', '/', '/', '/'}};
        map[2][0] = new Room(layout24);

        //Map [1][1] -- ROOM 25
        char[][] layout25 = {{'/', '/', '/', '/', '/', '/', '/', '/', '/'},
                {'/', ' ', '|', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', '|', ' ', ' ', ' ', '|', ' ', '/'},
                {'/', ' ', '|', ' ', ' ', ' ', '|', ' ', '/'},
                {'D', ' ', '|', ' ', ' ', ' ', '|', ' ', 'D'},
                {'/', ' ', '|', ' ', ' ', ' ', '|', ' ', '/'},
                {'/', ' ', '|', ' ', ' ', ' ', '|', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', '|', ' ', '/'},
                {'/', '/', '/', '/', '/', '/', '/', '/', '/'}};
        map[1][1] = new Room(layout25);

        //Map [1][0] -- ROOM 26
        char[][] layout26 = {{'/', '/', '/', '/', 'D', '/', '/', '/', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', '|', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', '|', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', '|', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', '|', ' ', ' ', ' ', 'D'},
                {'/', ' ', ' ', '|', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', '|', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
                {'/', '/', '/', '/', '/', '/', '/', '/', '/'}};
        map[1][0] = new Room(layout26);

        char[][] colin = {{'/','/','/','/','/','/','/','/'},
                {'/','?','?','?','?','?','?','/'},
                {'/','?','?','?','?','?','?','/'},
                {'/','?','?','?','?','?','?','/'},
                {'/','?','?','?','?','?','?','/'},
                {'/','?','?','?','?','?','?','/'},
                {'/','?','?','?','?','?','?','/'},
                {'/','?','?','?','?','?','?','/'},
                {'/','?','?','?','?','?','?','/'},
                {'/','?','?','?','?','?','?','/'},
                {'/','?','?','?','?','?','?','/'},
                {'/','/','/','/','/','/','/','/'}};
        map[0][0] = new Room(colin);


        int choice; // Choice int used for all input

        choice = JOptionPane.showConfirmDialog(null, welcome, gameName, JOptionPane.YES_NO_OPTION);
        if (choice == 1 || choice == -1) {
            System.exit(1);
        } // Stops program if user clicks "No" or closes the window


        // Sets Charisma
        String charismaSet = "";
        String[] rollor25 = new String[2]; rollor25[0] = "Roll"; rollor25[1] = "Use 25"; // Creates String[] of choices for rolling or choosing 25
        choice = JOptionPane.showOptionDialog(null, "Welcome, Beter! It's time to pick your stats.\n\nWould you like to roll for your CHARISMA or just take 25 out of 50?",
                gameName, 0, JOptionPane.QUESTION_MESSAGE, null, rollor25, null);
        if (choice == 0) {
            charismaSet = "y";
        }
        else if (choice == 1) {
            charismaSet = "n";
        }
        // Sets Stamina
        String staminaSet = "";
        choice = JOptionPane.showOptionDialog(null, "Interesting choice...\n\nWould you like to roll for your STAMINA or just take 25 out of 50?",
                gameName, 0, JOptionPane.QUESTION_MESSAGE, null, rollor25, null);
        if (choice == 0) {
            staminaSet = "y";
        }
        else if (choice == 1) {
            staminaSet = "n";
        }
        // Sets Luck
        String luckSet = "";
        choice = JOptionPane.showOptionDialog(null, "Hmm... Okay...\n\nWould you like to roll for your LUCK or just take 25 out of 50?",
                gameName, 0, JOptionPane.QUESTION_MESSAGE, null, rollor25, null);
        if (choice == 0) {
            luckSet = "y";
        }
        else if (choice == 1) {
            luckSet = "n";
        }
        // Sets Defense
        String defenseSet = "";
        choice = JOptionPane.showOptionDialog(null, "If you say so...\n\nWould you like to roll for your DEFENSE or just take 25 out of 50?",
                gameName, 0, JOptionPane.QUESTION_MESSAGE, null, rollor25, null);
        if (choice == 0) {
            defenseSet = "y";
        }
        else if (choice == 1) {
            defenseSet = "n";
        }
        // Sends stats to Player class and returns them
        player = new Player(charismaSet, staminaSet, luckSet, defenseSet);

        int charisma = player.getCharisma(); int stamina = player.getStamina(); int luck = player.getLuck(); int defense = player.getDefense();
        JOptionPane.showMessageDialog(null,
                "Here are your stats:\n" +
                        "Charisma: " + charisma + "\n" +
                        "Stamina: " + stamina + "\n" +
                        "Luck: " + luck + "\n" +
                        "Defense: " + defense + "\n",
                gameName, JOptionPane.INFORMATION_MESSAGE);


        JOptionPane.showMessageDialog(null,
                "The date was July 30th, and Beter and his friends were exploring the plentiful corn fields of Purdue and the cold tunnels of Lawson. Right as they were about to call it a day, they discovered the infamous Kava Kaverns.\n" +
                        "Beter's friend Nathan, who was obssessed with Kava, ran into the cave without hesitation, ignoring the sign that clearly read \"DANGER.\" In an effort to save their friend, Beter and the gang ran into the cave after Nathan.\n" +
                        "After a couple hours of exploring and searching, Beter and his friends could not find Nathan, and they were lost and isolated. Just when they thought things couldn't get worse, the walls started to rumble, and the ceiling collapsed on top of Beter and his friends!\n" +
                        "\nTwo weeks later, Beter woke up after being unconcious. He found himself alone in a deserted cave. He looked ahead and saw a door opening up into blackness.\n" +
                        "Beter knews what he must do. He must save his friends and escape the Kava Kaverns! He stood up, and he began to walk forward...",
                gameName, JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null, "Controls:\nW: move up\nA: move left\nD: move right\nS: move down\nI: open inventory", gameName, JOptionPane.INFORMATION_MESSAGE);
        player.addItem("chestPlate");
        JOptionPane.showMessageDialog(null, "You were given a chestplate!", gameName, JOptionPane.INFORMATION_MESSAGE);
        // While loop that runs as long as the player has not won (winCondition bool is not true)
        System.out.println(map[player.getCurrentRoomY()][player.getCurrentRoomX()].print()); // Initial print
        Colin colinsRoom = new Colin();
        while (!winCondition) { // As long as game has not been won
            if (player.getCurrentRoomY() == 0 && player.getCurrentRoomX() == 0) { // Colin's Room
                int py=player.getPositionY();
                int px=player.getPositionX();
                if (colinsRoom.maze[py][px]!='t'&& colinsRoom.maze[py][px]!='D' && colinsRoom.maze[py][px]!='?'){
                    player.setPosition(10,4);
                }
                if (py == 0) {
                    if (colinsRoom.maze[0][px] == 't') {
                        winCondition = true;
                        JOptionPane.showMessageDialog(null,"Beter made it out of the Kava Kaverns alive and he saved " + player.getFriends() + " friends!",gameName,JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            }
            else {
                String keyPressed = s.nextLine();// Accepts WASD input from user
                String keyPressedTest = keyPressed.toLowerCase();
                switch (keyPressedTest) {
                    case "i":
                        int menuSelection = Integer.parseInt(JOptionPane.showInputDialog(null, player.getInventory(), gameName, JOptionPane.INFORMATION_MESSAGE));
                        switch(menuSelection) {
                            case 1:
                                player.useItem(player.getItemAt(0));
                                player.rmFromInventory(player.getItemAt(0));
                                break;
                            case 2:
                                player.useItem(player.getItemAt(1));
                                player.rmFromInventory(player.getItemAt(1));
                                break;
                            case 3:
                                player.useItem(player.getItemAt(2));
                                player.rmFromInventory(player.getItemAt(2));
                                break;
                            case 4:
                                player.useItem(player.getItemAt(3));
                                player.rmFromInventory(player.getItemAt(3));
                                break;
                            case 5:
                                player.useItem(player.getItemAt(4));
                                player.rmFromInventory(player.getItemAt(4));
                                break;
                            case 6:
                                player.useItem(player.getItemAt(5));
                                player.rmFromInventory(player.getItemAt(5));
                                break;
                            case 7:
                                player.useItem(player.getItemAt(6));
                                player.rmFromInventory(player.getItemAt(6));
                                break;
                            case 8:
                                player.useItem(player.getItemAt(7));
                                player.rmFromInventory(player.getItemAt(7));
                                break;
                            case 9:
                                player.useItem(player.getItemAt(8));
                                player.rmFromInventory(player.getItemAt(8));
                                break;
                            case 10:
                                player.useItem(player.getItemAt(9));
                                player.rmFromInventory(player.getItemAt(9));
                                break;
                        }
                    case "w":
                        if (!player.obstacleCheck((player.getPositionY() - 1), player.getPositionX())) {
                            if (!player.doorCheck((player.getPositionY() - 1), player.getPositionX())) {
                                if (!player.eventCheck((player.getPositionY() - 1), player.getPositionX())) {
                                    if (!player.friendCheck((player.getPositionY() - 1), player.getPositionX())) {
                                        player.Revert(player.getPositionY(), player.getPositionX());
                                        player.Draw((player.getPositionY() - 1), player.getPositionX());
                                    }
                                    else {
                                        Event event = new Event();
                                        event.friendFound();
                                        player.Revert(player.getPositionY(), player.getPositionX());
                                        player.Draw((player.getPositionY() - 1), player.getPositionX());
                                    }
                                }
                                else {
                                    Event event = new Event();
                                    isDead = event.eventBegin();
                                    player.Revert(player.getPositionY(), player.getPositionX());
                                    player.Draw((player.getPositionY() - 1), player.getPositionX());
                                }
                            }
                            else {
                                map[player.getCurrentRoomY()][player.getCurrentRoomX()].setCharAt(player.getPositionX(), player.getPositionY(), ' ');
                                player.switchRoom(player.getPositionY(), player.getPositionX());
                                if (player.getCurrentRoomY() == 0 && player.getCurrentRoomX() == 0) {
                                    player.Draw(10, 4);
                                }
                                else {
                                    player.Draw(7, 4);
                                }
                            }
                        }
                        break;
                    case "a":
                        if (!player.obstacleCheck(player.getPositionY(), (player.getPositionX() - 1))) {
                            if (!player.doorCheck(player.getPositionY(), (player.getPositionX() - 1))) {
                                if (!player.eventCheck(player.getPositionY(), (player.getPositionX() - 1))) {
                                    if (!player.friendCheck((player.getPositionY()), (player.getPositionX() - 1))) {
                                        player.Revert(player.getPositionY(), player.getPositionX());
                                        player.Draw((player.getPositionY()), (player.getPositionX() - 1));
                                    }
									else {
                                        Event event = new Event();
                                        event.friendFound();
                                        player.Revert(player.getPositionY(), player.getPositionX());
                                        player.Draw(player.getPositionY(), (player.getPositionX() - 1));
                                    }
                                }
                                else {
                                    Event event = new Event();
                                    isDead = event.eventBegin();
                                    player.Revert(player.getPositionY(), player.getPositionX());
                                    player.Draw(player.getPositionY(), (player.getPositionX() - 1));
                                }
                            }
                            else {
                                map[player.getCurrentRoomY()][player.getCurrentRoomX()].setCharAt(player.getPositionX(), player.getPositionY(), ' ');
                                player.switchRoom(player.getPositionY(), player.getPositionX());
                                player.Draw(4, 7);
                            }
                        }
                        break;
                    case "s":
                        if (!player.obstacleCheck((player.getPositionY() + 1), player.getPositionX())) {
                            if (!player.doorCheck((player.getPositionY() + 1), player.getPositionX())) {
                                if (!player.eventCheck((player.getPositionY() + 1), player.getPositionX())) {
                                    if (!player.friendCheck((player.getPositionY() + 1), player.getPositionX())) {
                                        player.Revert(player.getPositionY(), player.getPositionX());
                                        player.Draw((player.getPositionY() + 1), player.getPositionX());
                                    }
                                    else {
                                        Event event = new Event();
                                        event.friendFound();
                                        player.Revert(player.getPositionY(), player.getPositionX());
                                        player.Draw((player.getPositionY() + 1), player.getPositionX());
                                    }
                                }
                                else {
                                    Event event = new Event();
                                    isDead = event.eventBegin();
                                    player.Revert(player.getPositionY(), player.getPositionX());
                                    player.Draw((player.getPositionY() + 1), player.getPositionX());
                                }
                            }
                            else {
                                map[player.getCurrentRoomY()][player.getCurrentRoomX()].setCharAt(player.getPositionX(), player.getPositionY(), ' ');
                                player.switchRoom(player.getPositionY(), player.getPositionX());
                                player.Draw(1, 4);
                            }
                        }
                        break;
                    case "d":
                        if (!player.obstacleCheck(player.getPositionY(), (player.getPositionX() + 1))) {
                            if (!player.doorCheck(player.getPositionY(), (player.getPositionX() + 1))) {
                                if (!player.eventCheck(player.getPositionY(), (player.getPositionX() + 1))) {
                                    if (!player.friendCheck((player.getPositionY()), (player.getPositionX() + 1))) {
                                        player.Revert(player.getPositionY(), player.getPositionX());
                                        player.Draw((player.getPositionY()), (player.getPositionX() + 1));
                                    }
									else {
                                        Event event = new Event();
                                        event.friendFound();
                                        player.Revert(player.getPositionY(), player.getPositionX());
                                        player.Draw(player.getPositionY(), (player.getPositionX() + 1));
                                    }
                                }
                                else {
                                    Event event = new Event();
                                    isDead = event.eventBegin();
                                    player.Revert(player.getPositionY(), player.getPositionX());
                                    player.Draw(player.getPositionY(), (player.getPositionX()+1));
                                }
                            }
                            else {
                                map[player.getCurrentRoomY()][player.getCurrentRoomX()].setCharAt(player.getPositionX(), player.getPositionY(), ' ');
                                player.switchRoom(player.getPositionY(), player.getPositionX());
                                player.Draw(4, 1);
                            }
                        }
                        break;
                }
                if(isDead){
                    JOptionPane.showMessageDialog(null, "Beter was a good man, but it appears he couldn't handle the Kava Kaverns and has died.\nMay he RIP in all of the Pepperonis.",gameName,JOptionPane.INFORMATION_MESSAGE);
                    break;
                } else {
                    if((player.getCurrentRoomY() == 0) && (player.getCurrentRoomX() == 0)) {
                        winCondition = true;
                        //System.out.println(map[player.getCurrentRoomY()][player.getCurrentRoomX()].printColin());
                    }
                    else {
                        System.out.println(map[player.getCurrentRoomY()][player.getCurrentRoomX()].print()); // Prints current room + Player drawn in
                    }
                }
            }
        }// End while
        JOptionPane.showMessageDialog(null,"Beter made it out of the Kava Kaverns alive and he saved " + player.getFriends() + " friends!",gameName,JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Thank you for playing Beter's Big Bang: The Kava Kaverns!\n\nCredits:\nColin Hayes\nWynn Smith\nJake Harris\nAndrew Davis",gameName,JOptionPane.INFORMATION_MESSAGE);
    } // End of Program

} // End of file
