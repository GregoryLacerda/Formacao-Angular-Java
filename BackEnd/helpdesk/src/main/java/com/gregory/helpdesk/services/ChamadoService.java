package com.gregory.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gregory.helpdesk.domain.Chamado;
import com.gregory.helpdesk.repositories.ChamadoRepository;
import com.gregory.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class ChamadoService {
	
	@Autowired
	private ChamadoRepository repositry;
	
	public Chamado findById(Integer id) {
		
		Optional<Chamado> obj = repositry.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado id: " + id));
	}
	
}
