package daos.mySqlImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import daos.IRankDao;
import solvd.army.Rank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RankDao extends AbstractMySqlDao implements IRankDao {
	private static final Logger logger = LogManager.getLogger(RankDao.class);
    @Override
    public Rank getById(long id) {
        try (Connection con = getConnection()) {
            String sql = "SELECT * FROM Army.ranks WHERE id=?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setLong(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    Rank r = new Rank();
                    while (rs.next()) {
                        r.setId(rs.getLong("id"));
                        r.setRankName(rs.getString("rank_name"));
                        r.setSoldierId(rs.getLong("soldier_id"));
                    }
                    return r;
                }
            }
        } catch (SQLException e) {
             logger.error("Error selecting rank by id: " + e.getMessage());
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
             logger.error("Error saving rank: " + e.getMessage());
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
             logger.error("Error updating rank: " + e.getMessage());
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
             logger.error("Error deleting rank: " + e.getMessage());
        }
    }
}
