package investmentascode.projects.investmentascodedal.controller;


import investmentascode.projects.investmentascodedal.model.Crypto;
import investmentascode.projects.investmentascodedal.repository.CryptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data/v1/crypto")
public class CryptoController {

  private final CryptoRepository cryptoRepository;

  @Autowired
  public CryptoController(CryptoRepository cryptoRepository) {
    this.cryptoRepository = cryptoRepository;
  }

  @GetMapping
  public List<Crypto> getAllCryptos() {
    return cryptoRepository.findAll();
  }




}
