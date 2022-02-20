package retriving;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner ;
import java.sql.ResultSet;
import java.sql.Connection;
public class ClassA 
{
	public static void main(String[] args) {
		try {
			
		Scanner sc	 = new Scanner(System.in);
Connection con	=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/system","system","admin");
			
	    PreparedStatement pr =  con.prepareStatement("select * from book38 where bcode=? or bname=?");
		 System.out.println("enter your book code number");
		  String bcode  = sc.nextLine();
		        System.out.println("enter your book name");
		      String bname = sc.nextLine();
		           pr.setString(1,bcode);
		           pr.setString(2, bname);
		           
		         ResultSet rs = pr.executeQuery();
		         while(rs.next())
		         {
		        	 System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5));
		         }
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
