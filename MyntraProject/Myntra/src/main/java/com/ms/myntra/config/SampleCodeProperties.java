package com.ms.myntra.config;

import java.time.Duration;
import java.time.temporal.ChronoUnit;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

@Validated
@Configuration
@ConfigurationProperties("downstream")

public class SampleCodeProperties {
	
	private static final Duration DEFAULT_READ_TIMEOUT_SECONDS = Duration.ofSeconds(25);
	
	private static final Duration DEFAULT_CONNECTION_TIMEOUT_SECONDS = Duration.ofSeconds(5);

	private Sample sample;
	
	public Sample create()
	{
		return new Sample();
	}
	
	public Sample getSample() {
		return sample;
	}

	public void setSample(Sample sample) {
		this.sample = sample; 
	}


	public static class Sample{ 
		
		private String posturl;
		
		private String geturl;
		
		private String patchurl;
		
		private String deleteurl;
		

	
		public String getPosturl() {
			return posturl;
		}

		public void setPosturl(String posturl) {
			this.posturl = posturl;
		}

		public String getGeturl() {
			return geturl;
		}

		public void setGeturl(String geturl) {
			this.geturl = geturl;
		}

		public String getPatchurl() {
			return patchurl;
		}

		public void setPatchurl(String patchurl) {
			this.patchurl = patchurl;
		}

		public String getDeleteurl() {
			return deleteurl;
		}

		public void setDeleteurl(String deleteurl) {
			this.deleteurl = deleteurl;
		}

		public Duration getReadTimeoutSecounds() {
			return readTimeoutSecounds;
		}

		public void setReadTimeoutSecounds(Duration readTimeoutSecounds) {
			this.readTimeoutSecounds = readTimeoutSecounds;
		}

		public Duration getConnectionTimeoutSeconds() {
			return connectionTimeoutSeconds;
		}

		public void setConnectionTimeoutSeconds(Duration connectionTimeoutSeconds) {
			this.connectionTimeoutSeconds = connectionTimeoutSeconds;
		}

		@DurationUnit(ChronoUnit.SECONDS)
		private Duration readTimeoutSecounds = DEFAULT_READ_TIMEOUT_SECONDS;
		
		@DurationUnit(ChronoUnit.SECONDS)
        private Duration connectionTimeoutSeconds = DEFAULT_CONNECTION_TIMEOUT_SECONDS;

	

		
		
	}

}
