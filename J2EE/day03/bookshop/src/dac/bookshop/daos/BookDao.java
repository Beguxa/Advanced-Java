package dac.bookshop.daos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bookshop.pojos.Book;

public class BookDao extends Dao {
	public Book findBook(int id) throws Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT ID,NAME,AUTHOR,SUBJECT,PRICE FROM BOOKS WHERE ID=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				Book b = new Book();
				b.setId(rs.getInt("ID"));
				b.setName(rs.getString("NAME"));
				b.setAuthor(rs.getString("AUTHOR"));
				b.setSubject(rs.getString("SUBJECT"));
				b.setPrice(rs.getDouble("PRICE"));
				return b;
			}
		}finally{
			if(rs!=null)
				rs.close();
			if(stmt!=null)
				stmt.close();
		}
		return null;
	}
	public List<String> getSubjectList() throws Exception {
		String sql = "SELECT DISTINCT SUBJECT FROM BOOKS";
		ResultSet rs = null;
		List<String> list = new ArrayList<>();
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("SUBJECT"));
			}
		} finally {
			if(rs!=null)
				rs.close();
			if(stmt!=null)
				stmt.close();
		}
		return list;
	}
	public List<Book> getBooks(String subject) throws Exception {
		ResultSet rs = null;
		List<Book> list = new ArrayList<>();
		try {
			String sql = "SELECT ID,NAME,AUTHOR,SUBJECT,PRICE FROM BOOKS WHERE SUBJECT=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, subject);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Book b = new Book();
				b.setId(rs.getInt("ID"));
				b.setName(rs.getString("NAME"));
				b.setAuthor(rs.getString("AUTHOR"));
				b.setSubject(rs.getString("SUBJECT"));
				b.setPrice(rs.getDouble("PRICE"));
				list.add(b);
			}
		}finally{
			if(rs!=null)
				rs.close();
			if(stmt!=null)
				stmt.close();
		}
		return list;
	}
}
