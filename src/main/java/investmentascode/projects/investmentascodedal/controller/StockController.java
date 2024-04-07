package investmentascode.projects.investmentascodedal.controller;

import investmentascode.projects.investmentascodedal.exception.SearchKeyNotFoundException;
import investmentascode.projects.investmentascodedal.model.Stock;
import investmentascode.projects.investmentascodedal.repository.StockRepository;
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
      throw new SearchKeyNotFoundException("Asset ID " + id + " doesn't exist. Please check.", HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok(stocks);
  }

  @GetMapping("/bySymbol")
  public ResponseEntity<?> getStocksBySymbol(@RequestParam("symbol") String symbol) {
    List<Stock> stocks = stockRepository.findBySymbol(symbol);
    if (stocks.isEmpty()) {
      throw new SearchKeyNotFoundException("Symbol " + symbol + " doesn't exist. Please check.", HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok(stocks);
  }

  @GetMapping("/byAssetIdAndDateRange")
  public ResponseEntity<?> getStocksByDateRange(
    @RequestParam(value = "asset_id", required = true) Long assetId,
    @RequestParam("from") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
    @RequestParam("to") @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate
  ) {
    List<Stock> stocks;
    stocks = stockRepository.findAllByAssetIdAndDateBetween(assetId, fromDate, toDate);

    if (stocks.isEmpty()) {
      throw new SearchKeyNotFoundException("No stocks found within the specified date range.", HttpStatus.NOT_FOUND);
    }

    stocks.sort(Comparator.comparing(Stock::getDate));
    return ResponseEntity.ok(stocks);
  }
}

