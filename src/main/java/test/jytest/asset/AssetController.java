package test.jytest.asset;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/assets")
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    // 자산 추가 - POST
    @PostMapping
    public ResponseEntity<Asset> create(@RequestBody final AssetRequest request) {
        Asset asset = new Asset(
                request.getAssetId(),
                request.getAssetType(),
                request.getAssetCategory(),
                request.getBrand(),
                request.getModel(),
                request.getSerialNumber(),
                request.getPurchaseDate(),
                request.getSupplier(),
                request.getPurchaseOrder(),
                request.getWarrantyStartDate(),
                request.getWarrantyEndDate(),
                request.getCampus(),
                request.getLocationRoom(),
                request.getDepartment(),
                request.getCustodianPerson(),
                request.getStatus()
        );
        return ResponseEntity.ok(assetService.createAsset(asset));
    }

    // 전체 자산 조회 - GET
    @GetMapping
    public ResponseEntity<List<Asset>> getAssets() {
        return ResponseEntity.ok(assetService.findAssets());
    }

    // asset_id로 자산 조회 - GET
    @GetMapping("/{asset_id}")
    public ResponseEntity<Asset> getAsset(@PathVariable("asset_id") final String assetId) {
        Optional<Asset> assetOpt = assetService.findAssetById(assetId);
        if (assetOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(assetOpt.get());
    }

    // 검색 조건으로 검색
    @GetMapping("/search")
    public ResponseEntity<List<Asset>> searchAsset(AssetSearchCondition cond) {
        return ResponseEntity.ok(assetService.search(cond));
    }


    // 자산 정보 수정 - PATCH
    @PatchMapping("/{asset_id}")
    public ResponseEntity<String> updateAsset(@PathVariable("asset_id") final String assetId,
                                              @RequestBody final AssetRequest request) {
        Asset updateAsset = new Asset();
        updateAsset.setAssetId(assetId);
        updateAsset.setAssetType(request.getAssetType());
        updateAsset.setAssetCategory(request.getAssetCategory());
        updateAsset.setBrand(request.getBrand());
        updateAsset.setModel(request.getModel());
        updateAsset.setSerialNumber(request.getSerialNumber());
        updateAsset.setPurchaseDate(request.getPurchaseDate());
        updateAsset.setSupplier(request.getSupplier());
        updateAsset.setPurchaseOrder(request.getPurchaseOrder());
        updateAsset.setWarrantyStartDate(request.getWarrantyStartDate());
        updateAsset.setWarrantyEndDate(request.getWarrantyEndDate());
        updateAsset.setCampus(request.getCampus());
        updateAsset.setLocationRoom(request.getLocationRoom());
        updateAsset.setDepartment(request.getDepartment());
        updateAsset.setCustodianPerson(request.getCustodianPerson());
        updateAsset.setStatus(request.getStatus());

        int updatedCount = assetService.updateAsset(updateAsset);
        if (updatedCount == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("해당 자산을 찾을 수 없거나 수정된 데이터가 없습니다.");
        }
        return ResponseEntity.ok("업데이트 성공");
    }

    // 자산 삭제 - DELETE
    @DeleteMapping("/{asset_id}")
    public ResponseEntity<String> removeAsset(@PathVariable("asset_id") final String assetId) {
        int deletedCount = assetService.deleteAsset(assetId);
        if (deletedCount == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("해당 자산을 찾을 수 없습니다.");
        }
        return ResponseEntity.ok("자산 정보 삭제 성공");
    }

}
