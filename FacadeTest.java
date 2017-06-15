package packglad;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.either;


public class FacadeTest {


    @Before
    //Lance le jeu d'essais au début du test pour avoir déjà des ethnies créées
    public void setUp() {
        Facade.lancerJeu();
    }

    /**
     * @see Facade#lancerJeu()
     */
    @Test
    public void testLancerJeu() {
        fail("Unimplemented");
    }

    /**
     * @see Facade#lancerJeuDEssai()
     */
    @Test
    public void testLancerJeuDEssai() {
        fail("Unimplemented");
    }

    /**
     * @see Facade#parametrage(Integer,Integer,Integer,Integer)
     */
    @Test
    public void testParametrage() {
        fail("Unimplemented");
    }

    @Test
    //4.a testIDG
    public void testIDG() {
        int ide = 4;
        gEthnie.creerEthnie(ide, "Strasbourgeois");
        int agilite = 200;

        int idg;
        for (int i = 1; i <= 10; i++) {
            idg = Facade.creerRetiaire("Antonismael", agilite, ide);
            assertThat("L'idg n'est pas " + i, idg, is(i));
            Facade.supprimerGlad(idg);
        }

        Facade.supprimerEthnie(ide);
    }

    @Test
    //4.b testAjoutGlad
    public void testAjoutGlad() {
        int ide = 4;
        gEthnie.creerEthnie(ide, "Strasbourgeois");
        int agilite = 200;

        int idg;
        for (int i = 1; i <= 10; i++) {
            idg = Facade.creerRetiaire("Antonismael", agilite, ide);
            assertThat("L'idg n'est pas " + i, idg, is(i));
            Facade.supprimerGlad(idg);
        }

        Facade.supprimerEthnie(ide);
    }


    /**
     * @see Facade#creerRetiaire(String,Integer,Integer)
     */
    @Test
    //1.a creerRetiaire
    public void testCreerRetiaire() {
        int ide = 4;
        gEthnie.creerEthnie(ide, "Strasbourgeois");
        int agilite = 200;
        int idg = Facade.creerRetiaire("Antonismael", agilite, 4);
        assertThat("Facade.agiliteRetiaire : Agilite ne vaut pas 200 ou agiliteMax des Retiaire",
                   Facade.agiliteRetiaire(idg), either(is(200)).or(is(Facade.getAgiliteMaxRetiaire())));

        Facade.supprimerGlad(idg);
        Facade.supprimerEthnie(ide);
    }

    /**
     * @see Facade#creerMirmillon(String,Integer,Integer)
     */
    @Test
    //2.a creerMirmillon
    public void testCreerMirmillon() {
        int ide = 4;
        gEthnie.creerEthnie(ide, "Strasbourgeois");
        int poids = 200;
        int idg = Facade.creerMirmillon("Antonismael", poids, 4);
        assertThat("Facade.poidsMirmillon : Poids ne vaut pas 200 ou poidsMax des Mirmillon",
                   Facade.poidsMirmillon(idg), either(is(200)).or(is(Facade.getPoidsMaxMirmillon())));

        Facade.supprimerGlad(idg);
        Facade.supprimerEthnie(ide);
    }

    /**
     * @see Facade#listerTousGladiateurs()
     */
    @Test
    public void testListerTousGladiateurs() {
        fail("Unimplemented");
    }

    /**
     * @see Facade#listerAgresseurs(Integer)
     */
    @Test
    public void testListerAgresseurs() {
        fail("Unimplemented");
    }

    /**
     * @see Facade#faireSaluerGladiateur(Integer)
     */
    @Test
    public void testFaireSaluerGladiateur() {
        fail("Unimplemented");
    }

    /**
     * @see Facade#faireRapport(Integer)
     */
    @Test
    public void testFaireRapport() {
        fail("Unimplemented");
    }

    /**
     * @see Facade#declarerArmes(Integer)
     */
    @Test
    public void testDeclarerArmes() {
        fail("Unimplemented");
    }

    /**
     * @see Facade#supprimerGlad(Integer)
     */
    @Test
    public void testSupprimerGlad() {
        fail("Unimplemented");
    }


    //6.a
    @Test(expected = IllegalArgumentException.class)
    public void testCreerUneArme1() {
        int ida1 = Facade.creerUneArme(null, 0, 10);
        int ida2 = Facade.creerUneArme("", -10, 10);
    }

    //6.b
    @Test(expected = IllegalArgumentException.class)
    public void testCreerUneArme2() {
        int ida1 = Facade.creerUneArme("Kaaris", 10, 20);
        int ida2 = Facade.creerUneArme("Kaaris", 3, 67);
    }

    /**
     * @see Facade#autoriserArmeAuxMirmillons(Integer)
     */
    @Test
    public void testAutoriserArmeAuxMirmillons() {
        fail("Unimplemented");
    }

    /**
     * @see Facade#autoriserArmeAuxRetiaires(Integer)
     */
    @Test
    public void testAutoriserArmeAuxRetiaires() {
        fail("Unimplemented");
    }

    //8.a
    @Test(expected = NoSuchElementException.class)
    public void testDonnerUneArme() {
        Facade.donnerUneArme(10, 10);

        // 8.b
        Ethnie ide = new Ethnie(1, "Neuhof");
        Integer idm = Facade.creerMirmillon("Lol", 30, 1);
        Integer ida = Facade.creerUneArme("Lance", 30, 1);
        Facade.donnerUneArme(idm, ida);

        assertTrue("gGladiateur.getGladiateur(idm).declarerArmes : liste des armes autorisées non vide",
                   gGladiateur.getGladiateur(idm).declarerArmes().isEmpty());
        
        //8.c
        
        Facade.autoriserArmeAuxMirmillons(ida);
        Facade.donnerUneArme(idm, ida);
        
        assertThat("gGladiateur.getGladiateur(idm).declarerArmes : n'est pas de taille 1",
                   gGladiateur.getGladiateur(idm).declarerArmes().size(), is(1));
    
        //8.d
        Facade.donnerUneArme(idm, ida);
        assertThat("gGladiateur.getGladiateur(idm).declarerArmes : n'est pas de taille 1",
                   gGladiateur.getGladiateur(idm).declarerArmes().size(), is(1));
        
        //8.e
        Integer ida2 = Facade.creerUneArme("Ok", 13, 13);
        Facade.autoriserArmeAuxMirmillons(ida2);
        Facade.donnerUneArme(idm, ida2);
        assertThat("gGladiateur.getGladiateur(idm).declarerArmes : n'est pas de taille 2",
                   gGladiateur.getGladiateur(idm).declarerArmes().size(), is(2));
    }

    //7.a
    @Test
    public void testListerArmesDispoMirmillon1() {
        assertTrue("Facade.listerArmesDispoMirmillon : liste des armes diponbibles aux mirmillons non vide initialement",
                   Facade.listerArmesDispoMirmillon().isEmpty());
        // 7.b
        Integer ida = Facade.creerUneArme("KB9", 9, 10);
        Facade.autoriserArmeAuxMirmillons(ida);

        assertThat("Facade.listerArmesDispoMirmillon().size : n'est pas de taille 1",
                   Facade.listerArmesDispoMirmillon().size(), is(1));


        assertThat("Facade.listerArmesDispoMirmillon().contains(a) : la liste ne contient pas l'arme ",
                   Facade.listerArmesDispoMirmillon().contains(ida), is(true));

    }

    //7.b
    @Test
    public void testListerArmesDispoMirmillon2() {
        Integer ida = Facade.creerUneArme("M10", 20, 15);
        Facade.autoriserArmeAuxMirmillons(ida);
        Facade.autoriserArmeAuxRetiaires(ida);

        assertThat("Facade.listerArmesDispoMirmillon().size : n'est pas de taille 1",
                   Facade.listerArmesDispoMirmillon().size(), is(1));

        assertThat("Facade.listerArmesDispoRetiaire().size : n'est pas de taille 1",
                   Facade.listerArmesDispoRetiaire().size(), is(1));

        assertThat("Facade.listerArmesDispoMirmillon().contains(a) : la liste ne contient pas l'arme ",
                   Facade.listerArmesDispoMirmillon().contains(ida), is(true));

        assertThat("Facade.listerArmesDispoRetiaire().contains(a) : la liste ne contient pas l'arme ",
                   Facade.listerArmesDispoRetiaire().contains(ida), is(true));
    }


    @Test
    public void testListerArmesDispoRetiaire() {
        fail("Unimplemented");
    }

    /**
     * @see Facade#decrireArme(Integer)
     */
    @Test
    public void testDecrireArme() {
        fail("Unimplemented");
    }

    /**
     * @see Facade#nomDeLArme(Integer)
     */
    @Test
    public void testNomDeLArme() {
        fail("Unimplemented");
    }

    /**
     * @see Facade#listerEthnies()
     */
    @Test
    public void testListerEthnies() {
        fail("Unimplemented");
    }

    /**
     * @see Facade#listerGladiateursDEthnie(Integer)
     */
    @Test
    //3.a listerGladiateursDEthnie
    public void testListerGladiateursDEthnie() {
        int ide = 4;
        gEthnie.creerEthnie(ide, "Strasbourgeois");
        int poids = 200;
        int idg = Facade.creerMirmillon("Antonismael", poids, 4);

        assertThat("Facade.listerGladiateursDEthnie(ethnie).contains(idg) : Le gladiateur ne fait pas partie de l'Ethnie",
                   Facade.listerGladiateursDEthnie(ide).contains(idg), is(true));

        Facade.supprimerGlad(idg);
        Facade.supprimerEthnie(ide);
    }

    /**
     * @see Facade#decrireEthnie(Integer)
     */
    @Test
    public void testDecrireEthnie() {
        fail("Unimplemented");
    }

    /**
     * @see Facade#getScore(Integer)
     */
    @Test
    public void testGetScore() {
        fail("Unimplemented");
    }

    /**
     * @see Facade#frapper(Integer,Integer,Integer)
     */
    @Test
    public void testFrapper() {
        fail("Unimplemented");
    }

    /**
     * @see Facade#desarmer(Integer,Integer)
     */
    @Test
    public void testDesarmer() {
        fail("Unimplemented");
    }

    /**
     * @see Facade#vainqueurs()
     */
    @Test
    public void testVainqueurs() {
        fail("Unimplemented");
    }

    /**
     * @see Facade#nomDuGladiateur(Integer)
     */
    @Test
    public void testNomDuGladiateur() {
        fail("Unimplemented");
    }

    /**
     * @see Facade#nomDeLEthnie(Integer)
     */
    @Test
    public void testNomDeLEthnie() {
        fail("Unimplemented");
    }
}
