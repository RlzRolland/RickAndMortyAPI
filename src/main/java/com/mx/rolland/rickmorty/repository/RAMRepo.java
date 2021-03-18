package com.mx.rolland.rickmorty.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mx.rolland.rickmorty.models.Characters;
import com.mx.rolland.rickmorty.models.Results;

@Component
public class RAMRepo {
	
	private final String CHARACTERS = "https://rickandmortyapi.com/api/character";
	private final String LOCATIONS = "https://rickandmortyapi.com/api/location";
	private final String EPISODES = "https://rickandmortyapi.com/api/episode";
	
	RestTemplate rest = new RestTemplate();
	HttpHeaders headers = new HttpHeaders();
	
	public Characters getAllCharacters() {
		
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		ResponseEntity<Characters> response = rest.exchange(CHARACTERS, HttpMethod.GET, 
				entity, Characters.class);
				
		return response.getBody();
	}
	
	public Characters getCharactersParam(Integer page) {
		
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		ResponseEntity<Characters> response = rest.exchange(CHARACTERS + "/?page=" + String.valueOf(page),
				HttpMethod.GET, entity, Characters.class);
		
		return response.getBody();
	}
	
	public Results getSingleCharacter(Integer id) {
		
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		ResponseEntity<Results> response = rest.exchange(CHARACTERS + "/" + id, 
				HttpMethod.GET, entity, Results.class);
		
		return response.getBody();
	}
	
	public List<Results> getMultipleCharacters(Integer[] ids) {
		
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		ResponseEntity<Results> response = null;
		
		List<Results> resultFull = new ArrayList<>();
		
		for (int i = 0; i < ids.length; i++) {
			try {
				response = rest.exchange(CHARACTERS + "/" + ids[i], HttpMethod.GET,
						entity, Results.class);
				resultFull.add(response.getBody());
			}
			catch (Exception ms) {
				ms.getMessage();
			}
		}
		
		return resultFull;
	}
}
