package br.com.pagamento.core.query;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(onConstructor_ = @Builder)
public class TransacaoQuery {
	private String id;
	private String cartao;
	private DescricaoQuery descricao;
	private FormaPagamentoQuery formaPagamento;
}
