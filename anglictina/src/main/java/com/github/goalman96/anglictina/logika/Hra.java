package com.github.goalman96.anglictina.logika;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

/**
 *  
 *
 *@author     Tibor Vondrasek
 */
public class Hra extends Observable {
    
    private Obrazek jablko;
    private Obrazek hruska;
    private Obrazek jahoda;
    private Obrazek banan;
    private Obrazek pomeranc;
    private Obrazek ananas;
    private ArrayList<Obrazek> obrazky;
    private Random randomGenerator;
    private int scoreSpravne;
    private int scoreSpatne;
    private Obrazek nahodnyObrazek;
    private Obrazek tipnutyObrazek;
    private String alertText;
    
     
    public Hra() {
    	randomGenerator = new Random();
    	obrazky = new ArrayList<Obrazek>();
        zalozHru();

    }
    /**
     *  Vytváří obrázky a  
     *  Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozHru() {
        jablko = new Obrazek("jablko", "apple", "jablko.jpg");
        hruska = new Obrazek("hruška", "pear", "hruska.jpg");
        jahoda = new Obrazek("jahoda", "strawberry", "jahoda.jpg");
        banan = new Obrazek("banán", "banana", "banan.jpg");
        pomeranc = new Obrazek("pomeranč", "orange", "pomeranc.jpg");
        ananas = new Obrazek("ananas", "pineapple", "ananas.jpg");
        obrazky.add(jablko);
        obrazky.add(hruska);
        obrazky.add(jahoda);
        obrazky.add(banan);
        obrazky.add(pomeranc);
        obrazky.add(ananas);
        scoreSpravne = 0;
        scoreSpatne = 0;
        
    }
    
    public void vylosujObrazek() {
    	int index = randomGenerator.nextInt(obrazky.size());
        this.nahodnyObrazek = obrazky.get(index);
    }
    public Obrazek getNahodnyObrazek() {
    	return this.nahodnyObrazek;
    }
    
    public void setTipnutyObrazek(Obrazek obrazek) {
    	this.tipnutyObrazek = obrazek;
        notifyObservers();
    }
    public void porovnejObrazky() {
    	if(nahodnyObrazek.equals(tipnutyObrazek)) {
    		zvysScoreSpravne();
    	}
    	else {
    		zvysScoreSpatne();
    	}
    }
    
    public Obrazek getJablko() {
    	return this.jablko;
    }
    
    public Obrazek getHruska() {
    	return this.hruska;
    }
    
    public Obrazek getJahoda() {
    	return this.jahoda;
    }
    
    public Obrazek getBanan() {
    	return this.banan;
    }
    
    public Obrazek getPomeranc() {
    	return this.pomeranc;
    }
    
    public Obrazek getAnanas() {
    	return this.ananas;
    }
    
    public String ScoreSpravneToString() {
    	return String.valueOf(scoreSpravne);
    }
    
    public String ScoreSpatneToString() {
    	return String.valueOf(scoreSpatne);
    }
    
    public void zvysScoreSpravne() {
    	alertText = "Správně!";
    	this.scoreSpravne++;
    }
    
    public void zvysScoreSpatne() {
    	alertText = "Špatný obrázek";
    	this.scoreSpatne++;
    	
    }
    public void vymazScore() {
    	this.scoreSpravne = 0;
    	this.scoreSpatne = 0;
    }
    
    public String getAlertText() {
    	return alertText;
    }
    
    @Override
    public void notifyObservers(){
        setChanged();
        super.notifyObservers();
    }
}


