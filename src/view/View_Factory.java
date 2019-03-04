package view;

import game.Game;

import javax.swing.*;

public class View_Factory {
    View view;
    Controller controller;
    Model model;
    Game game;

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void ajouterActionBoutons(){
        myJbutton[] bts = view.getButtons();
        for (int n = 0 ; n < bts.length ; n++){
            bts[n].addActionListener(controller);
        }
    }

    public void creerVue(){
        this.view = new View();
        this.model = new Model(game);
        this.controller = new Controller(model);
        ajouterActionBoutons();
    }

    public View_Factory(Game game) {
        this.game = game;
    }
}
