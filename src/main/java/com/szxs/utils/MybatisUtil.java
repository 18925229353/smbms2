package com.szxs.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MybatisUtil {
    private static SqlSessionFactory sessionFactory=null;
  static {
      //加载mybatis.xml配置文件
      Reader reader= null;
      try {
          reader = Resources.getResourceAsReader("mybatis.xml");
      } catch (IOException e) {
          e.printStackTrace();
      }
      SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
      //通过文件流获取会话工厂
      sessionFactory=builder.build(reader);
    }
    public static SqlSession openSession(){
      return sessionFactory.openSession(true);
    }
}
