package dac.bookshop.daos;

import java.sql.ResultSet;

import com.bookshop.pojos.Login;

public class LoginDao extends Dao {
	public Login findLogin(String user) throws Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT USERNAME,PASSWORD FROM LOGIN WHERE USERNAME=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, user);
			rs = stmt.executeQuery();
			if(rs.next()) {
				Login lg = new Login();
				lg.setUser(rs.getString("USERNAME"));
				lg.setPass(rs.getString("PASSWORD"));
				return lg;
			}
		} finally {
			if(rs!=null)
				rs.close();
			if(stmt!=null)
				stmt.close();
		}
		return null;
	}
}	
