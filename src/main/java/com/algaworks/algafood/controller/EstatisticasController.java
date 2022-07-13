package com.algaworks.algafood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.controller.openapi.EstatisticasControllerOpenApi;
import com.algaworks.algafood.domain.filter.VendaDiariaFilter;
import com.algaworks.algafood.domain.service.VendaQueryService;
import com.algaworks.algafood.domain.service.VendaReportService;
import com.algaworks.algafood.dto.VendaDiaria;

@RestController
@RequestMapping(path = "/estatisticas")
public class EstatisticasController implements EstatisticasControllerOpenApi {

	@Autowired
	private VendaQueryService vendaQueryService;

	@Autowired
	private VendaReportService vendaReportService;

	@Override
	@GetMapping(path = "/vendas-diarias", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<VendaDiaria> consultarVendasDiarias(VendaDiariaFilter filtro,
			@RequestParam(required = false) String data) {
		return vendaQueryService.consultarVendasDiaria(filtro, data);
	}

	@GetMapping(path = "/vendas-diarias", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<byte[]> consultarVendasDiariasPdf(VendaDiariaFilter filtro,
			@RequestParam(required = false) String data) {

		byte[] bytesPdf = vendaReportService.emitirVendasDiarias(filtro, data);

		var headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=vendas-diarias.pdf"); /*
															 * attachment é pra informar que o pdf é pra download e não
															 * pra visualizar
															 */

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).headers(headers).body(bytesPdf);
	}
}
