package com.thiagoio.rampolador.domain

import com.thiagoio.rampolador.R

enum class ClassificacaoRampa(val classificacao: String, val cor: Int) {

    PISO_PLANO("Piso plano", R.color.piso_plano),
    RAMPA_CONFORTAVEL("Rampa confortável" , R.color.rampa_confortavel ),
    RAMPA_DESAFIADORA("Rampa desafiadora" , R.color.rampa_desafiadora),
    RAMPA_LIMITE("Rampa limite" , R.color.limite_inclinacao),
    EXCESSO_DE_INCLINACAO("Excesso de inclinação" , R.color.excesso_inclinacao)
}