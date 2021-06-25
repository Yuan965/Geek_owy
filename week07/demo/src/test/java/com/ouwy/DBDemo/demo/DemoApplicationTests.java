package com.ouwy.DBDemo.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class DemoApplicationTests{

    @Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Test
	@Transactional
	void insertTest() {
		System.out.println("begin>>>>>");
    	long start=System.currentTimeMillis();
    	List list = new ArrayList<>();
		for(int i=0;i<100000;i++) {
			list.add(new Object[] {"aaa","123333"});
		}
		String sql = "insert into user(name,password) values (?,?)";
		jdbcTemplate.batchUpdate(sql, list);
		System.out.println("一共使用时间："+ (System.currentTimeMillis()-start) + " ms");
		System.out.println("end>>>>>");
	}
	
	@Test
	@Transactional
	void insertTest2() throws Exception{
		System.out.println("begin2>>>>>");
		long start=System.currentTimeMillis();
		String sql = "insert into user(name,password) values (?,?)";
		for(int i=0;i<100000;i++) {
			jdbcTemplate.update(sql, new Object[] {"aaaa","bbbbbbb"});
		}
		System.out.println("一共使用时间："+ (System.currentTimeMillis()-start) + " ms");
		System.out.println("end2>>>>>");
	}

}
