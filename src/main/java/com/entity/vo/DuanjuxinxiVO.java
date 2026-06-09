package com.entity.vo;

import com.entity.DuanjuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 短剧信息
 * @author 
 * @email 
 * @date 2025-02-25 15:01:40
 */
public class DuanjuxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 短剧分类
	 */
	
	private String duanjufenlei;
		
	/**
	 * 短剧图片
	 */
	
	private String duanjutupian;
		
	/**
	 * 观看人数
	 */
	
	private Integer guankanrenshu;
		
	/**
	 * 发布时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date fabushijian;
		
	/**
	 * 短剧简介
	 */
	
	private String duanjujianjie;
		
	/**
	 * 短剧详情
	 */
	
	private String duanjuxiangqing;
		
	/**
	 * 赞
	 */
	
	private Integer thumbsupnum;
		
	/**
	 * 踩
	 */
	
	private Integer crazilynum;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
		
	/**
	 * 评分
	 */
	
	private Double totalscore;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
	/**
	 * 设置：短剧分类
	 */
	 
	public void setDuanjufenlei(String duanjufenlei) {
		this.duanjufenlei = duanjufenlei;
	}
	
	/**
	 * 获取：短剧分类
	 */
	public String getDuanjufenlei() {
		return duanjufenlei;
	}
				
	
	/**
	 * 设置：短剧图片
	 */
	 
	public void setDuanjutupian(String duanjutupian) {
		this.duanjutupian = duanjutupian;
	}
	
	/**
	 * 获取：短剧图片
	 */
	public String getDuanjutupian() {
		return duanjutupian;
	}
				
	
	/**
	 * 设置：观看人数
	 */
	 
	public void setGuankanrenshu(Integer guankanrenshu) {
		this.guankanrenshu = guankanrenshu;
	}
	
	/**
	 * 获取：观看人数
	 */
	public Integer getGuankanrenshu() {
		return guankanrenshu;
	}
				
	
	/**
	 * 设置：发布时间
	 */
	 
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
				
	
	/**
	 * 设置：短剧简介
	 */
	 
	public void setDuanjujianjie(String duanjujianjie) {
		this.duanjujianjie = duanjujianjie;
	}
	
	/**
	 * 获取：短剧简介
	 */
	public String getDuanjujianjie() {
		return duanjujianjie;
	}
				
	
	/**
	 * 设置：短剧详情
	 */
	 
	public void setDuanjuxiangqing(String duanjuxiangqing) {
		this.duanjuxiangqing = duanjuxiangqing;
	}
	
	/**
	 * 获取：短剧详情
	 */
	public String getDuanjuxiangqing() {
		return duanjuxiangqing;
	}
				
	
	/**
	 * 设置：赞
	 */
	 
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
				
	
	/**
	 * 设置：踩
	 */
	 
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
				
	
	/**
	 * 设置：评分
	 */
	 
	public void setTotalscore(Double totalscore) {
		this.totalscore = totalscore;
	}
	
	/**
	 * 获取：评分
	 */
	public Double getTotalscore() {
		return totalscore;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}
