package com.fangbo.spring.jdbc;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.fangbo.spring.jdbc.EmployeeDao.*;

public class JDBC_Bo {

    private ClassPathXmlApplicationContext cpx=null;
    private JdbcTemplate jdbcTemplate=null;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    {
        cpx=new ClassPathXmlApplicationContext("file:src/beans_jdbc.xml");
        jdbcTemplate= (JdbcTemplate) cpx.getBean("jdbcTemplate");
        NamedParameterJdbcTemplate namedParameterJdbcTemplate= cpx.getBean(NamedParameterJdbcTemplate.class);

    }
    @Test
    public void testconnection() throws SQLException {
       DataSource dataSource= (DataSource) cpx.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }
    @Test
        public void testUpdate(){
        String sql = "UPDATE employees SET last_name = ? WHERE id = ?";
        jdbcTemplate.update(sql, "Jack", 5);
    }
       @Test
    public void testEmployeeDao(){
        System.out.println(EmployeeDao.get(1));
    }
    @Test
        /**
     * 执行批量更新: 批量的 INSERT, UPDATE, DELETE
     * 最后一个参数是 Object[] 的 List 类型: 因为修改一条记录需要一个 Object 的数组, 那么多条不就需要多个 Object 的数组吗
     */
        public void testBatchUpdate(){
        String sql = "INSERT INTO employees(last_name, email, dept_id) VALUES(?,?,?)";

        List<Object[]> batchArgs = new ArrayList<Object[]>();

        batchArgs.add(new Object[]{"AA", "aa@atguigu.com", 1});
        batchArgs.add(new Object[]{"BB", "bb@atguigu.com", 2});
        batchArgs.add(new Object[]{"CC", "cc@atguigu.com", 3});
        batchArgs.add(new Object[]{"DD", "dd@atguigu.com", 3});
        batchArgs.add(new Object[]{"EE", "ee@atguigu.com", 2});

        jdbcTemplate.batchUpdate(sql, batchArgs);
}


        /**
     * 从数据库中获取一条记录, 实际得到对应的一个对象
     * 注意不是调用 queryForObject(String sql, Class<Employee> requiredType, Object... args) 方法!
     * 而需要调用 queryForObject(String sql, RowMapper<Employee> rowMapper, Object... args)
     * 1. 其中的 RowMapper 指定如何去映射结果集的行, 常用的实现类为 BeanPropertyRowMapper
     * 2. 使用 SQL 中列的别名完成列名和类的属性名的映射. 例如 last_name lastName
     * 3. 不支持级联属性. JdbcTemplate 到底是一个 JDBC 的小工具, 而不是 ORM 框架
     */
        @Test
    public void testQueryForObject(){
        String sql = "SELECT id, last_name lastName, email, dept_id as \"department.id\" FROM employees WHERE id = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
        Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 1);

        System.out.println(employee);
    }
    /**
     * 查到实体类的集合
     * 注意调用的不是 queryForList 方法
     */
    @Test
    public void testQueryForList(){
        String sql = "SELECT id, last_name lastName, email FROM employees WHERE id > ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
        List<Employee> employees = jdbcTemplate.query(sql, rowMapper,5);

        System.out.println(employees);
    }

    //    /**
//     * 使用具名参数时, 可以使用 update(String sql, SqlParameterSource paramSource) 方法进行更新操作
//     * 1. SQL 语句中的参数名和类的属性一致!
//     * 2. 使用 SqlParameterSource 的 BeanPropertySqlParameterSource 实现类作为参数.
//     */
//    具名参数
    @Test
    public void testNamedParameterJdbcTemplate2(){
        String sql = "INSERT INTO employees(last_name, email, dept_id) "
                + "VALUES(:lastName,:email,:dpetId)";

        Employee employee = new Employee();
        employee.setLastName("XYZ");
        employee.setEmail("xyz@sina.com");
        employee.setDpetId(3);

        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(employee);
        namedParameterJdbcTemplate.update(sql, paramSource);
    }

        @Test
    public void testNamedParameterJdbcTemplate(){
        String sql = "INSERT INTO employees(last_name, email, dept_id) VALUES(:ln,:email,:deptid)";

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("ln", "FF");
        paramMap.put("email", "ff@atguigu.com");
        paramMap.put("deptid", 2);

        namedParameterJdbcTemplate.update(sql, paramMap);
    }

}

