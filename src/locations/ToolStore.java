package locations;

import market.*;
import player.ThisPlayer;

public class ToolStore extends Location {

    public ToolStore(ThisPlayer thisPlayer) {
        super(thisPlayer, "market", 2);
    }

    @Override
    public boolean onLocation() {

        System.out.println("\nTOOLSTORE HOŞGELDİN !");

        System.out.println("-------------------------------| Tool Store |-------------------------------");
        System.out.println("1 - Bir Silah Al");
        System.out.println("2 - Bir Kalkan Al");
        System.out.println("3 - Çıkış");
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("id gir : ");
        int selectGun = scanner.nextInt();
        while (selectGun < 1 || 3 < selectGun) {
            System.out.println("Girişiniz yanlış lütfen tekrar deneyin : ");
            selectGun = scanner.nextInt();
        }
        switch (selectGun) {
            case 1:
                printWeapon();
                break;
            case 2:
                printShield();
                break;
            default:
                System.out.println("Yine görüşürüz..");
        }
        return true;
    }

    public void printWeapon() {

        Weapons[] gunList = {new Pistol(), new Rifle(), new Sword()};

        System.out.println("--------------------------------| Silahlar |---------------------------------");
        for (Weapons weapons : gunList) {
            System.out.println("Eşya " + weapons.getId() + ": " + weapons.getName() + " | " +
                    " Fiyat" + ": " + weapons.getCost() + " | " +
                    " Hasar" + ": " + weapons.getDamage());
        }
        System.out.println("4 - Çıkış");
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("Eşyanı seç : ");
        int buyGun = scanner.nextInt();
        while (buyGun < 1 || 3 < buyGun) {
            if (buyGun == 4){
                break;
            }else System.out.println("Girişiniz yanlış lütfen tekrar deneyin : ");
            buyGun = scanner.nextInt();
        }
        buyWeaponById(buyGun);
    }

    public void printShield() {

        Shield[] shieldList = {new Helmet(), new Armor(), new Aegis()};

        System.out.println("--------------------------------| Kalkanlar |---------------------------------");
        for (Shield shield : shieldList) {
            System.out.println("Kalkan " + shield.getId() + ": " + shield.getName() + " | " +
                    " Fiyat" + ": " + shield.getCost() + " | " +
                    " Engelleme" + ": " + shield.getDodge());
        }
        System.out.println("4 - Çıkış");
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("Kalkanınızı Seçin : ");
        int buyShield = scanner.nextInt();
        while (buyShield < 1 || 3 < buyShield) {
            if (buyShield == 4){
                break;
            }else System.out.println("Girişiniz yanlış lütfen tekrar deneyin : ");
            buyShield = scanner.nextInt();
        }
        buyShieldById(buyShield);
    }


    public void buyWeaponById(int id) {
        Weapons[] weapons = {new Pistol(), new Rifle(), new Sword()};
        for (Weapons weapon : weapons) {
            if (weapon.getId() == id) {
                int cost = weapon.getCost();
                if (this.getThisPlayer().getMoney() >= cost) {
                    int balance = getThisPlayer().getMoney() - cost;
                    this.getThisPlayer().setMoney(balance);
                    System.out.println("Satın aldınız " + weapon.getName() + "!");
                    this.getThisPlayer().getInventory().setWeaponName(weapon.getName());
                    this.getThisPlayer().getInventory().setWeaponDamage(weapon.getDamage());
                    return;
                } else {
                    System.out.println(weapon.getName());
                    System.out.println("Bu eşyayı alacak kadar paran yok.");
                    return;
                }
            }
        }
        System.out.println("Geçersiz silah idsi.");
    }

    public void buyShieldById(int id) {
        Shield[] shieldList = {new Helmet(), new Armor(), new Aegis()};
        for (Shield shield : shieldList) {
            if (shield.getId() == id) {
                int cost = shield.getCost();
                if (this.getThisPlayer().getMoney() >= cost) {
                    int balance = getThisPlayer().getMoney() - cost;
                    this.getThisPlayer().setMoney(balance);
                    System.out.println("Satın aldınız " + shield.getName() + "!");
                    this.getThisPlayer().getInventory().setArmorName(shield.getName());
                    this.getThisPlayer().getInventory().setArmorDefence(shield.getDodge());
                    return;
                } else {
                    System.out.println(shield.getName());
                    System.out.println("Bu kalkanı alacak kadar paran yok.");
                    return;
                }
            }
        }
        System.out.println("Geçersiz kalkan idsi.");
    }
}
