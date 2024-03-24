package investmentascode.projects.investmentascodedal.repository;

import investmentascode.projects.investmentascodedal.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {
    List<Stock> findByAssetId(Long assetId);
}
