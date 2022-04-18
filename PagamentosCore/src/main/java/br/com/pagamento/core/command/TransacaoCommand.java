package br.com.pagamento.core.command;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(onConstructor_ = @Builder)
public class TransacaoCommand {
	private String cartao;
	private String id;
	private DescricaoCommand descricao;
	private FormaPagamentoCommand formaPagamento;
}
