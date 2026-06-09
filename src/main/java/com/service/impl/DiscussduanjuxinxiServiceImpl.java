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


import com.dao.DiscussduanjuxinxiDao;
import com.entity.DiscussduanjuxinxiEntity;
import com.service.DiscussduanjuxinxiService;
import com.entity.vo.DiscussduanjuxinxiVO;
import com.entity.view.DiscussduanjuxinxiView;

@Service("discussduanjuxinxiService")
public class DiscussduanjuxinxiServiceImpl extends ServiceImpl<DiscussduanjuxinxiDao, DiscussduanjuxinxiEntity> implements DiscussduanjuxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussduanjuxinxiEntity> page = this.selectPage(
                new Query<DiscussduanjuxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussduanjuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussduanjuxinxiEntity> wrapper) {
		  Page<DiscussduanjuxinxiView> page =new Query<DiscussduanjuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussduanjuxinxiVO> selectListVO(Wrapper<DiscussduanjuxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussduanjuxinxiVO selectVO(Wrapper<DiscussduanjuxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussduanjuxinxiView> selectListView(Wrapper<DiscussduanjuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussduanjuxinxiView selectView(Wrapper<DiscussduanjuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
