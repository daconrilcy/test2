package view;

import javax.swing.*;
import java.awt.*;

public class View {

    private JFrame frame;
    private JTextField txField;
    private myJbutton[] buttons;
    private String[] nomButton = new String[]{"Petite Carte", "Moyenne Carte" , "Grande Carte"};

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

    public String[] getNomButton() {
        return nomButton;
    }
    public myJbutton[] getButtons(){
      return buttons;
    };

    private void creerBoutons(){
        buttons = new myJbutton[nomButton.length];
        for (int n = 0 ; n < nomButton.length ; n++){
            buttons[n] = new myJbutton(nomButton[n], nomButton[n]);
            frame.getContentPane().add(buttons[n]);
        }
    }

    public void dessinne(){
        System.out.println("dessine");
        frame = new JFrame("My Settlers");
        frame.setLayout(new FlowLayout());
        creerBoutons();

        frame.setVisible(true);
        frame.pack();

    }

    public View (){
       dessinne();
    }
}
