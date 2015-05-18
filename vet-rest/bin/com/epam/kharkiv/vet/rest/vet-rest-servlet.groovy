beans {
    xmlns([mvc:'http://www.springframework.org/schema/mvc',ctx:'http://www.springframework.org/schema/context'])
    mvc.'annotation-driven'()
    ctx.'component-scan'('base-package':'com.epam.kharkiv.vet.rest')
    jsp(org.springframework.web.servlet.view.InternalResourceViewResolver) {
        prefix = '/WEB-INF/view/'
        suffix = '.jsp'
    }
}