package investmentascode.projects.investmentascodedal.controller;


import investmentascode.projects.investmentascodedal.exception.CustomException;
import investmentascode.projects.investmentascodedal.model.Stock;
import investmentascode.projects.investmentascodedal.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/data/v1/stock")
public class StockController {

  private final StockRepository stockRepository;

  @Autowired
  public StockController(StockRepository stockRepository) {
    this.stockRepository = stockRepository;
  }

  @GetMapping
  public List<Stock> getAllStocks() {
    return stockRepository.findAll();
  }

  @GetMapping("/byId")
  public ResponseEntity<?> getStocksById(@RequestParam("id") long id) {
    List<Stock> stocks = stockRepository.findByAssetId(id);
    if (stocks.isEmpty()) {
      throw new CustomException("ID " + id + " doesn't exist. Please check.");
    }
    return ResponseEntity.ok(stocks);
  }


}
