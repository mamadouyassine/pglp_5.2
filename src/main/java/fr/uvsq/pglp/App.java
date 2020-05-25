package fr.uvsq.pglp;

import org.apache.derby.iapi.jdbc.EngineConnection;

import java.sql.Connection;

/**
 * Hello world!
 *
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Connection connect = EntrepriseConnection.getInstanceConnexion();
        Personnels P1 ;
    }

}
