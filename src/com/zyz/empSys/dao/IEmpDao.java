package com.zyz.empSys.dao;

import java.util.List;

import com.zyz.empSys.domain.Emp;

/**
 * 员工DAO接口
 */
public interface IEmpDao {

	/**
	 * 根据员工姓名查找员工是否存在
	 * 
	 * @param name
	 * @return
	 */
	Emp findEmpByName(String name);

	/**
	 * 向数据库中添加员工
	 * 
	 * @param emp
	 */
	void addEmp(Emp emp);

	/**
	 * 根据姓名和密码查找员工
	 * 
	 * @param name
	 * @param password
	 * @return
	 */
	Emp findEmpByNameAndPassword(String name, String password);
	
	/**
	 * 查询所有员工信息
	 * 
	 * @return
	 */
	List<Emp> findAll();
	
	/**
	 * 根据id查询员工信息
	 * 
	 * @param id
	 * @return
	 */
	Emp findEmpById(Integer id);
	
	/**
	 * 根据id修改员工信息
	 * @param id
	 * @param emp
	 */
	void updateEmpById(Integer id, Emp emp);

	/**
	 * 根据id删除员工
	 * 
	 * @param id
	 */
	void deleteEmpById(Integer id);
	
	/**
	 * 根据条件查询符合条件的员工
	 * @param cname
	 * @return
	 */
	List<Emp> searchEmpByCondition(String cname);


}
