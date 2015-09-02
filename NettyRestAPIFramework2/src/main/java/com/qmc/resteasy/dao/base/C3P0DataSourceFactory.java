package com.qmc.resteasy.dao.base;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * @Description: C3P0DataSourceFactory
 * @author xiaoli 
 * @date 2015-9-1 下午6:41:03 
 * 
 */
public class C3P0DataSourceFactory extends UnpooledDataSourceFactory {

	/**
	 * 初始化dataSource
	 */
	public C3P0DataSourceFactory() {
		this.dataSource = new ComboPooledDataSource();
	}
}
