package com.example.navigation3

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay


    data object ScreenList
    data class ScreenDetails(val id: String)

    data class ScreenC(val id1: String)

    data object screenD

@Composable
fun Navigation() {
    val backStack = remember { mutableStateListOf<Any>(ScreenList) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key->
            when (key) {
                is ScreenList ->
                    NavEntry(key) {
                        ScreenA(modifier = Modifier, onClick = {
                            backStack.add(ScreenDetails("someId"))
                        })
                    }
                is ScreenDetails ->
                    NavEntry(key) {
                        ScreenB(
                            id = key.id,
                            onClick = { backStack.add(ScreenC("someId")) }
                        )
                    }
                is ScreenC ->
                    NavEntry(key){
                        ScreenC(id = key.id1, onClick = { backStack.add(screenD) })
                    }
                is screenD ->
                    NavEntry(key){
                        ScreenD(onClick = { backStack.add(ScreenList) })
                    }
                else -> error("Unknown key: $key")
            }
        }
    )
}