package daos.myBatis;
import org.apache.ibatis.annotations.*;

import solvd.army.Unit;

public interface IUnitDao extends IDao<Unit> {
    @Select("SELECT * FROM Army.units WHERE id = #{id}")
    Unit getById(long id);

    @Insert("INSERT INTO Army.units (unit_name) VALUES (#{unitName})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(Unit entity);

    @Update("UPDATE Army.units SET unit_name = #{unitName} WHERE id = #{id}")
    void update(Unit entity);

    @Delete("DELETE FROM Army.units WHERE id = #{id}")
    void removeById(long id);
}
