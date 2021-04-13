package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public enum DataSourceServices {

    INSTANSE;

    private final String CONFIG_NAME = "/db.properties";
    private HikariConfig config;
    private HikariDataSource dataSource;

    DataSourceServices() {
        this.config = new HikariConfig(DataSourceServices.class.getResource(CONFIG_NAME).getPath());
        this.dataSource = new HikariDataSource(config);
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void close() {
        dataSource.close();
    }
}
