package investmentascode.projects.investmentascodedal.controller;


import investmentascode.projects.investmentascodedal.exception.CustomException;
import investmentascode.projects.investmentascodedal.model.Asset;
import investmentascode.projects.investmentascodedal.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
      throw new CustomException("Type " + type + " doesn't exist. Please check.");
    }

    return ResponseEntity.ok(assets);
  }


}

