package daos.mySqlImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import daos.IRankDao;
import solvd.army.Rank;

public class RankDao extends AbstractMySqlDao implements IRankDao {

    @Override
    public Rank getById(long id) {
        try (Connection con = getConnection()) {
            String sql = "SELECT * FROM Army.ranks WHERE id=?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setLong(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    Rank r = new Rank(); // Using empty constructor
                    while (rs.next()) {
                        r.setId(rs.getLong("id"));
                        r.setRankName(rs.getString("rank_name"));
                        r.setSoldierId(rs.getLong("soldier_id")); // Only setting soldier_id, not Soldier object
                    }
                    return r;
                }
            }
        } catch (SQLException e) {
            // logger.severe("Error selecting rank by id: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Rank save(Rank entity) {
        try (Connection con = getConnection()) {
            String sql = "INSERT INTO Army.ranks (id, rank_name, soldier_id) VALUES (?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setLong(1, entity.getId());
                ps.setString(2, entity.getRankName());
                ps.setLong(3, entity.getSoldierId());
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    return entity;
                }
            }
        } catch (SQLException e) {
            // logger.severe("Error saving rank: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Rank update(Rank entity) {
        try (Connection con = getConnection()) {
            String sql = "UPDATE Army.ranks SET rank_name = ?, soldier_id = ? WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, entity.getRankName());
                ps.setLong(2, entity.getSoldierId());
                ps.setLong(3, entity.getId());
                int rowsUpdated = ps.executeUpdate();
                if (rowsUpdated > 0) {
                    return entity;
                }
            }
        } catch (SQLException e) {
            // logger.severe("Error updating rank: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void removeById(long id) {
        try (Connection con = getConnection()) {
            String sql = "DELETE FROM Army.ranks WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setLong(1, id);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            // logger.severe("Error deleting rank: " + e.getMessage());
        }
    }
}
