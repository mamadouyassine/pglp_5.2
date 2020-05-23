package fr.uvsq.pglp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class EntrepriseConnection {

    private static String JDBC_URL="jdbc:derby:PersoDB;create=true";
    private static final String DRIVER="org.apache.derby.jdbc.EmbeddedDriver";

    public static Connection getInstanceConnexion()
    {
        try {

            Class.forName(DRIVER);

            Connection connec =DriverManager.getConnection(JDBC_URL);
            if (connec!=null)
            {
                System.out.println("connexion au serveur de Bd reuissi");
                return connec;
            }
        } catch (SQLException e )
        {
            System.out.println("echec de connexion");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
            System.out.println("ERREUR : charger derby.jdbc.EmbeddedDriver ");

        }
        return null;
    }

    public static void createAllTabl(final Connection connect)
            throws SQLException {
        String Personnel = "CREATE TABLE PERSONEL ("
                + "Nom varchar(30),"
                + "Prenom varchar(30)"
                + ")";
    }
}
