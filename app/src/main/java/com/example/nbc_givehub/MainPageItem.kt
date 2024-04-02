package com.example.nbc_givehub

data class MainPageItem(
    val userImage: String,
    val userName: String,
    val postImage: String,
    val postTitle: String,
    val postSummary: String
) {
    companion object {
        fun dummyPostData(id: String): ArrayList<MainPageItem> {
            val dummyPostList = arrayListOf(
                MainPageItem(
                    "give_hub",
                    id,
                    "img_post1",
                    "Fragment LifeCycle",
                    "각 Fragment 인스턴스에는 고유한 수명 주기가 있다. 사용자가 앱을 탐색하거나 앱의 상호작용할 때 프래그먼트는 화면에서 추가 또는 삭제되거나 화면에 들어가고 나오면서 수명 주기의 여러 상태 간에 전환하게 된다.\n" +
                            "수명주기를 관리하기 위해 Fragment는 LifecycleOwner를 구현하여, getLifecycle() 메서드를 통해 액서스를 할 수 있는 Lifecycle 객체를 노출한다.\n" +
                            "가능한 각 Lifecycle 상태는 Lifecycle.State 열거형으로 표시된다\n" +
                            "- INITIALIZED\n" +
                            "- CREATED\n" +
                            "- STARTED\n" +
                            "- RESUMED\n" +
                            "- DESTROYED\n" +
                            "Lifecycle 위에 Fragment를 빌드하면 수명 주기 인식 구성요소로 수명 주기 처리에 사용할 수 있는 기법과 클래스를 사용할 수 있다. LifecycleObserver를 사용하는 것의 대안으로, Fragment 클래스에는 프래그먼트 수명 주기의 각 변경에 대응하는 콜백 메서드가 포함되어 있다.\n" +
                            "onCreate(), onStart(), onResume(), onPause(), onStop(), onDestroy()가 포함되어 있다."
                ),
                MainPageItem(
                    "give_hub",
                    "작성자2",
                    "img_post2",
                    "배열과 컬렉션 편",
                    "코틀린에서 배열을 다루기 위한 다양한 유형들이 있다.\n" +
                            " 크게 가변형 (배열의 값을 바꿀 수 있음)과 불변형(가변형 반대)가 있다.\n" +
                            "하지만 불변형이라고 아예 리스트를 건드릴 수 없는 것은 아니다.\n" +
                            "특정 조건을 만족하는 새 콜렉션을 반환하는 함수를 통해 변형된 콜렉션을 얻을 수 있다.\n" +
                            "1. sorted() : 오름차순 정렬내가 헷갈린 것은 sort와 sorted의 차이다\n" +
                            "차이점\n" +
                            "1. sort는 불변 컬렉션에서 단독으로 사용 불가\n" +
                            "2. sort는 값을 정렬을 할 뿐 값을 출력하지 않음\n" +
                            "바로 위의 코드의 출력 값\n" +
                            "kotlin.Unit은 sort를 한 출력값. 정렬만 할 뿐 값을 출력하지 않음 println(b)를 통해 다시 b의 값을 출력하자 정렬된 리스트 출력\n" +
                            "3. sorted는 바로 오름차순한 값을 출력"
                ),
                MainPageItem(
                    "give_hub",
                    id,
                    "img_post3",
                    "Activity LifeCycle을 알아보자",
                    "onCreate() 메서드에서는 액티비티의 일회성 초기화를 실행해야 하는데, onCreate() 메서드는 액티비티가 초기화된 직후(OS에서 메모리에 새로운 액티비티 객체를 만들 때) 한 번 호출이 된다.onCreate()가 실행되면 활동이 생성되었다고 간주된다.또한, onCreate() 메서드를 재정의할 때, 상위클래스 구현을 호출하여 활동 생성을 완료해야하는데, 이를 위해 액티비티 안에서 super.onCreate()를 즉시 호출해야한다. 이 사항은 다른 수명 주기 콜백 메서드의 경우에도 마찬가지로 적용이 필요하다.\n" +
                            "onStart() 메서드는 onCreate() 직후에 호출된다.onStart()가 실행되면 액티비티가 화면에 표시되며, onCreate()와 달리 시스템에서 활동의 수명 주기 동안 여러 번 호출할 수 있다.onStart()는 onStop() 메서드와 상응하여 페어링된다. 사용자가 앱을 시작한 후 기기 홈 화면으로 돌아오면 액티비티가 중지되고, 더 이상 화면에 표시되지 않게 된다.\n" +
                            "onPause()가 호출되면 더이상 앱에 포커스를 맞추고 있지 않게 되고, onStop() 이후에는 앱이 화면에 표시되지 않게된다.\n" +
                            "onRestart(), onStart()로 시작한 후 onResume()으로 앱이 재개된다.\n" +
                            "참고로 onRestart()는 액티비티가 이미 만들어진 상태에서 onStop()이 호출될 때 Created 상태로 전환된다. 이때 Destroyed로 진입하지 않고 Started로 되돌아 가는 경우에만 시스템에서 호출한다. 즉, onRestart()는\n" +
                            " 액티비티가 처음으로 시작되지 않은 경우에만(앱을 백그라운드에서 포그라운드로 다시 시작하는 경우에만) 호출하려는 코드를 배치하는 위치이다."
                ),
                MainPageItem(
                    "give_hub",
                    "작성자4",
                    "img_post4",
                    "안드로이드 스튜디오 padding, margin 뽀개기",
                    "android:padding=\"\" → 안쪽 전체 여백\n" +
                            "android:paddingBottom=\"\" → 안쪽 아래 여백\n" +
                            "android:paddingLeft=\"\" → 안쪽 왼쪽 여백\n" +
                            "android:paddingTop=\"\" → 안쪽 위 여백\n" +
                            "android:paddingEnd=\"\" → 안쪽 끝 방향 여백(오른쪽)\n" +
                            "android:paddingRight=\"\" → 안쪽 오른쪽 여백\n" +
                            "android:paddingStart=\"\" → 안쪽 시작 방향 여백(왼쪽)\n" +
                            "android:paddingVertical=\"\" → 안쪽 세로 여백\n" +
                            "android:paddingHorizontall=\"\" → 안쪽 가로 여백\n" +
                            "margin\n" +
                            "android:layout_margin=\"\" → 바깥쪽 전체 여백android:layout_marginBottom =\"\" → 바깥쪽 아래 여백android:layout_marginTop =\"\" → 바깥쪽 윗 여백\n" +
                            "android:layout_marginLeft =\"\" → 바깥쪽 왼쪽 여백android:layout_marginRight =\"\" → 바깥쪽 오른쪽 여백android:layout_marginStart =\"\" → 바깥쪽 시작 방향 여백(왼쪽)\n" +
                            "android:layout_marginEnd =\"\" → 바깥쪽 끝 방향 여백(오른쪽)\n" +
                            "android:layout_marginVertical =\"\" → 바깥쪽 세로 여백\n" +
                            "android:layout_margin Horizontall =\"\" → 바깥쪽 가로 여백"
                ),
                MainPageItem(
                    "give_hub",
                    "작성자5",
                    "img_post5",
                    "Activity Stack가 뭘까?",
                    "Activity Stack 관리 : AndroidManifest의 LaunchMode의 옵션으로 관리\n" +
                            "android:launchMode=\"standard\"\n" +
                            "새 인스턴스를 생성하고 여러 번 스턴스화될 수 있다.각 인스턴스는 서로 다른 Task에 들어있으며 Task에는 여러 인스턴스가 있을 수 있다.\n" +
                            "Activityandroid:launchMode=\"singleTop\"\n" +
                            "인스턴스가 이미 현재 Task의 맨 위에 있다면 시스템은 Activity의 새 인스턴스를 생성하는 대신, 새로운 인텐트를 보내어 Activity가 처리되도록 한다.\n" +
                            "Activityandroid:launchMode=\"singletask\"\n" +
                            "활동의 인스턴스가 이미 작업에 있다면 시스템은 새 인스턴스를 생성하지 않고 기존 인스턴스로 라우팅 한다.활동의 인스턴스가 한 번에 하나만 존재 할 수 있다. 위의 다른 액티비티를 쌓을 수 있다.\n" +
                            " android:launchMode=\"singleInstance\"\n" +
                            "singletask와 동일하지만 위의 다른 액티비티를 쌓을 수 없다.\n" +
                            "활동은 항상 자체 작업의 단 하나의 유일한 멤버이다."
                )
            )
            return dummyPostList
        }
    }
}
