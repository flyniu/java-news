package com.handle;

import com.db.sqlHelper;
import com.entity.Artical;
import com.entity.Manager;
import com.entity.Nav;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ActionBean {
	public String queryManager(){		
		sqlHelper sh = new sqlHelper();
		List<Manager> list = sh.queryallmanager();
		String tablehtmlString="";
		int i=1;
		for(Manager manager:list){
			tablehtmlString += "<tr><td><input type=\"radio\"  name=\"rdo\" autocomplete=\"off\" value=\""+ manager.getManager_id() + " \"></td> <td class=\"text-center\">" + i++ +"</td><td class=\"text-center\">"+ manager.getManager_id() +"</td><td class=\"text-center\">"+manager.getManager_name() + "</td></tr>";
		}
		sh.destroy();
		
		return tablehtmlString;
 	}
	
	public String queryNav(){
		sqlHelper sp = new sqlHelper();
		List<Nav> nav1 = sp.queryallnav();
		Collections.sort(nav1,new Comparator<Nav>(){

			public int compare(Nav o1, Nav o2) {
			if(o1.getNav_feight()>o2.getNav_feight()){
				return -1;
			}
			if(o1.getNav_feight()==o2.getNav_feight()){
				return o1.getNav_name().compareTo(o2.getNav_name());
				}
			if(o1.getNav_feight()<o2.getNav_feight()){
				return 1;
			}
			return 0;
			}			
		});
		String tablehtmlString = "";
		int i=1;
		
		for(Nav nav:nav1){
			tablehtmlString += "<tr><td><input type=\"radio\"  name=\"rdo\" autocomplete=\"off\" value=\""+ nav.getNav_name() + " \"></td> <td class=\"text-center\">" + i++ +"</td><td class=\"text-center\">"+ nav.getNav_name() +"</td><td class=\"text-center\">"+  nav.getNav_feight() +"</td></tr>"; 
		}
		sp.destroy();
		return tablehtmlString;
		
	}
	
	
	public Manager queryManagerById(String  manager_id){
		Manager manager = new Manager();
		sqlHelper sh = new sqlHelper();
		manager = sh.queryonemanager(manager_id);
		sh.destroy();
		return manager;
	}
	
	public Nav  queryNavByName(String nav_name){
		Nav nav = new Nav();
		sqlHelper s = new sqlHelper();
		nav = s.queryonenav(nav_name);
		s.destroy();
		return nav;
	}
	
	public List<Nav> querynavlist(){
		sqlHelper sp = new sqlHelper();
		List<Nav> nav1 = sp.queryallnav();
		Collections.sort(nav1,new Comparator<Nav>(){

			public int compare(Nav o1, Nav o2) {
			if(o1.getNav_feight()>o2.getNav_feight()){
				return -1;
			}
			if(o1.getNav_feight()==o2.getNav_feight()){
				return o1.getNav_name().compareTo(o2.getNav_name());
				}
			if(o1.getNav_feight()<o2.getNav_feight()){
				return 1;
			}
			return 0;
			}			
		});
		sp.destroy();
		
		return nav1;
	}
	
	public List<Map<String,String>> queryallartical(String nav_id,String artical_title){
		List<Map<String,String>> list =null;
		sqlHelper sql = new sqlHelper();
		list = sql.queryallarticalmap(nav_id,artical_title);
		sql.destroy();		
		return list;
	}
	
	public List<Map<String,String>> querylimitartical(int page,String nav_id,String artical_title){
		List<Map<String,String>> list =null;
		sqlHelper sql = new sqlHelper();
		list = sql.querylimitarticalmap(page,nav_id,artical_title);
		sql.destroy();		
		return list;
	}
	
	public Map quertArtical4edit(String artical_id){
		Map map = new HashMap();
		sqlHelper sql = new sqlHelper();
		map.put("navlist", sql.queryallnav());
		map.put("artical", sql.queryarticalbyid(artical_id));
		sql.destroy();
		return map;		
	}
	
	public List<Artical>  queryarticalbytype(String nav_id){
		sqlHelper sql = new sqlHelper();
		List<Artical> list = sql.queryarticalbynav(nav_id); 
		sql.destroy();
		return list;
	}
}
