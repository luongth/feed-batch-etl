/*
 * Copyright 2016 Thuan Anh Luong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package solutions.tal.datasource;

import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author Thuan Luong
 */
@Component
@ConfigurationProperties(prefix = "datasource")
public class ConnectionSettings {

    private String driver;

    private String url;

    private String username;

    private String password;

    private boolean autoCommit;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAutoCommit() {
        return autoCommit;
    }

    public void setAutoCommit(boolean autoCommit) {
        this.autoCommit = autoCommit;
    }

    public DataSource createDataSource() {
        PoolProperties poolProperties = new PoolProperties();
        poolProperties.setDriverClassName(this.driver);
        poolProperties.setUrl(this.url);
        poolProperties.setUsername(this.username);
        poolProperties.setPassword(this.password);
        poolProperties.setDefaultAutoCommit(this.autoCommit);
        return new org.apache.tomcat.jdbc.pool.DataSource(poolProperties);
    }
}
