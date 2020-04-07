package com.hyzs.essearch;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableSwagger2Doc
@SpringBootApplication
public class EsSearchApplication {

	public static void main(String[] args) {
		System.setProperty("es.set.netty.runtime.available.processors","false");
		SpringApplication.run(EsSearchApplication.class, args);
	}

}
