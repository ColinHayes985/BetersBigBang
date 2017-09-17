public class Room {
    private char[][] layout = new char[9][9]; // New character array to store layout

    public Room(char[][] a) { // Constructor
        layout = a; // Takes layout from Game.java and stores it as a layout of that room
    } // End constructor

    public String print() {
        String map = "";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                map = map + layout[i][j];
            }
            map = map + "\n";
        }
        return map;
    }

    public String printColin() {
        String map = "";
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 8; j++) {
                map = map + layout[i][j];
            }
            map = map + "\n";
        }

        return map;
    }

    public char getCharAt(int i, int j) {
        return layout[i][j];
    }

    public void setCharAt(int i, int j, char a) {
        layout[i][j] = a;
    }
}