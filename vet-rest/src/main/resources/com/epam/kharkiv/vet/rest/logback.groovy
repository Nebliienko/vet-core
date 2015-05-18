context.name = "vet-rest"

appender("FILE", RollingFileAppender) {
    file = "logs/vet-rest.log"
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "logs/vet-rest.log.%d.gz"
        maxHistory = 30
    }
    encoder(PatternLayoutEncoder) {
        pattern = "%date{yyyy-MM-dd HH:mm:ss.SSS} %-5level [%thread] [%mdc] %logger{44}:%line - %message%n"
    }
}

appender("CONSOLE", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%date{yyyy-MM-dd HH:mm:ss.SSS} %-5level [%thread] [%mdc] %logger{44}:%line - %message%n"
        outputPatternAsHeader = true
    }
}

logger("org.springframework", INFO, [], false)
logger("o.m.spring", INFO, [], false)

logger("org.apache", INFO, [], false)

logger("com.epam.kharkiv.vet", DEBUG)

root(INFO, ["CONSOLE", "FILE"])