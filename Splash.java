import java.awt.*;
import javax.swing.*;

public class Splash extends JWindow {
    private static final long serialVersionUID = 6248477390124803341L;
    private final int duration;

    public Splash(int duration) {
        this.duration = duration;
    }

    public void showSplash() {
        JPanel pan = new JPanel(new BorderLayout());
        Color background = new Color(16, 41, 107);
        pan.setBackground(background);
        
        int width = 500;
        int height = 263;
        Dimension dime = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dime.width - width) / 2;
        int y = (dime.height - height) / 2;
        setBounds(x, y, width, height);
        
        JLabel gif = new JLabel(new ImageIcon("giphy.gif"));
        JLabel label1 = new JLabel("Splash Window Demo", JLabel.CENTER);

        Color text = new Color(232, 222, 204);
        label1.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
        label1.setForeground(text);

        pan.add(gif, BorderLayout.CENTER);
        pan.add(label1, BorderLayout.SOUTH);

        Color border = new Color(27, 191, 159);
        pan.setBorder(BorderFactory.createLineBorder(border, 10));

        setContentPane(pan);
        setVisible(true);
        try {
            Thread.sleep(duration);
        } catch (Exception e) {
            e.printStackTrace();
        }
        dispose();
    }

    public static void main(String[]args) {
        int duration = 10000;
        if(args.length == 1) {
            try {
                duration = Integer.parseInt(args[0]);
            } catch(NumberFormatException mf) {
                System.out.println("Wrong command line argument: must be an integer number");
                System.out.println("The default duration 10000 milliseconds will be used");
            }
        }
        Splash splashWindow = new Splash(duration);
        splashWindow.showSplash();
    }
}