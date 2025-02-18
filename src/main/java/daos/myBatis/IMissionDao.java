package daos.myBatis;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import solvd.army.Mission;

public interface IMissionDao extends IDao<Mission> {
    @Select("SELECT * FROM Army.missions WHERE id = #{id}")
    Mission getById(long id);

    @Insert("INSERT INTO Army.missions (mission_name, mission_date, location) VALUES (#{missionName}, #{missionDate}, #{location})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(Mission entity);

    @Update(" UPDATE Army.missions SET mission_name = #{missionName}, mission_date = #{missionDate}, location = #{location} WHERE id = #{id}")
    void update(Mission entity);

    @Delete("DELETE FROM Army.missions WHERE id = #{id}")
    void removeById(long id);
}
