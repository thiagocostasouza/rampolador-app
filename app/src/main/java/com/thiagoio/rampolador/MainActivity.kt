package com.thiagoio.rampolador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.thiagoio.rampolador.databinding.ActivityMainBinding
import com.thiagoio.rampolador.extension.formataInclinacao
import com.thiagoio.rampolador.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {



    private lateinit var binding:  ActivityMainBinding
    private val inclinacaoTxt by lazy { binding.mainInclicacaoResultado }
    private val desnivelSld by lazy { binding.mainDesnivelSlider }
    private val comprimentoSld by lazy { binding.mainComprimentoSlider }
    private val estadoPiso by lazy { binding.estadoPiso }

    private lateinit var  mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initViewModel()
        initDesnivelSld()
        initComprimentoSld()
        initObserver()


    }

    private fun initObserver() {
        mViewModel.inclinacao.observe(this,{ inclinacaoCal: Double? ->
            inclinacaoTxt.text = "i: " + inclinacaoCal?.formataInclinacao() + "%"
            estadoPiso.text = mViewModel.classificacaoRampa.value?.classificacao
        })
    }

    private fun initViewModel() {
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private fun initComprimentoSld() {
        comprimentoSld.addOnChangeListener { _, value, _ ->
            mViewModel.comprimento.postValue(value.toDouble())
            mViewModel.atualizaInclinacao()
        }
    }

    private fun initDesnivelSld() {
        desnivelSld.addOnChangeListener { _, value, _ ->
            mViewModel.desnivel.postValue(value.toDouble())
            mViewModel.atualizaInclinacao()
        }
    }


}