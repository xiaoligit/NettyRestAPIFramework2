package com.qmc.resteasy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import com.qmc.resteasy.controller.HomeController;
import com.qmc.resteasy.server.NettyServer;

public class Main {

	public static void main(String[] args)
			throws Exception {

		ApplicationContext ac = new ClassPathXmlApplicationContext("root-context.xml");
		Assert.notNull(ac);
		Assert.notNull(ac.getBean(HomeController.class));

		NettyServer netty = ac.getBean(NettyServer.class);

		netty.start();

	}
}
