# Dev Mobile 2023
Curso de Desenvolvimento Mobile 2023

## Conheça a linguagem de programação Kotlin

Kotlin é uma linguagem de programação amplamente usada por desenvolvedores Android em qualquer lugar. Este tópico funciona como um curso intensivo do Kotlin para você começar a usá-lo rapidamente.

## Declaração de variável

O Kotlin usa duas palavras-chave diferentes para declarar variáveis: val e var.

- Use val para uma variável cujo valor nunca muda. Não é possível reatribuir um valor a uma variável que tenha sido declarada usando val.
- Use var para uma variável cujo valor possa ser mudado.

No exemplo abaixo, count é uma variável do tipo Int que recebe um valor inicial de 10:

` var count: Int = 10 `

Int é um tipo que representa um número inteiro, um dos muitos tipos numéricos que podem ser representados em Kotlin. Assim como acontece com outras linguagens, você também pode usar Byte, Short, Long, Float e Double, dependendo dos seus dados numéricos.

A palavra-chave var significa que você pode reatribuir valores a count conforme necessário. Por exemplo, você pode mudar o valor de count de 10 para 15:

```
var count: Int = 10
count = 15
```

No entanto, alguns valores não podem ser mudados. Considere um String chamado languageName. Se você quiser garantir que languageName sempre tenha o valor "Kotlin", poderá declarar languageName usando a palavra-chave val:

`val languageName: String = "Kotlin"`

Essas palavras-chave permitem que você seja explícito sobre o que pode ser mudado. Use-as em seu favor conforme necessário. Se uma referência de variável precisar ser reatribuível, declare-a como var. Do contrário, use val.

## Inferência de tipo

Continuando com o exemplo anterior, quando você atribui um valor inicial a languageName, o compilador Kotlin pode inferir o tipo com base no tipo do valor atribuído.

Como o valor de "Kotlin" é do tipo String, o compilador infere que languageName também é um String. O Kotlin é uma linguagem estática. Isso significa que o tipo é resolvido no momento da compilação e nunca muda.

No exemplo a seguir, languageName é inferido como String. Portanto, não é possível chamar nenhuma função que não faça parte da classe String:

```
val languageName = "Kotlin"
val upperCaseName = languageName.toUpperCase()

// Fails to compile
languageName.inc()
```

toUpperCase() é uma função que só pode ser chamada em variáveis do tipo String. Como o compilador Kotlin inferiu languageName como String, você pode chamar toUpperCase() com segurança. inc(), entretanto, é uma função de operador Int, por isso não pode ser chamada em String. A abordagem do Kotlin para a inferência de tipos oferece concisão e segurança de tipos.

## Segurança nula

Em algumas linguagens, uma variável de tipo de referência pode ser declarada sem fornecer um valor explícito inicial. Nesses casos, as variáveis geralmente contêm um valor nulo. Por padrão, as variáveis do Kotlin não podem reter valores nulos. Isso significa que o snippet a seguir é inválido.

```
// Fails to compile
val languageName: String = null
````

Para que uma variável mantenha um valor nulo, ela precisa ser do tipo anulável. Você pode especificar uma variável como sendo anulável, usando um sufixo do tipo com ?, conforme mostrado neste exemplo a seguir.

```
val languageName: String? = null
```

Com um tipo String?, você pode atribuir um valor String ou null a languageName.

Você precisa lidar com variáveis anuláveis com cuidado ou corre o risco de ter um NullPointerException. Em Java, por exemplo, se você tentar invocar um método em um valor nulo, seu programa falhará.

O Kotlin fornece uma série de mecanismos para trabalhar com segurança com variáveis anuláveis. Para ver mais informações, consulte Padrões comuns do Kotlin no Android: anulação (link em inglês).

## Condicionais

O Kotlin apresenta vários mecanismos para implementar a lógica condicional. O mais comum deles é uma instrução if-else. Se uma expressão entre parênteses ao lado de uma palavra-chave if for avaliada como true, o código dentro dessa ramificação (ou seja, o código imediatamente seguinte que é encapsulado entre chaves) será executado. Caso contrário, será executado o código dentro da ramificação else.

```
if (count == 42) {
    println("I have the answer.")
} else {
    println("The answer eludes me.")
}
```

Você pode representar várias condições usando else if. Isso permite representar uma lógica mais granular e complexa em uma única instrução condicional, conforme mostrado neste exemplo:

```
if (count == 42) {
    println("I have the answer.")
} else if (count > 35) {
    println("The answer is close.")
} else {
    println("The answer eludes me.")
}
```

As instruções condicionais são úteis para representar a lógica com estado, mas você pode se repetir ao gravá-las. No exemplo acima, você simplesmente imprime um String em cada ramificação. Para evitar essa repetição, o Kotlin oferece expressões condicionais. O último exemplo pode ser regravado da seguinte forma:

```
val answerString: String = if (count == 42) {
    "I have the answer."
} else if (count > 35) {
    "The answer is close."
} else {
    "The answer eludes me."
}

println(answerString)
```

Implicitamente, cada ramificação condicional retorna o resultado da expressão na linha final, de modo que não é necessário usar uma palavra-chave return. Como o resultado das três ramificações é do tipo String, o resultado da expressão if-else também é do tipo String. Neste exemplo, answerString recebe um valor inicial do resultado da expressão if-else. A inferência de tipos pode ser usada para omitir a declaração de tipo explícito para answerString, mas geralmente é uma boa ideia incluí-la para fins de clareza.

Observação: o Kotlin não inclui um operador ternário tradicional, favorecendo o uso de expressões condicionais.
Conforme a complexidade da instrução condicional aumenta, é recomendável substituir a expressão if-else por uma expressão when, conforme mostrado neste exemplo:

```
val answerString = when {
    count == 42 -> "I have the answer."
    count > 35 -> "The answer is close."
    else -> "The answer eludes me."
}

println(answerString)
```

Cada ramificação em uma expressão when é representada por uma condição, uma seta (->) e um resultado. Se a condição no lado esquerdo da seta for avaliada como verdadeira, o resultado da expressão no lado direito será retornado. Observe que a execução não passa de uma ramificação para a próxima. O código no exemplo de expressão when é funcionalmente equivalente ao do exemplo anterior, mas é mais fácil de ler.

As condicionais do Kotlin destacam um dos recursos mais avançados, a transmissão inteligente. Em vez de usar o operador de chamada segura ou o operador de declaração não nulo para trabalhar com valores anuláveis, você pode verificar se uma variável contém uma referência a um valor nulo usando uma instrução condicional, conforme mostrado neste exemplo:

```
val languageName: String? = null
if (languageName != null) {
    // No need to write languageName?.toUpperCase()
    println(languageName.toUpperCase())
}
```

Na ramificação condicional, languageName pode ser tratado como não anulável. O Kotlin é inteligente o suficiente para reconhecer que a condição para executar a ramificação é que languageName não contenha um valor nulo. Portanto, você não precisa tratar languageName como anulável nessa ramificação. Essa transmissão inteligente funciona para verificações nulas, verificações de tipo ou qualquer condição que satisfaça a um contrato.

## Funções
Você pode agrupar uma ou mais expressões em uma função. Em vez de repetir a mesma série de expressões sempre que precisar de um resultado, você pode unir as expressões em uma função e chamar essa função.

Para declarar uma função, use a palavra-chave fun seguida pelo nome da função. Em seguida, defina os tipos de entrada que sua função assume, se houver, e declare o tipo de saída retornada. No corpo de uma função, você define expressões que são chamadas quando sua função é invocada.

Com base nos exemplos anteriores, veja uma função completa do Kotlin:

```
fun generateAnswerString(): String {
    val answerString = if (count == 42) {
        "I have the answer."
    } else {
        "The answer eludes me"
    }

    return answerString
}
```

A função no exemplo acima tem o nome generateAnswerString. Não é necessária nenhuma entrada. Ela gera um resultado do tipo String. Para chamar uma função, use o nome dela, seguido pelo operador de invocação (()). No exemplo abaixo, a variável answerString é inicializada com o resultado de generateAnswerString().

`val answerString = generateAnswerString()`

As funções podem receber argumentos como entrada, conforme mostrado neste exemplo:

```
fun generateAnswerString(countThreshold: Int): String {
    val answerString = if (count > countThreshold) {
        "I have the answer."
    } else {
        "The answer eludes me."
    }

    return answerString
}
```

Ao declarar uma função, você pode especificar qualquer número de argumentos e os tipos. No exemplo acima, generateAnswerString() leva um argumento chamado countThreshold do tipo Int. Dentro da função, você pode se referir ao argumento usando o nome dele.

Ao chamar essa função, você precisa incluir um argumento nos parênteses da chamada da função:

`val answerString = generateAnswerString(42)`

## Como simplificar declarações de função

generateAnswerString() é uma função bastante simples. A função declara uma variável e, em seguida, retorna imediatamente. Quando o resultado de uma única expressão é retornado de uma função, você pode ignorar a declaração de uma variável local retornando diretamente o resultado da expressão if-else contida na função, conforme mostrado neste exemplo:

```
fun generateAnswerString(countThreshold: Int): String {
    return if (count > countThreshold) {
        "I have the answer."
    } else {
        "The answer eludes me."
    }
}
```

Você também pode substituir a palavra-chave de retorno pelo operador de atribuição:

```
fun generateAnswerString(countThreshold: Int): String = if (count > countThreshold) {
        "I have the answer"
    } else {
        "The answer eludes me"
    }
```

## Funções anônimas

Nem todas as funções precisam de um nome. Algumas funções são identificadas mais diretamente por suas entradas e saídas. Essas funções são chamadas de funções anônimas. Você pode manter uma referência a uma função anônima usando essa referência para chamar a função anônima posteriormente. Você também pode passar a referência no seu app, como acontece com outros tipos de referência.

```
val stringLengthFunc: (String) -> Int = { input ->
    input.length
}
```

Assim como as funções nomeadas, as funções anônimas podem conter qualquer número de expressões. O valor retornado da função é o resultado da expressão final.

No exemplo acima, stringLengthFunc contém uma referência a uma função anônima que usa um String como entrada e retorna o comprimento da entrada String como saída do tipo Int. Por esse motivo, o tipo da função é denotado como (String) -> Int. No entanto, esse código não invoca a função. Para recuperar o resultado da função, você precisa invocá-lo como faria com uma função nomeada. Forneça um String ao chamar stringLengthFunc, conforme mostrado neste exemplo:

```
val stringLengthFunc: (String) -> Int = { input ->
    input.length
}

val stringLength: Int = stringLengthFunc("Android")
```

## Funções de ordem superior

Uma função pode usar outra função como um argumento. As funções que usam outras funções como argumentos são chamadas de funções de ordem superior. Esse padrão é útil para a comunicação entre componentes, da mesma forma que você pode usar uma interface de callback em Java.

Veja um exemplo de uma função de ordem superior:

```
fun stringMapper(str: String, mapper: (String) -> Int): Int {
    // Invoke function
    return mapper(str)
}
```
A função stringMapper() usa um String junto com uma função que deriva um valor Int de um String transmitido nela.

Você pode chamar stringMapper() passando um String e uma função que satisfaça o outro parâmetro de entrada, ou seja, uma função que usa um String como entrada e gera um Int, conforme mostrado neste exemplo:

```
stringMapper("Android", { input ->
    input.length
})
```
Se a função anônima for o último parâmetro definido em uma função, você poderá transmiti-la para fora dos parênteses usados para chamar a função, conforme mostrado neste exemplo:

```
stringMapper("Android") { input ->
    input.length
}
```

As funções anônimas podem ser encontradas em toda a biblioteca padrão do Kotlin. Para mais informações, consulte Funções de ordem superior e lambdas (link em inglês).

## Classes

Todos os tipos mencionados até agora estão integrados à linguagem de programação Kotlin. Se quiser adicionar um tipo personalizado, você poderá definir uma classe usando a palavra-chave class, conforme mostrado neste exemplo:


`class Car`

### Propriedades

As classes representam o estado usando propriedades. Uma propriedade é uma variável de nível de classe que pode incluir um getter, um setter e um campo de backup. Como um carro precisa de rodas para dirigir, você pode adicionar uma lista de objetos Wheel como uma propriedade de Car, conforme mostrado neste exemplo:
```
class Car {
    val wheels = listOf<Wheel>()
}
```
Observe que wheels é um public val, o que significa que wheels pode ser acessado de fora da classe Car e não pode ser reatribuído. Se você quiser ter uma instância de Car, primeiro é necessário chamar seu construtor. A partir daí, você pode acessar qualquer uma das propriedades acessíveis.

```
val car = Car() // construct a Car
val wheels = car.wheels // retrieve the wheels value from the Car
``` 

Se você quiser personalizar suas rodas, poderá definir um construtor personalizado que especifica como as propriedades de classe são inicializadas:

`class Car(val wheels: List<Wheel>)`

No exemplo acima, o construtor de classe usa um List<Wheel> como argumento do construtor e usa esse argumento para inicializar a propriedade wheels.

### Funções de classe e encapsulamento

As classes usam funções para modelar o comportamento. As funções podem modificar o estado, ajudando você a expor somente os dados que quer expor. Esse controle de acesso faz parte de um conceito maior orientado a objetos, conhecido como encapsulamento.

No exemplo a seguir, a propriedade doorLock é mantida privada em qualquer item fora da classe Car. Para desbloquear o carro, você precisa chamar a função unlockDoor() transmitindo uma chave válida, conforme mostrado neste exemplo:

```
class Car(val wheels: List<Wheel>) {

    private val doorLock: DoorLock = ...

    fun unlockDoor(key: Key): Boolean {
        // Return true if key is valid for door lock, false otherwise
    }
}
```

Se quiser personalizar a forma como uma propriedade é referenciada, você poderá fornecer getter e setter personalizados. Por exemplo, se quiser expor o getter de uma propriedade ao restringir o acesso a setter, você poderá designar esse setter como private:

```
class Car(val wheels: List<Wheel>) {

    private val doorLock: DoorLock = ...

    var gallonsOfFuelInTank: Int = 15
        private set

    fun unlockDoor(key: Key): Boolean {
        // Return true if key is valid for door lock, false otherwise
    }
}
```

Com uma combinação de propriedades e funções, você pode criar classes que modelam todos os tipos de objeto.

## Interoperabilidade

Uma das características mais importantes do Kotlin é a interoperabilidade fluida com Java. Como o código Kotlin é compilado até o bytecode da JVM, seu código Kotlin pode ser chamado diretamente no código Java e vice versa. Isso significa que você pode aproveitar bibliotecas Java já existentes diretamente do Kotlin. Além disso, a maioria das APIs do Android é gravada em Java, e você pode chamá-las diretamente do Kotlin.

## Introdução ao estado no Compose ##

# Usar o estado no Compose
O estado em um app é qualquer valor que pode mudar ao longo do tempo. Neste app, o estado é o valor da conta.

Adicione uma variável para armazenar o estado:

No início da função EditNumberField(), use a palavra-chave val para adicionar uma variável amountInput e defini-la com o valor "0":

```
val amountInput = "0"
```

Este é o estado do app para o valor da conta.

Defina o parâmetro chamado value com um valor amountInput:
```
TextField(
   value = amountInput,
   onValueChange = {},
)
```

Verificar a visualização. A caixa de texto mostra o valor definido para a variável de estado.

Execute o app no emulador e tente inserir um valor diferente. O estado fixado no código continua o mesmo, porque o elemento combinável TextField não é atualizado automaticamente. Ele muda quando o parâmetro value, definido como a propriedade amountInput, é modificado.
A variável amountInput representa o estado da caixa de texto. Ter um estado fixado no código não é útil, já que ele não pode ser modificado e não reflete a entrada do usuário. É necessário atualizar o estado do app quando o usuário atualiza o valor da conta.

## A composição

Os elementos combináveis no app descrevem uma interface que mostra uma coluna com texto, um espaçador e uma caixa de texto. O texto mostra Calculate Tip, e a caixa de texto mostra um valor 0 ou o valor padrão.

O Compose é um framework de interface declarativo, ou seja, você declara como será a interface no código. Se você quiser que a caixa de texto mostre inicialmente um valor 100, defina no código o valor inicial dos elementos de composição como 100.

O que acontece se você quiser que a interface mude enquanto o app está em execução ou quando o usuário interage com ele? Por exemplo, o que acontece quando você atualiza a variável amountInput com o valor inserido pelo usuário e a mostra na caixa de texto? É então que você precisa usar um processo chamado recomposição para atualizar a composição do app.

A composição é uma descrição da interface criada pelo Compose quando ele executa elementos combináveis. Os apps do Compose chamam funções combináveis para transformar dados em elementos da interface. Se uma mudança de estado ocorrer, o Compose vai executar novamente as funções combináveis afetadas com o novo estado, criando uma interface atualizada. Isso é chamado de recomposição. O Compose programa uma recomposição para você.

Quando o Compose executa seus elementos combináveis pela primeira vez durante a composição inicial, ele acompanha os elementos chamados para descrever a interface em uma composição. A recomposição acontece quando o Compose executa novamente os elementos de composição que foram modificados em resposta a mudanças de dados e, em seguida, atualiza a composição para refletir essas mudanças.

A composição só pode ser produzida por uma composição inicial e atualizada por recomposição. A única maneira de modificar uma composição é pela recomposição. Para fazer isso, o Compose precisa saber qual estado será acompanhado para programar a recomposição ao receber uma atualização. No seu caso, é a variável amountInput. Então, sempre que o valor mudar, o Compose vai programar uma recomposição.

Você usa os tipos State e MutableState no Compose para tornar o estado no app observável ou monitorado pelo Compose. O tipo State é imutável, ou seja, o valor dele só será lido, enquanto o tipo MutableState for mutável. Você pode usar a função mutableStateOf() para criar um MutableState observável. Ele recebe um valor inicial como um parâmetro envolvido por um objeto State, que torna o value dele observável.

O valor retornado pela função mutableStateOf():

mantém o estado, que é o valor da conta;
é mutável, então o valor pode ser mudado;
é observável, então o Compose observa as mudanças no valor e aciona uma recomposição para atualizar a interface.
Adicione um estado de custo de serviço:

Na função EditNumberField(), mude a palavra-chave val antes da variável de estado amountInput para a palavra-chave var:

```
var amountInput = "0"
```

Isso torna o amountInput mutável.

Use o tipo MutableState<String> em vez da variável String fixada no código para que o Compose saiba que precisa acompanhar o estado amountInput e depois transmitir uma string "0", que é o valor padrão inicial para a variável de estado amountInput:

```
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
```

```
var amountInput: MutableState<String> = mutableStateOf("0")
```

A inicialização de amountInput também pode ser programada desta forma com inferência de tipo:

```
var amountInput = mutableStateOf("0")
```

A função mutableStateOf() recebe um valor inicial de "0" como argumento, fazendo com que o amountInput seja observável. O resultado é este aviso de compilação no Android Studio, mas isso poderá ser corrigido em breve:

Creating a state object during composition without using remember.

Na função combinável TextField, use a propriedade amountInput.value:

```
TextField(
   value = amountInput.value,
   onValueChange = {},
   modifier = modifier
)
```

O Compose monitora cada elemento combinável que lê propriedades de estado value e aciona uma recomposição quando o value é modificado.

O callback onValueChange é acionado quando a entrada na caixa de texto é mudada. Na expressão lambda, a variável it contém o novo valor.

Na expressão lambda do parâmetro chamado onValueChange, defina a propriedade amountInput.value como a variável it:

```
@Composable
fun EditNumberField(modifier: Modifier = Modifier) {
   var amountInput = mutableStateOf("0")
   TextField(
       value = amountInput.value,
       onValueChange = { amountInput.value = it },
       modifier = modifier
   )
}
```

Você está atualizando o estado de TextField (a variável amountInput), quando TextField notifica que há uma mudança no texto usando a função de callback onValueChange.

Execute o app e digite o texto. A caixa de texto ainda mostra um valor 0, como nesta imagem:
o usuário tenta digitar no campo de texto, mas nada muda

Quando o usuário digita na caixa de texto, o callback onValueChange é chamado, e a variável amountInput é atualizada com o novo valor. O estado amountInput é acompanhado pelo Compose. Assim, quando o valor muda, a recomposição é programada, e a função de composição EditNumberField() é executada novamente. Nessa função de composição, a variável amountInput é redefinida para o valor inicial de 0. Assim, a caixa de texto mostra um valor 0.

Com o código adicionado, as mudanças de estado fazem com que as recomposições sejam programadas.

No entanto, é necessário preservar o valor da variável amountInput nas recomposições para que ela não seja redefinida como 0 sempre que a função EditNumberField() é recomposta. Vamos resolver esse problema na próxima seção.


## Fonte
A fonte deste tutorial é o site [developer.android.com](developer.android.com)
