# pagamentosCore
Projeto API de Pagamentos.
Projeto desenvolvido utilizando SpringBoot, os 3 end points solicitados se encontram na classe PagamentoController, login e senha para requisoçoes dentro da classe SecurityConfig, parei até a parte do service onde defini os valores na mão, já que não foi solicitado persistência de dados no banco de dados.

Primeiro end point solicitarPagamento url utilizada http://localhost:8070/api/pagamento/solicitarPagamento/
Json utilizado :
{
      "cartao":"444423231234",
      "id":"1002342312",
      "descricao":{
         "valor":"500.50",
         "dataHora":"01/05/2021 18:30:00",
         "estabelecimento":"PetShop Mundo cão"
      },
      "formaPagamento":{
         "tipo":"AVISTA",
         "parcelas":"1"
      }
}

End point Estorno:
http://localhost:8070/api/pagamento/solicitacaoEstorno/15

End point Consulta:
http://localhost:8070/api/pagamento/findAllOrById/15
