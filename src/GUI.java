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

        JButton start = new JButton("Начало");
        start.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Miner miner = new Miner(x,y);
                frame.dispose();
            }
        });
        panel.add(start);
        JButton help = new JButton("Правила");
        help.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(frame, "Число в ячейке показывает, сколько мин скрыто вокруг данной ячейки . Это число поможет понять вам, где находятся безопасные ячейки, а где находятся бомбы.\n" +
                        "Если рядом с открытой ячейкой есть пустая ячейка, то она откроется автоматически.\n" +
                        "Если вы открыли ячейку с миной, то игра проиграна..\n" +
                        "Что бы пометить ячейку, в которой находится бомба, нажмите её правой кнопкой мыши.\n" +
                        "После того, как вы отметите все мины, можно навести курсор на открытую ячейку и нажать правую и левую кнопку мыши одновременно. Тогда откроются все свободные ячейки вокруг неё\n" +
                        "Если в ячейке указано число, оно показывает, сколько мин скрыто в восьми ячейках вокруг данной. Это число помогает понять, где находятся безопасные ячейки.\n" +
                        "Игра продолжается до тех пор, пока вы не откроете все не заминированные ячейки.");
            }
        });
        panel.add(help);
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 80));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}