package com.zyz.empSys.service.impl;

import java.util.List;

import com.zyz.empSys.dao.IEmpDao;
import com.zyz.empSys.dao.impl.EmpDao;
import com.zyz.empSys.domain.Emp;
import com.zyz.empSys.service.IEmpService;

/**
 * 员工服务接口的实现类
 */
public class EmpService implements IEmpService {

	// 获取一个dao对象
	private IEmpDao dao = new EmpDao();
	
	@Override
	public Emp findEmpByName(String name) {
		
		return dao.findEmpByName(name);
	}

	@Override
	public void register(Emp emp) {
		dao.addEmp(emp);
	}

	@Override
	public Emp findEmpByNameAndPassword(String name, String password) {
		return dao.findEmpByNameAndPassword(name, password);
	}

	@Override
	public List<Emp> findAll() {
		return dao.findAll();
	}
	
	@Override
	public Emp findEmpById(Integer id) {
		return dao.findEmpById(id);
	}

	@Override
	public void updateEmpById(Integer id, Emp emp) {
		dao.updateEmpById(id,emp);
	}

	@Override
	public void deleteEmpById(Integer id) {
		dao.deleteEmpById(id);
	}

	@Override
	public List<Emp> searchEmpByCondition(String cname) {
		return dao.searchEmpByCondition(cname);
	}

}
