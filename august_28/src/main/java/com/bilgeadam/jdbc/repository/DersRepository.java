package com.bilgeadam.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bilgeadam.jdbc.model.Ders;

import august_28.DBConstants;

public class DersRepository {

	public Ders selectById(long id) throws SQLException {
		Connection c = DBConstants.DBConnection();
		String sql = "SELECT * FROM \"Ders\" WHERE \"ID\" = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setLong(1, id);
		ResultSet result = stmt.executeQuery();
		Ders ders = null;
		while (result.next()) {
			long ogrId = result.getLong("OGR_ID");
			long konuId = result.getLong("KONU_ID");
			ders = new Ders(id, ogrId, konuId);
		}
		result.close();
		stmt.close();
		c.close();
		return ders;
	}

	public int deleteByKonuId(long konuId) throws SQLException {
		Connection c = DBConstants.DBConnection();
		String sql = "DELETE FROM \"DERS\" WHERE \"KONU_ID\" = ?";
		PreparedStatement stmt = c.prepareStatement(sql);
		stmt.setLong(1, konuId);
		int result = stmt.executeUpdate();
		stmt.close();
		c.close();
		return result;

	}

	public boolean insertTransactional(String name, boolean isGicik, String konuName) throws SQLException {
		// commit ve rollback
		Connection c = DBConstants.DBConnection();
		c.setAutoCommit(false);
		try {
			String sql = "INSERT INTO \"OGRETMEN\" (\"NAME\", \"IS_GICIK\") VALUES (?, CAST(? AS bit))";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setObject(2, isGicik ? 1 : 0);
			stmt.executeUpdate();
			stmt.close();
			sql = "INSERT INTO \"OBS\".\"KONU\" (\"NAME\") VALUES (?)";
			stmt = c.prepareStatement(sql);
			stmt.setString(1, konuName);
			stmt.executeUpdate();
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			c.rollback();
		}
		return false;
	}
}
