package daos.mySqlImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import daos.IMedicalRecordDao;
import solvd.army.MedicalRecord;

public class MedicalRecordDao extends AbstractMySqlDao implements IMedicalRecordDao {

    @Override
    public MedicalRecord getById(long id) {
        try (Connection con = getConnection()) {
            String sql = "SELECT * FROM Army.medical_records WHERE id=?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setLong(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    MedicalRecord medicalRecord = new MedicalRecord();
                    if (rs.next()) {
                        medicalRecord.setId(rs.getLong("id"));
                        medicalRecord.setSoldierId(rs.getLong("soldier_id"));
                        medicalRecord.setBloodType(rs.getString("blood_type"));
                        medicalRecord.setRh(rs.getString("rh"));
                    }
                    return medicalRecord;
                }
            }
        } catch (SQLException e) {
            // logger.severe("Error retrieving medical record by ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public MedicalRecord save(MedicalRecord entity) {
        try (Connection con = getConnection()) {
            String sql = "INSERT INTO Army.medical_records (id, soldier_id, blood_type, rh) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setLong(1, entity.getId());
                ps.setLong(2, entity.getSoldierId());
                ps.setString(3, entity.getBloodType());
                ps.setString(4, entity.getRh());
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    return entity;
                }
            }
        } catch (SQLException e) {
            // logger.severe("Error saving medical record: " + e.getMessage());
        }
        return null;
    }

    @Override
    public MedicalRecord update(MedicalRecord entity) {
        try (Connection con = getConnection()) {
            String sql = "UPDATE Army.medical_records SET soldier_id = ?, blood_type = ?, rh = ? WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setLong(1, entity.getSoldierId());
                ps.setString(2, entity.getBloodType());
                ps.setString(3, entity.getRh());
                ps.setLong(4, entity.getId());

                int rowsUpdated = ps.executeUpdate();
                if (rowsUpdated > 0) {
                    return entity;
                }
            }
        } catch (SQLException e) {
            // logger.severe("Error updating medical record: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void removeById(long id) {
        try (Connection con = getConnection()) {
            String sql = "DELETE FROM Army.medical_records WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setLong(1, id);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            // logger.severe("Error deleting medical record: " + e.getMessage());
        }
    }
}

