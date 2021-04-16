package github.farhanroy.signinup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import github.farhanroy.signinup.ui.theme.Shapes
import github.farhanroy.signinup.ui.theme.SigninupTheme

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SigninupTheme {
                Surface(color = MaterialTheme.colors.background) {
                    RegisterScreen()
                }
            }
        }
    }
}

@Composable
fun RegisterScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        HeaderText()
        Spacer(modifier = Modifier.height(64.dp))
        UsernameTextField()
        Spacer(modifier = Modifier.height(4.dp))
        EmailTextField()
        Spacer(modifier = Modifier.height(4.dp))
        PasswordTextField()
        Spacer(modifier = Modifier.height(64.dp))
        ButtonRegister()
        Spacer(modifier = Modifier.height(16.dp))
        ButtonFBRegister()
        Spacer(modifier = Modifier.height(48.dp))
        ButtonToLogin()
    }
}

@Composable
private fun HeaderText() {
    Text(text = "Welcome,", fontWeight = FontWeight.Bold, fontSize = 32.sp)
    Spacer(modifier = Modifier.height(2.dp))
    Text(text = "Sign up to create an account,", fontWeight = FontWeight.Bold, fontSize = 26.sp, color = Color.LightGray)
}

@Composable
private fun UsernameTextField() {
    var username by remember { mutableStateOf("") }

    OutlinedTextField(
        value = username,
        onValueChange = { username = it },
        label = { Text(text = "Username") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )
}

@Composable
private fun EmailTextField() {
    var email by remember { mutableStateOf("") }

    OutlinedTextField(
        value = email,
        onValueChange = { email = it },
        label = { Text(text = "Email") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )
}

@Composable
private fun PasswordTextField() {
    var password by remember { mutableStateOf("") }

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text(text = "Password") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )
}

@Composable
private fun ButtonRegister() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 1.dp),
        shape = Shapes.large
    ) {
        Text("Register")
    }
}

@Composable
private fun ButtonFBRegister() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 1.dp),
        shape = Shapes.large,
        elevation = ButtonDefaults.elevation(0.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = R.drawable.ic_facebook), contentDescription = "")
            Text("  Connect to Facebook", color = Color.Blue)
        }
    }
}

@Composable
private fun ButtonToLogin() {
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        Text("Have an account ? ")
        Text("Sign In ", color = MaterialTheme.colors.primary, fontWeight = FontWeight.SemiBold)
    }
}