package daos.myBatis;

import org.apache.ibatis.session.SqlSession;
import solvd.army.Unit;
import solvd.MyBatisUtil;

public class UnitDao implements IUnitDao {

    @Override
    public Unit getById(long id) {
        try (SqlSession session = MyBatisUtil.getSessionFactory().openSession()) {
            IUnitDao mapper = session.getMapper(IUnitDao.class);
            return mapper.getById(id);
        }
    }

    @Override
    public void save(Unit entity) {
        try (SqlSession session = MyBatisUtil.getSessionFactory().openSession(true)) {
            IUnitDao mapper = session.getMapper(IUnitDao.class);
            mapper.save(entity);
        }
    }

    @Override
    public void update(Unit entity) {
        try (SqlSession session = MyBatisUtil.getSessionFactory().openSession(true)) {
            IUnitDao mapper = session.getMapper(IUnitDao.class);
            mapper.update(entity);
        }
    }

    @Override
    public void removeById(long id) {
        try (SqlSession session = MyBatisUtil.getSessionFactory().openSession(true)) {
            IUnitDao mapper = session.getMapper(IUnitDao.class);
            mapper.removeById(id);
        }
    }
}
