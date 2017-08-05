package com.turreta.springboot.trim.string.from.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SampleBean
{
	@Value("${sample.property}")
	private String sampleProperty;

	public String getSampleProperty()
	{
		return sampleProperty;
	}

	public void setSampleProperty(String sampleProperty)
	{
		this.sampleProperty = sampleProperty;
	}
}
