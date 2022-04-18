package br.com.pagamento.core.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.pagamento.core.command.TransacaoCommand;
import br.com.pagamento.core.query.TransacaoQuery;
import br.com.pagamento.core.service.PagamentoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pagamento")
@RequiredArgsConstructor
public class PagamentoController {

	private final PagamentoService service;

	@PostMapping("/solicitarPagamento")
	@Transactional
	public ResponseEntity<TransacaoQuery> solicitarPagamento(@RequestBody TransacaoCommand transacaoCommand) {
		TransacaoQuery transacaoQuery = service.solicitarPagamento(transacaoCommand);
		return ok(transacaoQuery);
	}

	@GetMapping("/solicitacaoEstorno/{id}")
	@Transactional
	public ResponseEntity<TransacaoQuery> solicitacaoEstorno(@PathVariable String id) {
		TransacaoQuery transacaoQuery = service.solicitacaoEstorno(id);
		return ok(transacaoQuery);
	}

	@GetMapping("/findAllOrById/{id}")
	@Transactional
	public ResponseEntity<List<TransacaoQuery>> findAllOrById(@PathVariable String id) {
		List<TransacaoQuery> transacaoQuery = service.findAllOrById(id);
		return ok(transacaoQuery);
	}

}
