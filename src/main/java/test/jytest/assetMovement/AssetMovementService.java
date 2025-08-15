package test.jytest.assetMovement;

import test.jytest.repository.AssetMovementRepository;

import java.util.List;
import java.util.Optional;

public class AssetMovementService {

    private final AssetMovementRepository assetMovementRepository;

    public AssetMovementService(AssetMovementRepository assetMovementRepository) {
        this.assetMovementRepository = assetMovementRepository;
    }

    // 자산 생성
    AssetMovement createAssetMovement(final AssetMovement assetMovement) {
        return assetMovementRepository.save(assetMovement);
    }

    // 전체 자산 조회
    List<AssetMovement> findAllAssetMovement() {
        return assetMovementRepository.findAll();
    }

    // ID(자산 태그 번호)로 자산 조회
    Optional<AssetMovement> findAssetMovementById(final String movementId) {
        return assetMovementRepository.findById(movementId);
    }

    // 자산 정보 업데이트
    public int updateAssetMovement(final AssetMovement assetMovement) {
        return assetMovementRepository.update(assetMovement);
    }

    // 자산 삭제
    public int deleteAssetMovement(final String assetMovementId) {
        return assetMovementRepository.delete(assetMovementId);
    }

    public List<AssetMovement> search(AssetMovementSearchCondition cond) {return assetMovementRepository.search(cond);}

}
