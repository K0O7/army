package daos.mySqlImp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import daos.ISoldierDao;
import solvd.ConnectionPool;
import solvd.army.Soldier;

public class SoldierDao extends AbstractMySqlDao implements ISoldierDao {

	@Override
	public Soldier getById(long id) {
		try {
			Connection con = ConnectionPool.getConnection();
			String sql = "Select * from Soldiers where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(0, id);
			ResultSet rs = ps.executeQuery();
			Soldier s = new Soldier();
			while(rs.next()) {
				s.setId(rs.getLong("id"));
				s.setFirstName(rs.getString("FirstName"));
				s.setLastName(rs.getString("LastName"));
			return s;
			}
					
		} catch(Exception e) {
			
		}
		return null;
	}

	@Override
	public Soldier save(Soldier entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Soldier update(Soldier entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeById(long id) {
		// TODO Auto-generated method stub
		
	}

}
