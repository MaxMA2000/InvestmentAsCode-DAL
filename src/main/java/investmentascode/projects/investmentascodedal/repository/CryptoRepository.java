package investmentascode.projects.investmentascodedal.repository;

import investmentascode.projects.investmentascodedal.model.Crypto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CryptoRepository extends JpaRepository<Crypto, Long> {
  List<Crypto> findByAssetId(Long assetId);

  List<Crypto> findBySymbol(String symbol);

  List<Crypto> findAllByAssetIdAndDateBetween(Long assetId, Date fromDate, Date toDate);
}
