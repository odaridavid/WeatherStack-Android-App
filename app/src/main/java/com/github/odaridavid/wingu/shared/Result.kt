package com.github.odaridavid.wingu.shared

sealed class Result<Type> {

    data class Success<Type>(val data: Type) : Result<Type>()

    data class Error<Type>(val throwable: Throwable? = null) : Result<Type>()

}
