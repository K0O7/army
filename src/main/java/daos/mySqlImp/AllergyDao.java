package daos.mySqlImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import daos.IAllergyDao;
import solvd.army.Allergy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AllergyDao extends AbstractMySqlDao implements IAllergyDao {
	private static final Logger logger = LogManager.getLogger(AllergyDao.class);
    @Override
    public Allergy getById(long id) {
        try (Connection con = getConnection()) {
            String sql = "SELECT * FROM Army.allergies WHERE id=?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setLong(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    Allergy allergy = new Allergy();
                    if (rs.next()) {
                        allergy.setId(rs.getLong("id"));
                        allergy.setMedicalRecordId(rs.getLong("medical_record_id"));
                        allergy.setAllergen(rs.getString("allergen"));
                    }
                    return allergy;
                }
            }
        } catch (SQLException e) {
        	logger.error("Error retrieving allergy by ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Allergy save(Allergy entity) {
        try (Connection con = getConnection()) {
            String sql = "INSERT INTO Army.allergies (id, medical_record_id, allergen) VALUES (?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setLong(1, entity.getId());
                ps.setLong(2, entity.getMedicalRecordId());
                ps.setString(3, entity.getAllergen());
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    return entity;
                }
            }
        } catch (SQLException e) {
             logger.error("Error saving allergy: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Allergy update(Allergy entity) {
        try (Connection con = getConnection()) {
            String sql = "UPDATE Army.allergies SET medical_record_id = ?, allergen = ? WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setLong(1, entity.getMedicalRecordId());
                ps.setString(2, entity.getAllergen());
                ps.setLong(3, entity.getId());

                int rowsUpdated = ps.executeUpdate();
                if (rowsUpdated > 0) {
                    return entity;
                }
            }
        } catch (SQLException e) {
             logger.error("Error updating allergy: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void removeById(long id) {
        try (Connection con = getConnection()) {
            String sql = "DELETE FROM Army.allergies WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setLong(1, id);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
             logger.error("Error deleting allergy: " + e.getMessage());
        }
    }
}
