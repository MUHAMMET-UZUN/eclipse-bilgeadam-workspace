package com.bilgeadam.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import com.bilgeadam.jdbc.DBConstants;
import com.bilgeadam.jdbc.model.Ders;

/**
 * @author numan Bunu kullanmayın, gidin service i kullanın
 */
public class DersRepository
{
	public LinkedList<Ders> selectAll() throws SQLException
	{
		Connection c = DBConstants.DBConnection();
		Statement stmtn = c.createStatement();
		ResultSet result = stmtn.executeQuery("select * from \"DERS\" order by \"ID\" asc");
		LinkedList<Ders> dersler = new LinkedList<>();
		while (result.next())
		{
			long id = result.getLong("ID");
			long konuId = result.getLong("KONU_ID");
			long ogrId = result.getLong("OGR_ID");
			Ders k = new Ders(id, ogrId, konuId);
			dersler.add(k);
		}
		result.close();
		stmtn.close();
		c.close();
		return dersler;
	}

	public boolean insert(Long ogrId, Long konuId) throws SQLException
	{
		boolean isInserted = false;
		Connection c = DBConstants.DBConnection();
		String sql = "INSERT INTO \"DERS\" (\"OGR_ID\", \"KONU_ID\") VALUES (?, ?)";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setLong(1, ogrId);
		stmt.setLong(2, konuId);
		isInserted = stmt.executeUpdate() == 1;
		stmt.close();
		c.close();
		return isInserted;
	}

	public boolean deleteById(long id) throws SQLException
	{
		boolean isDeleted = false;
		Connection c = DBConstants.DBConnection();
		String sql = "DELETE FROM \"DERS\" WHERE \"ID\" = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setLong(1, id);
		isDeleted = stmt.executeUpdate() == 1;
		stmt.close();
		c.close();
		return isDeleted;
	}

	public int deleteByKonuId(long konuId) throws SQLException
	{
		Connection c = DBConstants.DBConnection();
		String sql = "DELETE FROM \"DERS\" WHERE \"KONU_ID\" = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setLong(1, konuId);
		int result = stmt.executeUpdate();
		stmt.close();
		c.close();
		return result;
	}

	public Ders selectById(long id) throws SQLException
	{
		Connection c = DBConstants.DBConnection();
		String sql = "SELECT * FROM \"DERS\" WHERE \"ID\" = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setLong(1, id);
		ResultSet result = stmt.executeQuery();
		Ders ders = null;
		while (result.next())
		{
			long ogrId = result.getLong("OGR_ID");
			long konuId = result.getLong("KONU_ID");
			ders = new Ders(id, ogrId, konuId);
		}
		result.close();
		stmt.close();
		c.close();
		return ders;
	}

	public boolean insertTransactional(String name, boolean isGicik, String konuName) throws SQLException
	{
		// commit ve rollback
		Connection c = DBConstants.DBConnection();
		c.setAutoCommit(false);
		try
		{
			String sql = "INSERT INTO \"OGRETMEN\" (\"NAME\", \"IS_GICIK\") VALUES (?, CAST(? AS bit))";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setObject(2, isGicik ? 1 : 0);
			stmt.executeUpdate();
			stmt.close();
			sql = "INSERT INTO \"KONU\" (\"NAME\") VALUES (?)";
			stmt = c.prepareStatement(sql);
			stmt.setString(1, konuName);
			stmt.executeUpdate();
			stmt.close();
			sql = "DELETE FROM \"OGRETMEN\" WHERE \"ID\" = ?";
			stmt = c.prepareStatement(sql);
			stmt.setLong(1, 1);
			stmt.executeUpdate();
			stmt.close();
			sql = "INSERT INTO \"DERS\" (\"OGR_ID\", \"KONU_ID\") VALUES (?, ?)";
			stmt = c.prepareStatement(sql);
			stmt.setLong(1, 123);
			stmt.setLong(2, 123);
			stmt.executeUpdate();
			stmt.close();
			c.commit();
			c.close();
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
			c.rollback();
		}
		return true;
	}
}
