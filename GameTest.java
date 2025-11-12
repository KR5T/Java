interface IDestroyable {
    void destroy(); 
}
abstract class Pickups {
    public void update() {
        System.out.println("Nesne dönüyor...");
    }
}

class Coin extends Pickups implements IDestroyable {
    @Override 
    public void update() {
        super.update();
        System.out.println("   > Coin parlıyor!");
    }
    
    @Override
    public void destroy() {
        System.out.println("   >>> Coin yok edildi ve +100 Puan verildi!");
    }
}

class Enemy implements IDestroyable {

    @Override
    public void destroy() {
        System.out.println("   >>> Düşman yok edildi!");
    }
}
public class GameTest {
    public static void main(String[] args) {
        
        IDestroyable[] destroyableThings = new IDestroyable[2];

        destroyableThings[0] = new Coin();
        destroyableThings[1] = new Enemy();

        System.out.println("--- Yok Edilebilirler Listesi ---");
        
        for (IDestroyable item : destroyableThings) {
            item.destroy(); 
        }
    }
}
