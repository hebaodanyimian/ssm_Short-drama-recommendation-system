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


import com.dao.DuanjuxinxiDao;
import com.entity.DuanjuxinxiEntity;
import com.service.DuanjuxinxiService;
import com.entity.vo.DuanjuxinxiVO;
import com.entity.view.DuanjuxinxiView;

@Service("duanjuxinxiService")
public class DuanjuxinxiServiceImpl extends ServiceImpl<DuanjuxinxiDao, DuanjuxinxiEntity> implements DuanjuxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DuanjuxinxiEntity> page = this.selectPage(
                new Query<DuanjuxinxiEntity>(params).getPage(),
                new EntityWrapper<DuanjuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DuanjuxinxiEntity> wrapper) {
		  Page<DuanjuxinxiView> page =new Query<DuanjuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DuanjuxinxiVO> selectListVO(Wrapper<DuanjuxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DuanjuxinxiVO selectVO(Wrapper<DuanjuxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DuanjuxinxiView> selectListView(Wrapper<DuanjuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DuanjuxinxiView selectView(Wrapper<DuanjuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<DuanjuxinxiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<DuanjuxinxiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<DuanjuxinxiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }



}
