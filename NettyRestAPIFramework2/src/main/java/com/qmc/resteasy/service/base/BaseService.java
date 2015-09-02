/**
 * 
 */
package com.qmc.resteasy.service.base;

import java.util.List;

import com.qmc.resteasy.dao.base.AbstractDao;

/**
 * @Description: BaseService
 * @author xiaoli 
 * @date 2015-9-1 下午5:21:45 
 * 
 */
public abstract class BaseService {
	
	
	public abstract AbstractDao getEntityDao();
	
	public <T, T2> List<T> selectList(String sqlMapName, T2 t2) {
		return getEntityDao().selectList(sqlMapName, t2);
	}
	
	
	public <T, T2> T selectOne(String sqlMapName, T2 t2) {
		return getEntityDao().selectOne(sqlMapName, t2);
	}

}
