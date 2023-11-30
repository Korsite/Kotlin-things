fun main(){
    val lista = mutableListOf(10, 3, 2, 11, 4)

    for(posicion in lista.indices) {
        var numeroMenor = lista[posicion]
        var posicionDelNumeroMenor = posicion

        for (posicion2 in posicion .. lista.lastIndex)
            if(lista[posicion2] < numeroMenor){
                numeroMenor = lista[posicion2]
                posicionDelNumeroMenor = posicion2
            }

        val auxiliar = lista[posicion]

        lista[posicion] = numeroMenor
        lista[posicionDelNumeroMenor] = auxiliar

    }
    print(lista)

}