# InvestmentAsCode-DAL

DAL (Data-Access-Layer) is a centric Springboot Application, providing API functionability to proceed data-related operations with database, currently this is the only MicroService directly interacting with database in *InvestmentAsCode* project, other MiroServices all need to interact with DAL to process data.


Click [here for checking Master InvestmentAsCode Repository](https://github.com/MaxMA2000/InvestmentAsCode)


## Installation
- Suggest to download **Java Version 21** and **JDK 17+**
- Below dependencies are definied in `pom.xml` [file](./pom.xml) with Maven, you can directly use Maven with downloaded `pom.xml` to prepare all dependencies
- DAL is developed using Java **Springboot** Application, with version below:
```xml
  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.2.3</version>
    <relativePath/> 
  </parent>
```
- Key Springboot Dependencies:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.30</version>
    <scope>provided</scope>
</dependency>
<!-- https://mvnrepository.com/artifact/org.postgresql/postgresql -->
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.3</version>
</dependency>
```


## Usage
- After installing dependencies, you need to make sure you have started the **PostgreSQL** from [AssetFlowPlatform](https://github.com/MaxMA2000/InvestmentAsCode-AssetFlowPlatform)
- Then config your "src/main/resources/application.properties" with your PostgreSQL credentials
- Similar to standard Springboot Applications, you can use **Intellij IDEA** to start running application directly
- Or you can use below commands:
    * Run application: `./mvnw spring-boot:run`


## Features
- `Assets`
    |API Endpoint |Type  |Details   |
    |---|---|---|
    |`/data/v1/asset`|`GET`|Get all assets from "Asset" Table|
    |`/data/v1/asset/byId?id=`|`GET`|Get one asset from "Asset" Table filtered by id|
    |`/data/v1/asset/byType?type=`|`GET`|Get list of asset from "Asset" Table filtered by type|
    |`/data/v1/asset/bySymbol?symbol=`|`GET`|Get list of asset from "Asset" Table filtered by symbol|
- `Stock`
    |API Endpoint |Type  |Details   |
    |---|---|---|
    |`/data/v1/stock`|`GET`|Get all stock prices data from "Stock" Table|
    |`/data/v1/stock/byAssetId?asset_id=`|`GET`|Get one stock prices data for a given asset_id|
    |`/data/v1/stock/bySymbol?symbol=`|`GET`|Get one stock prices data for a given stock symbol|
- `Crypto`
    |API Endpoint |Type  |Details   |
    |---|---|---|
    |`/data/v1/stock`|`GET`|Get all stock prices data from "Stock" Table|
    |`/data/v1/stock/byAssetId?asset_id=`|`GET`|Get one stock prices data for a given asset_id|
    |`/data/v1/stock/bySymbol?symbol=`|`GET`|Get one stock prices data for a given stock symbol|



## Documentation

DAL uses `JPA` to interact with database, by creating 
- repository (*src/main/java/investmentascode/projects/investmentascodedal/repository*) 
- model (*src/main/java/investmentascode/projects/investmentascodedal/model*)

and use it with 
- controllers (*src/main/java/investmentascode/projects/investmentascodedal/controller*)

Within repository / model / controllers, there are "Assets", "Crypto", "Stock" files used to create application together.