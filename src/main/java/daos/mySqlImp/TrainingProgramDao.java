package daos.mySqlImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import daos.ITrainingProgramDao;
import solvd.army.TrainingProgram;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TrainingProgramDao extends AbstractMySqlDao implements ITrainingProgramDao {
	private static final Logger logger = LogManager.getLogger(TrainingProgramDao.class);
	
    @Override
    public TrainingProgram getById(long id) {
        try (Connection con = getConnection()) {
            String sql = "SELECT * FROM Army.training_program WHERE id=?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setLong(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    TrainingProgram program = new TrainingProgram();
                    if (rs.next()) {
                        program.setId(rs.getLong("id"));
                        program.setProgramName(rs.getString("program_name"));
                    }
                    return program;
                }
            }
        } catch (SQLException e) {
             logger.error("Error retrieving training program by ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public TrainingProgram save(TrainingProgram entity) {
        try (Connection con = getConnection()) {
            String sql = "INSERT INTO Army.training_program (id, program_name) VALUES (?, ?)";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setLong(1, entity.getId());
                ps.setString(2, entity.getProgramName());
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    return entity;
                }
            }
        } catch (SQLException e) {
             logger.error("Error saving training program: " + e.getMessage());
        }
        return null;
    }

    @Override
    public TrainingProgram update(TrainingProgram entity) {
        try (Connection con = getConnection()) {
            String sql = "UPDATE Army.training_program SET program_name = ? WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, entity.getProgramName());
                ps.setLong(2, entity.getId());

                int rowsUpdated = ps.executeUpdate();
                if (rowsUpdated > 0) {
                    return entity;
                }
            }
        } catch (SQLException e) {
             logger.error("Error updating training program: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void removeById(long id) {
        try (Connection con = getConnection()) {
            String sql = "DELETE FROM Army.training_program WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setLong(1, id);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
             logger.error("Error deleting training program: " + e.getMessage());
        }
    }
}
