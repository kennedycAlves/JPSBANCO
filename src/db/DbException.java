package db;

import java.sql.SQLException;

public class DbException  extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public DbException(String msg) {
		super(msg);
	}

	

}
