package com.mx.rolland.rickmorty.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Info {
	private Integer count;
	private Integer pages;
	private String next;
	private String prev;
}
