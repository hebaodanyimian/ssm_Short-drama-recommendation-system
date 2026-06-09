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

import com.entity.DiscussduanjuxinxiEntity;
import com.entity.view.DiscussduanjuxinxiView;

import com.service.DiscussduanjuxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;

/**
 * 短剧信息评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2025-02-25 15:01:42
 */
@RestController
@RequestMapping("/discussduanjuxinxi")
public class DiscussduanjuxinxiController {
    @Autowired
    private DiscussduanjuxinxiService discussduanjuxinxiService;









    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussduanjuxinxiEntity discussduanjuxinxi,
		HttpServletRequest request){

        //设置查询条件
        EntityWrapper<DiscussduanjuxinxiEntity> ew = new EntityWrapper<DiscussduanjuxinxiEntity>();


        //查询结果
		PageUtils page = discussduanjuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussduanjuxinxi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,DiscussduanjuxinxiEntity discussduanjuxinxi,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DiscussduanjuxinxiEntity> ew = new EntityWrapper<DiscussduanjuxinxiEntity>();

        //查询结果
		PageUtils page = discussduanjuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussduanjuxinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }


	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussduanjuxinxiEntity discussduanjuxinxi){
       	EntityWrapper<DiscussduanjuxinxiEntity> ew = new EntityWrapper<DiscussduanjuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussduanjuxinxi, "discussduanjuxinxi"));
        return R.ok().put("data", discussduanjuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussduanjuxinxiEntity discussduanjuxinxi){
        EntityWrapper< DiscussduanjuxinxiEntity> ew = new EntityWrapper< DiscussduanjuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussduanjuxinxi, "discussduanjuxinxi"));
		DiscussduanjuxinxiView discussduanjuxinxiView =  discussduanjuxinxiService.selectView(ew);
		return R.ok("查询短剧信息评论表成功").put("data", discussduanjuxinxiView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussduanjuxinxiEntity discussduanjuxinxi = discussduanjuxinxiService.selectById(id);
        discussduanjuxinxi = discussduanjuxinxiService.selectView(new EntityWrapper<DiscussduanjuxinxiEntity>().eq("id", id));
				Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(discussduanjuxinxi,deSens);
        return R.ok().put("data", discussduanjuxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussduanjuxinxiEntity discussduanjuxinxi = discussduanjuxinxiService.selectById(id);
        discussduanjuxinxi = discussduanjuxinxiService.selectView(new EntityWrapper<DiscussduanjuxinxiEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(discussduanjuxinxi,deSens);
        return R.ok().put("data", discussduanjuxinxi);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussduanjuxinxiEntity discussduanjuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussduanjuxinxi);

        discussduanjuxinxiService.insert(discussduanjuxinxi);
        return R.ok().put("data",discussduanjuxinxi.getId());
    }

    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussduanjuxinxiEntity discussduanjuxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discussduanjuxinxi);

        discussduanjuxinxiService.insert(discussduanjuxinxi);
        return R.ok().put("data",discussduanjuxinxi.getId());
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussduanjuxinxiEntity discussduanjuxinxi = discussduanjuxinxiService.selectOne(new EntityWrapper<DiscussduanjuxinxiEntity>().eq("", username));
        return R.ok().put("data", discussduanjuxinxi);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussduanjuxinxiEntity discussduanjuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussduanjuxinxi);
        //全部更新
        discussduanjuxinxiService.updateById(discussduanjuxinxi);
        return R.ok();
    }




    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussduanjuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussduanjuxinxiEntity discussduanjuxinxi, HttpServletRequest request,String pre){
        EntityWrapper<DiscussduanjuxinxiEntity> ew = new EntityWrapper<DiscussduanjuxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        // 组装参数
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");

        params.put("order", "desc");
		PageUtils page = discussduanjuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussduanjuxinxi), params), params));
        return R.ok().put("data", page);
    }









}
