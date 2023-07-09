package com.example.cryptocurrencyapp.presentation.coin_list

import com.example.cryptocurrencyapp.domain.model.Coin


/*
so basically our coin list screen have this data so we are creating this data class. And we get data we expose this to the UI.
 */
data class CoinListState(
    val isLoading:Boolean=false,
    val coins:List<Coin> = emptyList(),
    val error:String=""
)
