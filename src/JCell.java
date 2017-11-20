import javax.swing.*;

public class JCell extends JButton{
    private int xPos;
    private int yPos;
    private boolean isBomb;
    private boolean isChecked;
    private boolean isMarked;

    public JCell(int x, int y, int size) {
        super();
        xPos = x;
        yPos = y;
        isBomb = false;
        isMarked = false;
        isChecked = false;
        setBounds(x * size, y * size, size, size);
    }

    public int x() {
        return xPos;
    }

    public int y() {
        return yPos;
    }

    public boolean isBomb(){
        return isBomb;
    }

    public boolean setBomb(){
        if (!isBomb) {
            isBomb = true;
            return true;
        }
        return false;
    }

    public boolean isChecked(){
        return isChecked;
    }
    public void setText(String text) {
        super.setText(text);
        setEnabled(false);
        isChecked = true;
    }

    public boolean setMark() {
        if (isMarked) {
            super.setText("");
            isMarked = false;
            return false;
        }else {
            super.setText("F");
            isMarked = true;
            return true;
        }
    }
    public String toString() {
        return "{" +
                "" + xPos +
                " " + yPos +
                ", isBomb=" + isBomb +
                ", isChecked=" + isChecked +
                ", isMarked=" + isMarked +
                '}';
    }

    public boolean isMarked() {
        return isMarked;
    }
}
