# 결과

## repository, template 명령어 차이
![캡쳐1](/images/캡쳐1.png)   

repository 로 실행할 때 명령어가 template 로 실행할 때 보다 더 많다.   
repository 를 사용하면 데이터가 저장될 때 CrudRepository 기능들을 위한 Set 데이터가 같이 저장되기 때문   

## Set 데이터   
![캡쳐2](/images/캡쳐2.png)   
repository 로 데이터 저장할 때 같이 저장되는 Set 데이터는 TTL 이 -1 이다.   
데이터의 TTL 과 상관없이 -1 이니 삭제 로직을 따로 설정해야 한다.   
