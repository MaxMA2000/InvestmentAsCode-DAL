package investmentascode.projects.investmentascodedal.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class AppNameController {

  @GetMapping
  public String appName(){
    return "Application Name: InvestmentAsCode-DAL";
  }

}

