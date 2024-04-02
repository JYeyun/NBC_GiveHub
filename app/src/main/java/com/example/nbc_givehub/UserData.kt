package com.example.nbc_givehub
data class UserData(
    var id: String = "",
    var name: String = "",
    var mbti: String = "",
    var launguage: String = "",
    var git: String = "",
    var blog: String = ""
){
    companion object{
        fun dummydata():ArrayList<UserData> {
            val dummylist = arrayListOf(
                UserData("jgs288", "장규식", "-", "Android / Kotlin","https://github.com/JnagGyuSik", "https://aquaria-kr.tistory.com/"),
                UserData("dkswlsgur123", "안진혁", "ENTP", "Android / Kotlin","https://github.com/AnJinHyuck", "https://noisno.tistory.com/"),
                UserData("jyk0435", "윤영진","INFP", "Android / Kotlin","https://github.com/jinnnyyy", "https://yyj1624.tistory.com/"),
                UserData("neoneoneo123", "정지연", "ENFJ", "Android / Kotlin","https://github.com/neoneoneo123", "https://velog.io/@neoneoneo/posts"),
                UserData("jyy3637", "정예윤", "ENTP", "Android / Kotlin", "https://github.com/JYeyun", "https://ginger-code.tistory.com/")
            )
            return dummylist
        }
    }
}
