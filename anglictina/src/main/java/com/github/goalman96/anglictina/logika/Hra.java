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
    
     /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public Hra() {
        zalozHru();
        obrazky = new ArrayList<Obrazek>();

    }
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
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
        
    }
    
    public Obrazek getNahodnyObrazek(Obrazek[] obrazky) {
    	Random generator = new Random();
    	int randomIndex = generator.nextInt(obrazky.length);
    	return obrazky[randomIndex];
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
}


