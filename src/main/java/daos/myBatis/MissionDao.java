package daos.myBatis;

import org.apache.ibatis.session.SqlSession;

import solvd.MyBatisUtil;
import solvd.army.Mission;

public class MissionDao implements IMissionDao {
    @Override
    public Mission getById(long id) {
        try (SqlSession session = MyBatisUtil.getSessionFactory().openSession()) {
        	IMissionDao mapper = session.getMapper(IMissionDao.class);
            return mapper.getById(id);
        }
    }

    @Override
    public void save(Mission entity) {
        try (SqlSession session = MyBatisUtil.getSessionFactory().openSession(true)) {
        	IMissionDao mapper = session.getMapper(IMissionDao.class);
            mapper.save(entity);
        }
    }

    @Override
    public void update(Mission entity) {
        try (SqlSession session = MyBatisUtil.getSessionFactory().openSession(true)) {
        	IMissionDao mapper = session.getMapper(IMissionDao.class);
            mapper.update(entity);
        }
    }

    @Override
    public void removeById(long id) {
        try (SqlSession session = MyBatisUtil.getSessionFactory().openSession(true)) {
        	IMissionDao mapper = session.getMapper(IMissionDao.class);
            mapper.removeById(id);
        }
    }
}
