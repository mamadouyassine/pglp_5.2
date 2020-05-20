package fr.uvsq.pglp;
import java.io.Serializable;
import java.sql.Connection;

public abstract class DAO <T> implements Serializable {
    protected Connection connect = null;

    public DAO(Connection conn){
        this.connect = conn;
    }


    public abstract T create(T obj);
    public abstract T find(int id);
    public abstract int update(int id , String nom, String premnom);
    public abstract int delete (int id);
}
