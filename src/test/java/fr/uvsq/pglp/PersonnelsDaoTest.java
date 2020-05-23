package fr.uvsq.pglp;

import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

public class PersonnelsDaoTest {
    Personnels persoSave;
    Personnels persoGet;

    @Before
    public void setup() {

        persoSave= new Personnels.Builder("Tall", "Abdoul", 2).build();

    }



    @Test
    public void test() {


    }

}