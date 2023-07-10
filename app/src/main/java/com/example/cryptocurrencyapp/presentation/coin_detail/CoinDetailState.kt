package com.example.cryptocurrencyapp.presentation.coin_detail

import com.example.cryptocurrencyapp.domain.model.Coin
import com.example.cryptocurrencyapp.domain.model.CoinDetail

/*
so basically our coin list screen have this data so we are creating this data class. And we get data we expose this to the UI.
 */
data class CoinDetailState(
    val isLoading:Boolean=false,
    val coin:CoinDetail? =null,
    val error:String=""
)
