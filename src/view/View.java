package view;

import javax.swing.*;
import java.awt.*;

public class View {

    private JFrame frame;
    private JTextField txField;
    private JButton button;

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTextField getTxField() {
        return txField;
    }

    public void setTxField(JTextField txField) {
        this.txField = txField;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public View(){
        frame = new JFrame("My Settlers");
        txField = new JTextField();
        txField.setColumns(10);
        button = new JButton("Create");

        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(txField);
        frame.getContentPane().add(button);

        frame.setVisible(true);
        frame.pack();
    }
}
