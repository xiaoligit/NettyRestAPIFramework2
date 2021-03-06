package com.qmc.resteasy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.resteasy.annotations.GZIP;
import org.springframework.stereotype.Controller;

import com.qmc.resteasy.model.Book;
import com.qmc.resteasy.service.BookService;


/**
 * @Description: 模板实例，关于Book的API操作
 * @author xiaoli 
 * @date 2015-9-1 下午5:01:45 
 * 
 */
@Controller
@Path("/ws/demo/book/")
public class BookController {
	
	@Resource
	BookService bookService;
	
	private static final Log logger = LogFactory
			.getLog(BookController.class);

	@GET
	@Path("{id}")
	@Produces("application/json;charset=utf8")
	@GZIP
	public Book getBook(@PathParam("id") int id) {
		logger.info("getDetail->id "+id);
		return bookService.getBookById(id);
	}
	
	@GET
	@Path("detail")
	@Produces("application/json;charset=utf8")
	@GZIP
	public Book getDetail(@QueryParam("id") int id) {
		logger.info("getDetail->id "+id);
		return bookService.getBookById(id);
	}
	
	@GET
	@Path("list")
	@Produces("application/json;charset=utf8")
	@GZIP
	public Map<String,Object> getBookList(@QueryParam("start") int start, @QueryParam("limit") int limit) {
		logger.info("getBookList->start="+start+";limit="+limit);
		Map<String,Object> result = new HashMap<String, Object>();
		List<Book> bookList = bookService.getBookList(start, limit);
		result.put("total", bookList.size());
		result.put("rows", bookList);
		return result;
	}
	
	@POST
	@Path("saveAuthor")
	@Produces("application/json;charset=utf8")
	@GZIP
	public Map<String,Object> saveAuthor(@FormParam("author") String author) {
		logger.info("saveAuthor->author "+author);
		return bookService.addAuthor(author);
	}
	
}
