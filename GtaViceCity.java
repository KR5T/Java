class Player {
    private int money;
    private int ammo;
    private String name;

    public Player(String name) {
        this.name = name;
        this.money = 10;
        this.ammo = 0;  
    }

    public void addMoney(int amount) {
        this.money += amount;
        System.out.println("   > " + name + " " + amount + "$ aldı. Toplam para: " + this.money + "$");
    }

    public void addAmmo(int amount) {
        this.ammo += amount;
        System.out.println("   > " + name + " " + amount + " mermi aldı. Toplam mermi: " + this.ammo);
    }

    public void showStatus() {
        System.out.println("--- " + name + " Durumu ---");
        System.out.println("Para: " + this.money + "$");
        System.out.println("Mermi: " + this.ammo);
        System.out.println("--------------------");
    }
}
abstract class Pickups {

    public void rotate() {
        System.out.println("Genel nesne dönüyor...");
    }

    public abstract void onPickup(Player player);
}
class Money extends Pickups {
    
    private int value = 100;

    @Override
    public void onPickup(Player player) {
        System.out.println("Bir 'Money' nesnesine dokunuldu.");
        player.addMoney(this.value);
    }

    @Override
    public void rotate() {
        System.out.println("Dolar banknotu havada süzülerek dönüyor...");
    }
}
class Gun extends Pickups {

    private String gunType = "Uzi";
    private int ammoAmount = 30;

    @Override
    public void onPickup(Player player) {
        System.out.println("Bir 'Gun' nesnesine ('" + gunType + "') dokunuldu.");
        player.addAmmo(this.ammoAmount);
    }

}
public class GtaViceCity {

    public static void main(String[] args) {
        Player tommy = new Player("Tommy Vercetti");
        tommy.showStatus();

        Pickups[] streetItems = new Pickups[3];
        streetItems[0] = new Money(); 
        streetItems[1] = new Gun();   
        streetItems[2] = new Money(); 

        System.out.println("\n*** Tommy sokağa çıktı... ***\n");

        for (Pickups item : streetItems) {
            item.rotate(); 

            item.onPickup(tommy);
            
            System.out.println("-----"); 
        }

        System.out.println("\n*** Görev tamamlandı! ***\n");
        tommy.showStatus();
    }
}
