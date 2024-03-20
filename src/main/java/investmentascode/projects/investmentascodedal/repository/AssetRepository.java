package investmentascode.projects.investmentascodedal.repository;

import investmentascode.projects.investmentascodedal.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Long> {
}
