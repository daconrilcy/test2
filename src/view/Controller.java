package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Controller implements ActionListener {

    private Model m;
    private String action;

    public Controller(Model m){
        this.m = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

      if (e.getSource() instanceof myJbutton){
          myJbutton b = (myJbutton)e.getSource();
          action = b.getActionModel();

          switch (action){
              case "Petite Carte":
                  m.creerPetiteMapAleatoire();
                  break;
              case "Moyenne Carte":
                  m.creerMoyenneMapAleatoire();
                  break;
              case "Grande Carte":
                  m.creerGrandeMapAleatoire();
                  break;
              default:
                  m.creerMoyenneMapAleatoire();
                  break;
          }
      } else{
          System.out.println("Pas myJButton");
      }



    }
}
