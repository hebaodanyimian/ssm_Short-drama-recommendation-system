package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussduanjuxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussduanjuxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussduanjuxinxiView;


/**
 * 短剧信息评论表
 *
 * @author 
 * @email 
 * @date 2025-02-25 15:01:42
 */
public interface DiscussduanjuxinxiService extends IService<DiscussduanjuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussduanjuxinxiVO> selectListVO(Wrapper<DiscussduanjuxinxiEntity> wrapper);
   	
   	DiscussduanjuxinxiVO selectVO(@Param("ew") Wrapper<DiscussduanjuxinxiEntity> wrapper);
   	
   	List<DiscussduanjuxinxiView> selectListView(Wrapper<DiscussduanjuxinxiEntity> wrapper);
   	
   	DiscussduanjuxinxiView selectView(@Param("ew") Wrapper<DiscussduanjuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussduanjuxinxiEntity> wrapper);

   	

}

