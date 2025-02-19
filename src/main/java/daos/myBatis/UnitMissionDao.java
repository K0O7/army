package daos.myBatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import solvd.MyBatisUtil;
import solvd.army.UnitMission;

public class UnitMissionDao implements IUnitMissionDao {
    @Override
    public UnitMission getById(long id) {
        try (SqlSession session = MyBatisUtil.getSessionFactory().openSession()) {
        	IUnitMissionDao mapper = session.getMapper(IUnitMissionDao.class);
            return mapper.getById(id);
        }
    }

    @Override
    public void save(UnitMission entity) {
        try (SqlSession session = MyBatisUtil.getSessionFactory().openSession(true)) {
        	IUnitMissionDao mapper = session.getMapper(IUnitMissionDao.class);
            mapper.save(entity);
        }
    }

    @Override
    public void update(UnitMission entity) {
        try (SqlSession session = MyBatisUtil.getSessionFactory().openSession(true)) {
        	IUnitMissionDao mapper = session.getMapper(IUnitMissionDao.class);
            mapper.update(entity);
        }
    }

    @Override
    public void removeById(long id) {
        try (SqlSession session = MyBatisUtil.getSessionFactory().openSession(true)) {
        	IUnitMissionDao mapper = session.getMapper(IUnitMissionDao.class);
            mapper.removeById(id);
        }
    }

	@Override
	public List<UnitMission> getMissionsByUnitId(long unitId) {
        try (SqlSession session = MyBatisUtil.getSessionFactory().openSession()) {
        	IUnitMissionDao mapper = session.getMapper(IUnitMissionDao.class);
        	return mapper.getMissionsByUnitId(unitId);
            //return session.selectList("daos.myBatis.IUnitMissionDao.getMissionsByUnitId", unitId);
        }
	}

	@Override
	public void deleteByUnitId(long unitId) {
        try (SqlSession session = MyBatisUtil.getSessionFactory().openSession(true)) {
        	IUnitMissionDao mapper = session.getMapper(IUnitMissionDao.class);
            mapper.deleteByUnitId(unitId);
            //session.delete("daos.myBatis.IUnitMissionDao.deleteByUnitId", unitId);
        }
	}
}
