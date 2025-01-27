
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
        .container {
            width: 700px;
            margin: 0 auto;
            overflow: auto;
            background-color: beige;
        }

        .container>h1 { /* container의 자식 h1 */
            text-align: center;
            margin: 100px 0 50px;
        }

        #frm li { /* from의 후손 li */
            float: left;  
            line-height: 40px;
            border-bottom: 1px solid gray;
        }

        /* 홀수번째 li : 20%, 짝수번째 li : 80% */
        #frm li:nth-child(2n) { 
            width: 80%;
        }
        #frm li:nth-child(2n+1) {
            width: 20%;
        }

        #tel2, #tel3, #zipcode {
            width: 50px;
        }

        #frm li:last-of-type {
            width: 100%;
            text-align: right;
        }
        input {line-height: 20px;}
        
        #addr { width: 80%; }
    </style>
    
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    
    <script>
  		// 사용법 참고 - https://postcode.map.daum.net/guide
    	//우편번호찾기
    	function daumPostCodeSearch(){
  			
    		new daum.Postcode({  //★★★다음 오픈소스에서 가져온 코드★★★
                oncomplete: function(data) {
                	console.log(data);
                    // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                    // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                    // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                    var addr = ''; // 주소 변수
                    var extraAddr = ''; // 참고항목 변수

                    //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                    if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                        addr = data.roadAddress;
                    } else { // 사용자가 지번 주소를 선택했을 경우(J)
                        addr = data.jibunAddress;
                    }

                    // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                    if(data.userSelectedType === 'R'){
                        // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                        // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                        if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                            extraAddr += data.bname;
                        }
                        // 건물명이 있고, 공동주택일 경우 추가한다.
                        if(data.buildingName !== '' && data.apartment === 'Y'){
                            extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                        }
                        // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                        if(extraAddr !== ''){
                            extraAddr = ' (' + extraAddr + ')';
                        }
                        // 조합된 참고항목을 해당 필드에 넣는다.
                        //document.getElementById("sample6_extraAddress").value = extraAddr;
                    
                    } else {
                        //document.getElementById("sample6_extraAddress").value = '';
                    }

                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    document.getElementById("zipcode").value = data.zonecode;
                    document.getElementById("addr").value = addr;
                    // 커서를 상세주소 필드로 이동한다.
                    document.getElementById("addrDetail").focus();
                }
            }).open();
  		}
    	
    </script>

<div class="container">
        <h1>회원가입 폼</h1>

        <form method="post" action="/myapp/member/formOk" id="frm">
            <ul>
                <li>아이디</li>
                <li>
                    <input type="text" name="userid" id="userid">
                    <input type="button" value="아이디중복확인">
                </li>
                <li>비밀번호</li>
                <li>
                    <input type="password" name="userpwd" id="userpwd">
                </li>
                <li>비밀번호 확인</li>
                <li>
                    <input type="password" name="userpwd2" id="userpwd2">
                </li>
                <li>이름</li>
                <li>
                    <input type="text" name="username" id="username">
                </li>
                <li>연락처</li>
                <li>
                    <select name="tel1">
                        <option>010</option>
                        <option>02</option>
                        <option>031</option>
                        <option>032</option>
                        <option>041</option>
                        <option>051</option>
                    </select>
                    -
                    <input type="text" name="tel2" id="tel2">
                    -
                    <input type="text" name="tel3" id="tel3">
                </li>
                <li>이메일</li>
                <li>
                    <input type="email" name="email" id="email">
                </li>
                <li>우편번호</li>
                <li>
                    <input type="text" name="zipcode" id="zipcode">
                    <input type="button" value="우편번호찾기" onclick="daumPostCodeSearch()">
                </li>
                <li>주소</li>
                <li>
                    <input type="text" name="addr" id="addr">
                </li>
                <li>상세주소</li>
                <li>
                    <input type="text" name="addrDetail" id="addrDetail">
                </li>
                <li>취미</li>
                <li>
                    <input type="checkbox" name="hobby" value="야구"> 야구
                    <input type="checkbox" name="hobby" value="축구"> 축구
                    <input type="checkbox" name="hobby" value="수영"> 수영
                    <input type="checkbox" name="hobby" value="런닝"> 런닝
                    <input type="checkbox" name="hobby" value="쇼핑"> 쇼핑
                    <input type="checkbox" name="hobby" value="독서"> 독서
                    <input type="checkbox" name="hobby" value="영화"> 영화
                </li>
                <li>
                    <input type="submit" value="회원가입하기">
                    <!-- <button>회원가입하기</button> : 위와 같은 기능 -->
                     <input type="reset" value="다시작성하기">
                </li>
            </ul>
        </form>
    </div>



