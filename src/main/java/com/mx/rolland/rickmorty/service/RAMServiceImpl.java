package com.mx.rolland.rickmorty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.rolland.rickmorty.models.Characters;
import com.mx.rolland.rickmorty.models.Results;
import com.mx.rolland.rickmorty.repository.RAMRepo;

@Service
public class RAMServiceImpl implements IRAMService {

	@Autowired
	RAMRepo repository;
	
	@Override
	public Characters getAllCharactersRAM() {
		return repository.getAllCharacters();
	}

	@Override
	public Characters getCharacterParam(Integer page) {
		return repository.getCharactersParam(page);
	}

	@Override
	public Results getCharacterById(Integer id) {
		return repository.getSingleCharacter(id);
	}

	@Override
	public List<Results> getMultipleCharacters(Integer[] ids) {
		return repository.getMultipleCharacters(ids);
	}
}
