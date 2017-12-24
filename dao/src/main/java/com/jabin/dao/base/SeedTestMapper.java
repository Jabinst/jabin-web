package com.jabin.dao.base;

import com.jabin.domain.base.SeedTest;
import com.jabin.domain.base.SeedTestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SeedTestMapper {
    int countByExample(SeedTestExample example);

    int deleteByExample(SeedTestExample example);

    int insert(SeedTest record);

    int insertSelective(SeedTest record);

    List<SeedTest> selectByExampleWithRowbounds(SeedTestExample example, RowBounds rowBounds);

    List<SeedTest> selectByExample(SeedTestExample example);

    int updateByExampleSelective(@Param("record") SeedTest record, @Param("example") SeedTestExample example);

    int updateByExample(@Param("record") SeedTest record, @Param("example") SeedTestExample example);
}