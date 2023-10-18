fun main(){
    
    // cria a variável de saida e atribui falso para ela
    var saida = false
  
    // loop para manter o programa rodando 
    while (saida == false){
    
        // solicita um número para calcular a tabuada
        print("Digite o numero da tabuada: ")
    	var base = readln().toInt()
    
        //zera o contador e cria o loop para contar de 0 a 10
        var contador = 1
    	while (contador <= 10){
      		print("$base X $contador = ")
      		println(base*contador)
      		
            // incrementa o contador em uma unidade
            contador = contador + 1
    	} // fim do loop que monta a tabuada
    
        // pergunta se será feita outra tabuada
        print("Calcular outra tabuada? S/N: ")
    	var resposta = readln()

    	// verifica se o usuário respondeu que não quer calcular outra tabuada
        if (resposta == "N"){
      		saida = true
    } // fim do loop que mantem o programa rodando
  }
}
