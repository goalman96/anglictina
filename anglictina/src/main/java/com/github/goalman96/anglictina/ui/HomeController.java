package com.github.goalman96.anglictina.ui;

import java.util.Observable;
import java.util.Observer;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	@FXML private Button hadejButton;
	@FXML private Label hadejLabel;
	@FXML private Label spravneLabel;
	@FXML private Label spatneLabel;
	
        
        
	private Hra hra;
	
	 @FXML public void hadej() {
		 	hra.vylosujObrazek();
		 	hadejLabel.setText(hra.getNahodnyObrazek().getAnglickyNazev());
     }
	 
	 @FXML public void jablkoClick() { 	
		 	hra.setTipnutyObrazek(hra.getJablko());
		 	hra.addObserver(this);
     }
	 
	 @FXML public void hruskaClick() { 	
		 	hra.setTipnutyObrazek(hra.getHruska());
		 	hra.addObserver(this);
	 }
	 
	 @FXML public void jahodaClick() { 	
		 	hra.setTipnutyObrazek(hra.getJahoda());
		 	hra.addObserver(this);
	 }
	 
	 @FXML public void bananClick() { 	
		 	hra.setTipnutyObrazek(hra.getBanan());
		 	hra.addObserver(this);
	 }
	 
	 @FXML public void pomerancClick() { 	
		 	hra.setTipnutyObrazek(hra.getPomeranc());
		 	hra.addObserver(this);
	 }
	 
	 @FXML public void ananasClick() { 	
		 	hra.setTipnutyObrazek(hra.getAnanas());
		 	hra.addObserver(this);
	 }
		
	
	
	public void inicializuj(Hra hra) {
		Obrazek jablko = hra.getJablko();
		ImageView obrazekJablko = new ImageView(new Image(com.github.goalman96.anglictina.ui.Application.class.getResourceAsStream("/zdroje/"+jablko.getObrazek()), 200, 200, false, false));
		jablkoButton.setTooltip(new Tooltip(jablko.getCeskyNazev()));
        jablkoButton.setGraphic(obrazekJablko);
        
        Obrazek hruska = hra.getHruska();
		ImageView obrazekHruska = new ImageView(new Image(com.github.goalman96.anglictina.ui.Application.class.getResourceAsStream("/zdroje/"+hruska.getObrazek()), 200, 200, false, false));
		hruskaButton.setTooltip(new Tooltip(hruska.getCeskyNazev()));
        hruskaButton.setGraphic(obrazekHruska);
        
        Obrazek jahoda = hra.getJahoda();
		ImageView obrazekJahoda = new ImageView(new Image(com.github.goalman96.anglictina.ui.Application.class.getResourceAsStream("/zdroje/"+jahoda.getObrazek()), 200, 200, false, false));
		jahodaButton.setTooltip(new Tooltip(jahoda.getCeskyNazev()));
        jahodaButton.setGraphic(obrazekJahoda);
        
        Obrazek banan = hra.getBanan();
		ImageView obrazekBanan = new ImageView(new Image(com.github.goalman96.anglictina.ui.Application.class.getResourceAsStream("/zdroje/"+banan.getObrazek()), 200, 200, false, false));
		bananButton.setTooltip(new Tooltip(banan.getCeskyNazev()));
        bananButton.setGraphic(obrazekBanan);
        
        Obrazek pomeranc = hra.getPomeranc();
		ImageView obrazekPomeranc = new ImageView(new Image(com.github.goalman96.anglictina.ui.Application.class.getResourceAsStream("/zdroje/"+pomeranc.getObrazek()), 200, 200, false, false));
		pomerancButton.setTooltip(new Tooltip(pomeranc.getCeskyNazev()));
        pomerancButton.setGraphic(obrazekPomeranc);
        
        Obrazek ananas = hra.getAnanas();
		ImageView obrazekAnanas = new ImageView(new Image(com.github.goalman96.anglictina.ui.Application.class.getResourceAsStream("/zdroje/"+ananas.getObrazek()), 200, 200, false, false));
		ananasButton.setTooltip(new Tooltip(ananas.getCeskyNazev()));
        ananasButton.setGraphic(obrazekAnanas);
        
        spravneLabel.setText("0");
        spatneLabel.setText("0");
        
        this.hra = hra;
	}

	public void update(Observable arg0, Object arg1) {
		hra.porovnejObrazky();
		spravneLabel.setText(hra.ScoreSpravneToString());
		spatneLabel.setText(hra.ScoreSpatneToString());
		Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setHeaderText(hra.getAlertText());
        alert.setContentText("Pokračovat");
        alert.showAndWait();
        hra.vylosujObrazek();
        hadejLabel.setText(hra.getNahodnyObrazek().getAnglickyNazev());
		
	}
}
