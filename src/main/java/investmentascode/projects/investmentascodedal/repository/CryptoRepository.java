package investmentascode.projects.investmentascodedal.repository;

import investmentascode.projects.investmentascodedal.model.Crypto;
import investmentascode.projects.investmentascodedal.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptoRepository extends JpaRepository<Crypto, Long> {
}
