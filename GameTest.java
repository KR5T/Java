class Pickups {
    public Pickups() {
        System.out.println("   > Pickups Constructor'ı çalıştı.");
    } 
    public void update() {
        System.out.println("   > Pickups: Nesne dönüyor...");
    }
}
class Coin extends Pickups {
    public Coin() {
        System.out.println("   > Coin Constructor'ı çalıştı.");
    }

    @Override
    public void update() {
        super.update(); 
        System.out.println("   > Coin: Nesne aynı zamanda parlıyor!");
    }
    public void onPickup() {
        System.out.println("Coin toplandı: +100 puan!");
    }
}
public class GameTest {
    public static void main(String[] args) {
        System.out.println("--- Coin oluşturuluyor: ---");
        Coin myCoin = new Coin();

        System.out.println("\n--- Coin güncelleniyor: ---");
        myCoin.update(); 
    }
}
