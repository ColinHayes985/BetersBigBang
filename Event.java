import javax.swing.*;
import java.util.*;

public class Event extends Player {
    int roomNum = 0;
    private static String gameName = "Beter's Big Bang: The Kava Kaverns";

    public Event() {
    }

    public boolean eventBegin() {

        Random r = new Random();
        int event = r.nextInt(4);
        System.out.println(event);
        Enemy vampice;
        if (event == 0) {

            // Turns map[][] format to roomNum
            if (player.getCurrentRoomY() == 0 && player.getCurrentRoomX() == 3) {
                roomNum = 17;
            }
            else if (player.getCurrentRoomY() == 0 && player.getCurrentRoomX() == 6) {
                roomNum = 16;
            }
            else if (player.getCurrentRoomY() == 1 && player.getCurrentRoomX() == 0) {
                roomNum = 26;
            }
            else if (player.getCurrentRoomY() == 1 && player.getCurrentRoomX() == 1) {
                roomNum = 25;
            }
            else if (player.getCurrentRoomY() == 1 && player.getCurrentRoomX() == 2) {
                roomNum = 19;
            }
            else if (player.getCurrentRoomY() == 1 && player.getCurrentRoomX() == 3) {
                roomNum = 18;
            }
            else if (player.getCurrentRoomY() == 1 && player.getCurrentRoomX() == 5) {
                roomNum = 12;
            }
            else if (player.getCurrentRoomY() == 1 && player.getCurrentRoomX() == 6) {
                roomNum = 11;
            }
            else if (player.getCurrentRoomY() == 1 && player.getCurrentRoomX() == 7) {
                roomNum = 10;
            }
            else if (player.getCurrentRoomY() == 2 && player.getCurrentRoomX() == 0) {
                roomNum = 24;
            }
            else if (player.getCurrentRoomY() == 2 && player.getCurrentRoomX() == 1) {
                roomNum = 23;
            }
            else if (player.getCurrentRoomY() == 2 && player.getCurrentRoomX() == 2) {
                roomNum = 20;
            }
            else if (player.getCurrentRoomY() == 2 && player.getCurrentRoomX() == 3) {
                roomNum = 13;
            }
            else if (player.getCurrentRoomY() == 2 && player.getCurrentRoomX() == 4) {
                roomNum = 5;
            }
            else if (player.getCurrentRoomY() == 2 && player.getCurrentRoomX() == 5) {
                roomNum = 1;
            }
            else if (player.getCurrentRoomY() == 2 && player.getCurrentRoomX() == 6) {
                roomNum = 2;
            }
            else if (player.getCurrentRoomY() == 2 && player.getCurrentRoomX() == 7) {
                roomNum = 9;
            }
            else if (player.getCurrentRoomY() == 3 && player.getCurrentRoomX() == 1) {
                roomNum = 22;
            }
            else if (player.getCurrentRoomY() == 3 && player.getCurrentRoomX() == 3) {
                roomNum = 14;
            }
            else if (player.getCurrentRoomY() == 3 && player.getCurrentRoomX() == 4) {
                roomNum = 6;
            }
            else if (player.getCurrentRoomY() == 3 && player.getCurrentRoomX() == 5) {
                roomNum = 0;
            }
            else if (player.getCurrentRoomY() == 3 && player.getCurrentRoomX() == 6) {
                roomNum = 3;
            }
            else if (player.getCurrentRoomY() == 4 && player.getCurrentRoomX() == 2) {
                roomNum = 21;
            }
            else if (player.getCurrentRoomY() == 4 && player.getCurrentRoomX() == 3) {
                roomNum = 15;
            }
            else if (player.getCurrentRoomY() == 4 && player.getCurrentRoomX() == 4) {
                roomNum = 7;
            }
            else if (player.getCurrentRoomY() == 4 && player.getCurrentRoomX() == 6) {
                roomNum = 4;
            }
            else if (player.getCurrentRoomY() == 4 && player.getCurrentRoomX() == 7) {
                roomNum = 8;
            }
            else {
                roomNum = -1;
            }

            //Player encounters an enemy
            JOptionPane.showMessageDialog(null, "A wild Vampice appears! It has been rumored that these things have haunted the Kava Kaverns for centuries! They feed off the Kava and any unsuspecting people to stumble upon the kavern. This could be a rough day for Beter...", gameName, JOptionPane.INFORMATION_MESSAGE);
            if (roomNum >= 1 && roomNum <= 7) {
                vampice = new Enemy(50, (r.nextInt(20) + 1), (r.nextInt(20) + 1), 1);
                JOptionPane.showMessageDialog(null, "Luckily, this vampice doesn't look too strong, it appears to be wearing a torn-up IU shirt.", gameName, JOptionPane.INFORMATION_MESSAGE);
            } else if (roomNum >= 8 && roomNum <= 15) {
                vampice = new Enemy(50, (r.nextInt(30) + 11), (r.nextInt(30) + 11), 2);
                JOptionPane.showMessageDialog(null, "This vampice looks kinda tough, this could mean trouble...", gameName, JOptionPane.INFORMATION_MESSAGE);
            } else if (roomNum >= 16 && roomNum <= 26) {
                vampice = new Enemy(50, (r.nextInt(30) + 21), (r.nextInt(30) + 21), 3);
                JOptionPane.showMessageDialog(null, "Uh oh, this vampice resembles Purdue Pete himself! It'll be a mircale to get out of this one alive.", gameName, JOptionPane.INFORMATION_MESSAGE);
            } else {
                vampice = new Enemy(50,0,0,1);
            }//end if

            if (player.getStamina() > vampice.getStamina()) {
                while (player.getHealth() > 0 || vampice.getHealth() > 0) {
                    player.setHealth(player.getHealth() - vampice.attack() + player.defend());
                    vampice.setHealth(vampice.getHealth() - player.getHealth() + vampice.defend());
                }//end while
                if (player.getHealth() < 0) {
                    String playerGetsKilled = "Oh no! Beter was slain by a vampice!";
                    JOptionPane.showMessageDialog(null, playerGetsKilled, gameName, JOptionPane.INFORMATION_MESSAGE);
                    return true;
                } else if (vampice.getHealth() < 0) {
                    String vampiceDefeated = "Congratulations! Beter defeated the vampice!";
                    JOptionPane.showMessageDialog(null, vampiceDefeated, gameName, JOptionPane.INFORMATION_MESSAGE);
                    return false;
                }
            } else {
                while (player.getHealth() > 0 || vampice.getHealth() > 0) {
                    vampice.setHealth(vampice.getHealth() - player.getHealth() + vampice.defend());
                    player.setHealth(player.getHealth() - vampice.attack() + player.defend());
                }//end while
                if (player.getHealth() < 0) {
                    String playerGetsKilled = "Oh no! Beter was slain by a vampice!";
                    JOptionPane.showMessageDialog(null, playerGetsKilled, gameName, JOptionPane.INFORMATION_MESSAGE);
                    return true;
                } else if (vampice.getHealth() < 0) {
                    String vampiceDefeated = "Congratulations! Beter defeated the vampice!";
                    JOptionPane.showMessageDialog(null, vampiceDefeated, gameName, JOptionPane.INFORMATION_MESSAGE);
                    return false;
                }
            }//end if

        } else if (event == 1) {
            //Player finds a chest with a random item in it
            JOptionPane.showMessageDialog(null, "Beter came across an old wooden chest, it appears to be unlocked.", gameName, JOptionPane.INFORMATION_MESSAGE);

            int randomEvent = (r.nextInt(10) + 1);
            switch (randomEvent){
                case 1:
                    player.addItem("healthPotion");
                    JOptionPane.showMessageDialog(null, "After peering in the chest and digging past all of the hwheels, Beter found a health potion!", gameName, JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 2:
                    player.addItem("chestPlate");
                    JOptionPane.showMessageDialog(null, "After peering in the chest and digging past all of the hwheels, Beter found a chest plate!", gameName, JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 3:
                    player.addItem("helmet");
                    JOptionPane.showMessageDialog(null, "After peering in the chest and digging past all of the hwheels, Beter found a helmet!", gameName, JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 4:
                    player.addItem("boots");
                    JOptionPane.showMessageDialog(null, "After peering in the chest and digging past all of the hwheels, Beter found boots!", gameName, JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 5:
                    player.addItem("shield");
                    JOptionPane.showMessageDialog(null, "After peering in the chest and digging past all of the hwheels, Beter found a shield!", gameName, JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 6:
                    player.addItem("dagger");
                    JOptionPane.showMessageDialog(null, "After peering in the chest and digging past all of the hwheels, Beter found a dagger!", gameName, JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 7:
                    player.addItem("axe");
                    JOptionPane.showMessageDialog(null, "After peering in the chest and digging past all of the hwheels, Beter found an axe!", gameName, JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 8:
                    player.addItem("sword");
                    JOptionPane.showMessageDialog(null, "After peering in the chest and digging past all of the hwheels, Beter found a sword!", gameName, JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 9:
                    player.addItem("luckyCharm");
                    JOptionPane.showMessageDialog(null, "After peering in the chest and digging past all of the hwheels, Beter found a lucky charm!", gameName, JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 10:
                    player.addItem("energyPotion");
                    JOptionPane.showMessageDialog(null, "After peering in the chest and digging past all of the hwheels, Beter found an energy potion!", gameName, JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 11:
                    player.addItem("charismaPotion");
                    JOptionPane.showMessageDialog(null, "After peering in the chest and digging past all of the hwheels, Beter found a charisma potion!", gameName, JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    player.addItem(null);
                    JOptionPane.showMessageDialog(null, "i eat ass lmao", gameName, JOptionPane.INFORMATION_MESSAGE);
                    break;
            }//end switch
        } else if (event == 2) {
            //Player falls into trap
            JOptionPane.showMessageDialog(null, "Oh no! It appears Beter fallen into a trap!", gameName, JOptionPane.INFORMATION_MESSAGE);
            int randomEvent = (r.nextInt(4) + 1);
            if(randomEvent == 1){
                String trapMessage = "There was a cave-in and a bunch of rocks fell on Beter's head. Ouch!";
                JOptionPane.showMessageDialog(null, trapMessage, gameName, JOptionPane.INFORMATION_MESSAGE);
                player.setHealth(player.getHealth() - 5);
            }else if(randomEvent == 2){
                String trapMessage = "There were some extra explosives lying around and Beter set them off. Silly Beter.";
                JOptionPane.showMessageDialog(null, trapMessage, gameName, JOptionPane.INFORMATION_MESSAGE);
                player.setHealth(player.getHealth() - 10);
            }else if(randomEvent == 3){
                String trapMessage = "A wild Logan appeared out of nowhere and tore every limb off of Beter. That'll hurt in the morining!";
                JOptionPane.showMessageDialog(null, trapMessage, gameName, JOptionPane.INFORMATION_MESSAGE);
                player.setHealth(player.getHealth() - 15);
            }else if(randomEvent == 4){
                String trapMessage = "Beter found a brochure from IU. IT'S A TRAP!";
                JOptionPane.showMessageDialog(null, trapMessage, gameName, JOptionPane.INFORMATION_MESSAGE);
                player.setStamina(player.getStamina()-5);
            }else{
                String trapMessage = "You can get here you idiot. You must go to IU";
                JOptionPane.showMessageDialog(null, trapMessage, gameName, JOptionPane.INFORMATION_MESSAGE);
            }//end if
        } else if (event == 3) {
            //Player encounters a meme (does nothing but adds to the story and hopefully gives a good laugh)
            int randomEvent = (r.nextInt(5) + 1);

            if(randomEvent == 1){
                JOptionPane.showMessageDialog(null, "Beter came across an old Hwheel. He doesn't think much about it, but it does remind him of his old CS180 professor, Professor Dunsmore", gameName, JOptionPane.INFORMATION_MESSAGE);
            }else if(randomEvent == 2){
                JOptionPane.showMessageDialog(null, "Beter came acorss a carving in the ground, it repeatedly says \"Java Says NO!\",\nFreaked out, Beter chooses to move on.", gameName, JOptionPane.INFORMATION_MESSAGE);
            }else if(randomEvent == 3){
                JOptionPane.showMessageDialog(null, "Beter comes across a sign that says \"Bridge Kids wuz here\" signed by Jesse, Kyle, Colin, Wynn, Jake, Andrew, as well as others", gameName, JOptionPane.INFORMATION_MESSAGE);
            }else if(randomEvent == 4){
                JOptionPane.showMessageDialog(null, "Beter comes across a slouched-over old man who smells faintly of kava.\nHe approaches the man, who turns to look at him, and with a crazed look in his eye, yells, \"I'M A GOOD CHRISTIAN BOY!\" at Beter before sprinting off into the cave, probably searching for more kava.", gameName, JOptionPane.INFORMATION_MESSAGE);
            }else if(randomEvent == 5){
                JOptionPane.showMessageDialog(null, "Beter came across a grave stone planted in the ground. It reads: \"Here lies EquaSolve: it was a good idea for about 30 minutes.\"", gameName, JOptionPane.INFORMATION_MESSAGE);
            }else{
                String trapMessage = "You can get here you idiot. You must go to IU.";
                JOptionPane.showMessageDialog(null, trapMessage, gameName, JOptionPane.INFORMATION_MESSAGE);
            }//end if
        }//end if
        return  false;
    }//end of eventBegin method

    public void friendFound() {
        player.addFriend();
        if(player.getFriends() == 1){
            JOptionPane.showMessageDialog(null, "Beter found his friend Ashwin! He found a couple of parenthesis and got super triggered and couldn't move.", gameName, JOptionPane.INFORMATION_MESSAGE);
        }else if(player.getFriends() == 2){
            JOptionPane.showMessageDialog(null, "Beter found his friend Megan! She's just been watching the Cardinal's game on TV this whole time! Too bad they lost to the Cubs 4-3.", gameName, JOptionPane.INFORMATION_MESSAGE);
        }else if(player.getFriends() == 3){
            JOptionPane.showMessageDialog(null, "Beter found his friend Sripath! He was correcting some ancient code he found in the cave dating as far back as the Mayans!", gameName, JOptionPane.INFORMATION_MESSAGE);
        }else if(player.getFriends() == 4){
            JOptionPane.showMessageDialog(null, "Beter found his friend Nathan! He's been drowning in the kava ponds and is high af.", gameName, JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "JAVA SAYS NO!", gameName, JOptionPane.INFORMATION_MESSAGE);
        }//end of if
    }//end of friendFound method
}//end event class

