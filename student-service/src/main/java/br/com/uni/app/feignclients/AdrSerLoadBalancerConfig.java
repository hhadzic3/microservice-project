/*
 * package br.com.uni.app.feignclients;
 * 
 * import org.springframework.cloud.client.loadbalancer.LoadBalanced; import
 * org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient; import
 * org.springframework.context.annotation.Bean;
 * 
 * import feign.Feign;
 * 
 * @LoadBalancerClient(value = "address-service") public class
 * AdrSerLoadBalancerConfig {
 * 
 * @LoadBalanced
 * 
 * @Bean public Feign.Builder feignBuilder(){ return Feign.builder(); }
 * 
 * }
 */