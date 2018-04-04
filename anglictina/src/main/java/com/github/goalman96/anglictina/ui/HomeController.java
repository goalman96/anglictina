package com.github.goalman96.anglictina.ui;

import java.util.Observable;
import java.util.Observer;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import com.github.goalman96.anglictina.logika.*;

/**
 * Kontroler, který zprostředkovává komunikaci mezi grafikou
 * a logikou adventury
 * 
 * @author Tibor Vondrasek
 *
 */
public class HomeController extends VBox implements Observer {
	
	@FXML private Button jablkoButton;
	@FXML private Button hruskaButton;
	@FXML private Button jahodaButton;
	@FXML private Button bananButton;
	@FXML private Button pomerancButton;
	@FXML private Button ananasButton;
	@FXML private Label hadejLabel;
	@FXML private Label spravneLabel;
	@FXML private Label spatneLabel;
	
        
        
        private ObservableList<Object> veciBatoh = FXCollections.observableArrayList();
	private Hra hra;
	
	/**
	 * metoda čte příkaz ze vstupního textového pole
	 * a zpracuje ho
	 */
	@FXML public void hadej() {
		hadejLabel           
	}
	
	/**
	 * Metoda bude soužit pro předání objektu se spuštěnou hrou
	 * kontroleru a zobrazí stav hry v grafice.
	 * @param objekt spuštěné hry
	 */
	public void inicializuj(Hra hra) {
		Obrazek jablko = hra.
		Image jablko = new Image(getClass().getResourceAsStream("/zdroje/"+.getObrazek()),200 , 200, false, false);
		
		Image kocka = new Image(getClass().getResourceAsStream("/zdroje/cat.jpg"),200 , 200, false, false);
        Button kockaTlacitko = new Button("");
        kockaTlacitko.setTooltip(new Tooltip("Kočka"));
        kockaTlacitko.setUserData("Cat");
        kockaTlacitko.setGraphic(new ImageView(kocka));
	
		vystup.setEditable(false);
		this.hra = hra;
		seznamVeciMistnost.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getPredmety());
		seznamVychodu.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVychody());
		uzivatel.setX(hra.getHerniPlan().getAktualniProstor().getX());
		uzivatel.setY(hra.getHerniPlan().getAktualniProstor().getY());
                seznamVeciBatoh.setItems(veciBatoh);
		hra.getHerniPlan().addObserver(this);
                hra.getHerniPlan().notifyObservers();
	}
	
	/**
	 * Metoda spustí novou hru
	 * zavolá metodu notifyObservers, aby uvědomila objekty 
	 */
        @FXML public void novaHra() 
        {
                hra = new Hra();
		vystup.setText(hra.vratUvitani());
		vstupniText.setDisable(false);
                hra.getHerniPlan().addObserver(this);
                hra.getHerniPlan().notifyObservers();
        }
        
     	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		seznamVeciMistnost.getItems().clear();
		seznamVychodu.getItems().clear();
		seznamVeciMistnost.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getPredmety());
		seznamVychodu.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVychody());
		uzivatel.setX(hra.getHerniPlan().getAktualniProstor().getX());
		uzivatel.setY(hra.getHerniPlan().getAktualniProstor().getY());
                
                List<Predmet> sBatoh = hra.getHerniPlan().getBatoh().getBatoh();
                veciBatoh.clear();
                for (Predmet vec : sBatoh) 
                {
                    ImageView obrazek = new ImageView(new Image(com.github.goalman96.adventura.ui.Application.class.getResourceAsStream("/zdroje/"+vec.getObrazek()), 100, 100, false, false));
                    veciBatoh.add(obrazek);
                }
                
     	 
	}

}
