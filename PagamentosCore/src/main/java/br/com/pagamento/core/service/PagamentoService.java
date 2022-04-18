package br.com.pagamento.core.service;


import java.util.List;

import br.com.pagamento.core.command.TransacaoCommand;
import br.com.pagamento.core.query.TransacaoQuery;

public interface PagamentoService {

	TransacaoQuery solicitarPagamento(TransacaoCommand transacaoCommand);

	TransacaoQuery solicitacaoEstorno(String id);

	List<TransacaoQuery> findAllOrById(String id);

}
