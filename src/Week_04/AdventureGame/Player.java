package Week_04.AdventureGame;

import java.util.Scanner;

public class Player {

  private int damage;
  private int health;
  private int money;
  private String charName;
  private String name;
  private Inventory inventory;
  private  int orjHealth;
Scanner scanner = new Scanner(System.in);
    public Player(String name) {
        this.name = name;
        this.inventory=new Inventory();
    }

    public int getOrjHealth() {
        return orjHealth;
    }

    public void setOrjHealth(int orjHealth) {
        this.orjHealth = orjHealth;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void selectChar(){
        Samurai samurai = new Samurai();
        Knight knight = new Knight();
        Archer archer = new Archer();

        GameChar[] charList = {new Samurai(),new Archer(),new Knight()};
        System.out.println("------------------------------------------------------------------------------");
        for (GameChar gameChar : charList){
            System.out.println("ID : " + gameChar.getId() +
                    "\tKarakter: " + gameChar.getName() +
                    "\tHasar: "+ gameChar.getDamage() +
                    "\tSağlık: " + gameChar.getHealth() +
                    "\tPara: "+ gameChar.getMoney() );
        }
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Lütfen bir karakter seçiniz !");
        int selectChar = scanner.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());

        }
        System.out.println("Karakter : " + this.getCharName() +
                ",Hasar :" + this.getDamage() +
                ",Sağlık : " +this.getHealth() +
                ",Para : "+this.getMoney());


    }
    public  void selectLoc(){

    }
    public void printInfo(){
        System.out.println(
                "Silahınız : " +this.getInventory().getWeapon().getName() +
                        ", Zırh : "+this.getInventory().getArmor().getName() +
                        ", Bloklama : "+this.getInventory().getArmor().getBlock() +
                        ", Hasarınız : " + this.getTotalDamage() +
                ", Sağlık : " +this.getHealth() +
                ", Para : "+this.getMoney());
    }
    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOrjHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }
    public Weapon getWeapon(){
        return this.getInventory().getWeapon();
    }
}
