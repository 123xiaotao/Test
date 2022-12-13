package JDBC;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JDBCTemplate {
    public static  void  main(String args[]){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCutils.getDateSource());
        System.out.println("第一题的效果。。。。。。。。。。。。。");
//        String sql="insert into student values('s001','老大',20,'计算机学院'), ('s002','老二',19,'计算机学院'), ('s003','老三',18,'计算机学院'), ('s004','老四',17,'计算机学院')";
//        int a = jdbcTemplate.update(sql);
        new JDBCTemplate().print(jdbcTemplate);
        System.out.println("第二题的效果。。。。。。。。。。。。。");
        String sql2="delete from student where SNO=?";
        jdbcTemplate.update(sql2,"s004");
        new JDBCTemplate().print(jdbcTemplate);
        System.out.println("第三题的效果。。。。。。。。。。。。。");
        String sql3="select * from student where SNO=?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql3,"s003");
        Iterator<Map<String, Object>> iterator = maps.iterator();
        while ((iterator.hasNext())){
            Map<String, Object> next = iterator.next();
            Set<String> strings = next.keySet();
            for(String c:strings){
                System.out.print(next.get(c)+" ");
            }
            System.out.println();
        }
        System.out.println("第四题的效果。。。。。。。。。。。。。");
        String sql4="update student set Name='老大',Age=20,College='通信学院' where SNO=?";
        jdbcTemplate.update(sql4,"s001");
        new JDBCTemplate().print(jdbcTemplate);
    }
    //打印表
    void  print(JdbcTemplate jdbcTemplate){
        String sql1="select * from student";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql1);
        Iterator<Map<String, Object>> iterator = maps.iterator();
        while ((iterator.hasNext())){
            Map<String, Object> next = iterator.next();
            Set<String> strings = next.keySet();
            for(String c:strings){
                System.out.print(next.get(c)+" ");
            }
            System.out.println();
        }
    }
}
