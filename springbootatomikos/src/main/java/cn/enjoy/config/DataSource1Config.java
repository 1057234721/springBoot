package cn.enjoy.config;

import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = "cn.enjoy.dao.users", sqlSessionFactoryRef = "test1SqlSessionFactory")
public class DataSource1Config {
//    @Bean(name = "test1DataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.spring")
//    @Primary
//    public DataSource testDataSource() {
//        return DataSourceBuilder.create().build();
//    }

    @Bean(name = "test1SqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test1DataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
         bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/users/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "test1DataSource")
    @Primary
    public DataSource testDataSource(DBConfig1 config1) {
        MysqlXADataSource mysqlXADataSource=new MysqlXADataSource();
        mysqlXADataSource.setUrl(config1.getJdbcUrl());
        mysqlXADataSource.setPassword(config1.getPassword());
        mysqlXADataSource.setUser(config1.getUsername());

        AtomikosDataSourceBean atomikosDataSourceBean=new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("test1Datasource");
        return atomikosDataSourceBean;

    }


//    @Bean(name = "test1TransactionManager")
//    @Primary
//    public DataSourceTransactionManager testTransactionManager(@Qualifier("test1DataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }

    @Bean(name = "test1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}