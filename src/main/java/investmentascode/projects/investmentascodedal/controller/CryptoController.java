package investmentascode.projects.investmentascodedal.controller;


import investmentascode.projects.investmentascodedal.exception.SearchKeyNotFoundException;
import investmentascode.projects.investmentascodedal.model.Crypto;
import investmentascode.projects.investmentascodedal.model.Stock;
import investmentascode.projects.investmentascodedal.repository.CryptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/data/v1/crypto")
public class CryptoController {

  private final CryptoRepository cryptoRepository;

  @Autowired
  public CryptoController(CryptoRepository cryptoRepository) {
    this.cryptoRepository = cryptoRepository;
  }

  @GetMapping
  public List<Crypto> getAllCryptos() {
    return cryptoRepository.findAll();
  }


  @GetMapping("/byId")
  public ResponseEntity<?> getStocksById(@RequestParam("id") long id) {
    List<Crypto> cryptos = cryptoRepository.findByAssetId(id);
    if (cryptos.isEmpty()) {
      throw new SearchKeyNotFoundException("Asset ID " + id + " doesn't exist in Crypto Table. Please check.", HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok(cryptos);
  }

  @GetMapping("/bySymbol")
  public ResponseEntity<?> getStocksBySymbol(@RequestParam("symbol") String symbol) {
    List<Crypto> cryptos = cryptoRepository.findBySymbol(symbol);
    if (cryptos.isEmpty()) {
      throw new SearchKeyNotFoundException("Symbol " + symbol + " doesn't exist in Crypto Table. Please check.", HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok(cryptos);
  }

  @GetMapping("/byAssetIdAndDateRange")
  public ResponseEntity<?> getStocksByDateRange(
    @RequestParam(value = "asset_id", required = true) Long assetId,
    @RequestParam("from") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
    @RequestParam("to") @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate
  ) {
    List<Crypto> cryptos;
    cryptos = cryptoRepository.findAllByAssetIdAndDateBetween(assetId, fromDate, toDate);

    if (cryptos.isEmpty()) {
      throw new SearchKeyNotFoundException("No cryptos found within the specified date range.", HttpStatus.NOT_FOUND);
    }

    cryptos.sort(Comparator.comparing(Crypto::getDate));
    return ResponseEntity.ok(cryptos);
  }


}
