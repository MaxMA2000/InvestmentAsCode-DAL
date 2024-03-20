package investmentascode.projects.investmentascodedal.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Stock {

  @Id
  private Long assetId;
  private String symbol;
  private Date date;
  private BigDecimal open;
  private BigDecimal high;
  private BigDecimal low;
  private BigDecimal close;
  private BigDecimal adjClose;
  private Integer volume;
  private Integer unadjustedVolume;
  private BigDecimal change;
  private BigDecimal changePercent;
  private Float vwap;
  private String label;
  private Float changeOverTime;
  private Date asOfDate;

//  @OneToOne
//  @JoinColumn(name = "asset_id")
//  private Asset asset;

  // Constructors, getters, and setters - created by Lombok

}
