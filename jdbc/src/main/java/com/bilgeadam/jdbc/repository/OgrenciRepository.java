package com.bilgeadam.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.bilgeadam.jdbc.DBConstants;
import com.bilgeadam.jdbc.model.Ogrenci;

public class OgrenciRepository
{
	public LinkedList<Ogrenci> selectAll() throws SQLException
	{
		Connection c = DBConstants.DBConnection();
		Statement stmtn = c.createStatement();
		ResultSet result = stmtn.executeQuery("select * from \"OGRENCI\" order by \"ID\" asc");
		LinkedList<Ogrenci> ogrenciler = new LinkedList<>();
		while (result.next())
		{
			long id = result.getLong("ID");
			String name = result.getString("Name");
			long ogrNumber = result.getLong("OGR_NUMBER");
			long year = result.getLong("YEAR");
			Ogrenci k = new Ogrenci(id, name, ogrNumber, year);
			ogrenciler.add(k);
		}
		result.close();
		stmtn.close();
		c.close();
		return ogrenciler;
	}

	public boolean insert(String name, Long ogrNumber, Long year) throws SQLException
	{
		boolean isInserted = false;
		Connection c = DBConstants.DBConnection();
		String sql = "INSERT INTO \"OGRENCI\" (\"NAME\", \"OGR_NUMBER\", \"YEAR\") VALUES (?, ?, ?)";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setString(1, name);
		stmt.setLong(2, ogrNumber);
		stmt.setLong(3, year);
		isInserted = stmt.executeUpdate() == 1;
		stmt.close();
		c.close();
		return isInserted;
	}

	public boolean deleteById(long id) throws SQLException
	{
		boolean isDeleted = false;
		Connection c = DBConstants.DBConnection();
		String sql = "DELETE FROM \"OGRENCI\" WHERE \"ID\" = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setLong(1, id);
		isDeleted = stmt.executeUpdate() == 1;
		stmt.close();
		c.close();
		return isDeleted;
	}

	public Ogrenci selectById(long id) throws SQLException
	{
		Connection c = DBConstants.DBConnection();
		String sql = "SELECT * FROM \"OGRENCI\" WHERE \"ID\" = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setLong(1, id);
		ResultSet result = stmt.executeQuery();
		Ogrenci ogrenci = null;
		while (result.next())
		{
			String name = result.getString("Name");
			long ogrNumber = result.getLong("OGR_NUMBER");
			long year = result.getLong("YEAR");
			ogrenci = new Ogrenci(id, name, ogrNumber, year);
		}
		result.close();
		stmt.close();
		c.close();
		return ogrenci;
	}
}
