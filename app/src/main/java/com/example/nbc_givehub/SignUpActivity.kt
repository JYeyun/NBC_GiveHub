package com.example.nbc_givehub

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        val sginUpName = findViewById<EditText>(R.id.singUpName)
        val sginUpId = findViewById<EditText>(R.id.singUpId)
        val sginUpPw = findViewById<EditText>(R.id.singUpPw)
        val sginUpNameCheck = findViewById<ImageView>(R.id.singUpNameCheck)
        val sginUpIdCheck = findViewById<ImageView>(R.id.singUpIdCheck)
        val sginUpPwCheck = findViewById<ImageView>(R.id.singUpPwCheck)

        val sginUpBt = findViewById<Button>(R.id.signUpBt)
        val sginUpBackBt = findViewById<Button>(R.id.singUpBack)


        //이름 확인
        sginUpName.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // 텍스트가 변경될 때마다 호출된다.
                // 비밀번호를 입력할 때 실시간으로 비밀번호 형식을 검사한다.
                if (sginUpName.text.isNotBlank()) {
                    sginUpNameCheck.setImageResource(R.drawable.icon_check_mark)
                }else{
                    sginUpNameCheck.setImageResource(R.drawable.x_icon)
                }
            }
            override fun afterTextChanged(p0: Editable?) {
            }
        })

        //아이디 확인
        sginUpId.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // 텍스트가 변경될 때마다 호출된다.
                // 비밀번호를 입력할 때 실시간으로 비밀번호 형식을 검사한다.
                if (idPatternCheck(sginUpId.text.toString())) {
                    sginUpIdCheck.setImageResource(R.drawable.icon_check_mark) //유효성 검사 완료되면 체크표시
                }else{
                    sginUpIdCheck.setImageResource(R.drawable.x_icon)
                }
            }
            override fun afterTextChanged(p0: Editable?) {
            }
        })

        //비밀번호 확인
        sginUpPw.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // 텍스트가 변경될 때마다 호출된다.
                // 비밀번호를 입력할 때 실시간으로 비밀번호 형식을 검사한다.
                if (pwPatternCheck(sginUpPw.text.toString())) {
                    sginUpPwCheck.setImageResource(R.drawable.icon_check_mark)
                }else{
                    sginUpPwCheck.setImageResource(R.drawable.x_icon)
                }
            }
            override fun afterTextChanged(p0: Editable?) {
            }
        })


        //회원가입 버튼
        sginUpBt.setOnClickListener {
            if(sginUpName.text.isBlank() || sginUpId.text.isBlank() || sginUpPw.text.isBlank()){
                Toast.makeText(this,"입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
            }else{
                //아이디 중복확인 후 결과가 참일 경우 회원정보를 리스트에 저장
                if (idCheck(sginUpId.text.toString())){
//                    Database.signUpName.add(sginUpName.text.toString())
//                    Database.signUpId.add(sginUpId.text.toString())
//                    Database.signUpPw.add(sginUpPw.text.toString())
//                    Log.d("저장한 정보 리스트","이름 : ${Database.signUpName}  아이디 : ${Database.signUpId}  비밀번호 : ${Database.signUpPw}")
//                    Log.d("입력한 정보 리스트","이름 : ${sginUpName.text}  아이디 : ${sginUpId.text}  비밀번호 : ${sginUpPw.text}")
                    Toast.makeText(this,"회원가입이 완료되었습니다", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, LoginActivity::class.java).apply {
                        putExtra("SingIn_ID", sginUpId.text.toString())
                        putExtra("SingIn_PW", sginUpPw.text.toString())
                    }
                    setResult(Activity.RESULT_OK, intent)
                    slideLeft()

                    //액티비티 강제 종료
                    if(!isFinishing) {
                        finish()
                    }
                }else{
                    Toast.makeText(this,"중복된 아이디 입니다", Toast.LENGTH_SHORT).show()
                }
            }
        }


        //뒤로가기 버튼
        sginUpBackBt.setOnClickListener {
            finish()
            slideUp()
        }
    }

    //아이디 유효성 검사
    fun idPatternCheck(id:String):Boolean{
        val idPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$" // 이메일
        return (Pattern.matches(idPattern,id))
    }

    //비밀번호 유효성 검사
    fun pwPatternCheck(pw:String):Boolean{
        val pwPattern = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&.])[A-Za-z[0-9]$@$!%*#?&.]{8,20}$" // 영문, 숫자, 특수문자, 8~20자 이내
//        if(Pattern.matches(pwPattern,pw)){
//            //                    Log.d("저장한 정보 리스트","이름 : ${Database.signUpName}  아이디 : ${Database.signUpId}  비밀번호 : ${Database.signUpPw}")
//            Log.d("확인","비밀번호 유효성 검사 완료")
//        }else{
//            Log.d("확인","비밀번호 유효성 검사 실패")
//        }
        //compile(String regex) : 주어진 정규표현식으로부터 패턴을 만듭니다.
        //pattern() : 컴파일된 정규표현식을 String 형태로 반환.
        //matches(CharSequence input) : 대상 문자열이 패턴과 일치할 경우 true를 반환.
        return (Pattern.matches(pwPattern,pw))
    }


    //중복 아이디 확인
    fun idCheck(id:String):Boolean{
        var boolean = true
        val dummy = UserData.dummydata()
        for (i in UserData.dummydata().indices){
            Log.d("ID확인","입력한 아이디${id} 비교하는 아이디:${dummy[i].id}")
            if(id == dummy[i].id.toString()){
                boolean = false
                break
            }
        }
        return boolean
    }
}