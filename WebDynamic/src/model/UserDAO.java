package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

public class UserDAO {
    public List<User> getAll(){
        List<User> list = new ArrayList<User>();
        try {
            Connection con = DBHelper.getConnection();
            String query = "SELECT * FROM User";
            PreparedStatement pstm = con.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                list.add(new User(rs.getInt("id"), rs.getString("username"), rs.getBoolean("gender"), rs.getString("email"), rs.getString("password")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public User getUser(int id) {
    	User user = new User();
		try {
			Connection con = DBHelper.getConnection();
			String query = "select * from user where id = ?";
			PreparedStatement pstm =con.prepareStatement(query);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				 user = new User(rs.getInt("id"),rs.getString("username"),rs.getBoolean("gender"),rs.getString("email"),rs.getString("password"));				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
    }
    public int addUser(User user) {
        try {
            Connection con = DBHelper.getConnection();
            String query = "INSERT INTO User (username, password, email, gender) VALUES (?, ?, ?, ?)";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPassword());
            pstm.setString(3, user.getEmail());
            pstm.setBoolean(4, user.isGender());
            int kq = pstm.executeUpdate();
            return kq;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int deleteUser (int id) {
    	try {
			Connection con = DBHelper.getConnection();
			String query = "delete from User where id = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			int kq = pstm.executeUpdate();
			return kq;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return -1;
    }
    public int updateUser (User user) {	
    	try {
			Connection con = DBHelper.getConnection();
			String query = "update User set username= ?, password =? , email=? ,gender =? where  id = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setString(1, user.getUsername());
			pstm.setString(2,user.getPassword());
			pstm.setString(3,user.getEmail());
			pstm.setBoolean(4, user.isGender());
			pstm.setInt(5, user.getId());
			int kq = pstm.executeUpdate();
			return kq;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	return -1;
    }
}
