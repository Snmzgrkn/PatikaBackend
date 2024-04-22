package Week_07.RENTACAR.dao;

import Week_07.RENTACAR.core.Db;
import Week_07.RENTACAR.entity.Brand;
import Week_07.RENTACAR.entity.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelDao {
    private Connection connection;
    private final BrandDao brandDao = new BrandDao();
    public ModelDao(){
        this.connection = Db.getInstance();
    }

    public Model getById(int id){
        Model obj = null;
        String query = "SELECT * FROM public.model WHERE model_id = ?";
        try {
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) obj = this.match(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }



    public ArrayList<Model> findAll() {
        ArrayList<Model> modelList = new ArrayList<>();
        return this.selectByQuery("SELECT * FROM public.model ORDER BY model_id ASC");

    }
    public ArrayList<Model> getByListBrandId(int brandId) {
        return this.selectByQuery("SELECT * FROM public.model WHERE model_brand_id = "+brandId);
    }

    public boolean save(Model model) {
        String query = "INSERT INTO public.model " +
                "(model_brand_id, model_name, model_type, model_year, model_fuel, model_gear) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement prepared = this.connection.prepareStatement(query);
            // Set parameters for the insert query
            prepared.setInt(1, model.getBrand_id());
            prepared.setString(2, model.getName());
            prepared.setString(3, model.getType().toString());
            prepared.setString(4, model.getYear());
            prepared.setString(5, model.getFuel().toString());
            prepared.setString(6, model.getGear().toString());
            return prepared.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Model model) {
        String query = "UPDATE public.model SET " +
                "model_brand_id = ?, " +
                "model_name = ?, " +
                "model_type = ?, " +
                "model_year = ?, " +
                "model_fuel = ?, " +
                "model_gear = ? " +
                "WHERE model_id = ?";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            // Set parameters for the update query
            ps.setInt(1, model.getBrand_id());
            ps.setString(2, model.getName());
            ps.setString(3, model.getType().toString());
            ps.setString(4, model.getYear());
            ps.setString(5, model.getFuel().toString());
            ps.setString(6, model.getGear().toString());
            ps.setInt(7, model.getId());
            return ps.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean delete(int model_id) {
        String query = "DELETE FROM public.model WHERE model_id = ?";
        try {
            PreparedStatement prepared = this.connection.prepareStatement(query);
            prepared.setInt(1, model_id);
            return prepared.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
    public ArrayList<Model> selectByQuery(String query) {
        ArrayList<Model> modelList = new ArrayList<>();
        try {
            ResultSet rs = this.connection.createStatement().executeQuery(query);
            while (rs.next()) {
                modelList.add(this.match(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelList;
    }

    public Model match(ResultSet rs) throws SQLException{
        Model model = new Model();
        model.setId(rs.getInt("model_id"));
        model.setName(rs.getString("model_name"));
        model.setFuel(Model.Fuel.valueOf(rs.getString("model_fuel")));
        model.setGear(Model.Gear.valueOf(rs.getString("model_gear")));
        model.setType(Model.Type.valueOf(rs.getString("model_type")));
        model.setYear(rs.getString("model_year"));
        model.setBrand(this.brandDao.getById(rs.getInt("model_brand_id")));
        model.setBrand_id(rs.getInt("model_brand_id"));
        return model;
    }


}
