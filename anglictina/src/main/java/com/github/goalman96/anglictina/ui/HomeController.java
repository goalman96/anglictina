package com.github.goalman96.anglictina.ui;

import java.util.Observable;
import java.util.Observer;
import javafx.collections.ObservableList;

import com.github.goalman96.anglictina.logika.*;

/**
 * Kontroler, který zprostředkovává komunikaci mezi grafikou
 * a logikou adventury
 * 
 * @author Filip Vencovsky, Tibor Vondrasek
 *
 */
public class HomeController extends GridPane implements Observer {
	
	@FXML private TextField vstupniText;
	@FXML private TextArea vystup;
	@FXML private ListView<Predmet> seznamVeciMistnost;
	@FXML private ListView<Prostor> seznamVychodu;
    @FXML private ListView<Object> seznamVeciBatoh;
	@FXML private ImageView uzivatel;
	
        
        
        private ObservableList<Object> veciBatoh = FXCollections.observableArrayList();
	private IHra hra;
	
	/**
	 * metoda čte příkaz ze vstupního textového pole
	 * a zpracuje ho
	 */
	@FXML public void odesliPrikaz() {
		String vystupPrikazu = hra.zpracujPrikaz(vstupniText.getText());
		vystup.appendText("\n----------\n"+vstupniText.getText()+"\n----------\n");
		vystup.appendText(vystupPrikazu);
		vstupniText.setText("");
                hra.getHerniPlan().notifyObservers();
		if(hra.konecHry()) {
			vystup.appendText("\n----------\nKonec hry\n----------\n");
			vstupniText.setDisable(true);
		}
                
	}
	
	/**
	 * Metoda bude soužit pro předání objektu se spuštěnou hrou
	 * kontroleru a zobrazí stav hry v grafice.
	 * @param objekt spuštěné hry
	 */
	public void inicializuj(IHra hra) {
		vystup.setText(hra.vratUvitani());
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
