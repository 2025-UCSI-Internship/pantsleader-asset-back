package test.jytest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.jytest.asset.AssetService;
import test.jytest.assetMovement.AssetMovementService;
import test.jytest.repository.AssetMovementRepository;
import test.jytest.repository.AssetRepository;
import test.jytest.repository.jdbctemplate.JdbcTemplateAssetMovementRepository;
import test.jytest.repository.jdbctemplate.JdbcTemplateAssetRepository;

import javax.sql.DataSource;

@Configuration
public class JdbcTemplateConfig {

    private final DataSource dataSource;

    public JdbcTemplateConfig(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public AssetRepository assetRepository() {
        return new JdbcTemplateAssetRepository(dataSource);
    }

    @Bean
    public AssetService assetService() {
        return new AssetService(assetRepository());
    }

    @Bean
    public AssetMovementRepository assetMovementRepository() {
        return new JdbcTemplateAssetMovementRepository(dataSource);
    }

    @Bean
    public AssetMovementService assetMovementService() {
        return new AssetMovementService(assetMovementRepository());
    }



}
