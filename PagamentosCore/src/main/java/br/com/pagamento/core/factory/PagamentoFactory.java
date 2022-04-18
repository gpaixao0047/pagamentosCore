package br.com.pagamento.core.factory;

import org.modelmapper.ModelMapper;
import br.com.pagamento.core.command.TransacaoCommand;
import br.com.pagamento.core.query.TransacaoQuery;

public class PagamentoFactory {
	private PagamentoFactory() {
		
	}
	
	public static TransacaoQuery makeTransacaoCommandToQuery(TransacaoCommand transacaoCommand) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(transacaoCommand, TransacaoQuery.class);
	}
	
}
