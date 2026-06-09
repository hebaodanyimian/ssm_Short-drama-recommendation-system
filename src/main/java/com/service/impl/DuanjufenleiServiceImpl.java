package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DuanjufenleiDao;
import com.entity.DuanjufenleiEntity;
import com.service.DuanjufenleiService;
import com.entity.vo.DuanjufenleiVO;
import com.entity.view.DuanjufenleiView;

@Service("duanjufenleiService")
public class DuanjufenleiServiceImpl extends ServiceImpl<DuanjufenleiDao, DuanjufenleiEntity> implements DuanjufenleiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DuanjufenleiEntity> page = this.selectPage(
                new Query<DuanjufenleiEntity>(params).getPage(),
                new EntityWrapper<DuanjufenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DuanjufenleiEntity> wrapper) {
		  Page<DuanjufenleiView> page =new Query<DuanjufenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DuanjufenleiVO> selectListVO(Wrapper<DuanjufenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DuanjufenleiVO selectVO(Wrapper<DuanjufenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DuanjufenleiView> selectListView(Wrapper<DuanjufenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DuanjufenleiView selectView(Wrapper<DuanjufenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
