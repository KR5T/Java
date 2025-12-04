import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GradeCalculator extends JFrame implements ActionListener {

    private JTextField nameField, midtermField, finalField;
    private JButton calcButton;

    public GradeCalculator() {

        setTitle("Grade Calculator");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Student Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Midterm Grade:"));
        midtermField = new JTextField();
        add(midtermField);

        add(new JLabel("Final Grade:"));
        finalField = new JTextField();
        add(finalField);

        calcButton = new JButton("Calculate");
        calcButton.addActionListener(this);
        add(calcButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String name = nameField.getText();
            int midterm = Integer.parseInt(midtermField.getText());
            int fin = Integer.parseInt(finalField.getText());

            if (midterm < 0 || midterm > 100 || fin < 0 || fin > 100) {
                JOptionPane.showMessageDialog(this,
                        "grades must be between 0 and 100!",
                        "error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double general = midterm * 0.4 + fin * 0.6;
            String letter = calculateLetter(general);

            JOptionPane.showMessageDialog(this,
                    "student: " + name +
                    "\ngeneral grade: " + general +
                    "\nletter grade: " + letter,
                    "result", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "please enter valid numeric grades!",
                    "input error", JOptionPane.ERROR_MESSAGE);
        }
        finally{
            
        }
            
    }

    private String calculateLetter(double grade) {
        if (grade >= 90) return "AA";
        else if (grade >= 80) return "BA";
        else if (grade >= 70) return "BB";
        else if (grade >= 60) return "CB";
        else if (grade >= 50) return "CC";
        else return "FF";
    }

    public static void main(String[] args) {
        new GradeCalculator();
    }
}
