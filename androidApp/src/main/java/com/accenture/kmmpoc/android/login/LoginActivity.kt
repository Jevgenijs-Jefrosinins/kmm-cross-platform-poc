package com.accenture.kmmpoc.android.login

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.accenture.kmmpoc.android.R
import com.accenture.kmmpoc.presentation.base.BaseDIActivity
import com.accenture.kmmpoc.android.login.ui.theme.KMM_PoC_AppTheme
import com.accenture.kmmpoc.domain.auth.entity.SignInData
import com.accenture.kmmpoc.domain.base.DomainResponse
import com.accenture.kmmpoc.presentation.login.LoginViewModel
import com.accenture.kmmpoc.presentation.utils.textFieldValueSaver
import org.kodein.di.DI
import org.kodein.di.instance

class LoginActivity : BaseDIActivity() {

    private val viewModel: LoginViewModel by viewModels()

    private val navigator by instance<LoginNavigator>()

    override val initActivityDI: DI.Builder.() -> Unit = {
        import(loginModule(this@LoginActivity))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KMM_PoC_AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginPage { signInData ->
                        onLoginClick(signInData)
                    }
                }
            }
        }
        // subscribe to authentication response(s)
        viewModel.userSessionLiveData.observe(this) { response ->
            when (response) {
                is DomainResponse.Loading -> { /* no-op. To-do: display loader*/ }
                is DomainResponse.Content -> {
                    navigator.toHomePage()
                }
                is DomainResponse.Error -> {
                    Toast.makeText(this, response.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun onLoginClick(signInData: SignInData) {
        viewModel.signIn(signInData)
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPage(
    onLoginClicked: (SignInData) -> Unit = { _ -> }
) {

    val emailSaver = textFieldValueSaver()
    var emailValue by rememberSaveable(stateSaver = emailSaver) {
        mutableStateOf(TextFieldValue())
    }

    val passwordSaver = textFieldValueSaver()
    var passwordValue by rememberSaveable(stateSaver = passwordSaver) {
        mutableStateOf(TextFieldValue())
    }

    var passwordVisible by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()//(0.8f)
//                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color.White)
                .padding(10.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 2.sp
                    ),
                    fontSize = 30.sp
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Text(
                    text = stringResource(id = R.string.login_subtitle),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        letterSpacing = 1.sp
                    ),
                    fontSize = 15.sp
                )
                Spacer(modifier = Modifier.padding(20.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        value = emailValue,
                        onValueChange = { value -> emailValue = value },
                        label = { Text(text = stringResource(id = R.string.email)) },
                        placeholder = { Text(text = stringResource(id = R.string.email)) },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .focusRequester(focusRequester = focusRequester),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next
                        )
                    )
                    OutlinedTextField(
                        value = passwordValue,
                        onValueChange = { value -> passwordValue = value },
                        label = { Text(text = stringResource(id = R.string.pwd)) },
                        placeholder = { Text(text = stringResource(id = R.string.pwd)) },
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisible = !passwordVisible
                            }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_collection),
                                    contentDescription = null,
                                    tint = if (passwordVisible) Color.Black else Color.Gray
                                )
                            }
                        },
                        singleLine = true,
                        visualTransformation = if (passwordVisible) VisualTransformation.None
                        else PasswordVisualTransformation(),
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .focusRequester(focusRequester = focusRequester),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        )
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        text = stringResource(id = R.string.forgot_pwd),
                        textAlign = TextAlign.End,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            letterSpacing = 1.sp
                        ),
                        fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.padding(20.dp))
                    Button(
                        onClick = {
                            onLoginClicked(
                                SignInData(emailValue.text, passwordValue.text)
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp)
                    ) {
                        Text(text = stringResource(id = R.string.log_in), fontSize = 20.sp)
                    }
                    Spacer(modifier = Modifier.padding(20.dp))
                    Text(
                        text = stringResource(id = R.string.sign_up),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(0.8f),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp
                        ),
                        fontSize = 15.sp
                    )
                }
            }
        }
    }
}

