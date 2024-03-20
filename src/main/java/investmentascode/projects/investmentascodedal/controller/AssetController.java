package investmentascode.projects.investmentascodedal.controller;


import investmentascode.projects.investmentascodedal.model.Asset;
import investmentascode.projects.investmentascodedal.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
  public List<Asset> getAllAssets(){
    return assetRepository.findAll();
  }
}
