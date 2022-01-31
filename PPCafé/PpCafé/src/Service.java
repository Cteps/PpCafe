import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Service {

    public Service() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame frame = new JFrame("PPCafé");
        JPanel background = new JPanel();
        background.setLayout(null);
        background.setSize(dimension);
        background.setBackground(Color.CYAN);

        JPanel panel = new JPanel();

        panel.setLayout(new FlowLayout(FlowLayout.RIGHT, -200, 0));
        // ->
        panel.setSize(300, 100);
        panel.setBackground(Color.RED);

        /*
         * int x = (int) ((dimension.getWidth() - panel.getWidth()));
         * int y = (int) dimension.getHeight();
         * panel.setLocation(x, y);
         */
        JButton bdef = new JButton("DEF");
        Produto[] produtos = new Produto[20];
        JButton[] prod_b = new JButton[20];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                Produto produto = new Produto("Item" + (i + j * 4 + 1), i * .2);
                JButton b = new JButton("Item" + (i + j * 4 + 1));
                produtos[i + j * 4] = produto;
                prod_b[i + j * 4] = b;
                b.setBounds(i * 300, j * 100, 300, 100);
                frame.add(b);
            }
        }

        // ->
        bdef.setBounds((int) dimension.getWidth() - 100, 10, 100, 50);
        bdef.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                Definições();
            }

        });

        frame.add(bdef);
        frame.add(background);
        frame.add(panel);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }

    public void Definições() {
        JFrame frame = new JFrame("Definições");

        frame.setVisible(true);
    }
}
