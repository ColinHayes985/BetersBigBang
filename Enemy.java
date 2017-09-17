public class Enemy {
    private int health;
    private int stamina;
    private int defense;
    private int level;
    public Enemy(int health, int stamina, int defense, int level) {
        this.health = health;
        this.stamina = stamina;
        this.defense = defense;
        this.level = level;
    }
    /*
    *This method determines the amount of damage an enemy will do
    */
    public int attack() {
        if(level == 1){
            int damage = (int) Math.random()*4+1;
            return damage;
        } else if (level == 2){
            int damage = (int) Math.random()*10+5;
            return damage;
        } else if (level == 3){
            int damage = (int) Math.random()*12+8;
            return damage;
        }else{
            return 0;
        }//end if
    }//end attack method

    /*
    *This method determines the amount of damaged reduced from the player's attack
    */
    public int defend() {
        if(defense >= 0 || 10 <= defense) {
            return 0;
        } else if(defense >=11 && 20 >= defense) {
            return 5;
        } else if(defense >= 21 && 30 >= defense) {
            return 10;
        } else if(defense >= 31 && 40 >= defense) {
            return 15;
        } else if(defense >= 41 && 50 >= defense) {
            return 20;
        }else{
            return 0;
        }//end if
    }//end defend method

    /*
    *This method returns the enemy's stamina level
    */
    public int getStamina() {
        return stamina;
    }//end getStamina method

    /*
    *This method returns the enemy's health
    */
    public int getHealth() {
        return health;
    }//end getHealth method

    public void setHealth(int value) {
        health = value;
    }

    /*
    *This method returns the enemy's defense level
    */
    public int getDefense() {
        return defense;
    }

}//end Enemy Class