package com.bitc.springteamproject1209.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.sql.DataSource;

// @Configuration : 해당 파일이 스프링 프로젝트 설정 파일임을 나타내는 어노테이션
@Configuration
// @PropertySource : 지정한 파일에서 설정 내용을 가져오는 어노테이션
// classpath:/ : resource 폴더를 의미함
@PropertySource("classpath:/application.properties")
public class DatabaseConfiguration {
  @Autowired
  private ApplicationContext applicationContext;

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource.hikari")
  public HikariConfig hikariConfig() {
    return new HikariConfig();
  }

  @Bean
  public DataSource dataSource() throws Exception {
    DataSource dataSource = new HikariDataSource(hikariConfig());
    System.out.println(dataSource.toString());
    return dataSource;
  }

  @Bean
  public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource);

//        주의! Location이 아니라 Locations 임, getResources 도 마찬가지로 getResource 아님
    // 스프링에서 별 두개(**)는 모든 파일/모든 폴더 등, 모든! 을 뜻함.
    // sql-*.xml는  sql-아무 파일명.xml 형식에 맞는 파일을 들고옴
    sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/sql-*.xml"));
    sqlSessionFactoryBean.setConfiguration(mybatisConfig());

    return sqlSessionFactoryBean.getObject();
  }

  @Bean
  public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
    return new SqlSessionTemplate(sqlSessionFactory);
  }

  @Bean
  @ConfigurationProperties(prefix = "mybatis.configuration")
  public org.apache.ibatis.session.Configuration mybatisConfig() {
    return new org.apache.ibatis.session.Configuration();
  }


}
