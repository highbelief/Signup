document.getElementById('joinForm').addEventListener('submit', function(event) {
    event.preventDefault(); // 폼 제출 기본 동작 막기

    const username = document.getElementById('username').value;
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const confirmPassword = document.getElementById('confirmPassword').value;

    // 비밀번호와 비밀번호 확인이 일치하는지 확인
    if (password !== confirmPassword) {
        document.getElementById('passwordCheckResult').textContent = '비밀번호가 일치하지 않습니다.';
        document.getElementById('passwordCheckResult').style.color = 'red';
        return;
    } else {
        document.getElementById('passwordCheckResult').textContent = '비밀번호가 일치합니다.';
        document.getElementById('passwordCheckResult').style.color = 'green';
    }

    // 회원가입 데이터 객체 생성
    const userData = {
        username: username,
        name: name,
        email: email,
        password: password
    };

    // Fetch API를 사용하여 POST 방식으로 데이터 전송 (올바른 서버 URL로 변경)
    fetch('http://localhost:8080/users/create', {  // localhost:8080으로 요청
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(userData) // userData 객체를 JSON 문자열로 변환
    })
        .then(response => {
            if (response.ok) {
                return response.text(); // 성공 시 응답 메시지 받기
            } else {
                throw new Error('회원가입에 실패했습니다.');
            }
        })
        .then(data => {
            alert(data); // 성공 메시지 출력
            window.location.href = 'index.html'; // 메인 화면으로 리다이렉트
        })
        .catch(error => {
            alert(error.message); // 에러 메시지 출력
        });
});

// 중복 확인 기능 수정
document.getElementById('checkDuplicate').addEventListener('click', function() {
    const username = document.getElementById('username').value;
    const result = document.getElementById('duplicateCheckResult');

    if (!username) {
        result.textContent = '아이디를 입력하세요.';
        result.style.color = 'red';
        return;
    }

    // URL이 정확히 설정되었는지 확인
    fetch(`http://localhost:8080/users/check-duplicate?username=${username}`)  // 서버 주소 확인
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('중복 확인에 실패했습니다.');
            }
        })
        .then(data => {
            if (data) {
                result.textContent = '이미 존재하는 아이디입니다.';
                result.style.color = 'red';
            } else {
                result.textContent = '사용 가능한 아이디입니다.';
                result.style.color = 'green';
            }
        })
        .catch(error => {
            result.textContent = error.message;
            result.style.color = 'red';
        });
});
