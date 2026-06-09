package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DuanjufenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DuanjufenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DuanjufenleiView;


/**
 * 短剧分类
 *
 * @author 
 * @email 
 * @date 2025-02-25 15:01:40
 */
public interface DuanjufenleiService extends IService<DuanjufenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DuanjufenleiVO> selectListVO(Wrapper<DuanjufenleiEntity> wrapper);
   	
   	DuanjufenleiVO selectVO(@Param("ew") Wrapper<DuanjufenleiEntity> wrapper);
   	
   	List<DuanjufenleiView> selectListView(Wrapper<DuanjufenleiEntity> wrapper);
   	
   	DuanjufenleiView selectView(@Param("ew") Wrapper<DuanjufenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DuanjufenleiEntity> wrapper);

   	

}

