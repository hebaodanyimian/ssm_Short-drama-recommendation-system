package com.dao;

import com.entity.DiscussduanjuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussduanjuxinxiVO;
import com.entity.view.DiscussduanjuxinxiView;


/**
 * 短剧信息评论表
 * 
 * @author 
 * @email 
 * @date 2025-02-25 15:01:42
 */
public interface DiscussduanjuxinxiDao extends BaseMapper<DiscussduanjuxinxiEntity> {
	
	List<DiscussduanjuxinxiVO> selectListVO(@Param("ew") Wrapper<DiscussduanjuxinxiEntity> wrapper);
	
	DiscussduanjuxinxiVO selectVO(@Param("ew") Wrapper<DiscussduanjuxinxiEntity> wrapper);
	
	List<DiscussduanjuxinxiView> selectListView(@Param("ew") Wrapper<DiscussduanjuxinxiEntity> wrapper);

	List<DiscussduanjuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussduanjuxinxiEntity> wrapper);

	
	DiscussduanjuxinxiView selectView(@Param("ew") Wrapper<DiscussduanjuxinxiEntity> wrapper);
	

}
