package com.ujanglukmanbdg.tarucingpet.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ujanglukmanbdg.tarucingpet.ui.theme.TarucingPetTheme
import com.ujanglukmanbdg.tarucingpet.R
import com.ujanglukmanbdg.tarucingpet.navigation.ScreenMenu
import com.ujanglukmanbdg.tarucingpet.ui.theme.PremiumSoftPink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PromotionHome(navController: NavController, ) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = PremiumSoftPink, contentColor = White),

        onClick = {
            val idAnimal = 5

            navController.navigate(ScreenMenu.DetailAnimal.createRoute(id = idAnimal))
        },

    ) {

        Box(modifier = Modifier.fillMaxSize()) {

            Image(
                modifier = Modifier.align(Alignment.BottomEnd).padding(45.dp),
                painter = painterResource(R.drawable.banner_kucing),
                contentDescription = stringResource(id = R.string.banner_promotion)
            )
            Column(
                modifier = Modifier.padding(start = 18.dp, top = 20.dp, bottom = 20.dp, end = 18.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.banner_promotion_1),
                    style = MaterialTheme.typography.bodyMedium.copy(color = White, fontSize = 15.sp),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = stringResource(id = R.string.banner_promotion_2),
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold, color = White, fontSize = 20.sp,)
                )
                Text(
                    text = stringResource(id = R.string.banner_promotion_3),
                    style = MaterialTheme.typography.bodyMedium.copy(color = White, fontSize = 13.sp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PromotionHomePreview(){
    TarucingPetTheme {
      //  PromotionHome()
    }
}