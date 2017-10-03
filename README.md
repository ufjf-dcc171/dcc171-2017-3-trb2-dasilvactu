Primeiro Trabalho de Laboratório de Programação 3

Marcus Vinicius da Silva - 201365178C - Ciência da Computação

Descrição do Sistema: O sistema foi desenvolvido tendo em vista o funcionamento de uma lanchonete, onde existem Mesas, Pedidos e Itens. As mesas são identificadas por um número e contém uma lista de Pedidos. Cada Pedido contém um número de identificação, uma lista de Itens, a data de sua abertura e fechamento, um identificador de status(se está aberto ou fechado) e o seu valor total. Cada item contém um nome, uma quantidade e um preço associado.
O sistema permite que seja feito cadastro de mesas, pedidos e itens. O cadastro de um pedido deve estar associado a uma mesa e a inserção de um item deve estar associada a um pedido. Pedidos que estão fechados não permitem inclusao, edição ou exclusão de itens.

Modelo de Dados: O diagrama de classes pode ser visualizado na pasta raiz do projeto.

Telas: O sistema é composto de duas telas: Uma para cadastro e visualização de mesas e pedidos(Janela Mesas) e outra para edição de Pedidos e visualização de Itens(Janela Pedidos).

	-Janela Mesas. Funcionalidades:Criação de Mesas, Criação de Pedidos, Edição de Pedidos, Fechamento de Pedidos
		
	-Janela Pedido. Funcionalidades: Salvar Dados, Excluir Item, Visualizar Itens do Pedido

Funcionamento do sistema: O sistema utiliza listas para exibição dos dados em componentes JScrollPane, onde cada ListModel foi implementado separadamente. Na tela de visualização das mesas e pedidos foram usados dois componentes JScrolPane, um para mesas e outro para pedidos. Para a exibição dos detalhes do pedido foi utilizado um componente JTextArea, configurado para não permitir edição. Na janela de itens, foi utilizado um compontente JScrolPane para a exibição de todos os itens de um Pedido. Nesta janela existem campos do tipo texto que podem ser utilizados para editar um item ou adicionar um item novo.

Dificuldades de implementação: Como todos os conceitos foram vistos em sala de aula, não houve muita dificuldade de implementação. Um ponto central que foi descoberto nesse trabalho é a passagem de uma instância de Janela para o construtor de outra janela (utilizando um objeto Classe.this), coisa que não foi feita dentro de sala. 
 
	


