<div align="center">
  <img src="https://user-images.githubusercontent.com/118269278/202439585-dc46e5a8-66e2-47d7-99e2-932447be5803.png" width="80" height="80" />
  <h1>RxJava 공부하기</h1>
  <strong>- 반응형 프로그래밍: 주변 환경과 끊임없이 상호 작용을 하는 프로그래밍, 데이터가 변하면 알아서 캐치해준다.<br><br></strong>
  
  <h2>명령형 프로그래밍이란?</h2>
  - 작성된 코드가 정해진 순서대로 실행되는 방식의 프로그래밍<br><br>
  
  <h2>반응형 프로그래밍</h2>
  - 시간 순으로 들어오는 모든 데이터의 흐름을 <strong>스트림</strong>으로 처리하며
    하나의 데이터 흐름은 다른 데이터 흐름으로 변형되기도 한다.<br><br>
    
  <h2>Observable</h2>
  - Observable을 구독하는 Observer가 존재하고, Observable이 순차적으로 발행하는 데이터에 대해서 반응한다.<br>
  - onNext(): 하나의 소스 Observable에서 Observer까지 한 번에 하나씩 순차적으로 데이터를 발행한다.<br>
  - onComplete(): 데이터 발행이 끝났음을 알리는 완료 이벤트를 Observer에 전달하여 onNext()를 더 호출하지 않음을 나타낸다.<br>
  
</div>
