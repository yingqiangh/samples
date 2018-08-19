package com.meilicd;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrix
public class UserApiApplication {
	@Bean(name = "hystrixRegistrationBean")
	public ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean registration = new ServletRegistrationBean(
				new HystrixMetricsStreamServlet(), "/hystrix.stream");
		registration.setName("hystrixServlet");
		registration.setLoadOnStartup(1);
		return registration;
	}
	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}
}
