package com.demojanine.dto;

import java.util.Date;

public class FilmeDTO {
	private String title;
	private Integer episode_id;
	private String opening_crawl ;
	private String director;
	private String producer;
	private Date release_date;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getEpisode_id() {
		return episode_id;
	}
	public void setEpisode_id(Integer episode_id) {
		this.episode_id = episode_id;
	}
	public String getOpening_crawl() {
		return opening_crawl;
	}
	public void setOpening_crawl(String opening_crawl) {
		this.opening_crawl = opening_crawl;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public Date getRelease_date() {
		return release_date;
	}
	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

}
