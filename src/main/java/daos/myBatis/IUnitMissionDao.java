package daos.myBatis;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import solvd.army.UnitMission;

public interface IUnitMissionDao extends IDao<UnitMission> {
    @Select("SELECT * FROM Army.unit_missions WHERE id = #{id}")
    UnitMission getById(long id);

    @Insert("INSERT INTO Army.unit_missions (mission_id, unit_id) VALUES (#{mission.id}, #{unit.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(UnitMission entity);

    @Update("UPDATE Army.unit_missions SET mission_id = #{mission.id}, unit_id = #{unit.id} WHERE id = #{id}")
    void update(UnitMission entity);

    @Delete("DELETE FROM Army.unit_missions WHERE id = #{id}")
    void removeById(long id);
}
