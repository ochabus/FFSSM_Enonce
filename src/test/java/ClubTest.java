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
import java.time.Month;
import java.util.ArrayList;
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
public class ClubTest {
  Licence l1;
    Moniteur Guillaume;
    Plongeur plongeur, plongeur2;
    Club dauphin;// L'objet à tester
    Plongee plong1;
    Embauche e1;
  ArrayList lesPlongees;

    @BeforeEach

    public void setUp() {
        // Initialiser les objets utilisés dans les tests
        dauphin = new Club(Guillaume, "Les Dauphins", "0729017354");
        plongeur = new Plongeur("86", "ALBAN", "Thibault", "28 pas. hermitte", "0678452543", LocalDate.of(1990, 12, 8));
        plongeur2 = new Plongeur("86", "DALI", "Evans", "28 pas. hermitte", "0678452543", LocalDate.of(1989, 6, 3));
        Guillaume = new Moniteur(Guillaume, dauphin, 4, "29", "CASTILLO", "Guillaume", "avenue de toulouse", "0637937900", LocalDate.of(1977, 4, 11));
        l1 = new Licence(Guillaume, "08917", LocalDate.of(2020, 9, 26), dauphin);
        e1 = new Embauche(LocalDate.of(2021, 12, 7), Guillaume, dauphin);
        plong1 = new Plongee(new Site("Arcachon","bassin d'arcachon"),Guillaume, LocalDate.of(2021, 12, 5),10,4);
    }
@Test
public void TestPlongeeNonConformes(){
    plongeur.ajouteLicence("89876", LocalDate.of(2021, 12, 5), dauphin);
    plong1.ajouteParticipant(plongeur);
    plongeur2.ajouteLicence("234", LocalDate.of(2020, 12, 5), dauphin);
    plong1.ajouteParticipant(plongeur2);
    
   assertFalse(plong1.estConforme(),"Il y a une plongee non conforme");
   
}
 @Test
    public void TestOrganisePlongee(){
        //lesPlongees = new ArrayList<>();
        dauphin.organisePlongee(plong1);
        //assertTrue(dauphin.lesPlongees.contains(plong1));
        assertTrue(dauphin.plongees.contains(plong1));
    }
}
