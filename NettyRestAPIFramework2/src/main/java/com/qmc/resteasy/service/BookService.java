/**
 * 
 */
package com.qmc.resteasy.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.qmc.resteasy.dao.BookDao;
import com.qmc.resteasy.dao.base.AbstractDao;
import com.qmc.resteasy.model.Book;
import com.qmc.resteasy.service.base.BaseService;

/**
 * @Description: TODO
 * @author xiaoli
 * @date 2015-9-1 下午5:18:35
 * 
 */
@Service
public class BookService extends BaseService {

	protected static final Log logger = LogFactory.getLog(BookService.class);

	@Resource
	BookDao bookDao;

	@Override
	public AbstractDao getEntityDao() {
		return bookDao;
	}

	/**
	 * 返回单个Book
	 * 
	 * @param id
	 * @return Book
	 */
	public Book getBookById(int id) {
		return bookDao.getBookById(id);
	}

	/**
	 * 返回数据列表
	 * 
	 * @param start
	 * @param limit
	 * @return List<Book>
	 */
	public List<Book> getBookList(int start, int limit) {
		return bookDao.getBookList(start, limit);
	}

	/**
	 * 演示MyBatis插入数据(对Author的新增数据就写在这里面～～演示而已)
	 * 
	 * @param authorStr
	 * @return Map<String, Object>
	 */
	public Map<String, Object> addAuthor(String authorStr) {

		return bookDao.addAuthor(authorStr);
	}

}
