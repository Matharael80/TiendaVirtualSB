package com.BO.TiendaVirtualSB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class TiendaVirtualSbApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaVirtualSbApplication.class, args);
	}

}
