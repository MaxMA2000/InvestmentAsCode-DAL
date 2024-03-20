package investmentascode.projects.investmentascodedal.controller;


import investmentascode.projects.investmentascodedal.model.Stock;
import investmentascode.projects.investmentascodedal.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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




}
