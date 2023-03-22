package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.dto.EmpDTO;
import app.utility.EmpDB_Util;

public class EmpDAO 
{
	public boolean addEmp(EmpDTO dto)
	{
		boolean res=true;
		
		Connection con=EmpDB_Util.getConnection();
		
		try {
			PreparedStatement pstmt=con.prepareStatement("insert into employee_details values(?,?,?,?)");
		    pstmt.setInt(1, dto.getId());
		    pstmt.setString(2, dto.getName());
		    pstmt.setInt(3, dto.getContact());
		    pstmt.setString(4, dto.getEmail());
		    
		    //nori-No of row inserted
		    int nori=pstmt.executeUpdate();
		    
		    if(nori!=1)
		    {
		    	res=false;
		    }
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
			res=false;
		}
		return res;
	}
	
	public boolean deleteEmp(int id)
	{
		boolean res=true;
		Connection con=EmpDB_Util.getConnection();
		
		try {
			PreparedStatement pstmt=con.prepareStatement("delete from employee_details where id=?");
			pstmt.setInt(1, id);
			
			int nord=pstmt.executeUpdate();
			
			if(nord!=1)
			{
				res=false;
			}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
			res=false;
		}
		
		return res;
	}

	public EmpDTO searchEmp(int id)
	{
		EmpDTO dto=null;
		
		Connection con=EmpDB_Util.getConnection();
		
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from employee_details where id=?");
			pstmt.setInt(1, id);
			
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				dto=new EmpDTO();
				dto.setId(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setContact(rs.getInt(3));
				dto.setEmail(rs.getString(4));
				
			}
			
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		}
		return dto;
	}

	public List<EmpDTO> displayAllEmp()
	{
		List<EmpDTO> employees=new ArrayList<EmpDTO>();
		
		Connection con=EmpDB_Util.getConnection();
		
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from employee_details");
			
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				EmpDTO dto=new EmpDTO();
				
				dto.setId(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setContact(rs.getInt(3));
				dto.setEmail(rs.getString(4));
				
				employees.add(dto);
			}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return employees;
		
	}

}
