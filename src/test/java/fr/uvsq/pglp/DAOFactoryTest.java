package fr.uvsq.pglp;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class DAOFactoryTest {
    Personnels persoSave;
    Personnels persoSave1;
    Personnels persoSave2;
    Personnels persoSave3;
    Personnels persodelete;
    Personnels persoGet;
    Personnels persoGet1;
    Personnels persoGet2;
    Personnels persoGet3;
    Personnels persofind;
    Personnels persofind1;
    PersonnelsDAO persoDao;

    @Before
    public void setUp() throws Exception {
        persoGet=null;
        persoDao=null;
        persofind=null;
        persoSave= new Personnels
                .Builder("Derra", "Abdoul", 2).build();
        persoSave1= new Personnels
                .Builder("Maiga", "Abdalah", 1).build();
        persoSave2= new Personnels
                .Builder("Traore", "Benedicte", 3).build();
        persoSave3= new Personnels
                .Builder("Jean", "Jacques", 4).build();
        persodelete= new Personnels
                .Builder("Simpore", "Naimatou", 5).build();
    }

    @Test
    public void testCreate() {
        persoDao = DAOFactory.getPersonnelsDAO();
        persoGet1=persoDao.create(persoSave1);
        persoGet=persoDao.create(persoSave);
        persoGet2=persoDao.create(persoSave2);
        persoGet3=persoDao.create(persoSave3);
        persoGet3=persoDao.create(persodelete);
        assertTrue(persoGet!=null);
        assertTrue(persoGet1!=null);
        assertTrue(persoGet2!=null);
        assertTrue(persoGet3!=null);


    }

    @Test
    public void testfind() {
        persoDao = DAOFactory.getPersonnelsDAO();
        persofind=persoDao.find(1);
        persofind1=persoDao.find(3);
        assertTrue(persofind!=null);
        assertTrue(persofind1!=null);
        persofind.print();
        persofind1.print();


    }

    @Test
    public void testUpdate() {
        persoDao = DAOFactory.getPersonnelsDAO();
        assertTrue(persoDao.update(4,"Jean"," Luc")==1);
    }

    @Test
    public void testDelete() {
        persoDao = DAOFactory.getPersonnelsDAO();
        assertTrue(persoDao.delete(5)==1);
    }


}