package investmentascode.projects.investmentascodedal.controller;


import investmentascode.projects.investmentascodedal.model.Asset;
import investmentascode.projects.investmentascodedal.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
  public List<Asset> getAssetsByType(@RequestParam("type") String type) {
    return assetRepository.findByType(type);
  }


  
}

