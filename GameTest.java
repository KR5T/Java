abstract class Pickups {
    public abstract void update();
}

class Coin extends Pickups {
    @Override
    public void update() { System.out.println("Coin dönüyor ve parlıyor..."); }
    
    // Sadece Coin'e özel metot:
    public void onPickup() { System.out.println("   >>> Coin alındı! +100 Puan!"); }
}

class Gem extends Pickups {
    @Override
    public void update() { System.out.println("Mücevher dönüyor ve ışıldıyor..."); }
    
    // Sadece Gem'e özel metot:
    public void onShatter() { System.out.println("   >>> Mücevher kırıldı!"); }
}

public class GameTest {
    public static void main(String[] args) {
        
        Pickups[] allPickups = new Pickups[3];
        allPickups[0] = new Coin();
        allPickups[1] = new Gem();
        allPickups[2] = new Coin();

        System.out.println("--- Polimorfik Döngü (instanceof ile) ---");
        
        for (Pickups p : allPickups) {
            
            // 1. Polimorfik çağrı (Herkes yapar)
            p.update(); 

            // 2. Tipe özel çağrı (instanceof ve Downcasting)
            if (p instanceof Coin) {
                Coin myCoin = (Coin) p; // Downcasting
                myCoin.onPickup();
            }
            else if (p instanceof Gem) {
                Gem myGem = (Gem) p; // Downcasting
                myGem.onShatter();
            }
        }
    }
}
