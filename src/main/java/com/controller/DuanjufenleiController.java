package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DuanjufenleiEntity;
import com.entity.view.DuanjufenleiView;

import com.service.DuanjufenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;

/**
 * 短剧分类
 * 后端接口
 * @author 
 * @email 
 * @date 2025-02-25 15:01:40
 */
@RestController
@RequestMapping("/duanjufenlei")
public class DuanjufenleiController {
    @Autowired
    private DuanjufenleiService duanjufenleiService;









    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DuanjufenleiEntity duanjufenlei,
		HttpServletRequest request){

        //设置查询条件
        EntityWrapper<DuanjufenleiEntity> ew = new EntityWrapper<DuanjufenleiEntity>();


        //查询结果
		PageUtils page = duanjufenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, duanjufenlei), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }

    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DuanjufenleiEntity duanjufenlei,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DuanjufenleiEntity> ew = new EntityWrapper<DuanjufenleiEntity>();

        //查询结果
		PageUtils page = duanjufenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, duanjufenlei), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }


	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DuanjufenleiEntity duanjufenlei){
       	EntityWrapper<DuanjufenleiEntity> ew = new EntityWrapper<DuanjufenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( duanjufenlei, "duanjufenlei"));
        return R.ok().put("data", duanjufenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DuanjufenleiEntity duanjufenlei){
        EntityWrapper< DuanjufenleiEntity> ew = new EntityWrapper< DuanjufenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( duanjufenlei, "duanjufenlei"));
		DuanjufenleiView duanjufenleiView =  duanjufenleiService.selectView(ew);
		return R.ok("查询短剧分类成功").put("data", duanjufenleiView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DuanjufenleiEntity duanjufenlei = duanjufenleiService.selectById(id);
        duanjufenlei = duanjufenleiService.selectView(new EntityWrapper<DuanjufenleiEntity>().eq("id", id));
				Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(duanjufenlei,deSens);
        return R.ok().put("data", duanjufenlei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DuanjufenleiEntity duanjufenlei = duanjufenleiService.selectById(id);
        duanjufenlei = duanjufenleiService.selectView(new EntityWrapper<DuanjufenleiEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(duanjufenlei,deSens);
        return R.ok().put("data", duanjufenlei);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DuanjufenleiEntity duanjufenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(duanjufenlei);

        duanjufenleiService.insert(duanjufenlei);
        return R.ok().put("data",duanjufenlei.getId());
    }

    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DuanjufenleiEntity duanjufenlei, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(duanjufenlei);

        duanjufenleiService.insert(duanjufenlei);
        return R.ok().put("data",duanjufenlei.getId());
    }




    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DuanjufenleiEntity duanjufenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(duanjufenlei);
        //全部更新
        duanjufenleiService.updateById(duanjufenlei);
        return R.ok();
    }




    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        duanjufenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
