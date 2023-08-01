package main;

import locations.*;
import player.*;

import java.util.Scanner;

public class Game {
    private Scanner scanner = new Scanner(System.in);
    private String playerName;

    public void start(){
        System.out.print("\nMacera oyunu adasına hoş geldiniz isminiz nedir? : ");
        playerName = scanner.next();
        System.out.println("Bu adada gerçek korkunuzu keşfedeceksiniz !!\n");

        System.out.println("Hangi karakter olmak istiyorsun " + playerName);
        ThisPlayer player = new ThisPlayer(playerName);
        player.selectPlayer();

        Location location = null;

        while (true) {

            System.out.println("\n<-------------------------------| locations |------------------------------->");
            System.out.println("1 - Home   --> Burada dinlenebilirsin.");
            System.out.println("2 - market --> Buradan silah ve kalkan satın alabilirsiniz");
            System.out.println("3 - Cave   --> [Seviye 1] savaş yeri");
            System.out.println("4 - Fores  --> [Seviye 2] savaş yeri");
            System.out.println("5 - River  --> [Seviye 3] savaş yeri");
            System.out.println("0 - Oyunu Bitir");
            System.out.println("X - Ödülleri Göster");
            System.out.println("<--------------| Durum türünüzü kontrol etmek istiyorsanız: Durum |------------>");
            System.out.print("Konum idsi girin : ");
            String selectLoc = scanner.next();
            selectLoc = selectLoc.toUpperCase();
            switch (selectLoc) {
                case "0":
                    location = null;
                    break;
                case "1":
                    location = new House(player);
                    break;
                case "2":
                    location = new ToolStore(player);
                    break;
                case "3":
                    location = new Cave(player);
                    break;
                case "4":
                    location = new Forest(player);
                    break;
                case "5":
                    location = new River(player);
                    break;
                case "Durum":
                    player.showStatus();
                    continue;
                case "X":
                    player.awardStats();
                    continue;
                default:
                    location = new House(player);
            }

            if (location == null){
                System.out.println("Oyunu korku içinde bırakmış olsanız bile, bunun sadece bir oyun olduğunu ve güvenliğinizin her zaman önce geldiğini unutmayın.");
                System.out.println("Endişelenme, bir şeyin senin için çok fazla olduğunu kabul etmekte utanılacak bir şey yok.");
                System.out.println("Kendine iyi bak ve güvende kal!");
                break;
            }
            if (!location.onLocation()){
                System.out.println("Oyun bitti..");
                break;
            }
        }
    }
}
