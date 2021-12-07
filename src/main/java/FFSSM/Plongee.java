/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Plongee {

    public Site lieu;

    public Moniteur chefDePalanquee;

    public LocalDate date;

    public int profondeur;

    public int duree;
    private Licence licence;
    private ArrayList<Plongeur> plongee = new ArrayList<>();

    public Plongee(Site lieu, Moniteur chefDePalanquee, LocalDate date, int profondeur, int duree) {
        this.lieu = lieu;
        this.chefDePalanquee = chefDePalanquee;
        this.date = date;
        this.profondeur = profondeur;
        this.duree = duree;

    }

    public void ajouteParticipant(Plongeur participant) {
        plongee.add(participant);
    }

    public LocalDate getDate() {
        return date;
    }

    /**
     * Détermine si la plongée est conforme. Une plongée est conforme si tous
     * les plongeurs de la palanquée ont une licence valide à la date de la
     * plongée
     *
     * @return vrai si la plongée est conforme
     */
    public boolean estConforme() {
        boolean estConforme = false;
        if (licence.estValide(date)) {
            estConforme = true;
        }
        return estConforme;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.lieu);
        hash = 31 * hash + Objects.hashCode(this.chefDePalanquee);
        hash = 31 * hash + Objects.hashCode(this.date);
        hash = 31 * hash + this.profondeur;
        hash = 31 * hash + this.duree;
        hash = 31 * hash + Objects.hashCode(this.licence);
        hash = 31 * hash + Objects.hashCode(this.plongee);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Plongee other = (Plongee) obj;
        if (this.profondeur != other.profondeur) {
            return false;
        }
        if (this.duree != other.duree) {
            return false;
        }
        if (!Objects.equals(this.lieu, other.lieu)) {
            return false;
        }
        if (!Objects.equals(this.chefDePalanquee, other.chefDePalanquee)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.licence, other.licence)) {
            return false;
        }
        if (!Objects.equals(this.plongee, other.plongee)) {
            return false;
        }
        return true;
    }

}
