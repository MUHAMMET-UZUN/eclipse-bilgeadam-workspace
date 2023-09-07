package com.bilgeadam.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.bilgeadam.jdbc.DBConstants;
import com.bilgeadam.jdbc.model.Ogretmen;

public class OgretmenRepository
{
	public LinkedList<Ogretmen> selectAll() throws SQLException
	{
		Connection c = DBConstants.DBConnection();
		Statement stmtn = c.createStatement();
		ResultSet result = stmtn.executeQuery("select * from \"OGRETMEN\" order by \"ID\" asc");
		LinkedList<Ogretmen> ogretmenler = new LinkedList<>();
		while (result.next())
		{
			long id = result.getLong("ID");
			String name = result.getString("Name");
			boolean isGicik = result.getBoolean("IS_GICIK");
			Ogretmen k = new Ogretmen(id, name, isGicik);
			ogretmenler.add(k);
		}
		result.close();
		stmtn.close();
		c.close();
		return ogretmenler;
	}

	public boolean insert(String name, boolean isGicik) throws SQLException
	{
		boolean isInserted = false;
		Connection c = DBConstants.DBConnection();
		String sql = "INSERT INTO \"OGRETMEN\" (\"NAME\", \"IS_GICIK\") VALUES (?, CAST(? AS bit))";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setString(1, name);
		stmt.setObject(2, isGicik ? 1 : 0);
		isInserted = stmt.executeUpdate() == 1;
		stmt.close();
		c.close();
		return isInserted;
	}

	public boolean deleteById(long id) throws SQLException
	{
		boolean isDeleted = false;
		Connection c = DBConstants.DBConnection();
		String sql = "DELETE FROM \"OGRETMEN\" WHERE \"ID\" = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setLong(1, id);
		isDeleted = stmt.executeUpdate() == 1;
		stmt.close();
		c.close();
		return isDeleted;
	}

	public Ogretmen selectById(long id) throws SQLException
	{
		Connection c = DBConstants.DBConnection();
		String sql = "SELECT * FROM \"OGRETMEN\" WHERE \"ID\" = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setLong(1, id);
		ResultSet result = stmt.executeQuery();
		Ogretmen ogretmen = null;
		while (result.next())
		{
			long ogr_id = result.getLong("ID");
			String name = result.getString("Name");
			boolean isGicik = result.getBoolean("IS_GICIK");
			ogretmen = new Ogretmen(ogr_id, name, isGicik);
		}
		stmt.close();
		c.close();
		return ogretmen;
	}
}
