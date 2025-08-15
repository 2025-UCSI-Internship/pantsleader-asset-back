package test.jytest.asset;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import test.jytest.repository.AssetRepository;

import java.util.List;
import java.util.Optional;


public class AssetService {

    private final AssetRepository assetRepository;

    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    // 자산 생성
    Asset createAsset(final Asset asset) {
        return assetRepository.save(asset);
    }

    // 전체 자산 조회
    List<Asset> findAssets() {
        return assetRepository.findAll();
    }

    // ID(자산 태그 번호)로 자산 조회
    Optional<Asset> findAssetById(final String assetId) {
        return assetRepository.findById(assetId);
    }

    // 자산 정보 업데이트
    public int updateAsset(final Asset asset) {
        return assetRepository.update(asset);
    }

    // 자산 삭제
    public int deleteAsset(final String assetId) {
        return assetRepository.delete(assetId);
    }

    public List<Asset> search(AssetSearchCondition cond) {return assetRepository.search(cond);}

}

