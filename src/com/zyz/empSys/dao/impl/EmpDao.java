package com.zyz.empSys.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zyz.empSys.dao.IEmpDao;
import com.zyz.empSys.domain.Emp;
import com.zyz.empSys.util.MyDBUtil;


/**
 * 员工DAO接口的实现类
 */
public class EmpDao implements IEmpDao {
	// 获取到链接对象
	Connection connection = MyDBUtil.getConnection();

	@Override
	public Emp findEmpByName(String name) {

		String sql = "select * from emp where name=?";

		QueryRunner runner = new QueryRunner();

		try {
			return runner.query(connection, sql, new BeanHandler<Emp>(Emp.class), name);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void addEmp(Emp emp) {
		String sql = "insert into emp values(null, ?,?,?,?,?,?,?,?);";

		QueryRunner runner = new QueryRunner();

		try {
			runner.update(connection, sql, new Object[] { emp.getName(), emp.getPassword(), emp.getGender(),
					emp.getAge(), emp.getHiredate(), emp.getSalary(), emp.getPhone(), emp.getEmail() });
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Emp findEmpByNameAndPassword(String name, String password) {

		String sql = "select * from emp where name=? and password = ?";

		QueryRunner runner = new QueryRunner();

		try {
			return runner.query(connection, sql, new BeanHandler<Emp>(Emp.class), new Object[] { name, password });
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Emp> findAll() {
		String sql = "select * from emp";

		QueryRunner runner = new QueryRunner();

		try {
			return runner.query(connection, sql, new BeanListHandler<Emp>(Emp.class));
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Emp findEmpById(Integer id) {

		String sql = "select * from emp where id=?";

		QueryRunner runner = new QueryRunner();

		try {
			return runner.query(connection, sql, new BeanHandler<Emp>(Emp.class), id);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void updateEmpById(Integer id, Emp emp) {
		String sql = "update emp set name=?,password=?,gender=?,age=?,hiredate=?,salary=?,phone=?,email=? where id="
				+ id;
		QueryRunner runner = new QueryRunner();

		try {
			runner.update(connection, sql, new Object[] { emp.getName(), emp.getPassword(), emp.getGender(),
					emp.getAge(), emp.getHiredate(), emp.getSalary(), emp.getPhone(), emp.getEmail() });
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void deleteEmpById(Integer id) {
		String sql = "delete from emp where id=?";

		QueryRunner runner = new QueryRunner();

		try {
			runner.update(connection, sql, id);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public List<Emp> searchEmpByCondition(String cname) {

		cname = "%" + cname + "%";
		String sql = "select * from emp where id like? or name like?  or gender like? or age like? or salary like? or phone like? or email like?";

		QueryRunner runner = new QueryRunner();

		try {
			return runner.query(connection, sql, new BeanListHandler<Emp>(Emp.class), new Object[] {cname,cname,cname,cname,cname,cname,cname});
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
