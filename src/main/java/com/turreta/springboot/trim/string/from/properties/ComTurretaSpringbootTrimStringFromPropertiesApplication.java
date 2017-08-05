package com.turreta.springboot.trim.string.from.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.StandardEnvironment;

@SpringBootApplication
public class ComTurretaSpringbootTrimStringFromPropertiesApplication {

	public static void main(String[] args) {
//		ApplicationContext context = SpringApplication.run(ComTurretaSpringbootTrimStringFromPropertiesApplication.class, args);
//
//		SampleBean sb = context.getBean(SampleBean.class);
//		System.out.println(String.format("String value: [%s]", sb.getSampleProperty()));
//		System.out.println(String.format("String value length: [%d]",sb.getSampleProperty().length()));


		StandardEnvironment std = new StandardEnvironment() {
			@Override
			public String getProperty(String key)
			{
				String tmp = super.getProperty(key);
				if(tmp != null) {
					tmp = tmp.trim();
				}
				return tmp;
			}

			@Override
			public String getProperty(String key, String defaultValue)
			{
				String tmp = super.getProperty(key, defaultValue);
				if(tmp != null) {
					tmp = tmp.trim();
				}
				return tmp;
			}
		};

		SpringApplicationBuilder builder = new SpringApplicationBuilder(
				ComTurretaSpringbootTrimStringFromPropertiesApplication.class).environment(std);

		ApplicationContext ctxtFromBuilder = builder.run(args);
		SampleBean sb = ctxtFromBuilder.getBean(SampleBean.class);
		System.out.println(String.format("String value: [%s]", sb.getSampleProperty()));
		System.out.println(String.format("String value length: [%d]",sb.getSampleProperty().length()));
	}
}
