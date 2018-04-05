package com.github.goalman96.anglictina.logika;

import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
/**
 * Trida Prostor - popisuje jednotlivé prostory (místnosti) hry
 *
 * Tato třída je součástí jednoduché textové hry.
 *
 * "Prostor" reprezentuje jedno místo (místnost, prostor, ..) ve scénáři hry.
 * Prostor může mít sousední prostory připojené přes východy. Pro každý východ
 * si prostor ukládá odkaz na sousedící prostor.
 *
 * @author Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova, Alena Buchalcevova
 * @version z kurzu 4IT101 pro školní rok 2014/2015
 */
public class Obrazek {

    private String ceskyNazev;
    private String anglickyNazev;  
    private String obrazek;
    /**
     * Vytvoření prostoru se zadaným popisem, např. "kuchyň", "hala", "trávník
     * před domem"
     *
     * @param nazev nazev prostoru, jednoznačný identifikátor, jedno slovo nebo
     * víceslovný název bez mezer.
     * @param popis Popis prostoru.
     */
    public Obrazek(String ceskyNazev, String anglickyNazev, String obrazek) {
        this.ceskyNazev = ceskyNazev;
        this.anglickyNazev = anglickyNazev;
        this.obrazek = obrazek;
        
    }

    public String getCeskyNazev() { 
    	return this.ceskyNazev;
    }
    
    public String getAnglickyNazev() {
    	return this.anglickyNazev;
    }
    
    public String getObrazek() {
    	return this.obrazek;
    }
    
}
