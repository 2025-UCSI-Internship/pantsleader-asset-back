package test.jytest.repository;

import test.jytest.asset.Asset;
import test.jytest.asset.AssetSearchCondition;
import test.jytest.assetMovement.AssetMovement;
import test.jytest.assetMovement.AssetMovementSearchCondition;

import java.util.List;
import java.util.Optional;


public interface AssetMovementRepository {


    AssetMovement save(final AssetMovement assetMovement);

    Optional<AssetMovement> findById(final String movementId);

    List<AssetMovement> findAll();

    int update(final AssetMovement assetMovement);

    int delete(final String movementId);

    Optional<AssetMovement> findById(Long movementId);

    List<AssetMovement> search(AssetMovementSearchCondition cond);


    int delete(Long movementId);
}

