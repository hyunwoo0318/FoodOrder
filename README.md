# FoodOrder
toy project using spring

현재 우리나라에서 제일 많이 이용되는 어플중 하나인 배달음식어플을 만들어보려고함.


기능
1. 등록된 음식점에서 메뉴를 골라 장바구니에 넣어 저장
2. 장바구니에 있는 음식을 주문 -> 결제
3. 주문이 완료되면 음식점 주인이 배달완료를 누름(배달은 바로 된다고 가정)
4. 배달완료가 되면 고객은 평점과 사진리뷰를 남길수있음(필수X)
5. 음식점들을 여러 카테고리로 정렬해서 보여줄수있음.


////////***************************************************************************////
20220912 전체적인 구상 간이로 완료함

추가로 해야할일
1. Repository(음식점, 회원)를 지금은 memory로 임시로 만듬 -> DB에 직접 연결해야함
2. 주문과 회원가입시 validation 조건 걸기.
3. 회원을 고객과 점주로 구별 -> 점주에게 직접 음식점의 정보를 DB로 입력받기.
4. 지금은 로그인 상태가 아니여도 로그인 상태에서만 접근해야하는 페이지에 접근 가능함 -> filter나 interceptor를 이용해서 이를 막기
5. 리뷰에 평점, 여러 문장으로 쓸수있게 변경
