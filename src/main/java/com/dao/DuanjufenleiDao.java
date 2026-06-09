package com.dao;

import com.entity.DuanjufenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DuanjufenleiVO;
import com.entity.view.DuanjufenleiView;


/**
 * 短剧分类
 * 
 * @author 
 * @email 
 * @date 2025-02-25 15:01:40
 */
public interface DuanjufenleiDao extends BaseMapper<DuanjufenleiEntity> {
	
	List<DuanjufenleiVO> selectListVO(@Param("ew") Wrapper<DuanjufenleiEntity> wrapper);
	
	DuanjufenleiVO selectVO(@Param("ew") Wrapper<DuanjufenleiEntity> wrapper);
	
	List<DuanjufenleiView> selectListView(@Param("ew") Wrapper<DuanjufenleiEntity> wrapper);

	List<DuanjufenleiView> selectListView(Pagination page,@Param("ew") Wrapper<DuanjufenleiEntity> wrapper);

	
	DuanjufenleiView selectView(@Param("ew") Wrapper<DuanjufenleiEntity> wrapper);
	

}
