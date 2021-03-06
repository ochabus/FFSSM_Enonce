/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import FFSSM.Club;
import FFSSM.Embauche;
import FFSSM.Licence;
import FFSSM.Moniteur;
import FFSSM.Plongee;
import FFSSM.Plongeur;
import FFSSM.Site;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author chabus
 */
public class PlongeeTest {

    Licence l1;
    Moniteur Guillaume;// L'objet à tester
    Plongeur plongeur;
    Club dauphin;
    Plongee plong1;
    Embauche e1;
    ArrayList lesPlongees;

    @BeforeEach

    public void setUp() {
        // Initialiser les objets utilisés dans les tests
        dauphin = new Club(Guillaume, "Les Dauphins", "0729017354");
        plongeur = new Plongeur("86", "ALBAN", "Thibault", "28 pas. hermitte", "0678452543", LocalDate.of(1990, 12, 8));
        Guillaume = new Moniteur(Guillaume, dauphin, 4, "29", "CASTILLO", "Guillaume", "avenue de toulouse", "0637937900", LocalDate.of(1977, 4, 11));
        l1 = new Licence(Guillaume, "08917", LocalDate.of(2020, 9, 26), dauphin);
        e1 = new Embauche(LocalDate.of(2021, 12, 7), Guillaume, dauphin);
        plong1 = new Plongee(new Site("Arcachon", "bassin d'arcachon"), Guillaume, LocalDate.of(2021, 12, 5), 10, 4);
    }

    @Test
    public void TestAjoutParticipant() {
        lesPlongees = new ArrayList<>();
        plong1.ajouteParticipant(plongeur);
        lesPlongees.add(plongeur);
        assertTrue(plong1.plongee.contains(plongeur));
    }

    @Test
    public void TestEstConforme() {
        plongeur.ajouteLicence("73", LocalDate.of(2021, 5, 1), dauphin);
        plong1.ajouteParticipant(plongeur);
        assertTrue(plong1.estConforme());
    }
}
