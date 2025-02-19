package daos.myBatis;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import solvd.army.UnitMission;

public interface IUnitMissionDao extends IDao<UnitMission> {
    @Select("SELECT * FROM Army.unit_missions WHERE id = #{id}")
    UnitMission getById(long id);

    @Insert("INSERT INTO Army.unit_missions (missions_id, units_id) VALUES (#{mission.id}, #{unit.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(UnitMission entity);

    @Update("UPDATE Army.unit_missions SET missions_id = #{mission.id}, units_id = #{unit.id} WHERE id = #{id}")
    void update(UnitMission entity);

    @Delete("DELETE FROM Army.unit_missions WHERE id = #{id}")
    void removeById(long id);
    
    @Select("SELECT * FROM Army.unit_missions WHERE units_id = #{unitId}")
    List<UnitMission> getMissionsByUnitId(long unitId);
    
    @Delete("DELETE FROM Army.unit_missions WHERE units_id = #{unitId}")
    void deleteByUnitId(long unitId);
}
