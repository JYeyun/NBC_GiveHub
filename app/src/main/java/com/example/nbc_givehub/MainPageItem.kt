package com.example.nbc_givehub


data class MainPageItem(
    val userImage: Int,
    val userName: String,
    val postImage: Int,
    val postTitle: String,
    val postSummary: String,
    var like: Int,
    var isLike: Boolean,
) {
    companion object {
        val dummyPostList = arrayListOf(
            MainPageItem(
                R.drawable.img1,
                "윤영진",
                R.drawable.img_post1,
                "Fragment LifeCycle",
                "<h3 style=\"font-style:italic;\">각 Fragment 인스턴스에는 고유한 수명 주기가 있다.</h3>\n" +
                        "\n" +
                        "<p>사용자가 앱을 탐색하거나 앱의 상호작용할 때 프래그먼트는 화면에서 추가 또는 삭제되거나 화면에 들어가고 나오면서 <strong>수명 주기의 여러 상태 간에 전환</strong>하게 된다.</p>\n" +
                        "\n" +
                        "<p>수명주기를 관리하기 위해 Fragment는 <strong>LifecycleOwner</strong>를 구현하여, <strong>getLifecycle()</strong> 메서드를 통해 액서스를 할 수 있는 Lifecycle 객체를 노출한다.</p>\n" +
                        "\n" +
                        "<p>가능한 각 Lifecycle 상태는 Lifecycle.State 열거형으로 표시된다.</p>\n" +
                        "\n" +
                        "<ul>\n" +
                        "\t<li> INITIALIZED</li>\n" +
                        "\t<li> CREATED</li>\n" +
                        "\t<li> STARTED</li>\n" +
                        "\t<li> RESUMED</li>\n" +
                        "\t<li> DESTROYED</li>\n" +
                        "</ul>\n" +
                        "\n" +
                        "<p>Lifecycle 위에 Fragment를 빌드하면 수명 주기 인식 구성요소로 수명 주기 처리에 사용할 수 있는 기법과 클래스를 사용할 수 있다.</p>\n" +
                        "\n" +
                        "<p>LifecycleObserver를 사용하는 것의 대안으로, Fragment 클래스에는 프래그먼트 수명 주기의 각 변경에 대응하는 콜백 메서드가 포함되어 있다.</p>\n" +
                        "\n" +
                        "<ul>\n" +
                        "\t<li>수명 주기 : onCreate(), onStart(), onResume(), onPause(), onStop(), onDestroy()</li>\n" +
                        "</ul>\n",
                18,
                true
            ),
            MainPageItem(
                R.drawable.img5,
                "정지연",
                R.drawable.img_post2,
                "sort와 sorted편",
                "<h2><em>코틀린에는 배열을 다룰 수 있는 다양한 유형이 있다.</em></h2>\n" +
                        "\n" +
                        "<p>크게 가변형 (배열의 값을 바꿀 수 있음)과 불변형(가변형 반대)가 있다.</p>\n" +
                        "\n" +
                        "<p>하지만 불변형이라고 아예 리스트를 건드릴 수 없는 것은 아니다.</p>\n" +
                        "\n" +
                        "<p>특정 조건을 만족하는 새 콜렉션을 반환하는 함수를 통해 변형된 콜렉션을 얻을 수 있다.</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<p>이 배열을 정렬할 수 있는데, 헷갈릴 수 있는 것은&nbsp;sort와 sorted이다.</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h2>차이점</h2>\n" +
                        "\n" +
                        "<ol>\n" +
                        "\t<li>&nbsp;sort는 불변 컬렉션에서 단독으로 사용 불가</li>\n" +
                        "\t<li>&nbsp;sort는 값을 정렬을 할 뿐 값을 출력하지 않음</li>\n" +
                        "\t<li>&nbsp;sorted는 바로 오름차순한 값을 출력</li>\n" +
                        "</ol>\n",
                77,
                false
            ),
            MainPageItem(
                R.drawable.img1,
                "장규식",
                R.drawable.img_post3,
                "Activity LifeCycle을 알아보자",
                "<h2><em>액티비티의 수명 주기</em></h2>\n" +
                        "\n" +
                        "<p>onCreate() 메서드에서는 액티비티의 일회성 초기화를 실행해야 하는데, onCreate() 메서드는 액티비티가 초기화된 직후(OS에서 메모리에 새로운 액티비티 객체를 만들 때) 한 번 호출이 된다.</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>onCreate()</h4>\n" +
                        "\n" +
                        "<p>onCreate()가 실행되면 활동이 생성되었다고 간주된다.</p>\n" +
                        "\n" +
                        "<p>onCreate() 메서드를 재정의할 때, 상위클래스 구현을 호출하여 활동 생성을 완료해야하는데, 이를 위해 액티비티 안에서 super.onCreate()를 즉시 호출해야한다.</p>\n" +
                        "\n" +
                        "<p>이 사항은 다른 수명 주기 콜백 메서드의 경우에도 마찬가지로 적용이 필요하다.</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>onStart()</h4>\n" +
                        "\n" +
                        "<p>onStart() 메서드는 onCreate() 직후에 호출된다.</p>\n" +
                        "\n" +
                        "<p>onStart()가 실행되면 액티비티가 화면에 표시되며, onCreate()와 달리 시스템에서 활동의 수명 주기 동안 여러 번 호출할 수 있다.</p>\n" +
                        "\n" +
                        "<p>onStart()는 onStop() 메서드와 상응하여 페어링된다.</p>\n" +
                        "\n" +
                        "<p>사용자가 앱을 시작한 후 기기 홈 화면으로 돌아오면 액티비티가 중지되고, 더 이상 화면에 표시되지 않게 된다.</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>onPause()</h4>\n" +
                        "\n" +
                        "<p>onPause()가 호출되면 더이상 앱에 포커스를 맞추고 있지 않게 된다.</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>onStop()</h4>\n" +
                        "\n" +
                        "<p>onStop() 이후에는 앱이 화면에 표시되지 않게된다.</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>onStop()</h4>\n" +
                        "\n" +
                        "<p>onStop() 이후에는 앱이 화면에 표시되지 않게된다.</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>onRestart()</h4>\n" +
                        "\n" +
                        "<p>onRestart()는 액티비티가 이미 만들어진 상태에서 onStop()이 호출될 때 Created 상태로 전환된다.</p>\n" +
                        "\n" +
                        "<p>이때 Destroyed로 진입하지 않고 Started로 되돌아 가는 경우에만 시스템에서 호출한다.</p>\n" +
                        "\n" +
                        "<p>즉, onRestart()는 액티비티가 처음으로 시작되지 않은 경우에만(앱을 백그라운드에서 포그라운드로 다시 시작하는 경우에만) 호출하려는 코드를 배치하는 위치이다.</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<p>onRestart(), onStart()로 시작한 후 onResume()으로 앱이 재개된다.</p>\n",
                24,
                false
            ),
            MainPageItem(
                R.drawable.img4,
                "안진혁",
                R.drawable.img_post4,
                "안드로이드 스튜디오 padding, margin 뽀개기",
                "<h2>Padding</h2>\n" +
                        "\n" +
                        "<ul>\n" +
                        "\t<li>&nbsp;android:padding=&quot;&quot; &rarr; 안쪽 전체 여백</li>\n" +
                        "\t<li>&nbsp;android:paddingBottom=&quot;&quot; &rarr; 안쪽 아래 여백</li>\n" +
                        "\t<li>&nbsp;android:paddingLeft=&quot;&quot; &rarr; 안쪽 왼쪽 여백</li>\n" +
                        "\t<li>&nbsp;android:paddingTop=&quot;&quot; &rarr; 안쪽 위 여백</li>\n" +
                        "\t<li>&nbsp;android:paddingEnd=&quot;&quot; &rarr; 안쪽 끝 방향 여백(오른쪽)</li>\n" +
                        "\t<li>&nbsp;android:paddingRight=&quot;&quot; &rarr; 안쪽 오른쪽 여백</li>\n" +
                        "\t<li>&nbsp;android:paddingStart=&quot;&quot; &rarr; 안쪽 시작 방향 여백(왼쪽)</li>\n" +
                        "\t<li>&nbsp;android:paddingVertical=&quot;&quot; &rarr; 안쪽 세로 여백</li>\n" +
                        "\t<li>&nbsp;android:paddingHorizontall=&quot;&quot; &rarr; 안쪽 가로 여백</li>\n" +
                        "</ul>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h2>Margin</h2>\n" +
                        "\n" +
                        "<ul>\n" +
                        "\t<li>&nbsp;android:layout_margin=&quot;&quot; &rarr; 바깥쪽 전체 여백</li>\n" +
                        "\t<li>&nbsp;android:layout_marginBottom =&quot;&quot; &rarr; 바깥쪽 아래 여백</li>\n" +
                        "\t<li>&nbsp;android:layout_marginTop =&quot;&quot; &rarr; 바깥쪽 윗 여백</li>\n" +
                        "\t<li>&nbsp;android:layout_marginLeft =&quot;&quot; &rarr; 바깥쪽 왼쪽 여백</li>\n" +
                        "\t<li>&nbsp;android:layout_marginRight =&quot;&quot; &rarr; 바깥쪽 오른쪽 여백</li>\n" +
                        "\t<li>&nbsp;android:layout_marginStart =&quot;&quot; &rarr; 바깥쪽 시작 방향 여백(왼쪽)</li>\n" +
                        "\t<li>&nbsp;android:layout_marginEnd =&quot;&quot; &rarr; 바깥쪽 끝 방향 여백(오른쪽)</li>\n" +
                        "\t<li>&nbsp;android:layout_marginVertical =&quot;&quot; &rarr; 바깥쪽 세로 여백</li>\n" +
                        "\t<li>&nbsp;android:layout_marginHorizontal =&quot;&quot; &rarr; 바깥쪽 가로 여백</li>\n" +
                        "</ul>\n",
                30,
                false
            ),
            MainPageItem(
                R.drawable.img2,
                "정예윤",
                R.drawable.img_post5,
                "Activity Stack이 뭘까?",
                "<h2>Activity Stack 관리</h2>\n" +
                        "\n" +
                        "<blockquote>\n" +
                        "<p>AndroidManifest의 LaunchMode의 옵션으로 관리</p>\n" +
                        "</blockquote>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>android:launchMode=&quot;standard&quot;</h4>\n" +
                        "\n" +
                        "<p>새 인스턴스를 생성하고 여러 번 인</p>\n" +
                        "\n" +
                        "<p>스턴스화될 수 있다.각 인스턴스는 서로 다른 Task에 들어있으며 Task에는 여러 인스턴스가 있을 수 있다.</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>Activityandroid:launchMode=&quot;singleTop&quot;</h4>\n" +
                        "\n" +
                        "<p>인스턴스가 이미 현재 Task의 맨 위에 있다면 시스템은 Activity의 새 인스턴스를 생성하는 대신, 새로운 인텐트를 보내어 Activity가 처리되도록 한다.</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>Activityandroid:launchMode=&quot;singletask&quot;</h4>\n" +
                        "\n" +
                        "<p>활동의 인스턴스가 이미 작업에 있다면 시스템은 새 인스턴스를 생성하지 않고 기존 인스턴스로 라우팅 한다.</p>\n" +
                        "\n" +
                        "<p>활동의 인스턴스가 한 번에 하나만 존재 할 수 있다.</p>\n" +
                        "\n" +
                        "<p>위의 다른 액티비티를 쌓을 수 있다.</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>android:launchMode=&quot;singleInstance&quot;</h4>\n" +
                        "\n" +
                        "<p>singletask와 동일하지만 위의 다른 액티비티를 쌓을 수 없다.</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<p><br />\n" +
                        "<em>액티비티는&nbsp;항상 자체 작업의 단 하나의 유일한 멤버이다.</em></p>\n",
                101,
                false
            ),
            MainPageItem(
                R.drawable.img4,
                "안진혁",
                R.drawable.img_post6,
                "코틀린 확장함수",
                "<h2><em>코틀린의 확장함수</em></h2>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<p>KotIin은 클래스에서 상속하거나 Decorator 와 같은 디자인 패턴으 사용하지 않고도 새로운 기능으로 클래스나 인터페이스를 확장할 수 있는 기능을 제공합니다 .</p>\n" +
                        "\n" +
                        "<p>이는 확장 이라는 특수 선언을 통해 수행됩니다.</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<p>예를 들어</p>\n" +
                        "\n" +
                        "<p>수정할 수 없는 타사 라이브러리의 클래스 또는 인터페이스에 대한 새 함수를 작성할 수 있습니다.</p>\n" +
                        "\n" +
                        "<p>이러한 함수는 마지 원래 클래스의 메서드인 것져럼 일반적인 방법으로 호출할 수 있니다.</p>\n" +
                        "\n" +
                        "<p>이 메커니즘을 <strong>확장 기능</strong> 이라고 합니다.</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<p>기존 클래스에 대한 새 속성을 정의할 수 있는 확장 속성도 있습니다.</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<p>확장 기능을 선언하려면 확장 중인 유형을 나타내는 수신기 유형으로 이름 앞에 접두사를 붙입니다.</p>\n" +
                        "\n" +
                        "<p>확장자는 실제로 확장하는 클래스를 수정하지 않습니다.</p>\n" +
                        "\n" +
                        "<p>확장자를 정의하면 클래스에 새 멤버를 삽입하는 것이 아니라 이 유형의 변수에 점 표기를 사용하여 새 함수를 호출할 수 있도록 하는 것입니다.</p>\n",
                31,
                false
            ),
            MainPageItem(
                R.drawable.img1,
                "장규식",
                R.drawable.img_post7,
                "상속 복습",
                "<h2><em>상속의 쓰임새</em></h2>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<p>공통적인 요소들이 있다면 부모/자식 클래스를 구분해서 상속관계를 만들 수 있다.</p>\n" +
                        "\n" +
                        "<p>코틀린은 다른 언어들과 달리 무분별한 상속으로 예상치 못한 흐름을 방지하기 위해 생략된 final키워드로 상속을 막아두었다.</p>\n" +
                        "\n" +
                        "<p>open 키워드를 사용하여 상속 관계를 만들 수 있다.</p>\n" +
                        "\n" +
                        "<h4><br />\n" +
                        "상속이 필요한 이유 :</h4>\n" +
                        "\n" +
                        "<p>다형성클래스의 내용을 변경해야하는 경우 부모 클래스만 변경하는것만으로 공수를 줄일 수 있다.</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>오버라이딩</h4>\n" +
                        "\n" +
                        "<p>상속받은 부모 클래스의 정보(프로퍼티)나 행위(메소드)를 수정하여 쓸 수 있다.</p>\n" +
                        "\n" +
                        "<p>주로 부모 클래스의 행위(메소드)를 재설계(수정)</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>오버라이딩이 필요한 이유 :</h4>\n" +
                        "\n" +
                        "<p>공통적인 내용을 부모 클래스에서 관리하는건 좋지만, 자식 클래스에서도 부모 클래스의 일부를 수정하여 사용한다.</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>오버로딩</h4>\n" +
                        "\n" +
                        "<p>매개변수의 갯수를 다르게하면 동일한 이름으로 메소드를 만들 수 있다.</p>\n" +
                        "\n" +
                        "<p>매개변수의 자료형을 다르게하면 동일한 이름으로 메소드를 만들 수 있다.</p>\n" +
                        "\n" +
                        "<p>반환자료형(반환형)은 오버로딩에 영향을 주지 않는다.</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>오버로딩이 필요한 이유 :</h4>\n" +
                        "\n" +
                        "<p>addInt, addDouble따로 만들면 나중에 관리가 힘들어진다.</p>\n" +
                        "\n" +
                        "<p>자료형이 정수, 실수로 다르니까 오버로딩으로 해결 가능해진다.</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>인터페이스</h4>\n" +
                        "\n" +
                        "<p>메소드의 로직이 존재하지않고 이름만 존재할때 추상메소드 라고 한다.</p>\n" +
                        "\n" +
                        "<p>원래 인터페이스는 추상메소드만 허용하지만 최근에는 추상메소드가 아니어도 된다.</p>\n",
                5,
                false
            ),
            MainPageItem(
                R.drawable.img5,
                "정지연",
                R.drawable.img_post8,
                "Kotlin 문법(1)",
                "<h4>1. kotlin 특징</h4>\n" +
                        "\n" +
                        "<ul>\n" +
                        "\t<li>실용성</li>\n" +
                        "\t<li>간결성</li>\n" +
                        "\t<li>안정성</li>\n" +
                        "\t<li>상호운용성</li>\n" +
                        "</ul>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>2. kotlin 함수 형태</h4>\n" +
                        "\n" +
                        "<ul>\n" +
                        "\t<li>기본적인 형태는fun 함수명 (a : 변수타입) : 리턴타입 {}함수의 내용이 간단하다면 한줄로 줄여 쓸 수 있다.</li>\n" +
                        "</ul>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>3. 변수</h4>\n" +
                        "\n" +
                        "<ul>\n" +
                        "\t<li>val = value (값) - 재할당 X</li>\n" +
                        "\t<li>var = variable (변경 가능한) 변수타입이 없어도 코틀린은 타입 추론이 가능하기 때문에 에러가 나지 않음</li>\n" +
                        "</ul>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>4. 클래스 (Class)</h4>\n" +
                        "\n" +
                        "<ul>\n" +
                        "\t<li>클래스 선언 보조 생성자 init - 초기화 작업을 하기 위해 사용</li>\n" +
                        "</ul>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>5. 컬렉션(list, map, set)</h4>\n" +
                        "\n" +
                        "<ul>\n" +
                        "\t<li>mutableListOf(변경 가능) / listOf(변경 불가)</li>\n" +
                        "\t<li>joinToString(separator)</li>\n" +
                        "\t<li>mapOf / mutableMapOf</li>\n" +
                        "</ul>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>6. NULL</h4>\n" +
                        "\n" +
                        "<ul>\n" +
                        "\t<li>타입 뒤에 ? 를 붙이면 널(NULL) 가능</li>\n" +
                        "\t<li>Null 확인 코드&nbsp;val result = nickname?: &quot;null&quot;(null이면 오른쪽 출력)</li>\n" +
                        "\t<li dir=\"rtl\">val result = nickname?. length(null이 아니면 값 출력)-&nbsp;</li>\n" +
                        "\t<li dir=\"rtl\">val result = nickname!!.length(null 일 수 없는 경우)-&nbsp;</li>\n" +
                        "</ul>\n",
                14,
                false
            ),
            MainPageItem(
                R.drawable.img4,
                "안진혁",
                R.drawable.img_post6,
                "코틀린 확장함수",
                "<h2><em>코틀린의 확장함수</em></h2>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<p>KotIin은 클래스에서 상속하거나 Decorator 와 같은 디자인 패턴으 사용하지 않고도 새로운 기능으로 클래스나 인터페이스를 확장할 수 있는 기능을 제공합니다 .</p>\n" +
                        "\n" +
                        "<p>이는 확장 이라는 특수 선언을 통해 수행됩니다.</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<p>예를 들어</p>\n" +
                        "\n" +
                        "<p>수정할 수 없는 타사 라이브러리의 클래스 또는 인터페이스에 대한 새 함수를 작성할 수 있습니다.</p>\n" +
                        "\n" +
                        "<p>이러한 함수는 마지 원래 클래스의 메서드인 것져럼 일반적인 방법으로 호출할 수 있니다.</p>\n" +
                        "\n" +
                        "<p>이 메커니즘을 <strong>확장 기능</strong> 이라고 합니다.</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<p>기존 클래스에 대한 새 속성을 정의할 수 있는 확장 속성도 있습니다.</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<p>확장 기능을 선언하려면 확장 중인 유형을 나타내는 수신기 유형으로 이름 앞에 접두사를 붙입니다.</p>\n" +
                        "\n" +
                        "<p>확장자는 실제로 확장하는 클래스를 수정하지 않습니다.</p>\n" +
                        "\n" +
                        "<p>확장자를 정의하면 클래스에 새 멤버를 삽입하는 것이 아니라 이 유형의 변수에 점 표기를 사용하여 새 함수를 호출할 수 있도록 하는 것입니다.</p>\n",
                7,
                false
            ),
            MainPageItem(
                R.drawable.img1,
                "장규식",
                R.drawable.img_post7,
                "상속",
                "<h2><em>상속의 쓰임새</em></h2>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<p>공통적인 요소들이 있다면 부모/자식 클래스를 구분해서 상속관계를 만들 수 있다.</p>\n" +
                        "\n" +
                        "<p>코틀린은 다른 언어들과 달리 무분별한 상속으로 예상치 못한 흐름을 방지하기 위해 생략된 final키워드로 상속을 막아두었다.</p>\n" +
                        "\n" +
                        "<p>open 키워드를 사용하여 상속 관계를 만들 수 있다.</p>\n" +
                        "\n" +
                        "<h4><br />\n" +
                        "상속이 필요한 이유 :</h4>\n" +
                        "\n" +
                        "<p>다형성클래스의 내용을 변경해야하는 경우 부모 클래스만 변경하는것만으로 공수를 줄일 수 있다.</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>오버라이딩</h4>\n" +
                        "\n" +
                        "<p>상속받은 부모 클래스의 정보(프로퍼티)나 행위(메소드)를 수정하여 쓸 수 있다.</p>\n" +
                        "\n" +
                        "<p>주로 부모 클래스의 행위(메소드)를 재설계(수정)</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>오버라이딩이 필요한 이유 :</h4>\n" +
                        "\n" +
                        "<p>공통적인 내용을 부모 클래스에서 관리하는건 좋지만, 자식 클래스에서도 부모 클래스의 일부를 수정하여 사용한다.</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>오버로딩</h4>\n" +
                        "\n" +
                        "<p>매개변수의 갯수를 다르게하면 동일한 이름으로 메소드를 만들 수 있다.</p>\n" +
                        "\n" +
                        "<p>매개변수의 자료형을 다르게하면 동일한 이름으로 메소드를 만들 수 있다.</p>\n" +
                        "\n" +
                        "<p>반환자료형(반환형)은 오버로딩에 영향을 주지 않는다.</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>오버로딩이 필요한 이유 :</h4>\n" +
                        "\n" +
                        "<p>addInt, addDouble따로 만들면 나중에 관리가 힘들어진다.</p>\n" +
                        "\n" +
                        "<p>자료형이 정수, 실수로 다르니까 오버로딩으로 해결 가능해진다.</p>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>인터페이스</h4>\n" +
                        "\n" +
                        "<p>메소드의 로직이 존재하지않고 이름만 존재할때 추상메소드 라고 한다.</p>\n" +
                        "\n" +
                        "<p>원래 인터페이스는 추상메소드만 허용하지만 최근에는 추상메소드가 아니어도 된다.</p>\n",
                85,
                false
            ),
            MainPageItem(
                R.drawable.img5,
                "정지연",
                R.drawable.img_post8,
                "Kotlin 문법(1)",
                "<h4>1. kotlin 특징</h4>\n" +
                        "\n" +
                        "<ul>\n" +
                        "\t<li>실용성</li>\n" +
                        "\t<li>간결성</li>\n" +
                        "\t<li>안정성</li>\n" +
                        "\t<li>상호운용성</li>\n" +
                        "</ul>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>2. kotlin 함수 형태</h4>\n" +
                        "\n" +
                        "<ul>\n" +
                        "\t<li>기본적인 형태는fun 함수명 (a : 변수타입) : 리턴타입 {}함수의 내용이 간단하다면 한줄로 줄여 쓸 수 있다.</li>\n" +
                        "</ul>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>3. 변수</h4>\n" +
                        "\n" +
                        "<ul>\n" +
                        "\t<li>val = value (값) - 재할당 X</li>\n" +
                        "\t<li>var = variable (변경 가능한) 변수타입이 없어도 코틀린은 타입 추론이 가능하기 때문에 에러가 나지 않음</li>\n" +
                        "</ul>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>4. 클래스 (Class)</h4>\n" +
                        "\n" +
                        "<ul>\n" +
                        "\t<li>클래스 선언 보조 생성자 init - 초기화 작업을 하기 위해 사용</li>\n" +
                        "</ul>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>5. 컬렉션(list, map, set)</h4>\n" +
                        "\n" +
                        "<ul>\n" +
                        "\t<li>mutableListOf(변경 가능) / listOf(변경 불가)</li>\n" +
                        "\t<li>joinToString(separator)</li>\n" +
                        "\t<li>mapOf / mutableMapOf</li>\n" +
                        "</ul>\n" +
                        "\n" +
                        "<p>&nbsp;</p>\n" +
                        "\n" +
                        "<h4>6. NULL</h4>\n" +
                        "\n" +
                        "<ul>\n" +
                        "\t<li>타입 뒤에 ? 를 붙이면 널(NULL) 가능</li>\n" +
                        "\t<li>Null 확인 코드&nbsp;val result = nickname?: &quot;null&quot;(null이면 오른쪽 출력)</li>\n" +
                        "\t<li dir=\"rtl\">val result = nickname?. length(null이 아니면 값 출력)-&nbsp;</li>\n" +
                        "\t<li dir=\"rtl\">val result = nickname!!.length(null 일 수 없는 경우)-&nbsp;</li>\n" +
                        "</ul>\n",
                29,
                false
            )
        )

        fun dummyPostData(): ArrayList<MainPageItem> {
            return dummyPostList
        }
    }
}
