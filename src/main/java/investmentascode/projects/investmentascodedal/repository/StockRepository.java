package investmentascode.projects.investmentascodedal.repository;

import investmentascode.projects.investmentascodedal.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {
  List<Stock> findByAssetId(Long assetId);

  List<Stock> findBySymbol(String symbol);

  List<Stock> findAllByAssetIdAndDateBetween(Long assetId, Date fromDate, Date toDate);

}
