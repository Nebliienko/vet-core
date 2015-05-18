beans {
    xmlns([jdbc:'http://www.springframework.org/schema/jdbc',ctx:'http://www.springframework.org/schema/context'])

    ctx.'component-scan'('base-package':'com.epam.kharkiv.vet.repository')

    jdbc.'embedded-database'(id:'dataSource', type:'H2')
    transactionManager(org.springframework.jdbc.datasource.DataSourceTransactionManager){ dataSource = dataSource  }

    sqlSessionFactory(org.mybatis.spring.SqlSessionFactoryBean){
        dataSource = dataSource
        configLocation = "classpath:com/epam/kharkiv/vet/repository/mybatis/mybatis-config.xml"
    }

    sqlTempate(org.mybatis.spring.SqlSessionTemplate, sqlSessionFactory)

    liquibase(liquibase.integration.spring.SpringLiquibase) {
        dataSource = dataSource
        changeLog = "classpath:com/epam/kharkiv/vet/liquibase/main-changelog.groovy"
    }
    
    dataLiquibase(liquibase.integration.spring.SpringLiquibase) {
        dataSource = dataSource
        changeLog = "classpath:com/epam/kharkiv/vet/liquibase/data-changelog.groovy"
    }
}
