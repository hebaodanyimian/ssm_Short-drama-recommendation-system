package com.dao;

import com.entity.DuanjuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DuanjuxinxiVO;
import com.entity.view.DuanjuxinxiView;


/**
 * 短剧信息
 * 
 * @author 
 * @email 
 * @date 2025-02-25 15:01:40
 */
public interface DuanjuxinxiDao extends BaseMapper<DuanjuxinxiEntity> {
	
	List<DuanjuxinxiVO> selectListVO(@Param("ew") Wrapper<DuanjuxinxiEntity> wrapper);
	
	DuanjuxinxiVO selectVO(@Param("ew") Wrapper<DuanjuxinxiEntity> wrapper);
	
	List<DuanjuxinxiView> selectListView(@Param("ew") Wrapper<DuanjuxinxiEntity> wrapper);

	List<DuanjuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DuanjuxinxiEntity> wrapper);

	
	DuanjuxinxiView selectView(@Param("ew") Wrapper<DuanjuxinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params")Map<String, Object> params,@Param("ew") Wrapper<DuanjuxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<DuanjuxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<DuanjuxinxiEntity> wrapper);



}
