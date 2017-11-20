import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Miner extends JFrame {
    private int bombsNumber, size, markedCount;
    private final int CELL_SIZE = 50;
    private JCell[][] field;

    public Miner(int size, int number) {
        this.size = size;
        bombsNumber = number;
        markedCount = 0;

        generateField();
        setLayout(new GroupLayout(getContentPane()));
        setBounds(0, 0, CELL_SIZE * size, CELL_SIZE * size + 50);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    MouseListener listener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            JCell cell = (JCell) e.getSource();

            if (e.getButton() == MouseEvent.BUTTON1)
                if (cell.isBomb())
                    openBombs();
                else
                    countAround(cell.x(), cell.y());

            else if (e.getButton() == MouseEvent.BUTTON3)
                if (!cell.isChecked()) {
                    if (cell.setMark())
                        markedCount++;
                    else
                        markedCount--;

                    if (markedCount == bombsNumber)
                        checkForWin();
                }

            System.out.println(cell);
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };

    private void checkForWin() {
        for (int x = 0; x < size; x++)
            for (int y = 0; y < size; y++)
                if (field[x][y].isBomb() && !field[x][y].isMarked())
                    return;

        showDialog("Congratulations!");
    }

    private void openBombs() {
        for (int x = 0; x < size; x++)
            for (int y = 0; y < size; y++)
                if (field[x][y].isBomb())
                    field[x][y].setText("x");

        showDialog("Game over.");
    }

    private void showDialog(String message) {
        String[] options = {"Try again", "Exit"};
        int response = JOptionPane.showOptionDialog
                (this, message, "Message", 0, JOptionPane.QUESTION_MESSAGE, null, options, "PHP");
        if (response == 0) {
            getContentPane().removeAll();
            setLayout(new GroupLayout(getContentPane()));
            generateField();
        } else
            dispose();
    }

    private void countAround(int x, int y) {
        Integer s = 0;

        for (int i = -1; i <= 1; i++)
            if (x + i >= 0 && x + i < size)
                for (int j = -1; j <= 1; j++)
                    if (y + j >= 0 && y + j < size)
                        s += field[x + i][y + j].isBomb() ? 1 : 0;

        if (s == 0) {
            field[x][y].setText("");
            openNear(x, y);
        } else
            field[x][y].setText(s + "");
    }

    private void openNear(int x, int y) {
        for (int i = -1; i <= 1; i++)
            if (x + i >= 0 && x + i < size)
                for (int j = -1; j <= 1; j++)
                    if (y + j >= 0 && y + j < size)
                        if (!field[x +i][y+j].isChecked())
                            countAround(x + i, y + j);
    }

    private void generateField() {
        int k = 0;
        field = new JCell[size][size];
        Random r = new Random();

        for (int x = 0; x < size; x++)
            for (int y = 0; y < size; y++) {
                JCell cell = new JCell(x, y, CELL_SIZE);
                cell.addMouseListener(listener);
                add(cell);
                field[x][y] = cell;
            }

        while (k < bombsNumber)
            if (field[r.nextInt(size)][r.nextInt(size)].setBomb())
                k++;
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
    }

}