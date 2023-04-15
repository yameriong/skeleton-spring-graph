# Skeleton - SpringBoot - GraphQl
Java 17
Spring Boot 3.0.5
Gradle
Dependencies
* Spring for GraphQL
* Spring for JPA
* Spring Web
* H2 Database
* Lombok
* DGS Framework (ToDo)

### GraphQl ?

* 그래프QL의 이름에는 질의(Query)를 뜻하는 Query의 Q가 있지만 질의 행위에만 국한된 단어이며, 그래프QL은 데이터를 읽기뿐만 아니라 수정도 가능하다.
그래프QL은 데이터를 읽을때는 query 를 사용하고 수정은 mutation 을 사용한다.

* 클라이언트-서버 구조에서 그래프QL은 효율성이 좋다. 클라이언트는 종종 서버에게 여러 리소스를 요청해야한다.(Underfetching)
그래프QL은 이러한 다중 요청의 복잡성을 해결해준다.
그리고 필요한 데이터만을 응답받아 사용이 가능하다.(Overfetching)

* 하나의 요청, 하나의 응답
REST API 도 하나의 엔드포인트(endpoint)를 통해 동일한 처리를 하게 만들 수도 있지만 일반적인 방법은 아니다.
그래프QL은 하나의 엔드포인트로 다양한 서비스와 데이터 교환이 가능하다.

### GraphQL이 RestAPI보다 좋은 이유? 
1. 데이터 요청의 유연성: GraphQL을 사용하면 클라이언트가 필요한 데이터만 정확하게 요청할 수 있습니다. 이는 네트워크 효율성과 성능을 향상시키며, 불필요한 데이터 전송을 줄여줍니다.

2. 타입 시스템: GraphQL은 강력한 타입 시스템을 가지고 있어, 데이터의 구조와 타입을 명확하게 정의할 수 있습니다. 이로 인해 개발자들은 문서화, 유효성 검사, 자동완성 등의 기능을 활용할 수 있습니다.

3. 단일 엔드포인트: GraphQL에서는 하나의 엔드포인트를 통해 모든 요청을 처리합니다. 이는 복잡한 엔드포인트 구조를 줄이고, API 개발 및 유지 보수를 간소화합니다.

4. 실시간 업데이트 지원: GraphQL은 구독(subscription) 기능을 통해 실시간 업데이트를 지원합니다. 이를 통해 클라이언트는 서버의 데이터 변경을 실시간으로 수신할 수 있습니다.

5. 진화하는 API: GraphQL은 필드 및 타입 추가와 같은 API의 변경 사항을 쉽게 처리할 수 있어, API 버전 관리가 덜 필요합니다. 이는 기존 서비스를 중단하지 않고 API를 진화시킬 수 있는 장점을 제공합니다.


### GraphQL에도 단점, 모든 프로젝트에 적합하지는 않은 이유 상황에 따라 REST API가 더 적합한 경우는?

1. 캐싱: GraphQL은 캐싱이 기본적으로 없다. 이로 인해 클라이언트 측에서 별도의 캐싱 전략을 구현.

2. 복잡성: GraphQL은 쿼리와 스키마 정의에 대한 추가적인 공부가 필요함. 간단한 API를 구현하는 경우, REST API가 더 간단하고 빠르게 구축할 수 있는 옵션이 될 수 있다.

3. 파일 업로드: GraphQL에서는 별도의 스펙이 없어 추가적인 구현이 필요합니다.

4. 성능 이슈: GraphQL에서는 클라이언트가 복잡한 쿼리를 만들 수 있어, 서버에 부하를 줄 수 있습니다. 이러한 경우, 쿼리의 복잡성을 제한하거나 최적화할 필요가 있습니다.
> * 그래프QL도 N+1 이슈가 발생을 한다.(내부 필드 데이터를 얻기 위해, N개의 query 를 요청하는걸 의미한다) 
> * 페이스북에서 데이터로더(DataLoader)라는 툴을 제시했다. 데이터로더는 일괄처리(Batch)와 캐시를 조합해서 문제를 처리

5. 개발 생태계: REST API는 오랫동안 널리 사용되어 왔기 때문에, 풍부한 라이브러리와 도구가 존재합니다. GraphQL은 상대적으로 최근에 나온 기술이라, 개발 도구 및 라이브러리가 아직 충분하지 않을 수 있습니다.

상황과 요구 사항에 따라, GraphQL과 REST API 중 어느 것이 더 적합한지 판단해야 합니다. 간단한 프로젝트에서는 REST API가 더 적합할 수 있으며, 복잡한 데이터 구조와 실시간 업데이트가 필요한 프로젝트에서는 GraphQL이 더 적합할 수 있습니다.