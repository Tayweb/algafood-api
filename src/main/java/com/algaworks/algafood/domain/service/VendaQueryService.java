package com.algaworks.algafood.domain.service;

import java.util.List;

import com.algaworks.algafood.domain.filter.VendaDiariaFilter;
import com.algaworks.algafood.dto.VendaDiaria;

public interface VendaQueryService {

	List<VendaDiaria>consultarVendasDiaria(VendaDiariaFilter filtro, String data);
}