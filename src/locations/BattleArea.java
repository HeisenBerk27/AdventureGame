package locations;

import monster.Monsters;
import player.ThisPlayer;

import java.util.Random;

public abstract class BattleArea extends Location {
    private Monsters monsters;
    private String award;
    private String name;
    private final int maxMonsters;

    public BattleArea(ThisPlayer thisPlayer, String name, Monsters monsters, String award) {
        super(thisPlayer, "Savaş Haritası", 10);
        this.monsters = monsters;
        this.name = name;
        this.award = award;
        this.maxMonsters = 3;
    }

    @Override
    public boolean onLocation() {
        int rmonsters = randomMonsters();
        System.out.println("**********************************| " + this.getName() + " |**********************************");
        System.out.println("Savaşmak zorunda olduğun " + rmonsters + " " + this.getMosters().getName());
        System.out.println("Kazanırsan " + this.getAward());
        System.out.println("Savaşmak istiyor musun? Savaş/Kaç");
        System.out.println("****************************************************************************");
        String selecetCase = scanner.next();
        selecetCase = selecetCase.toUpperCase();
        if (selecetCase.equals("SAVAŞ") || selecetCase.equals("SAVAŞ")) {
            if (combat(rmonsters)) {
                System.out.println(this.getName() + " Tebrikler, bu adımı geçtin.");
                return true;
            }
        }

        if (this.getThisPlayer().getHealth() <= 0) {
            System.out.println("Öldün..!");
            return false;
        }
        return true;
    }

    public boolean combat(int monsterNumber) {
        for (int i = 1; i <= monsterNumber; i++) {
            this.getMosters().setHealthy(this.getMosters().getMainHealhy());
            playerStats();
            monsterStats(i);
            while (this.getThisPlayer().getHealth() > 0 && this.getMosters().getHealthy() > 0) {
                System.out.print("Vur/Kaç : ");
                String selectCombat = scanner.next().toUpperCase();
                if (selectCombat.equals("VUR") || selectCombat.equals("VUR")) {
                    this.getMosters().setHealthy(this.getMosters().getHealthy() - this.getThisPlayer().getDamage());
                    afterHit();
                    if (this.getMosters().getHealthy() > 0) {
                        System.out.println();
                        System.out.println(this.getMosters().getName() + " sana saldırdı !!");
                        int dodgeMonster = this.getMosters().getDamage() - this.getThisPlayer().getInventory().getArmorDefence();
                        System.out.println("-> " + this.getThisPlayer().getCharName() + " Sağlık : -" + this.getMosters().getDamage());
                        if (dodgeMonster < 0) {
                            dodgeMonster = 0;
                        }
                        this.getThisPlayer().setHealth(this.getThisPlayer().getHealth() - dodgeMonster);
                        System.out.println(this.getThisPlayer().getCharName() + " Canlı Sağlık : " + this.getThisPlayer().getHealth());
                        System.out.println("**************************************************************************");
                    }
                } else {
                    return false;
                }

                if (this.getMosters().getHealthy() <= 0) {
                    System.out.println("[" + i + ""+this.getMosters().getName()+"]");
                    System.out.println(this.getMosters().getMoney() + " Altın kazandın !!");
                    this.getThisPlayer().setMoney(this.getThisPlayer().getMoney() + this.getMosters().getMoney());
                }

                if (i == monsterNumber && this.getMosters().getName().equals("Zombi")){
                    this.getThisPlayer().getInventory().setWater(true);
                    System.out.println("Tebrikler, su elde ettin");
                }
                if (i == monsterNumber && this.getMosters().getName().equals("Vampir")){
                    this.getThisPlayer().getInventory().setFood(true);
                    System.out.println("Tebrikler, yiyecek elde ettin");
                }
                if (i == monsterNumber && this.getMosters().getName().equals("Ayı")){
                    this.getThisPlayer().getInventory().setFireWoord(true);
                    System.out.println("Tebrikler, odun elde ettin");
                }
            }
        }
        return false;
    }

    public void afterHit() {
        System.out.println("********************************| Başla |*********************************");
        System.out.println(this.getThisPlayer().getCharName() + " saldırıyor !!");
        System.out.println("-> " + this.getMosters().getName() + " Sağlık : -" + this.getThisPlayer().getDamage());
        System.out.println(this.getMosters().getName() + " Canlı sağlık : " + this.getMosters().getHealthy());
        System.out.println();
    }

    public void playerStats() {
        System.out.println("**************************************************************************");
        System.out.println(this.getThisPlayer().getCharName() + " Durum ");
        System.out.println("[Hasar :" + this.getThisPlayer().getTotalDamage() +
                "] [Sağlık : " + this.getThisPlayer().getHealth() +
                "] [Silah : " + this.getThisPlayer().getInventory().getWeaponName() +
                "] [Silah Hasarı : " + this.getThisPlayer().getInventory().getWeaponDamage() +
                "] [Kalkan : " + this.getThisPlayer().getInventory().getArmorDefence() +
                "] [Altın :   " + this.getThisPlayer().getMoney() + "]");
    }

    public void monsterStats(int i) {
        System.out.println(i + "." + this.getMosters().getName() + " Durum ");
        System.out.println("[Hasar :" + this.getMosters().getDamage() +
                "] [Sağlık :" + this.getMosters().getHealthy() +
                "] [Ödül :" + this.getMosters().getMoney() + " Altın]");
        System.out.println("**************************************************************************");
    }


    public int randomMonsters() {
        Random random = new Random();
        return random.nextInt(3) + 1;
    }

    public Monsters getMosters() {
        return monsters;
    }

    public void setMosters(Monsters monsters) {
        this.monsters = monsters;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getMaxMonsters() {
        return maxMonsters;
    }
}