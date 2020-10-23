package curso.repositorio;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

public class BancoCurso {

	static Connection getConnection() {
		
		try {
			
			Driver drv = new com.mysql.cj.jdbc.Driver();
			Properties props = new Properties();
			props.put( "user", "root");
			props.put( "password", "Aa1010116!");
			return drv.connect( "jdbc:mysql://localhost/curso?useTimezone=true&serverTimezone=UTC", props);
		} catch (SQLException e) {
			
			throw new RuntimeException( e);
		}
	}
}
