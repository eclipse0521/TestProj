package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CenterDAO {
	
	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;
	
	public CenterDAO() {
		try {
			
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:/comp/env/mmm");
			
			con = ds.getConnection();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<CenterDTO> list(String cate){
		
		ArrayList<CenterDTO> res = new ArrayList<CenterDTO>();
		
		try {
			sql = "select * from center where cate = ?";
			
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, cate);
			
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				CenterDTO dto = new CenterDTO();
				
				dto.setId(rs.getInt("id"));
				dto.setGid(rs.getInt("gid"));
				dto.setSeq(rs.getInt("seq"));
				dto.setLev(rs.getInt("lev"));
				dto.setCnt(rs.getInt("cnt"));
				
				dto.setTitle(rs.getString("title"));
				dto.setPname(rs.getString("pname"));
				
				dto.setRegdate(rs.getTimestamp("regdate"));
				
				res.add(dto);
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return res;

	}
	
	public CenterDTO detail(String id){
		CenterDTO dto = null;
		
		sql = "select * from center where id = ?";
		
		
		
		try {
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1,  id);
			
			rs = ptmt.executeQuery();
			
			if(rs.next()) {
				dto = new CenterDTO();
				dto.setId(rs.getInt("id"));
				dto.setPname(rs.getString("pname"));
				dto.setTitle(rs.getString("title"));
				dto.setRegdate(rs.getDate("regdate"));
				dto.setContent(rs.getString("content"));
				
				dto.setCnt(rs.getInt("cnt"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return dto;
	}
	
	
	public int insert(CenterDTO dto){
		
		int res = -1;
		
		sql = "insert into center (pname, title, cate, content, cnt, gid, seq, lev, regdate) values "
				+ "(?, ?, ?, ?, 1, id, 0, 0, sysdate())";
						
		try {
			
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, dto.getPname());
			ptmt.setString(2, dto.getTitle());
			ptmt.setString(3, "notice");
			ptmt.setString(4, dto.getContent());
//			ptmt.setInt(5, dto.getId());
			
			rs = ptmt.executeQuery();
			
			sql = "select max(id) from center";
			rs = ptmt.executeQuery(sql);
			
			rs.next();
			res = rs.getInt(1);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return res;
	}
	
	public void Update(String id) {
				
		try {
			
			sql = "UPDATE center SET cnt = (cnt+1) WHERE id = ?";
			
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, id);
			
			rs = ptmt.executeQuery();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}	
		
	}
	
	public CenterDTO Modify(String id, String title, String content) {
		
		try {
			
			sql = "UPDATE center SET title = ?, content = ? WHERE id = ?";
			
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, title);
			
			ptmt.setString(2, content);
			
			ptmt.setString(3, id);
			
			rs = ptmt.executeQuery();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return null;	
		
	}
	
	public void Delete(String id) {
		
		try {
			
			sql = "delete from center where id = ?";
			
			ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, id);
			
			rs = ptmt.executeQuery();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	
	void close() {
		if(rs!=null)try {rs.close();} catch (SQLException e) {}
		if(ptmt!=null)try {ptmt.close();} catch (SQLException e) {}
		if(con!=null)try {con.close();} catch (SQLException e) {}
	}
}
