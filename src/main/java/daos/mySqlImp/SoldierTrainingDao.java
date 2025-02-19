package daos.mySqlImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import daos.ISoldierTrainingDao;
import solvd.army.SoldierTraining;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SoldierTrainingDao extends AbstractMySqlDao implements ISoldierTrainingDao {
	private static final Logger logger = LogManager.getLogger(SoldierTrainingDao.class);
	
    @Override
    public SoldierTraining getById(long id) {
        try (Connection con = getConnection()) {
            String sql = "SELECT * FROM Army.soldier_training WHERE id=?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setLong(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    SoldierTraining training = new SoldierTraining();
                    if (rs.next()) {
                        training.setId(rs.getLong("id"));
                        training.setSoldierId(rs.getLong("soldier_id"));
                        training.setTrainingProgramsId(rs.getLong("training_programs_id"));
                        training.setStartDate(rs.getDate("start_date").toLocalDate());
                        training.setEndDate(rs.getDate("end_date").toLocalDate());
                    }
                    return training;
                }
            }
        } catch (SQLException e) {
             logger.error("Error retrieving soldier training by ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public SoldierTraining save(SoldierTraining entity) {
        try (Connection con = getConnection()) {
            String sql = "INSERT INTO Army.soldier_training (id, soldier_id, training_programs_id, start_date, end_date) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setLong(1, entity.getId());
                ps.setLong(2, entity.getSoldierId());
                ps.setLong(3, entity.getTrainingProgramsId());
                ps.setDate(4, Date.valueOf(entity.getStartDate()));
                ps.setDate(5, Date.valueOf(entity.getEndDate()));
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    return entity;
                }
            }
        } catch (SQLException e) {
             logger.error("Error saving soldier training: " + e.getMessage());
        }
        return null;
    }

    @Override
    public SoldierTraining update(SoldierTraining entity) {
        try (Connection con = getConnection()) {
            String sql = "UPDATE Army.soldier_training SET soldier_id = ?, training_programs_id = ?, start_date = ?, end_date = ? WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setLong(1, entity.getSoldierId());
                ps.setLong(2, entity.getTrainingProgramsId());
                ps.setDate(3, Date.valueOf(entity.getStartDate()));
                ps.setDate(4, Date.valueOf(entity.getEndDate()));
                ps.setLong(5, entity.getId());

                int rowsUpdated = ps.executeUpdate();
                if (rowsUpdated > 0) {
                    return entity;
                }
            }
        } catch (SQLException e) {
             logger.error("Error updating soldier training: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void removeById(long id) {
        try (Connection con = getConnection()) {
            String sql = "DELETE FROM Army.soldier_training WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setLong(1, id);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
             logger.error("Error deleting soldier training: " + e.getMessage());
        }
    }
}
