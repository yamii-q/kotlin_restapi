//package com.example.kotlin_restapi.config
//
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.core.Ordered
//import org.springframework.web.cors.CorsConfiguration
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource
//import org.springframework.web.filter.CorsFilter
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
//
//@Configuration
//class WebMvcConfig : WebMvcConfigurer {
//
//    @Bean
//    fun corsFilter(): FilterRegistrationBean<CorsFilter> {
//        val source = UrlBasedCorsConfigurationSource()
//        val config = CorsConfiguration()
//        config.addAllowedOrigin(CorsConfiguration.ALL)
//        config.addAllowedHeader(CorsConfiguration.ALL)
//        config.addAllowedMethod(CorsConfiguration.ALL)
//        source.registerCorsConfiguration("/**", config)
//        val bean = FilterRegistrationBean(CorsFilter(source))
//        bean.order = Ordered.HIGHEST_PRECEDENCE
//        return bean
//    }
//}