package com.thiagoio.rampolador.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thiagoio.rampolador.domain.Calculador
import com.thiagoio.rampolador.domain.ClassificacaoRampa
import java.lang.ArithmeticException
import kotlin.math.absoluteValue

class MainViewModel : ViewModel(){

    val desnivel = MutableLiveData<Double>()
    val comprimento = MutableLiveData<Double>()
    val inclinacao = MutableLiveData<Double>()
    val classificacaoRampa = MutableLiveData<ClassificacaoRampa>()
    val calculador = Calculador()

    init {
        desnivel.value = 0.0
        comprimento.value = 0.0
        inclinacao.value = 0.0
        classificacaoRampa.value = ClassificacaoRampa.PISO_PLANO
    }


    fun atualizaInclinacao(){
        val dH: Double? = desnivel.value
        val dL: Double? = comprimento.value
        val inclinacaoCalculada = calculador.calculaInclinacao(dH, dL)
        inclinacao.value = inclinacaoCalculada
        classificacaoRampa.value = atualizaClassificacao(inclinacaoCalculada)

    }

    fun atualizaClassificacao(inclinacao: Double): ClassificacaoRampa{
       calculador.analisaInclinacao(inclinacao)
    }

}