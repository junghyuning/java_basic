package dbcp;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

public class Dbpc02_DataSourceApp {
	public static void main(String[] args) throws SQLException {
		PoolDataSource pds = PoolDataSourceFactory.getPoolDataSource();
		pds.setConnectionFactoryClassName("oracle.jdbc.driver.OracleDriver");
		
		pds.setURL("jdbc:oracle:thin:@localhost:1521:xe");
		
		pds.setUser("scott");
		
		pds.setPassword("tiger");
		
		pds.setInitialPoolSize(2);
		pds.setMaxPoolSize(3);
		
		Connection con1 = pds.getConnection();
		System.out.println("con1 = " + con1);
		con1.close();
		
		Connection con2 = pds.getConnection();
		System.out.println("con1 = " + con1);
		con2.close();
		
		Connection con3 = pds.getConnection();
		System.out.println("con1 = " + con1);
		con3.close();
		
//		Connection con4 = pds.getConnection();
//		System.out.println("con1 = " + con1);
//		con4.close();
	}
}
