# JUnit-docs-for-TDD
###JUnit document를 번역해보자. 중요내용들 정리해봄.

## 1. OverView

1.1 JUnit5란 무엇인가
JUnit5 = JUnit Platform + JUnit Jupiter + JUnit Vintage

JUnit Platform : JVM에서 돌아가는 테스트 프레임워크이다. 테스트 엔진 API 으로도 정의되며 더욱이 Gradle과 Maven, JUnit4의 빌드 플러그인을 만들 수 있고 커맨드 라인에서 돌아가는 콘솔 런쳐를 제공한다.

JUnit Jupiter : JUnit5에서의 테스트 작성을 위한 새로운 프로그래밍 모델, 확장모델 이다.

JUnit Vintage : JUnit3 와 JUnit4를 가능하게 해주는 테스트 엔진이다.

1.2 지원하는 Java 버젼
JUnit5 는 런타임때 Java8버전(혹은 그 이상)이 필요하다. 하지만 이전 버전 JDK에서 컴파일된 코드들은 테스트 가능하다.

## 2. Installation

2.1 Dependency Metadata (의존성 데이터)
2.1.1 JUnit Platform
- Group ID : org.junit.platform
- Version : 1.3.2
- Artifact IDs : 

2.1.2 JUnit Jupiter

2.1.3 JUnit Vintage

3.1 Annotation
모든 코어 어노테이션은 junit-jupiter-api 모듈안에 org.junit.jupiter.api 패키지에 있다.

목록 : (나중에 정리할 것)

3.1.1. 메타 어노테이션과 구성 어노테이션 
JUnit은 메타 어노테이션을 허용하는데 사용자 어노테이션을 만들 때 자동으로 메타 어노테이션을 상속해서 만들어 진다.

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.Tag;
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Tag("fast")
public @interface Fast {
}
```

3.3. Display Names

@Display 어노테이션으로 테스트 수행시 나오는 이름을 지정할 수 있다.

3.4 Assertions

JUnit Jupiter는 JUnit4의 assertion들과 Java 8 람다식과 함께 몇 가지가 더 추가 되었다. 모든 JUnit Jupiter는 static메소드이며 람다를 지원한다. 위치는 org.junit.jupiter.api.Assertions 에 있다.

3.4.1 Third-party Assertion Libraries
JUnit팀은 matcher같은 추가적인 함수기능을 지원하기 위해 AssertJ, Hamcrest, Truth같은 써드 파티 라이브러리를 지원한다.

3.5 Assumption
JUnit은 JUnit4에서 지원하는 가정 메소드와 추가로 몇개를 더 지원한다.

```java
@Test
void testOnlyOnDeveloperWorkstation() {
    assumeTrue("DEV".equals(System.getenv("ENV")),
    () -> "Aborting test: not on developer workstation");
}
```

3.6 Disabling Test
전체 테스트 클래스나 단위 테스트 메소드나 @Disabled로 지나칠 수 있다.

3.11 생성자와 메소드의 의존성 주입
이전 JUnit에서는 생성자와 메소드에 파라미터를 가질 수 없었다. 하지만 JUnit Jupiter의 메인 변화중 하나는 생성자와 메소드에 파라미터를 가질수 있는 것이다. 이것은 의존성주입을 허락하여 많은 유연성을 가지게 한다.

* TestInfo
```java
@DisplayName("TestInfo Demo")
public class TestInfoDemo {
    TestInfoDemo(TestInfo testInfo) {
        assertEquals("TestInfo Demo", testInfo.getDisplayName());
    }

    @Test
    @Tag("my-tag")
    @DisplayName("Test1")
    void test1(TestInfo testInfo) {
        assertEquals("Test1", testInfo.getDisplayName());
        assertTrue(testInfo.getTags().contains("my-tag"));
    }
}
```

* TestReport
메소드 파라미터가 testreport이면 현재 테스트중인 테스트에 추가적인 데이터를 보여줄 수 있다. JUnit4에서의 stdout, stderr와 상응한다.
(돌려보면 시간과 로그가 나온다)

```java
public class TestReporterDemo {

    @Test
    void reportSingleValue(TestReporter testReporter) {
        testReporter.publishEntry("a status message");
    }

    @Test
    void reportKeyValuePark(TestReporter testReporter) {
        testReporter.publishEntry("a key", "a value");
    }
}
```

3.13. 테스트의 반복
RepeatedTest로 테스트를 반복을 할 수 있다.

```java
public class RepeatedTestsDemo {

    @RepeatedTest(5)
    void repeatTest(RepetitionInfo repetitionInfo) {
        assertEquals(5, repetitionInfo.getTotalRepetitions());
    }
}
``` 


 