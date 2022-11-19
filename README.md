<div align="center">
  <img src="https://user-images.githubusercontent.com/118269278/202439585-dc46e5a8-66e2-47d7-99e2-932447be5803.png" width="80" height="80" />
  <h1>RxJava 공부하기</h1>
  <strong>- 반응형 프로그래밍: 주변 환경과 끊임없이 상호 작용을 하는 프로그래밍, 데이터가 변하면 알아서 캐치해준다.<br><br></strong>
  
  <h2>명령형 프로그래밍이란?</h2>
  - 작성된 코드가 정해진 순서대로 실행되는 방식의 프로그래밍<br><br>
  
  <h2>반응형 프로그래밍</h2>
  - 시간 순으로 들어오는 모든 데이터의 흐름을 <strong>스트림</strong>으로 처리하며
    하나의 데이터 흐름은 다른 데이터 흐름으로 변형되기도 한다.<br><br>
    
 <h2>리액티브 시스템</h2>
 - 메시지를 보내 데이터를 처리하고 상황에 따라 스케일 아웃과 스케일 인을 자동으로 수행해 장애 내성을 높임으로써 항상 빠르게 응답할 수 잇는 시스템
  
  <br><br>
 
</div>
  
 ## RxJava의 특징
 > RxJava는 디자인 패턴인 옵저버 패턴을 잘 확장했다.
 > 옵저버 패턴은 감시 대상 객체의 상태가 변하면 이를 관찰하는 객체에 알려주는 구조이다.
 > 이 패턴의 특징을 살리면 데이터를 생성하는 측과 데이터를 소비하는 측으로 나눌 수 있기 때문에 쉽게 데이터 스트림을 처리할 수 있다.
 
 ### RxJava의 또 다른 특징
 > 쉬운 비동기 처리를 들 수 있다.
 >> Observable 규약이라는 RxJava 개발 가이드라인을 따른 구현이라면 직접 스레드를 관리하는 번거로움에서 해방될 뿐만 아니라 구현도 간단히 할 수 있다.
 
 ## Reactive Streams란?
> 라이브러리나 프레임워크에 상관없이 데이터 스트림을 비동기로 다룰 수 있는 공통 매커니즘
> 데이터를 만들어 통지하는 Publisher(생산자)와 통지된 데이터를 받아 처리하는 Subscriber(소비자)로 구성된다.

![Sequence-diagram-of-the-publish-subscribe-model](https://user-images.githubusercontent.com/118269278/202840330-a2f2705b-2920-4d12-8ec9-95913a1ea558.png)

<br><br>
## Reactive Streams의 규칙 (참고)
> 어떤 규칙이 있는지 확인하기 -> reactive-streams-jvm/README.md: https://github.com/reactive-streams/reactive-streams-jvm/blob/master/README.md
>> ### 기본 규칙
>> - 구독 시작 통지(onSubscribe)는 해당 구독에서 한 번만 발생한다.
>> - 통지는 순차적으로 이루어진다.
>> - null을 통지하지 않는다.
>> - Publisher 처리는 완료 또는 에러를 통지해 종료한다.

## RxJava의 기본 구조
> 데이터를 만들고 통지하는 생산자와 통지된 데이터를 받아 처리하는 소비자로 구성된다.

|구분|생산자|소비자|
|------|---|---|
|Reactive Streams 지원|Floawable|Subscriber|
|Reactive Streams 미지원|Observable|Observer|

#### !! Observable과 Observable 간에 데이터를 교환할 때 Flowable과 Subscriber처럼 데이터 개수 요청은 하지 않고 데이터가 생성되자마자 Observer에 통지된다.

<br><br>

 <h2>시작하기 전 코드 알아보기</h2>
  
```
Observable<String> source = Observable.create(emitter -> {
      emitter.onNext("Hello");
      emitter.onNext("Yena");
      emitter.onComplete();
});

Observable.create()를 사용하면 Emitter를 이용하여 직접 아이템을 발행하고, 아이템 발행의 완료나 오류
(Complete/Error)의 알림을 직접 설정할 수 있다.

```

