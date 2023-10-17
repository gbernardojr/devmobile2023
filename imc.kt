fun main(args: Array<String>){

  // solicitando que o usuário digite algumas informações
  println("Qual é seu nome?")
  var nome= readln()

  println("Qual sua idade?")
  var idade= readln().toInt()

  println("Qual sua altura?")
  var altura= readln().toDouble()

  println("Qual seu peso?")
  var peso= readln().toDouble()

  // Calculando o IMC e exibindo o resultado para o usuário
  var imc= peso/(altura*altura)
  println("O seu indice de massa corporea é $imc")

  // Classificando o resultado
  if (imc < 17) {
    println("Muito abaixo do peso")
  } else if (imc < 18.49) {
    println("Abaixo do peso")
  } else if (imc < 24.99) {
    println("Peso normal")
  } else if (imc < 29.99) {
    println("Acima do peso")
  } else  {
    println("Obesidade")
  }
}
