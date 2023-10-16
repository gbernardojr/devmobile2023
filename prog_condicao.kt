fun main(Args : list){
  Print("Digite o primeiro número: ")
  var xNumero1 = Readln()
  Print("Digite o primeiro número: ")
  var xNumero2 = Readln()

  Print("Escolha: 1-Somar, 2-Subtrair, 3-Multiplicar, 4-Dividir)
  var xEscolha = readln()

  var xResultado = 0.0
  if (xEscolha = 1){
    xResultado = xNumero1 + xNumero2
  } else if (xEscolha = 2){
    xResultado = xNumero1 - xNumero2
  } else if (xEscolha = 3){
    xResultado = xNumero1 * xNumero2
  } else if (xEscolha = 4){
    xResultado = xNumero1 / xNumero2
  } else {
    Println("Opção Inválida")
  }
  Println("Resultado da Operação = $xResultado")
}
