package com.cjh;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
public class SessionFactoryUtil {
    //01.创建需要单例的静态对象
    private static SqlSessionFactory sessionFactory;

    //02.私有化构造
    private SessionFactoryUtil() {
    }

    //03.提供对外访问的接口
    public static synchronized SqlSession getSession() {
        try {
            //把xml文件读取到内存中 并且返回一个输入流对象
            InputStream stream = Resources.getResourceAsStream("mybatis.xml");
            if (sessionFactory == null) {
                //创建SqlSessionFactory
                sessionFactory = new SqlSessionFactoryBuilder().build(stream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return sessionFactory.openSession();
    }
}
