package sv.hawklibrary.com.connections;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


import sv.hawkframework.factorys.LoggerFactory;
import sv.hawkframework.loggers.Logger;
import sv.hawkframework.loggers.NoLogger;


public class MySqlConnection  implements DataBaseConnection,AutoCloseable{


	private static final Logger logger = LoggerFactory.getLogger(null, NoLogger.class);
	private static MySqlConnection mySqlConnection;
	private  Connection connectionMysql;
	
	private MySqlConnection() {
	}
	

	public static MySqlConnection getInstance() {
		
		
	  	if (mySqlConnection==null) { 	
	  		mySqlConnection = new MySqlConnection();
	  		
	  	}

  		try {
			if (mySqlConnection.getConnection() == null || mySqlConnection.getConnection().isClosed()) {
					mySqlConnection.openConnection();
				
			}
		} catch (SQLException e) {
		}
	  	
		return mySqlConnection;
	}

	@Override
	public void close() throws Exception {
		closeConnection();
		
	}
	
	
	private void openConnection() {

		try {

			String url ="jdbc:mysql://blhukvcuiurjxgkfeise-mysql.services.clever-cloud.com/blhukvcuiurjxgkfeise?user=uhafqkblamf2lqpl&password=A4B2zjc1T52toESVq6lf";
			this.connectionMysql = DriverManager.getConnection(url);
					
			
			logger.info("Conexion abierta" );
			
			
		} catch (SQLException e) {
			
			logger.error(e.getMessage());
			e.fillInStackTrace();
			return;
		}		
	}
	

	public void closeConnection() throws SQLException {
		 
       if(connectionMysql != null)
        connectionMysql.close();
	         
	}

	@Override
	public Boolean executeQuery(String query) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean executeCall(String query) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultSet readerCall(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet executeReader(String query) throws SQLException,NullPointerException {
		if (this.connectionMysql==null || this.connectionMysql.isClosed())
			this.openConnection();
		
		ResultSet rs = null;
		try {
			rs = this.connectionMysql.prepareStatement(query).executeQuery();
			
		}catch (SQLException ex) {
			this.connectionMysql.close();
			this.openConnection();
			rs = this.connectionMysql.prepareStatement(query).executeQuery();	
		}
		
		return rs;
	}


	@Override
	public Connection getConnection() throws SQLException {
	
		if (this.connectionMysql!=null && this.connectionMysql.isClosed()) {
			this.openConnection();
		}
		if (this.connectionMysql==null) {
			this.openConnection();
		}
		
		return this.connectionMysql;
      
	}


	






	

	
	

	
}
