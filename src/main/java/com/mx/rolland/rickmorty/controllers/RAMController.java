package com.mx.rolland.rickmorty.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.rolland.rickmorty.models.Characters;
import com.mx.rolland.rickmorty.models.Results;
import com.mx.rolland.rickmorty.service.IRAMService;

@RestController
@RequestMapping("/rickmorty")
public class RAMController {

	@Autowired
	IRAMService service;
	
	@GetMapping("/getAllCharacters")
	public ResponseEntity<Characters> getCharacters() {
		Characters characters = service.getAllCharactersRAM();
		return new ResponseEntity<>(characters, HttpStatus.OK);
	}
	
	@GetMapping("/getCharacterParam")
	public ResponseEntity<Characters> getCharacterParam(@RequestParam(defaultValue = "1") Integer page) {
		Characters characters = service.getCharacterParam(page);
		return new ResponseEntity<>(characters, HttpStatus.OK);
	}
	
	@GetMapping("/getCharacterById/{id}")
	public ResponseEntity<Results> getCharacterById(@PathVariable Integer id) {
		Results characterInfo = service.getCharacterById(id);
		return new ResponseEntity<>(characterInfo, HttpStatus.OK);
	}
	
	@GetMapping("/getMultipleCharacters/{ids}")
	public List<Results> getMultipleCharacters(@PathVariable Integer[] ids) {
		return service.getMultipleCharacters(ids);
	}
}
