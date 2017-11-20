import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class GUI
{
    private JCheckBox ez; //чекбокс для жирного шрифта
    private JCheckBox norm;
    private JCheckBox hard;
    int x;
    int y;
    public GUI()
    {

        JFrame.setDefaultLookAndFeelDecorated(true);
        final JFrame frame = new JFrame("Сапер");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        panel.setLayout(new FlowLayout());

        JButton start = new JButton("Start");
        start.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Miner miner = new Miner(x,y);
                frame.dispose();
            }
        });
        panel.add(start);

        ez = new JCheckBox("Easy");
        ez.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (ez.isSelected()){
                    x = 9;
                    y = 10;
                }
            }
        });
        norm = new JCheckBox("Norm");
        norm.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (norm.isSelected()){
                    x = 16;
                    y = 40;
                }
            }
        });
        hard = new JCheckBox("Hard");
        hard.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (hard.isSelected()){
                    x = 18;
                    y = 100;
                }

            }
        });

        panel.add(ez);
        panel.add(norm);
        panel.add(hard);


        frame.getContentPane().add(panel);

        frame.setPreferredSize(new Dimension(400, 80));

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}