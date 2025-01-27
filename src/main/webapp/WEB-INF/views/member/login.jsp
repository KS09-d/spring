<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <style>
        .container {
            /* background-color: aquamarine; 만들때 영역에 색을 칠해놓으면 편하다. 마무리하고 삭제. */
            width: 500px;
            margin: 100px auto; /* 100(12시방향) auto(3시방향) 100(6시방향) auto(9시방향) - 이렇게 적용됨. */
            overflow: auto; /* 아래 float 정렬을 했을 때 div가 줄어들면 정보가 영역밖으로 나가기 때문에 정보만큼 자동 영역 생성하는 방법 */
        }
        #title {
            text-align: center;
        }
        .in-box, .log-btn {
            padding: 20px;
            margin: 10px 0px;
        }
        .in-box { /* 아이디,비밀번호 창 */
            width: 456px;
            padding: 20px;
        }
        .log-btn { /* 로그인 버튼 */
            width: 100%;
            padding: 20px;
            background-color: blue;
            color: #fff;
            font-size: 1.2em;
        }
        .left, .right { /* 정렬하게 되면 div의 영역이 줄어든다. */
            float: left;
            width: 50%;
            margin: 30px 0;
        }
        .right {
            text-align: right;
        }
        a:link, a:visited, a:hover {
            color: #000;
            text-decoration: none;
        }
    </style>
    
    <script>
    	function formCheck(){  //유효성 검사
    		//아이디 정보의 유무 체크
    		if(document.getElementByID("userid").value==""){
    			alert("아이디를 입력 후 로그인하세요.");
    			return false;
    		}
    		if(document.getElementById("userpwd").value==""){
    			alert("비밀번호를 입력 후 로그인하세요.");
    			return false;
    		}
    		return true;
    	}
    </script>
    
    <div class="container">
        <h1 id="title">로그인 폼</h1>

        <form method="post" action="<%= request.getContextPath()%>/member/loginOk" onsubmit="return formCheck()"/>
            <!-- '#':임시주소 -->
            <input type="text" id="userid" name="userid" class="in-box" value="goguma" placeholder="아이디(5~15자의 영문, 숫자만 가능)" minlength="5" maxlength="15"/> <br>
            <input type="password" id="userpwd" name="userpwd" class="in-box" value="12345678" placeholder="비밀번호(입력 실패 5회 시 잠금처리)" minlength="5" maxlength="15"/> <br>
            <input type="submit" value="로그인" class="log-btn"/>
        </form>

        <div class="left">
            <input type="button" value="회원가입" onclick="Location.href='<%= request.getContextPath()%>/member/form'"/>  <!-- button이기 때문에 이벤트로 연결 -->
        </div>

        <div class="right">
            <a href="#">아이디찾기 / 비밀번호찾기</a>
        </div>
    </div>
