package investmentascode.projects.investmentascodedal.repository;

import investmentascode.projects.investmentascodedal.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetRepository extends JpaRepository<Asset, Long> {
    List<Asset> findByType(String value);
}
