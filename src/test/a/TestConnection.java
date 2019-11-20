package test.a;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.zyz.empSys.util.MyDBUtil;

public class TestConnection {
	@Test
	public void test1() throws SQLException {
		Connection connection=MyDBUtil.getConnection();
		System.out.println(connection);
		
		connection.close();
	}
	
	
}
