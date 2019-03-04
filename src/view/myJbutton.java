package view;

import javax.swing.*;

public class myJbutton extends JButton {
    private String actionModel;

    public String getActionModel() {
        return actionModel;
    }

    public void setActionModel(String actionModel) {
        this.actionModel = actionModel;
    }


    public myJbutton(Icon icon) {
        super(icon);
    }

    public myJbutton(String text) {
        super(text);
    }

    public myJbutton(String text , String action) {
        super(text);
        this.actionModel = action;
    }

    public myJbutton(Action a) {
        super(a);
    }

    public myJbutton(String text, Icon icon) {
        super(text, icon);
    }
}
