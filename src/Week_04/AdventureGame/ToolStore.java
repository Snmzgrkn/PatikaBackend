package Week_04.AdventureGame;

public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation(){
        System.out.println("--------- Mağazaya Hoşgeldiniz ---------");
        boolean showMenu = true;
        while (showMenu){
            System.out.println("1  - Silahlar");
            System.out.println("2  - Zırhlar");
            System.out.println("3  - Çıkış Yap");
            System.out.print("Seçiminiz :");
            int selectCase = Location.scanner.nextInt();
            while (selectCase < 1 || selectCase >3){
                System.out.println("Geçersiz değer, tekrar giriniz :");
                selectCase = scanner.nextInt();
            }
            switch (selectCase){
                case 1:
                    printWeapons();
                    buyWeapon();
                    break;
                case 2:
                    printArmors();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Bir daha bekleriz !");
                    showMenu=false;
                    return true;


            }
        }
        return true;

    }
    public void printWeapons(){
        System.out.println("------ Silahlar ------");
        System.out.println();
        for (Weapon w : Weapon.weapons()){
            System.out.println(w.getId() +"-"+  w.getName() + " Para : "+w.getValue() + ", Hasar :" + w.getDamage());
        }
        System.out.println("0 - Çıkış Yap");


    }
    public  void  buyWeapon(){
        System.out.println("Bir Silah Seçiniz !");

        int selectWeaponID = scanner.nextInt();
        while (selectWeaponID < 0 || selectWeaponID >= Weapon.weapons().length){
            System.out.println("Geçersiz değer, tekrar giriniz :");
            selectWeaponID = scanner.nextInt();
        }

        if (selectWeaponID != 0){
            Weapon selectedWeapon = Weapon.getWeaponObByIdj(selectWeaponID);
            if(selectedWeapon != null){
                if (selectedWeapon.getValue() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli Paranız Bulunmamaktadır !");
                }else {
                    // SATIN ALMA GERÇEKLEŞTİĞİ ALAN
                    System.out.println(selectedWeapon.getName() + " silahını satın aldınız !");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getValue();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız :" + this.getPlayer().getMoney());
                    System.out.println("Önceki Silahınız :" + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Yeni Silahınız :" + this.getPlayer().getInventory().getWeapon().getName());

                }
            }
        }



    }

    public void printArmors(){
        System.out.println("------ Zırhlar ------");
        System.out.println();
        for (Armor a : Armor.armors()){
            System.out.println(a.getId() +"-"+  a.getName() +
                    " Para : "+a.getPrice() +
                    " Zırh: "+a.getBlock());
        }
        System.out.println("0 - Çıkış Yap");

    }
    public void buyArmor(){
        System.out.println("Bir Zırh Seçiniz !");

        int selectArmorID = scanner.nextInt();
        while (selectArmorID < 0 || selectArmorID >= Armor.armors().length){
            System.out.println("Geçersiz değer, tekrar giriniz :");
            selectArmorID = scanner.nextInt();
        }
        if (selectArmorID !=0){
            Armor selectedArmor = Armor.getArmorObByIdj(selectArmorID);
            if(selectedArmor != null){
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli paranız bulunmamaktadır !");
                }else {
                    System.out.println("Zırhı satın aldınız!!");
                    this.getPlayer().setMoney(this.getPlayer().getMoney()-selectedArmor.getPrice());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Kalan paranız :" + this.getPlayer().getMoney());

                }
            }
        }


    }
}
