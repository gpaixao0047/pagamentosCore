package br.com.pagamento.core.query;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor(onConstructor_ = @Builder)
public class DescricaoQuery {
	private String valor;
	private String dataHora;
	private String estabelecimento;
	private String nsu;
	private String codigoAutorizacao;
	private String status;
}
