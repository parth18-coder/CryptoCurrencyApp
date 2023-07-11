package com.example.cryptocurrencyapp.domain.use_case.get_coins

import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.data.remote.dto.toCoin
import com.example.cryptocurrencyapp.domain.model.Coin
import com.example.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/*
here we have use the CoinRepository interface not the CoinRepositoryImpl, this help when in future we have to replace it with any other
class. so use the interface.
 */

/*
HttpException can arise if the code that we get from api is not start with the 2. And IOException can arise if we are not able to talk to api
maybe due to the internet connection etc.
 */

/*
first in the try block we emit the loading status. Now viewModel receive it and show the progress bar in the UI.

Then if it is successful than we emit the List<Coin> and viewModel will receive it.
 */

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
){

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow{
        try{
            emit(Resource.Loading<List<Coin>>())

            // here we convert the List<CoinDto> to the List<Coin>
            val coins= repository.getCoins().map { it.toCoin() }

            emit(Resource.Success<List<Coin>>(coins))

            // Now coins is the List<CoinDto> but we want to return the List<Coin>. So

        }
        catch (e: HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occurred "))
        }
        catch (e: IOException){
            emit(Resource.Error<List<Coin>>("Couldn't reach the server. Please Check your internet connection"))

        }

    }
}