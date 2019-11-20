package test.a;

import org.junit.jupiter.api.Test;

import com.zyz.empSys.dao.impl.EmpDao;
import com.zyz.empSys.util.MyDBUtil;

public class TestDao {
	EmpDao dao = new EmpDao();
	
	@Test
	public void test1() {
		System.out.println(MyDBUtil.getConnection());
	}
}
