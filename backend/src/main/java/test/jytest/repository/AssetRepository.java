package test.jytest.repository;

import org.springframework.stereotype.Repository;
import test.jytest.asset.Asset;
import test.jytest.asset.AssetSearchCondition;

import java.util.List;
import java.util.Optional;



public interface AssetRepository {


    Asset save(final Asset asset);

    Optional<Asset> findById(final String assetId);

    List<Asset> findAll();

    int update(final Asset asset);

    int delete(final String assetId);

    List<Asset> search(AssetSearchCondition cond);

}

