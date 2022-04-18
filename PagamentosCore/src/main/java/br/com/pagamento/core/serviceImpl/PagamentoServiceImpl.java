package br.com.pagamento.core.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pagamento.core.command.TransacaoCommand;
import br.com.pagamento.core.factory.PagamentoFactory;
import br.com.pagamento.core.query.DescricaoQuery;
import br.com.pagamento.core.query.FormaPagamentoQuery;
import br.com.pagamento.core.query.TransacaoQuery;
import br.com.pagamento.core.service.PagamentoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PagamentoServiceImpl implements PagamentoService {

	@Override
	public TransacaoQuery solicitarPagamento(TransacaoCommand transacaoCommand) {
		TransacaoQuery transacaoQuery = PagamentoFactory.makeTransacaoCommandToQuery(transacaoCommand);
		transacaoQuery = setValoresPagamento(transacaoQuery);
		return transacaoQuery;
	}

	@Override
	public TransacaoQuery solicitacaoEstorno(String id) {
		return solicitacaoEstornoById(id);
	}

	@Override
	public List<TransacaoQuery> findAllOrById(String id) {
		List<TransacaoQuery> listTransacaoQuery = new ArrayList<TransacaoQuery>();
		if (id.isEmpty()) {
			listTransacaoQuery = findAll();
		} else {
			listTransacaoQuery = findById(id);
		}
		return listTransacaoQuery;
	}

	private TransacaoQuery setValoresPagamento(TransacaoQuery transacaoQuery) {
		DescricaoQuery descricaoQuery = transacaoQuery.getDescricao();
		descricaoQuery.setNsu("123456789");
		descricaoQuery.setCodigoAutorizacao("12334654645");
		descricaoQuery.setStatus("AUTORIZADO");
		transacaoQuery.setDescricao(descricaoQuery);
		return transacaoQuery;
	}

	private TransacaoQuery solicitacaoEstornoById(String id) {
		TransacaoQuery transacaoQuery = new TransacaoQuery();
		transacaoQuery.setId(id);
		transacaoQuery.setCartao("1233****432");
		transacaoQuery.setDescricao(makeDescricaoQuery());
		transacaoQuery.setFormaPagamento(makeFormaPagamentoQuery());
		return transacaoQuery;
	}

	private DescricaoQuery makeDescricaoQuery() {
		DescricaoQuery descricaoQuery = new DescricaoQuery();
		descricaoQuery.setValor("500.50");
		descricaoQuery.setDataHora("01/05/2021 18:30:00");
		descricaoQuery.setEstabelecimento("PetShop Mundo cão");
		descricaoQuery.setNsu("123456789");
		descricaoQuery.setCodigoAutorizacao("12334654645");
		descricaoQuery.setStatus("CANCELADO");
		return descricaoQuery;
	}

	private FormaPagamentoQuery makeFormaPagamentoQuery() {
		FormaPagamentoQuery formaPagamentoQuery = new FormaPagamentoQuery();
		formaPagamentoQuery.setTipo("AVISTA");
		formaPagamentoQuery.setParcelas("1");
		return formaPagamentoQuery;
	}

	private List<TransacaoQuery> findById(String id) {
		List<TransacaoQuery> listTransacaoQuery = new ArrayList<TransacaoQuery>();
		TransacaoQuery transacaoQuery = new TransacaoQuery();
		transacaoQuery.setId(id);
		transacaoQuery.setCartao("1233****432");
		transacaoQuery.setDescricao(makeDescricaoQuery());
		transacaoQuery.setFormaPagamento(makeFormaPagamentoQuery());
		listTransacaoQuery.add(transacaoQuery);
		return listTransacaoQuery;
	}

	private List<TransacaoQuery> findAll() {
		List<TransacaoQuery> listTransacaoQuery = new ArrayList<TransacaoQuery>();
		TransacaoQuery transacaoQuery = new TransacaoQuery();
		transacaoQuery.setId("12323");
		transacaoQuery.setCartao("1233****432");
		transacaoQuery.setDescricao(makeDescricaoQuery());
		transacaoQuery.setFormaPagamento(makeFormaPagamentoQuery());
		listTransacaoQuery.add(transacaoQuery);
		listTransacaoQuery.add(transacaoQuery);
		return listTransacaoQuery;
	}

}
