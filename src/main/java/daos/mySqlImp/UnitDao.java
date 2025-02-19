package daos.mySqlImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import daos.IUnitDao;
import solvd.army.Unit;
import solvd.army.listeners.UnitListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UnitDao extends AbstractMySqlDao implements IUnitDao {
	private static final Logger logger = LogManager.getLogger(UnitDao.class);
    private final List<UnitListener> listeners = new ArrayList<>();

    public void addListener(UnitListener listener) {
        listeners.add(listener);
    }

    public void removeListener(UnitListener listener) {
        listeners.remove(listener);
    }

    private void notifyUnitCreated(Unit unit) {
        for (UnitListener listener : listeners) {
            listener.onUnitCreated(unit);
        }
    }

    private void notifyUnitUpdated(Unit unit) {
        for (UnitListener listener : listeners) {
            listener.onUnitUpdated(unit);
        }
    }

    private void notifyUnitDeleted(long id) {
        for (UnitListener listener : listeners) {
            listener.onUnitDeleted(id);
        }
    }
	
    @Override
    public Unit getById(long id) {
        try (Connection con = getConnection()) {
            String sql = "SELECT * FROM Army.units WHERE id=?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setLong(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                	Unit unit = new Unit();
                    if (rs.next()) {
                    	unit.setId(rs.getLong("id"));
                    	unit.setUnitName(rs.getString("unit_name"));
                    }
                    return unit;
                }
            }
        } catch (SQLException e) {
             logger.error("Error retrieving allergy by ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Unit save(Unit entity) {
        try (Connection con = getConnection()) {
            String sql = "INSERT INTO Army.units (id, unit_name) VALUES (?, ?)";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setLong(1, entity.getId());
                ps.setString(2, entity.getUnitName());
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                	notifyUnitCreated(entity);
                    return entity;
                }
            }
        } catch (SQLException e) {
             logger.error("Error saving allergy: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Unit update(Unit entity) {
        try (Connection con = getConnection()) {
            String sql = "UPDATE Army.units SET unit_name = ? WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, entity.getUnitName());
                ps.setLong(2, entity.getId());

                int rowsUpdated = ps.executeUpdate();
                if (rowsUpdated > 0) {
                	notifyUnitUpdated(entity);
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
            String sql = "DELETE FROM Army.units WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setLong(1, id);
                ps.executeUpdate();
                notifyUnitDeleted(id);
            }
        } catch (SQLException e) {
             logger.error("Error deleting allergy: " + e.getMessage());
        }
    }
}
