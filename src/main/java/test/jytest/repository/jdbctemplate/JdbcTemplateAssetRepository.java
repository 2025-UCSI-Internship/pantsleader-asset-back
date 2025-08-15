package test.jytest.repository.jdbctemplate;

import org.springframework.stereotype.Repository;
import test.jytest.asset.Asset;
import test.jytest.asset.AssetSearchCondition;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import test.jytest.repository.AssetRepository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcTemplateAssetRepository implements AssetRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateAssetRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Asset save(Asset asset) {
        String sql = "INSERT INTO assets (" +
                "asset_id, asset_type, asset_category, brand, model, serial_number, purchase_date, " +
                "supplier, purchase_order, warranty_start_date, warranty_end_date, campus, location_room, " +
                "department, custodian_person, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                asset.getAssetId(),
                asset.getAssetType(),
                asset.getAssetCategory(),
                asset.getBrand(),
                asset.getModel(),
                asset.getSerialNumber(),
                asset.getPurchaseDate(),
                asset.getSupplier(),
                asset.getPurchaseOrder(),
                asset.getWarrantyStartDate(),
                asset.getWarrantyEndDate(),
                asset.getCampus(),
                asset.getLocationRoom(),
                asset.getDepartment(),
                asset.getCustodianPerson(),
                asset.getStatus()
        );

        return asset;
    }

    @Override
    public List<Asset> findAll() {
        String sql = "SELECT * FROM assets";
        return jdbcTemplate.query(sql, rowMapper());
    }

    @Override
    public Optional<Asset> findById(String assetId) {
        String sql = "SELECT * FROM assets WHERE asset_id = ?";
        try {
            Asset asset = jdbcTemplate.queryForObject(sql, rowMapper(), assetId);
            return Optional.of(asset);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }



    @Override
    public List<Asset> search(AssetSearchCondition cond) {
        String sql = "SELECT * FROM assets WHERE 1=1";
        List<Object> params = new ArrayList<>();

        if (cond.getAssetId() != null) {
            sql += " AND asset_id LIKE ?";
            params.add("%" + cond.getAssetId() + "%");
        }
        if (cond.getAssetType() != null) {
            sql += " AND asset_type LIKE ?";
            params.add("%" + cond.getAssetType() + "%");
        }
        if (cond.getAssetCategory() != null) {
            sql += " AND asset_category LIKE ?";
            params.add("%" + cond.getAssetCategory() + "%");
        }
        if (cond.getBrand() != null) {
            sql += " AND brand LIKE ?";
            params.add("%" + cond.getBrand() + "%");
        }
        if (cond.getModel() != null) {
            sql += " AND model LIKE ?";
            params.add("%" + cond.getModel() + "%");
        }
        if (cond.getSerialNumber() != null) {
            sql += " AND serial_number LIKE ?";
            params.add("%" + cond.getSerialNumber() + "%");
        }
        if (cond.getPurchaseDate() != null) {
            sql += " AND purchase_date = ?";
            params.add(cond.getPurchaseDate());
        }
        if (cond.getSupplier() != null) {
            sql += " AND supplier LIKE ?";
            params.add("%" + cond.getSupplier() + "%");
        }
        if (cond.getPurchaseOrder() != null) {
            sql += " AND purchase_order LIKE ?";
            params.add("%" + cond.getPurchaseOrder() + "%");
        }
        if (cond.getWarrantyStartDate() != null) {
            sql += " AND warranty_start_date = ?";
            params.add(cond.getWarrantyStartDate());
        }
        if (cond.getWarrantyEndDate() != null) {
            sql += " AND warranty_end_date = ?";
            params.add(cond.getWarrantyEndDate());
        }
        if (cond.getCampus() != null) {
            sql += " AND campus LIKE ?";
            params.add("%" + cond.getCampus() + "%");
        }
        if (cond.getLocationRoom() != null) {
            sql += " AND location_room LIKE ?";
            params.add("%" + cond.getLocationRoom() + "%");
        }
        if (cond.getDepartment() != null) {
            sql += " AND department LIKE ?";
            params.add("%" + cond.getDepartment() + "%");
        }
        if (cond.getCustodianPerson() != null) {
            sql += " AND custodian_person LIKE ?";
            params.add("%" + cond.getCustodianPerson() + "%");
        }
        if (cond.getStatus() != null) {
            sql += " AND status LIKE ?";
            params.add("%" + cond.getStatus() + "%");
        }

        return jdbcTemplate.query(sql, rowMapper(), params.toArray());
    }



    @Override
    public int update(Asset asset) {
        String sql = "UPDATE assets SET " +
                "asset_type = ?, asset_category = ?, brand = ?, model = ?, serial_number = ?, purchase_date = ?, " +
                "supplier = ?, purchase_order = ?, warranty_start_date = ?, warranty_end_date = ?, campus = ?, location_room = ?, " +
                "department = ?, custodian_person = ?, status = ? " +
                "WHERE asset_id = ?";

        return jdbcTemplate.update(sql,
                asset.getAssetType(),
                asset.getAssetCategory(),
                asset.getBrand(),
                asset.getModel(),
                asset.getSerialNumber(),
                asset.getPurchaseDate(),
                asset.getSupplier(),
                asset.getPurchaseOrder(),
                asset.getWarrantyStartDate(),
                asset.getWarrantyEndDate(),
                asset.getCampus(),
                asset.getLocationRoom(),
                asset.getDepartment(),
                asset.getCustodianPerson(),
                asset.getStatus(),
                asset.getAssetId()
        );

    }

    @Override
    public int delete(String assetId) {
        String sql = "DELETE FROM assets WHERE asset_id = ?";
        return jdbcTemplate.update(sql, assetId);
    }

    private RowMapper<Asset> rowMapper() {
        return (rs, rowNum) -> {
            Asset asset = new Asset();
            asset.setAssetId(rs.getString("asset_id"));
            asset.setAssetType(rs.getString("asset_type"));
            asset.setAssetCategory(rs.getString("asset_category"));
            asset.setBrand(rs.getString("brand"));
            asset.setModel(rs.getString("model"));
            asset.setSerialNumber(rs.getString("serial_number"));
            asset.setPurchaseDate(rs.getDate("purchase_date"));
            asset.setSupplier(rs.getString("supplier"));
            asset.setPurchaseOrder(rs.getString("purchase_order"));
            asset.setWarrantyStartDate(rs.getDate("warranty_start_date"));
            asset.setWarrantyEndDate(rs.getDate("warranty_end_date"));
            asset.setCampus(rs.getString("campus"));
            asset.setLocationRoom(rs.getString("location_room"));
            asset.setDepartment(rs.getString("department"));
            asset.setCustodianPerson(rs.getString("custodian_person"));
            asset.setStatus(rs.getString("status"));
            return asset;
        };
    }
}
