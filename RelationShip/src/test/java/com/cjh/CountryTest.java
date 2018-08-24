package com.cjh;

import com.cjh.dao.CountryMapper;

import com.cjh.pojo.Country;
import com.cjh.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CountryTest {
    static SqlSession session=null;
    static CountryMapper mapper=null;
    /**
     * 获取session 和 mapper赋值
     */
    @Before
    public  void before(){
        session= SessionFactoryUtil.getSession();
        mapper=session.getMapper(CountryMapper.class);
    }
    /**
     * 数据真正上传到数据库 和 关闭mapper
     */
    @After
    public  void after(){
        session.commit();
        session.close();
    }
    @Test
    public void  selectProvincial(){
        Country country = mapper.selectProvincial(1);
        System.out.println(country.getcId());
        System.out.println(country.getProvincials());

    }
}

