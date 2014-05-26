package mylibs;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


  
public class DBOP {  
	private Statement stat = null;
	private PreparedStatement psStatement = null;
	private ResultSet rsq   = null;
	private String tablename = null;
	private Connection conn  = null;
	String sql;
	
	public DBOP(String tablename){
		this.tablename = tablename;
	}  
 

	public String  queryBySql(String sql,Object[] paramas){
//		connection();
		String code = null;
		try {
			java.sql.PreparedStatement prepareStatement = conn.prepareStatement(sql);
			if(paramas!=null&&paramas.length>0){
				for(int i=0;i<paramas.length;i++){
					prepareStatement.setObject(i+1, paramas[i]);
				}
			}
			while (rsq.next()) { 
				code = rsq.getString("regist_code");
				break;
				}
				rsq.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return code;
	}
	
	public void connxpath(String file){
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:"+System.getProperty("user.dir")+"\\src\\locator\\"+file);
			stat = conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void conntable(String database,String username,String passwd){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//String database = "jdbc:mysql://172.16.12.51:3306/customer"
			//String username = "writeuser"
			//String passwd = "parkland100"
			conn = DriverManager.getConnection("jdbc:mysql://172.16.12.51:3306/"+database, username, passwd);
			stat = conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String  selectSettleBill(){
//		connection("settle", "writeuser", "parkland100");
		String code = null;
		sql = "select send_body from "+tablename+" where to_phone = 18610066360 ORDER BY create_time desc limit 1";
		try {
			rsq =stat.executeQuery(sql);
			rsq.last();
			int rsqi = rsq.getRow();
			System.out.println(rsqi);
			for (int i=1;i<=rsqi;i++){
			rsq.absolute(i);
			System.out.println(rsq.getString(1));
			System.out.println(rsq.getString(1).subSequence(0,6));
			}
			rsq.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			close();
		}
		return code;
	}
//	直接通过SQL语句查询后取的第一列的值
	public String  exesql(String sql){
		String result = null;
		try {
			rsq =stat.executeQuery(sql);
			rsq.last();
			result = rsq.getString(1);
			rsq.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			close();
		}
		return result;
	}
//	直接通过SQL语句查询后取的第i列的值
	public String  exesql(String sql,int i){
		String result = null;
		try {
			rsq =stat.executeQuery(sql);
			rsq.last();
			result = rsq.getString(i);
			rsq.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			close();
		}
		return result;
	}

	public String  getLocatorXpath(String locatorname){
		String xpath = null;
		try {
			rsq =stat.executeQuery("select * from "+tablename+" where webelement = '"+locatorname+"';");
			while (rsq.next()) { 
				xpath = rsq.getString("Xpath");
				}
				rsq.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xpath;
	}
	
	public String  getLocatoDate(String locatorname){
		String data = null;
		try {
			rsq =stat.executeQuery("select * from "+tablename+" where id = '"+locatorname+"';");
			while (rsq.next()) { 
				data = rsq.getString("id");
				}
				rsq.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	
	public String getLocatorCSS(String locatorname){
		String css = null;
		try {
			rsq =stat.executeQuery("select * from "+tablename+" where WebElementName = '"+locatorname+"';");
			while (rsq.next()) { 
			css=rsq.getString("CSS");
			}
				rsq.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return css;
	}
	
	
	private void close() {
		if(conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public String getTestDate(int i,int j){
		String date = null;
		try {
			rsq =stat.executeQuery("select * from "+tablename+" where id = "+i+";");
			while (rsq.next()) { 
				date=rsq.getString(j);
			}
				rsq.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
		
	}

	public static void main(String[] args) {
		DBOP dbop = new DBOP("coupon_info");

		
		
	}
	
}  