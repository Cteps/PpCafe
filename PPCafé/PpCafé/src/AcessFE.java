import java.io.File;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;

//->.Fazer Para alterar Definições
public class AcessFE {
    String Pp = "123";

    public AcessFE() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame frame = new JFrame("PPCafé");
        frame.setIconImage(Icon().getImage());
        frame.setSize(dimension);
        frame.setBackground(Color.BLACK);
        frame.setLocationRelativeTo(null);

        JPanel background = new JPanel();
        background.setLayout(null);
        background.setSize(dimension);
        background.setBackground(Color.CYAN);

        JPanel panel = Panel();

        int x = panel.getLocation().x;
        int y = panel.getLocation().y;

        JButton[] lista = new JButton[12];

        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton b0 = new JButton("0");
        JButton bEnter = new JButton("Enter");
        JButton bDel = new JButton("DEL");

        lista[0] = (b1);
        lista[1] = (b2);
        lista[2] = (b3);
        lista[3] = (b4);
        lista[4] = (b5);
        lista[5] = (b6);
        lista[6] = (b7);
        lista[7] = (b8);
        lista[8] = (b9);
        lista[9] = (b0);
        lista[10] = (bEnter);
        lista[11] = (bDel);

        JTextField textField = new JTextField(30);
        // ->
        Font font = new Font("Arial", Font.BOLD, 30);
        textField.setFont(font);
        // ->
        textField.setBounds(x, y, 300, 50);
        // panel.add(b1);
        // frame.add(panel);
        // ->
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int n = i + j * 3;
                // ->
                lista[n].setBounds(x + 100 * i, y + 50 + 50 * j, 100, 50);
                frame.add(lista[n]);
                lista[n].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        textField.setText(textField.getText() + (n + 1));
                    }
                });
            }

        }
        lista[10].setBounds(x + 100, y + 200, 200, 50);
        lista[10].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                // System.out.println(textField.getText());
                String s = textField.getText();
                // PopUP(frame, Pp.compareTo(textField.getText()));
                PopUP(frame, s.equals(Pp));
            }

        });

        lista[11].setBounds(x, y + 200, 100, 50);

        lista[11].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String s = textField.getText();
                textField.setText(s.substring(0, s.length() - 1));
            }
        });
        frame.add(lista[10]);
        frame.add(lista[11]);
        // b1.setSize(100, 50);
        // b1.setLocation(x, y + 50);
        // System.out.println(frame);

        frame.add(textField);
        frame.add(background);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
    }

    public JPanel Panel() {
        JPanel panel = new JPanel();

        panel.setLayout(new FlowLayout(FlowLayout.CENTER, -100, 0));
        // ->
        panel.setSize(300, 400);
        panel.setBackground(Color.BLUE);
        panel = WindowAtCenter(panel);
        return panel;
    }

    public JPanel WindowAtCenter(JPanel panel) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - panel.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - panel.getHeight()) / 2);
        panel.setLocation(x, y);
        return panel;
    }

    public ImageIcon Icon() {
        ImageIcon ico;
        try {
            File file = new File("C:\\Users\\Passos\\Desktop\\PPCafé\\PpCafé\\src\\ICON.png");
            BufferedImage bufferedImage = ImageIO.read(file);
            ico = new ImageIcon(bufferedImage);
            return ico;
        } catch (Exception e) {
            System.out.println("Error");
            ico = null;
            return ico;
        }

    }

    public void PopUP(JFrame bframe, Boolean bool) {
        JFrame frame = new JFrame("Validação");
        JLabel label;

        if (bool) {
            label = new JLabel("BEM");
            label.setForeground(Color.green);
        } else {
            label = new JLabel("ERRADO");
            label.setForeground(Color.RED);
        }
        JButton b = new JButton("OK");
        JPanel panel = new JPanel();

        panel.setLayout(null);

        panel.add(label);
        panel.add(b);

        label.setBackground(Color.BLUE);

        label.setBounds(150, 50, 150, 50);
        b.setBounds(100, 100, 150, 50);

        frame.add(panel);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (!bool) {
                    frame.dispose();
                    bframe.setEnabled(true);
                    bframe.setVisible(true);
                } else {
                    frame.dispose();
                    bframe.dispose();
                    new Service();
                }
            }
        });

        frame.setSize(400, 200);
        frame.setLocation(430, 400);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
