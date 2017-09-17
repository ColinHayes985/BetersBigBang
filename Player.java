import java.util.Random;

public class Player extends Game {
    private Random stat = new Random();
    private int health = 0;
    private int currentHealth = 0;      //Used for health potions/damage/deathCheck
    private int charisma = 0;
    private int stamina = 0;
    private int luck = 0;
    private int defense = 0; //Check to make battles more interesting
    private int friends = 0; //total of 4 friends to find
    private int positionX = 0;
    private int positionY = 0;
    private int roomX = 0;
    private int roomY = 0;
    private String[] inventory = new String[10]; //bag size of 10

    public int getHealth() {
        return health;
    }
    public void setHealth(int value) {
        health = value;
    }
    public int getCharisma() {
        return charisma;
    }
    public void setCharisma(int value) {
        charisma = value;
    }
    public int getStamina() {
        return stamina;
    }
    public void setStamina(int value) {
        stamina = value;
    }
    public int getLuck() {
        return luck;
    }
    public void setLuck(int value) {
        luck = value;
    }
    public int getDefense() {
        return defense;
    }
    public void setDefense(int value) {
        defense = value;
    }
    public int getFriends() {               //returns how many friends have been found
        return friends;
    }
    public void addFriend() {               //increments friends
        friends = friends + 1;
    }
    public int getPositionY() {             //Y position of player within the current room
        return positionY;
    }
    public int getPositionX() {             //X position of player within the current room
        return positionX;
    }
    public void setPosition(int y, int x) { //set pos of player within room
        positionY = y;
        positionX = x;
    }
    public boolean obstacleCheck(int y, int x) { //throws boolean flag true if there is an obstacle at the given x and y coords
        if (map[roomY][roomX].getCharAt(y, x) == '/' || map[roomY][roomX].getCharAt(y, x) == '|') {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean doorCheck(int y, int x) { //throws boolean flag true if there is an door at the given x and y coords
        if (map[roomY][roomX].getCharAt(y, x) == 'D') {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean eventCheck(int y, int x) { //throws boolean flag true if there is an event at the given x and y coords
        if (map[roomY][roomX].getCharAt(y, x) == '*') {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean friendCheck(int y, int x) { //throws boolean flag true if there is an event at the given x and y coords
        if (map[roomY][roomX].getCharAt(y, x) == 'F') {
            return true;
        }
        else {
            return false;
        }
    }
    public int getCurrentRoomX() {              //Returns the X-coord of the current room within the map
        return roomX;
    }
    public int getCurrentRoomY() {              //Returns the Y-coord of the current room within the map
        return roomY;
    }
    public void setCurrentRoom(int i, int j) {  //Sets the X and Y values of the coords of the current room within the map
        roomY = i;
        roomX = j;
    }
    public void Revert(int y, int x) {              //used to revert a space back to ' ' when the 'O' is moved to a different space
        map[roomY][roomX].setCharAt(y, x, ' ');
    }
    public void Draw(int y, int x) {                //draws the 'O' onto the current room at a given X and Y
        map[roomY][roomX].setCharAt(y, x, 'O');
        setPosition(y, x);
    }
    public void switchRoom(int y, int x) {          //Used to move between rooms when the player goes through a door
        if (x == 1) {
            roomX--;
        }
        else if (y == 1) {
            roomY--;
        }
        else if (y == 7) {
            roomY++;
        }
        else if (x == 7) {
            roomX++;
        }
    }
    public int attack() {                               //Attacks enemy based on Stamina stat
        return (int) (Math.random() * (stamina / 2));
    }
    public int defend() {                               //Defends next incoming attack based on Defense stat
        if(defense >= 0 && 10 <= defense) {
            return 0;
        }
        else if(defense >=11 && 20 >= defense) {
            return 5;
        }
        else if(defense >= 21 && 30 >= defense) {
            return 10;
        }
        else if(defense >= 31 && 40 >= defense) {
            return 15;
        }
        else if(defense >= 41 && 50 >= defense) {
            return 20;
        }
        else {
            return -1;
        }
    }
    public String getItemAt(int i) {
        return inventory[i];
    }
    public String getInventory() {                              //Used to display menu of current items
        String result = "";
        for (int i = 0; i < inventory.length; i++) {
            result = (i + 1) + ". " + inventory[i] + "\n";
        }
        return result;
    }
    public void addItem(String item) {
        boolean added = false;
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null || inventory[i] == "") {
                if (!added) {
                    inventory[i] = item;
                    added = true;
                }
            }
        }
    }
    public boolean itemExists(String item) {
        for (int i = 0; i < inventory.length; i++) { //checks to see if the item is in the player's inventory
            if (inventory[i].equalsIgnoreCase(item)) {
                return true;
            }
        }
        return false;
    }
    public void useItem(String item) {
        switch(item) {
            case "healthPotion":
                currentHealth += 20;
                if (currentHealth > 50) {
                    currentHealth = 50;
                }
                break;
            case "chestPlate":
                defense += 10;
                break;
            case "helmet":
                defense += 5;
                break;
            case "boots":
                defense += 5;
                break;
            case "shield":
                defense += 15;
                break;
            case "dagger":
                stamina += 5;
                break;
            case "axe":
                stamina += 10;
                break;
            case "sword":
                stamina += 15;
                break;
            case "luckyCharm":
                luck += 10;
                break;
            case "energyPotion":
                stamina += 10;
                break;
            case "charismaPotion":
                charisma += 10;
                break;
            default:
                break;
        }
    }
    public void rmFromInventory(String item) {
        boolean hasBeenRemoved = false;
        for (int i = 0; i < inventory.length; i++) {
            if (hasBeenRemoved) {
                return;
            }
            if (inventory[i].equals(item)) {
                inventory[i] = "";
                hasBeenRemoved = true;
            }
        }

    }
    Player() {
        health = 0;
        charisma = 0;
        stamina = 0;
        luck = 0;
        defense = 0;
        friends = 0;
        positionX = 4;
        positionY = 4;
        roomX = 5;
        roomY = 3;
    }
    Player(int h, int c, int s, int l, int d) {
        health = h;
        charisma = c;
        stamina = s;
        luck = l;
        defense = d;
        friends = 0;
        positionX = 4;
        positionY = 4;
        roomX = 5;
        roomY = 3;
    }
    Player(String c2, String c3, String c4, String c5) {
        health = 50;
        if (c2.equalsIgnoreCase("y")) {
            charisma = stat.nextInt(51);
        }
        else {
            charisma = 25;
        }
        if (c3.equalsIgnoreCase("y")) {
            stamina = stat.nextInt(51);
        }
        else {
            stamina = 25;
        }
        if (c4.equalsIgnoreCase("y")) {
            luck = stat.nextInt(51);
        }
        else {
            luck = 25;
        }
        if (c5.equalsIgnoreCase("y")) {
            defense = stat.nextInt(51);
        }
        else {
            defense = 25;
        }
        friends = 0;
        positionX = 4;
        positionY = 4;
        roomX = 5;
        roomY = 3;
    }
}