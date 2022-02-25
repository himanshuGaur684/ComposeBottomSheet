package com.gaur.composebottomsheet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gaur.composebottomsheet.ui.theme.ComposeBottomSheetTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBottomSheetTheme {
                BottomSheet()
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheet() {

    val scope = rememberCoroutineScope()
    val bottomSheetState= rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            Column(modifier = Modifier.padding(12.dp)) {
                Text(text = "Text 1")
                Text(text = "Text 2")
                Text(text = "Text 3")
                Text(text = "Text 4")
                Text(text = "Text 5")
                Text(text = "Text 6")
                Text(text = "Text 7")
                Text(text = "Text 8")
            }
        },
        sheetShape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
        sheetElevation = 12.dp
    ) {
        MainContent(scope,bottomSheetState)
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainContent(scope:CoroutineScope,bottomSheetState: ModalBottomSheetState) {

    Surface(modifier = Modifier.fillMaxSize()) {

        Button(modifier = Modifier.height(40.dp).fillMaxWidth(), onClick = {
            scope.launch {
                bottomSheetState.show()
            }
        }) {
            Text(text = "Click me ( Expand me)")
        }

    }


}
