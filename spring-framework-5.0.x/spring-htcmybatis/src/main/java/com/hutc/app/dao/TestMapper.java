package com.hutc.app.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface TestMapper {

	@Select("SELECT * FROM t_s_role")
	public List<Map<String,String>> queryAll();
}
