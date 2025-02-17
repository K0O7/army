package daos.mySqlImp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import daos.ISoldierDao;
import solvd.ConnectionPool;
import solvd.army.Soldier;

public class SoldierDao extends AbstractMySqlDao implements ISoldierDao {

	@Override
	public Soldier getById(long id) {
		try(Connection con = getConnection()) {
			String sql = "SELECT * FROM Army.soldiers where id=?";
			try (PreparedStatement ps = con.prepareStatement(sql)){
				ps.setLong(1, id);
				try (ResultSet rs = ps.executeQuery()){
					Soldier s = new Soldier();
					while(rs.next()) {
						s.setId(rs.getLong("id"));
						s.setFirstName(rs.getString("first_name"));
						s.setLastName(rs.getString("last_name"));
					}

					return s;
		}}} catch(SQLException  e) {
			//logger.severe("Error selecting soldier by id: " + e.getMessage());
		}
		return null;
	}

	@Override
	public Soldier save(Soldier entity) {
        try(Connection con = getConnection()) {
            String sql = "INSERT INTO Army.soldiers (id, first_name, last_name) VALUES (?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(sql)){
            	ps.setLong(1, entity.getId());
            	ps.setString(2, entity.getFirstName());
            	ps.setString(3, entity.getLastName());
            	int rowsAffected = ps.executeUpdate();
            	if (rowsAffected > 0) {
            		return entity;
            }
        }} catch (SQLException e) {
        	//logger.severe("Error saving soldier: " + e.getMessage());
        }
        return null;
	}

	@Override
	public Soldier update(Soldier entity) {

        try(Connection con = getConnection()) {
            String sql = "UPDATE Army.soldiers SET first_name = ?, last_name = ? WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)){
            	ps.setString(1, entity.getFirstName());
            	ps.setString(2, entity.getLastName());
            	ps.setLong(3, entity.getId());

            	int rowsUpdated = ps.executeUpdate();
            	if (rowsUpdated > 0) {
            		return entity;
            }
        }} catch (SQLException e) {
        	//logger.severe("Error updating soldier: " + e.getMessage());
        }
        return null;
	}

	@Override
	public void removeById(long id) {
        try(Connection con = getConnection()) {
            String sql = "DELETE FROM Army.soldiers WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)){
            ps.setLong(1, id);
            ps.executeUpdate();
        }} catch (SQLException e) {
        	//logger.severe("Error deleting soldier: " + e.getMessage());
        }
	}

}
