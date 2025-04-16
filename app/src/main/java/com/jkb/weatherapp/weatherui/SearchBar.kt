package com.jkb.weatherapp.weatherui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(onSearch: (String) -> Unit) {
    var text by remember { mutableStateOf(TextFieldValue("")) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TextField(
            value = text,
            onValueChange = { newtext -> text = newtext },
            modifier = Modifier.weight(1f),
            placeholder = { Text("Enter city name") })
        Spacer(modifier = Modifier.width(8.dp))
        Button(onClick = { onSearch(text.text) }) {
            Text("Search")
        }
    }
}

@Preview
@Composable
fun PreviewSearchBar() {
    SearchBar {  }
}