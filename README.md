# quebraAe
Um aplicativo que utiliza criptografia para cifrar uma mensagem inicial e gera uma chave, através desta chave é possível fazer o processo inverso.
O objetivo deste algoritmo se dá a partir de uma entrada (texto claro), no qual o mesmo será convertido utilizando os parâmetros da tabela ASCII, no caso o valor decimal referente a entrada de texto. O grande diferencial se dá na métrica de avaliação, a cada caractere repetido será aplicado o método fatorial que determinará qual casa da tabela o valor chave receberá.
Etapas de funcionamento:

      *Inicialmente é feito a conversão de cada caractere da string passada (texto claro) para o decimal correspondente do mesmo na tabela ASCII.

      *Após isso é realizada uma contagem de elementos repetidos salvando as posições respectivas em um lista.

      *A captura das posições é passada para um método que calcula o fatorial de cada caractere repetido sempre incrementando em 1.

      *Será feito a soma com os valores decimais de cada elemento com seu fatorial correspondente.

      *Percorre a o intervalo da tabela ASCII de 33 até 126, até chegar no limite do valor da soma do decimal com o fatorial, assim é definido o novo caractere.

      *Novamente converte os decimais em caracteres.
