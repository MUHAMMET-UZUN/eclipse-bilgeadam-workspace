package com.bilgeadam.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.bilgeadam.jdbc.DBConstants;
import com.bilgeadam.jdbc.model.Konu;

public class KonuRepository
{
	public LinkedList<Konu> selectAll() throws SQLException
	{
		Connection c = DBConstants.DBConnection();
		Statement stmnt = c.createStatement();
		ResultSet result = stmnt.executeQuery("select * from \"KONU\" order by \"ID\" asc");
		LinkedList<Konu> konular = new LinkedList<>();
		while (result.next())
		{
			// result set satılar kümesidir
			long id = result.getLong("ID");
			String name = result.getString("NAME");
			Konu k = new Konu(id, name);
			konular.add(k);
		}
		result.close();
		stmnt.close();
		c.close();
		return konular;
	}

	public boolean insert(String name) throws SQLException
	{
		boolean isInserted = false;
		Connection c = DBConstants.DBConnection();
		String sql = "INSERT INTO \"KONU\" (\"NAME\") VALUES (?)";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setString(1, name);
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

	public Konu selectById(long id) throws SQLException
	{
		Connection c = DBConstants.DBConnection();
		String sql = "SELECT * FROM \"KONU\" WHERE \"ID\" = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setLong(1, id);
		ResultSet result = stmt.executeQuery();
		Konu konu = null;
		result.next();
		String name = result.getString("NAME");
		konu = new Konu(id, name);
		result.close();
		stmt.close();
		c.close();
		return konu;
	}
}