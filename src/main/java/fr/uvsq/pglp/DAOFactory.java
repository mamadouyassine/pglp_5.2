package fr.uvsq.pglp;
import java.sql.Connection;

public class DAOFactory {
    private static final Connection conn= EntrepriseConnection.getInstanceConnexion();


    public static PersonnelsDAO getPersonnelsDAO(){
        return new PersonnelsDAO(conn);
    }

    public static CompositePersoDAO getCompositePerso(){
        return new CompositePersoDAO(conn) {
            @Override
            public int update(int id, String nom, String premnom) {
                return 0;
            }

            @Override
            public int delete(int id) {
                return 0;
            }
        };

    }


}
