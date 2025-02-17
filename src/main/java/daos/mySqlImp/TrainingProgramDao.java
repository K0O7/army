package daos.mySqlImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import daos.ITrainingProgramDao;
import solvd.army.TrainingProgram;

public class TrainingProgramDao extends AbstractMySqlDao implements ITrainingProgramDao {

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
            // logger.severe("Error retrieving training program by ID: " + e.getMessage());
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
            // logger.severe("Error saving training program: " + e.getMessage());
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
            // logger.severe("Error updating training program: " + e.getMessage());
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
            // logger.severe("Error deleting training program: " + e.getMessage());
        }
    }
}
