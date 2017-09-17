package pizzaordersystem.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import pizzaordersystem.beans.Pizza;

public class AdminDao extends BaseDao {

	private ArrayList<Pizza> pizzaList;

	public String addPizza(Pizza p) {
		String sql = "insert into pizzadb values(?,?,?,?,?)";
		String sql1 = "select max(pizzaid) from pizzadb";
		int currId = 111;

		try (PreparedStatement ps = getMyConnection().prepareStatement(sql1); 
				ResultSet rs = ps.executeQuery()) {
			if (rs.next())
				currId = rs.getInt(1) + 1;
		} catch (SQLException e) {
			e.printStackTrace();

		}

		try (PreparedStatement ps = getMyConnection().prepareStatement(sql)) {
			ps.setInt(1, currId);
			ps.setString(2, p.getPizzaName());
			ps.setString(3, p.getSize() + "");
			ps.setFloat(4, p.getPrice());
			ps.setString(5, p.getPizzaType());
			if (ps.executeUpdate() > 0) {
				return ("Pizza Added Successfully");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public ArrayList<Pizza> showAll() {

		String sql = "select * from pizzaDb order by pizzaid";
		pizzaList = new ArrayList<>();

		try (PreparedStatement ps = getMyConnection().prepareStatement(sql); 
				ResultSet rs = ps.executeQuery(sql)) {
			while (rs.next()) {
				Pizza p = new Pizza(rs.getInt(1), rs.getString(2), rs.getString(3).charAt(0), rs.getInt(4),
						rs.getString(5));
				pizzaList.add(p);
			}
			return pizzaList;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean update(Pizza p) {
		String sql = "update pizzaDb set pizzaname=?,pizzatype=?,pizzasize=?,pizzaprice=? where pizzaid=?";
		try (PreparedStatement ps = getMyConnection().prepareStatement(sql)) {
			ps.setString(1, p.getPizzaName());
			ps.setString(2, p.getPizzaType());
			ps.setString(3, p.getSize() + "");
			ps.setFloat(4, p.getPrice());
			ps.setInt(5, p.getPizzaId());
			return (ps.executeUpdate() > 0);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Pizza getPizzaDetails(int pid) {
		String sql = "select * from pizzaDB where pizzaId=?";
		try (PreparedStatement ps = getMyConnection().prepareStatement(sql);) {
			Pizza p = new Pizza();
			ps.setInt(1, pid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				p.setPizzaId(rs.getInt(1));
				p.setPizzaName(rs.getString(2));
				p.setSize(rs.getString(3).charAt(0));
				p.setPrice(rs.getInt(4));
				p.setPizzaType(rs.getString(5));
				return p;
			} else
				return null;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean delete(int pid) {
		String sql = "delete from pizzaDB where pizzaId=?";
		try (PreparedStatement ps = getMyConnection().prepareStatement(sql)) {
			ps.setInt(1, pid);
			if (ps.executeUpdate() > 0)
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	

}
