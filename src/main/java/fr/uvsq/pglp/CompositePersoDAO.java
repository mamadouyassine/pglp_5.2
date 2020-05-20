package fr.uvsq.pglp;
import java.sql.Connection;

public abstract class CompositePersoDAO extends DAO<CompositePerso> {

    public CompositePersoDAO(Connection conn) {
        super(conn);
        // TODO Auto-generated constructor stub
    }

    @Override
    public CompositePerso create(CompositePerso obj) {
        // TODO Auto-generated method stub
        return obj;
    }

    @Override
    public CompositePerso find(int id) {
        // TODO Auto-generated method stub
        CompositePerso grpperso=null;
        return grpperso;
    }



}
