package com.bilgeadam.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.bilgeadam.jdbc.DBConstants;
import com.bilgeadam.jdbc.model.DersOgrenci;

public class DersOgrenciRepository
{

	public LinkedList<DersOgrenci> selectAll() throws SQLException
	{
		Connection c = DBConstants.DBConnection();
		Statement stmtn = c.createStatement();
		ResultSet result = stmtn.executeQuery("select * from \"DERS_OGRENCI\" order by \"ID\" asc");
		LinkedList<DersOgrenci> dersOgrenciler = new LinkedList<>();
		while (result.next())
		{
			long id = result.getLong("ID");
			long dersId = result.getLong("DERS_ID");
			long ogrId = result.getLong("OGR_ID");
			int devamsizlik = result.getInt("DEVAMSIZLIK");
			int note = result.getInt("NOTE");
			DersOgrenci k = new DersOgrenci(id, dersId, ogrId, devamsizlik, note);
			dersOgrenciler.add(k);
		}
		result.close();
		stmtn.close();
		c.close();
		return dersOgrenciler;
	}

	public boolean insert(Long dersId, Long ogrId, int devamsizlik, int note) throws SQLException
	{
		boolean isInserted = false;
		Connection c = DBConstants.DBConnection();
		String sql = "INSERT INTO \"DERS_OGRENCI\" (\"DERS_ID\", \"OGR_ID\", \"DEVAMSIZLIK\", \"NOTE\") VALUES (?, ?, ?, ?)";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setLong(1, dersId);
		stmt.setLong(2, ogrId);
		stmt.setInt(3, devamsizlik);
		stmt.setInt(4, note);
		isInserted = stmt.executeUpdate() == 1;
		stmt.close();
		c.close();
		return isInserted;
	}

	public boolean deleteById(long id) throws SQLException
	{
		boolean isDeleted = false;
		Connection c = DBConstants.DBConnection();
		String sql = "DELETE FROM \"KONU\" WHERE \"ID\" = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setLong(1, id);
		isDeleted = stmt.executeUpdate() == 1;
		stmt.close();
		c.close();
		return isDeleted;
	}

	public DersOgrenci selectById(long id) throws SQLException
	{
		Connection c = DBConstants.DBConnection();
		String sql = "SELECT * FROM \"DERS_OGRENCI\" WHERE \"ID\" = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setLong(1, id);
		ResultSet result = stmt.executeQuery();
		DersOgrenci dersOgrenci = null;
		while (result.next())
		{
			long dersId = result.getLong("DERS_ID");
			long ogrId = result.getLong("OGR_ID");
			int devamsizlik = result.getInt("DEVAMSIZLIK");
			int note = result.getInt("NOTE");
			dersOgrenci = new DersOgrenci(id, dersId, ogrId, devamsizlik, note);
		}
		stmt.close();
		c.close();
		return dersOgrenci;
	}
}
