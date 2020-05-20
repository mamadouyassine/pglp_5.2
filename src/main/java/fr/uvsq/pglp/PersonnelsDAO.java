package fr.uvsq.pglp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonnelsDAO  extends DAO<Personnels> {
    public PersonnelsDAO(Connection conn) {
        super(conn);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Personnels create(Personnels obj) {
        try {

            Statement s;
            s = connect.createStatement();
            try {
                s.execute("create table personnel (nom varchar(40), prenom varchar(40),Id int ,PRIMARY KEY (id))");
                System.out.println("Created table derby");
            } catch (Exception e) {
                // TODO: handle exception
            }
            PreparedStatement prepare = connect.prepareStatement("INSERT INTO personnel (nom, prenom, Id) VALUES (?,?,?) ");
            prepare.setString(1, obj.getNom());
            prepare.setString(2, obj.getPrenom());
            prepare.setInt(3, obj.getId());
            prepare.executeUpdate();
        } catch (SQLException e) {
            // TODO: handle exception
        }
        return obj;
    }

    @Override
    public Personnels find(int Id) {

        Personnels perso=null;
        try {
            PreparedStatement prepare = this.connect.prepareStatement("SELECT * FROM personnel WHERE ID = ?");
            prepare.setInt(1, Id);
            ResultSet result= prepare.executeQuery();
            if(result.next()) {
                perso = new Personnels
                        .Builder(result.getString("nom"), result.getString("prenom"), result.getInt("Id"))
                        .build();
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

        return perso;
    }

    @Override
    public int update(int id , String nom , String prenom) {
        try
        {
            PreparedStatement prepare =this.connect.prepareStatement("update personnel set nom=?,prenom=? where id=?");
            prepare.setString(1, nom);
            prepare.setString(2, prenom);
            prepare.setInt(3, id);
            return prepare.executeUpdate();

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        try
        {
            PreparedStatement prepare =this.connect.prepareStatement("delete from personnel where id=?");
            prepare.setInt(1, id);
            return prepare.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return 0;
    }
}
