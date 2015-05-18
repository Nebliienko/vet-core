beans{
    xmlns(security:'http://www.springframework.org/schema/security')
    security.'global-method-security'('secured-annotations':'enabled')
    security.http('auto-config':'true'){
        security.'intercept-url'(pattern:'/login*',access:'IS_AUTHENTICATED_ANONYMOUSLY')
        security.'intercept-url'(pattern:'/visitations/**',access:'ROLE_USER')
        security.'form-login'(
        'default-target-url':'/pet/get')
        security.'logout'('logout-success-url':'/pet/get')
    }
    security.'authentication-manager'{
        security.'authentication-provider'{
            security.'user-service'{
                security.user(name:'admin', password:'admin', authorities:'ROLE_USER')
                security.user(name:'user', password:'user', authorities:'ROLE_USER')
            }
            security.'jdbc-user-service'('data-source-ref':'dataSource')
        }
    }
}