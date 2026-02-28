package gonzalez.sebastian.composepokedex_gonzalezsebastian.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import gonzalez.sebastian.composepokedex_gonzalezsebastian.R

@Composable
fun ContiguousObjects(position: String, image: Int, name: String, number: Int) {

    val arrowDirection = arrowOption(position)
    val alignment = alignmentOption(position)

    Column(modifier = Modifier
        .padding(16.dp),
        horizontalAlignment = alignment){

        Image(painter = painterResource(id = image),
            contentDescription = "${name}Image",
            modifier = Modifier.size(125.dp))

        Row() {
            if (position == "left") {
                Image(
                    painter = painterResource(id = arrowDirection),
                    contentDescription = "${position}Arrow",
                    modifier = Modifier.size(30.dp)
                )

                Text(text = name + " N.° ${String.format("%04d", number)}")
            } else {
                Text(text = name + " N.° ${String.format("%04d", number)}")

                Image(
                    painter = painterResource(id = arrowDirection),
                    contentDescription = "${position}Arrow",
                    modifier = Modifier.size(30.dp)
                )
            }
        }

    }
}

fun alignmentOption(position: String) : Alignment.Horizontal{
    if (position == "left") {
        return Alignment.Start
    } else {
        return Alignment.End
    }
}

fun arrowOption(position: String) : Int {
    if (position == "left") {
        return R.drawable.left_arrow_outline
    } else {
        return R.drawable.right_arrow_outline
    }
}