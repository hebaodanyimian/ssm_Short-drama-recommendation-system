package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DuanjuxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DuanjuxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DuanjuxinxiView;


/**
 * 短剧信息
 *
 * @author 
 * @email 
 * @date 2025-02-25 15:01:40
 */
public interface DuanjuxinxiService extends IService<DuanjuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DuanjuxinxiVO> selectListVO(Wrapper<DuanjuxinxiEntity> wrapper);
   	
   	DuanjuxinxiVO selectVO(@Param("ew") Wrapper<DuanjuxinxiEntity> wrapper);
   	
   	List<DuanjuxinxiView> selectListView(Wrapper<DuanjuxinxiEntity> wrapper);
   	
   	DuanjuxinxiView selectView(@Param("ew") Wrapper<DuanjuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DuanjuxinxiEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<DuanjuxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<DuanjuxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<DuanjuxinxiEntity> wrapper);



}

