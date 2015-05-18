beans {
    importBeans('classpath:com/epam/kharkiv/vet/repository/db-config.groovy')
    importBeans('classpath:com/epam/kharkiv/vet/service/service-config.groovy')
    importBeans('classpath:com/epam/kharkiv/vet/rest/security-context.groovy')
    messageSource(org.springframework.context.support.ResourceBundleMessageSource) {
        basename = 'message'
    }
}