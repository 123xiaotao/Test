package com.xiaobai;

import com.xiaobai.dao.AccountDao;
import com.xiaobai.pojo.Account;
import com.xiaobai.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AccountTest {
    @Test//查询所有记录
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        List<Account> all = mapper.findAll();
        for (Account account : all) {
            System.out.println(account);
            System.out.println("894");
        }
        sqlSession.close();
    }
    @Test//通过id删除
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        Scanner scanner=new Scanner(System.in);
        System.out.println("想要删除id：");
        mapper.deleteById(scanner.nextLine());
        sqlSession.commit();
        sqlSession.close();
    }
    @Test//插入记录
    public void test3(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        mapper.insert(new Account("222","小晓",1000,new Date(1000*60*60),new Date()));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test//通过id查找对象
    public void test4(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        Account account = mapper.selectById("111");
        System.out.println(account);
        sqlSession.close();
    }
    @Test//更新
    public void test5(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        int 小晓 = mapper.update(new Account("222", "小晓", 1000, new Date(), new Date()));
        System.out.println(小晓);
        sqlSession.commit();
        sqlSession.close();
    }
}
