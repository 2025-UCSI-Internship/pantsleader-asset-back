package test.jytest.assetMovement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/asset-movements")
public class AssetMovementController {

    private final AssetMovementService assetMovementService;

    public AssetMovementController(AssetMovementService assetMovementService) {
        this.assetMovementService = assetMovementService;
    }

    // 1. 자산 이동 추가 - POST
    @PostMapping
    public ResponseEntity<AssetMovement> createMovement(@RequestBody AssetMovementRequest request) {
        AssetMovement movement = new AssetMovement(
                request.getAssetId(),
                request.getMovementType(),
                request.getDateTakenOut(),
                request.getExpectedReturnDate(),
                request.getDateReturned(),
                request.getPersonTakingAsset(),
                request.getDepartment(),
                request.getPurpose(),
                request.getRemarks(),
                request.getConditionAtCheckout(),
                request.getConditionAtCheckin()
        );
        return ResponseEntity.ok(assetMovementService.createAssetMovement(movement));
    }

    // 2. 전체 이동 내역 조회 - GET
    @GetMapping
    public ResponseEntity<List<AssetMovement>> getAllMovements() {
        return ResponseEntity.ok(assetMovementService.findAllAssetMovement());
    }

    // 3. 특정 이동 ID 조회 - GET
    @GetMapping("/{movement_id}")
    public ResponseEntity<AssetMovement> getMovement(@PathVariable("movement_id") String movementId) {
        Optional<AssetMovement> movementOpt = assetMovementService.findAssetMovementById(String.valueOf(movementId));
        if (movementOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movementOpt.get());
    }

    // 4. 이동 내역 검색 - GET
    @GetMapping("/search")
    public ResponseEntity<List<AssetMovement>> searchMovements(AssetMovementSearchCondition cond) {
        return ResponseEntity.ok(assetMovementService.search(cond));
    }

    // 5. 이동 내역 수정 - PATCH
    @PatchMapping("/{movement_id}")
    public ResponseEntity<String> updateMovement(@PathVariable("movement_id") Long movementId,
                                                 @RequestBody AssetMovementRequest request) {
        AssetMovement updateMovement = new AssetMovement();
        updateMovement.setMovementId(movementId);
        updateMovement.setAssetId(request.getAssetId());
        updateMovement.setMovementType(request.getMovementType());
        updateMovement.setDateTakenOut(request.getDateTakenOut());
        updateMovement.setExpectedReturnDate(request.getExpectedReturnDate());
        updateMovement.setDateReturned(request.getDateReturned());
        updateMovement.setPersonTakingAsset(request.getPersonTakingAsset());
        updateMovement.setDepartment(request.getDepartment());
        updateMovement.setPurpose(request.getPurpose());
        updateMovement.setRemarks(request.getRemarks());
        updateMovement.setConditionAtCheckout(request.getConditionAtCheckout());
        updateMovement.setConditionAtCheckin(request.getConditionAtCheckin());

        int updatedCount = assetMovementService.updateAssetMovement(updateMovement);
        if (updatedCount == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("해당 이동 내역을 찾을 수 없거나 수정된 데이터가 없습니다.");
        }
        return ResponseEntity.ok("업데이트 성공");
    }

    // 6. 이동 내역 삭제 - DELETE
    @DeleteMapping("/{movement_id}")
    public ResponseEntity<String> deleteMovement(@PathVariable("movement_id") String movementId) {
        int deletedCount = assetMovementService.deleteAssetMovement(movementId);
        if (deletedCount == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("해당 이동 내역을 찾을 수 없습니다.");
        }
        return ResponseEntity.ok("삭제 성공");
    }
}
