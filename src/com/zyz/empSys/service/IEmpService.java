package com.zyz.empSys.service;

import java.util.List;

import com.zyz.empSys.domain.Emp;

/**
 * 员工服务接口
 */
public interface IEmpService {
	
	/**
	 * 根据用户名查找用户是否存在
	 * 
	 * @param name
	 * @return
	 */
	Emp findEmpByName(String name);

	  /**
	   *      注册员工
	   * 
	   * @param emp
	   */
	void register(Emp emp);

	/**
	 *    根据姓名和密码查询员工
	 * 
	 * @param name
	 * @param password
	 * @return
	 */
	Emp findEmpByNameAndPassword(String name, String password);
	
	/**
	 * 查询所有员工信息
	 */
	List<Emp> findAll();
	
	/**
	 * 根据id查找员工信息
	 * @param id
	 * @return
	 */
	Emp findEmpById(Integer id);
	
	/**
	 * 根据id修员工信息
	 * 
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
