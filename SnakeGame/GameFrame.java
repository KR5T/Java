package SnakeGame;
import javax.swing.JFrame;

public class GameFrame extends JFrame {

    public GameFrame() {
        GamePanel panel = new GamePanel(); //here
        this.add(panel); //and here, same with: this.add(new GamePanel());
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //what happens when i click to X
        this.setResizable(false); //resize the window: false
        this.pack(); //window size: automatic setting
        this.setVisible(true); //visible or not
        this.setLocationRelativeTo(null); //window location -> null: screen center
    }
}
