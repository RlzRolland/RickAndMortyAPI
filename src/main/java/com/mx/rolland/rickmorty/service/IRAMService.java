package com.mx.rolland.rickmorty.service;

import java.util.List;

import com.mx.rolland.rickmorty.models.Characters;
import com.mx.rolland.rickmorty.models.Results;

public interface IRAMService {

	public Characters getAllCharactersRAM();
	
	public Characters getCharacterParam(Integer page);
	
	public Results getCharacterById(Integer id);
	
	public List<Results> getMultipleCharacters(Integer[] ids);
}
