package investmentascode.projects.investmentascodedal.controller;


import investmentascode.projects.investmentascodedal.model.Asset;
import investmentascode.projects.investmentascodedal.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data/v1/asset")
public class AssetController {

  private final AssetRepository assetRepository;

  @Autowired
  public AssetController(AssetRepository assetRepository) {
    this.assetRepository = assetRepository;
  }

  @GetMapping
  public List<Asset> getAllAssets() {
    return assetRepository.findAll();
  }

  @GetMapping("/byType")
  public ResponseEntity<?> getAssetsByType(@RequestParam("type") String type) {
    List<Asset> assets = assetRepository.findByType(type);

    if (assets.isEmpty()) {
      String errorMessage = "Type " + type + " doesn't exist. Please check.";
      ErrorResponse errorResponse = new ErrorResponse(errorMessage);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    return ResponseEntity.ok(assets);
  }


  private static class ErrorResponse {
    private final String message;

    public ErrorResponse(String message) {
      this.message = message;
    }

    public String getMessage() {
      return message;
    }
  }


}

