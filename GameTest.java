class Pickups {
    protected String pickupSound;

    public Pickups() {
        System.out.println("   > 1. Pickups (Ebeveyn) Constructor'ı çalıştı.");
        this.pickupSound = "Bling!"; 
    }
    
    public Pickups(String customSound) {
        System.out.println("   > 1. Pickups (Ebeveyn) Constructor'ı çalıştı. (Özel Sesli)");
        this.pickupSound = customSound;
    }
    
    public void update() {
        System.out.println("Nesne dönüyor...");
    }
}

class Coin extends Pickups {
    
    public Coin() {
        System.out.println("   > 2. Coin (Çocuk) Constructor'ı çalıştı.");
    }

    public void onPickup() {
        System.out.println("Coin toplandı: +100 puan! Ses: " + pickupSound);
    }
}

class Gem extends Pickups {

    public Gem(String sound) {
        super(sound); 
        
        System.out.println("   > 2. Gem (Çocuk) Constructor'ı çalıştı.");
    }
    
    public void onPickup() {
         System.out.println("Mücevher toplandı: +500 puan! Ses: " + pickupSound);
    }
}
public class GameTest {
    public static void main(String[] args) {
        System.out.println("--- Coin (Gizli super() çağrısı) oluşturuluyor: ---");
        Coin myCoin = new Coin();
        myCoin.onPickup();

        System.out.println("\n--- Gem (Açık super(sound) çağrısı) oluşturuluyor: ---");
        Gem myGem = new Gem("Parlama Sesi!");
        myGem.onPickup();
    }
}
