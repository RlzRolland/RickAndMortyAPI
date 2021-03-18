package com.mx.rolland.rickmorty.models;

import java.util.Date;
import java.util.List;

import lombok.Getter;

@Getter
public class Results {
	private Integer id;
	private String name;
	private String status;
	private String species;
	private String type;
	private String gender;
	private OriginLocation origin;
	private OriginLocation location;
	private String image;
	private List<String> episode;
	private String url;
	private Date created;
}
