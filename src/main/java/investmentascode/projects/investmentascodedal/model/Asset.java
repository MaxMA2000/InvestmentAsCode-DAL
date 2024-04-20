package investmentascode.projects.investmentascodedal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Asset {

  @Id
  private Long assetId;
  private String symbol;
  private String name;
  private String exchange;
  private String exchangeShortName;
  private String type;
  private Date asOfDate;

  // Constructors, getters, and setters - created by lombok

}
