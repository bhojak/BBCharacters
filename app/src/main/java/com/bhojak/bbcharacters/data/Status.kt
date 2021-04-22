package com.bhojak.bbcharacters.data

sealed class Status {
    object Error : Status()
    object Loading : Status()
    object Success : Status()
}