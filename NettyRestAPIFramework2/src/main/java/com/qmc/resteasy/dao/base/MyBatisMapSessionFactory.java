package com.qmc.resteasy.dao.base;

import java.io.IOException;
import java.io.Reader;
import java.util.Hashtable;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.qmc.resteasy.common.Constant;
import com.qmc.resteasy.utils.StringUtil;


/**
 * @Description: MyBatisMapSessionFactory--自定义SqlSessionFactory的Factory
 * @author xiaoli 
 * @date 2015-9-1 下午6:40:51 
 * 
 */
public class MyBatisMapSessionFactory {
	private static Hashtable<String, SqlSessionFactory> ht = new Hashtable<String, SqlSessionFactory>();

	/**
	 * 解析SqlMapConfig.xml文件获得sqlMap句柄
	 * 
	 * @param configFile
	 * @return SqlSessionFactory
	 * @throws IOException
	 */
	public synchronized static SqlSessionFactory getSqlMapInstance(
			String configFile) throws IOException {
		if (StringUtil.isEmpty(configFile)) {
			configFile = Constant.DEFAULT_CONFIGURATION_FILE;
		}
		if (!ht.containsKey(configFile)) {
			Reader reader = Resources.getResourceAsReader(configFile);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
					.build(reader);
			reader.close();
			ht.put(configFile, sessionFactory);
		}
		return ht.get(configFile);
	}
}
