package com.phoenixredwolf.newyorkcityschools.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryDark,
    onPrimary = OnPrimaryDark,
    primaryContainer = PrimaryContDark,
    onPrimaryContainer = OnPrimaryContDark,
    secondary = SecondaryDark,
    onSecondary = OnSecondaryDark,
    secondaryContainer = SecondaryContDark,
    onSecondaryContainer = OnSecondaryContDark,
    tertiary = TertiaryDark,
    onTertiary = OnTeriaryDark,
    tertiaryContainer = TertiaryContDark,
    onTertiaryContainer = OnTertiaryContDark,
    error = ErrorDark,
    errorContainer = ErrorContDark,
    onError = OnErrorDark,
    onErrorContainer = OnErrorContDark,
    background = BackAndSurfDark,
    onBackground = OnBackAndSurfDark,
    surface = BackAndSurfDark,
    onSurface = OnBackAndSurfDark,
    outline = OutlineDark,
    surfaceVariant = SurfVarDark,
    onSurfaceVariant = OnSurfVarDark,
    scrim = Purple40
    )

private val LightColorScheme = lightColorScheme(
    primary = PrimaryLight,
    onPrimary = OnPrSecTerErrLight,
    primaryContainer = PrimaryContLight,
    onPrimaryContainer = OnPrimaryContLight,
    secondary = SecondaryLight,
    onSecondary = OnPrSecTerErrLight,
    secondaryContainer = SecondaryContLight,
    onSecondaryContainer = OnSecondaryContLight,
    tertiary = TertiaryLight,
    onTertiary = OnPrSecTerErrLight,
    tertiaryContainer = TertiaryContLight,
    onTertiaryContainer = OnTertiaryContLight,
    error = ErrorLight,
    errorContainer = ErrorContLight,
    onError = OnPrSecTerErrLight,
    onErrorContainer = OnErrorContLight,
    background = BackAndSurfLight,
    onBackground = OnBackAndSurfLight,
    surface = BackAndSurfLight,
    onSurface = OnBackAndSurfLight,
    outline = OutlineLight,
    surfaceVariant = SurfaceVarLight,
    onSurfaceVariant = OnSurfVarLight,
    scrim = Color.Blue
)

@Composable
fun NewYorkCitySchoolsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    val window = (view.context as Activity).window
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window,view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}