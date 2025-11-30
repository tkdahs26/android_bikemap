# android_bikemap

##### 두번째 개인어플만들기 공공데이터포털api사이트 활용한 공용자전거위치찾기
사용기술 구글api 공공데이터포털api android json


Google Maps SDK를 핵심 기술로 활용하여 서울, 광양 등의 도시별 위치 정보를 지도에 시각화하고, Street View 및 Places API를 연동하여 주변 환경 사진을 제공하는 Android 위치 기반 정보 서비스 애플리케이션을 개발했습니다.

1) 다중 도시 위치 데이터 매핑 
기능: 서울, 광양 등 선택된 도시에 따라 지도에 해당 지역의 자전거 대여소 또는 관심 지점 위치를 마커로 표시.

MarkerOptions을 활용하여 사용자 지정 마커 아이콘을 생성하고 지도에 배치했습니다.

2) Google Places,Photo API 연동
기능: 지도상의 특정 대여소위치 마커 클릭 시, 해당 위치의 주변 환경 사진 목록을 제공.

 Google Places API를 호출하여 장소 정보를 획득하고, Photodata를 기반으로 사진 URL에서 갤러리 형태로 표시 구현했습니다

3) Google Street View 연동
기능: 사용자가 선택한 위치의 실시간 길거리 뷰를 제공하여 주변 환경을 360도로 탐색할 수 있도록 지원.

Street View 화면을 구현하고, 지도에서 얻은 정보를 저장 후, 이를 Street View 카메라 위치로 연동했습니다.

4) 주소 기능 활용
기능: 특정 주소를 변환하거나(Geo-coding), 지도상의 좌표를 주소로 변환하여 사용자에게 제공. (코드를 통해 간접적으로 추정)

성과: Geocoder를 활용하여 정확도를 높이고, 사용자에게 친숙한 주소 정보를 제공하는 로직을 구현했습니다.










<img src="https://user-images.githubusercontent.com/48806275/163067348-bdfea364-7aab-4e94-871f-b28b5a1f927e.png " width="20%" height="200%"/>첫화면:서울 광양 버튼(공공데이터포털사이트참고)


<img src="https://user-images.githubusercontent.com/48806275/129466846-0d1f6742-e6e0-4208-9c1f-e4c14055304c.png " width="20%" height="200%"/><img src="https://user-images.githubusercontent.com/48806275/129467571-e34fc158-a4f3-443c-9e13-258a6c1ee9e1.png " width="20%" height="200%"/>클릭시  자전거대여소의 마커를생성

<img src="https://user-images.githubusercontent.com/48806275/129466847-7f808f50-d6c4-416a-9b37-75100b0a40cb.png " width="20%" height="200%"/><img src="https://user-images.githubusercontent.com/48806275/129466829-1bbaa385-c1fd-4339-8487-32c94bf595ea.png " width="20%" height="200%"/>마커클릭: 자전거 거치대수와 현재거치수 표기

<img src="https://user-images.githubusercontent.com/48806275/129466831-a587b658-5337-4315-805c-e29b661c9520.png " width="20%" height="200%"/><img src="https://user-images.githubusercontent.com/48806275/129466832-d011cee2-db59-4d82-b43f-83564fca0fef.png " width="20%" height="200%"/>거리뷰버튼클릭: streetview api 활용

<img src="https://user-images.githubusercontent.com/48806275/129466833-8e83b37d-831c-4306-a0b7-377c93b9f931.png " width="20%" height="200%"/><img src="https://user-images.githubusercontent.com/48806275/129467408-2a96e15e-45a0-4de9-800c-9903d2b8ae0d.png " width="20%" height="200%"/>검색바 클릭:자동완성 인터페이스 구글 place autocomplete 활용 (지도기능 몇가지 추가)


<img src="https://user-images.githubusercontent.com/48806275/129466835-82fbaaf2-f7af-4705-ae0a-dc79d8a28f72.png " width="20%" height="200%"/>검색: 해당좌표에 마커생성 마커정보는 google map api에서 받음

<img src="https://user-images.githubusercontent.com/48806275/129466836-16406ac9-32d9-4568-8077-6eb147ef6a56.png " width="20%" height="200%"/>검색마커의 거리뷰버튼클릭: streetview google api 에서 받음

<img src="https://user-images.githubusercontent.com/48806275/129466837-b81387e8-b787-44f9-9a78-a0b77e2733e5.png " width="20%" height="200%"/><img src="https://user-images.githubusercontent.com/48806275/129466839-80d07040-478c-474b-8712-39c82fb8b6ff.png " width="20%" height="200%"/>검색마커의 사진버튼클릭: google map api의 사진들을 받아서 출력

<img src="https://user-images.githubusercontent.com/48806275/129466840-805d5230-9fef-48e7-8cb2-786ee5591638.png " width="20%" height="200%"/>전화버튼클릭
<img src="https://user-images.githubusercontent.com/48806275/129466841-ec60cc5b-98f0-4507-8fe7-72ae52124dff.png " width="20%" height="200%"/>홈페이지버튼클릭

<img src="https://user-images.githubusercontent.com/48806275/129466842-0e470690-bb6e-4c17-b311-e0dc62e2ba67.png " width="20%" height="200%"/>맵 아무곳에 클릭: 큰 마커생성 geocoder활용 


<img src="https://user-images.githubusercontent.com/48806275/129466843-c9613df8-61b8-41ca-91fa-67d50961a5e0.png " width="20%" height="200%"/>마커클릭:geocoder로 주소받고 사진은 place api에서받음

<img src="https://user-images.githubusercontent.com/48806275/129466844-d5a41889-3ab1-411c-8584-8dcc46d45afb.png " width="20%" height="200%"/>마커 주변사진버튼클릭: 주변 도시의 사진을 받아옴 place api를 활용

<img src="https://user-images.githubusercontent.com/48806275/162346247-efda4f98-27a2-4921-9ba5-b6b841cb8bf6.png " width="20%" height="200%"/>위 사진 클릭: 사진 게시자의 정보로 넘어감


<img src="https://user-images.githubusercontent.com/48806275/129601438-0491197c-ac61-4ac5-8145-1fef7d8c0ca7.png" width="20%" height="200%"/>해당 마커의 사진 api에 없다는 오류 나올시
 
