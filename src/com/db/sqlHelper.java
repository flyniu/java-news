package com.db;

import java.awt.print.Printable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.MediaSize.NA;

import com.entity.Artical;
import com.entity.Manager;
import com.entity.Nav;
import com.sun.crypto.provider.RSACipher;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.org.apache.bcel.internal.generic.Select;

public class sqlHelper {
		private java.sql.Connection con = null;
		public sqlHelper(){
			con = DB.getConnection();			
		}
		public void destroy(){
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		public boolean uniq(String manager_id){
			boolean re = false;
			String sql = "select * from manager where manager_id=?";		
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, manager_id);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					re = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
			
			return re;
			
		}
		
		@SuppressWarnings("null")
		public Manager queManagerbyIDandPWD(Manager manager1){
			String sql = "select manager_name from manager where manager_id=? and manager_password=?";
			Manager manager = new Manager();	
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, manager1.getManager_id());
				ps.setString(2, manager1.getManager_password());
				ResultSet rs = ps.executeQuery();	
				if(rs.next()){
				manager.setManager_name(rs.getString("manager_name"));					
				}					
			} catch (SQLException e) {			
				e.printStackTrace();
			}
			return manager;			
		}
		
		public Manager queryonemanager(String manager_id){		
			String sql = "select manager_id,manager_name from manager where manager_id=?";
			Manager manager = new Manager();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, manager_id);
				ResultSet rs = ps.executeQuery();
					while(rs.next()){
					manager.setManager_id(rs.getString("manager_id"));
					manager.setManager_name(rs.getString("manager_name"));
					
					}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return manager;
			
		}
		public List<Manager> queryallmanager(){
			
			List<Manager> list = new ArrayList<Manager>();
			String sql = "select manager_id,manager_name from manager";
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					Manager manager = new Manager();
					manager.setManager_id(rs.getString("manager_id"));
					manager.setManager_name(rs.getString("manager_name"));
					list.add(manager);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
 		}
		public String  insertmanager(Manager manager){
			String sql = "insert into manager (manager_id,manager_name,manager_password) values (?,?,?)";
			int result = -9;
			String string="ccc";
			try {							
				PreparedStatement ps = con.prepareStatement(sql);	
				ps.setString(1, manager.getManager_id());		
				ps.setString(2, manager.getManager_name());
		
				ps.setString(3, manager.getManager_password());
				result = ps.executeUpdate();
				string =  manager.getManager_id();
				
			} catch (Exception e) {
				System.out.println(e.toString());
				e.printStackTrace();
			}
			return string;
		}
		
		public boolean  insertnav(Nav nav){
			String sql = "insert into nav (nav_id,nav_name,nav_feight) values (?,?,?)";
			boolean judge = false;
			try {							
				PreparedStatement ps = con.prepareStatement(sql);	
				ps.setString(1, nav.getNav_id());		
				ps.setString(2, nav.getNav_name());		
				ps.setInt(3, nav.getNav_feight());
				ps.executeUpdate();	
				judge=true;				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return judge;
		}
		public  boolean delete(Manager manager){
			String sql = "delete from Manager where manager_id=?";			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, manager.getManager_id());
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		
		public Nav querynavbyname(String name){
			Nav nav = new Nav();
			String sql = "select * from nav where nav_name =?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, name);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					nav.setNav_feight(rs.getInt("nav_feight"));
					nav.setNav_name(rs.getString("nav_name"));
					nav.setNav_id(rs.getString("nav_id"));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return nav;			
		}
		public boolean deletenav(Nav nav){
			boolean judge =true;
			String sql ="delete from nav where nav_name=?";
			try{
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, nav.getNav_name());
				ps.executeUpdate();
			}catch (Exception e) {
					judge =false;
			}
			return judge;					
		}
		public boolean deleteartical(Artical artical){
			
			String sql = "delete from artical where artical_id=?";
			
			boolean judge=false;
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, artical.getArtical_id());
				ps.executeUpdate();
				judge=true;
				
			} catch (Exception e) {
					e.printStackTrace();
			}
			return judge;
		}
		public  boolean updatepaw(Manager manager){
			String sql = "update Manager set password=? where manager_id=?";
			boolean b = false;
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, manager.getManager_password());
				ps.setString(2, manager.getManager_id());
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return b;
		}
		public boolean updatenav(Nav nav){
			boolean judge = true;
			String sql = "update nav set nav_feight=?,nav_name=? where nav_id=?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, nav.getNav_feight());
				ps.setString(2, nav.getNav_name());
				ps.setString(3, nav.getNav_id());
				ps.executeUpdate();			
			} catch (Exception e) {
				e.printStackTrace();
				judge=false;
			}
			return judge;
		}
		public  boolean updatename(Manager manager){
			String sql = "update Manager set manager_name=? where manager_id=?";
			int re=0;
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, manager.getManager_name());
				ps.setString(2, manager.getManager_id());
				re = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(re!=0){
				return true;
				}
				else {
					return false;
				}
	
		}
		public  boolean updatenameandpaw(Manager manager){
			String sql = "update Manager set name=?,manager_password=? where manager_id=?";			
			int re=0;
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, manager.getManager_name());
				ps.setString(2, manager.getManager_id());
				re = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(re!=0){
			return true;
			}
			else {
				return false;
			}
		}
		public Nav queryonenav(String nav_name) {
			String sql = "select nav_name,nav_feight from nav where nav_name=?";
			Nav nav = new Nav();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, nav_name);
				ResultSet rs = ps.executeQuery();
					while(rs.next()){
					nav.setNav_name(rs.getString("nav_name"));
					nav.setNav_feight(rs.getInt("nav_feight"));					
					}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return nav;
		}
		public List<Nav> queryallnav() {
			List<Nav> nav = new ArrayList(); 
				String sql = "select * from nav";
				try{
					PreparedStatement ps = con.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					while(rs.next()){
						Nav nav1 = new Nav();
						nav1.setNav_name(rs.getString("nav_name"));
						nav1.setNav_feight(rs.getInt("nav_feight"));
						nav1.setNav_id(rs.getString("nav_id"));
						nav.add(nav1);
					}
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return nav;
		}
		public boolean insertartical(Artical artical) {
			String sql ="insert into artical (artical_id,artical_title,artical_date,artical_content,nav_id) values(?,?,?,?,?)";
			boolean judge = false;
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, artical.getArtical_id());
				ps.setString(2, artical.getArtical_title());
				ps.setString(3, artical.getArtical_date());
				ps.setString(4, artical.getArtical_content());
				ps.setString(5, artical.getNav_id());
				ps.executeUpdate();
				judge=true;
				
			} catch (Exception e) {
				e.printStackTrace();
				judge=false;
			}
			return judge;
			
		}
		public List<Map<String,String>> queryallarticalmap(String nav_id,String artical_title) {
			String sql = "select artical_id,artical_title,artical_date,nav_name from artical,nav where artical.nav_id=nav.nav_id ";
			if(nav_id!=null && !"".equals(nav_id)) 
			{
				sql += "and nav.nav_id =? "; 
			}	
			if(artical_title!=null && !"".equals(artical_title)){
				sql+= "and artical_title like ? ";
			}			
					sql += "order by artical_date desc";
			List<Map<String,String>> list = new ArrayList();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				int pos=1;
				if(nav_id!=null && !"".equals(nav_id)) 
				{
					ps.setString(pos, nav_id);
					pos=2;
				}	
				if(artical_title!=null && !"".equals(artical_title)){
					ps.setString(pos, "%"+artical_title+"%");
				}
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					Map<String, String> map = new HashMap();
					map.put("artical_id", rs.getString("artical_id"));
					map.put("artical_title", rs.getString("artical_title"));
					map.put("artical_date", rs.getString("artical_date"));
					map.put("nav_name", rs.getString("nav_name"));
					list.add(map);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		public List<Map<String, String>> querylimitarticalmap(int page,String nav_id,String artical_title) {
			String sql = "select artical_id,artical_title,artical_date,nav_name from artical,nav where artical.nav_id=nav.nav_id ";
				if(nav_id!=null && !"".equals(nav_id)) 
				{
					sql += "and nav.nav_id =? "; 
				}				
				if(artical_title!=null && !"".equals(artical_title)){
					sql+= "and artical_title like ? ";
				}
					sql += "order by artical_date desc limit "+ (page-1)*10 + ",10";
			List<Map<String,String>> list = new ArrayList();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				int pos=1;
				if(nav_id!=null && !"".equals(nav_id)) 
				{
					ps.setString(pos, nav_id);
					pos=2;
				}	
				if(artical_title!=null && !"".equals(artical_title)){
					ps.setString(pos, "%"+artical_title+"%");
				}
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					Map<String, String> map = new HashMap();
					map.put("artical_id", rs.getString("artical_id"));
					map.put("artical_title", rs.getString("artical_title"));
					map.put("artical_date", rs.getString("artical_date"));
					map.put("nav_name", rs.getString("nav_name"));
					list.add(map);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		public Artical queryarticalbyid(String aritical_id) {
			String sql = "select * from artical where artical_id =?";
			Artical artical = new Artical();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, aritical_id);
				ResultSet rs = ps.executeQuery();
		
			
				while(rs.next()){
					
					artical.setArtical_id(rs.getString("artical_id"));
					artical.setArtical_title(rs.getString("artical_title"));
					artical.setArtical_date(rs.getString("artical_date"));
					artical.setNav_id(rs.getString("nav_id"));
					artical.setArtical_content(rs.getString("artical_content"));									
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return artical;
		}
		/*
		 * 更新新闻
		 */
		public boolean editartical(Artical artical) {
			String sql = "update artical" +
					" set " +
					"artical_title=?,artical_date=?,artical_content=?,nav_id=?"+" where artical_id=? ";
			boolean judge=false;
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, artical.getArtical_title());				
				ps.setString(2, artical.getArtical_date());
				ps.setString(3, artical.getArtical_content());				
				ps.setString(4, artical.getNav_id());
				ps.setString(5, artical.getArtical_id());
				System.out.println(artical.getArtical_content());
				System.out.println(sql);
				ps.executeUpdate();
				judge=true;
			} catch (Exception e) {
			e.printStackTrace();
			}
			return judge;
		}
		public List<Artical> queryarticalbynav(String nav_id) {

			String sql = "select artical_id,artical_title,artical_date from artical where nav_id=? order by artical_date desc limit 0,7";
			List<Artical> list = new ArrayList();			
			try {
				PreparedStatement ps = con.prepareStatement(sql);			
				ps.setString(1, nav_id);		
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					Artical artical = new Artical();
					artical.setArtical_id(rs.getString("artical_id"));
					artical.setArtical_title(rs.getString("artical_title"));
					artical.setArtical_date(rs.getString("artical_date"));
					list.add(artical);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}				
}
