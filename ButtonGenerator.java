import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonGenerator {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UIGenerator());
    }
}

class UIGenerator extends JFrame implements ActionListener {

    private JComboBox<String> comboBox;
    private JButton generateButton;
    private JPanel container;

    public UIGenerator() {
        setTitle("UI Generator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        comboBox = new JComboBox<>(new String[]{"Button", "TextField"});
        generateButton = new JButton("Generate");
        generateButton.addActionListener(this);

        topPanel.add(comboBox);
        topPanel.add(generateButton);

        container = new JPanel();
        container.setLayout(new FlowLayout());

        add(topPanel, BorderLayout.NORTH);
        add(container, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        generateUIElement();
    }

    private void generateUIElement() {
        String choice = (String) comboBox.getSelectedItem();

        if (choice.equals("Button")) {
            JButton newBtn = new JButton("New Button");

            newBtn.addActionListener(ev -> generateUIElement());

            container.add(newBtn);

        } else if (choice.equals("TextField")) {
            JTextField tf = new JTextField("New TextField", 12);
            container.add(tf);
        }

        container.revalidate();
        container.repaint();
    }
}